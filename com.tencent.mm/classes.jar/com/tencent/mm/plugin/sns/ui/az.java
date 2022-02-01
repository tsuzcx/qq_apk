package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class az
{
  private BroadcastReceiver sqa;
  int xlf;
  b yOK;
  
  public az()
  {
    AppMethodBeat.i(98916);
    this.sqa = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(98915);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          ac.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = az.this.xlf;
          az.this.xlf = az.dPZ();
          ac.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(az.this.xlf) });
          if ((az.this.xlf != i) && (az.this.yOK != null)) {
            az.this.yOK.dQa();
          }
        }
        AppMethodBeat.o(98915);
      }
    };
    this.xlf = dPZ();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    cIr();
    ai.getContext().registerReceiver(this.sqa, localIntentFilter);
    AppMethodBeat.o(98916);
  }
  
  static int dPZ()
  {
    AppMethodBeat.i(98917);
    int i;
    if (!ax.isConnected(ai.getContext())) {
      i = a.yOM;
    }
    for (;;)
    {
      ac.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(98917);
      return i;
      if (ax.isWifi(ai.getContext()))
      {
        i = a.WIFI;
      }
      else if (ax.is2G(ai.getContext()))
      {
        i = a.yON;
      }
      else if (ax.is3G(ai.getContext()))
      {
        i = a.yOO;
      }
      else if (ax.is4G(ai.getContext()))
      {
        i = a.yOP;
      }
      else
      {
        ac.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = a.yOP;
      }
    }
  }
  
  public final void cIr()
  {
    AppMethodBeat.i(98918);
    try
    {
      ai.getContext().unregisterReceiver(this.sqa);
      AppMethodBeat.o(98918);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(98918);
    }
  }
  
  public final boolean ccN()
  {
    return this.xlf == a.WIFI;
  }
  
  public final boolean dPY()
  {
    return (this.xlf == a.yON) || (this.xlf == a.yOO);
  }
  
  public static final class a
  {
    static int WIFI = 5;
    static int yOM = 1;
    static int yON = 2;
    static int yOO = 3;
    static int yOP = 4;
  }
  
  static abstract interface b
  {
    public abstract void dQa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az
 * JD-Core Version:    0.7.0.1
 */