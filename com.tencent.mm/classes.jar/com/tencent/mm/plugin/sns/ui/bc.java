package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class bc
{
  b Agg;
  private BroadcastReceiver tmD;
  int yzh;
  
  public bc()
  {
    AppMethodBeat.i(98916);
    this.tmD = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          ad.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = bc.this.yzh;
          bc.this.yzh = bc.ecp();
          ad.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(bc.this.yzh) });
          if ((bc.this.yzh != i) && (bc.this.Agg != null)) {
            bc.this.Agg.ecq();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.yzh = ecp();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    cQG();
    aj.getContext().registerReceiver(this.tmD, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int ecp()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!ay.isConnected(aj.getContext())) {
      i = a.Agi;
    }
    for (;;)
    {
      ad.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(98917);
      return i;
      if (ay.isWifi(aj.getContext()))
      {
        i = a.WIFI;
      }
      else if (ay.is2G(aj.getContext()))
      {
        i = a.Agj;
      }
      else if (ay.is3G(aj.getContext()))
      {
        i = a.Agk;
      }
      else if (ay.is4G(aj.getContext()))
      {
        i = a.Agl;
      }
      else
      {
        ad.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.Agl;
      }
    }
  }
  
  public final void cQG()
  {
    AppMethodBeat.i(98918);
    try
    {
      aj.getContext().unregisterReceiver(this.tmD);
      AppMethodBeat.o(98918);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(98918);
    }
  }
  
  public final boolean chr()
  {
    return this.yzh == a.WIFI;
  }
  
  public final boolean doP()
  {
    return (this.yzh == a.Agj) || (this.yzh == a.Agk);
  }
  
  public static final class a
  {
    static int Agi = 1;
    static int Agj = 2;
    static int Agk = 3;
    static int Agl = 4;
    static int WIFI = 5;
  }
  
  static abstract interface b
  {
    public abstract void ecq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc
 * JD-Core Version:    0.7.0.1
 */