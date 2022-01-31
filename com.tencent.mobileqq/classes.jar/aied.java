import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;

public class aied
  implements Runnable
{
  public aied(InnerDns paramInnerDns) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 1, "syncAddressData called, mServerProcName=" + InnerDns.a(this.a) + ", mConnected=" + InnerDns.a(this.a));
    }
    if (InnerDns.a(this.a)) {
      try
      {
        Object localObject1 = new Bundle();
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "syncAddressData", (Bundle)localObject1);
        if (((EIPCResult)localObject1).isSuccess())
        {
          localObject1 = ((EIPCResult)localObject1).data.getString("addressData");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return;
          }
          localObject1 = InnerDns.a((String)localObject1);
          if (localObject1 == null) {
            return;
          }
          try
          {
            InnerDns.a(this.a, new HashMap((Map)localObject1));
            return;
          }
          finally {}
        }
        QLog.e("InnerDns", 1, "syncAddressData fail, mServerProcName=" + InnerDns.a(this.a));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("InnerDns", 1, "syncAddressData error:" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aied
 * JD-Core Version:    0.7.0.1
 */