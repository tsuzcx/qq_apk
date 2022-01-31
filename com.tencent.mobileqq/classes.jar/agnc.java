import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class agnc
  implements bhqd
{
  agnc(agmy paramagmy, bhpy parambhpy, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Agmy.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Agmy.jdField_a_of_type_JavaLangString, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!bdee.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_Agmy.a(), this.jdField_a_of_type_Agmy.a().getString(2131694766), 0).b(this.jdField_a_of_type_Agmy.a().getTitleBarHeight());
        return;
      }
    } while ((alpu)this.jdField_a_of_type_Agmy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35) == null);
    paramView = bdcd.a(this.jdField_a_of_type_Agmy.a(), 230).setMessage(2131693399).setNegativeButton(2131690624, new agne(this)).setPositiveButton(2131690626, new agnd(this));
    paramView.setTitle(2131693400);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnc
 * JD-Core Version:    0.7.0.1
 */