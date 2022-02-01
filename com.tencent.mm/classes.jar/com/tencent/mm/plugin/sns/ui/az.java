package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class az
{
  private BroadcastReceiver rhi;
  int vZZ;
  b xBW;
  
  public az()
  {
    AppMethodBeat.i(98916);
    this.rhi = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          ad.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = az.this.vZZ;
          az.this.vZZ = az.dBC();
          ad.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(az.this.vZZ) });
          if ((az.this.vZZ != i) && (az.this.xBW != null)) {
            az.this.xBW.dBD();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.vZZ = dBC();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    cvf();
    aj.getContext().registerReceiver(this.rhi, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int dBC()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!ay.isConnected(aj.getContext())) {
      i = a.xBY;
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
        i = a.xBZ;
      }
      else if (ay.is3G(aj.getContext()))
      {
        i = a.xCa;
      }
      else if (ay.is4G(aj.getContext()))
      {
        i = a.xCb;
      }
      else
      {
        ad.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.xCb;
      }
    }
  }
  
  public final boolean bVA()
  {
    return this.vZZ == a.WIFI;
  }
  
  public final void cvf()
  {
    AppMethodBeat.i(98918);
    try
    {
      aj.getContext().unregisterReceiver(this.rhi);
      AppMethodBeat.o(98918);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(98918);
    }
  }
  
  public final boolean dBB()
  {
    return (this.vZZ == a.xBZ) || (this.vZZ == a.xCa);
  }
  
  public static final class a
  {
    static int WIFI = 5;
    static int xBY = 1;
    static int xBZ = 2;
    static int xCa = 3;
    static int xCb = 4;
  }
  
  static abstract interface b
  {
    public abstract void dBD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az
 * JD-Core Version:    0.7.0.1
 */