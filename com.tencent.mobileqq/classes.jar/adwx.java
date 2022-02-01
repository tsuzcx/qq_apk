import android.view.View;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adwx
  implements bliz
{
  public adwx(AuthDevActivity paramAuthDevActivity, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity) != null) && (AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.isFinishing()))
      {
        AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).dismiss();
        AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).cancel();
        AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, null);
      }
      return;
      if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getString(2131691989), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.begin to delAuthDev");
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
        if (asvf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long)) {
          AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.delAuthDev fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwx
 * JD-Core Version:    0.7.0.1
 */