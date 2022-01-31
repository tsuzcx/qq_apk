package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b.a;
import com.tencent.xweb.b.c;
import com.tencent.xweb.b.d;

public class XWalkLibraryLoader$WXFileDownloaderTask
  extends AsyncTask<Void, Integer, Integer>
  implements c
{
  private static final int DOWNLOAD_FAILED = -1;
  private static final int DOWNLOAD_SUCCESS = 0;
  private static final int UPDATE_INTERVAL_MS = 500;
  private final Object lockObj;
  private XWalkLibraryLoader.DownloadInfo mDownloadInfo;
  private XWalkLibraryLoader.DownloadListener mListener;
  private long mProgressUpdateTime;
  private d mWXFileDownloaderBridge;
  private boolean mWaitTimeout;
  
  public XWalkLibraryLoader$WXFileDownloaderTask(boolean paramBoolean, XWalkLibraryLoader.DownloadListener paramDownloadListener, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(85682);
    this.mProgressUpdateTime = 0L;
    this.mWXFileDownloaderBridge = null;
    this.lockObj = new Object();
    this.mWaitTimeout = false;
    this.mListener = paramDownloadListener;
    this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
    this.mDownloadInfo.mErrorType = 0;
    this.mDownloadInfo.mErrorCode = 0;
    this.mDownloadInfo.mDownloadType = 2;
    this.mDownloadInfo.mUrl = paramString1;
    this.mDownloadInfo.mSavePath = paramString2;
    this.mDownloadInfo.mIsRuntime = paramBoolean;
    this.mDownloadInfo.mBizType = paramInt;
    this.mWXFileDownloaderBridge = new d();
    this.mWXFileDownloaderBridge.BEP = this;
    AppMethodBeat.o(85682);
  }
  
  protected Integer doInBackground(Void... arg1)
  {
    AppMethodBeat.i(85684);
    if ((this.mWXFileDownloaderBridge == null) || (!d.isValid()))
    {
      this.mDownloadInfo.mErrorType = 2;
      this.mDownloadInfo.mErrorCode = -1;
      AppMethodBeat.o(85684);
      return Integer.valueOf(-1);
    }
    ??? = this.mWXFileDownloaderBridge;
    String str1 = this.mDownloadInfo.mUrl;
    String str2 = this.mDownloadInfo.mSavePath;
    if (d.BEO != null) {}
    for (int i = d.BEO.a(str1, str2, ???);; i = -1)
    {
      if (i != 0)
      {
        this.mDownloadInfo.mErrorType = 1;
        this.mDownloadInfo.mErrorCode = -1;
        AppMethodBeat.o(85684);
        return Integer.valueOf(-1);
      }
      synchronized (this.lockObj)
      {
        try
        {
          this.mWaitTimeout = true;
          this.lockObj.wait(300000L);
          if ((this.mDownloadInfo.mErrorType == 0) && (this.mDownloadInfo.mErrorCode == 0))
          {
            AppMethodBeat.o(85684);
            return Integer.valueOf(0);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            this.mWaitTimeout = false;
            this.mDownloadInfo.mErrorType = 2;
            this.mDownloadInfo.mErrorCode = -101;
          }
        }
      }
      Log.e("XWalkLib", "download errortype:" + this.mDownloadInfo.mErrorType + ", errorcode:" + this.mDownloadInfo.mErrorCode + ", waitTimeout:" + this.mWaitTimeout);
      if (this.mWaitTimeout)
      {
        this.mDownloadInfo.mErrorType = 1;
        this.mDownloadInfo.mErrorCode = -100;
      }
      AppMethodBeat.o(85684);
      return Integer.valueOf(-1);
    }
  }
  
  public boolean isValid()
  {
    AppMethodBeat.i(85681);
    if (this.mWXFileDownloaderBridge == null)
    {
      AppMethodBeat.o(85681);
      return false;
    }
    boolean bool = d.isValid();
    AppMethodBeat.o(85681);
    return bool;
  }
  
  protected void onCancelled(Integer paramInteger)
  {
    AppMethodBeat.i(85686);
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      Log.i("XWalkLib", "WXFileDownloaderTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
    }
    for (;;)
    {
      this.mListener.onDownloadCancelled();
      AppMethodBeat.o(85686);
      return;
      Log.i("XWalkLib", "WXFileDownloaderTask other onCancelled: " + this.mDownloadInfo.mSavePath);
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    AppMethodBeat.i(85687);
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      Log.i("XWalkLib", "WXFileDownloaderTask runtime onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
    }
    while (paramInteger.intValue() == 0)
    {
      this.mListener.onDownloadCompleted(this.mDownloadInfo);
      AppMethodBeat.o(85687);
      return;
      Log.i("XWalkLib", "WXFileDownloaderTask other onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
    }
    this.mListener.onDownloadFailed(this.mDownloadInfo);
    AppMethodBeat.o(85687);
  }
  
  protected void onPreExecute()
  {
    AppMethodBeat.i(85683);
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(this);
      Log.i("XWalkLib", "WXFileDownloaderTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
    }
    for (;;)
    {
      this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
      this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
      Context localContext = XWalkEnvironment.getApplicationContext();
      this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(localContext);
      AppMethodBeat.o(85683);
      return;
      Log.i("XWalkLib", "WXFileDownloaderTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
    }
  }
  
  public void onProgressChange(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(85688);
    Log.d("XWalkLib", "url:" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
    if (this.mDownloadInfo.mFileTotalSize != paramLong2) {
      this.mDownloadInfo.mFileTotalSize = paramLong2;
    }
    publishProgress(new Integer[] { Integer.valueOf((int)paramLong1), Integer.valueOf((int)paramLong2) });
    AppMethodBeat.o(85688);
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(85685);
    Log.d("XWalkLib", "WXFileDownloaderTask updated: " + paramVarArgs[0] + "/" + paramVarArgs[1]);
    if (paramVarArgs[1].intValue() > 0) {
      i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
    }
    this.mListener.onDownloadUpdated(i);
    AppMethodBeat.o(85685);
  }
  
  public void onTaskFail(String arg1, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(85690);
    synchronized (this.lockObj)
    {
      this.mDownloadInfo.mErrorType = 1;
      this.mDownloadInfo.mErrorCode = paramInt;
      this.mDownloadInfo.mIsDownloadResume = paramBoolean;
      this.mWaitTimeout = false;
      this.lockObj.notify();
      AppMethodBeat.o(85690);
      return;
    }
  }
  
  public void onTaskSucc(String arg1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(85689);
    synchronized (this.lockObj)
    {
      this.mDownloadInfo.mIsDownloadResume = paramBoolean;
      this.mWaitTimeout = false;
      this.lockObj.notify();
      AppMethodBeat.o(85689);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask
 * JD-Core Version:    0.7.0.1
 */