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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService;", "()V", "dynamicBgService", "Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "listeners", "Landroid/util/SparseArray;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "Lkotlin/collections/HashSet;", "addTaskBarEventListener", "", "type", "", "listener", "getBackgroundView", "Landroid/view/View;", "context", "Landroid/content/Context;", "initEnableBackgroundView", "isEnableBackgroundView", "", "notifyClickTaskBarItem", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "notifyTaskBarDataUpdated", "removeTaskBarEventListener", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements b
{
  public static final i.a SQD;
  private final com.tencent.mm.plugin.taskbar.ui.a.e SQE;
  final SparseArray<HashSet<b.a>> oPB;
  
  static
  {
    AppMethodBeat.i(263984);
    SQD = new i.a((byte)0);
    AppMethodBeat.o(263984);
  }
  
  public i()
  {
    AppMethodBeat.i(263977);
    this.oPB = new SparseArray();
    this.SQE = new com.tencent.mm.plugin.taskbar.ui.a.e();
    com.tencent.mm.dynamicbackground.model.d locald = com.tencent.mm.dynamicbackground.model.d.mbs;
    com.tencent.mm.dynamicbackground.model.d.a((com.tencent.mm.dynamicbackground.model.c)this.SQE);
    AppMethodBeat.o(263977);
  }
  
  public final void a(int paramInt, b.a parama)
  {
    AppMethodBeat.i(264007);
    s.u(parama, "listener");
    HashSet localHashSet2 = (HashSet)this.oPB.get(paramInt);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    localHashSet1.add(parama);
    this.oPB.put(paramInt, localHashSet1);
    AppMethodBeat.o(264007);
  }
  
  public final void b(int paramInt, b.a parama)
  {
    AppMethodBeat.i(264011);
    s.u(parama, "listener");
    HashSet localHashSet = (HashSet)this.oPB.get(paramInt);
    if (localHashSet != null) {
      localHashSet.remove(parama);
    }
    AppMethodBeat.o(264011);
  }
  
  public final void hCW()
  {
    AppMethodBeat.i(263991);
    e.hCT();
    AppMethodBeat.o(263991);
  }
  
  public final boolean hCX()
  {
    AppMethodBeat.i(263995);
    boolean bool = e.aTo();
    AppMethodBeat.o(263995);
    return bool;
  }
  
  public final View ke(Context paramContext)
  {
    AppMethodBeat.i(264000);
    s.u(paramContext, "context");
    com.tencent.mm.dynamicbackground.a.c.a((c.a)com.tencent.mm.plugin.taskbar.ui.a.d.STL);
    paramContext = paramContext.getApplicationContext();
    s.s(paramContext, "context.applicationContext");
    paramContext = (View)new DynamicBackgroundGLSurfaceView(paramContext);
    AppMethodBeat.o(264000);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.i
 * JD-Core Version:    0.7.0.1
 */