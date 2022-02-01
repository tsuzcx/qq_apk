package com.tencent.mm.plugin.taskbar;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer;
import com.tencent.mm.plugin.taskbar.ui.a;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService;", "()V", "dynamicBgService", "Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgServiceImpl;", "glSurfaceView", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "listeners", "Landroid/util/SparseArray;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "Lkotlin/collections/HashSet;", "addTaskBarEventListener", "", "type", "", "listener", "getBackgroundView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getMyAppBrandHeaderAnimController", "Lcom/tencent/mm/plugin/taskbar/api/HeaderAnimController;", "listView", "Landroid/widget/ListView;", "headerContainer", "Lcom/tencent/mm/plugin/taskbar/api/HeaderContainer;", "getMyAppBrandHeaderContainer", "initEnableBackgroundView", "isEnableBackgroundView", "", "notifyClickTaskBarItem", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "removeTaskBarEventListener", "Companion", "plugin-taskbar_release"})
public final class i
  implements com.tencent.mm.plugin.taskbar.api.c
{
  public static final i.a UrH;
  private DynamicBackgroundGLSurfaceView FSg;
  private final com.tencent.mm.plugin.taskbar.ui.a.e FSh;
  final SparseArray<HashSet<com.tencent.mm.plugin.taskbar.api.c.a>> jfY;
  
  static
  {
    AppMethodBeat.i(258572);
    UrH = new i.a((byte)0);
    AppMethodBeat.o(258572);
  }
  
  public i()
  {
    AppMethodBeat.i(238439);
    this.jfY = new SparseArray();
    this.FSh = new com.tencent.mm.plugin.taskbar.ui.a.e();
    com.tencent.mm.dynamicbackground.model.d locald = com.tencent.mm.dynamicbackground.model.d.gRj;
    com.tencent.mm.dynamicbackground.model.d.a((com.tencent.mm.dynamicbackground.model.c)this.FSh);
    AppMethodBeat.o(238439);
  }
  
  public final b a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(238433);
    p.h(paramContext, "context");
    p.h(paramListView, "listView");
    p.h(paramHeaderContainer, "headerContainer");
    paramContext = (b)new a(paramContext, paramListView, paramHeaderContainer);
    AppMethodBeat.o(238433);
    return paramContext;
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.taskbar.api.c.a parama)
  {
    AppMethodBeat.i(238437);
    p.h(parama, "listener");
    HashSet localHashSet2 = (HashSet)this.jfY.get(paramInt);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    localHashSet1.add(parama);
    this.jfY.put(paramInt, localHashSet1);
    AppMethodBeat.o(238437);
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.taskbar.api.c.a parama)
  {
    AppMethodBeat.i(238438);
    p.h(parama, "listener");
    HashSet localHashSet = (HashSet)this.jfY.get(paramInt);
    if (localHashSet != null)
    {
      localHashSet.remove(parama);
      AppMethodBeat.o(238438);
      return;
    }
    AppMethodBeat.o(238438);
  }
  
  public final void fuu()
  {
    AppMethodBeat.i(238434);
    e.fur();
    AppMethodBeat.o(238434);
  }
  
  public final boolean fuv()
  {
    AppMethodBeat.i(238435);
    boolean bool = e.atB();
    AppMethodBeat.o(238435);
    return bool;
  }
  
  public final HeaderContainer hn(Context paramContext)
  {
    AppMethodBeat.i(238432);
    p.h(paramContext, "context");
    paramContext = (HeaderContainer)new TaskBarContainer(paramContext);
    AppMethodBeat.o(238432);
    return paramContext;
  }
  
  public final View ho(Context paramContext)
  {
    AppMethodBeat.i(238436);
    p.h(paramContext, "context");
    com.tencent.mm.dynamicbackground.a.c.a((com.tencent.mm.dynamicbackground.a.c.a)com.tencent.mm.plugin.taskbar.ui.a.d.FVe);
    if (this.FSg == null)
    {
      paramContext = paramContext.getApplicationContext();
      p.g(paramContext, "context.applicationContext");
      this.FSg = new DynamicBackgroundGLSurfaceView(paramContext, null, 2);
    }
    paramContext = this.FSg;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext = (View)paramContext;
    AppMethodBeat.o(238436);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.i
 * JD-Core Version:    0.7.0.1
 */