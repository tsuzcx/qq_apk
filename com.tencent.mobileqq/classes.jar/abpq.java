import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class abpq
  implements CompoundButton.OnCheckedChangeListener
{
  public abpq(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d) {
      NotifyPushSettingActivity.f(this.a).setContentDescription(ajyc.a(2131707650));
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131718625), "qqsetting_receivemsg_whenexit_key", paramBoolean);
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
      axqw.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Logout_msg", 0, i, paramCompoundButton, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpq
 * JD-Core Version:    0.7.0.1
 */