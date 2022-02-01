import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class afbm
  extends BroadcastReceiver
{
  public afbm(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingActivity.a(this.a, paramContext);
    }
    do
    {
      boolean bool;
      do
      {
        return;
        if (!paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive")) {
          break;
        }
        paramContext = paramIntent.getStringExtra("uin");
        bool = paramIntent.getBooleanExtra("configPCActive", false);
      } while (!this.a.app.getAccount().equals(paramContext));
      if (true == bool)
      {
        NotifyPushSettingActivity.g(this.a).setVisibility(0);
        return;
      }
      NotifyPushSettingActivity.g(this.a).setVisibility(8);
      return;
    } while (!paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage"));
    paramContext = paramIntent.getStringExtra("uin");
    NotifyPushSettingActivity.b(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbm
 * JD-Core Version:    0.7.0.1
 */