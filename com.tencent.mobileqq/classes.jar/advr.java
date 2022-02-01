import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advr
  implements CompoundButton.OnCheckedChangeListener
{
  public advr(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c) {
      this.a.g.setContentDescription(anzj.a(2131699693));
    }
    QQAppInterface localQQAppInterface = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      bdll.b(localQQAppInterface, "CliOper", "", "", "Shake_screenshot", "Shake_screenshot_switch", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131694432), "qqsetting_screenshot_key", paramBoolean);
      if (!paramBoolean) {
        break label106;
      }
      this.a.turnOnShake();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label106:
      this.a.turnOffShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advr
 * JD-Core Version:    0.7.0.1
 */