import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;

class aclz
  implements AdIPCManager.Callback
{
  aclz(acly paramacly) {}
  
  public void onCallback(AdIPCManager.Params paramParams, AdIPCManager.Result paramResult)
  {
    if (paramResult != null) {}
    for (boolean bool = paramResult.success;; bool = false)
    {
      acqy.b("GdtInterstitialAd", String.format("close.onCallback %b", new Object[] { Boolean.valueOf(bool) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclz
 * JD-Core Version:    0.7.0.1
 */