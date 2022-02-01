package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "isNewRenderer", "renderType", "", "Companion", "plugin-voip_release"})
public final class a
{
  public static final a.a ztb;
  private ap handler;
  private long zsY;
  private boolean zsZ;
  private final BatteryManager zta;
  
  static
  {
    AppMethodBeat.i(192272);
    ztb = new a.a((byte)0);
    AppMethodBeat.o(192272);
  }
  
  public a()
  {
    AppMethodBeat.i(192271);
    Object localObject = aj.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(192271);
      throw ((Throwable)localObject);
    }
    this.zta = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(192271);
  }
  
  private void init()
  {
    AppMethodBeat.i(192267);
    this.zsY = 0L;
    this.handler = new ap("batteryCounter");
    AppMethodBeat.o(192267);
  }
  
  public final void Q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(192269);
    this.zsZ = false;
    if (this.zsY > 0L)
    {
      ad.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.zsY + ' ');
      if (paramBoolean)
      {
        localObject = f.ztz;
        f.a.Y(this.zsY / 1000L, paramInt);
        AppMethodBeat.o(192269);
        return;
      }
      Object localObject = g.ztC;
      g.a.Y(this.zsY / 1000L, paramInt);
    }
    AppMethodBeat.o(192269);
  }
  
  public final void dWp()
  {
    AppMethodBeat.i(192268);
    for (;;)
    {
      this.zsZ = true;
      ap localap = this.handler;
      if (((localap == null) || (localap.isQuit() != true)) && (this.zsZ))
      {
        localap = this.handler;
        if (localap != null)
        {
          localap.postDelayed((Runnable)new b(this), 1000L);
          AppMethodBeat.o(192268);
          return;
        }
        AppMethodBeat.o(192268);
        return;
      }
      init();
    }
  }
  
  public final void dWq()
  {
    AppMethodBeat.i(192270);
    ap localap = this.handler;
    if (localap != null) {
      localap.removeCallbacksAndMessages(null);
    }
    localap = this.handler;
    if (localap != null)
    {
      localap.quitSafely();
      AppMethodBeat.o(192270);
      return;
    }
    AppMethodBeat.o(192270);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(192266);
      a.a(this.ztc);
      this.ztc.dWp();
      AppMethodBeat.o(192266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */