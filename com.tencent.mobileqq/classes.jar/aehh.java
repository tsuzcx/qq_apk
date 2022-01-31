import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;

public class aehh
  extends MessageObserver
{
  public aehh(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg) {}
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false);
      return;
    }
    MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, false, "send Msg fail : errCode = " + paramStatictisInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehh
 * JD-Core Version:    0.7.0.1
 */