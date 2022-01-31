import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class acwz
  extends BroadcastReceiver
{
  acwz(acwy paramacwy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals("com.tencent.mobileqq.intent.logout")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "OLfilesession[] logout.....!");
        }
        this.a.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acwz
 * JD-Core Version:    0.7.0.1
 */