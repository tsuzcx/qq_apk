import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import mqq.app.AppRuntime;

public class aimp
  implements Runnable
{
  public aimp(StructMsgForGeneralShare paramStructMsgForGeneralShare, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.frienduin, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.msgtype, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimp
 * JD-Core Version:    0.7.0.1
 */