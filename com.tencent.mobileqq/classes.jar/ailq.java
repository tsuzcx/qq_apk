import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ailq
  implements bliz
{
  ailq(ailn paramailn, blir paramblir, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Ailn.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Ailn.jdField_a_of_type_JavaLangString, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!bhnv.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_Ailn.a(), this.jdField_a_of_type_Ailn.a().getString(2131693965), 0).b(this.jdField_a_of_type_Ailn.a().getTitleBarHeight());
        return;
      }
    } while ((anzp)this.jdField_a_of_type_Ailn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35) == null);
    paramView = bhlq.a(this.jdField_a_of_type_Ailn.a(), 230).setMessage(2131692892).setNegativeButton(2131690560, new ails(this)).setPositiveButton(2131690562, new ailr(this));
    paramView.setTitle(2131692893);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailq
 * JD-Core Version:    0.7.0.1
 */