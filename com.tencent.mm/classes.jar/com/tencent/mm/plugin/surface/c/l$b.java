package com.tencent.mm.plugin.surface.c;

import com.tencent.magicbrush.handler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.q;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/surface/render/SurfaceMagicBrushFactory$create$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$b
  implements a
{
  l$b(i parami) {}
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(265082);
    s.u(paramRunnable, "p0");
    Object localObject = this.SLD;
    s.s(localObject, "jsRuntime");
    localObject = (q)((i)localObject).Z(q.class);
    if (localObject != null) {
      ((q)localObject).a(paramRunnable, paramBoolean);
    }
    AppMethodBeat.o(265082);
  }
  
  public final boolean aoN()
  {
    AppMethodBeat.i(265091);
    Object localObject = this.SLD;
    s.s(localObject, "jsRuntime");
    localObject = (q)((i)localObject).Z(q.class);
    if (localObject == null)
    {
      AppMethodBeat.o(265091);
      return false;
    }
    boolean bool = ((q)localObject).aoN();
    AppMethodBeat.o(265091);
    return bool;
  }
  
  public final String aoO()
  {
    AppMethodBeat.i(265078);
    Object localObject = this.SLD;
    s.s(localObject, "jsRuntime");
    localObject = (q)((i)localObject).Z(q.class);
    if (localObject == null)
    {
      AppMethodBeat.o(265078);
      return null;
    }
    localObject = ((q)localObject).aoO();
    AppMethodBeat.o(265078);
    return localObject;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(265104);
    Object localObject = this.SLD;
    s.s(localObject, "jsRuntime");
    localObject = (q)((i)localObject).Z(q.class);
    if (localObject == null)
    {
      AppMethodBeat.o(265104);
      return false;
    }
    boolean bool = ((q)localObject).doInnerLoopTask();
    AppMethodBeat.o(265104);
    return bool;
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(265098);
    Object localObject = this.SLD;
    s.s(localObject, "jsRuntime");
    localObject = (q)((i)localObject).Z(q.class);
    if (localObject != null) {
      ((q)localObject).resumeLoopTasks();
    }
    AppMethodBeat.o(265098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.l.b
 * JD-Core Version:    0.7.0.1
 */