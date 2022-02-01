package io.flutter.plugins.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;

public class ConnectivityBroadcastReceiver
  extends BroadcastReceiver
  implements EventChannel.StreamHandler
{
  public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
  private Connectivity connectivity;
  private Context context;
  private EventChannel.EventSink events;
  private Handler mainHandler;
  private ConnectivityManager.NetworkCallback networkCallback;
  
  public ConnectivityBroadcastReceiver(Context paramContext, Connectivity paramConnectivity)
  {
    AppMethodBeat.i(189593);
    this.mainHandler = new Handler(Looper.getMainLooper());
    this.context = paramContext;
    this.connectivity = paramConnectivity;
    AppMethodBeat.o(189593);
  }
  
  private void sendEvent()
  {
    AppMethodBeat.i(189600);
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(189613);
        ConnectivityBroadcastReceiver.this.events.success(ConnectivityBroadcastReceiver.this.connectivity.getNetworkType());
        AppMethodBeat.o(189613);
      }
    };
    this.mainHandler.post(local2);
    AppMethodBeat.o(189600);
  }
  
  public ConnectivityManager.NetworkCallback getNetworkCallback()
  {
    return this.networkCallback;
  }
  
  public void onCancel(Object paramObject)
  {
    AppMethodBeat.i(189639);
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (this.networkCallback != null)
      {
        this.connectivity.getConnectivityManager().unregisterNetworkCallback(this.networkCallback);
        this.networkCallback = null;
        AppMethodBeat.o(189639);
      }
    }
    else {
      this.context.unregisterReceiver(this);
    }
    AppMethodBeat.o(189639);
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    AppMethodBeat.i(189630);
    this.events = paramEventSink;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.networkCallback = new ConnectivityManager.NetworkCallback()
      {
        public void onAvailable(Network paramAnonymousNetwork)
        {
          AppMethodBeat.i(189605);
          ConnectivityBroadcastReceiver.access$000(ConnectivityBroadcastReceiver.this);
          AppMethodBeat.o(189605);
        }
        
        public void onLost(Network paramAnonymousNetwork)
        {
          AppMethodBeat.i(189614);
          ConnectivityBroadcastReceiver.access$000(ConnectivityBroadcastReceiver.this);
          AppMethodBeat.o(189614);
        }
      };
      this.connectivity.getConnectivityManager().registerDefaultNetworkCallback(this.networkCallback);
      AppMethodBeat.o(189630);
      return;
    }
    this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(189630);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(189650);
    if (this.events != null) {
      this.events.success(this.connectivity.getNetworkType());
    }
    AppMethodBeat.o(189650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */