import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class aalq
  implements TVK_SDKMgr.InstallListener
{
  aalq(aall paramaall) {}
  
  public void onInstallProgress(float paramFloat)
  {
    aanp.a("GdtMvViewController", "installSDK onInstallProgress arg0=" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    aanp.a("GdtMvViewController", "installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    aanp.a("GdtMvViewController", "installSDK onInstalledSuccessed");
    aall.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalq
 * JD-Core Version:    0.7.0.1
 */