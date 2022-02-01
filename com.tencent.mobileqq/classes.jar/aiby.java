import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class aiby
  implements bkhw
{
  aiby(aibv paramaibv, bkho parambkho, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkho.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Aibv.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Aibv.jdField_a_of_type_JavaLangString, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!bgnt.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_Aibv.a(), this.jdField_a_of_type_Aibv.a().getString(2131693948), 0).b(this.jdField_a_of_type_Aibv.a().getTitleBarHeight());
        return;
      }
    } while ((anno)this.jdField_a_of_type_Aibv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35) == null);
    paramView = bglp.a(this.jdField_a_of_type_Aibv.a(), 230).setMessage(2131692884).setNegativeButton(2131690564, new aica(this)).setPositiveButton(2131690566, new aibz(this));
    paramView.setTitle(2131692885);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiby
 * JD-Core Version:    0.7.0.1
 */