import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import java.lang.ref.WeakReference;

public final class acqc
  implements AdIPCManager.Handler
{
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    String str2 = null;
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    if (paramParams == null) {
      if (paramParams == null) {
        break label179;
      }
    }
    label179:
    for (String str1 = paramParams.getAction();; str1 = null)
    {
      if (paramParams != null) {
        str2 = paramParams.getToProcessName();
      }
      acvc.b("GdtInterstitialAd", String.format("IPCHandlerForClose.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localResult.success) }));
      return localResult;
      if ((!paramParams.isValid()) || (paramParams.bundle == null)) {
        break;
      }
      str1 = paramParams.bundle.getString("TRACE_ID");
      if (paramParams.bundle == null) {
        break;
      }
      WeakReference localWeakReference = acqd.a().a(str1);
      if ((localWeakReference == null) || (localWeakReference.get() == null)) {
        break;
      }
      acqe.c(BaseApplicationImpl.getContext(), ((GdtInterstitialFragment)localWeakReference.get()).a(), ((GdtInterstitialFragment)localWeakReference.get()).a());
      localResult.success = true;
      AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialAd.IPCHandlerForClose.1(this, str1), 0, 2000L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqc
 * JD-Core Version:    0.7.0.1
 */