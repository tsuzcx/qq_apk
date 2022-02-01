import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class aibw
  implements bkzq
{
  aibw(aibs paramaibs, bkzi parambkzi, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Aibs.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_Aibs.tag, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_Aibs.getActivity(), this.jdField_a_of_type_Aibs.getActivity().getString(2131694255), 0).b(this.jdField_a_of_type_Aibs.getActivity().getTitleBarHeight());
        return;
      }
    } while ((anwd)this.jdField_a_of_type_Aibs.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER) == null);
    paramView = bhdj.a(this.jdField_a_of_type_Aibs.getActivity(), 230).setMessage(2131693078).setNegativeButton(2131690677, new aiby(this)).setPositiveButton(2131690679, new aibx(this));
    paramView.setTitle(2131693079);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibw
 * JD-Core Version:    0.7.0.1
 */