import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;

class ajgd
  implements View.OnClickListener
{
  ajgd(ajgb paramajgb, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper click banner, jump");
    }
    paramView = (QQAppInterface)ajgb.a(this.jdField_a_of_type_Ajgb).getAppRuntime();
    ((UpgradeTIMManager)paramView.getManager(256)).a(ajgb.a(this.jdField_a_of_type_Ajgb), this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper.g);
    azqs.b(paramView, "CliOper", "", "", "0X8008659", "0X8008659", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgd
 * JD-Core Version:    0.7.0.1
 */