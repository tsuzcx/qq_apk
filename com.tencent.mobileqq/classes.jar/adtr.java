import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adtr
  implements CompoundButton.OnCheckedChangeListener
{
  public adtr(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      bjmf.a();
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label91;
      }
      str1 = "0X8004BE7";
      label23:
      if (!paramBoolean) {
        break label97;
      }
    }
    label91:
    label97:
    for (String str2 = "0X8004BE7";; str2 = "0X8004BE6")
    {
      bcef.b(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "1", "", "", "");
      if (AppSetting.c) {
        NotifyPushSettingActivity.d(this.a).setContentDescription(amtj.a(2131706748));
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bjmf.b();
      break;
      str1 = "0X8004BE6";
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtr
 * JD-Core Version:    0.7.0.1
 */