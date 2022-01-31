import com.tencent.mobileqq.armap.ipc.ArMapIPC;
import com.tencent.mobileqq.armap.ipc.IPCConstants;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;

public class abmv
  implements EIPCOnGetConnectionListener
{
  public abmv(ArMapIPC paramArMapIPC) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = paramEIPCConnection.procName;
    this.a.a = true;
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPC", 2, "onConnectBind " + paramEIPCConnection);
    }
    this.a.a(IPCConstants.c, EIPCResult.createResult(0, null));
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = paramEIPCConnection.procName;
    this.a.a = false;
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPC", 2, "onConnectUnbind " + paramEIPCConnection);
    }
    this.a.a(IPCConstants.c, EIPCResult.createResult(0, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmv
 * JD-Core Version:    0.7.0.1
 */