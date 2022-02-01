import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;

public class aekx
  implements CompoundButton.OnCheckedChangeListener
{
  public aekx(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBooleanAsync(this.a.getString(2131718174) + this.a.a, paramBoolean);
    if (AppSetting.c) {
      NotifyPushSettingActivity.e(this.a).setContentDescription(anvx.a(2131707116));
    }
    QQAppInterface localQQAppInterface = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (String str = "1";; str = "0")
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekx
 * JD-Core Version:    0.7.0.1
 */