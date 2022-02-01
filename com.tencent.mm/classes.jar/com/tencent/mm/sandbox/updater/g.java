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
  private static long NFm = 125829120L;
  private static long NFn = 314572800L;
  private long NFo;
  private long NFp;
  private String NFq;
  private k NFr;
  private boolean initialized;
  boolean tcf;
  MTimerHandler timer;
  
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
    this.NFo = 0L;
    this.NFp = 0L;
    this.NFq = null;
    this.initialized = false;
    this.tcf = false;
    this.NFr = paramk;
    AppMethodBeat.o(32716);
  }
  
  public static boolean bhL(String paramString)
  {
    AppMethodBeat.i(32721);
    if (j.bhN(paramString) > NFm)
    {
      Log.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void gwk()
  {
    AppMethodBeat.i(32719);
    if (this.NFo + this.NFp > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.NFo);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.NFp);
      if (this.NFr.mContext != null) {
        this.tcf = NetStatusUtil.isWifi(this.NFr.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.tcf);
      if (this.NFr.mContext != null) {
        this.NFr.mContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long gwl()
  {
    AppMethodBeat.i(32722);
    gwk();
    if (Util.isNullOrNil(this.NFq))
    {
      Log.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = j.L(this.NFq, this.NFo, this.NFp);
    this.NFo = 0L;
    this.NFp = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  final void Az(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.NFo + this.NFp >= 524288L)) && (gwl() >= NFm) && (this.NFr.EtH == 2))
    {
      Log.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.NFr.cancel();
    }
    AppMethodBeat.o(32720);
  }
  
  public final void gM(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.NFq)) {
      stop();
    }
    Log.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(NFm) });
    NFm = Math.max(paramInt * 4, NFm);
    NFm = Math.min(NFn, NFm);
    Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(NFm) });
    if (!this.initialized)
    {
      if (this.NFr.mContext != null) {
        this.tcf = NetStatusUtil.isWifi(this.NFr.mContext);
      }
      this.timer.startTimer(30000L);
      this.initialized = true;
      this.NFq = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    Az(true);
    this.timer.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */