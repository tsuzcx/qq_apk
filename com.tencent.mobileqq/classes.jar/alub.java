import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.qphone.base.util.QLog;

public class alub
  extends BroadcastReceiver
{
  public alub(GuardManager paramGuardManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (this.a.jdField_a_of_type_Long > 0L) {
        this.a.a(false);
      }
      anov.b();
    }
    while (!"android.intent.action.SCREEN_ON".equals(paramContext)) {
      return;
    }
    if ((this.a.jdField_a_of_type_Long == 0L) && (this.a.jdField_a_of_type_JavaLangString != null)) {
      this.a.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    anov.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alub
 * JD-Core Version:    0.7.0.1
 */