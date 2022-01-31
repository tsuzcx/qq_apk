package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class VoipMgr$NetChangedBroadcastReceiver
  extends BroadcastReceiver
{
  public VoipMgr$NetChangedBroadcastReceiver(VoipMgr paramVoipMgr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(4484);
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      switch (a.getNetType(paramContext))
      {
      }
      do
      {
        do
        {
          AppMethodBeat.o(4484);
          return;
        } while (VoipMgr.k(this.tyo) == 5);
        j = VoipMgr.cNo()[1];
        if (VoipMgr.l(this.tyo) == 0) {
          VoipMgr.c(this.tyo, 4);
        }
        k = VoipMgr.cNp() / VoipMgr.l(this.tyo);
        VoipMgr.c(this.tyo, 5);
        m = VoipMgr.cNo()[0];
        ab.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.m(this.tyo));
        if (VoipMgr.b(this.tyo)) {}
        for (;;)
        {
          a.a(i, System.currentTimeMillis(), VoipMgr.k(this.tyo), 5, j, m, k);
          VoipMgr.n(this.tyo);
          VoipMgr.d(this.tyo, 5);
          VoipMgr.cNq();
          VoipMgr.o(this.tyo);
          AppMethodBeat.o(4484);
          return;
          i = 1;
        }
      } while (VoipMgr.k(this.tyo) == 4);
      int k = VoipMgr.cNo()[0];
      if (VoipMgr.l(this.tyo) == 0) {
        VoipMgr.c(this.tyo, 5);
      }
      int m = VoipMgr.cNp() / VoipMgr.l(this.tyo);
      VoipMgr.c(this.tyo, 4);
      int n = VoipMgr.cNo()[1];
      ab.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.m(this.tyo));
      if (VoipMgr.b(this.tyo)) {}
      for (i = j;; i = 1)
      {
        a.a(i, System.currentTimeMillis(), VoipMgr.k(this.tyo), 4, k, n, m);
        VoipMgr.n(this.tyo);
        VoipMgr.d(this.tyo, 4);
        VoipMgr.cNq();
        VoipMgr.o(this.tyo);
        break;
      }
    }
    if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (VoipMgr.p(this.tyo) == 0L))
    {
      VoipMgr.a(this.tyo, System.currentTimeMillis());
      AppMethodBeat.o(4484);
      return;
    }
    if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (VoipMgr.p(this.tyo) != 0L))
    {
      VoipMgr.b(this.tyo, System.currentTimeMillis() - VoipMgr.p(this.tyo));
      VoipMgr.a(this.tyo, 0L);
    }
    AppMethodBeat.o(4484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.NetChangedBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */