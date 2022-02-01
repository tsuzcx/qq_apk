import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alkb
  implements View.OnClickListener
{
  alkb(aljw paramaljw, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper click banner, jump");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)aljw.a(this.jdField_a_of_type_Aljw).getAppRuntime();
    ((UpgradeTIMManager)localQQAppInterface.getManager(256)).a(aljw.a(this.jdField_a_of_type_Aljw), this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.g);
    bdll.b(localQQAppInterface, "CliOper", "", "", "0X8008659", "0X8008659", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkb
 * JD-Core Version:    0.7.0.1
 */