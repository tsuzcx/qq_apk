import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afay
  implements CompoundButton.OnCheckedChangeListener
{
  public afay(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (AppSetting.c) {
      NotifyPushSettingActivity.c(this.a).setContentDescription(anzj.a(2131717558));
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131717558), "qqsetting_notify_blncontrol_key", paramBoolean);
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.getCurrentAccountUin(), "LED_light", 1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label157;
      }
      label89:
      if (!paramBoolean) {
        break label162;
      }
    }
    label157:
    label162:
    for (String str = "1";; str = "0")
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.getCurrentAccountUin(), "LED_light", 0);
      break;
      i = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afay
 * JD-Core Version:    0.7.0.1
 */