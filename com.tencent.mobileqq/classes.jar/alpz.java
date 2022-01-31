import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.qphone.base.util.QLog;

public class alpz
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ark.ArkAppNotifyCenter", 2, "--VolumeReceiver---" + paramIntent.getAction());
    }
    ArkAppNotifyCenter.access$100("com.tencent.gouwu.video");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alpz
 * JD-Core Version:    0.7.0.1
 */