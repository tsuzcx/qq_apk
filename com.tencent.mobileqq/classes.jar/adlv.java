import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class adlv
  implements View.OnClickListener
{
  public adlv(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (NotifyPushSettingActivity.a(this.a) == null)
    {
      NotifyPushSettingActivity.a(this.a, new admb(this.a, this.a.app, NotifyPushSettingActivity.a(this.a), NotifyPushSettingActivity.a(this.a), NotifyPushSettingActivity.a(this.a)));
      admb.a(NotifyPushSettingActivity.a(this.a), NotifyPushSettingActivity.a(this.a));
    }
    if (NotifyPushSettingActivity.a(this.a))
    {
      int i = (int)NetConnInfoCenter.getServerTime();
      int j = SettingCloneUtil.readValueForInt(this.a.getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      NotifyPushSettingActivity.a(this.a).a(j - i);
    }
    NotifyPushSettingActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlv
 * JD-Core Version:    0.7.0.1
 */