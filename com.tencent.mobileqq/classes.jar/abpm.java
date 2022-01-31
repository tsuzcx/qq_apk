import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class abpm
  implements CompoundButton.OnCheckedChangeListener
{
  public abpm(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d) {
      NotifyPushSettingActivity.f(this.a).setContentDescription(ajya.a(2131707661));
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131718636), "qqsetting_receivemsg_whenexit_key", paramBoolean);
    SyncService.a(this.a, paramBoolean);
    QQAppInterface localQQAppInterface = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      axqy.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Logout_msg", 0, i, paramCompoundButton, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpm
 * JD-Core Version:    0.7.0.1
 */