import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.widget.QQToast;

class ahfg
  implements DialogInterface.OnClickListener
{
  ahfg(ahfa paramahfa, MessageForReplyText paramMessageForReplyText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Ahfa.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((bgkf)this.jdField_a_of_type_Ahfa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_Ahfa.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true).a) && ((this.jdField_a_of_type_Ahfa.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.jdField_a_of_type_Ahfa.jdField_a_of_type_AndroidContentContext;
      QQToast.a(this.jdField_a_of_type_Ahfa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697134, 0).b(paramDialogInterface.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Ahfa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfg
 * JD-Core Version:    0.7.0.1
 */