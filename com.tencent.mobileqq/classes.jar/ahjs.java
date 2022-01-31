import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ahjs
  extends BroadcastReceiver
{
  public ahjs(CliNotifyPush paramCliNotifyPush) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (CliNotifyPush.jdField_a_of_type_Boolean != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      CliNotifyPush.a(this.a, 2013);
      return;
    }
    CliNotifyPush.jdField_a_of_type_Boolean = false;
    if (paramIntent != null)
    {
      CliNotifyPush.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + CliNotifyPush.a(this.a));
      if ((CliNotifyPush.a(this.a) != 0) && (CliNotifyPush.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      CliNotifyPush.jdField_a_of_type_Int = 0;
      CliNotifyPush.b = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.getHandler(CliNotifyPush.class).removeCallbacks(CliNotifyPush.a(this.a));
      paramContext.getHandler(CliNotifyPush.class).post(CliNotifyPush.a(this.a));
      return;
      label194:
      CliNotifyPush.a(this.a, 3001);
      CliNotifyPush.jdField_a_of_type_Int += 1;
      continue;
      label216:
      CliNotifyPush.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahjs
 * JD-Core Version:    0.7.0.1
 */