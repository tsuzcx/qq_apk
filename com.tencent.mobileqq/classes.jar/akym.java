import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class akym
  implements ServiceConnection
{
  akym(akyk paramakyk) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.w(akyx.a, 1, "onServiceConnected, name[" + paramComponentName + "]");
    try
    {
      this.a.a = alec.a(paramIBinder);
      this.a.a.a(akyk.a(this.a));
      this.a.a.c();
      return;
    }
    catch (Exception paramComponentName)
    {
      QLog.w(akyx.a, 1, "onServiceConnected, Exception", paramComponentName);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.w(akyx.a, 1, "onServiceDisconnected, name[" + paramComponentName + "]");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akym
 * JD-Core Version:    0.7.0.1
 */