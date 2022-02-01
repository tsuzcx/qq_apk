import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.widget.QQToast;

class agmq
  implements DialogInterface.OnClickListener
{
  agmq(agmk paramagmk, MessageForReplyText paramMessageForReplyText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Agmk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((bfbz)this.jdField_a_of_type_Agmk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Agmk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true).a) && ((this.jdField_a_of_type_Agmk.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.jdField_a_of_type_Agmk.jdField_a_of_type_AndroidContentContext;
      QQToast.a(this.jdField_a_of_type_Agmk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131696866, 0).b(paramDialogInterface.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Agmk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().sendMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmq
 * JD-Core Version:    0.7.0.1
 */