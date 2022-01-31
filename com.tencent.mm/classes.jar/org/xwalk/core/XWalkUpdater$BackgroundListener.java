package org.xwalk.core;

import com.tencent.xweb.util.e;

class XWalkUpdater$BackgroundListener
  implements XWalkLibraryLoader.DownloadListener
{
  private XWalkUpdater.UpdateConfig mConfig;
  
  public XWalkUpdater$BackgroundListener(XWalkUpdater paramXWalkUpdater, XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    this.mConfig = paramUpdateConfig;
  }
  
  private void reportKV(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    int j = 1;
    int i;
    int k;
    int m;
    long l1;
    long l2;
    if (this.mConfig.isPatchUpdate)
    {
      i = 2;
      k = XWalkEnvironment.getInstalledNewstVersion();
      m = this.mConfig.apkVer;
      l1 = System.currentTimeMillis();
      l2 = paramDownloadInfo.mStartTimestamp;
      if (!paramDownloadInfo.mIsDownloadResume) {
        break label174;
      }
    }
    for (;;)
    {
      e.bp(15124, i + "," + k + "," + m + ",180801," + paramDownloadInfo.mErrorCode + "," + paramDownloadInfo.mNetWorkType + "," + paramDownloadInfo.mRetryTimes + "," + (l1 - l2) + "," + paramDownloadInfo.mFileTotalSize + "," + paramDownloadInfo.mDownloadType + "," + j);
      return;
      i = 1;
      break;
      label174:
      j = 0;
    }
  }
  
  public void onDownloadCancelled()
  {
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateCancelled();
  }
  
  public void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk completed, apkver = " + this.mConfig.apkVer);
    if (this.mConfig.isPatchUpdate) {
      e.iz(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
    for (;;)
    {
      reportKV(paramDownloadInfo);
      new XWalkUpdater.BackgroundListener.1(this).execute(new Void[0]);
      return;
      e.ix(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
  }
  
  public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
    if (this.mConfig.isPatchUpdate) {
      e.cTf();
    }
    for (;;)
    {
      reportKV(paramDownloadInfo);
      XWalkUpdater.access$000(this.this$0).onXWalkUpdateFailed(-1);
      return;
      e.cTa();
    }
  }
  
  public void onDownloadStarted(int paramInt)
  {
    Log.d("XWalkLib", "DownloadTask started, type:" + paramInt + " config:" + this.mConfig.getLogSelf());
    if (this.mConfig.isPatchUpdate) {
      e.cTe();
    }
    for (;;)
    {
      XWalkUpdater.access$000(this.this$0).onXWalkUpdateStarted();
      return;
      e.cSZ();
    }
  }
  
  public void onDownloadUpdated(int paramInt)
  {
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.BackgroundListener
 * JD-Core Version:    0.7.0.1
 */