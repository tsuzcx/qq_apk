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
  private static long EOG = 125829120L;
  private static long EOH = 314572800L;
  private long EOI;
  private long EOJ;
  private String EOK;
  private k EOL;
  av cOx;
  private boolean initialized;
  boolean qbG;
  
  public g(k paramk)
  {
    AppMethodBeat.i(32716);
    this.cOx = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32713);
        g.a(g.this, true);
        AppMethodBeat.o(32713);
        return true;
      }
    }, true);
    this.EOI = 0L;
    this.EOJ = 0L;
    this.EOK = null;
    this.initialized = false;
    this.qbG = false;
    this.EOL = paramk;
    AppMethodBeat.o(32716);
  }
  
  public static boolean aEO(String paramString)
  {
    AppMethodBeat.i(32721);
    if (j.aEQ(paramString) > EOG)
    {
      ad.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void eDJ()
  {
    AppMethodBeat.i(32719);
    if (this.EOI + this.EOJ > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.EOI);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.EOJ);
      if (this.EOL.mContext != null) {
        this.qbG = ay.isWifi(this.EOL.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.qbG);
      if (this.EOL.mContext != null) {
        this.EOL.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long eDK()
  {
    AppMethodBeat.i(32722);
    eDJ();
    if (bt.isNullOrNil(this.EOK))
    {
      ad.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = j.L(this.EOK, this.EOI, this.EOJ);
    this.EOI = 0L;
    this.EOJ = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  public final void fD(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.EOK)) {
      stop();
    }
    ad.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    ad.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(EOG) });
    EOG = Math.max(paramInt * 4, EOG);
    EOG = Math.min(EOH, EOG);
    ad.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(EOG) });
    if (!this.initialized)
    {
      if (this.EOL.mContext != null) {
        this.qbG = ay.isWifi(this.EOL.mContext);
      }
      this.cOx.av(30000L, 30000L);
      this.initialized = true;
      this.EOK = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    uD(true);
    this.cOx.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
  
  final void uD(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.EOI + this.EOJ >= 524288L)) && (eDK() >= EOG) && (this.EOL.xpD == 2))
    {
      ad.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.EOL.cancel();
    }
    AppMethodBeat.o(32720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */