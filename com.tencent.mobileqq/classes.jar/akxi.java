import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class akxi
  implements ServiceConnection
{
  akxi(akxh paramakxh) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    akxh.a(this.a, alei.a(paramIBinder));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceConnected ARGlobalRemoteManager=" + akxh.a(this.a));
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    akxh.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceDisconnected ARGlobalRemoteManager=" + akxh.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxi
 * JD-Core Version:    0.7.0.1
 */