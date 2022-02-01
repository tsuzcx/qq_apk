package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "isNewRenderer", "renderType", "", "Companion", "plugin-voip_release"})
public final class a
{
  public static final a.a CCz;
  private long CCw;
  private boolean CCx;
  private final BatteryManager CCy;
  private aq handler;
  
  static
  {
    AppMethodBeat.i(210345);
    CCz = new a.a((byte)0);
    AppMethodBeat.o(210345);
  }
  
  public a()
  {
    AppMethodBeat.i(210344);
    Object localObject = ak.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(210344);
      throw ((Throwable)localObject);
    }
    this.CCy = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(210344);
  }
  
  private void init()
  {
    AppMethodBeat.i(210340);
    this.CCw = 0L;
    this.handler = new aq("batteryCounter");
    AppMethodBeat.o(210340);
  }
  
  public final void W(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(210342);
    this.CCx = false;
    if (this.CCw > 0L)
    {
      ae.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.CCw + ' ');
      if (paramBoolean)
      {
        localObject = i.CDi;
        i.a.ag(this.CCw / 1000L, paramInt);
        AppMethodBeat.o(210342);
        return;
      }
      Object localObject = j.CDl;
      j.a.ag(this.CCw / 1000L, paramInt);
    }
    AppMethodBeat.o(210342);
  }
  
  public final void eCT()
  {
    AppMethodBeat.i(210341);
    for (;;)
    {
      this.CCx = true;
      aq localaq = this.handler;
      if (((localaq == null) || (localaq.isQuit() != true)) && (this.CCx))
      {
        localaq = this.handler;
        if (localaq != null)
        {
          localaq.postDelayed((Runnable)new b(this), 1000L);
          AppMethodBeat.o(210341);
          return;
        }
        AppMethodBeat.o(210341);
        return;
      }
      init();
    }
  }
  
  public final void eCU()
  {
    AppMethodBeat.i(210343);
    aq localaq = this.handler;
    if (localaq != null) {
      localaq.removeCallbacksAndMessages(null);
    }
    localaq = this.handler;
    if (localaq != null)
    {
      localaq.quitSafely();
      AppMethodBeat.o(210343);
      return;
    }
    AppMethodBeat.o(210343);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(210339);
      a.a(this.CCA);
      this.CCA.eCT();
      AppMethodBeat.o(210339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */