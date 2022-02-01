import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeky
  implements CompoundButton.OnCheckedChangeListener
{
  public aeky(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.c) {
      NotifyPushSettingActivity.f(this.a).setContentDescription(anvx.a(2131707108));
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131717979), "qqsetting_receivemsg_whenexit_key", paramBoolean);
    SyncService.a(this.a, paramBoolean);
    QQAppInterface localQQAppInterface = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label117;
      }
    }
    label117:
    for (String str = "1";; str = "0")
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Logout_msg", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeky
 * JD-Core Version:    0.7.0.1
 */