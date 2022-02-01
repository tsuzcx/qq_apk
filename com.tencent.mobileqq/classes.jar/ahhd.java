import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ahhd
  implements bjoe
{
  ahhd(ahgz paramahgz, bjnw parambjnw, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Ahgz.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Ahgz.tag, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_Ahgz.getActivity(), this.jdField_a_of_type_Ahgz.getActivity().getString(2131694064), 0).b(this.jdField_a_of_type_Ahgz.getActivity().getTitleBarHeight());
        return;
      }
    } while ((amtp)this.jdField_a_of_type_Ahgz.app.getBusinessHandler(35) == null);
    paramView = bfur.a(this.jdField_a_of_type_Ahgz.getActivity(), 230).setMessage(2131692942).setNegativeButton(2131690600, new ahhf(this)).setPositiveButton(2131690602, new ahhe(this));
    paramView.setTitle(2131692943);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhd
 * JD-Core Version:    0.7.0.1
 */