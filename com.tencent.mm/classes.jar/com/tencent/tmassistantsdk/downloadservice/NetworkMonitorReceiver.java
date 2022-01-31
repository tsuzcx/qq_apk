package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
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
  protected boolean isRegisterReceiver;
  protected final ak mNetworkChangedHandler;
  ArrayList<NetworkMonitorReceiver.INetworkChangedObserver> mObs;
  
  public NetworkMonitorReceiver()
  {
    AppMethodBeat.i(75771);
    this.isRegisterReceiver = false;
    this.mNetworkChangedHandler = new NetworkMonitorReceiver.1(this);
    this.mObs = new ArrayList();
    AppMethodBeat.o(75771);
  }
  
  public static NetworkMonitorReceiver getInstance()
  {
    try
    {
      AppMethodBeat.i(75772);
      if (mInstance == null) {
        mInstance = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = mInstance;
      AppMethodBeat.o(75772);
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public void addNetworkChangedObserver(NetworkMonitorReceiver.INetworkChangedObserver paramINetworkChangedObserver)
  {
    AppMethodBeat.i(75776);
    if ((!this.mObs.contains(paramINetworkChangedObserver)) && (paramINetworkChangedObserver != null)) {
      this.mObs.add(paramINetworkChangedObserver);
    }
    AppMethodBeat.o(75776);
  }
  
  public void notifyNetworkChanged()
  {
    AppMethodBeat.i(75778);
    Iterator localIterator = this.mObs.iterator();
    while (localIterator.hasNext()) {
      ((NetworkMonitorReceiver.INetworkChangedObserver)localIterator.next()).onNetworkChanged();
    }
    AppMethodBeat.o(75778);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(75773);
    TMLog.i("NetworkMonitorReceiver", "network changed!");
    this.mNetworkChangedHandler.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    this.mNetworkChangedHandler.sendMessageDelayed(paramContext, 3500L);
    AppMethodBeat.o(75773);
  }
  
  public void registerReceiver()
  {
    AppMethodBeat.i(75774);
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(75774);
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.isRegisterReceiver = true;
      AppMethodBeat.o(75774);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.isRegisterReceiver = false;
      ab.printErrStackTrace("NetworkMonitorReceiver", localThrowable, "", new Object[0]);
      AppMethodBeat.o(75774);
    }
  }
  
  public void removeNetworkChangedObserver(NetworkMonitorReceiver.INetworkChangedObserver paramINetworkChangedObserver)
  {
    AppMethodBeat.i(75777);
    if (paramINetworkChangedObserver != null) {
      this.mObs.remove(paramINetworkChangedObserver);
    }
    AppMethodBeat.o(75777);
  }
  
  public void unregisterReceiver()
  {
    AppMethodBeat.i(75775);
    if (mInstance == null)
    {
      AppMethodBeat.o(75775);
      return;
    }
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(75775);
      return;
    }
    try
    {
      if (this.isRegisterReceiver)
      {
        localContext.unregisterReceiver(this);
        this.isRegisterReceiver = false;
      }
      AppMethodBeat.o(75775);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("NetworkMonitorReceiver", localThrowable, "", new Object[0]);
      AppMethodBeat.o(75775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */