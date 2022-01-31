import com.tencent.mobileqq.armap.ipc.ArMapIPC;
import com.tencent.mobileqq.armap.ipc.IPCConstants;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;

public class abft
  implements EIPClientConnectListener
{
  public abft(ArMapIPC paramArMapIPC) {}
  
  public void connectFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPC", 2, "connectFailed ");
    }
    this.a.a = false;
    this.a.a(IPCConstants.b, EIPCResult.createResult(-102, null));
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = paramEIPCConnection.procName;
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPC", 2, "connectSuccess " + paramEIPCConnection);
    }
    this.a.a = true;
    this.a.a(IPCConstants.b, EIPCResult.createResult(0, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abft
 * JD-Core Version:    0.7.0.1
 */