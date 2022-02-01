package com.tencent.mm.plugin.webcanvas;

import com.tencent.magicbrush.handler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "webview-sdk_release"})
public final class c$g
  implements a
{
  c$g(c paramc) {}
  
  public final boolean LO()
  {
    AppMethodBeat.i(224634);
    IJSRuntime localIJSRuntime = this.IzN.bMz();
    p.g(localIJSRuntime, "this@WebCanvasJsEngine.jsRuntime");
    boolean bool = localIJSRuntime.Xw();
    AppMethodBeat.o(224634);
    return bool;
  }
  
  public final String LP()
  {
    AppMethodBeat.i(224630);
    String str = this.IzN.LP();
    AppMethodBeat.o(224630);
    return str;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(224633);
    p.h(paramRunnable, "p0");
    this.IzN.a(paramRunnable, paramBoolean);
    AppMethodBeat.o(224633);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(224632);
    boolean bool = this.IzN.bMz().doInnerLoopTask();
    AppMethodBeat.o(224632);
    return bool;
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(224631);
    this.IzN.bMz().resumeLoopTasks();
    AppMethodBeat.o(224631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c.g
 * JD-Core Version:    0.7.0.1
 */