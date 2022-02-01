package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.a.a;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.uic.c.a;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel;", "Lcom/tencent/mm/plugin/multitask/ui/panel/BaseMultiTaskPanel;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "onCreateInstanceState", "Landroid/os/Bundle;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/os/Bundle;)V", "multiTaskEventListener", "com/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$multiTaskEventListener$1", "Lcom/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$multiTaskEventListener$1;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "initPanelWindowContainer", "", "container", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "onChanged", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "savedInstanceState", "onDestroy", "onGridItemClick", "firstView", "Landroid/view/View;", "targetView", "curPos", "", "taskInfo", "needEnterAnim", "", "onGridItemDelete", "onGridItemExposed", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
  implements com.tencent.mm.plugin.multitask.ui.uic.b.b, IStorageObserver<MultiTaskInfo>
{
  public static final b.a LGu;
  private final MinusScreenPanel.multiTaskEventListener.1 LGv;
  private com.tencent.mm.plugin.teenmode.a.g qCv;
  
  static
  {
    AppMethodBeat.i(304562);
    LGu = new b.a((byte)0);
    AppMethodBeat.o(304562);
  }
  
  public b(AppCompatActivity paramAppCompatActivity, Bundle paramBundle)
  {
    super(paramAppCompatActivity, paramBundle);
    AppMethodBeat.i(304541);
    this.LGv = new MinusScreenPanel.multiTaskEventListener.1(this, paramAppCompatActivity, f.hfK);
    this.qCv = new b..ExternalSyntheticLambda0(paramAppCompatActivity);
    AppMethodBeat.o(304541);
  }
  
  private static final void c(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(304553);
    s.u(paramAppCompatActivity, "$activity");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.c(paramAppCompatActivity));
    AppMethodBeat.o(304553);
  }
  
  public final void a(View paramView1, final View paramView2, int paramInt, final MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(304626);
    s.u(paramMultiTaskInfo, "taskInfo");
    Object localObject = k.aeZF;
    k.d(this.activity).q(com.tencent.mm.plugin.multitask.ui.uic.c.class);
    if (com.tencent.mm.plugin.multitask.ui.uic.c.acA(paramMultiTaskInfo.field_type))
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg((Context)this.activity);
      Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onGridItemClick, is TeenMode!");
      AppMethodBeat.o(304626);
      return;
    }
    final drt localdrt = new drt();
    localdrt.aaXp = paramBoolean;
    localObject = com.tencent.mm.plugin.multitask.f.c.LIw;
    if (paramView2 == null)
    {
      localObject = null;
      localObject = com.tencent.mm.plugin.multitask.f.c.im((View)localObject);
      localdrt.qWi = ((String)((r)localObject).bsC);
      if ((((Number)((r)localObject).bsD).intValue() & 0x1) != 1) {
        break label302;
      }
      bool = true;
      label142:
      localdrt.aaXr = bool;
      if ((((Number)((r)localObject).bsD).intValue() & 0x4) != 1) {
        break label308;
      }
    }
    label302:
    label308:
    for (boolean bool = true;; bool = false)
    {
      localdrt.aaXs = bool;
      localObject = com.tencent.mm.plugin.multitask.h.LBd;
      localObject = paramMultiTaskInfo.field_id;
      s.s(localObject, "taskInfo.field_id");
      localdrt.aaXo = com.tencent.mm.plugin.multitask.h.aNP((String)localObject);
      localObject = com.tencent.mm.plugin.multitask.h.LBd;
      localdrt.aaXq = com.tencent.mm.plugin.multitask.h.gjv();
      localObject = com.tencent.mm.plugin.multitask.f.c.LIw;
      localdrt.LCT = com.tencent.mm.plugin.multitask.f.c.il(paramView1);
      localdrt.aaXt = paramInt;
      if (!paramBoolean) {
        break label314;
      }
      paramView1 = com.tencent.mm.plugin.multitask.g.LBa;
      paramView1 = aNW(com.tencent.mm.plugin.multitask.g.gjs());
      if (paramView1 == null) {
        break label389;
      }
      ((com.tencent.mm.plugin.multitask.ui.uic.d)paramView1).a(paramView2, paramMultiTaskInfo, localdrt, new b(this, paramMultiTaskInfo, localdrt, paramView2));
      AppMethodBeat.o(304626);
      return;
      localObject = paramView2.findViewById(e.c.multi_task_item_bg);
      break;
      bool = false;
      break label142;
    }
    label314:
    paramView1 = h(paramMultiTaskInfo);
    if (paramView1 != null)
    {
      localdrt.XgN = System.currentTimeMillis();
      a.a.a((com.tencent.mm.plugin.multitask.ui.a)paramView1, paramView2, paramMultiTaskInfo, localdrt);
      paramView1 = k.aeZF;
      ((com.tencent.mm.plugin.multitask.ui.uic.c)k.d(this.activity).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).k(paramMultiTaskInfo);
      Log.i("MicroMsg.MultiTask.MinusScreenPanel", "needEnterAnim false, onGridItemClick, id:%s", new Object[] { paramMultiTaskInfo.field_id });
    }
    label389:
    AppMethodBeat.o(304626);
  }
  
  public final void a(MultiTaskPanelContainer paramMultiTaskPanelContainer)
  {
    AppMethodBeat.i(304591);
    s.u(paramMultiTaskPanelContainer, "container");
    Object localObject1 = new MultiTaskInfo();
    Object localObject2 = com.tencent.mm.plugin.multitask.g.LBa;
    ((MultiTaskInfo)localObject1).field_id = com.tencent.mm.plugin.multitask.g.gjr();
    localObject1 = h((MultiTaskInfo)localObject1);
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).getRootView();
      c.a locala = com.tencent.mm.plugin.multitask.ui.uic.c.LHl;
      ((View)localObject2).setPadding(0, 0, com.tencent.mm.plugin.multitask.ui.uic.c.glB(), 0);
      ((com.tencent.mm.plugin.multitask.ui.uic.b)localObject1).LHb = ((com.tencent.mm.plugin.multitask.ui.uic.b.b)this);
    }
    super.a(paramMultiTaskPanelContainer);
    AppMethodBeat.o(304591);
  }
  
  public final a.b eDe()
  {
    return a.b.LDp;
  }
  
  public final void i(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304634);
    s.u(paramMultiTaskInfo, "taskInfo");
    Object localObject = h(paramMultiTaskInfo);
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.ui.c)localObject).fZ(paramMultiTaskInfo);
    }
    localObject = paramMultiTaskInfo.field_id;
    s.s(localObject, "taskInfo.field_id");
    aNV((String)localObject);
    Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onGridItemDelete, id:%s", new Object[] { paramMultiTaskInfo.field_id });
    AppMethodBeat.o(304634);
  }
  
  public final void j(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304645);
    s.u(paramMultiTaskInfo, "taskInfo");
    com.tencent.mm.plugin.multitask.ui.c localc = h(paramMultiTaskInfo);
    if (localc != null) {
      localc.a(paramMultiTaskInfo);
    }
    AppMethodBeat.o(304645);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(304607);
    super.onCreate(paramBundle);
    Object localObject = ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).getMultiTaskStorage();
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.model.b)localObject).observe((q)this.activity, (IStorageObserver)this);
    }
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(this.qCv);
    this.LGv.alive();
    localObject = com.tencent.mm.plugin.multitask.g.LBa;
    localObject = cq(0, com.tencent.mm.plugin.multitask.g.gjr());
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.ui.uic.b)localObject).onCreate(paramBundle);
    }
    AppMethodBeat.o(304607);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(304614);
    super.onDestroy();
    Object localObject = ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).getMultiTaskStorage();
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.model.b)localObject).removeObserver((IStorageObserver)this);
    }
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b(this.qCv);
    this.LGv.dead();
    localObject = com.tencent.mm.plugin.multitask.g.LBa;
    localObject = cq(0, com.tencent.mm.plugin.multitask.g.gjr());
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.ui.uic.b)localObject).onDestroy();
    }
    AppMethodBeat.o(304614);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/panel/MinusScreenPanel$onGridItemClick$1$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.multitask.c.c
  {
    b(b paramb, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, View paramView) {}
    
    private static final void a(b paramb, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, View paramView)
    {
      AppMethodBeat.i(304510);
      s.u(paramb, "this$0");
      s.u(paramMultiTaskInfo, "$taskInfo");
      s.u(paramdrt, "$animData");
      com.tencent.mm.plugin.multitask.ui.c localc = paramb.h(paramMultiTaskInfo);
      if (localc != null)
      {
        k localk = k.aeZF;
        ((com.tencent.mm.plugin.multitask.ui.uic.c)k.d(paramb.activity).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).k(paramMultiTaskInfo);
        paramdrt.XgN = System.currentTimeMillis();
        a.a.a((com.tencent.mm.plugin.multitask.ui.a)localc, paramView, paramMultiTaskInfo, paramdrt);
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onAnimationCancel,onGridItemClick, id:%s", new Object[] { paramMultiTaskInfo.field_id });
      }
      AppMethodBeat.o(304510);
    }
    
    private static final void b(b paramb, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, View paramView)
    {
      AppMethodBeat.i(304515);
      s.u(paramb, "this$0");
      s.u(paramMultiTaskInfo, "$taskInfo");
      s.u(paramdrt, "$animData");
      com.tencent.mm.plugin.multitask.ui.c localc = paramb.h(paramMultiTaskInfo);
      if (localc != null)
      {
        k localk = k.aeZF;
        ((com.tencent.mm.plugin.multitask.ui.uic.c)k.d(paramb.activity).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).k(paramMultiTaskInfo);
        paramdrt.XgN = System.currentTimeMillis();
        a.a.a((com.tencent.mm.plugin.multitask.ui.a)localc, paramView, paramMultiTaskInfo, paramdrt);
        Log.i("MicroMsg.MultiTask.MinusScreenPanel", "onAnimationEnd, onGridItemClick, id:%s", new Object[] { paramMultiTaskInfo.field_id });
      }
      AppMethodBeat.o(304515);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt) {}
    
    public final void aco(int paramInt)
    {
      AppMethodBeat.i(304534);
      com.tencent.threadpool.h.ahAA.bk(new b.b..ExternalSyntheticLambda0(this.LGw, paramMultiTaskInfo, localdrt, paramView2));
      AppMethodBeat.o(304534);
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(304540);
      com.tencent.threadpool.h.ahAA.bk(new b.b..ExternalSyntheticLambda1(this.LGw, paramMultiTaskInfo, localdrt, paramView2));
      AppMethodBeat.o(304540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.b
 * JD-Core Version:    0.7.0.1
 */