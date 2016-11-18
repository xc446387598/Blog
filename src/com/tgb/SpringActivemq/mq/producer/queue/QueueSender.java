package com.tgb.SpringActivemq.mq.producer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description  ������Ϣ�����ߣ�������Ϣ������
 * 
 */
@Component("queueSender")
public class QueueSender {
	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jsmTemplate;//ͨ��Qualifier���η���ע���Ӧ��bean

	/**
	 * ����һ����Ϣ��ָ���Ķ��У�Ŀ�꣩
	 * @param queueName ��������
	 * @param message ��Ϣ����
	 */
	public void send(String queueName,final String message){
		jsmTemplate.send(queueName,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(message);
			}
		});
	}
	

}
