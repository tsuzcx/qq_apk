import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.service.message.MessageCache;

public class aehi
  extends MessageObserver
{
  public aehi(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(6003, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq + "" });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      return;
    }
    MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true, "sendStructLongMsg fail : errCode = " + paramStatictisInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehi
 * JD-Core Version:    0.7.0.1
 */