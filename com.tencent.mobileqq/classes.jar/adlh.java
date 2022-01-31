import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adlh
  implements CompoundButton.OnCheckedChangeListener
{
  public adlh(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      bhsc.a();
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label81;
      }
      paramCompoundButton = "0X8004BE7";
      label23:
      if (!paramBoolean) {
        break label87;
      }
    }
    label81:
    label87:
    for (String str = "0X8004BE7";; str = "0X8004BE6")
    {
      azqs.b(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "1", "", "", "");
      if (AppSetting.c) {
        NotifyPushSettingActivity.d(this.a).setContentDescription(alud.a(2131708034));
      }
      return;
      bhsc.b();
      break;
      paramCompoundButton = "0X8004BE6";
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlh
 * JD-Core Version:    0.7.0.1
 */