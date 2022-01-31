package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver
  extends BroadcastReceiver
{
  protected static final int MSG_DELAY_TIME = 3500;
  protected static final int MSG_resumeDownloadTime = 67;
  protected static final String TAG = "NetworkMonitorReceiver";
  protected static NetworkMonitorReceiver mInstance = null;
  protected boolean isRegisterReceiver = false;
  protected final ah mNetworkChangedHandler = new NetworkMonitorReceiver.1(this);
  ArrayList<NetworkMonitorReceiver.INetworkChangedObserver> mObs = new ArrayList();
  
  public static NetworkMonitorReceiver getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = mInstance;
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public void addNetworkChangedObserver(NetworkMonitorReceiver.INetworkChangedObserver paramINetworkChangedObserver)
  {
    if ((!this.mObs.contains(paramINetworkChangedObserver)) && (paramINetworkChangedObserver != null)) {
      this.mObs.add(paramINetworkChangedObserver);
    }
  }
  
  public void notifyNetworkChanged()
  {
    Iterator localIterator = this.mObs.iterator();
    while (localIterator.hasNext()) {
      ((NetworkMonitorReceiver.INetworkChangedObserver)localIterator.next()).onNetworkChanged();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TMLog.i("NetworkMonitorReceiver", "network changed!");
    this.mNetworkChangedHandler.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    this.mNetworkChangedHandler.sendMessageDelayed(paramContext, 3500L);
  }
  
  public void registerReceiver()
  {
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.isRegisterReceiver = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.isRegisterReceiver = false;
      y.printErrStackTrace("NetworkMonitorReceiver", localThrowable, "", new Object[0]);
    }
  }
  
  public void removeNetworkChangedObserver(NetworkMonitorReceiver.INetworkChangedObserver paramINetworkChangedObserver)
  {
    if (paramINetworkChangedObserver != null) {
      this.mObs.remove(paramINetworkChangedObserver);
    }
  }
  
  public void unregisterReceiver()
  {
    if (mInstance == null) {}
    for (;;)
    {
      return;
      Context localContext = GlobalUtil.getInstance().getContext();
      if (localContext != null) {
        try
        {
          if (this.isRegisterReceiver)
          {
            localContext.unregisterReceiver(this);
            this.isRegisterReceiver = false;
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          y.printErrStackTrace("NetworkMonitorReceiver", localThrowable, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */