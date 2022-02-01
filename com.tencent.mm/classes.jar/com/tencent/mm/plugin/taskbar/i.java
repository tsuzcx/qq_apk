package com.tencent.mm.plugin.taskbar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c.a;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.api.b.a;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService;", "()V", "dynamicBgService", "Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "listeners", "Landroid/util/SparseArray;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "Lkotlin/collections/HashSet;", "addTaskBarEventListener", "", "type", "", "listener", "getBackgroundView", "Landroid/view/View;", "context", "Landroid/content/Context;", "initEnableBackgroundView", "isEnableBackgroundView", "", "notifyClickTaskBarItem", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "notifyTaskBarDataUpdated", "removeTaskBarEventListener", "Companion", "plugin-taskbar_release"})
public final class i
  implements b
{
  public static final i.a Mnl;
  private final com.tencent.mm.plugin.taskbar.ui.a.e Mnk;
  final SparseArray<HashSet<b.a>> lWz;
  
  static
  {
    AppMethodBeat.i(214658);
    Mnl = new i.a((byte)0);
    AppMethodBeat.o(214658);
  }
  
  public i()
  {
    AppMethodBeat.i(214657);
    this.lWz = new SparseArray();
    this.Mnk = new com.tencent.mm.plugin.taskbar.ui.a.e();
    com.tencent.mm.dynamicbackground.model.d locald = com.tencent.mm.dynamicbackground.model.d.jBF;
    com.tencent.mm.dynamicbackground.model.d.a((com.tencent.mm.dynamicbackground.model.c)this.Mnk);
    AppMethodBeat.o(214657);
  }
  
  public final void a(int paramInt, b.a parama)
  {
    AppMethodBeat.i(214655);
    p.k(parama, "listener");
    HashSet localHashSet2 = (HashSet)this.lWz.get(paramInt);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    localHashSet1.add(parama);
    this.lWz.put(paramInt, localHashSet1);
    AppMethodBeat.o(214655);
  }
  
  public final void b(int paramInt, b.a parama)
  {
    AppMethodBeat.i(214656);
    p.k(parama, "listener");
    HashSet localHashSet = (HashSet)this.lWz.get(paramInt);
    if (localHashSet != null)
    {
      localHashSet.remove(parama);
      AppMethodBeat.o(214656);
      return;
    }
    AppMethodBeat.o(214656);
  }
  
  public final void giW()
  {
    AppMethodBeat.i(214652);
    e.giT();
    AppMethodBeat.o(214652);
  }
  
  public final boolean giX()
  {
    AppMethodBeat.i(214653);
    boolean bool = e.aAt();
    AppMethodBeat.o(214653);
    return bool;
  }
  
  public final View io(Context paramContext)
  {
    AppMethodBeat.i(214654);
    p.k(paramContext, "context");
    com.tencent.mm.dynamicbackground.a.c.a((c.a)com.tencent.mm.plugin.taskbar.ui.a.d.Mqz);
    paramContext = paramContext.getApplicationContext();
    p.j(paramContext, "context.applicationContext");
    paramContext = (View)new DynamicBackgroundGLSurfaceView(paramContext);
    AppMethodBeat.o(214654);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.i
 * JD-Core Version:    0.7.0.1
 */