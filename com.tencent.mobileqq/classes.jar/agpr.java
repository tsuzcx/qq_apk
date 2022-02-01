import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;

class agpr
  implements DialogInterface.OnClickListener
{
  agpr(agpn paramagpn, MessageForArkFlashChat paramMessageForArkFlashChat) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkFlashChat)bcsa.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat);
    if (paramDialogInterface.msgData == null) {
      if (paramDialogInterface.ark_app_message == null) {
        ArkAppCenter.c("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
      }
    }
    while (this.jdField_a_of_type_Agpn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      return;
      paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
    }
    this.jdField_a_of_type_Agpn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_Agpn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Agpn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat.uniseq);
    this.jdField_a_of_type_Agpn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addAndSendMessage(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpr
 * JD-Core Version:    0.7.0.1
 */