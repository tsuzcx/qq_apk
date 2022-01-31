import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class ahce
  implements EIPCOnGetConnectionListener
{
  ahce(ahcd paramahcd) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      ahcd.a(this.a, paramEIPCConnection.procName);
    }
    ahcd.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      ahcd.a(this.a, paramEIPCConnection.procName);
    }
    ahcd.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahce
 * JD-Core Version:    0.7.0.1
 */