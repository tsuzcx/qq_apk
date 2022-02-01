import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class afdb
  implements bliz
{
  public afdb(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getString(2131691989), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X800B323", "0X800B323", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Blir.dismiss();
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131717902, 0L, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Int = 2;
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, true);
      if (PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_c_of_type_Boolean)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unBindContactsMobile");
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.g();
        if (!PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_a_of_type_Boolean) {
          break label229;
        }
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindPhoneNumLoginOnPhoneUnity");
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.d();
      }
      for (;;)
      {
        PhoneUnityBindInfoActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
        break;
        PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.a(false);
        break label165;
        PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b(false);
      }
    case 1: 
      label165:
      label229:
      if (!bhnv.d(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131694008);
        return;
      }
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2);
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity).jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Blir.dismiss();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "dc00898", "", "", "0X800B325", "0X800B325", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Blir.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdb
 * JD-Core Version:    0.7.0.1
 */