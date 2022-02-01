package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

final class g
{
  private static long USL = 125829120L;
  private static long USM = 314572800L;
  private long USN;
  private long USO;
  private String USP;
  private k USQ;
  private boolean initialized;
  MTimerHandler timer;
  boolean wIk;
  
  public g(k paramk)
  {
    AppMethodBeat.i(32716);
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(32713);
        g.a(g.this, true);
        AppMethodBeat.o(32713);
        return true;
      }
    }, true);
    this.USN = 0L;
    this.USO = 0L;
    this.USP = null;
    this.initialized = false;
    this.wIk = false;
    this.USQ = paramk;
    AppMethodBeat.o(32716);
  }
  
  public static boolean bud(String paramString)
  {
    AppMethodBeat.i(32721);
    if (j.buf(paramString) > USL)
    {
      Log.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void hsj()
  {
    AppMethodBeat.i(32719);
    if (this.USN + this.USO > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.USN);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.USO);
      if (this.USQ.mContext != null) {
        this.wIk = NetStatusUtil.isWifi(this.USQ.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.wIk);
      if (this.USQ.mContext != null) {
        this.USQ.mContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long hsk()
  {
    AppMethodBeat.i(32722);
    hsj();
    if (Util.isNullOrNil(this.USP))
    {
      Log.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = j.K(this.USP, this.USN, this.USO);
    this.USN = 0L;
    this.USO = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  final void EG(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.USN + this.USO >= 524288L)) && (hsk() >= USL) && (this.USQ.KHe == 2))
    {
      Log.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.USQ.cancel();
    }
    AppMethodBeat.o(32720);
  }
  
  public final void hv(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.USP)) {
      stop();
    }
    Log.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(USL) });
    USL = Math.max(paramInt * 4, USL);
    USL = Math.min(USM, USL);
    Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(USL) });
    if (!this.initialized)
    {
      if (this.USQ.mContext != null) {
        this.wIk = NetStatusUtil.isWifi(this.USQ.mContext);
      }
      this.timer.startTimer(30000L);
      this.initialized = true;
      this.USP = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    EG(true);
    this.timer.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */