import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import cooperation.qzone.LocalMultiProcConfig;

public class abfo
  implements CompoundButton.OnCheckedChangeListener
{
  public abfo(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBooleanAsync(this.a.getString(2131653020) + this.a.a, paramBoolean);
    if (AppSetting.c) {
      NotifyPushSettingActivity.e(this.a).setContentDescription(ajjy.a(2131641873));
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
      awqx.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, paramCompoundButton, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfo
 * JD-Core Version:    0.7.0.1
 */