import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import cooperation.qzone.LocalMultiProcConfig;

public class adgt
  implements CompoundButton.OnCheckedChangeListener
{
  public adgt(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBooleanAsync(this.a.getString(2131719334) + this.a.a, paramBoolean);
    if (AppSetting.c) {
      NotifyPushSettingActivity.e(this.a).setContentDescription(alpo.a(2131708041));
    }
    QQAppInterface localQQAppInterface = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label109;
      }
    }
    label109:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      azmj.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, paramCompoundButton, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgt
 * JD-Core Version:    0.7.0.1
 */