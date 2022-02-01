package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.tmassistantsdk.util.TMLog;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  private static final String TAG = "QQDownloaderInstalled";
  protected static QQDownloaderInstalled mInstance = null;
  protected boolean isRegisted = false;
  protected IQQDownloaderInstalled mListener = null;
  
  public static QQDownloaderInstalled getInstance()
  {
    try
    {
      AppMethodBeat.i(102098);
      if (mInstance == null) {
        mInstance = new QQDownloaderInstalled();
      }
      QQDownloaderInstalled localQQDownloaderInstalled = mInstance;
      AppMethodBeat.o(102098);
      return localQQDownloaderInstalled;
    }
    finally {}
  }
  
  public void onReceive(final Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(102099);
    TMLog.i("QQDownloaderInstalled", "onReceive!");
    h.ahAA.bp(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(102097);
        if (QQDownloaderInstalled.this.mListener != null) {
          QQDownloaderInstalled.this.mListener.onQQDownloaderInstalled(paramContext);
        }
        AppMethodBeat.o(102097);
      }
    });
    AppMethodBeat.o(102099);
  }
  
  public void registeListener(IQQDownloaderInstalled paramIQQDownloaderInstalled)
  {
    this.mListener = paramIQQDownloaderInstalled;
  }
  
  public void registeReceiver(Context paramContext)
  {
    AppMethodBeat.i(102100);
    if (!this.isRegisted)
    {
      TMLog.i("QQDownloaderInstalled", "registeReceiver   context" + paramContext + "  receiver:" + this);
      try
      {
        this.isRegisted = true;
        AppMethodBeat.o(102100);
        return;
      }
      finally
      {
        TMLog.i("QQDownloaderInstalled", "registeReceiver exception!!!");
        this.isRegisted = false;
        Log.printErrStackTrace("QQDownloaderInstalled", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(102100);
  }
  
  public void unRegisteReceiver(Context paramContext)
  {
    AppMethodBeat.i(102101);
    if ((paramContext == null) || (mInstance == null))
    {
      AppMethodBeat.o(102101);
      return;
    }
    if (this.isRegisted)
    {
      TMLog.i("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
      try
      {
        this.isRegisted = false;
        AppMethodBeat.o(102101);
        return;
      }
      finally
      {
        TMLog.i("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
        this.isRegisted = false;
        Log.printErrStackTrace("QQDownloaderInstalled", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(102101);
  }
  
  public void unregisteListener()
  {
    this.mListener = null;
  }
  
  public static abstract interface IQQDownloaderInstalled
  {
    public abstract void onQQDownloaderInstalled(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */