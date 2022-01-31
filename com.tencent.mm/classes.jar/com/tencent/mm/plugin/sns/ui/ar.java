package com.tencent.mm.plugin.sns.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class ar
{
  private BroadcastReceiver mKc;
  int qCf;
  ar.b rTu;
  
  public ar()
  {
    AppMethodBeat.i(155730);
    this.mKc = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(155729);
        if (paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          ab.i("MicroMsg.Sns.SnsNetworkMgr", "connChangedBroadcastReceiver");
          int i = ar.this.qCf;
          ar.this.qCf = ar.cvE();
          ab.i("MicroMsg.Sns.SnsNetworkMgr", "network change current:%s change:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(ar.this.qCf) });
          if ((ar.this.qCf != i) && (ar.this.rTu != null)) {
            ar.this.rTu.cvF();
          }
        }
        AppMethodBeat.o(155729);
      }
    };
    this.qCf = cvE();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    bzQ();
    ah.getContext().registerReceiver(this.mKc, localIntentFilter);
    AppMethodBeat.o(155730);
  }
  
  static int cvE()
  {
    AppMethodBeat.i(155731);
    int i;
    if (!at.isConnected(ah.getContext())) {
      i = ar.a.rTw;
    }
    for (;;)
    {
      ab.i("MicroMsg.Sns.SnsNetworkMgr", "currentNetworkStatus:%s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155731);
      return i;
      if (at.isWifi(ah.getContext()))
      {
        i = ar.a.WIFI;
      }
      else if (at.is2G(ah.getContext()))
      {
        i = ar.a.rTx;
      }
      else if (at.is3G(ah.getContext()))
      {
        i = ar.a.rTy;
      }
      else if (at.is4G(ah.getContext()))
      {
        i = ar.a.rTz;
      }
      else
      {
        ab.i("MicroMsg.Sns.SnsNetworkMgr", "failed and return 4g");
        i = ar.a.rTz;
      }
    }
  }
  
  public final boolean bTw()
  {
    return (this.qCf == ar.a.rTx) || (this.qCf == ar.a.rTy);
  }
  
  public final boolean blP()
  {
    return this.qCf == ar.a.WIFI;
  }
  
  public final void bzQ()
  {
    AppMethodBeat.i(155732);
    try
    {
      ah.getContext().unregisterReceiver(this.mKc);
      AppMethodBeat.o(155732);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(155732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */