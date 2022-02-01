package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

final class g
{
  private static long GlT = 125829120L;
  private static long GlU = 314572800L;
  private long GlV;
  private long GlW;
  private String GlX;
  private k GlY;
  au cLS;
  private boolean initialized;
  boolean qKm;
  
  public g(k paramk)
  {
    AppMethodBeat.i(32716);
    this.cLS = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32713);
        g.a(g.this, true);
        AppMethodBeat.o(32713);
        return true;
      }
    }, true);
    this.GlV = 0L;
    this.GlW = 0L;
    this.GlX = null;
    this.initialized = false;
    this.qKm = false;
    this.GlY = paramk;
    AppMethodBeat.o(32716);
  }
  
  public static boolean aKf(String paramString)
  {
    AppMethodBeat.i(32721);
    if (j.aKh(paramString) > GlT)
    {
      ac.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void eTd()
  {
    AppMethodBeat.i(32719);
    if (this.GlV + this.GlW > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.GlV);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.GlW);
      if (this.GlY.mContext != null) {
        this.qKm = ax.isWifi(this.GlY.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.qKm);
      if (this.GlY.mContext != null) {
        this.GlY.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long eTe()
  {
    AppMethodBeat.i(32722);
    eTd();
    if (bs.isNullOrNil(this.GlX))
    {
      ac.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = j.J(this.GlX, this.GlV, this.GlW);
    this.GlV = 0L;
    this.GlW = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  public final void fI(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.GlX)) {
      stop();
    }
    ac.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    ac.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(GlT) });
    GlT = Math.max(paramInt * 4, GlT);
    GlT = Math.min(GlU, GlT);
    ac.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(GlT) });
    if (!this.initialized)
    {
      if (this.GlY.mContext != null) {
        this.qKm = ax.isWifi(this.GlY.mContext);
      }
      this.cLS.au(30000L, 30000L);
      this.initialized = true;
      this.GlX = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    vF(true);
    this.cLS.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
  
  final void vF(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.GlV + this.GlW >= 524288L)) && (eTe() >= GlT) && (this.GlY.yCt == 2))
    {
      ac.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.GlY.cancel();
    }
    AppMethodBeat.o(32720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */