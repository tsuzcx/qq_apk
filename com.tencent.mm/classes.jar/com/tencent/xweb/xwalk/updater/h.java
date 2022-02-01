package com.tencent.xweb.xwalk.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ao;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.o;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWebDownloader.DownloadInfo;
import org.xwalk.core.XWebDownloader.DownloadListener;

public final class h
  implements XWebDownloader.DownloadListener
{
  private final i aipp;
  private final UpdateConfig aiqT;
  private final o aiqU;
  
  public h(UpdateConfig paramUpdateConfig, o paramo)
  {
    this.aiqT = paramUpdateConfig;
    this.aiqU = paramo;
    this.aipp = paramo.aipp;
  }
  
  private void a(XWebDownloader.DownloadInfo paramDownloadInfo)
  {
    int j = 1;
    AppMethodBeat.i(213021);
    int i;
    int k;
    int m;
    long l1;
    long l2;
    if (this.aiqT.ailq)
    {
      i = 2;
      k = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
      m = this.aiqT.aiqN;
      l1 = System.currentTimeMillis();
      l2 = paramDownloadInfo.mStartTimestamp;
      if (!paramDownloadInfo.mIsDownloadResume) {
        break label207;
      }
    }
    for (;;)
    {
      l.ev(15124, i + "," + k + "," + m + "," + ao.kge() + "," + paramDownloadInfo.mErrorCode + "," + paramDownloadInfo.mNetWorkType + "," + paramDownloadInfo.mRetryTimes + "," + (l1 - l2) + "," + paramDownloadInfo.mFileTotalSize + "," + paramDownloadInfo.mDownloadType + "," + j + "," + paramDownloadInfo.mUrl);
      AppMethodBeat.o(213021);
      return;
      i = 1;
      break;
      label207:
      j = 0;
    }
  }
  
  public final void onDownloadCancelled()
  {
    AppMethodBeat.i(213048);
    Log.i("XWalkRuntimeDownloadListener", "onDownloadCancelled");
    if (this.aipp != null) {
      this.aipp.kkk();
    }
    AppMethodBeat.o(213048);
  }
  
  public final void onDownloadCompleted(XWebDownloader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(213055);
    Log.i("XWalkRuntimeDownloadListener", "onDownloadCompleted, apkver:" + this.aiqT.aiqN);
    if (this.aiqT.ailq) {
      l.Bx(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
    for (;;)
    {
      a(paramDownloadInfo);
      new AsyncTask() {}.execute(new Void[0]);
      AppMethodBeat.o(213055);
      return;
      l.Bv(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
  }
  
  public final void onDownloadFailed(XWebDownloader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(213051);
    Log.i("XWalkRuntimeDownloadListener", "onDownloadFailed");
    if (this.aiqT.ailq) {
      l.kit();
    }
    for (;;)
    {
      a(paramDownloadInfo);
      if ((this.aiqT != null) && (this.aiqT.aiqI != null)) {
        this.aiqT.aiqI.aJR(-1);
      }
      if (this.aipp != null) {
        this.aipp.a(-1, this.aiqT.aiqI);
      }
      AppMethodBeat.o(213051);
      return;
      l.kio();
    }
  }
  
  public final void onDownloadStarted(int paramInt)
  {
    AppMethodBeat.i(213037);
    StringBuilder localStringBuilder = new StringBuilder("onDownloadStarted, type:").append(paramInt).append(", config:");
    Object localObject = this.aiqT;
    if (((UpdateConfig)localObject).checkValid())
    {
      localObject = "UpdateConfig isMatchMd5:" + ((UpdateConfig)localObject).aiqJ + ",downloadFileMd5:" + ((UpdateConfig)localObject).aiqK + ",isPatchUpdate:" + ((UpdateConfig)localObject).ailq + ",downUrl:" + ((UpdateConfig)localObject).aiqM + ",apkVer:" + ((UpdateConfig)localObject).aiqN + ",useCDN:" + ((UpdateConfig)localObject).aiiL + ",downloadPath:" + ((UpdateConfig)localObject).gEb() + ".";
      Log.i("XWalkRuntimeDownloadListener", (String)localObject);
      if (!this.aiqT.ailq) {
        break label194;
      }
      l.kis();
    }
    for (;;)
    {
      if (this.aipp != null) {
        this.aipp.a(this.aiqT.aiqI);
      }
      AppMethodBeat.o(213037);
      return;
      localObject = "invalid update config";
      break;
      label194:
      l.kin();
    }
  }
  
  public final void onDownloadUpdated(int paramInt)
  {
    AppMethodBeat.i(213042);
    if (this.aipp != null) {
      this.aipp.aJU(paramInt);
    }
    AppMethodBeat.o(213042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.h
 * JD-Core Version:    0.7.0.1
 */