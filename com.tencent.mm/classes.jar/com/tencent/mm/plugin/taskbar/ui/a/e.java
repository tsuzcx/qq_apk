package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-taskbar_release"})
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a MqA;
  
  static
  {
    AppMethodBeat.i(215638);
    MqA = new e.a((byte)0);
    AppMethodBeat.o(215638);
  }
  
  public final boolean aAA()
  {
    AppMethodBeat.i(215628);
    boolean bool = c.aAA();
    AppMethodBeat.o(215628);
    return bool;
  }
  
  public final boolean aAB()
  {
    AppMethodBeat.i(215633);
    boolean bool = c.aAB();
    AppMethodBeat.o(215633);
    return bool;
  }
  
  public final void aAC()
  {
    AppMethodBeat.i(215630);
    c.aAC();
    AppMethodBeat.o(215630);
  }
  
  public final void aAD()
  {
    AppMethodBeat.i(215629);
    c.aAD();
    AppMethodBeat.o(215629);
  }
  
  public final float aAE()
  {
    AppMethodBeat.i(215625);
    a locala = a.Mqu;
    float f = a.gjW();
    AppMethodBeat.o(215625);
    return f;
  }
  
  public final boolean aAt()
  {
    AppMethodBeat.i(215627);
    boolean bool = com.tencent.mm.plugin.taskbar.e.aAt();
    AppMethodBeat.o(215627);
    return bool;
  }
  
  public final void aAu()
  {
    AppMethodBeat.i(215636);
    com.tencent.mm.plugin.taskbar.e.zP(false);
    AppMethodBeat.o(215636);
  }
  
  public final void aAv()
  {
    AppMethodBeat.i(215626);
    Log.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (com.tencent.mm.plugin.taskbar.e.aAt()) {
      c.gkc();
    }
    try
    {
      System.loadLibrary("dynamicBg");
      AppMethodBeat.o(215626);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", localThrowable, "alvinluo DynamicBackgroundNative exception", new Object[0]);
      c.gkb();
      AppMethodBeat.o(215626);
    }
  }
  
  public final boolean aAw()
  {
    AppMethodBeat.i(215637);
    boolean bool = c.gke();
    AppMethodBeat.o(215637);
    return bool;
  }
  
  public final void aAx()
  {
    AppMethodBeat.i(215632);
    c.aAx();
    AppMethodBeat.o(215632);
  }
  
  public final void aAy()
  {
    AppMethodBeat.i(215634);
    c.gkb();
    AppMethodBeat.o(215634);
  }
  
  public final void aAz()
  {
    AppMethodBeat.i(215635);
    c.gkd();
    AppMethodBeat.o(215635);
  }
  
  public final Point au(Context paramContext)
  {
    AppMethodBeat.i(215624);
    p.k(paramContext, "context");
    paramContext = ar.au(paramContext);
    p.j(paramContext, "UIUtils.getDisplayRealSize(context)");
    AppMethodBeat.o(215624);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.e
 * JD-Core Version:    0.7.0.1
 */