package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "isNewRenderer", "renderType", "", "Companion", "plugin-voip_release"})
public final class a
{
  public static final a.a Hgo;
  private long Hgl;
  private boolean Hgm;
  private final BatteryManager Hgn;
  private MMHandler handler;
  
  static
  {
    AppMethodBeat.i(235996);
    Hgo = new a.a((byte)0);
    AppMethodBeat.o(235996);
  }
  
  public a()
  {
    AppMethodBeat.i(235995);
    Object localObject = MMApplicationContext.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(235995);
      throw ((Throwable)localObject);
    }
    this.Hgn = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(235995);
  }
  
  private void init()
  {
    AppMethodBeat.i(235991);
    this.Hgl = 0L;
    this.handler = new MMHandler("batteryCounter");
    AppMethodBeat.o(235991);
  }
  
  public final void Z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(235993);
    this.Hgm = false;
    if (this.Hgl > 0L)
    {
      Log.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.Hgl + ' ');
      if (paramBoolean)
      {
        localObject = h.Hhl;
        h.a.aj(this.Hgl / 1000L, paramInt);
        AppMethodBeat.o(235993);
        return;
      }
      Object localObject = i.Hho;
      i.a.aj(this.Hgl / 1000L, paramInt);
    }
    AppMethodBeat.o(235993);
  }
  
  public final void fJK()
  {
    AppMethodBeat.i(235992);
    for (;;)
    {
      this.Hgm = true;
      MMHandler localMMHandler = this.handler;
      if (((localMMHandler == null) || (localMMHandler.isQuit() != true)) && (this.Hgm))
      {
        localMMHandler = this.handler;
        if (localMMHandler != null)
        {
          localMMHandler.postDelayed((Runnable)new b(this), 1000L);
          AppMethodBeat.o(235992);
          return;
        }
        AppMethodBeat.o(235992);
        return;
      }
      init();
    }
  }
  
  public final void fJL()
  {
    AppMethodBeat.i(235994);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.quitSafely();
      AppMethodBeat.o(235994);
      return;
    }
    AppMethodBeat.o(235994);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(235990);
      a.a(this.Hgp);
      this.Hgp.fJK();
      AppMethodBeat.o(235990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */