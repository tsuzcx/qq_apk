import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForReplyText;

class adyn
  implements DialogInterface.OnClickListener
{
  adyn(adyh paramadyh, MessageForReplyText paramMessageForReplyText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Adyh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bakk)this.jdField_a_of_type_Adyh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Adyh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a) && ((this.jdField_a_of_type_Adyh.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
    {
      paramDialogInterface = (BaseActivity)this.jdField_a_of_type_Adyh.jdField_a_of_type_AndroidContentContext;
      bcpw.a(this.jdField_a_of_type_Adyh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697656, 0).b(paramDialogInterface.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Adyh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyn
 * JD-Core Version:    0.7.0.1
 */