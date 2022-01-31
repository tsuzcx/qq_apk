import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class akkb
  implements ServiceConnection
{
  akkb(akjz paramakjz) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.w(akkm.a, 1, "onServiceConnected, name[" + paramComponentName + "]");
    try
    {
      this.a.a = akpr.a(paramIBinder);
      this.a.a.a(akjz.a(this.a));
      this.a.a.c();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(akkm.a, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.w(akkm.a, 1, "onServiceDisconnected, name[" + paramComponentName + "]");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akkb
 * JD-Core Version:    0.7.0.1
 */