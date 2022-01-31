import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;

class adcb
  implements DialogInterface.OnClickListener
{
  adcb(adbx paramadbx, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkFlashChat)awbi.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat);
    if (paramDialogInterface.msgData == null) {
      if (paramDialogInterface.ark_app_message == null) {
        ArkAppCenter.c("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
      }
    }
    while (this.jdField_a_of_type_Adbx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      return;
      paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
    }
    this.jdField_a_of_type_Adbx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Adbx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Adbx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.uniseq);
    this.jdField_a_of_type_Adbx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcb
 * JD-Core Version:    0.7.0.1
 */