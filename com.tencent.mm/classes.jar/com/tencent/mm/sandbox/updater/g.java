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
  private static long acnX = 125829120L;
  private static long acnY = 314572800L;
  boolean Aey;
  private long acnZ;
  private long acoa;
  private String acob;
  private j acoc;
  private boolean initialized;
  MTimerHandler timer;
  
  public g(j paramj)
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
    this.acnZ = 0L;
    this.acoa = 0L;
    this.acob = null;
    this.initialized = false;
    this.Aey = false;
    this.acoc = paramj;
    AppMethodBeat.o(32716);
  }
  
  public static boolean buc(String paramString)
  {
    AppMethodBeat.i(32721);
    if (i.bue(paramString) > acnX)
    {
      Log.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      AppMethodBeat.o(32721);
      return true;
    }
    AppMethodBeat.o(32721);
    return false;
  }
  
  private void iSo()
  {
    AppMethodBeat.i(32719);
    if (this.acnZ + this.acoa > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
      localIntent.putExtra("intent_extra_flow_stat_upstream", this.acnZ);
      localIntent.putExtra("intent_extra_flow_stat_downstream", this.acoa);
      if (this.acoc.mContext != null) {
        this.Aey = NetStatusUtil.isWifi(this.acoc.mContext);
      }
      localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.Aey);
      if (this.acoc.mContext != null) {
        this.acoc.mContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      }
    }
    AppMethodBeat.o(32719);
  }
  
  private long iSp()
  {
    AppMethodBeat.i(32722);
    iSo();
    if (Util.isNullOrNil(this.acob))
    {
      Log.e("MicroMsg.TrafficStatistic", "traffic is null!");
      AppMethodBeat.o(32722);
      return 0L;
    }
    long l = i.Q(this.acob, this.acnZ, this.acoa);
    this.acnZ = 0L;
    this.acoa = 0L;
    AppMethodBeat.o(32722);
    return l;
  }
  
  final void Ks(boolean paramBoolean)
  {
    AppMethodBeat.i(32720);
    if (((paramBoolean) || (this.acnZ + this.acoa >= 524288L)) && (iSp() >= acnX) && (this.acoc.RgE == 2))
    {
      Log.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
      this.acoc.cancel();
    }
    AppMethodBeat.o(32720);
  }
  
  public final void iD(String paramString, int paramInt)
  {
    AppMethodBeat.i(32717);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32717);
      return;
    }
    if (!paramString.equals(this.acob)) {
      stop();
    }
    Log.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(paramInt)));
    Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(acnX) });
    acnX = Math.max(paramInt * 4, acnX);
    acnX = Math.min(acnY, acnX);
    Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(acnX) });
    if (!this.initialized)
    {
      if (this.acoc.mContext != null) {
        this.Aey = NetStatusUtil.isWifi(this.acoc.mContext);
      }
      this.timer.startTimer(30000L);
      this.initialized = true;
      this.acob = paramString;
    }
    AppMethodBeat.o(32717);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(32718);
    Ks(true);
    this.timer.stopTimer();
    this.initialized = false;
    AppMethodBeat.o(32718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.g
 * JD-Core Version:    0.7.0.1
 */