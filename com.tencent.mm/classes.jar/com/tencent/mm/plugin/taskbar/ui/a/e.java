package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-taskbar_release"})
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a FVf;
  
  static
  {
    AppMethodBeat.i(238491);
    FVf = new e.a((byte)0);
    AppMethodBeat.o(238491);
  }
  
  public final boolean atB()
  {
    AppMethodBeat.i(238481);
    boolean bool = com.tencent.mm.plugin.taskbar.e.atB();
    AppMethodBeat.o(238481);
    return bool;
  }
  
  public final void atC()
  {
    AppMethodBeat.i(238489);
    com.tencent.mm.plugin.taskbar.e.wj(false);
    AppMethodBeat.o(238489);
  }
  
  public final void atD()
  {
    AppMethodBeat.i(238480);
    Log.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (com.tencent.mm.plugin.taskbar.e.atB()) {
      c.fve();
    }
    try
    {
      System.loadLibrary("dynamicBg");
      AppMethodBeat.o(238480);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", localThrowable, "alvinluo DynamicBackgroundNative exception", new Object[0]);
      c.fvd();
      AppMethodBeat.o(238480);
    }
  }
  
  public final boolean atE()
  {
    AppMethodBeat.i(238490);
    boolean bool = c.fvg();
    AppMethodBeat.o(238490);
    return bool;
  }
  
  public final void atF()
  {
    AppMethodBeat.i(238485);
    c.atF();
    AppMethodBeat.o(238485);
  }
  
  public final void atG()
  {
    AppMethodBeat.i(238487);
    c.fvd();
    AppMethodBeat.o(238487);
  }
  
  public final void atH()
  {
    AppMethodBeat.i(238488);
    c.fvf();
    AppMethodBeat.o(238488);
  }
  
  public final boolean atI()
  {
    AppMethodBeat.i(238482);
    boolean bool = c.atI();
    AppMethodBeat.o(238482);
    return bool;
  }
  
  public final boolean atJ()
  {
    AppMethodBeat.i(238486);
    boolean bool = c.atJ();
    AppMethodBeat.o(238486);
    return bool;
  }
  
  public final void atK()
  {
    AppMethodBeat.i(238484);
    c.atK();
    AppMethodBeat.o(238484);
  }
  
  public final void atL()
  {
    AppMethodBeat.i(238483);
    c.atL();
    AppMethodBeat.o(238483);
  }
  
  public final float atM()
  {
    AppMethodBeat.i(238479);
    a locala = a.FUZ;
    float f = a.fuY();
    AppMethodBeat.o(238479);
    return f;
  }
  
  public final Point az(Context paramContext)
  {
    AppMethodBeat.i(238478);
    p.h(paramContext, "context");
    paramContext = ao.az(paramContext);
    p.g(paramContext, "UIUtils.getDisplayRealSize(context)");
    AppMethodBeat.o(238478);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.e
 * JD-Core Version:    0.7.0.1
 */