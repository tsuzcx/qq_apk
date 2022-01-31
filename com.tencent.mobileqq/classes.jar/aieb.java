import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

public class aieb
  implements EIPCOnGetConnectionListener
{
  public aieb(InnerDns paramInnerDns) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.a(this.a, paramEIPCConnection.procName);
    }
    InnerDns.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.a(this.a, paramEIPCConnection.procName);
    }
    InnerDns.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aieb
 * JD-Core Version:    0.7.0.1
 */