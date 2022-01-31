import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

public class aisd
  implements EIPClientConnectListener
{
  public aisd(InnerDns paramInnerDns) {}
  
  public void connectFailed()
  {
    InnerDns.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectFailed");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      InnerDns.a(this.a, paramEIPCConnection.procName);
    }
    InnerDns.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "connectSuccess");
    }
    InnerDns.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisd
 * JD-Core Version:    0.7.0.1
 */