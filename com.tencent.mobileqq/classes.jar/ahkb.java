import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class ahkb
  implements Runnable
{
  public ahkb(QZoneNotifyServlet paramQZoneNotifyServlet) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QZoneNotifyServlet.a(), 2, "QZone scheduled QZoneFeedTimeTask run. currentTime:" + System.currentTimeMillis());
    }
    AppRuntime localAppRuntime = this.a.getAppRuntime();
    if (localAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), QZoneNotifyServlet.class);
    localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localNewIntent.putExtra("qzone_send_by_time", 4);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahkb
 * JD-Core Version:    0.7.0.1
 */