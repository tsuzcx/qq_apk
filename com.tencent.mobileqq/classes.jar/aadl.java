import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aadl
  implements Runnable
{
  public aadl(RemoteArConfigManager paramRemoteArConfigManager) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadResource");
      }
      try
      {
        if (!this.a.a())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a();
          this.a.jdField_a_of_type_Boolean = true;
          return;
        }
        RemoteArConfigManager.a(this.a).sendMessage(RemoteArConfigManager.a(this.a).obtainMessage(3));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "downloadResource|RemoteException e= " + localRemoteException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadl
 * JD-Core Version:    0.7.0.1
 */