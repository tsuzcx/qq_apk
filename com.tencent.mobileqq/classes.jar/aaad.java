import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aaad
  implements CompoundButton.OnCheckedChangeListener
{
  public aaad(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c) {
      this.a.f.setContentDescription(ajjy.a(2131634985));
    }
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      awqx.b(paramCompoundButton, "CliOper", "", "", "Shake_screenshot", "Shake_screenshot_switch", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131629602), "qqsetting_screenshot_key", paramBoolean);
      if (!paramBoolean) {
        break;
      }
      this.a.turnOnShake();
      return;
    }
    this.a.turnOffShake();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaad
 * JD-Core Version:    0.7.0.1
 */