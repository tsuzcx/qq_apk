package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;

public final class bi
{
  int PhY;
  b RuA;
  private BroadcastReceiver RuB;
  
  public bi()
  {
    AppMethodBeat.i(98916);
    this.RuB = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          Log.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = bi.this.PhY;
          bi.this.PhY = bi.hoZ();
          Log.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(bi.this.PhY) });
          if ((bi.this.PhY != i) && (bi.this.RuA != null)) {
            bi.this.RuA.hpb();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.PhY = hoZ();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    hpa();
    MMApplicationContext.getContext().registerReceiver(this.RuB, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int hoZ()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!NetStatusUtil.isConnected(NetworkCache.INSTANCE.getActiveNetworkInfoFromCache(MMApplicationContext.getContext()))) {
      i = a.RuD;
    }
    for (;;)
    {
      Log.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(98917);
      return i;
      if (NetStatusUtil.isWifiFromCache(MMApplicationContext.getContext()))
      {
        i = a.WIFI;
      }
      else if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
      {
        i = a.RuE;
      }
      else if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
      {
        i = a.RuF;
      }
      else if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
      {
        i = a.RuG;
      }
      else
      {
        Log.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.RuG;
      }
    }
  }
  
  public final boolean fvi()
  {
    return this.PhY == a.WIFI;
  }
  
  public final boolean geL()
  {
    return (this.PhY == a.RuE) || (this.PhY == a.RuF);
  }
  
  public final void hpa()
  {
    AppMethodBeat.i(98918);
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.RuB);
      AppMethodBeat.o(98918);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(98918);
    }
  }
  
  public static final class a
  {
    static int RuD = 1;
    static int RuE = 2;
    static int RuF = 3;
    static int RuG = 4;
    static int WIFI = 5;
  }
  
  static abstract interface b
  {
    public abstract void hpb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bi
 * JD-Core Version:    0.7.0.1
 */