import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class aklt
  extends BroadcastReceiver
{
  public aklt(WebProcessManager paramWebProcessManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "action=" + paramContext);
        }
        if (!paramContext.equals("com.tencent.mobileqq.webprocess.restart_web_process")) {
          break;
        }
        this.a.f();
      } while (!paramIntent.getBooleanExtra("isPreloadWebProcess", false));
      this.a.i();
      return;
    } while (!paramContext.equals("com.tencent.mobileqq.webprocess.report"));
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklt
 * JD-Core Version:    0.7.0.1
 */