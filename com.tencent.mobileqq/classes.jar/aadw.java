import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.ar.ARGlobalRemoteManager;
import com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager.Stub;
import com.tencent.qphone.base.util.QLog;

public class aadw
  implements ServiceConnection
{
  public aadw(ARGlobalRemoteManager paramARGlobalRemoteManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    ARGlobalRemoteManager.a(this.a, IArGlobalConfigManager.Stub.a(paramIBinder));
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceConnected ARGlobalRemoteManager=" + ARGlobalRemoteManager.a(this.a));
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ARGlobalRemoteManager.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("ARGlobalRemoteManager", 2, "onServiceDisconnected ARGlobalRemoteManager=" + ARGlobalRemoteManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadw
 * JD-Core Version:    0.7.0.1
 */