package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
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
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qd;
import com.tencent.mm.autogen.a.qd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.e.c;
import com.tencent.mm.plugin.multitask.ui.e.d;
import com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridLayoutManager;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.MinusScreenRoundFrameLayout;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskCoordinatorLayout;
import com.tencent.mm.plugin.multitask.ui.panel.OverScrollMultiTaskRecyclerView;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageEventId.Companion;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoChangedListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "DOUBLE_CLICK_CHECK_INTERVAL", "", "ITEM_MAX_NUM", "", "getITEM_MAX_NUM", "()I", "VIEW_TYPE_HEADER", "getVIEW_TYPE_HEADER", "backIconView", "Landroid/widget/ImageView;", "getBackIconView", "()Landroid/widget/ImageView;", "setBackIconView", "(Landroid/widget/ImageView;)V", "clickTimestamp", "config", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;)V", "dataObserver", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$dataObserver$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$dataObserver$1;", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "lastOrientation", "mAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "getMAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setMAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "mFloatBallInited", "", "mItemGridClickListener", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "getMItemGridClickListener", "()Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "setMItemGridClickListener", "(Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;)V", "mMinusScreenViewListener", "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1", "Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1;", "minusScreenManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getMinusScreenManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "minusScreenManager$delegate", "Lkotlin/Lazy;", "multiTaskInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMultiTaskInfoList", "()Ljava/util/ArrayList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "recyclerViewRoot", "Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "getRecyclerViewRoot", "()Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;", "setRecyclerViewRoot", "(Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskCoordinatorLayout;)V", "screenResolution", "Landroid/graphics/Point;", "tipsGuideView", "Landroid/widget/TextView;", "getTipsGuideView", "()Landroid/widget/TextView;", "setTipsGuideView", "(Landroid/widget/TextView;)V", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "visibleRect", "Landroid/graphics/Rect;", "getVisibleRect", "()Landroid/graphics/Rect;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "caculateMultiTaskFirstViewLayout", "", "checkLoadingState", "checkMultiInfoExist", "id", "", "checkMultiStateIfNeed", "checkTipsGuide", "isShow", "hasTipsDone", "convertFloatBallInfo", "doFlingItemAnimation", "doScrollAnimation", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutManager;", "doScrollItemAnimation", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "doubleClickCheck", "findMultiTaskInfoListPos", "getLayoutId", "getMultiTaskItemPosition", "curPos", "way", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getTaskCount", "initAdapter", "initBallInfo", "initData", "initDataUI", "infoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needSnapShot", "scrollTop", "clearCache", "initUI", "isDataEmpty", "jumpUICFormSnapshot", "multiTaskInfo", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFloatBallInfoChanged", "ballInfoList", "", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "lastEnteredBallInfo", "onMultiTaskChange", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onMultiTaskInit", "obj", "", "onPanelSlide", "panel", "slideOffset", "", "enterTipsTransOffset", "refreshLayout", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setGridItemClickListener", "listener", "showSnapShotViewIfNeed", "taskInfo", "forceHide", "forceShow", "supportMultiTaskType", "multiTaskType", "triggerItemExposed", "Companion", "OnItemListener", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.multitask.ui.c
  implements com.tencent.mm.plugin.ball.c.d
{
  public static final b.a LGS;
  static final String TAG;
  private final int ATI;
  WxRecyclerView AZd;
  final int LGT;
  private final long LGU;
  private volatile boolean LGV;
  final ArrayList<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> LGW;
  final Rect LGX;
  MultiTaskCoordinatorLayout LGY;
  private TextView LGZ;
  private ImageView LHa;
  public b LHb;
  private final kotlin.j LHc;
  com.tencent.mm.plugin.multitask.ui.minusscreen.a LHd;
  WxRecyclerAdapter<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> LHe;
  private final c LHf;
  private final k LHg;
  final Handler eLs;
  private int lastOrientation;
  private View pUv;
  private long sXL;
  private Point vpf;
  
  static
  {
    AppMethodBeat.i(304416);
    LGS = new b.a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskMinusScreenUIC";
    AppMethodBeat.o(304416);
  }
  
  public b(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(304325);
    this.LGT = 100;
    this.LGU = 1000L;
    this.LGW = new ArrayList();
    this.LGX = new Rect();
    this.LHc = kotlin.k.cm((kotlin.g.a.a)new l(this, paramAppCompatActivity));
    this.LHd = ((com.tencent.mm.plugin.multitask.ui.minusscreen.a)new com.tencent.mm.plugin.multitask.ui.minusscreen.c((List)this.LGW, (byte)0));
    this.lastOrientation = -1;
    this.vpf = new Point();
    this.eLs = new Handler(Looper.getMainLooper());
    this.LHf = new c(this);
    this.LHg = new k(this);
    AppMethodBeat.o(304325);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(304368);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.aF(false, true);
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramb = com.tencent.mm.ui.component.k.d(paramb.getActivity()).q(c.class);
    s.s(paramb, "of(activity).get(MultiTaskUIC::class.java)");
    c.a((c)paramb, true, true, false, false, false, false, false, 248);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304368);
  }
  
  private final void a(final List<? extends MultiTaskInfo> paramList, final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(304348);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, paramList, paramBoolean3, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(304348);
  }
  
  private RecyclerView.LayoutManager gkT()
  {
    AppMethodBeat.i(304333);
    RecyclerView.LayoutManager localLayoutManager = (RecyclerView.LayoutManager)this.LHc.getValue();
    AppMethodBeat.o(304333);
    return localLayoutManager;
  }
  
  private final void gkU()
  {
    int i = 0;
    AppMethodBeat.i(304343);
    if (this.LGV)
    {
      Log.i(TAG, "convertFloatBallInfo, is Already done!");
      AppMethodBeat.o(304343);
      return;
    }
    List localList = ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).cXN();
    Log.i(TAG, "convertFloatBallInfo,size:%d", new Object[] { Integer.valueOf(localList.size()) });
    s.s(localList, "floatBallList");
    Iterator localIterator = ((Iterable)p.m((Iterable)localList)).iterator();
    if (localIterator.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)localIterator.next();
      Object localObject1 = com.tencent.mm.plugin.multitask.f.a.LIu;
      if (!com.tencent.mm.plugin.multitask.f.a.Qs(localBallInfo.type)) {
        break label413;
      }
      this.LGV = true;
      localObject1 = new MultiTaskInfo();
      ((MultiTaskInfo)localObject1).field_type = localBallInfo.type;
      ((MultiTaskInfo)localObject1).field_id = localBallInfo.key;
      ((MultiTaskInfo)localObject1).field_showData = new drz();
      ((MultiTaskInfo)localObject1).field_showData.nickname = localBallInfo.name;
      ((MultiTaskInfo)localObject1).field_showData.title = localBallInfo.desc;
      ((MultiTaskInfo)localObject1).field_showData.aaXP = localBallInfo.icon;
      Object localObject2 = com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.LGb;
      s.s(localBallInfo, "ballInfo");
      localObject2 = localBallInfo.oSS;
      s.s(localObject2, "ballInfo.extra");
      com.tencent.mm.plugin.multitask.ui.minusscreen.c.a.a.a((MultiTaskInfo)localObject1, localBallInfo, (Bundle)localObject2);
      localObject2 = (com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class);
      String str = ((MultiTaskInfo)localObject1).field_id;
      s.s(str, "multiTaskInfo.field_id");
      i = ((MultiTaskInfo)localObject1).field_type;
      drz localdrz = ((MultiTaskInfo)localObject1).gkh();
      s.s(localdrz, "multiTaskInfo.showData");
      ((com.tencent.mm.plugin.multitask.d)localObject2).addTaskInfoByBitmap(str, i, localdrz, null, ((MultiTaskInfo)localObject1).field_data, null);
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
        com.tencent.mm.plugin.ball.service.d.cYL().clear();
      }
      AppMethodBeat.o(304343);
      return;
    }
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void a(RecyclerView paramRecyclerView, MinusScreenGridLayoutManager paramMinusScreenGridLayoutManager)
  {
    AppMethodBeat.i(304564);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramMinusScreenGridLayoutManager, "layoutManager");
    if (paramMinusScreenGridLayoutManager.getItemCount() <= 3)
    {
      AppMethodBeat.o(304564);
      return;
    }
    int k = paramMinusScreenGridLayoutManager.Ju();
    int n = paramMinusScreenGridLayoutManager.Jw();
    int i;
    Object localObject1;
    View localView;
    Object localObject2;
    label149:
    int m;
    if (k <= n)
    {
      i = k;
      localObject1 = paramRecyclerView.w(i, false);
      if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
        break label250;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 != null)
      {
        localView = ((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.LDT);
        localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.multi_task_item_bg);
        if ((localView != null) && (localObject2 != null))
        {
          ((View)localObject2).getLocalVisibleRect(this.LGX);
          if (paramMinusScreenGridLayoutManager.getItemCount() != 2) {
            break label256;
          }
          localObject2 = c.LHl;
          j = c.glw();
          m = j - this.LGX.height();
          if ((m <= j * 0.8F) && (i <= k + 1)) {
            break label282;
          }
        }
      }
    }
    label256:
    label275:
    label282:
    for (int j = 0;; j = m)
    {
      localView.setTranslationY(j);
      localView = ((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.LDP);
      if ((localView instanceof MinusScreenRoundFrameLayout)) {}
      for (localObject1 = (MinusScreenRoundFrameLayout)localView;; localObject1 = null)
      {
        if (localObject1 != null) {
          ((MinusScreenRoundFrameLayout)localView).acw(j);
        }
        if (i != n) {
          break label275;
        }
        AppMethodBeat.o(304564);
        return;
        label250:
        localObject1 = null;
        break;
        localObject2 = c.LHl;
        j = c.glu();
        break label149;
      }
      i += 1;
      break;
    }
  }
  
  public final void a(StorageObserverEvent<MultiTaskInfo> paramStorageObserverEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(304513);
    s.u(paramStorageObserverEvent, "event");
    MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramStorageObserverEvent.getObj();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("onMultiTaskChange ").append(paramStorageObserverEvent.getEventId()).append(' ');
    if (localMultiTaskInfo == null) {}
    for (Object localObject1 = null;; localObject1 = localMultiTaskInfo.field_id)
    {
      Log.i(str, localObject1);
      paramStorageObserverEvent = paramStorageObserverEvent.getEventId();
      if (!s.p(paramStorageObserverEvent, StorageEventId.Companion.getINSERT())) {
        break;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new m(localMultiTaskInfo, this));
      AppMethodBeat.o(304513);
      return;
    }
    if (s.p(paramStorageObserverEvent, StorageEventId.Companion.getDELETE()))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(localMultiTaskInfo, this));
      AppMethodBeat.o(304513);
      return;
    }
    if (s.p(paramStorageObserverEvent, StorageEventId.Companion.getUPDATE()))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o(localMultiTaskInfo, this));
      AppMethodBeat.o(304513);
      return;
    }
    localObject1 = com.tencent.mm.plugin.multitask.model.c.LDh;
    int i;
    label271:
    if (s.p(paramStorageObserverEvent, com.tencent.mm.plugin.multitask.model.c.gkj()))
    {
      paramStorageObserverEvent = ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).getMultiTaskStorage();
      if (paramStorageObserverEvent != null) {
        break label292;
      }
      paramStorageObserverEvent = localObject2;
      if ((paramStorageObserverEvent == null) || (paramStorageObserverEvent.size() != 2)) {
        break label300;
      }
      i = 1;
      label251:
      if (i == 0)
      {
        if ((paramStorageObserverEvent == null) || (paramStorageObserverEvent.size() != 3)) {
          break label305;
        }
        i = 1;
        if (i == 0) {
          break label310;
        }
      }
    }
    label292:
    label300:
    label305:
    label310:
    for (boolean bool = true;; bool = false)
    {
      a(paramStorageObserverEvent, false, true, bool);
      AppMethodBeat.o(304513);
      return;
      paramStorageObserverEvent = paramStorageObserverEvent.gki();
      break;
      i = 0;
      break label251;
      i = 0;
      break label271;
    }
  }
  
  public final void a(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(304453);
    s.u(paramList, "ballInfoList");
    Log.i(TAG, "dataChanged");
    gkU();
    AppMethodBeat.o(304453);
  }
  
  public final boolean a(MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(304476);
    int j = this.LGW.size();
    Object localObject2;
    if (j <= 1)
    {
      localObject1 = this.LGY;
      if (localObject1 != null)
      {
        localObject2 = MultiTaskCoordinatorLayout.LGJ;
        ((MultiTaskCoordinatorLayout)localObject1).setMode(MultiTaskCoordinatorLayout.gkR());
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).LHp;
      if (localObject1 != null)
      {
        localObject2 = g.LBa;
        localObject1 = ((com.tencent.mm.plugin.multitask.ui.panel.b)localObject1).aNW(g.gjs());
        if ((localObject1 != null) && ((localObject1 instanceof d)))
        {
          localObject2 = (d)localObject1;
          ((d)localObject2).LIj = paramMultiTaskInfo;
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          com.tencent.mm.ui.component.k.d(((d)localObject2).getActivity()).q(c.class);
          if (paramMultiTaskInfo != null) {
            break label207;
          }
          i = -1;
          label144:
          if (!c.acA(i)) {
            break label216;
          }
          Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, teenmode!, forceShow:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(304476);
      return false;
      localObject1 = this.LGY;
      if (localObject1 == null) {
        break;
      }
      localObject2 = MultiTaskCoordinatorLayout.LGJ;
      ((MultiTaskCoordinatorLayout)localObject1).setMode(MultiTaskCoordinatorLayout.gkS());
      break;
      label207:
      i = paramMultiTaskInfo.field_type;
      break label144;
      label216:
      localObject1 = com.tencent.mm.plugin.multitask.e.b.LDn;
      if ((com.tencent.mm.plugin.multitask.e.b.gks()) || (j != 1))
      {
        if (j == 1)
        {
          localObject1 = com.tencent.mm.plugin.multitask.f.c.LIw;
          if (com.tencent.mm.plugin.multitask.f.c.glQ())
          {
            if (paramBoolean2) {
              ((d)localObject2).l(paramMultiTaskInfo);
            }
            Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, only one size!, forceShow:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
            AppMethodBeat.o(304476);
            return true;
          }
        }
        if (!paramBoolean1) {
          break label329;
        }
        paramMultiTaskInfo = com.tencent.mm.ui.component.k.aeZF;
        ((c)com.tencent.mm.ui.component.k.d(((d)localObject2).getActivity()).q(c.class)).zG(true);
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, force hide!");
      }
    }
    label329:
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zue, 15);
    Object localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adgS, "").toString();
    Object localObject3 = kotlin.n.n.a((CharSequence)localObject1, new String[] { "|" });
    if (((List)localObject3).size() == 2)
    {
      paramMultiTaskInfo = (String)((List)localObject3).get(0);
      long l = Long.parseLong((String)((List)localObject3).get(1));
      localObject3 = ((d)localObject2).LIj;
      if ((paramMultiTaskInfo != null) && (localObject3 != null) && (cn.bDw() - l <= i * 60 * 1000) && (TextUtils.equals((CharSequence)paramMultiTaskInfo, (CharSequence)((MultiTaskInfo)localObject3).field_id)))
      {
        Log.i("MicroMsg.SnapShotMultiTaskUIC", s.X("checkSnapShot, in timeout!: ", Integer.valueOf(i)));
        AppMethodBeat.o(304476);
        return true;
      }
    }
    if (!((d)localObject2).cvt())
    {
      paramMultiTaskInfo = ((d)localObject2).LIj;
      if (paramMultiTaskInfo == null) {}
      for (paramMultiTaskInfo = null;; paramMultiTaskInfo = paramMultiTaskInfo.field_id)
      {
        Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, is hide!, lastShowInfo:%s, currentShowId:%s, timeout: %d", new Object[] { localObject1, paramMultiTaskInfo, Integer.valueOf(i) });
        break;
      }
    }
    paramMultiTaskInfo = ((d)localObject2).LIj;
    if (paramMultiTaskInfo == null) {}
    for (paramMultiTaskInfo = null;; paramMultiTaskInfo = paramMultiTaskInfo.field_id)
    {
      Log.i("MicroMsg.SnapShotMultiTaskUIC", "checkSnapShot, return false, lastShowInfo:%s, currentShowId:%s, timeout: %d", new Object[] { localObject1, paramMultiTaskInfo, Integer.valueOf(i) });
      AppMethodBeat.o(304476);
      return false;
    }
  }
  
  public final void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(304498);
    if (paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
      com.tencent.mm.plugin.multitask.e.b.gkm();
      AppMethodBeat.o(304498);
      return;
    }
    Object localObject = com.tencent.mm.plugin.multitask.e.b.LDn;
    if ((!com.tencent.mm.plugin.multitask.e.b.gkl()) && (paramBoolean1))
    {
      localObject = this.LGZ;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.LGZ;
      if (localObject != null) {
        ((TextView)localObject).setAlpha(1.0F);
      }
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).acy(2);
      AppMethodBeat.o(304498);
      return;
    }
    localObject = this.LGZ;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(304498);
  }
  
  public final void aI(float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    AppMethodBeat.i(304467);
    Object localObject;
    if (paramFloat1 >= 0.5F)
    {
      paramFloat1 = (paramFloat1 - 0.5F) / 0.5F;
      if (paramFloat1 < 0.0F)
      {
        paramFloat1 = f;
        localObject = this.LHa;
        if (localObject != null) {
          ((ImageView)localObject).setAlpha(paramFloat1);
        }
        localObject = this.LGZ;
        if (localObject != null) {
          ((TextView)localObject).setAlpha(paramFloat1);
        }
      }
    }
    for (;;)
    {
      localObject = this.LGY;
      if (localObject != null)
      {
        c.a locala = c.LHl;
        paramFloat1 = -c.glF();
        locala = c.LHl;
        ((MultiTaskCoordinatorLayout)localObject).setTranslationX(paramFloat1 + c.glF() * paramFloat2);
      }
      AppMethodBeat.o(304467);
      return;
      if (paramFloat1 > 1.0F)
      {
        paramFloat1 = 1.0F;
        break;
      }
      break;
      localObject = this.LHa;
      if (localObject != null) {
        ((ImageView)localObject).setAlpha(0.0F);
      }
      localObject = this.LGZ;
      if (localObject != null) {
        ((TextView)localObject).setAlpha(0.0F);
      }
    }
  }
  
  public final int aNX(String paramString)
  {
    AppMethodBeat.i(304483);
    if (paramString != null)
    {
      Object localObject1 = (Iterable)this.LGW;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        if (s.p(((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)localObject2).LGa.field_id, paramString))
        {
          AppMethodBeat.o(304483);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(304483);
    return -1;
  }
  
  public final a.b eDe()
  {
    return a.b.LDp;
  }
  
  public final void exz()
  {
    AppMethodBeat.i(304558);
    Object localObject1 = this.AZd;
    label35:
    int j;
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof MinusScreenGridLayoutManager)) {
        break label296;
      }
      localObject1 = (MinusScreenGridLayoutManager)localObject1;
      if (localObject1 != null)
      {
        j = ((MinusScreenGridLayoutManager)localObject1).Ju();
        k = ((MinusScreenGridLayoutManager)localObject1).Jw();
        if (j > k) {}
      }
    }
    for (;;)
    {
      localObject1 = this.AZd;
      label71:
      label86:
      Object localObject2;
      int i;
      label104:
      Object localObject3;
      c.a locala;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof com.tencent.mm.view.recyclerview.j)) {
          break label314;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.j)localObject1;
        if (localObject1 != null)
        {
          localObject2 = this.AZd;
          if (localObject2 != null) {
            break label320;
          }
          i = 0;
          Log.i(TAG, "refreshLayout itemCount:" + i + ", pos:" + j);
          if (i != 2) {
            break label346;
          }
          localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.LDI);
          if (localObject2 != null)
          {
            localObject3 = c.LHl;
            ((View)localObject2).setTranslationX(c.gly());
            localObject3 = c.LHl;
            ((View)localObject2).setTranslationY(c.glx());
            localObject3 = ((View)localObject2).getLayoutParams();
            locala = c.LHl;
            ((ViewGroup.LayoutParams)localObject3).height = c.gls();
            localObject3 = ((View)localObject2).getLayoutParams();
            locala = c.LHl;
            ((ViewGroup.LayoutParams)localObject3).width = c.glr();
            localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.multi_task_item_bg);
            if (localObject1 != null)
            {
              localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
              localObject3 = c.LHl;
              ((ViewGroup.LayoutParams)localObject1).height = c.glw();
            }
            ((View)localObject2).requestLayout();
          }
        }
      }
      for (;;)
      {
        if (j != k) {
          break label584;
        }
        AppMethodBeat.o(304558);
        return;
        localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
        break;
        label296:
        localObject1 = null;
        break label35;
        localObject1 = ((RecyclerView)localObject1).w(j, false);
        break label71;
        label314:
        localObject1 = null;
        break label86;
        label320:
        localObject2 = ((WxRecyclerView)localObject2).getAdapter();
        if (localObject2 == null)
        {
          i = 0;
          break label104;
        }
        i = ((RecyclerView.a)localObject2).getItemCount();
        break label104;
        label346:
        if (i == 3)
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.LDI);
          if (localObject2 != null)
          {
            localObject3 = c.LHl;
            ((View)localObject2).setTranslationY(c.glA());
            localObject3 = ((View)localObject2).getLayoutParams();
            locala = c.LHl;
            ((ViewGroup.LayoutParams)localObject3).height = c.glq();
            localObject3 = ((View)localObject2).getLayoutParams();
            locala = c.LHl;
            ((ViewGroup.LayoutParams)localObject3).width = c.glp();
            localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.multi_task_item_bg);
            if (localObject1 != null)
            {
              localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
              localObject3 = c.LHl;
              ((ViewGroup.LayoutParams)localObject1).height = c.glu();
            }
            ((View)localObject2).requestLayout();
          }
        }
        else if (i >= 4)
        {
          localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.LDI);
          if (localObject2 != null)
          {
            localObject3 = ((View)localObject2).getLayoutParams();
            locala = c.LHl;
            ((ViewGroup.LayoutParams)localObject3).height = c.glq();
            localObject3 = ((View)localObject2).getLayoutParams();
            locala = c.LHl;
            ((ViewGroup.LayoutParams)localObject3).width = c.glp();
            localObject1 = (RoundedCornerFrameLayout)((com.tencent.mm.view.recyclerview.j)localObject1).caK.findViewById(e.c.multi_task_item_bg);
            if (localObject1 != null)
            {
              localObject1 = ((RoundedCornerFrameLayout)localObject1).getLayoutParams();
              localObject3 = c.LHl;
              ((ViewGroup.LayoutParams)localObject1).height = c.glu();
            }
            ((View)localObject2).requestLayout();
          }
        }
      }
      label584:
      j += 1;
    }
  }
  
  public final void fw(Object paramObject)
  {
    AppMethodBeat.i(304448);
    super.fw(paramObject);
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a((com.tencent.mm.plugin.ball.c.d)this);
    paramObject = (RelativeLayout)getRootView().findViewById(e.c.LEi);
    Object localObject = paramObject.getLayoutParams();
    if (localObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(304448);
      throw paramObject;
    }
    localObject = (LinearLayout.LayoutParams)localObject;
    ((LinearLayout.LayoutParams)localObject).topMargin = bf.I((Context)getActivity(), -1);
    paramObject.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.LHa = ((ImageView)getRootView().findViewById(e.c.LEh));
    paramObject = this.LHa;
    if (paramObject != null) {
      paramObject.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    }
    this.LGZ = ((TextView)getRootView().findViewById(e.c.LDJ));
    this.LHd.a((com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.LHg);
    this.AZd = ((WxRecyclerView)getRootView().findViewById(e.c.LEf));
    this.LGY = ((MultiTaskCoordinatorLayout)getRootView().findViewById(e.c.LEg));
    paramObject = this.LGY;
    if (paramObject != null)
    {
      paramObject = paramObject.getViewTreeObserver();
      if (paramObject != null) {
        paramObject.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new j(this));
      }
    }
    paramObject = new FrameLayout((Context)getActivity());
    localObject = c.LHl;
    paramObject.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, c.glE()));
    localObject = ah.aiuX;
    this.pUv = ((View)paramObject);
    ((MinusScreenGridLayoutManager)gkT()).LFF = ((RecyclerView)this.AZd);
    paramObject = this.AZd;
    if ((paramObject instanceof OverScrollMultiTaskRecyclerView)) {}
    for (paramObject = (OverScrollMultiTaskRecyclerView)paramObject;; paramObject = null)
    {
      if (paramObject != null)
      {
        paramObject = paramObject.getBehavior();
        if (paramObject != null) {
          paramObject.LGR = ((com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.LHg);
        }
      }
      this.LHe = ((WxRecyclerAdapter)new b.d(this, this.LHd.ech(), this.LGW));
      paramObject = this.LHe;
      if (paramObject != null) {
        paramObject.a((RecyclerView.c)this.LHf);
      }
      paramObject = this.AZd;
      if (paramObject != null)
      {
        paramObject.setLayoutManager(gkT());
        paramObject.setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.a.a((RecyclerView)paramObject, (com.tencent.mm.plugin.multitask.ui.minusscreen.d.a)this.LHg));
        paramObject.setAdapter((RecyclerView.a)this.LHe);
      }
      this.LHd.setAdapter(this.LHe);
      paramObject = this.pUv;
      if (paramObject != null)
      {
        localObject = this.LHe;
        if (localObject != null) {
          com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)localObject, paramObject, this.ATI);
        }
      }
      paramObject = this.LHe;
      if (paramObject != null) {
        paramObject.agOe = ((i.c)new e(this));
      }
      paramObject = this.LHe;
      if (paramObject != null) {
        paramObject.agOS = ((o)new f(this));
      }
      paramObject = this.AZd;
      if (paramObject != null) {
        paramObject.a((RecyclerView.l)new b.g(this));
      }
      com.tencent.mm.ae.d.e("MultiTask_Thread", (kotlin.g.a.a)new b.h(this));
      AppMethodBeat.o(304448);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return e.d.LEm;
  }
  
  public final void gkV()
  {
    AppMethodBeat.i(304456);
    WxRecyclerAdapter localWxRecyclerAdapter = this.LHe;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.onPause();
    }
    localWxRecyclerAdapter = this.LHe;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.onResume();
    }
    AppMethodBeat.o(304456);
  }
  
  public final void gkW()
  {
    boolean bool1 = true;
    AppMethodBeat.i(304493);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    boolean bool2 = ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).gkZ();
    if ((bool2) && (isDataEmpty()))
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(c.class);
      s.s(localObject, "of(activity).get(MultiTaskUIC::class.java)");
      c.a((c)localObject, true, false, false, false, false, false, true, 128);
    }
    gkX();
    qd.a locala;
    if (!bool2)
    {
      localObject = new qd();
      locala = ((qd)localObject).hTn;
      if (this.LGW.size() == 0) {
        break label135;
      }
    }
    for (;;)
    {
      locala.isVisible = bool1;
      ((qd)localObject).publish();
      AppMethodBeat.o(304493);
      return;
      label135:
      bool1 = false;
    }
  }
  
  public final void gkX()
  {
    AppMethodBeat.i(304506);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    if (!((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).gkZ())
    {
      if (isDataEmpty())
      {
        localk = com.tencent.mm.ui.component.k.aeZF;
        ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).acx(1);
        AppMethodBeat.o(304506);
        return;
      }
      localk = com.tencent.mm.ui.component.k.aeZF;
      if (!((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).glg())
      {
        localk = com.tencent.mm.ui.component.k.aeZF;
        ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).acx(2);
        AppMethodBeat.o(304506);
      }
    }
    else
    {
      localk = com.tencent.mm.ui.component.k.aeZF;
      ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).acx(0);
    }
    AppMethodBeat.o(304506);
  }
  
  public final long gkY()
  {
    AppMethodBeat.i(304535);
    long l = this.LGW.size();
    AppMethodBeat.o(304535);
    return l;
  }
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(304463);
    if (this.LGW.size() == 0)
    {
      AppMethodBeat.o(304463);
      return true;
    }
    AppMethodBeat.o(304463);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(304544);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Point localPoint1 = this.vpf;
    Point localPoint2 = aw.bf((Context)getContext());
    s.s(localPoint2, "getDisplayRealSize(context)");
    this.vpf = localPoint2;
    if ((aw.jlc()) && (aw.mO((Context)getContext()))) {
      this.vpf.x = aw.getDeviceWidth();
    }
    if (aw.jkS()) {
      this.vpf.x = aw.getDeviceHeight();
    }
    Log.i(TAG, "onConfigurationChanged lastOrientation:" + this.lastOrientation + ",orientation:" + Integer.valueOf(paramConfiguration.orientation) + ", screenResolution:" + this.vpf.x + ", lastScreenResolution:" + localPoint1.x);
    if ((this.lastOrientation != paramConfiguration.orientation) || ((localPoint1 != null) && ((localPoint1.x != this.vpf.x) || (localPoint1.y != this.vpf.y))))
    {
      this.lastOrientation = paramConfiguration.orientation;
      exz();
    }
    AppMethodBeat.o(304544);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(304428);
    super.onCreate(paramBundle);
    AppMethodBeat.o(304428);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(304431);
    super.onDestroy();
    WxRecyclerAdapter localWxRecyclerAdapter = this.LHe;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.b((RecyclerView.c)this.LHf);
    }
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b((com.tencent.mm.plugin.ball.c.d)this);
    AppMethodBeat.o(304431);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$OnItemListener;", "", "onGridItemClick", "", "firstView", "Landroid/view/View;", "targetView", "curPos", "", "taskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "needEnterAnim", "", "onGridItemDelete", "onGridItemExposed", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(View paramView1, View paramView2, int paramInt, MultiTaskInfo paramMultiTaskInfo, boolean paramBoolean);
    
    public abstract void i(MultiTaskInfo paramMultiTaskInfo);
    
    public abstract void j(MultiTaskInfo paramMultiTaskInfo);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onItemRangeChanged", "", "positionStart", "", "itemCount", "payload", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.c
  {
    c(b paramb) {}
    
    private static final void a(b paramb, RecyclerView.f paramf)
    {
      AppMethodBeat.i(304241);
      s.u(paramb, "this$0");
      s.u(paramf, "$it");
      paramb = paramb.AZd;
      if (paramb != null) {
        paramb.setItemAnimator(paramf);
      }
      AppMethodBeat.o(304241);
    }
    
    private static final void b(b paramb, RecyclerView.f paramf)
    {
      AppMethodBeat.i(304249);
      s.u(paramb, "this$0");
      s.u(paramf, "$it");
      paramb = paramb.AZd;
      if (paramb != null) {
        paramb.setItemAnimator(paramf);
      }
      AppMethodBeat.o(304249);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(304265);
      Object localObject1 = this.LHh.AZd;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((WxRecyclerView)localObject1).getItemAnimator())
      {
        if (localObject1 != null)
        {
          b localb = this.LHh;
          Object localObject2 = b.LGS;
          Log.w(b.access$getTAG$cp(), s.X("originItemAnimator=", localObject1));
          localObject2 = localb.AZd;
          if (localObject2 != null) {
            ((WxRecyclerView)localObject2).setItemAnimator(null);
          }
          localb.eLs.removeCallbacksAndMessages(null);
          localb.eLs.postDelayed(new b.c..ExternalSyntheticLambda0(localb, (RecyclerView.f)localObject1), ((RecyclerView.f)localObject1).bZL + 60L);
        }
        super.onItemRangeChanged(paramInt1, paramInt2);
        AppMethodBeat.o(304265);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(304272);
      Object localObject1 = this.LHh.AZd;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((WxRecyclerView)localObject1).getItemAnimator())
      {
        if (localObject1 != null)
        {
          b localb = this.LHh;
          Object localObject2 = b.LGS;
          Log.w(b.access$getTAG$cp(), s.X("originItemAnimator=", localObject1));
          localObject2 = localb.AZd;
          if (localObject2 != null) {
            ((WxRecyclerView)localObject2).setItemAnimator(null);
          }
          localb.eLs.removeCallbacksAndMessages(null);
          localb.eLs.postDelayed(new b.c..ExternalSyntheticLambda1(localb, (RecyclerView.f)localObject1), ((RecyclerView.f)localObject1).bZL + 60L);
        }
        super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(304272);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    e(b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initAdapter$5", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements o
  {
    f(b paramb) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(304306);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramm, "data");
      paramm = (Iterable)paramm.agOE;
      b localb = this.LHh;
      int i = 0;
      Iterator localIterator = paramm.iterator();
      if (localIterator.hasNext())
      {
        paramm = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        paramm = (com.tencent.mm.view.recyclerview.n)paramm;
        Object localObject1;
        if ((paramm.agOG instanceof com.tencent.mm.plugin.multitask.ui.minusscreen.b.a))
        {
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          if (((c)com.tencent.mm.ui.component.k.d(localb.getActivity()).q(c.class)).gkZ())
          {
            localObject1 = ((com.tencent.mm.plugin.multitask.ui.minusscreen.b.a)paramm.agOG).LGa;
            if (localObject1 != null)
            {
              paramm = com.tencent.mm.plugin.secdata.ui.a.PlI;
              paramm = paramRecyclerView.getContext();
              s.s(paramm, "recyclerView.context");
              paramm = com.tencent.mm.plugin.secdata.ui.a.a.jC(paramm);
              if (paramm != null) {
                break label272;
              }
            }
          }
        }
        label272:
        for (paramm = null;; paramm = (dry)paramm.aiK(5))
        {
          if (paramm != null)
          {
            long l = localb.aNX(((MultiTaskInfo)localObject1).field_id);
            Object localObject2 = b.LGS;
            Log.d(b.access$getTAG$cp(), "Item Exposed, itemId: %s, pos: %s", new Object[] { ((MultiTaskInfo)localObject1).field_id, Long.valueOf(l) });
            localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
            localObject2 = ((MultiTaskInfo)localObject1).field_id;
            s.s(localObject2, "multiTaskInfo.field_id");
            com.tencent.mm.plugin.multitask.d.a.bm((String)localObject2, cn.bDw());
            localObject2 = com.tencent.mm.plugin.multitask.d.a.LDj;
            com.tencent.mm.plugin.multitask.d.a.a((MultiTaskInfo)localObject1, paramm.zIO, l, 1L, "");
          }
          paramm = localb.LHb;
          if (paramm != null) {
            paramm.j((MultiTaskInfo)localObject1);
          }
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(304306);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(b paramb, List<? extends MultiTaskInfo> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$initUI$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    j(b paramb) {}
    
    private static final void d(b paramb)
    {
      AppMethodBeat.i(304271);
      s.u(paramb, "this$0");
      paramb = paramb.getRootView().findViewById(e.c.LDN);
      Object localObject = paramb.getLayoutParams();
      if (localObject == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(304271);
        throw paramb;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      c.a locala = c.LHl;
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = c.glo();
      locala = c.LHl;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = c.glE();
      locala = c.LHl;
      ((ViewGroup.MarginLayoutParams)localObject).width = c.glt();
      float f = ((ViewGroup.MarginLayoutParams)localObject).width;
      locala = c.LHl;
      ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(f * c.glI()));
      paramb.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(304271);
    }
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(304282);
      Object localObject = this.LHh.LGY;
      if (localObject != null)
      {
        localObject = ((MultiTaskCoordinatorLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      com.tencent.threadpool.h.ahAA.bk(new b.j..ExternalSyntheticLambda0(this.LHh));
      AppMethodBeat.o(304282);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/uic/MultiTaskMinusScreenUIC$mMinusScreenViewListener$1", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "onGridItemAnimFinished", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onItemDelete", "taskInfo", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemOverScrollChanged", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.plugin.multitask.ui.minusscreen.d.a
  {
    k(b paramb) {}
    
    public final void Y(RecyclerView.v paramv)
    {
      int j = 0;
      AppMethodBeat.i(304307);
      s.u(paramv, "viewHolder");
      Object localObject2 = this.LHh;
      s.u(paramv, "viewHolder");
      Object localObject1 = ((b)localObject2).AZd;
      if (localObject1 == null)
      {
        i = 0;
        if (i > 3) {
          break label149;
        }
        localObject2 = paramv.caK.findViewById(e.c.LDT);
        localObject1 = paramv.caK.findViewById(e.c.LDP);
        if ((localObject2 != null) && (localObject1 != null))
        {
          ((View)localObject2).setTranslationY(0.0F);
          if (!(localObject1 instanceof MinusScreenRoundFrameLayout)) {
            break label144;
          }
        }
      }
      label144:
      for (paramv = (MinusScreenRoundFrameLayout)localObject1;; paramv = null)
      {
        if (paramv != null) {
          ((MinusScreenRoundFrameLayout)localObject1).acw(0);
        }
        AppMethodBeat.o(304307);
        return;
        localObject1 = ((WxRecyclerView)localObject1).getAdapter();
        if (localObject1 == null)
        {
          i = 0;
          break;
        }
        i = ((RecyclerView.a)localObject1).getItemCount();
        break;
      }
      label149:
      localObject1 = ((b)localObject2).AZd;
      label179:
      int k;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof MinusScreenGridLayoutManager)) {
          break label355;
        }
        localObject1 = (MinusScreenGridLayoutManager)localObject1;
        if (localObject1 != null)
        {
          int m = ((MinusScreenGridLayoutManager)localObject1).Ju();
          localObject1 = paramv.caK.findViewById(e.c.LDT);
          Object localObject3 = paramv.caK.findViewById(e.c.multi_task_item_bg);
          if ((localObject1 != null) && (localObject3 != null))
          {
            ((View)localObject3).getLocalVisibleRect(((b)localObject2).LGX);
            localObject3 = c.LHl;
            k = c.glu() - ((b)localObject2).LGX.height();
            float f = k;
            localObject2 = c.LHl;
            i = j;
            if (f <= c.glu() * 0.8F) {
              if (paramv.KJ() <= m + 1) {
                break label366;
              }
            }
          }
        }
      }
      label355:
      label366:
      for (int i = j;; i = k)
      {
        ((View)localObject1).setTranslationY(i);
        localObject1 = paramv.caK.findViewById(e.c.LDP);
        if ((localObject1 instanceof MinusScreenRoundFrameLayout)) {}
        for (paramv = (MinusScreenRoundFrameLayout)localObject1;; paramv = null)
        {
          if (paramv != null) {
            ((MinusScreenRoundFrameLayout)localObject1).acw(i);
          }
          AppMethodBeat.o(304307);
          return;
          localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();
          break;
          localObject1 = null;
          break label179;
        }
      }
    }
    
    public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.b.a parama, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(304288);
      s.u(paramj, "holder");
      Object localObject1;
      if (parama != null)
      {
        Object localObject2 = parama.LGa;
        if (localObject2 != null)
        {
          localObject1 = this.LHh;
          ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).removeTaskInfoAndCoverImg(((MultiTaskInfo)localObject2).field_id);
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramj = paramj.context;
          s.s(paramj, "holder.context");
          paramj = com.tencent.mm.plugin.secdata.ui.a.a.jC(paramj);
          if (paramj != null) {
            break label159;
          }
        }
      }
      label159:
      for (paramj = null;; paramj = (dry)paramj.aiK(5))
      {
        if (paramj != null)
        {
          long l = ((b)localObject1).aNX(parama.LGa.field_id);
          localObject1 = b.LGS;
          Log.d(b.access$getTAG$cp(), "Item deleted!, itemId: %s, pos: %s", new Object[] { parama.LGa.field_id, Long.valueOf(l) });
          if (paramj != null)
          {
            localObject1 = com.tencent.mm.plugin.multitask.d.a.LDj;
            com.tencent.mm.plugin.multitask.d.a.a(parama.LGa, paramj.zIO, l, 3L, "");
          }
        }
        AppMethodBeat.o(304288);
        return;
      }
    }
    
    public final void gkN()
    {
      MinusScreenGridLayoutManager localMinusScreenGridLayoutManager = null;
      AppMethodBeat.i(304313);
      b localb = this.LHh;
      Object localObject = localb.AZd;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((WxRecyclerView)localObject).getLayoutManager())
      {
        if ((localObject instanceof MinusScreenGridLayoutManager)) {
          localMinusScreenGridLayoutManager = (MinusScreenGridLayoutManager)localObject;
        }
        if (localMinusScreenGridLayoutManager != null)
        {
          localObject = localb.AZd;
          if (localObject != null) {
            localb.a((RecyclerView)localObject, localMinusScreenGridLayoutManager);
          }
        }
        AppMethodBeat.o(304313);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<RecyclerView.LayoutManager>
  {
    l(b paramb, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<ah>
  {
    m(MultiTaskInfo paramMultiTaskInfo, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(MultiTaskInfo paramMultiTaskInfo, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ah>
  {
    o(MultiTaskInfo paramMultiTaskInfo, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.b
 * JD-Core Version:    0.7.0.1
 */