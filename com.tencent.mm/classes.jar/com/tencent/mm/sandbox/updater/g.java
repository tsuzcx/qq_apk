package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

final class g
{
  private static long HXG = 125829120L;
  private static long HXH = 314572800L;
  private long HXI;
  private long HXJ;
  private String HXK;
  private k HXL;
  av cXg;
  private boolean initialized;
  boolean ruo;
  
  public g(k paramk)
  {
    AppMethodBeat.i(32716);
    this.cXg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32713);
        g.a(g.this, true);
        AppMethodBeat.o(32713);
        return true;
      }
    }, true);
    this.HXI = 0L;
    this.HXJ = 0L;
    this.HXK = null;
    this.initialized = false;
    this.ruo = false;
    this.HXL = paramk;
    AppMethodBeat.o(32716);
  }
  
  public static boolean aPL(String paramString)
  {
    AppMethodBeat.i(32721);
    if (j.aPN(paramString) > HXG)
    {
      ad.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void fiF()
  {
    AppMethodBeat.i(32719);
    if (this.HXI + this.HXJ > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.HXI);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.HXJ);
      if (this.HXL.mContext != null) {
        this.ruo = ay.isWifi(this.HXL.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.ruo);
      if (this.HXL.mContext != null) {
        this.HXL.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long fiG()
  {
    AppMethodBeat.i(32722);
    fiF();
    if (bt.isNullOrNil(this.HXK))
    {
      ad.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = j.K(this.HXK, this.HXI, this.HXJ);
    this.HXI = 0L;
    this.HXJ = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  public final void gf(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.HXK)) {
      stop();
    }
    ad.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    ad.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(HXG) });
    HXG = Math.max(paramInt * 4, HXG);
    HXG = Math.min(HXH, HXG);
    ad.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(HXG) });
    if (!this.initialized)
    {
      if (this.HXL.mContext != null) {
        this.ruo = ay.isWifi(this.HXL.mContext);
      }
      this.cXg.az(30000L, 30000L);
      this.initialized = true;
      this.HXK = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    wr(true);
    this.cXg.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
  
  final void wr(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.HXI + this.HXJ >= 524288L)) && (fiG() >= HXG) && (this.HXL.zTO == 2))
    {
      ad.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.HXL.cancel();
    }
    AppMethodBeat.o(32720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */