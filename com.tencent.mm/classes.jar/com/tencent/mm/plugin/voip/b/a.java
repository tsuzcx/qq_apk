package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", "getBatteryInfo", "", "init", "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "isNewRenderer", "renderType", "", "Companion", "plugin-voip_release"})
public final class a
{
  public static final a.a CkU;
  private long CkR;
  private boolean CkS;
  private final BatteryManager CkT;
  private ap handler;
  
  static
  {
    AppMethodBeat.i(215924);
    CkU = new a.a((byte)0);
    AppMethodBeat.o(215924);
  }
  
  public a()
  {
    AppMethodBeat.i(215923);
    Object localObject = aj.getContext().getSystemService("batterymanager");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.BatteryManager");
      AppMethodBeat.o(215923);
      throw ((Throwable)localObject);
    }
    this.CkT = ((BatteryManager)localObject);
    init();
    AppMethodBeat.o(215923);
  }
  
  private void init()
  {
    AppMethodBeat.i(215919);
    this.CkR = 0L;
    this.handler = new ap("batteryCounter");
    AppMethodBeat.o(215919);
  }
  
  public final void T(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(215921);
    this.CkS = false;
    if (this.CkR > 0L)
    {
      ad.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.CkR + ' ');
      if (paramBoolean)
      {
        localObject = i.ClE;
        i.a.ag(this.CkR / 1000L, paramInt);
        AppMethodBeat.o(215921);
        return;
      }
      Object localObject = j.ClH;
      j.a.ag(this.CkR / 1000L, paramInt);
    }
    AppMethodBeat.o(215921);
  }
  
  public final void ezl()
  {
    AppMethodBeat.i(215920);
    for (;;)
    {
      this.CkS = true;
      ap localap = this.handler;
      if (((localap == null) || (localap.isQuit() != true)) && (this.CkS))
      {
        localap = this.handler;
        if (localap != null)
        {
          localap.postDelayed((Runnable)new b(this), 1000L);
          AppMethodBeat.o(215920);
          return;
        }
        AppMethodBeat.o(215920);
        return;
      }
      init();
    }
  }
  
  public final void ezm()
  {
    AppMethodBeat.i(215922);
    ap localap = this.handler;
    if (localap != null) {
      localap.removeCallbacksAndMessages(null);
    }
    localap = this.handler;
    if (localap != null)
    {
      localap.quitSafely();
      AppMethodBeat.o(215922);
      return;
    }
    AppMethodBeat.o(215922);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(215918);
      a.a(this.CkV);
      this.CkV.ezl();
      AppMethodBeat.o(215918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */