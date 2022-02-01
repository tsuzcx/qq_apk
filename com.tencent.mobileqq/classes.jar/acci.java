import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;

final class acci
  implements AdIPCManager.Handler
{
  public AdIPCManager.Result handle(AdIPCManager.Params paramParams)
  {
    String str2 = null;
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    if (paramParams == null) {
      if (paramParams == null) {
        break label91;
      }
    }
    label91:
    for (String str1 = paramParams.getAction();; str1 = null)
    {
      if (paramParams != null) {
        str2 = paramParams.getToProcessName();
      }
      acho.b("GdtInterstitialPreDownloader", String.format("IPCHandlerForPreDownload.handle action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(localResult.success) }));
      return localResult;
      if (!paramParams.isValid()) {
        break;
      }
      accf.a().a();
      localResult.success = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acci
 * JD-Core Version:    0.7.0.1
 */