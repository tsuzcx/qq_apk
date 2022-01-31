package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f
{
  private static long ucO = 125829120L;
  private static long ucP = 314572800L;
  am byQ = new am(new f.1(this), true);
  private boolean initialized = false;
  boolean kaC = false;
  private long ucQ = 0L;
  private long ucR = 0L;
  private String ucS = null;
  private j ucT;
  
  public f(j paramj)
  {
    this.ucT = paramj;
  }
  
  public static boolean YN(String paramString)
  {
    if (i.YP(paramString) > ucO)
    {
      y.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
      return true;
    }
    return false;
  }
  
  public final void dm(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return;
      if (!paramString.equals(this.ucS)) {
        stop();
      }
      y.i("MicroMsg.TrafficStatistic", "pack size: " + paramInt);
      y.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[] { Long.valueOf(ucO) });
      ucO = Math.max(paramInt * 4, ucO);
      ucO = Math.min(ucP, ucO);
      y.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[] { Long.valueOf(ucO) });
    } while (this.initialized);
    if (this.ucT.mContext != null) {
      this.kaC = aq.isWifi(this.ucT.mContext);
    }
    this.byQ.S(30000L, 30000L);
    this.initialized = true;
    this.ucS = paramString;
  }
  
  final void mp(boolean paramBoolean)
  {
    long l = 0L;
    if ((paramBoolean) || (this.ucQ + this.ucR >= 524288L))
    {
      if (this.ucQ + this.ucR > 0L)
      {
        Intent localIntent = new Intent();
        localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        localIntent.putExtra("intent_extra_flow_stat_upstream", this.ucQ);
        localIntent.putExtra("intent_extra_flow_stat_downstream", this.ucR);
        if (this.ucT.mContext != null) {
          this.kaC = aq.isWifi(this.ucT.mContext);
        }
        localIntent.putExtra("intent_extra_flow_stat_is_wifi", this.kaC);
        if (this.ucT.mContext != null) {
          this.ucT.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        }
      }
      if (!bk.bl(this.ucS)) {
        break label188;
      }
      y.e("MicroMsg.TrafficStatistic", "traffic is null!");
    }
    for (;;)
    {
      if ((l >= ucO) && (this.ucT.oRr == 2))
      {
        y.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
        this.ucT.cancel();
      }
      return;
      label188:
      l = i.x(this.ucS, this.ucQ, this.ucR);
      this.ucQ = 0L;
      this.ucR = 0L;
    }
  }
  
  public final void stop()
  {
    mp(true);
    this.byQ.stopTimer();
    this.initialized = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.f
 * JD-Core Version:    0.7.0.1
 */