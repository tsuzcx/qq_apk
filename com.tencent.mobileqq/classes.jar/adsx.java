import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class adsx
  implements TVK_SDKMgr.InstallListener
{
  public adsx(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ImaxAdUtil.b("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    ImaxAdUtil.b("installSDK onInstalledSuccessed");
    ImaxAdVideoPreloadManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsx
 * JD-Core Version:    0.7.0.1
 */