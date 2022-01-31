import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abrj
  implements bfph
{
  public abrj(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, String paramString1, String paramString2, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X8009EC8", "0X8009EC8", 0, 0, "", "", "", "");
      if (!bbfj.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
      {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getString(2131692321), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
        return;
      }
      paramView = (akgd)this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app.a(34);
      if (paramView != null) {
        paramView.a(3, this.jdField_a_of_type_JavaLangString, this.b);
      }
      PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131719292, 1000L, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
      return;
    case 1: 
      if (!bbfj.d(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131694673);
        return;
      }
      paramView = new Intent(paramView, BindNumberActivity.class);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("kUnityOther", true);
      paramView.putExtra("kSrouce", this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.startActivityForResult(paramView, 1004);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X8009EC9", "0X8009EC9", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Bfpc.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X8009ECA", "0X8009ECA", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfpc.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abrj
 * JD-Core Version:    0.7.0.1
 */