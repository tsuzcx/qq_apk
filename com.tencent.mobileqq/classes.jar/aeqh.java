import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class aeqh
  implements bfoq
{
  aeqh(aeqd paramaeqd, bfol parambfol, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfol.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Aeqd.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Aeqd.jdField_a_of_type_JavaLangString, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!bbev.d(BaseApplication.getContext()))
      {
        bcpw.a(this.jdField_a_of_type_Aeqd.a(), this.jdField_a_of_type_Aeqd.a().getString(2131694609), 0).b(this.jdField_a_of_type_Aeqd.a().getTitleBarHeight());
        return;
      }
    } while ((ajyi)this.jdField_a_of_type_Aeqd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35) == null);
    paramView = bbcv.a(this.jdField_a_of_type_Aeqd.a(), 230).setMessage(2131693297).setNegativeButton(2131690573, new aeqj(this)).setPositiveButton(2131690575, new aeqi(this));
    paramView.setTitle(2131693298);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqh
 * JD-Core Version:    0.7.0.1
 */