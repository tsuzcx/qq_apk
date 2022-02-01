package com.tencent.mm.plugin.multitask.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager;
import com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.a;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout;
import com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoChangedListener;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "DOUBLE_CLICK_CHECK_INTERVAL", "", "ITEM_MAX_NUM", "", "getITEM_MAX_NUM", "()I", "VIEW_TYPE_HEADER", "getVIEW_TYPE_HEADER", "clickTimestamp", "config", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;)V", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "lastOrientation", "mAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "getMAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setMAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "mFloatBallInited", "", "mItemGridClickListener", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "getMItemGridClickListener", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "setMItemGridClickListener", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;)V", "mMinusScreenViewListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1;", "minusScreenManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getMinusScreenManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "minusScreenManager$delegate", "Lkotlin/Lazy;", "multiTaskInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMultiTaskInfoList", "()Ljava/util/ArrayList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "recyclerViewRoot", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "getRecyclerViewRoot", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "setRecyclerViewRoot", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;)V", "screenResolution", "Landroid/graphics/Point;", "visibleRect", "Landroid/graphics/Rect;", "getVisibleRect", "()Landroid/graphics/Rect;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "caculateMultiTaskFirstViewLayout", "", "checkLoadingState", "checkMultiInfoExist", "id", "", "checkMultiStateIfNeed", "convertFloatBallInfo", "doFlingItemAnimation", "doScrollAnimation", "Landroid/support/v7/widget/RecyclerView;", "layoutManager", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "doScrollItemAnimation", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "doubleClickCheck", "findMultiTaskInfoListPos", "getLayoutId", "getMultiTaskItemPosition", "curPos", "way", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getTaskCount", "initAdapter", "initBallInfo", "initData", "initDataUI", "infoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needSnapShot", "scrollTop", "clearCache", "initUI", "isDataEmpty", "jumpUICFormSnapshot", "multiTaskInfo", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFloatBallInfoChanged", "ballInfoList", "", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "lastEnteredBallInfo", "onMultiTaskChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onMultiTaskInit", "obj", "", "refreshLayout", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setGridItemClickListener", "listener", "showSnapShotViewIfNeed", "taskInfo", "forceHide", "forceShow", "supportMultiTaskType", "multiTaskType", "triggerItemExposed", "Companion", "OnItemListener", "ui-multitask_release"})
public final class MultiTaskMinusScreenUIC
  extends MultiTaskUIComponent
  implements com.tencent.mm.plugin.ball.c.d
{
  public static final MultiTaskMinusScreenUIC.a Afu;
  static final String TAG = "MicroMsg.MultiTask.MultiTaskMinusScreenUIC";
  final int Afl;
  private final long Afm;
  final ArrayList<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> Afn;
  MultiTaskCoordinatorLayout Afo;
  public b Afp;
  private final f Afq;
  com.tencent.mm.plugin.multitask.ui.minusscreen.a Afr;
  WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> Afs;
  private final j Aft;
  private volatile boolean IZj;
  private View kgo;
  private int lastOrientation;
  private long mRS;
  private Point pbD;
  private final int tMh;
  WxRecyclerView ufR;
  final Rect vPN;
  
  static
  {
    AppMethodBeat.i(236638);
    Afu = new MultiTaskMinusScreenUIC.a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskMinusScreenUIC";
    AppMethodBeat.o(236638);
  }
  
  public MultiTaskMinusScreenUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236637);
    this.Afl = 100;
    this.Afm = 1000L;
    this.Afn = new ArrayList();
    this.vPN = new Rect();
    this.Afq = kotlin.g.ah((kotlin.g.a.a)new k(this, paramAppCompatActivity));
    this.Afr = ((com.tencent.mm.plugin.multitask.ui.minusscreen.a)new com.tencent.mm.plugin.multitask.ui.minusscreen.c((List)this.Afn, (byte)0));
    this.lastOrientation = -1;
    this.pbD = new Point();
    this.Aft = new j(this);
    AppMethodBeat.o(236637);
  }
  
  private final void a(final List<? extends MultiTaskInfo> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(236624);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, paramList, paramBoolean3, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(236624);
  }
  
  private final void eoD()
  {
    AppMethodBeat.i(236635);
    Object localObject1 = this.ufR;
    Object localObject2;
    int i;
    int k;
    label68:
    label87:
    int j;
    label143:
    Object localObject3;
    MultiTaskUIC.a locala;
    if (localObject1 != null)
    {
      localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
      localObject2 = localObject1;
      if (!(localObject1 instanceof MinusScreenGridLayoutManager)) {
        localObject2 = null;
      }
      localObject1 = (MinusScreenGridLayoutManager)localObject2;
      if (localObject1 == null) {
        break label587;
      }
      i = ((MinusScreenGridLayoutManager)localObject1).ks();
      k = ((MinusScreenGridLayoutManager)localObject1).ku();
      if (i > k) {
        break label580;
      }
      localObject1 = this.ufR;
      if (localObject1 == null) {
        break label331;
      }
      localObject1 = ((WxRecyclerView)localObject1).cg(i);
      localObject2 = localObject1;
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.h)) {
        localObject2 = null;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.h)localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.ufR;
        if (localObject2 == null) {
          break label337;
        }
        localObject2 = ((WxRecyclerView)localObject2).getAdapter();
        if (localObject2 == null) {
          break label337;
        }
        j = ((RecyclerView.a)localObject2).getItemCount();
        Log.i(TAG, "refreshLayout itemCount:" + j + ", pos:" + i);
        if (j != 2) {
          break label342;
        }
        localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131302800);
        if (localObject2 != null)
        {
          localObject3 = MultiTaskUIC.Ago;
          ((View)localObject2).setTranslationX(MultiTaskUIC.esn());
          localObject3 = MultiTaskUIC.Ago;
          ((View)localObject2).setTranslationY(MultiTaskUIC.esm());
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject3).height = MultiTaskUIC.esh();
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject3).width = MultiTaskUIC.esg();
          localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131305006);
          if (localObject1 != null)
          {
            localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
            localObject3 = MultiTaskUIC.Ago;
            ((ViewGroup.LayoutParams)localObject1).height = MultiTaskUIC.esl();
          }
          ((View)localObject2).requestLayout();
        }
      }
    }
    for (;;)
    {
      if (i == k) {
        break label580;
      }
      i += 1;
      break label68;
      localObject1 = null;
      break;
      label331:
      localObject1 = null;
      break label87;
      label337:
      j = 0;
      break label143;
      label342:
      if (j == 3)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131302800);
        if (localObject2 != null)
        {
          localObject3 = MultiTaskUIC.Ago;
          ((View)localObject2).setTranslationY(MultiTaskUIC.esp());
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject3).height = MultiTaskUIC.esf();
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject3).width = MultiTaskUIC.ese();
          localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131305006);
          if (localObject1 != null)
          {
            localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
            localObject3 = MultiTaskUIC.Ago;
            ((ViewGroup.LayoutParams)localObject1).height = MultiTaskUIC.esj();
          }
          ((View)localObject2).requestLayout();
        }
      }
      else if (j >= 4)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131302800);
        if (localObject2 != null)
        {
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject3).height = MultiTaskUIC.esf();
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = MultiTaskUIC.Ago;
          ((ViewGroup.LayoutParams)localObject3).width = MultiTaskUIC.ese();
          localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131305006);
          if (localObject1 != null)
          {
            localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
            localObject3 = MultiTaskUIC.Ago;
            ((ViewGroup.LayoutParams)localObject1).height = MultiTaskUIC.esj();
          }
          ((View)localObject2).requestLayout();
        }
      }
    }
    label580:
    AppMethodBeat.o(236635);
    return;
    label587:
    AppMethodBeat.o(236635);
  }
  
  private RecyclerView.LayoutManager erJ()
  {
    AppMethodBeat.i(236621);
    RecyclerView.LayoutManager localLayoutManager = (RecyclerView.LayoutManager)this.Afq.getValue();
    AppMethodBeat.o(236621);
    return localLayoutManager;
  }
  
  private final void gcP()
  {
    int i = 0;
    AppMethodBeat.i(258186);
    if (this.IZj)
    {
      Log.i(TAG, "convertFloatBallInfo, is Already done!");
      AppMethodBeat.o(258186);
      return;
    }
    List localList = ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chR();
    Log.i(TAG, "convertFloatBallInfo,size:%d", new Object[] { Integer.valueOf(localList.size()) });
    p.g(localList, "floatBallList");
    Iterator localIterator = ((Iterable)kotlin.a.j.m((Iterable)localList)).iterator();
    if (localIterator.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)localIterator.next();
      Object localObject1 = com.tencent.mm.plugin.multitask.f.a.AgJ;
      if (!com.tencent.mm.plugin.multitask.f.a.Js(localBallInfo.type)) {
        break label413;
      }
      this.IZj = true;
      localObject1 = new MultiTaskInfo();
      ((MultiTaskInfo)localObject1).field_type = localBallInfo.type;
      ((MultiTaskInfo)localObject1).field_id = localBallInfo.key;
      ((MultiTaskInfo)localObject1).field_showData = new cru();
      ((MultiTaskInfo)localObject1).field_showData.nickname = localBallInfo.name;
      ((MultiTaskInfo)localObject1).field_showData.title = localBallInfo.desc;
      ((MultiTaskInfo)localObject1).field_showData.MwR = localBallInfo.icon;
      Object localObject2 = com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.Aeo;
      p.g(localBallInfo, "ballInfo");
      localObject2 = localBallInfo.jkf;
      p.g(localObject2, "ballInfo.extra");
      a.a.a((MultiTaskInfo)localObject1, localBallInfo, (Bundle)localObject2);
      localObject2 = (com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class);
      String str = ((MultiTaskInfo)localObject1).field_id;
      p.g(str, "multiTaskInfo.field_id");
      i = ((MultiTaskInfo)localObject1).field_type;
      cru localcru = ((MultiTaskInfo)localObject1).erh();
      p.g(localcru, "multiTaskInfo.showData");
      ((com.tencent.mm.plugin.multitask.d)localObject2).addTaskInfoByBitmap(str, i, localcru, null, ((MultiTaskInfo)localObject1).field_data, null);
      Log.i(TAG, "convertFloatBallInfo, type:" + localBallInfo.type + ", id:" + localBallInfo.key + ", nickname:" + localBallInfo.name);
      i = 1;
    }
    label413:
    for (;;)
    {
      break;
      if ((localList.size() > 0) && (i != 0))
      {
        Log.i(TAG, "convertFloatBallInfo, clearData");
        com.tencent.mm.plugin.ball.service.e.ciJ().clear();
      }
      AppMethodBeat.o(258186);
      return;
    }
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void a(RecyclerView paramRecyclerView, MinusScreenGridLayoutManager paramMinusScreenGridLayoutManager)
  {
    AppMethodBeat.i(236636);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramMinusScreenGridLayoutManager, "layoutManager");
    if (paramMinusScreenGridLayoutManager.getItemCount() <= 3)
    {
      AppMethodBeat.o(236636);
      return;
    }
    int k = paramMinusScreenGridLayoutManager.ks();
    int n = paramMinusScreenGridLayoutManager.ku();
    int i;
    Object localObject2;
    Object localObject3;
    int j;
    if (k <= n)
    {
      i = k;
      localObject2 = paramRecyclerView.cg(i);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.h)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.h)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131305008);
        localObject3 = ((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131305006);
        if ((localObject2 != null) && (localObject3 != null))
        {
          ((View)localObject3).getLocalVisibleRect(this.vPN);
          if (paramMinusScreenGridLayoutManager.getItemCount() != 2) {
            break label259;
          }
          localObject3 = MultiTaskUIC.Ago;
          j = MultiTaskUIC.esl();
          label155:
          int m = j - this.vPN.height();
          if (m <= j * 0.8F)
          {
            j = m;
            if (i <= k + 1) {}
          }
          else
          {
            j = 0;
          }
          ((View)localObject2).setTranslationY(j);
          localObject2 = ((com.tencent.mm.view.recyclerview.h)localObject1).aus.findViewById(2131305003);
          if ((localObject2 instanceof MinusScreenRoundFrameLayout)) {
            break label279;
          }
        }
      }
    }
    label259:
    label279:
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      if ((MinusScreenRoundFrameLayout)localObject1 != null) {
        ((MinusScreenRoundFrameLayout)localObject2).RS(j);
      }
      if (i != n)
      {
        i += 1;
        break;
        localObject3 = MultiTaskUIC.Ago;
        j = MultiTaskUIC.esj();
        break label155;
      }
      AppMethodBeat.o(236636);
      return;
    }
  }
  
  public final void a(MStorageEventData paramMStorageEventData)
  {
    Object localObject3 = null;
    AppMethodBeat.i(236632);
    if (paramMStorageEventData != null)
    {
      Object localObject1 = paramMStorageEventData.obj;
      label29:
      Object localObject2;
      String str;
      StringBuilder localStringBuilder;
      if (localObject1 != null) {
        if ((localObject1 instanceof MultiTaskInfo))
        {
          localObject2 = localObject1;
          if (!(localObject1 instanceof MultiTaskInfo)) {
            localObject2 = null;
          }
          localObject2 = (MultiTaskInfo)localObject2;
          str = TAG;
          localStringBuilder = new StringBuilder("onMultiTaskChange ").append(paramMStorageEventData.eventId).append(' ');
          if (localObject2 == null) {
            break label165;
          }
        }
      }
      label165:
      for (localObject1 = ((MultiTaskInfo)localObject2).field_id;; localObject1 = null)
      {
        Log.i(str, (String)localObject1);
        switch (paramMStorageEventData.eventId)
        {
        case 4: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(236632);
          return;
          localObject1 = null;
          break label29;
          localObject1 = null;
          break label29;
        }
      }
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new l((MultiTaskInfo)localObject2, this));
      AppMethodBeat.o(236632);
      return;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new m((MultiTaskInfo)localObject2, this));
      AppMethodBeat.o(236632);
      return;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new n((MultiTaskInfo)localObject2, this));
      AppMethodBeat.o(236632);
      return;
      localObject1 = ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
      paramMStorageEventData = localObject3;
      if (localObject1 != null) {
        paramMStorageEventData = ((com.tencent.mm.plugin.multitask.model.a)localObject1).eri();
      }
      if (((paramMStorageEventData != null) && (paramMStorageEventData.size() == 2)) || ((paramMStorageEventData != null) && (paramMStorageEventData.size() == 3))) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramMStorageEventData, false, true, bool);
        break;
      }
    }
    AppMethodBeat.o(236632);
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(258185);
    p.h(paramList, "ballInfoList");
    Log.i(TAG, "dataChanged");
    gcP();
    AppMethodBeat.o(258185);
  }
  
  public final boolean a(MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236627);
    int j = this.Afn.size();
    Object localObject2;
    if (j <= 1)
    {
      localObject1 = this.Afo;
      if (localObject1 != null)
      {
        localObject2 = MultiTaskCoordinatorLayout.Afg;
        ((MultiTaskCoordinatorLayout)localObject1).setMode(MultiTaskCoordinatorLayout.erH());
      }
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).AfE;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
        localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aGP(com.tencent.mm.plugin.multitask.g.eqx());
        if ((localObject1 != null) && ((localObject1 instanceof SnapShotMultiTaskUIC)))
        {
          localObject2 = (SnapShotMultiTaskUIC)localObject1;
          ((SnapShotMultiTaskUIC)localObject2).Agu = paramMultiTaskInfo;
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          com.tencent.mm.ui.component.a.b(((SnapShotMultiTaskUIC)localObject2).getActivity()).get(MultiTaskUIC.class);
          if (paramMultiTaskInfo == null) {
            break label210;
          }
          i = paramMultiTaskInfo.field_type;
          label147:
          if (!MultiTaskUIC.RU(i)) {
            break label216;
          }
          Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, teenmode!, forceShow:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(236627);
      return false;
      localObject1 = this.Afo;
      if (localObject1 == null) {
        break;
      }
      localObject2 = MultiTaskCoordinatorLayout.Afg;
      ((MultiTaskCoordinatorLayout)localObject1).setMode(MultiTaskCoordinatorLayout.erI());
      break;
      label210:
      i = -1;
      break label147;
      label216:
      if (j == 1)
      {
        localObject1 = com.tencent.mm.plugin.multitask.f.c.AgL;
        if (com.tencent.mm.plugin.multitask.f.c.esD())
        {
          if (paramBoolean2) {
            ((SnapShotMultiTaskUIC)localObject2).m(paramMultiTaskInfo);
          }
          Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, only one size!, forceShow:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
          AppMethodBeat.o(236627);
          return true;
        }
      }
      if (!paramBoolean1) {
        break label312;
      }
      paramMultiTaskInfo = com.tencent.mm.ui.component.a.PRN;
      ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(((SnapShotMultiTaskUIC)localObject2).getActivity()).get(MultiTaskUIC.class)).sk(true);
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, force hide!");
    }
    label312:
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soU, 15);
    paramMultiTaskInfo = com.tencent.mm.kernel.g.aAh();
    p.g(paramMultiTaskInfo, "MMKernel.storage()");
    Object localObject1 = paramMultiTaskInfo.azQ().get(ar.a.Oot, "").toString();
    Object localObject3 = n.a((CharSequence)localObject1, new String[] { "|" });
    if (((List)localObject3).size() == 2)
    {
      paramMultiTaskInfo = (String)((List)localObject3).get(0);
      long l = Long.parseLong((String)((List)localObject3).get(1));
      localObject3 = ((SnapShotMultiTaskUIC)localObject2).Agu;
      if ((paramMultiTaskInfo != null) && (localObject3 != null) && (cl.aWA() - l <= i * 60 * 1000) && (TextUtils.equals((CharSequence)paramMultiTaskInfo, (CharSequence)((MultiTaskInfo)localObject3).field_id)))
      {
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, in timeout!: ".concat(String.valueOf(i)));
        AppMethodBeat.o(236627);
        return true;
      }
    }
    if (!((SnapShotMultiTaskUIC)localObject2).bJw())
    {
      paramMultiTaskInfo = ((SnapShotMultiTaskUIC)localObject2).Agu;
      if (paramMultiTaskInfo != null) {}
      for (paramMultiTaskInfo = paramMultiTaskInfo.field_id;; paramMultiTaskInfo = null)
      {
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, is hide!, lastShowInfo:%s, currentShowId:%s, timeout: %d", new Object[] { localObject1, paramMultiTaskInfo, Integer.valueOf(i) });
        break;
      }
    }
    paramMultiTaskInfo = ((SnapShotMultiTaskUIC)localObject2).Agu;
    if (paramMultiTaskInfo != null) {}
    for (paramMultiTaskInfo = paramMultiTaskInfo.field_id;; paramMultiTaskInfo = null)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, return false, lastShowInfo:%s, currentShowId:%s, timeout: %d", new Object[] { localObject1, paramMultiTaskInfo, Integer.valueOf(i) });
      AppMethodBeat.o(236627);
      return false;
    }
  }
  
  public final int aGQ(String paramString)
  {
    AppMethodBeat.i(236629);
    if (paramString != null)
    {
      Object localObject1 = (Iterable)this.Afn;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        if (p.j(((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject2).Aen.field_id, paramString))
        {
          AppMethodBeat.o(236629);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(236629);
    return -1;
  }
  
  public final void dk(Object paramObject)
  {
    AppMethodBeat.i(236623);
    super.dk(paramObject);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.d)this);
    paramObject = (FrameLayout)getRootView().findViewById(2131305081);
    p.g(paramObject, "titleView");
    Object localObject = paramObject.getLayoutParams();
    if (localObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(236623);
      throw paramObject;
    }
    localObject = (LinearLayout.LayoutParams)localObject;
    ((LinearLayout.LayoutParams)localObject).topMargin = au.D((Context)getActivity(), -1);
    paramObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Afr.a((com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.Aft);
    this.ufR = ((WxRecyclerView)getRootView().findViewById(2131305078));
    this.Afo = ((MultiTaskCoordinatorLayout)getRootView().findViewById(2131305079));
    paramObject = this.Afo;
    if (paramObject != null)
    {
      paramObject = paramObject.getViewTreeObserver();
      if (paramObject != null) {
        paramObject.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new i(this));
      }
    }
    paramObject = new FrameLayout((Context)getActivity());
    localObject = MultiTaskUIC.Ago;
    paramObject.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, MultiTaskUIC.est()));
    this.kgo = ((View)paramObject);
    paramObject = erJ();
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager");
      AppMethodBeat.o(236623);
      throw paramObject;
    }
    ((MinusScreenGridLayoutManager)paramObject).AdM = ((RecyclerView)this.ufR);
    localObject = this.ufR;
    paramObject = localObject;
    if (!(localObject instanceof OverScrollMultiTaskRecyclerView)) {
      paramObject = null;
    }
    paramObject = (OverScrollMultiTaskRecyclerView)paramObject;
    if (paramObject != null)
    {
      paramObject = paramObject.getBehavior();
      if (paramObject != null) {
        paramObject.Afi = ((com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.Aft);
      }
    }
    this.Afs = ((WxRecyclerAdapter)new MultiTaskMinusScreenUIC.c(this, this.Afr.dcK(), this.Afn));
    paramObject = this.ufR;
    if (paramObject != null)
    {
      paramObject.setLayoutManager(erJ());
      paramObject.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.a.a((RecyclerView)paramObject, (com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.Aft));
      paramObject.setAdapter((RecyclerView.a)this.Afs);
    }
    this.Afr.setAdapter(this.Afs);
    paramObject = this.kgo;
    if (paramObject != null)
    {
      localObject = this.Afs;
      if (localObject != null) {
        com.tencent.mm.view.recyclerview.g.a((com.tencent.mm.view.recyclerview.g)localObject, paramObject, this.tMh);
      }
    }
    paramObject = this.Afs;
    if (paramObject != null) {
      paramObject.RqP = ((g.c)new d(this));
    }
    paramObject = this.Afs;
    if (paramObject != null) {
      paramObject.RrA = ((com.tencent.mm.view.recyclerview.l)new e(this));
    }
    paramObject = this.ufR;
    if (paramObject != null) {
      paramObject.a((RecyclerView.l)new f(this));
    }
    com.tencent.mm.ac.d.c("MultiTask_Thread", (kotlin.g.a.a)new g(this));
    AppMethodBeat.o(236623);
  }
  
  public final a.b dks()
  {
    return a.b.Acg;
  }
  
  public final void erK()
  {
    AppMethodBeat.i(236625);
    WxRecyclerAdapter localWxRecyclerAdapter = this.Afs;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.onPause();
    }
    localWxRecyclerAdapter = this.Afs;
    if (localWxRecyclerAdapter != null)
    {
      localWxRecyclerAdapter.onResume();
      AppMethodBeat.o(236625);
      return;
    }
    AppMethodBeat.o(236625);
  }
  
  public final void erL()
  {
    AppMethodBeat.i(236630);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    boolean bool = ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).erO();
    if ((bool) && (isDataEmpty()))
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      MultiTaskUIC.a((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class));
    }
    erM();
    nw.a locala;
    if (!bool)
    {
      localObject = new nw();
      locala = ((nw)localObject).dTY;
      if (this.Afn.size() == 0) {
        break label120;
      }
    }
    label120:
    for (bool = true;; bool = false)
    {
      locala.isVisible = bool;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(236630);
      return;
    }
  }
  
  public final void erM()
  {
    AppMethodBeat.i(236631);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    if (!((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).erO())
    {
      if (isDataEmpty())
      {
        locala = com.tencent.mm.ui.component.a.PRN;
        ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).RT(1);
        AppMethodBeat.o(236631);
        return;
      }
      locala = com.tencent.mm.ui.component.a.PRN;
      if (!((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).erU())
      {
        locala = com.tencent.mm.ui.component.a.PRN;
        ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).RT(2);
      }
      AppMethodBeat.o(236631);
      return;
    }
    locala = com.tencent.mm.ui.component.a.PRN;
    ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MultiTaskUIC.class)).RT(0);
    AppMethodBeat.o(236631);
  }
  
  public final int getLayoutId()
  {
    return 2131495762;
  }
  
  public final long getTaskCount()
  {
    AppMethodBeat.i(236633);
    long l = this.Afn.size();
    AppMethodBeat.o(236633);
    return l;
  }
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(236626);
    if (this.Afn.size() == 0)
    {
      AppMethodBeat.o(236626);
      return true;
    }
    AppMethodBeat.o(236626);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(236634);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Point localPoint1 = this.pbD;
    Point localPoint2 = com.tencent.mm.ui.ao.az((Context)getContext());
    p.g(localPoint2, "UIUtils.getDisplayRealSize(context)");
    this.pbD = localPoint2;
    if ((com.tencent.mm.ui.ao.gJN()) && (aw.kB((Context)getContext()))) {
      this.pbD.x = com.tencent.mm.ui.ao.getDeviceWidth();
    }
    if (com.tencent.mm.ui.ao.gJK()) {
      this.pbD.x = com.tencent.mm.ui.ao.getDeviceHeight();
    }
    Log.i(TAG, "onConfigurationChanged lastOrientation:" + this.lastOrientation + ",orientation:" + paramConfiguration.orientation + ", screenResolution:" + this.pbD.x + ", lastScreenResolution:" + localPoint1.x);
    if ((this.lastOrientation != paramConfiguration.orientation) || ((localPoint1 != null) && ((localPoint1.x != this.pbD.x) || (localPoint1.y != this.pbD.y))))
    {
      this.lastOrientation = paramConfiguration.orientation;
      eoD();
    }
    AppMethodBeat.o(236634);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(236622);
    super.onCreate(paramBundle);
    AppMethodBeat.o(236622);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(258184);
    super.onDestroy();
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.d)this);
    AppMethodBeat.o(258184);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "", "onGridItemClick", "", "firstView", "Landroid/view/View;", "targetView", "curPos", "", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needEnterAnim", "", "onGridItemDelete", "onGridItemExposed", "ui-multitask_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView1, View paramView2, int paramInt, MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean);
    
    public abstract void j(MultiTaskInfo paramMultiTaskInfo);
    
    public abstract void k(MultiTaskInfo paramMultiTaskInfo);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "ui-multitask_release"})
  public static final class d
    implements g.c<com.tencent.mm.view.recyclerview.h>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$5", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-multitask_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.l
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(236607);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramj, "data");
      Iterator localIterator = ((Iterable)paramj.Rrn).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paramj = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        paramj = (k)paramj;
        if ((paramj.Rrp instanceof com.tencent.mm.plugin.multitask.ui.minusscreen.b.a))
        {
          Object localObject1 = com.tencent.mm.ui.component.a.PRN;
          if (((MultiTaskUIC)com.tencent.mm.ui.component.a.b(this.Afv.getActivity()).get(MultiTaskUIC.class)).erO())
          {
            paramj = paramj.Rrp;
            if (paramj == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.minusscreen.data.RVMultiTaskData");
              AppMethodBeat.o(236607);
              throw paramRecyclerView;
            }
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)paramj).Aen;
            if (localObject1 != null)
            {
              paramj = SecDataUIC.CWq;
              paramj = paramRecyclerView.getContext();
              p.g(paramj, "recyclerView.context");
              paramj = SecDataUIC.a.gU(paramj);
              if (paramj != null) {}
              for (paramj = (crt)paramj.Xh(5);; paramj = null)
              {
                if (paramj != null)
                {
                  long l = this.Afv.aGQ(((MultiTaskInfo)localObject1).field_id);
                  Object localObject2 = MultiTaskMinusScreenUIC.Afu;
                  Log.d(MultiTaskMinusScreenUIC.access$getTAG$cp(), "Item Exposed, itemId: %s, pos: %s", new Object[] { ((MultiTaskInfo)localObject1).field_id, Long.valueOf(l) });
                  localObject2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                  localObject2 = ((MultiTaskInfo)localObject1).field_id;
                  p.g(localObject2, "multiTaskInfo.field_id");
                  com.tencent.mm.plugin.multitask.d.a.bb((String)localObject2, cl.aWA());
                  localObject2 = com.tencent.mm.plugin.multitask.d.a.AbZ;
                  com.tencent.mm.plugin.multitask.d.a.a((MultiTaskInfo)localObject1, paramj.sGQ, l, 1L, "");
                }
                paramj = this.Afv.Afp;
                if (paramj == null) {
                  break label309;
                }
                paramj.k((MultiTaskInfo)localObject1);
                i = j;
                break;
              }
              label309:
              i = j;
              continue;
            }
          }
        }
        i = j;
      }
      AppMethodBeat.o(236607);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "ui-multitask_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(236609);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(236609);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(236608);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      localObject = localLayoutManager;
      if (!(localLayoutManager instanceof MinusScreenGridLayoutManager)) {
        localObject = null;
      }
      localObject = (MinusScreenGridLayoutManager)localObject;
      if (localObject != null) {
        this.Afv.a(paramRecyclerView, (MinusScreenGridLayoutManager)localObject);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(236608);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(MultiTaskMinusScreenUIC paramMultiTaskMinusScreenUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(MultiTaskMinusScreenUIC paramMultiTaskMinusScreenUIC, List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initUI$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ui-multitask_release"})
  public static final class i
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(236613);
      Object localObject = this.Afv.Afo;
      if (localObject != null)
      {
        localObject = ((MultiTaskCoordinatorLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(236613);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiTaskMinusScreenUIC.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(236612);
        Object localObject1 = this.Afz.Afv.getRootView().findViewById(2131305002);
        p.g(localObject1, "targetView");
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(236612);
          throw ((Throwable)localObject1);
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        MultiTaskUIC.a locala = MultiTaskUIC.Ago;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = MultiTaskUIC.esd();
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = MultiTaskUIC.est();
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.MarginLayoutParams)localObject2).width = MultiTaskUIC.esi();
        float f = ((ViewGroup.MarginLayoutParams)localObject2).width;
        locala = MultiTaskUIC.Ago;
        ((ViewGroup.MarginLayoutParams)localObject2).height = ((int)(f * MultiTaskUIC.esw()));
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        AppMethodBeat.o(236612);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onGridItemAnimFinished", "", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onItemDelete", "taskInfo", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemOverScrollChanged", "ui-multitask_release"})
  public static final class j
    implements com.tencent.mm.plugin.multitask.ui.minusscreen.d.a
  {
    public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(236614);
      p.h(paramh, "holder");
      if (parama != null)
      {
        Object localObject = parama.Aen;
        if (localObject != null)
        {
          ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).removeTaskInfoAndCoverImg(((MultiTaskInfo)localObject).field_id);
          localObject = SecDataUIC.CWq;
          paramh = paramh.getContext();
          p.g(paramh, "holder.context");
          paramh = SecDataUIC.a.gU(paramh);
          if (paramh != null) {}
          for (paramh = (crt)paramh.Xh(5);; paramh = null)
          {
            if (paramh != null)
            {
              long l = this.Afv.aGQ(parama.Aen.field_id);
              localObject = MultiTaskMinusScreenUIC.Afu;
              Log.d(MultiTaskMinusScreenUIC.access$getTAG$cp(), "Item deleted!, itemId: %s, pos: %s", new Object[] { parama.Aen.field_id, Long.valueOf(l) });
              localObject = com.tencent.mm.plugin.multitask.d.a.AbZ;
              com.tencent.mm.plugin.multitask.d.a.a(parama.Aen, paramh.sGQ, l, 3L, "");
            }
            AppMethodBeat.o(236614);
            return;
          }
        }
      }
      AppMethodBeat.o(236614);
    }
    
    public final void ac(RecyclerView.v paramv)
    {
      int j = 0;
      AppMethodBeat.i(236615);
      p.h(paramv, "viewHolder");
      MultiTaskMinusScreenUIC localMultiTaskMinusScreenUIC = this.Afv;
      p.h(paramv, "viewHolder");
      Object localObject1 = localMultiTaskMinusScreenUIC.ufR;
      int i;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).getAdapter();
        if (localObject1 != null)
        {
          i = ((RecyclerView.a)localObject1).getItemCount();
          if (i > 3) {
            break label136;
          }
          localObject2 = paramv.aus.findViewById(2131305008);
          localObject1 = paramv.aus.findViewById(2131305003);
          if ((localObject2 != null) && (localObject1 != null))
          {
            ((View)localObject2).setTranslationY(0.0F);
            if ((localObject1 instanceof MinusScreenRoundFrameLayout)) {
              break label363;
            }
          }
        }
      }
      label136:
      label345:
      label357:
      label363:
      for (paramv = null;; paramv = (RecyclerView.v)localObject1)
      {
        if ((MinusScreenRoundFrameLayout)paramv != null) {
          ((MinusScreenRoundFrameLayout)localObject1).RS(0);
        }
        AppMethodBeat.o(236615);
        return;
        i = 0;
        break;
        localObject1 = localMultiTaskMinusScreenUIC.ufR;
        int k;
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
          localObject2 = localObject1;
          if (!(localObject1 instanceof MinusScreenGridLayoutManager)) {
            localObject2 = null;
          }
          localObject1 = (MinusScreenGridLayoutManager)localObject2;
          if (localObject1 == null) {
            break label345;
          }
          int m = ((MinusScreenGridLayoutManager)localObject1).ks();
          localObject1 = paramv.aus.findViewById(2131305008);
          localObject2 = paramv.aus.findViewById(2131305006);
          if ((localObject1 != null) && (localObject2 != null))
          {
            ((View)localObject2).getLocalVisibleRect(localMultiTaskMinusScreenUIC.vPN);
            localObject2 = MultiTaskUIC.Ago;
            k = MultiTaskUIC.esj() - localMultiTaskMinusScreenUIC.vPN.height();
            float f = k;
            localObject2 = MultiTaskUIC.Ago;
            i = j;
            if (f <= MultiTaskUIC.esj() * 0.8F) {
              if (paramv.lR() <= m + 1) {
                break label357;
              }
            }
          }
        }
        for (i = j;; i = k)
        {
          ((View)localObject1).setTranslationY(i);
          localObject1 = paramv.aus.findViewById(2131305003);
          if (!(localObject1 instanceof MinusScreenRoundFrameLayout)) {}
          for (paramv = null;; paramv = (RecyclerView.v)localObject1)
          {
            if ((MinusScreenRoundFrameLayout)paramv != null) {
              ((MinusScreenRoundFrameLayout)localObject1).RS(i);
            }
            AppMethodBeat.o(236615);
            return;
            localObject1 = null;
            break;
            AppMethodBeat.o(236615);
            return;
          }
        }
      }
    }
    
    public final void erE()
    {
      AppMethodBeat.i(236616);
      MultiTaskMinusScreenUIC localMultiTaskMinusScreenUIC = this.Afv;
      Object localObject1 = localMultiTaskMinusScreenUIC.ufR;
      if (localObject1 != null) {}
      for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof MinusScreenGridLayoutManager)) {
          localObject2 = null;
        }
        localObject1 = (MinusScreenGridLayoutManager)localObject2;
        if (localObject1 == null) {
          break label79;
        }
        localObject2 = localMultiTaskMinusScreenUIC.ufR;
        if (localObject2 == null) {
          break;
        }
        localMultiTaskMinusScreenUIC.a((RecyclerView)localObject2, (MinusScreenGridLayoutManager)localObject1);
        AppMethodBeat.o(236616);
        return;
      }
      AppMethodBeat.o(236616);
      return;
      label79:
      AppMethodBeat.o(236616);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    k(MultiTaskMinusScreenUIC paramMultiTaskMinusScreenUIC, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$onMultiTaskChange$1$1"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(MultiTaskInfo paramMultiTaskInfo, MultiTaskMinusScreenUIC paramMultiTaskMinusScreenUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$onMultiTaskChange$1$2"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(MultiTaskInfo paramMultiTaskInfo, MultiTaskMinusScreenUIC paramMultiTaskMinusScreenUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$onMultiTaskChange$1$3"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(MultiTaskInfo paramMultiTaskInfo, MultiTaskMinusScreenUIC paramMultiTaskMinusScreenUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC
 * JD-Core Version:    0.7.0.1
 */