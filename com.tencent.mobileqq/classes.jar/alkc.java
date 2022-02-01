import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alkc
  implements View.OnClickListener
{
  alkc(aljw paramaljw, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper close banner");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)aljw.a(this.jdField_a_of_type_Aljw).getAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.a();
    UpgradeTIMWrapper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper);
    aljw.a(this.jdField_a_of_type_Aljw).obtainMessage(20).sendToTarget();
    bdll.b(localQQAppInterface, "CliOper", "", "", "0X800865A", "0X800865A", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkc
 * JD-Core Version:    0.7.0.1
 */