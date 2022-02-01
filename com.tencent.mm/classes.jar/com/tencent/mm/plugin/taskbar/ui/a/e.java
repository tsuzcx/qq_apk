package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a STM;
  
  static
  {
    AppMethodBeat.i(264131);
    STM = new e.a((byte)0);
    AppMethodBeat.o(264131);
  }
  
  public final boolean aTo()
  {
    AppMethodBeat.i(264165);
    boolean bool = com.tencent.mm.plugin.taskbar.e.aTo();
    AppMethodBeat.o(264165);
    return bool;
  }
  
  public final void aTp()
  {
    AppMethodBeat.i(264211);
    com.tencent.mm.plugin.taskbar.e.Fg(false);
    AppMethodBeat.o(264211);
  }
  
  public final void aTq()
  {
    AppMethodBeat.i(264159);
    Log.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (com.tencent.mm.plugin.taskbar.e.aTo()) {
      c.hEc();
    }
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("dynamicBg");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl", "loadDynamicBgLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl", "loadDynamicBgLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      AppMethodBeat.o(264159);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", localThrowable, "alvinluo DynamicBackgroundNative exception", new Object[0]);
      c.hEb();
      AppMethodBeat.o(264159);
    }
  }
  
  public final boolean aTr()
  {
    AppMethodBeat.i(264216);
    boolean bool = c.hEe();
    AppMethodBeat.o(264216);
    return bool;
  }
  
  public final void aTs()
  {
    AppMethodBeat.i(264190);
    c.aTs();
    AppMethodBeat.o(264190);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(264204);
    c.hEb();
    AppMethodBeat.o(264204);
  }
  
  public final void aTu()
  {
    AppMethodBeat.i(264206);
    c.hEd();
    AppMethodBeat.o(264206);
  }
  
  public final boolean aTv()
  {
    AppMethodBeat.i(264169);
    boolean bool = c.aTv();
    AppMethodBeat.o(264169);
    return bool;
  }
  
  public final boolean aTw()
  {
    AppMethodBeat.i(264200);
    boolean bool = c.aTw();
    AppMethodBeat.o(264200);
    return bool;
  }
  
  public final void aTx()
  {
    AppMethodBeat.i(264182);
    c.aTx();
    AppMethodBeat.o(264182);
  }
  
  public final void aTy()
  {
    AppMethodBeat.i(264174);
    c.aTy();
    AppMethodBeat.o(264174);
  }
  
  public final float aTz()
  {
    AppMethodBeat.i(264149);
    a locala = a.STE;
    float f = a.hDW();
    AppMethodBeat.o(264149);
    return f;
  }
  
  public final Point bf(Context paramContext)
  {
    AppMethodBeat.i(264140);
    s.u(paramContext, "context");
    paramContext = aw.bf(paramContext);
    s.s(paramContext, "getDisplayRealSize(context)");
    AppMethodBeat.o(264140);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.e
 * JD-Core Version:    0.7.0.1
 */