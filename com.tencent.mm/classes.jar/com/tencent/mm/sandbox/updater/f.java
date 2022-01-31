package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class f
{
  private static long yld = 125829120L;
  private static long yle = 314572800L;
  ap caS;
  private boolean initialized;
  boolean muY;
  private long ylf;
  private long ylg;
  private String ylh;
  private j yli;
  
  public f(j paramj)
  {
    AppMethodBeat.i(28902);
    this.caS = new ap(new f.1(this), true);
    this.ylf = 0L;
    this.ylg = 0L;
    this.ylh = null;
    this.initialized = false;
    this.muY = false;
    this.yli = paramj;
    AppMethodBeat.o(28902);
  }
  
  public static boolean aoL(String paramString)
  {
    AppMethodBeat.i(28907);
    if (i.aoN(paramString) > yld)
    {
      ab.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(28907);
      return true;
    }
    AppMethodBeat.o(28907);
    return false;
  }
  
  private void drG()
  {
    AppMethodBeat.i(28905);
    if (this.ylf + this.ylg > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.ylf);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.ylg);
      if (this.yli.mContext != null) {
        this.muY = at.isWifi(this.yli.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.muY);
      if (this.yli.mContext != null) {
        this.yli.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      }
    }
    AppMethodBeat.o(28905);
  }
  
  private long drH()
  {
    AppMethodBeat.i(28908);
    drG();
    if (bo.isNullOrNil(this.ylh))
    {
      ab.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(28908);
      return 0L;
    }
    long l = i.F(this.ylh, this.ylf, this.ylg);
    this.ylf = 0L;
    this.ylg = 0L;
    AppMethodBeat.o(28908);
    return l;
  }
  
  public final void es(String paramString, int paramInt)
  {
    AppMethodBeat.i(28903);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28903);
      return;
    }
    if (!paramString.equals(this.ylh)) {
      stop();
    }
    ab.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    ab.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(yld) });
    yld = Math.max(paramInt * 4, yld);
    yld = Math.min(yle, yld);
    ab.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(yld) });
    if (!this.initialized)
    {
      if (this.yli.mContext != null) {
        this.muY = at.isWifi(this.yli.mContext);
      }
      this.caS.ag(30000L, 30000L);
      this.initialized = true;
      this.ylh = paramString;
    }
    AppMethodBeat.o(28903);
  }
  
  final void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(28906);
    if (((paramBoolean) || (this.ylf + this.ylg >= 524288L)) && (drH() >= yld) && (this.yli.rJd == 2))
    {
      ab.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.yli.cancel();
    }
    AppMethodBeat.o(28906);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(28904);
    pE(true);
    this.caS.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(28904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */