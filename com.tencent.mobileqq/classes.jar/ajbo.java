import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;

class ajbo
  implements View.OnClickListener
{
  ajbo(ajbm paramajbm, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper click banner, jump");
    }
    paramView = (QQAppInterface)ajbm.a(this.jdField_a_of_type_Ajbm).getAppRuntime();
    ((UpgradeTIMManager)paramView.getManager(256)).a(ajbm.a(this.jdField_a_of_type_Ajbm), this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper.g);
    azmj.b(paramView, "CliOper", "", "", "0X8008659", "0X8008659", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbo
 * JD-Core Version:    0.7.0.1
 */