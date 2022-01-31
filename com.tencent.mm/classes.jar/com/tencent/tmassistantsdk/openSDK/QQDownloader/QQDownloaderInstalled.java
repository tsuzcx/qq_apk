package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.util.TMLog;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  private static final String TAG = "QQDownloaderInstalled";
  protected static QQDownloaderInstalled mInstance = null;
  protected boolean isRegisted = false;
  protected QQDownloaderInstalled.IQQDownloaderInstalled mListener = null;
  
  public static QQDownloaderInstalled getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new QQDownloaderInstalled();
      }
      QQDownloaderInstalled localQQDownloaderInstalled = mInstance;
      return localQQDownloaderInstalled;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TMLog.i("QQDownloaderInstalled", "onReceive!");
    new QQDownloaderInstalled.1(this, paramContext).start();
  }
  
  public void registeListener(QQDownloaderInstalled.IQQDownloaderInstalled paramIQQDownloaderInstalled)
  {
    this.mListener = paramIQQDownloaderInstalled;
  }
  
  public void registeReceiver(Context paramContext)
  {
    if (!this.isRegisted) {
      TMLog.i("QQDownloaderInstalled", "registeReceiver   context" + paramContext + "  receiver:" + this);
    }
    try
    {
      this.isRegisted = true;
      return;
    }
    catch (Throwable paramContext)
    {
      TMLog.i("QQDownloaderInstalled", "registeReceiver exception!!!");
      this.isRegisted = false;
      y.printErrStackTrace("QQDownloaderInstalled", paramContext, "", new Object[0]);
    }
  }
  
  public void unRegisteReceiver(Context paramContext)
  {
    if ((paramContext == null) || (mInstance == null)) {}
    while (!this.isRegisted) {
      return;
    }
    TMLog.i("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      this.isRegisted = false;
      return;
    }
    catch (Throwable paramContext)
    {
      TMLog.i("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
      this.isRegisted = false;
      y.printErrStackTrace("QQDownloaderInstalled", paramContext, "", new Object[0]);
    }
  }
  
  public void unregisteListener()
  {
    this.mListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */