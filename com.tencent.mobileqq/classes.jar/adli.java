import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import cooperation.qzone.LocalMultiProcConfig;

public class adli
  implements CompoundButton.OnCheckedChangeListener
{
  public adli(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBooleanAsync(this.a.getString(2131719346) + this.a.a, paramBoolean);
    if (AppSetting.c) {
      NotifyPushSettingActivity.e(this.a).setContentDescription(alud.a(2131708053));
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
      azqs.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, paramCompoundButton, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adli
 * JD-Core Version:    0.7.0.1
 */