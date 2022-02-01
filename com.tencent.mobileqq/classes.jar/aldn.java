import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aldn
  implements View.OnClickListener
{
  aldn(aldh paramaldh, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper close banner");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)aldh.a(this.jdField_a_of_type_Aldh).getAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.a();
    UpgradeTIMWrapper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper);
    aldh.a(this.jdField_a_of_type_Aldh).obtainMessage(20).sendToTarget();
    bdla.b(localQQAppInterface, "CliOper", "", "", "0X800865A", "0X800865A", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldn
 * JD-Core Version:    0.7.0.1
 */