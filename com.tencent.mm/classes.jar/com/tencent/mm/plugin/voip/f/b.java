package com.tencent.mm.plugin.voip.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.d.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "maxBatteryTemperature", "Lkotlin/Pair;", "", "minBatteryTemperature", "startMillis", "getBatteryInfo", "", "getBatteryTemperature", "context", "Landroid/content/Context;", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a ULb;
  private r<Integer, Long> ULc;
  private r<Integer, Long> ULd;
  private long ULe;
  private MMHandler handler;
  private long wOh;
  private boolean wOi;
  private final BatteryManager wOj;
  
  static
  {
    AppMethodBeat.i(292674);
    ULb = new b.a((byte)0);
    AppMethodBeat.o(292674);
  }
  
  public b()
  {
    AppMethodBeat.i(292637);
    Object localObject = MMApplicationContext.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(292637);
      throw ((Throwable)localObject);
    }
    this.wOj = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(292637);
  }
  
  private static final void a(b paramb)
  {
    long l1 = 0L;
    AppMethodBeat.i(292664);
    s.u(paramb, "this$0");
    int i = paramb.wOj.getIntProperty(3);
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    int j = bU((Context)localObject);
    long l2;
    if (paramb.wOh != 0L)
    {
      l2 = paramb.wOh;
      l2 = (i + l2) / 2L;
      paramb.wOh = l2;
      if (paramb.ULc != null) {
        break label187;
      }
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label160;
      }
      l2 = 0L;
      label93:
      paramb.ULc = new r(Integer.valueOf(j), Long.valueOf(l2));
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label174;
      }
      label124:
      paramb.ULd = new r(Integer.valueOf(j), Long.valueOf(l1));
    }
    label160:
    label174:
    label187:
    label227:
    do
    {
      paramb.dpF();
      AppMethodBeat.o(292664);
      return;
      l2 = i;
      break;
      l2 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
      break label93;
      l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
      break label124;
      localObject = paramb.ULc;
      if ((localObject != null) && (((Number)((r)localObject).bsC).intValue() > j))
      {
        if (SubCoreVoip.hVp().Uxh != 0L) {
          break label306;
        }
        l2 = 0L;
        paramb.ULc = new r(Integer.valueOf(j), Long.valueOf(l2));
      }
      localObject = paramb.ULd;
    } while ((localObject == null) || (((Number)((r)localObject).bsC).intValue() >= j));
    if (SubCoreVoip.hVp().Uxh == 0L) {}
    for (;;)
    {
      paramb.ULd = new r(Integer.valueOf(j), Long.valueOf(l1));
      break;
      label306:
      l2 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
      break label227;
      l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
    }
  }
  
  private static int bU(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(292652);
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null)
      {
        AppMethodBeat.o(292652);
        return 0;
      }
      int j = paramContext.getIntExtra("temperature", 0);
      i = j;
    }
    finally
    {
      label43:
      break label43;
    }
    AppMethodBeat.o(292652);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(292646);
    this.wOh = 0L;
    this.ULd = null;
    this.ULc = null;
    this.handler = new MMHandler("batteryCounter");
    AppMethodBeat.o(292646);
  }
  
  public final void dpF()
  {
    AppMethodBeat.i(292691);
    for (;;)
    {
      this.wOi = true;
      this.ULe = SystemClock.uptimeMillis();
      MMHandler localMMHandler = this.handler;
      if ((localMMHandler != null) && (localMMHandler.isQuit() == true)) {}
      for (int i = 1; (i == 0) && (this.wOi); i = 0)
      {
        localMMHandler = this.handler;
        if (localMMHandler == null) {
          break label90;
        }
        localMMHandler.postDelayed(new b..ExternalSyntheticLambda0(this), 6000L);
        AppMethodBeat.o(292691);
        return;
      }
      init();
    }
    label90:
    AppMethodBeat.o(292691);
  }
  
  public final void iaT()
  {
    long l2 = 0L;
    AppMethodBeat.i(292698);
    this.wOi = false;
    long l1 = this.ULe;
    this.ULe = 0L;
    if (l1 > 0L) {}
    for (l1 = SystemClock.uptimeMillis() - l1;; l1 = 0L)
    {
      if (this.wOh > 0L)
      {
        Log.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.wOh + ", during = " + l1 + " ms");
        localObject = c.UGb;
        c.wT(this.wOh / 1000L);
      }
      if ((this.ULc == null) || (this.ULd == null)) {
        break;
      }
      localObject = this.ULc;
      if (localObject != null)
      {
        localc = c.UGb;
        c.i((r)localObject);
      }
      localObject = this.ULd;
      if (localObject == null) {
        break label256;
      }
      c localc = c.UGb;
      c.j((r)localObject);
      AppMethodBeat.o(292698);
      return;
    }
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    int i = bU((Context)localObject);
    localObject = c.UGb;
    if (SubCoreVoip.hVp().Uxh == 0L)
    {
      l1 = 0L;
      c.i(new r(Integer.valueOf(i), Long.valueOf(l1)));
      localObject = c.UGb;
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label275;
      }
    }
    label256:
    label275:
    for (l1 = l2;; l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh))
    {
      c.j(new r(Integer.valueOf(i), Long.valueOf(l1)));
      AppMethodBeat.o(292698);
      return;
      l1 = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
      break;
    }
  }
  
  public final void iaU()
  {
    AppMethodBeat.i(292704);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.quitSafely();
    }
    AppMethodBeat.o(292704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.b
 * JD-Core Version:    0.7.0.1
 */