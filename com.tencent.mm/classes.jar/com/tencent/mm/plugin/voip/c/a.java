package com.tencent.mm.plugin.voip.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "maxBatteryTemperature", "Lkotlin/Pair;", "", "minBatteryTemperature", "startMillis", "getBatteryInfo", "", "getBatteryTemperature", "context", "Landroid/content/Context;", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "Companion", "plugin-voip_release"})
public final class a
{
  public static final a.a NXa;
  private o<Integer, Long> NWX;
  private o<Integer, Long> NWY;
  private long NWZ;
  private MMHandler handler;
  private long tKQ;
  private boolean tKR;
  private final BatteryManager tKS;
  
  static
  {
    AppMethodBeat.i(235255);
    NXa = new a.a((byte)0);
    AppMethodBeat.o(235255);
  }
  
  public a()
  {
    AppMethodBeat.i(235253);
    Object localObject = MMApplicationContext.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(235253);
      throw ((Throwable)localObject);
    }
    this.tKS = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(235253);
  }
  
  private static int bk(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(235244);
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null)
      {
        AppMethodBeat.o(235244);
        return 0;
      }
      p.j(paramContext, "context.registerReceiver…              ?: return 0");
      int j = paramContext.getIntExtra("temperature", 0);
      i = j;
    }
    catch (Throwable paramContext)
    {
      label49:
      break label49;
    }
    AppMethodBeat.o(235244);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(235240);
    this.tKQ = 0L;
    this.NWY = null;
    this.NWX = null;
    this.handler = new MMHandler("batteryCounter");
    AppMethodBeat.o(235240);
  }
  
  public final void cLZ()
  {
    AppMethodBeat.i(235245);
    for (;;)
    {
      this.tKR = true;
      this.NWZ = SystemClock.uptimeMillis();
      MMHandler localMMHandler = this.handler;
      if (((localMMHandler == null) || (localMMHandler.isQuit() != true)) && (this.tKR))
      {
        localMMHandler = this.handler;
        if (localMMHandler != null)
        {
          localMMHandler.postDelayed((Runnable)new b(this), 6000L);
          AppMethodBeat.o(235245);
          return;
        }
        AppMethodBeat.o(235245);
        return;
      }
      init();
    }
  }
  
  public final void gCh()
  {
    AppMethodBeat.i(235250);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.quitSafely();
      AppMethodBeat.o(235250);
      return;
    }
    AppMethodBeat.o(235250);
  }
  
  public final void gEI()
  {
    long l2 = 0L;
    AppMethodBeat.i(293141);
    this.tKR = false;
    long l1 = this.NWZ;
    this.NWZ = 0L;
    if (l1 > 0L) {}
    for (l1 = SystemClock.uptimeMillis() - l1;; l1 = 0L)
    {
      if (this.tKQ > 0L)
      {
        Log.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.tKQ + ", during = " + l1 + " ms");
        localObject = com.tencent.mm.plugin.voip.b.a.NTi;
        com.tencent.mm.plugin.voip.b.a.XV(this.tKQ / 1000L);
      }
      if ((this.NWX == null) || (this.NWY == null)) {
        break label171;
      }
      localObject = this.NWX;
      if (localObject != null)
      {
        locala = com.tencent.mm.plugin.voip.b.a.NTi;
        com.tencent.mm.plugin.voip.b.a.b((o)localObject);
      }
      localObject = this.NWY;
      if (localObject == null) {
        break;
      }
      com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.c((o)localObject);
      AppMethodBeat.o(293141);
      return;
    }
    AppMethodBeat.o(293141);
    return;
    label171:
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    int i = bk((Context)localObject);
    localObject = com.tencent.mm.plugin.voip.b.a.NTi;
    if (c.gxs().NKx == 0L)
    {
      l1 = 0L;
      com.tencent.mm.plugin.voip.b.a.b(new o(Integer.valueOf(i), Long.valueOf(l1)));
      localObject = com.tencent.mm.plugin.voip.b.a.NTi;
      if (c.gxs().NKx != 0L) {
        break label281;
      }
    }
    label281:
    for (l1 = l2;; l1 = Util.secondsToNow(c.gxs().NKx))
    {
      com.tencent.mm.plugin.voip.b.a.c(new o(Integer.valueOf(i), Long.valueOf(l1)));
      AppMethodBeat.o(293141);
      return;
      l1 = Util.secondsToNow(c.gxs().NKx);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(245751);
      a.a(this.NXb);
      this.NXb.cLZ();
      AppMethodBeat.o(245751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.a
 * JD-Core Version:    0.7.0.1
 */