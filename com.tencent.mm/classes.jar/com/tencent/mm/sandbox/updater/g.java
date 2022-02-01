package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

final class g
{
  private static long IrN = 125829120L;
  private static long IrO = 314572800L;
  private long IrP;
  private long IrQ;
  private String IrR;
  private k IrS;
  aw cYd;
  private boolean initialized;
  boolean rCA;
  
  public g(k paramk)
  {
    AppMethodBeat.i(32716);
    this.cYd = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32713);
        g.a(g.this, true);
        AppMethodBeat.o(32713);
        return true;
      }
    }, true);
    this.IrP = 0L;
    this.IrQ = 0L;
    this.IrR = null;
    this.initialized = false;
    this.rCA = false;
    this.IrS = paramk;
    AppMethodBeat.o(32716);
  }
  
  public static boolean aRi(String paramString)
  {
    AppMethodBeat.i(32721);
    if (j.aRk(paramString) > IrN)
    {
      ae.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void fmx()
  {
    AppMethodBeat.i(32719);
    if (this.IrP + this.IrQ > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.IrP);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.IrQ);
      if (this.IrS.mContext != null) {
        this.rCA = az.isWifi(this.IrS.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.rCA);
      if (this.IrS.mContext != null) {
        this.IrS.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long fmy()
  {
    AppMethodBeat.i(32722);
    fmx();
    if (bu.isNullOrNil(this.IrR))
    {
      ae.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = j.K(this.IrR, this.IrP, this.IrQ);
    this.IrP = 0L;
    this.IrQ = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  public final void go(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.IrR)) {
      stop();
    }
    ae.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    ae.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(IrN) });
    IrN = Math.max(paramInt * 4, IrN);
    IrN = Math.min(IrO, IrN);
    ae.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(IrN) });
    if (!this.initialized)
    {
      if (this.IrS.mContext != null) {
        this.rCA = az.isWifi(this.IrS.mContext);
      }
      this.cYd.ay(30000L, 30000L);
      this.initialized = true;
      this.IrR = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    wz(true);
    this.cYd.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
  
  final void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.IrP + this.IrQ >= 524288L)) && (fmy() >= IrN) && (this.IrS.AkV == 2))
    {
      ae.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.IrS.cancel();
    }
    AppMethodBeat.o(32720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */