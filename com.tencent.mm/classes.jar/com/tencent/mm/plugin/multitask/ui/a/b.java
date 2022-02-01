package com.tencent.mm.plugin.multitask.ui.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.a.ot.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout;
import com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageEventId.Companion;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.k;
import com.tencent.mm.view.recyclerview.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoChangedListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "DOUBLE_CLICK_CHECK_INTERVAL", "", "ITEM_MAX_NUM", "", "getITEM_MAX_NUM", "()I", "VIEW_TYPE_HEADER", "getVIEW_TYPE_HEADER", "backIconView", "Landroid/widget/ImageView;", "getBackIconView", "()Landroid/widget/ImageView;", "setBackIconView", "(Landroid/widget/ImageView;)V", "clickTimestamp", "config", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;)V", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "lastOrientation", "mAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "getMAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setMAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "mFloatBallInited", "", "mItemGridClickListener", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "getMItemGridClickListener", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "setMItemGridClickListener", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;)V", "mMinusScreenViewListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1;", "minusScreenManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getMinusScreenManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "minusScreenManager$delegate", "Lkotlin/Lazy;", "multiTaskInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMultiTaskInfoList", "()Ljava/util/ArrayList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "recyclerViewRoot", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "getRecyclerViewRoot", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "setRecyclerViewRoot", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;)V", "screenResolution", "Landroid/graphics/Point;", "tipsGuideView", "Landroid/widget/TextView;", "getTipsGuideView", "()Landroid/widget/TextView;", "setTipsGuideView", "(Landroid/widget/TextView;)V", "visibleRect", "Landroid/graphics/Rect;", "getVisibleRect", "()Landroid/graphics/Rect;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "caculateMultiTaskFirstViewLayout", "", "checkLoadingState", "checkMultiInfoExist", "id", "", "checkMultiStateIfNeed", "checkTipsGuide", "isShow", "hasTipsDone", "convertFloatBallInfo", "doFlingItemAnimation", "doScrollAnimation", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "doScrollItemAnimation", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "doubleClickCheck", "findMultiTaskInfoListPos", "getLayoutId", "getMultiTaskItemPosition", "curPos", "way", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getTaskCount", "initAdapter", "initBallInfo", "initData", "initDataUI", "infoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needSnapShot", "scrollTop", "clearCache", "initUI", "isDataEmpty", "jumpUICFormSnapshot", "multiTaskInfo", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFloatBallInfoChanged", "ballInfoList", "", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "lastEnteredBallInfo", "onMultiTaskChange", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onMultiTaskInit", "obj", "", "onPanelSlide", "panel", "slideOffset", "", "enterTipsTransOffset", "refreshLayout", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setGridItemClickListener", "listener", "showSnapShotViewIfNeed", "taskInfo", "forceHide", "forceShow", "supportMultiTaskType", "multiTaskType", "triggerItemExposed", "Companion", "OnItemListener", "ui-multitask_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.ui.c
  implements com.tencent.mm.plugin.ball.c.d
{
  public static final b.a FMb;
  static final String TAG = "MicroMsg.MultiTask.MultiTaskMinusScreenUIC";
  final int FLO;
  private final long FLP;
  private volatile boolean FLQ;
  final ArrayList<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> FLR;
  final Rect FLS;
  MultiTaskCoordinatorLayout FLT;
  private TextView FLU;
  private ImageView FLV;
  public b FLW;
  private final kotlin.f FLX;
  com.tencent.mm.plugin.multitask.ui.minusscreen.a FLY;
  WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> FLZ;
  private final k FMa;
  private int lastOrientation;
  private View mXN;
  private long pSM;
  private Point sdD;
  WxRecyclerView xUj;
  private final int xvY;
  
  static
  {
    AppMethodBeat.i(197434);
    FMb = new b.a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskMinusScreenUIC";
    AppMethodBeat.o(197434);
  }
  
  public b(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(197433);
    this.FLO = 100;
    this.FLP = 1000L;
    this.FLR = new ArrayList();
    this.FLS = new Rect();
    this.FLX = kotlin.g.ar((kotlin.g.a.a)new l(this, paramAppCompatActivity));
    this.FLY = ((com.tencent.mm.plugin.multitask.ui.minusscreen.a)new com.tencent.mm.plugin.multitask.ui.minusscreen.c((List)this.FLR, (byte)0));
    this.lastOrientation = -1;
    this.sdD = new Point();
    this.FMa = new k(this);
    AppMethodBeat.o(197433);
  }
  
  private final void a(final List<? extends MultiTaskInfo> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(197392);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramList, paramBoolean3, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(197392);
  }
  
  private RecyclerView.LayoutManager fbQ()
  {
    AppMethodBeat.i(197350);
    RecyclerView.LayoutManager localLayoutManager = (RecyclerView.LayoutManager)this.FLX.getValue();
    AppMethodBeat.o(197350);
    return localLayoutManager;
  }
  
  private final void fbR()
  {
    int i = 0;
    AppMethodBeat.i(197389);
    if (this.FLQ)
    {
      Log.i(TAG, "convertFloatBallInfo, is Already done!");
      AppMethodBeat.o(197389);
      return;
    }
    List localList = ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).cvd();
    Log.i(TAG, "convertFloatBallInfo,size:%d", new Object[] { Integer.valueOf(localList.size()) });
    p.j(localList, "floatBallList");
    Iterator localIterator = ((Iterable)j.m((Iterable)localList)).iterator();
    if (localIterator.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)localIterator.next();
      Object localObject1 = com.tencent.mm.plugin.multitask.f.a.FNz;
      if (!com.tencent.mm.plugin.multitask.f.a.Of(localBallInfo.type)) {
        break label413;
      }
      this.FLQ = true;
      localObject1 = new MultiTaskInfo();
      ((MultiTaskInfo)localObject1).field_type = localBallInfo.type;
      ((MultiTaskInfo)localObject1).field_id = localBallInfo.key;
      ((MultiTaskInfo)localObject1).field_showData = new dar();
      ((MultiTaskInfo)localObject1).field_showData.nickname = localBallInfo.name;
      ((MultiTaskInfo)localObject1).field_showData.title = localBallInfo.desc;
      ((MultiTaskInfo)localObject1).field_showData.TIg = localBallInfo.icon;
      Object localObject2 = com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.FKQ;
      p.j(localBallInfo, "ballInfo");
      localObject2 = localBallInfo.mab;
      p.j(localObject2, "ballInfo.extra");
      com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.a.a((MultiTaskInfo)localObject1, localBallInfo, (Bundle)localObject2);
      localObject2 = (com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class);
      String str = ((MultiTaskInfo)localObject1).field_id;
      p.j(str, "multiTaskInfo.field_id");
      i = ((MultiTaskInfo)localObject1).field_type;
      dar localdar = ((MultiTaskInfo)localObject1).fbc();
      p.j(localdar, "multiTaskInfo.showData");
      ((com.tencent.mm.plugin.multitask.d)localObject2).addTaskInfoByBitmap(str, i, localdar, null, ((MultiTaskInfo)localObject1).field_data, null);
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
        com.tencent.mm.plugin.ball.service.d.cwb().clear();
      }
      AppMethodBeat.o(197389);
      return;
    }
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void a(RecyclerView paramRecyclerView, MinusScreenGridLayoutManager paramMinusScreenGridLayoutManager)
  {
    AppMethodBeat.i(197426);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramMinusScreenGridLayoutManager, "layoutManager");
    if (paramMinusScreenGridLayoutManager.getItemCount() <= 3)
    {
      AppMethodBeat.o(197426);
      return;
    }
    int k = paramMinusScreenGridLayoutManager.kJ();
    int n = paramMinusScreenGridLayoutManager.kL();
    int i;
    Object localObject2;
    Object localObject3;
    int j;
    if (k <= n)
    {
      i = k;
      localObject2 = paramRecyclerView.cJ(i);
      localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
        localObject1 = null;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.i)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.FIJ);
        localObject3 = ((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.multi_task_item_bg);
        if ((localObject2 != null) && (localObject3 != null))
        {
          ((View)localObject3).getLocalVisibleRect(this.FLS);
          if (paramMinusScreenGridLayoutManager.getItemCount() != 2) {
            break label259;
          }
          localObject3 = c.FNc;
          j = c.fct();
          label155:
          int m = j - this.FLS.height();
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
          localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.FIF);
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
        ((MinusScreenRoundFrameLayout)localObject2).Yk(j);
      }
      if (i != n)
      {
        i += 1;
        break;
        localObject3 = c.FNc;
        j = c.fcr();
        break label155;
      }
      AppMethodBeat.o(197426);
      return;
    }
  }
  
  public final void a(StorageObserverEvent<MultiTaskInfo> paramStorageObserverEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(197418);
    p.k(paramStorageObserverEvent, "event");
    final MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramStorageObserverEvent.getObj();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("onMultiTaskChange ").append(paramStorageObserverEvent.getEventId()).append(' ');
    if (localMultiTaskInfo != null) {}
    for (Object localObject1 = localMultiTaskInfo.field_id;; localObject1 = null)
    {
      Log.i(str, (String)localObject1);
      paramStorageObserverEvent = paramStorageObserverEvent.getEventId();
      if (!p.h(paramStorageObserverEvent, StorageEventId.Companion.getINSERT())) {
        break;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new m(this, localMultiTaskInfo));
      AppMethodBeat.o(197418);
      return;
    }
    if (p.h(paramStorageObserverEvent, StorageEventId.Companion.getDELETE()))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(this, localMultiTaskInfo));
      AppMethodBeat.o(197418);
      return;
    }
    if (p.h(paramStorageObserverEvent, StorageEventId.Companion.getUPDATE()))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o(this, localMultiTaskInfo));
      AppMethodBeat.o(197418);
      return;
    }
    localObject1 = com.tencent.mm.plugin.multitask.model.c.FHM;
    if (p.h(paramStorageObserverEvent, com.tencent.mm.plugin.multitask.model.c.fbe()))
    {
      localObject1 = ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).getMultiTaskStorage();
      paramStorageObserverEvent = localObject2;
      if (localObject1 != null) {
        paramStorageObserverEvent = ((com.tencent.mm.plugin.multitask.model.b)localObject1).fbd();
      }
      if (((paramStorageObserverEvent == null) || (paramStorageObserverEvent.size() != 2)) && ((paramStorageObserverEvent == null) || (paramStorageObserverEvent.size() != 3))) {
        break label281;
      }
    }
    label281:
    for (boolean bool = true;; bool = false)
    {
      a(paramStorageObserverEvent, false, true, bool);
      AppMethodBeat.o(197418);
      return;
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(197374);
    p.k(paramList, "ballInfoList");
    Log.i(TAG, "dataChanged");
    fbR();
    AppMethodBeat.o(197374);
  }
  
  public final boolean a(MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197403);
    int j = this.FLR.size();
    Object localObject2;
    if (j <= 1)
    {
      localObject1 = this.FLT;
      if (localObject1 != null)
      {
        localObject2 = MultiTaskCoordinatorLayout.FLJ;
        ((MultiTaskCoordinatorLayout)localObject1).setMode(MultiTaskCoordinatorLayout.fbO());
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = ((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).FMk;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.multitask.g.FEX;
        localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aRe(com.tencent.mm.plugin.multitask.g.fan());
        if ((localObject1 != null) && ((localObject1 instanceof d)))
        {
          localObject2 = (d)localObject1;
          ((d)localObject2).FNi = paramMultiTaskInfo;
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          com.tencent.mm.ui.component.g.b(((d)localObject2).getActivity()).i(c.class);
          if (paramMultiTaskInfo == null) {
            break label210;
          }
          i = paramMultiTaskInfo.field_type;
          label147:
          if (!c.Yo(i)) {
            break label216;
          }
          Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, teenmode!, forceShow:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(197403);
      return false;
      localObject1 = this.FLT;
      if (localObject1 == null) {
        break;
      }
      localObject2 = MultiTaskCoordinatorLayout.FLJ;
      ((MultiTaskCoordinatorLayout)localObject1).setMode(MultiTaskCoordinatorLayout.fbP());
      break;
      label210:
      i = -1;
      break label147;
      label216:
      localObject1 = com.tencent.mm.plugin.multitask.e.b.FHS;
      if ((com.tencent.mm.plugin.multitask.e.b.fbn()) || (j != 1))
      {
        if (j == 1)
        {
          localObject1 = com.tencent.mm.plugin.multitask.f.c.FNB;
          if (com.tencent.mm.plugin.multitask.f.c.fcN())
          {
            if (paramBoolean2) {
              ((d)localObject2).l(paramMultiTaskInfo);
            }
            Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, only one size!, forceShow:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
            AppMethodBeat.o(197403);
            return true;
          }
        }
        if (!paramBoolean1) {
          break label329;
        }
        paramMultiTaskInfo = com.tencent.mm.ui.component.g.Xox;
        ((c)com.tencent.mm.ui.component.g.b(((d)localObject2).getActivity()).i(c.class)).vo(true);
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, force hide!");
      }
    }
    label329:
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waD, 15);
    paramMultiTaskInfo = com.tencent.mm.kernel.h.aHG();
    p.j(paramMultiTaskInfo, "MMKernel.storage()");
    Object localObject1 = paramMultiTaskInfo.aHp().get(ar.a.VDR, "").toString();
    Object localObject3 = n.a((CharSequence)localObject1, new String[] { "|" });
    if (((List)localObject3).size() == 2)
    {
      paramMultiTaskInfo = (String)((List)localObject3).get(0);
      long l = Long.parseLong((String)((List)localObject3).get(1));
      localObject3 = ((d)localObject2).FNi;
      if ((paramMultiTaskInfo != null) && (localObject3 != null) && (cm.bfE() - l <= i * 60 * 1000) && (TextUtils.equals((CharSequence)paramMultiTaskInfo, (CharSequence)((MultiTaskInfo)localObject3).field_id)))
      {
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, in timeout!: ".concat(String.valueOf(i)));
        AppMethodBeat.o(197403);
        return true;
      }
    }
    if (!((d)localObject2).bVd())
    {
      paramMultiTaskInfo = ((d)localObject2).FNi;
      if (paramMultiTaskInfo != null) {}
      for (paramMultiTaskInfo = paramMultiTaskInfo.field_id;; paramMultiTaskInfo = null)
      {
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, is hide!, lastShowInfo:%s, currentShowId:%s, timeout: %d", new Object[] { localObject1, paramMultiTaskInfo, Integer.valueOf(i) });
        break;
      }
    }
    paramMultiTaskInfo = ((d)localObject2).FNi;
    if (paramMultiTaskInfo != null) {}
    for (paramMultiTaskInfo = paramMultiTaskInfo.field_id;; paramMultiTaskInfo = null)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, return false, lastShowInfo:%s, currentShowId:%s, timeout: %d", new Object[] { localObject1, paramMultiTaskInfo, Integer.valueOf(i) });
      AppMethodBeat.o(197403);
      return false;
    }
  }
  
  public final int aRf(String paramString)
  {
    AppMethodBeat.i(197405);
    if (paramString != null)
    {
      Object localObject1 = (Iterable)this.FLR;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        if (p.h(((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject2).FKP.field_id, paramString))
        {
          AppMethodBeat.o(197405);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(197405);
    return -1;
  }
  
  public final void ad(float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    AppMethodBeat.i(197401);
    Object localObject;
    if (paramFloat1 >= 0.5F)
    {
      paramFloat1 = (paramFloat1 - 0.5F) / 0.5F;
      if (paramFloat1 < 0.0F)
      {
        paramFloat1 = f;
        localObject = this.FLV;
        if (localObject != null) {
          ((ImageView)localObject).setAlpha(paramFloat1);
        }
        localObject = this.FLU;
        if (localObject != null) {
          ((TextView)localObject).setAlpha(paramFloat1);
        }
      }
    }
    for (;;)
    {
      localObject = this.FLT;
      if (localObject == null) {
        break label166;
      }
      c.a locala = c.FNc;
      paramFloat1 = -c.fcC();
      locala = c.FNc;
      ((MultiTaskCoordinatorLayout)localObject).setTranslationX(paramFloat1 + c.fcC() * paramFloat2);
      AppMethodBeat.o(197401);
      return;
      if (paramFloat1 > 1.0F)
      {
        paramFloat1 = 1.0F;
        break;
      }
      break;
      localObject = this.FLV;
      if (localObject != null) {
        ((ImageView)localObject).setAlpha(0.0F);
      }
      localObject = this.FLU;
      if (localObject != null) {
        ((TextView)localObject).setAlpha(0.0F);
      }
    }
    label166:
    AppMethodBeat.o(197401);
  }
  
  public final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197409);
    if (paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.multitask.e.b.FHS;
      com.tencent.mm.plugin.multitask.e.b.fbh();
      AppMethodBeat.o(197409);
      return;
    }
    Object localObject = com.tencent.mm.plugin.multitask.e.b.FHS;
    if ((!com.tencent.mm.plugin.multitask.e.b.fbg()) && (paramBoolean1))
    {
      localObject = this.FLU;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.FLU;
      if (localObject != null) {
        ((TextView)localObject).setAlpha(1.0F);
      }
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).Ym(2);
      AppMethodBeat.o(197409);
      return;
    }
    localObject = this.FLU;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(197409);
      return;
    }
    AppMethodBeat.o(197409);
  }
  
  public final void dGn()
  {
    AppMethodBeat.i(197424);
    Object localObject1 = this.xUj;
    Object localObject2;
    int i;
    int k;
    label68:
    label87:
    int j;
    label143:
    Object localObject3;
    c.a locala;
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
      i = ((MinusScreenGridLayoutManager)localObject1).kJ();
      k = ((MinusScreenGridLayoutManager)localObject1).kL();
      if (i > k) {
        break label580;
      }
      localObject1 = this.xUj;
      if (localObject1 == null) {
        break label331;
      }
      localObject1 = ((WxRecyclerView)localObject1).cJ(i);
      localObject2 = localObject1;
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.i)) {
        localObject2 = null;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.i)localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.xUj;
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
        localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.FIy);
        if (localObject2 != null)
        {
          localObject3 = c.FNc;
          ((View)localObject2).setTranslationX(c.fcv());
          localObject3 = c.FNc;
          ((View)localObject2).setTranslationY(c.fcu());
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = c.FNc;
          ((ViewGroup.LayoutParams)localObject3).height = c.fcp();
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = c.FNc;
          ((ViewGroup.LayoutParams)localObject3).width = c.fco();
          localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.multi_task_item_bg);
          if (localObject1 != null)
          {
            localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
            localObject3 = c.FNc;
            ((ViewGroup.LayoutParams)localObject1).height = c.fct();
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
        localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.FIy);
        if (localObject2 != null)
        {
          localObject3 = c.FNc;
          ((View)localObject2).setTranslationY(c.fcx());
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = c.FNc;
          ((ViewGroup.LayoutParams)localObject3).height = c.fcn();
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = c.FNc;
          ((ViewGroup.LayoutParams)localObject3).width = c.fcm();
          localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.multi_task_item_bg);
          if (localObject1 != null)
          {
            localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
            localObject3 = c.FNc;
            ((ViewGroup.LayoutParams)localObject1).height = c.fcr();
          }
          ((View)localObject2).requestLayout();
        }
      }
      else if (j >= 4)
      {
        localObject2 = ((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.FIy);
        if (localObject2 != null)
        {
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = c.FNc;
          ((ViewGroup.LayoutParams)localObject3).height = c.fcn();
          localObject3 = ((View)localObject2).getLayoutParams();
          locala = c.FNc;
          ((ViewGroup.LayoutParams)localObject3).width = c.fcm();
          localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.i)localObject1).amk.findViewById(e.c.multi_task_item_bg);
          if (localObject1 != null)
          {
            localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
            localObject3 = c.FNc;
            ((ViewGroup.LayoutParams)localObject1).height = c.fcr();
          }
          ((View)localObject2).requestLayout();
        }
      }
    }
    label580:
    AppMethodBeat.o(197424);
    return;
    label587:
    AppMethodBeat.o(197424);
  }
  
  public final a.b dKp()
  {
    return a.b.FHW;
  }
  
  public final void dp(Object paramObject)
  {
    AppMethodBeat.i(197373);
    super.dp(paramObject);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.d)this);
    paramObject = (RelativeLayout)getRootView().findViewById(e.c.FIW);
    p.j(paramObject, "titleView");
    Object localObject = paramObject.getLayoutParams();
    if (localObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(197373);
      throw paramObject;
    }
    localObject = (LinearLayout.LayoutParams)localObject;
    ((LinearLayout.LayoutParams)localObject).topMargin = ax.F((Context)getActivity(), -1);
    paramObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.FLV = ((ImageView)getRootView().findViewById(e.c.FIV));
    paramObject = this.FLV;
    if (paramObject != null) {
      paramObject.setOnClickListener((View.OnClickListener)new i(this));
    }
    this.FLU = ((TextView)getRootView().findViewById(e.c.FIz));
    this.FLY.a((com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.FMa);
    this.xUj = ((WxRecyclerView)getRootView().findViewById(e.c.FIT));
    this.FLT = ((MultiTaskCoordinatorLayout)getRootView().findViewById(e.c.FIU));
    paramObject = this.FLT;
    if (paramObject != null)
    {
      paramObject = paramObject.getViewTreeObserver();
      if (paramObject != null) {
        paramObject.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new j(this));
      }
    }
    paramObject = new FrameLayout((Context)getActivity());
    localObject = c.FNc;
    paramObject.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, c.fcB()));
    this.mXN = ((View)paramObject);
    paramObject = fbQ();
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager");
      AppMethodBeat.o(197373);
      throw paramObject;
    }
    ((MinusScreenGridLayoutManager)paramObject).FKp = ((RecyclerView)this.xUj);
    localObject = this.xUj;
    paramObject = localObject;
    if (!(localObject instanceof OverScrollMultiTaskRecyclerView)) {
      paramObject = null;
    }
    paramObject = (OverScrollMultiTaskRecyclerView)paramObject;
    if (paramObject != null)
    {
      paramObject = paramObject.getBehavior();
      if (paramObject != null) {
        paramObject.FLL = ((com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.FMa);
      }
    }
    this.FLZ = ((WxRecyclerAdapter)new b.c(this, this.FLY.dtg(), this.FLR));
    paramObject = this.xUj;
    if (paramObject != null)
    {
      paramObject.setLayoutManager(fbQ());
      paramObject.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.a.a((RecyclerView)paramObject, (com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.FMa));
      paramObject.setAdapter((RecyclerView.a)this.FLZ);
    }
    this.FLY.setAdapter(this.FLZ);
    paramObject = this.mXN;
    if (paramObject != null)
    {
      localObject = this.FLZ;
      if (localObject != null) {
        com.tencent.mm.view.recyclerview.h.a((com.tencent.mm.view.recyclerview.h)localObject, paramObject, this.xvY);
      }
    }
    paramObject = this.FLZ;
    if (paramObject != null) {
      paramObject.YSn = ((h.c)new d(this));
    }
    paramObject = this.FLZ;
    if (paramObject != null) {
      paramObject.YTa = ((m)new e(this));
    }
    paramObject = this.xUj;
    if (paramObject != null) {
      paramObject.a((RecyclerView.l)new b.f(this));
    }
    com.tencent.mm.ae.d.c("MultiTask_Thread", (kotlin.g.a.a)new g(this));
    AppMethodBeat.o(197373);
  }
  
  public final void fbS()
  {
    AppMethodBeat.i(197396);
    WxRecyclerAdapter localWxRecyclerAdapter = this.FLZ;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.onPause();
    }
    localWxRecyclerAdapter = this.FLZ;
    if (localWxRecyclerAdapter != null)
    {
      localWxRecyclerAdapter.onResume();
      AppMethodBeat.o(197396);
      return;
    }
    AppMethodBeat.o(197396);
  }
  
  public final void fbT()
  {
    boolean bool1 = true;
    AppMethodBeat.i(197407);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    boolean bool2 = ((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).fbW();
    if ((bool2) && (isDataEmpty()))
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      c.a((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class), true, false, false, false, false, false, true, 128);
    }
    fbU();
    ot.a locala;
    if (!bool2)
    {
      localObject = new ot();
      locala = ((ot)localObject).fNA;
      if (this.FLR.size() == 0) {
        break label132;
      }
    }
    for (;;)
    {
      locala.isVisible = bool1;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(197407);
      return;
      label132:
      bool1 = false;
    }
  }
  
  public final void fbU()
  {
    AppMethodBeat.i(197412);
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    if (!((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).fbW())
    {
      if (isDataEmpty())
      {
        localg = com.tencent.mm.ui.component.g.Xox;
        ((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).Yl(1);
        AppMethodBeat.o(197412);
        return;
      }
      localg = com.tencent.mm.ui.component.g.Xox;
      if (!((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).fcc())
      {
        localg = com.tencent.mm.ui.component.g.Xox;
        ((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).Yl(2);
      }
      AppMethodBeat.o(197412);
      return;
    }
    localg = com.tencent.mm.ui.component.g.Xox;
    ((c)com.tencent.mm.ui.component.g.b(getActivity()).i(c.class)).Yl(0);
    AppMethodBeat.o(197412);
  }
  
  public final long fbV()
  {
    AppMethodBeat.i(197420);
    long l = this.FLR.size();
    AppMethodBeat.o(197420);
    return l;
  }
  
  public final int getLayoutId()
  {
    return e.d.FJb;
  }
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(197398);
    if (this.FLR.size() == 0)
    {
      AppMethodBeat.o(197398);
      return true;
    }
    AppMethodBeat.o(197398);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(197422);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Point localPoint1 = this.sdD;
    Point localPoint2 = ar.au((Context)getContext());
    p.j(localPoint2, "UIUtils.getDisplayRealSize(context)");
    this.sdD = localPoint2;
    if ((ar.hIO()) && (ar.kL((Context)getContext()))) {
      this.sdD.x = ar.getDeviceWidth();
    }
    if (ar.hIH()) {
      this.sdD.x = ar.getDeviceHeight();
    }
    Log.i(TAG, "onConfigurationChanged lastOrientation:" + this.lastOrientation + ",orientation:" + paramConfiguration.orientation + ", screenResolution:" + this.sdD.x + ", lastScreenResolution:" + localPoint1.x);
    if ((this.lastOrientation != paramConfiguration.orientation) || ((localPoint1 != null) && ((localPoint1.x != this.sdD.x) || (localPoint1.y != this.sdD.y))))
    {
      this.lastOrientation = paramConfiguration.orientation;
      dGn();
    }
    AppMethodBeat.o(197422);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197352);
    super.onCreate(paramBundle);
    AppMethodBeat.o(197352);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(197355);
    super.onDestroy();
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.d)this);
    AppMethodBeat.o(197355);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "", "onGridItemClick", "", "firstView", "Landroid/view/View;", "targetView", "curPos", "", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needEnterAnim", "", "onGridItemDelete", "onGridItemExposed", "ui-multitask_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView1, View paramView2, int paramInt, MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean);
    
    public abstract void i(MultiTaskInfo paramMultiTaskInfo);
    
    public abstract void j(MultiTaskInfo paramMultiTaskInfo);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "ui-multitask_release"})
  public static final class d
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$5", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-multitask_release"})
  public static final class e
    implements m
  {
    public final void a(RecyclerView paramRecyclerView, k paramk)
    {
      AppMethodBeat.i(196405);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramk, "data");
      Iterator localIterator = ((Iterable)paramk.YSN).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paramk = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.iBO();
        }
        paramk = (com.tencent.mm.view.recyclerview.l)paramk;
        if ((paramk.YSP instanceof com.tencent.mm.plugin.multitask.ui.minusscreen.b.a))
        {
          Object localObject1 = com.tencent.mm.ui.component.g.Xox;
          if (((c)com.tencent.mm.ui.component.g.b(this.FMc.getActivity()).i(c.class)).fbW())
          {
            paramk = paramk.YSP;
            if (paramk == null)
            {
              paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.minusscreen.data.RVMultiTaskData");
              AppMethodBeat.o(196405);
              throw paramRecyclerView;
            }
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)paramk).FKP;
            if (localObject1 != null)
            {
              paramk = com.tencent.mm.plugin.secdata.ui.a.JbV;
              paramk = paramRecyclerView.getContext();
              p.j(paramk, "recyclerView.context");
              paramk = com.tencent.mm.plugin.secdata.ui.a.a.hU(paramk);
              if (paramk != null) {}
              for (paramk = (daq)paramk.aef(5);; paramk = null)
              {
                if (paramk != null)
                {
                  long l = this.FMc.aRf(((MultiTaskInfo)localObject1).field_id);
                  Object localObject2 = b.FMb;
                  Log.d(b.access$getTAG$cp(), "Item Exposed, itemId: %s, pos: %s", new Object[] { ((MultiTaskInfo)localObject1).field_id, Long.valueOf(l) });
                  localObject2 = com.tencent.mm.plugin.multitask.d.a.FHO;
                  localObject2 = ((MultiTaskInfo)localObject1).field_id;
                  p.j(localObject2, "multiTaskInfo.field_id");
                  com.tencent.mm.plugin.multitask.d.a.bc((String)localObject2, cm.bfE());
                  localObject2 = com.tencent.mm.plugin.multitask.d.a.FHO;
                  com.tencent.mm.plugin.multitask.d.a.a((MultiTaskInfo)localObject1, paramk.wmL, l, 1L, "");
                }
                paramk = this.FMc.FLW;
                if (paramk == null) {
                  break label309;
                }
                paramk.j((MultiTaskInfo)localObject1);
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
      AppMethodBeat.o(196405);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(b paramb, List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196536);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.FMc.al(false, true);
      paramView = com.tencent.mm.ui.component.g.Xox;
      c.a((c)com.tencent.mm.ui.component.g.b(this.FMc.getActivity()).i(c.class), true, true, false, false, false, false, false, 248);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196536);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initUI$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ui-multitask_release"})
  public static final class j
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(196340);
      Object localObject = this.FMc.FLT;
      if (localObject != null)
      {
        localObject = ((MultiTaskCoordinatorLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(196340);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.j paramj) {}
      
      public final void run()
      {
        AppMethodBeat.i(196132);
        Object localObject1 = this.FMf.FMc.getRootView().findViewById(e.c.FID);
        p.j(localObject1, "targetView");
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(196132);
          throw ((Throwable)localObject1);
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        c.a locala = c.FNc;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = c.fcl();
        locala = c.FNc;
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = c.fcB();
        locala = c.FNc;
        ((ViewGroup.MarginLayoutParams)localObject2).width = c.fcq();
        float f = ((ViewGroup.MarginLayoutParams)localObject2).width;
        locala = c.FNc;
        ((ViewGroup.MarginLayoutParams)localObject2).height = ((int)(f * c.fcF()));
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        AppMethodBeat.o(196132);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onGridItemAnimFinished", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemDelete", "taskInfo", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemOverScrollChanged", "ui-multitask_release"})
  public static final class k
    implements com.tencent.mm.plugin.multitask.ui.minusscreen.d.a
  {
    public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(196439);
      p.k(parami, "holder");
      if (parama != null)
      {
        Object localObject = parama.FKP;
        if (localObject != null)
        {
          ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).removeTaskInfoAndCoverImg(((MultiTaskInfo)localObject).field_id);
          localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
          parami = parami.getContext();
          p.j(parami, "holder.context");
          parami = com.tencent.mm.plugin.secdata.ui.a.a.hU(parami);
          if (parami != null) {}
          for (parami = (daq)parami.aef(5);; parami = null)
          {
            if (parami != null)
            {
              long l = this.FMc.aRf(parama.FKP.field_id);
              localObject = b.FMb;
              Log.d(b.access$getTAG$cp(), "Item deleted!, itemId: %s, pos: %s", new Object[] { parama.FKP.field_id, Long.valueOf(l) });
              localObject = com.tencent.mm.plugin.multitask.d.a.FHO;
              com.tencent.mm.plugin.multitask.d.a.a(parama.FKP, parami.wmL, l, 3L, "");
            }
            AppMethodBeat.o(196439);
            return;
          }
        }
      }
      AppMethodBeat.o(196439);
    }
    
    public final void ad(RecyclerView.v paramv)
    {
      int j = 0;
      AppMethodBeat.i(196447);
      p.k(paramv, "viewHolder");
      b localb = this.FMc;
      p.k(paramv, "viewHolder");
      Object localObject1 = localb.xUj;
      int i;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).getAdapter();
        if (localObject1 != null)
        {
          i = ((RecyclerView.a)localObject1).getItemCount();
          if (i > 3) {
            break label138;
          }
          localObject2 = paramv.amk.findViewById(e.c.FIJ);
          localObject1 = paramv.amk.findViewById(e.c.FIF);
          if ((localObject2 != null) && (localObject1 != null))
          {
            ((View)localObject2).setTranslationY(0.0F);
            if ((localObject1 instanceof MinusScreenRoundFrameLayout)) {
              break label368;
            }
          }
        }
      }
      label138:
      label350:
      label362:
      label368:
      for (paramv = null;; paramv = (RecyclerView.v)localObject1)
      {
        if ((MinusScreenRoundFrameLayout)paramv != null) {
          ((MinusScreenRoundFrameLayout)localObject1).Yk(0);
        }
        AppMethodBeat.o(196447);
        return;
        i = 0;
        break;
        localObject1 = localb.xUj;
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
            break label350;
          }
          int m = ((MinusScreenGridLayoutManager)localObject1).kJ();
          localObject1 = paramv.amk.findViewById(e.c.FIJ);
          localObject2 = paramv.amk.findViewById(e.c.multi_task_item_bg);
          if ((localObject1 != null) && (localObject2 != null))
          {
            ((View)localObject2).getLocalVisibleRect(localb.FLS);
            localObject2 = c.FNc;
            k = c.fcr() - localb.FLS.height();
            float f = k;
            localObject2 = c.FNc;
            i = j;
            if (f <= c.fcr() * 0.8F) {
              if (paramv.md() <= m + 1) {
                break label362;
              }
            }
          }
        }
        for (i = j;; i = k)
        {
          ((View)localObject1).setTranslationY(i);
          localObject1 = paramv.amk.findViewById(e.c.FIF);
          if (!(localObject1 instanceof MinusScreenRoundFrameLayout)) {}
          for (paramv = null;; paramv = (RecyclerView.v)localObject1)
          {
            if ((MinusScreenRoundFrameLayout)paramv != null) {
              ((MinusScreenRoundFrameLayout)localObject1).Yk(i);
            }
            AppMethodBeat.o(196447);
            return;
            localObject1 = null;
            break;
            AppMethodBeat.o(196447);
            return;
          }
        }
      }
    }
    
    public final void fbJ()
    {
      AppMethodBeat.i(196450);
      b localb = this.FMc;
      Object localObject1 = localb.xUj;
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
        localObject2 = localb.xUj;
        if (localObject2 == null) {
          break;
        }
        localb.a((RecyclerView)localObject2, (MinusScreenGridLayoutManager)localObject1);
        AppMethodBeat.o(196450);
        return;
      }
      AppMethodBeat.o(196450);
      return;
      label79:
      AppMethodBeat.o(196450);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    l(b paramb, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(b paramb, MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(b paramb, MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(b paramb, MultiTaskInfo paramMultiTaskInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.b
 * JD-Core Version:    0.7.0.1
 */