import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class aeqf
  implements bfph
{
  aeqf(aeqb paramaeqb, bfpc parambfpc, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfpc.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Aeqb.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Aeqb.jdField_a_of_type_JavaLangString, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!bbfj.d(BaseApplication.getContext()))
      {
        bcql.a(this.jdField_a_of_type_Aeqb.a(), this.jdField_a_of_type_Aeqb.a().getString(2131694610), 0).b(this.jdField_a_of_type_Aeqb.a().getTitleBarHeight());
        return;
      }
    } while ((ajyg)this.jdField_a_of_type_Aeqb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35) == null);
    paramView = bbdj.a(this.jdField_a_of_type_Aeqb.a(), 230).setMessage(2131693298).setNegativeButton(2131690573, new aeqh(this)).setPositiveButton(2131690575, new aeqg(this));
    paramView.setTitle(2131693299);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqf
 * JD-Core Version:    0.7.0.1
 */