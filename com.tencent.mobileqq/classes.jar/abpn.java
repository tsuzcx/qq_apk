import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class abpn
  implements CompoundButton.OnCheckedChangeListener
{
  public abpn(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (AppSetting.d) {
      NotifyPushSettingActivity.c(this.a).setContentDescription(ajyc.a(2131718851));
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131718851), "qqsetting_notify_blncontrol_key", paramBoolean);
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.getCurrentAccountUin(), "LED_light", 1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label147;
      }
      label89:
      if (!paramBoolean) {
        break label152;
      }
    }
    label147:
    label152:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      axqw.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, paramCompoundButton, "", "", "");
      return;
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.getCurrentAccountUin(), "LED_light", 0);
      break;
      i = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpn
 * JD-Core Version:    0.7.0.1
 */