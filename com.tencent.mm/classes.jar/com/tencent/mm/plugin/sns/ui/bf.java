package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class bf
{
  int CTg;
  b EGI;
  private BroadcastReceiver wOz;
  
  public bf()
  {
    AppMethodBeat.i(98916);
    this.wOz = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          Log.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = bf.this.CTg;
          bf.this.CTg = bf.fiw();
          Log.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(bf.this.CTg) });
          if ((bf.this.CTg != i) && (bf.this.EGI != null)) {
            bf.this.EGI.fix();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.CTg = fiw();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    dMu();
    MMApplicationContext.getContext().registerReceiver(this.wOz, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int fiw()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
      i = a.EGK;
    }
    for (;;)
    {
      Log.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(98917);
      return i;
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        i = a.WIFI;
      }
      else if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
      {
        i = a.EGL;
      }
      else if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
      {
        i = a.EGM;
      }
      else if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
      {
        i = a.EGN;
      }
      else
      {
        Log.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.EGN;
      }
    }
  }
  
  public final boolean cGF()
  {
    return this.CTg == a.WIFI;
  }
  
  public final void dMu()
  {
    AppMethodBeat.i(98918);
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.wOz);
      AppMethodBeat.o(98918);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(98918);
    }
  }
  
  public final boolean emf()
  {
    return (this.CTg == a.EGL) || (this.CTg == a.EGM);
  }
  
  public static final class a
  {
    static int EGK = 1;
    static int EGL = 2;
    static int EGM = 3;
    static int EGN = 4;
    static int WIFI = 5;
  }
  
  static abstract interface b
  {
    public abstract void fix();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf
 * JD-Core Version:    0.7.0.1
 */