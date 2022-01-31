import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.qphone.base.util.QLog;

public class aipc
  implements DialogInterface.OnClickListener
{
  public aipc(AssociatedAccountOptPopBar paramAssociatedAccountOptPopBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onAccoutChangeFailed -> LoginActivity");
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getPackageName());
    paramDialogInterface.setClass(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("uin", this.a.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("befault_uin", this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramDialogInterface);
    this.a.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipc
 * JD-Core Version:    0.7.0.1
 */