import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class adng
  implements bhuk
{
  public adng(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, String paramString1, String paramString2, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X8009EC8", "0X8009EC8", 0, 0, "", "", "", "");
      if (!bdin.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getString(2131692398), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
        return;
      }
      paramView = (amci)this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app.a(34);
      if (paramView != null) {
        paramView.a(3, this.jdField_a_of_type_JavaLangString, this.b);
      }
      PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131719785, 1000L, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
      return;
    case 1: 
      if (!bdin.d(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131694831);
        return;
      }
      paramView = new Intent(paramView, BindNumberActivity.class);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("kUnityOther", true);
      paramView.putExtra("kSrouce", this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.startActivityForResult(paramView, 1004);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X8009EC9", "0X8009EC9", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bhuf.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X8009ECA", "0X8009ECA", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhuf.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adng
 * JD-Core Version:    0.7.0.1
 */