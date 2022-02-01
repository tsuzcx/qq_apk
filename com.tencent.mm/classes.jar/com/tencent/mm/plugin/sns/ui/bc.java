package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public final class bc
{
  b Axs;
  private BroadcastReceiver txv;
  int yPh;
  
  public bc()
  {
    AppMethodBeat.i(98916);
    this.txv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          ae.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = bc.this.yPh;
          bc.this.yPh = bc.efW();
          ae.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(bc.this.yPh) });
          if ((bc.this.yPh != i) && (bc.this.Axs != null)) {
            bc.this.Axs.efX();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.yPh = efW();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    cTl();
    ak.getContext().registerReceiver(this.txv, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int efW()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!az.isConnected(ak.getContext())) {
      i = a.Axu;
    }
    for (;;)
    {
      ae.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(98917);
      return i;
      if (az.isWifi(ak.getContext()))
      {
        i = a.WIFI;
      }
      else if (az.is2G(ak.getContext()))
      {
        i = a.Axv;
      }
      else if (az.is3G(ak.getContext()))
      {
        i = a.Axw;
      }
      else if (az.is4G(ak.getContext()))
      {
        i = a.Axx;
      }
      else
      {
        ae.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.Axx;
      }
    }
  }
  
  public final void cTl()
  {
    AppMethodBeat.i(98918);
    try
    {
      ak.getContext().unregisterReceiver(this.txv);
      AppMethodBeat.o(98918);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(98918);
    }
  }
  
  public final boolean ciH()
  {
    return this.yPh == a.WIFI;
  }
  
  public final boolean drZ()
  {
    return (this.yPh == a.Axv) || (this.yPh == a.Axw);
  }
  
  public static final class a
  {
    static int Axu = 1;
    static int Axv = 2;
    static int Axw = 3;
    static int Axx = 4;
    static int WIFI = 5;
  }
  
  static abstract interface b
  {
    public abstract void efX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc
 * JD-Core Version:    0.7.0.1
 */