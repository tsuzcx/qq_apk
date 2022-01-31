import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adgu
  implements CompoundButton.OnCheckedChangeListener
{
  public adgu(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c) {
      NotifyPushSettingActivity.f(this.a).setContentDescription(alpo.a(2131708033));
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131719109), "qqsetting_receivemsg_whenexit_key", paramBoolean);
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
      azmj.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Logout_msg", 0, i, paramCompoundButton, "", "", "");
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgu
 * JD-Core Version:    0.7.0.1
 */