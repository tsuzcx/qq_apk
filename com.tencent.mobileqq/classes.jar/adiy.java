import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class adiy
  implements TVK_SDKMgr.InstallListener
{
  public adiy(ImaxAdVideoPreloadManager paramImaxAdVideoPreloadManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adiy
 * JD-Core Version:    0.7.0.1
 */