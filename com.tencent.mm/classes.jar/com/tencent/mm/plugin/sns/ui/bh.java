package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class bh
{
  int IYy;
  b KUC;
  private BroadcastReceiver KUD;
  
  public bh()
  {
    AppMethodBeat.i(98916);
    this.KUD = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          Log.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = bh.this.IYy;
          bh.this.IYy = bh.fWI();
          Log.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(bh.this.IYy) });
          if ((bh.this.IYy != i) && (bh.this.KUC != null)) {
            bh.this.KUC.fWK();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.IYy = fWI();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    fWJ();
    MMApplicationContext.getContext().registerReceiver(this.KUD, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int fWI()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
      i = a.KUF;
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
        i = a.KUG;
      }
      else if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
      {
        i = a.KUH;
      }
      else if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
      {
        i = a.KUI;
      }
      else
      {
        Log.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.KUI;
      }
    }
  }
  
  public final boolean eVU()
  {
    return (this.IYy == a.KUG) || (this.IYy == a.KUH);
  }
  
  public final boolean eqb()
  {
    return this.IYy == a.WIFI;
  }
  
  public final void fWJ()
  {
    AppMethodBeat.i(98918);
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.KUD);
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
    static int KUF = 1;
    static int KUG = 2;
    static int KUH = 3;
    static int KUI = 4;
    static int WIFI = 5;
  }
  
  static abstract interface b
  {
    public abstract void fWK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh
 * JD-Core Version:    0.7.0.1
 */