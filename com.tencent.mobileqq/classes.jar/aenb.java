import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aenb
  implements bkzq
{
  public aenb(PhoneUnityChangeActivity paramPhoneUnityChangeActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.jdField_a_of_type_Bkzi.cancel();
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.a, 230, anvx.a(2131707499), anvx.a(2131707489), anvx.a(2131707477), anvx.a(2131707480), new aenc(this), new aend(this));
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!this.a.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenb
 * JD-Core Version:    0.7.0.1
 */