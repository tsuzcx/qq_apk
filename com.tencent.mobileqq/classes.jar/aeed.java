import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.nearby.ipc.MainProcessInterface;
import com.tencent.mobileqq.nearby.ipc.MainProcessInterface.Stub;
import com.tencent.mobileqq.nearby.ipc.NearbyProcess;
import com.tencent.qphone.base.util.QLog;

public class aeed
  implements ServiceConnection
{
  public aeed(NearbyProcess paramNearbyProcess) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface = MainProcessInterface.Stub.a(paramIBinder);
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcessInterface);
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceConnected.");
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramComponentName.printStackTrace();
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (NearbyProcess.a(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyIpcMainProcessInterface = null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, "nearbyProcess onServiceDisConnected.");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeed
 * JD-Core Version:    0.7.0.1
 */