import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class ahxm
  implements Runnable
{
  public ahxm(MessagePBElemDecoder paramMessagePBElemDecoder, msg_comm.Msg paramMsg) {}
  
  public void run()
  {
    ((PublicAccountHandler)MessagePBElemDecoder.a(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessagePBElemDecoder).b.a(11)).a(String.valueOf(this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg.msg_head.from_uin.get()), 0L, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahxm
 * JD-Core Version:    0.7.0.1
 */