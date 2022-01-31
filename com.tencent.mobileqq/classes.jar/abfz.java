import com.tencent.mobileqq.armap.ipc.ArMapIPCProxy;
import com.tencent.mobileqq.armap.ipc.IPCConstants;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;

public class abfz
  implements EIPCOnGetConnectionListener
{
  public abfz(ArMapIPCProxy paramArMapIPCProxy) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = paramEIPCConnection.procName;
    if (paramEIPCConnection.equals(IPCConstants.a))
    {
      this.a.a = true;
      this.a.a(IPCConstants.c, EIPCResult.createResult(0, null));
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPCProxy", 2, "onConnectBind " + paramEIPCConnection);
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    paramEIPCConnection = paramEIPCConnection.procName;
    if (paramEIPCConnection.equals(IPCConstants.a))
    {
      this.a.a = false;
      this.a.a(IPCConstants.c, EIPCResult.createResult(-102, null));
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArMapIPCProxy", 2, "onConnectUnbind " + paramEIPCConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfz
 * JD-Core Version:    0.7.0.1
 */