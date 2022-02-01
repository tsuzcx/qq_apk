package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
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
  protected final ao mNetworkChangedHandler;
  ArrayList<INetworkChangedObserver> mObs;
  
  public NetworkMonitorReceiver()
  {
    AppMethodBeat.i(102017);
    this.isRegisterReceiver = false;
    this.mNetworkChangedHandler = new ao()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(102016);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102016);
          return;
          NetworkMonitorReceiver.this.notifyNetworkChanged();
        }
      }
    };
    this.mObs = new ArrayList();
    AppMethodBeat.o(102017);
  }
  
  public static NetworkMonitorReceiver getInstance()
  {
    try
    {
      AppMethodBeat.i(102018);
      if (mInstance == null) {
        mInstance = new NetworkMonitorReceiver();
      }
      NetworkMonitorReceiver localNetworkMonitorReceiver = mInstance;
      AppMethodBeat.o(102018);
      return localNetworkMonitorReceiver;
    }
    finally {}
  }
  
  public void addNetworkChangedObserver(INetworkChangedObserver paramINetworkChangedObserver)
  {
    AppMethodBeat.i(102022);
    if ((!this.mObs.contains(paramINetworkChangedObserver)) && (paramINetworkChangedObserver != null)) {
      this.mObs.add(paramINetworkChangedObserver);
    }
    AppMethodBeat.o(102022);
  }
  
  public void notifyNetworkChanged()
  {
    AppMethodBeat.i(102024);
    Iterator localIterator = this.mObs.iterator();
    while (localIterator.hasNext()) {
      ((INetworkChangedObserver)localIterator.next()).onNetworkChanged();
    }
    AppMethodBeat.o(102024);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(102019);
    TMLog.i("NetworkMonitorReceiver", "network changed!");
    this.mNetworkChangedHandler.removeMessages(67);
    paramContext = Message.obtain();
    paramContext.what = 67;
    this.mNetworkChangedHandler.sendMessageDelayed(paramContext, 3500L);
    AppMethodBeat.o(102019);
  }
  
  public void registerReceiver()
  {
    AppMethodBeat.i(102020);
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(102020);
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      localContext.registerReceiver(this, localIntentFilter);
      this.isRegisterReceiver = true;
      AppMethodBeat.o(102020);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.isRegisterReceiver = false;
      ac.printErrStackTrace("NetworkMonitorReceiver", localThrowable, "", new Object[0]);
      AppMethodBeat.o(102020);
    }
  }
  
  public void removeNetworkChangedObserver(INetworkChangedObserver paramINetworkChangedObserver)
  {
    AppMethodBeat.i(102023);
    if (paramINetworkChangedObserver != null) {
      this.mObs.remove(paramINetworkChangedObserver);
    }
    AppMethodBeat.o(102023);
  }
  
  public void unregisterReceiver()
  {
    AppMethodBeat.i(102021);
    if (mInstance == null)
    {
      AppMethodBeat.o(102021);
      return;
    }
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext == null)
    {
      AppMethodBeat.o(102021);
      return;
    }
    try
    {
      if (this.isRegisterReceiver)
      {
        localContext.unregisterReceiver(this);
        this.isRegisterReceiver = false;
      }
      AppMethodBeat.o(102021);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("NetworkMonitorReceiver", localThrowable, "", new Object[0]);
      AppMethodBeat.o(102021);
    }
  }
  
  public static abstract interface INetworkChangedObserver
  {
    public abstract void onNetworkChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */