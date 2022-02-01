import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class afwo
  implements DialogInterface.OnClickListener
{
  afwo(afwn paramafwn, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkApp)bbli.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    if (paramDialogInterface.msgData == null) {
      if (paramDialogInterface.ark_app_message == null) {
        ArkAppCenter.c("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
          } while (this.jdField_a_of_type_Afwn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
          if ((paramDialogInterface.ark_app_message.containStructMsg == null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.containStructMsg != null)) {
            paramDialogInterface.ark_app_message.containStructMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.containStructMsg;
          }
          paramInt = paramDialogInterface.getProcessState();
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppShareMultiItemBuilder", 2, new Object[] { "AAShare.get multiItem resend msg stat=", Integer.valueOf(paramInt), ", old.uniseq=", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq), ", new uniseq=", Long.valueOf(paramDialogInterface.uniseq) });
          }
          this.jdField_a_of_type_Afwn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_Afwn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Afwn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq);
          if ((paramInt == 1002) || (paramInt == 0)) {
            break;
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
        } while (!(localObject instanceof QQAppInterface));
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ((aoza)localObject).a(paramDialogInterface);
    return;
    this.jdField_a_of_type_Afwn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addAndSendMessage(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwo
 * JD-Core Version:    0.7.0.1
 */