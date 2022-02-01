import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class afbc
  implements CompoundButton.OnCheckedChangeListener
{
  public afbc(NotifyPushSettingActivity paramNotifyPushSettingActivity, anum paramanum) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c) {
      NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).setContentDescription("PC离线时自动启动QQ手机版");
    }
    QQAppInterface localQQAppInterface;
    int i;
    if (!NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity))
    {
      if (paramBoolean) {
        bdll.b(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 1, "", "", "", "");
      }
    }
    else
    {
      if ((!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) || (!NotifyPushSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity))) {
        break label193;
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app;
      if (!paramBoolean) {
        break label181;
      }
      i = 1;
      label94:
      if (!paramBoolean) {
        break label186;
      }
    }
    label181:
    label186:
    for (Object localObject = "1";; localObject = "0")
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "PC_active", 0, i, (String)localObject, "", "", "");
      if (!NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)) {
        this.jdField_a_of_type_Anum.b(paramBoolean);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bdll.b(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 0, "", "", "", "");
      break;
      i = 0;
      break label94;
    }
    label193:
    NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
    localObject = NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
    if (!NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a()) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getApplication().getString(2131694197), 0).b(5);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbc
 * JD-Core Version:    0.7.0.1
 */