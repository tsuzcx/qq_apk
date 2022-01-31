import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.IQlinkService.Stub;
import cooperation.qlink.QlinkServiceProxy;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class alxo
  implements ServiceConnection
{
  public alxo(QlinkServiceProxy paramQlinkServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    QlinkServiceProxy.a(this.a, IQlinkService.Stub.a(paramIBinder));
    QlinkServiceProxy.a(this.a, false);
    QlinkServiceProxy.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + paramComponentName);
    try
    {
      QlinkServiceProxy.a(this.a).getApplication().unbindService(QlinkServiceProxy.a(this.a));
      QlinkServiceProxy.a(this.a, null);
      QlinkServiceProxy.a(this.a, false);
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxo
 * JD-Core Version:    0.7.0.1
 */