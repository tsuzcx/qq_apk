import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class akxo
  implements EIPCOnGetConnectionListener
{
  akxo(akxn paramakxn) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      akxn.a(this.a, paramEIPCConnection.procName);
    }
    akxn.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      akxn.a(this.a, paramEIPCConnection.procName);
    }
    akxn.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxo
 * JD-Core Version:    0.7.0.1
 */