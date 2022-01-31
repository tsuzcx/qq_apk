import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahki
  implements View.OnClickListener
{
  ahki(ahkf paramahkf, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper close banner");
    }
    paramView = (QQAppInterface)ahkf.a(this.jdField_a_of_type_Ahkf).getAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper.a();
    UpgradeTIMWrapper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper);
    ahkf.a(this.jdField_a_of_type_Ahkf).obtainMessage(20).sendToTarget();
    axqw.b(paramView, "CliOper", "", "", "0X800865A", "0X800865A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */