package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;

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
    AppMethodBeat.i(85905);
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
        break label184;
      }
    }
    for (;;)
    {
      f.bW(15124, i + "," + k + "," + m + ",190503," + paramDownloadInfo.mErrorCode + "," + paramDownloadInfo.mNetWorkType + "," + paramDownloadInfo.mRetryTimes + "," + (l1 - l2) + "," + paramDownloadInfo.mFileTotalSize + "," + paramDownloadInfo.mDownloadType + "," + j);
      AppMethodBeat.o(85905);
      return;
      i = 1;
      break;
      label184:
      j = 0;
    }
  }
  
  public void onDownloadCancelled()
  {
    AppMethodBeat.i(85902);
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateCancelled();
    AppMethodBeat.o(85902);
  }
  
  public void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(85904);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk completed, apkver = " + this.mConfig.apkVer);
    if (this.mConfig.isPatchUpdate) {
      f.pl(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
    for (;;)
    {
      reportKV(paramDownloadInfo);
      new XWalkUpdater.BackgroundListener.1(this).execute(new Void[0]);
      AppMethodBeat.o(85904);
      return;
      f.pj(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
  }
  
  public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(85903);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
    if (this.mConfig.isPatchUpdate) {
      f.dZv();
    }
    for (;;)
    {
      reportKV(paramDownloadInfo);
      XWalkUpdater.access$000(this.this$0).onXWalkUpdateFailed(-1);
      AppMethodBeat.o(85903);
      return;
      f.dZr();
    }
  }
  
  public void onDownloadStarted(int paramInt)
  {
    AppMethodBeat.i(85900);
    Log.d("XWalkLib", "DownloadTask started, type:" + paramInt + " config:" + this.mConfig.getLogSelf());
    if (this.mConfig.isPatchUpdate) {
      f.aGV();
    }
    for (;;)
    {
      XWalkUpdater.access$000(this.this$0).onXWalkUpdateStarted();
      AppMethodBeat.o(85900);
      return;
      f.dZq();
    }
  }
  
  public void onDownloadUpdated(int paramInt)
  {
    AppMethodBeat.i(85901);
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateProgress(paramInt);
    AppMethodBeat.o(85901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.BackgroundListener
 * JD-Core Version:    0.7.0.1
 */