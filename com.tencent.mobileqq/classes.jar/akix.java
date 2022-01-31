import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class akix
  implements ServiceConnection
{
  akix(akiw paramakiw) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    akiw.a(this.a, akpx.a(paramIBinder));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceConnected ARGlobalRemoteManager=" + akiw.a(this.a));
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    akiw.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceDisconnected ARGlobalRemoteManager=" + akiw.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akix
 * JD-Core Version:    0.7.0.1
 */