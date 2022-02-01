import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

class agoi
  implements DialogInterface.OnClickListener
{
  agoi(agog paramagog, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ausz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, this.jdField_a_of_type_Agog.jdField_a_of_type_AndroidContentContext)) {}
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
            paramDialogInterface = (MessageForArkApp)bcsa.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
            if (paramDialogInterface.msgData == null)
            {
              if (paramDialogInterface.ark_app_message == null)
              {
                ArkAppCenter.c("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
                return;
              }
              paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
            }
          } while (this.jdField_a_of_type_Agog.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
          paramInt = paramDialogInterface.getProcessState();
          this.jdField_a_of_type_Agog.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_Agog.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_Agog.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq);
          if ((paramInt == 1002) || (paramInt == 0)) {
            break;
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
        } while (!(localObject instanceof QQAppInterface));
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ((aqce)localObject).a(paramDialogInterface);
    return;
    this.jdField_a_of_type_Agog.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addAndSendMessage(paramDialogInterface, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoi
 * JD-Core Version:    0.7.0.1
 */