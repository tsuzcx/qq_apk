import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class aaqf
  implements TVK_SDKMgr.InstallListener
{
  aaqf(aaqa paramaaqa) {}
  
  public void onInstallProgress(float paramFloat)
  {
    aase.a("GdtMvViewController", "installSDK onInstallProgress arg0=" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    aase.a("GdtMvViewController", "installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    aase.a("GdtMvViewController", "installSDK onInstalledSuccessed");
    aaqa.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqf
 * JD-Core Version:    0.7.0.1
 */