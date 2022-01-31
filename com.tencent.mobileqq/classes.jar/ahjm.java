import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import msf.msgcomm.msg_comm.Msg;

public final class ahjm
  implements Runnable
{
  public ahjm(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg) {}
  
  public void run()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a(8)).a(this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahjm
 * JD-Core Version:    0.7.0.1
 */