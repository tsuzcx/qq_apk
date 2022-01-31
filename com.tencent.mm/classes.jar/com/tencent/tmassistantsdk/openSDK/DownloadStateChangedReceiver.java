package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;

public class DownloadStateChangedReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "DownloadStateChangedReceiver";
  protected static DownloadStateChangedReceiver mInstance = null;
  protected ak handler;
  protected HandlerThread handlerThread;
  protected boolean isRegisted;
  ArrayList<IDownloadStateChangedListener> mListeners;
  
  public DownloadStateChangedReceiver()
  {
    AppMethodBeat.i(75840);
    this.handlerThread = new HandlerThread("downloadStateChangedThread");
    this.handler = null;
    this.isRegisted = false;
    this.mListeners = new ArrayList();
    this.handlerThread.start();
    this.handler = new ak(this.handlerThread.getLooper());
    AppMethodBeat.o(75840);
  }
  
  public static DownloadStateChangedReceiver getInstance()
  {
    try
    {
      AppMethodBeat.i(75841);
      if (mInstance == null) {
        mInstance = new DownloadStateChangedReceiver();
      }
      DownloadStateChangedReceiver localDownloadStateChangedReceiver = mInstance;
      AppMethodBeat.o(75841);
      return localDownloadStateChangedReceiver;
    }
    finally {}
  }
  
  public void addDownloadStateChangedListener(IDownloadStateChangedListener paramIDownloadStateChangedListener)
  {
    AppMethodBeat.i(75845);
    if ((paramIDownloadStateChangedListener != null) && (!this.mListeners.contains(paramIDownloadStateChangedListener))) {
      this.mListeners.add(paramIDownloadStateChangedListener);
    }
    AppMethodBeat.o(75845);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(75842);
    if (this.handler != null) {
      this.handler.post(new DownloadStateChangedReceiver.1(this, paramIntent));
    }
    AppMethodBeat.o(75842);
  }
  
  public void registeReceiver(Context paramContext)
  {
    AppMethodBeat.i(75843);
    if (!this.isRegisted)
    {
      TMLog.i("DownloadStateChangedReceiver", "registeReceiver   context" + paramContext + "  receiver:" + this);
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action");
      try
      {
        TMLog.i("DownloadStateChangedReceiver", String.valueOf(paramContext.registerReceiver(this, localIntentFilter)));
        this.isRegisted = true;
        AppMethodBeat.o(75843);
        return;
      }
      catch (Throwable paramContext)
      {
        TMLog.i("DownloadStateChangedReceiver", "registeReceiver exception!!!");
        this.isRegisted = false;
        ab.printErrStackTrace("DownloadStateChangedReceiver", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(75843);
  }
  
  public void removeDownloadStateChangedListener(IDownloadStateChangedListener paramIDownloadStateChangedListener)
  {
    AppMethodBeat.i(75846);
    if (paramIDownloadStateChangedListener != null) {
      this.mListeners.remove(paramIDownloadStateChangedListener);
    }
    AppMethodBeat.o(75846);
  }
  
  public void unRegisteReceiver(Context paramContext)
  {
    AppMethodBeat.i(75844);
    if ((paramContext == null) || (mInstance == null))
    {
      AppMethodBeat.o(75844);
      return;
    }
    if (this.isRegisted)
    {
      TMLog.i("DownloadStateChangedReceiver", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
      try
      {
        paramContext.unregisterReceiver(this);
        this.isRegisted = false;
        AppMethodBeat.o(75844);
        return;
      }
      catch (Throwable paramContext)
      {
        TMLog.i("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!");
        this.isRegisted = false;
        ab.printErrStackTrace("DownloadStateChangedReceiver", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(75844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.DownloadStateChangedReceiver
 * JD-Core Version:    0.7.0.1
 */