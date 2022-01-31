import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class adty
  extends SSOAccountObserver
{
  WeakReference a;
  
  public adty(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    this.a = new WeakReference(paramForwardSdkBaseOption);
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSdkBaseOption", 2, "-->onFailed--account = " + paramString + ", ret = " + paramInt2);
    }
    paramString = (ForwardSdkBaseOption)this.a.get();
    if ((paramString != null) && (!paramString.k) && (ForwardSdkBaseOption.a(paramString) != null)) {
      ForwardSdkBaseOption.a(paramString).sendEmptyMessage(0);
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSdkBaseOption", 2, "-->onGetTicketNoPasswd--recv g_t_n_p, account = " + paramString);
    }
    if (paramInt == 4096) {}
    for (paramString = new String(paramArrayOfByte);; paramString = null)
    {
      paramArrayOfByte = (ForwardSdkBaseOption)this.a.get();
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.i = paramString;
        paramArrayOfByte.k = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adty
 * JD-Core Version:    0.7.0.1
 */