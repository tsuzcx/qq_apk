import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class agpr
  implements EIPCOnGetConnectionListener
{
  agpr(agpq paramagpq) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      agpq.a(this.a, paramEIPCConnection.procName);
    }
    agpq.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      agpq.a(this.a, paramEIPCConnection.procName);
    }
    agpq.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpr
 * JD-Core Version:    0.7.0.1
 */