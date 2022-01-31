package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;

public class DownloadStateChangedReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "DownloadStateChangedReceiver";
  protected static DownloadStateChangedReceiver mInstance = null;
  protected ah handler = null;
  protected HandlerThread handlerThread = new HandlerThread("downloadStateChangedThread");
  protected boolean isRegisted = false;
  ArrayList<IDownloadStateChangedListener> mListeners = new ArrayList();
  
  public DownloadStateChangedReceiver()
  {
    this.handlerThread.start();
    this.handler = new ah(this.handlerThread.getLooper());
  }
  
  public static DownloadStateChangedReceiver getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DownloadStateChangedReceiver();
      }
      DownloadStateChangedReceiver localDownloadStateChangedReceiver = mInstance;
      return localDownloadStateChangedReceiver;
    }
    finally {}
  }
  
  public void addDownloadStateChangedListener(IDownloadStateChangedListener paramIDownloadStateChangedListener)
  {
    if ((paramIDownloadStateChangedListener != null) && (!this.mListeners.contains(paramIDownloadStateChangedListener))) {
      this.mListeners.add(paramIDownloadStateChangedListener);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.handler != null) {
      this.handler.post(new DownloadStateChangedReceiver.1(this, paramIntent));
    }
  }
  
  public void registeReceiver(Context paramContext)
  {
    IntentFilter localIntentFilter;
    if (!this.isRegisted)
    {
      TMLog.i("DownloadStateChangedReceiver", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action");
    }
    try
    {
      TMLog.i("DownloadStateChangedReceiver", String.valueOf(paramContext.registerReceiver(this, localIntentFilter)));
      this.isRegisted = true;
      return;
    }
    catch (Throwable paramContext)
    {
      TMLog.i("DownloadStateChangedReceiver", "registeReceiver exception!!!");
      this.isRegisted = false;
      y.printErrStackTrace("DownloadStateChangedReceiver", paramContext, "", new Object[0]);
    }
  }
  
  public void removeDownloadStateChangedListener(IDownloadStateChangedListener paramIDownloadStateChangedListener)
  {
    if (paramIDownloadStateChangedListener != null) {
      this.mListeners.remove(paramIDownloadStateChangedListener);
    }
  }
  
  public void unRegisteReceiver(Context paramContext)
  {
    if ((paramContext == null) || (mInstance == null)) {}
    while (!this.isRegisted) {
      return;
    }
    TMLog.i("DownloadStateChangedReceiver", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.isRegisted = false;
      return;
    }
    catch (Throwable paramContext)
    {
      TMLog.i("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!");
      this.isRegisted = false;
      y.printErrStackTrace("DownloadStateChangedReceiver", paramContext, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.DownloadStateChangedReceiver
 * JD-Core Version:    0.7.0.1
 */