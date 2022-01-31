import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajbp
  implements View.OnClickListener
{
  ajbp(ajbm paramajbm, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper close banner");
    }
    paramView = (QQAppInterface)ajbm.a(this.jdField_a_of_type_Ajbm).getAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper.a();
    UpgradeTIMWrapper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper);
    ajbm.a(this.jdField_a_of_type_Ajbm).obtainMessage(20).sendToTarget();
    azmj.b(paramView, "CliOper", "", "", "0X800865A", "0X800865A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbp
 * JD-Core Version:    0.7.0.1
 */