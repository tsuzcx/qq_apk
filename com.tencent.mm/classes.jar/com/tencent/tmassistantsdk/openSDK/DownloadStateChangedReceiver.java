package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadStateChangedReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "DownloadStateChangedReceiver";
  protected static DownloadStateChangedReceiver mInstance = null;
  protected ao handler;
  protected boolean isRegisted;
  ArrayList<IDownloadStateChangedListener> mListeners;
  
  public DownloadStateChangedReceiver()
  {
    AppMethodBeat.i(102086);
    this.handler = null;
    this.isRegisted = false;
    this.mListeners = new ArrayList();
    this.handler = new ao("downloadStateChangedThread");
    AppMethodBeat.o(102086);
  }
  
  public static DownloadStateChangedReceiver getInstance()
  {
    try
    {
      AppMethodBeat.i(102087);
      if (mInstance == null) {
        mInstance = new DownloadStateChangedReceiver();
      }
      DownloadStateChangedReceiver localDownloadStateChangedReceiver = mInstance;
      AppMethodBeat.o(102087);
      return localDownloadStateChangedReceiver;
    }
    finally {}
  }
  
  public void addDownloadStateChangedListener(IDownloadStateChangedListener paramIDownloadStateChangedListener)
  {
    AppMethodBeat.i(102091);
    if ((paramIDownloadStateChangedListener != null) && (!this.mListeners.contains(paramIDownloadStateChangedListener))) {
      this.mListeners.add(paramIDownloadStateChangedListener);
    }
    AppMethodBeat.o(102091);
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(102088);
    if (this.handler != null) {
      this.handler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(102085);
          TMQQDownloaderStateChangeParam localTMQQDownloaderStateChangeParam = new TMQQDownloaderStateChangeParam();
          localTMQQDownloaderStateChangeParam.hostPackageName = paramIntent.getStringExtra("hostPackageName");
          localTMQQDownloaderStateChangeParam.hostVersion = paramIntent.getStringExtra("hostVersion");
          localTMQQDownloaderStateChangeParam.taskId = paramIntent.getStringExtra("taskId");
          localTMQQDownloaderStateChangeParam.errorCode = bs.getInt(paramIntent.getStringExtra("errorCode"), 0);
          localTMQQDownloaderStateChangeParam.errorMsg = paramIntent.getStringExtra("errorMsg");
          localTMQQDownloaderStateChangeParam.state = bs.getInt(paramIntent.getStringExtra("state"), 0);
          Object localObject = new TMQQDownloaderOpenSDKParam();
          ((TMQQDownloaderOpenSDKParam)localObject).SNGAppId = paramIntent.getStringExtra("sngAppId");
          ((TMQQDownloaderOpenSDKParam)localObject).taskAppId = paramIntent.getStringExtra("taskAppId");
          ((TMQQDownloaderOpenSDKParam)localObject).taskApkId = paramIntent.getStringExtra("taskApkId");
          ((TMQQDownloaderOpenSDKParam)localObject).taskPackageName = paramIntent.getStringExtra("taskPackageName");
          ((TMQQDownloaderOpenSDKParam)localObject).taskVersion = bs.getInt(paramIntent.getStringExtra("taskVersion"), 0);
          ((TMQQDownloaderOpenSDKParam)localObject).via = paramIntent.getStringExtra("via");
          ((TMQQDownloaderOpenSDKParam)localObject).uin = paramIntent.getStringExtra("uin");
          ((TMQQDownloaderOpenSDKParam)localObject).uinType = paramIntent.getStringExtra("uinType");
          localTMQQDownloaderStateChangeParam.param = ((TMQQDownloaderOpenSDKParam)localObject);
          localObject = DownloadStateChangedReceiver.this.mListeners.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((IDownloadStateChangedListener)((Iterator)localObject).next()).onDownloadStateChanged(localTMQQDownloaderStateChangeParam);
          }
          AppMethodBeat.o(102085);
        }
      });
    }
    AppMethodBeat.o(102088);
  }
  
  public void registeReceiver(Context paramContext)
  {
    AppMethodBeat.i(102089);
    if (!this.isRegisted)
    {
      TMLog.i("DownloadStateChangedReceiver", "registeReceiver   context" + paramContext + "  receiver:" + this);
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action");
      try
      {
        TMLog.i("DownloadStateChangedReceiver", String.valueOf(paramContext.registerReceiver(this, localIntentFilter)));
        this.isRegisted = true;
        AppMethodBeat.o(102089);
        return;
      }
      catch (Throwable paramContext)
      {
        TMLog.i("DownloadStateChangedReceiver", "registeReceiver exception!!!");
        this.isRegisted = false;
        ac.printErrStackTrace("DownloadStateChangedReceiver", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(102089);
  }
  
  public void removeDownloadStateChangedListener(IDownloadStateChangedListener paramIDownloadStateChangedListener)
  {
    AppMethodBeat.i(102092);
    if (paramIDownloadStateChangedListener != null) {
      this.mListeners.remove(paramIDownloadStateChangedListener);
    }
    AppMethodBeat.o(102092);
  }
  
  public void unRegisteReceiver(Context paramContext)
  {
    AppMethodBeat.i(102090);
    if ((paramContext == null) || (mInstance == null))
    {
      AppMethodBeat.o(102090);
      return;
    }
    if (this.isRegisted)
    {
      TMLog.i("DownloadStateChangedReceiver", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
      try
      {
        paramContext.unregisterReceiver(this);
        this.isRegisted = false;
        AppMethodBeat.o(102090);
        return;
      }
      catch (Throwable paramContext)
      {
        TMLog.i("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!");
        this.isRegisted = false;
        ac.printErrStackTrace("DownloadStateChangedReceiver", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(102090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.DownloadStateChangedReceiver
 * JD-Core Version:    0.7.0.1
 */