package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "isNewRenderer", "renderType", "", "Companion", "plugin-voip_release"})
public final class a
{
  public static final a.a ALP;
  private long ALM;
  private boolean ALN;
  private final BatteryManager ALO;
  private ao handler;
  
  static
  {
    AppMethodBeat.i(208610);
    ALP = new a.a((byte)0);
    AppMethodBeat.o(208610);
  }
  
  public a()
  {
    AppMethodBeat.i(208609);
    Object localObject = ai.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(208609);
      throw ((Throwable)localObject);
    }
    this.ALO = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(208609);
  }
  
  private void init()
  {
    AppMethodBeat.i(208605);
    this.ALM = 0L;
    this.handler = new ao("batteryCounter");
    AppMethodBeat.o(208605);
  }
  
  public final void S(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(208607);
    this.ALN = false;
    if (this.ALM > 0L)
    {
      ac.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.ALM + ' ');
      if (paramBoolean)
      {
        localObject = g.AMq;
        g.a.ab(this.ALM / 1000L, paramInt);
        AppMethodBeat.o(208607);
        return;
      }
      Object localObject = h.AMt;
      h.a.ab(this.ALM / 1000L, paramInt);
    }
    AppMethodBeat.o(208607);
  }
  
  public final void elB()
  {
    AppMethodBeat.i(208606);
    for (;;)
    {
      this.ALN = true;
      ao localao = this.handler;
      if (((localao == null) || (localao.isQuit() != true)) && (this.ALN))
      {
        localao = this.handler;
        if (localao != null)
        {
          localao.postDelayed((Runnable)new b(this), 1000L);
          AppMethodBeat.o(208606);
          return;
        }
        AppMethodBeat.o(208606);
        return;
      }
      init();
    }
  }
  
  public final void elC()
  {
    AppMethodBeat.i(208608);
    ao localao = this.handler;
    if (localao != null) {
      localao.removeCallbacksAndMessages(null);
    }
    localao = this.handler;
    if (localao != null)
    {
      localao.quitSafely();
      AppMethodBeat.o(208608);
      return;
    }
    AppMethodBeat.o(208608);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(208604);
      a.a(this.ALQ);
      this.ALQ.elB();
      AppMethodBeat.o(208604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */