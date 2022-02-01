package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.g.b.a.o;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.i;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopViewContainer;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.aj.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.g.a;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TaskBarView
  extends RecyclerView
  implements AppBrandDesktopView.i, com.tencent.mm.plugin.taskbar.api.b.a, d.b, com.tencent.mm.plugin.taskbar.ui.section.b.a
{
  private float CBd;
  final d FUi;
  private final ArrayList<Integer> FUj;
  private long FUk;
  private com.tencent.mm.plugin.taskbar.ui.section.weapp.b FUl;
  private boolean FUm;
  boolean FUn;
  boolean FUo;
  private boolean FUp;
  private float FUq;
  private boolean FUr;
  private boolean FUs;
  private RecyclerView.a adj;
  private int atO;
  boolean dSv;
  private boolean dXX;
  private RecyclerView.l guX;
  int hIX;
  boolean isPaused;
  private Context mContext;
  private Interpolator mInterpolator;
  private int mLastState;
  private int mTouchSlop;
  private LinearLayoutManager oDV;
  boolean onK;
  boolean onN;
  boolean onO;
  int onP;
  private boolean onT;
  private int onV;
  private float onW;
  private float onX;
  private boolean onY;
  private boolean onZ;
  HeaderContainer onh;
  private boolean onj;
  private RelativeLayout onl;
  int onp;
  Runnable ont;
  Runnable onu;
  private boolean ooc;
  private Animator.AnimatorListener wY;
  
  public TaskBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(238261);
    this.FUi = new d(this);
    this.FUj = new ArrayList();
    this.oDV = null;
    this.onj = false;
    this.atO = 0;
    this.FUk = 0L;
    this.onp = 0;
    this.ont = null;
    this.onu = null;
    this.dXX = false;
    this.hIX = 0;
    this.onK = false;
    this.FUm = false;
    this.isPaused = false;
    this.onN = false;
    this.onO = false;
    this.FUn = false;
    this.FUo = false;
    this.FUp = false;
    this.onP = 0;
    this.onT = false;
    this.dSv = false;
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.onV = 0;
    this.CBd = 0.0F;
    this.onW = 0.0F;
    this.FUq = 0.0F;
    this.onX = 0.0F;
    this.onY = false;
    this.FUr = false;
    this.FUs = false;
    this.onZ = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wY = new TaskBarView.6(this);
    this.mLastState = -1;
    this.ooc = false;
    this.guX = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(238236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          if (!TaskBarView.r(TaskBarView.this)) {
            break label94;
          }
          TaskBarView.s(TaskBarView.this);
        }
        for (;;)
        {
          TaskBarView.d(TaskBarView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(238236);
          return;
          label94:
          if ((TaskBarView.t(TaskBarView.this) == 1) || (TaskBarView.t(TaskBarView.this) == 2)) {
            TaskBarView.fuU();
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(238237);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (TaskBarView.u(TaskBarView.this))
        {
          TaskBarView.v(TaskBarView.this);
          if (TaskBarView.w(TaskBarView.this) != null)
          {
            paramAnonymousInt1 = TaskBarView.x(TaskBarView.this) - TaskBarView.w(TaskBarView.this).ks();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < TaskBarView.this.getChildCount()))
            {
              paramAnonymousInt1 = TaskBarView.this.getChildAt(paramAnonymousInt1).getTop();
              TaskBarView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(238237);
      }
    };
    init(paramContext);
    AppMethodBeat.o(238261);
  }
  
  public TaskBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238262);
    this.FUi = new d(this);
    this.FUj = new ArrayList();
    this.oDV = null;
    this.onj = false;
    this.atO = 0;
    this.FUk = 0L;
    this.onp = 0;
    this.ont = null;
    this.onu = null;
    this.dXX = false;
    this.hIX = 0;
    this.onK = false;
    this.FUm = false;
    this.isPaused = false;
    this.onN = false;
    this.onO = false;
    this.FUn = false;
    this.FUo = false;
    this.FUp = false;
    this.onP = 0;
    this.onT = false;
    this.dSv = false;
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.onV = 0;
    this.CBd = 0.0F;
    this.onW = 0.0F;
    this.FUq = 0.0F;
    this.onX = 0.0F;
    this.onY = false;
    this.FUr = false;
    this.FUs = false;
    this.onZ = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.wY = new TaskBarView.6(this);
    this.mLastState = -1;
    this.ooc = false;
    this.guX = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(238236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          if (!TaskBarView.r(TaskBarView.this)) {
            break label94;
          }
          TaskBarView.s(TaskBarView.this);
        }
        for (;;)
        {
          TaskBarView.d(TaskBarView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(238236);
          return;
          label94:
          if ((TaskBarView.t(TaskBarView.this) == 1) || (TaskBarView.t(TaskBarView.this) == 2)) {
            TaskBarView.fuU();
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(238237);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (TaskBarView.u(TaskBarView.this))
        {
          TaskBarView.v(TaskBarView.this);
          if (TaskBarView.w(TaskBarView.this) != null)
          {
            paramAnonymousInt1 = TaskBarView.x(TaskBarView.this) - TaskBarView.w(TaskBarView.this).ks();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < TaskBarView.this.getChildCount()))
            {
              paramAnonymousInt1 = TaskBarView.this.getChildAt(paramAnonymousInt1).getTop();
              TaskBarView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$13", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(238237);
      }
    };
    init(paramContext);
    AppMethodBeat.o(238262);
  }
  
  private void abC(int paramInt)
  {
    AppMethodBeat.i(238276);
    com.tencent.mm.plugin.taskbar.ui.section.g localg = this.FUi.abG(paramInt);
    if ((localg.FVH.size() > 0) && (!g.a.abK(localg.FVr))) {
      this.FUj.add(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(238276);
  }
  
  private int abF(int paramInt)
  {
    AppMethodBeat.i(238290);
    paramInt = this.FUj.indexOf(Integer.valueOf(paramInt));
    AppMethodBeat.o(238290);
    return paramInt;
  }
  
  private int getEmptyViewTopMargin()
  {
    AppMethodBeat.i(238291);
    if (this.mContext.getResources().getConfiguration().orientation == 2) {}
    for (int i = 1; (i != 0) && (this.FUl != null); i = 0)
    {
      i = (getHeight() - com.tencent.mm.cb.a.aH(getContext(), 2131165308)) / 2;
      int j = this.FUl.getHeight();
      int k = com.tencent.mm.cb.a.aH(getContext(), 2131165314);
      AppMethodBeat.o(238291);
      return i + j + k;
    }
    i = (getHeight() - com.tencent.mm.cb.a.aH(getContext(), 2131165308)) / 2;
    AppMethodBeat.o(238291);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(238268);
    this.mContext = paramContext;
    setItemAnimator(new c());
    a(new b((byte)0));
    this.FUi.cau();
    com.tencent.mm.plugin.appbrand.widget.recent.d.init(this.mContext);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(2131101287));
    this.oDV = new LinearLayoutManager();
    setLayoutManager(this.oDV);
    setOverScrollMode(2);
    a(this.guX);
    this.adj = new a();
    setAdapter(this.adj);
    this.FUi.qE(false);
    reloadData();
    Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView init %d", new Object[] { Integer.valueOf(hashCode()) });
    this.onV = com.tencent.mm.cb.a.fromDPToPix(paramContext, 100);
    AppMethodBeat.o(238268);
  }
  
  private void n(Boolean paramBoolean)
  {
    AppMethodBeat.i(238269);
    if ((this.onh == null) || (this.onh.getDesktopBgView() == null))
    {
      AppMethodBeat.o(238269);
      return;
    }
    if (paramBoolean.booleanValue())
    {
      this.onN = false;
      fuS();
      this.onh.setBlurAnimateStatue(true);
      this.onh.getDesktopBgView().setAlpha(0.0F);
      this.onh.getDesktopBgView().setVisibility(0);
      this.onh.getDesktopBgView().animate().alpha(1.0F).setDuration(300L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(238238);
          TaskBarView.a(TaskBarView.this).setBlurAnimateStatue(false);
          AppMethodBeat.o(238238);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      AppMethodBeat.o(238269);
      return;
    }
    this.onh.setBlurAnimateStatue(true);
    this.onh.getDesktopBgView().setAlpha(1.0F);
    this.onh.getDesktopBgView().animate().alpha(0.0F).setDuration(300L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(238239);
        TaskBarView.a(TaskBarView.this).setBlurAnimateStatue(false);
        TaskBarView.a(TaskBarView.this).getDesktopBgView().setVisibility(8);
        TaskBarView.b(TaskBarView.this);
        AppMethodBeat.o(238239);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    AppMethodBeat.o(238269);
  }
  
  private void setupMultiTaskScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(238279);
    Log.i("MicroMsg.TaskBarView", "setupMultiTaskScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((MultiTaskUIC)com.tencent.mm.ui.component.a.ko(getContext()).get(MultiTaskUIC.class)).hx(paramBoolean);
    AppMethodBeat.o(238279);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, int paramInt)
  {
    AppMethodBeat.i(238292);
    d locald = this.FUi;
    kotlin.g.b.p.h(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d,pos:%d", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), Integer.valueOf(paramInt) });
    locald.FUF.I(com.tencent.mm.plugin.taskbar.a.a.Mm(paramMultiTaskInfo.field_type), paramInt, paramMultiTaskInfo.field_id);
    AppMethodBeat.o(238292);
  }
  
  public final void abA(int paramInt)
  {
    AppMethodBeat.i(238274);
    if ((paramInt == 2) && (abF(paramInt) != -1) && (this.FUi.abG(2).FVH.isEmpty()))
    {
      Log.i("MicroMsg.TaskBarView", "live last item removed");
      abB(paramInt);
    }
    AppMethodBeat.o(238274);
  }
  
  public final void abB(final int paramInt)
  {
    AppMethodBeat.i(238275);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238242);
        Log.i("MicroMsg.TaskBarView", "onSectionDeleted %d", new Object[] { Integer.valueOf(paramInt) });
        if ((paramInt == 2) && (!TaskBarView.g(TaskBarView.this).abG(2).FVI.isEmpty()))
        {
          AppMethodBeat.o(238242);
          return;
        }
        int j = TaskBarView.a(TaskBarView.this, paramInt);
        if (j == -1)
        {
          AppMethodBeat.o(238242);
          return;
        }
        int k = TaskBarView.c(TaskBarView.this).size() - 1;
        if ((paramInt == 1) && (k == 1)) {}
        for (int i = 1;; i = 0)
        {
          TaskBarView.h(TaskBarView.this);
          TaskBarView.this.getAdapter().ck(j);
          if (((k <= 1) && (TaskBarView.c(TaskBarView.this).size() > k)) || (i != 0))
          {
            if (i != 0)
            {
              TaskBarView.this.getAdapter().ci(0);
              AppMethodBeat.o(238242);
              return;
            }
            TaskBarView.this.getAdapter().cj(TaskBarView.c(TaskBarView.this).size() - 1);
          }
          AppMethodBeat.o(238242);
          return;
        }
      }
    });
    AppMethodBeat.o(238275);
  }
  
  public final void abD(int paramInt)
  {
    AppMethodBeat.i(238287);
    n(Boolean.FALSE);
    getDesktopViewContainer().T(paramInt, false);
    this.FUk = System.currentTimeMillis();
    AppMethodBeat.o(238287);
  }
  
  public final void abE(int paramInt)
  {
    AppMethodBeat.i(238289);
    getAdapter().b(abF(paramInt), Boolean.TRUE);
    AppMethodBeat.o(238289);
  }
  
  public final void caB()
  {
    AppMethodBeat.i(238280);
    Log.i("MicroMsg.TaskBarView", "[onOpenHeader]");
    Object localObject5;
    Object localObject1;
    Object localObject4;
    int i;
    label420:
    Object localObject3;
    int n;
    int j;
    int i1;
    int k;
    int m;
    if (!this.onK)
    {
      this.FUp = false;
      setupMultiTaskScroll(false);
      localObject5 = this.FUi;
      localObject1 = ((d)localObject5).FUC.values();
      kotlin.g.b.p.g(localObject1, "sectionViewModelMap.values");
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.taskbar.ui.section.g)((Iterator)localObject1).next();
        localObject4 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject2).FVH;
        while (((List)localObject4).size() > 5)
        {
          localObject6 = (MultiTaskInfo)((List)localObject4).get(((List)localObject4).size() - 1);
          ((PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release((MultiTaskInfo)localObject6);
          ((com.tencent.mm.plugin.taskbar.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(((MultiTaskInfo)((List)localObject4).remove(((List)localObject4).size() - 1)).field_id, false, 4);
          ((d)localObject5).a((MultiTaskInfo)localObject6, 2, 4);
        }
        ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject2).fvk();
      }
      Object localObject6 = new HashMap();
      HashMap localHashMap = new HashMap();
      localObject1 = ((d)localObject5).abG(2);
      Object localObject7;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject1).FVH;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (MultiTaskInfo)((Iterator)localObject1).next();
            localObject2 = new aws();
            for (;;)
            {
              try
              {
                ((aws)localObject2).parseFrom(((MultiTaskInfo)localObject4).field_data);
                if (((aws)localObject2).tuO == null) {
                  break;
                }
                localObject7 = ((aws)localObject2).tuO;
                if (localObject7 == null) {
                  kotlin.g.b.p.hyc();
                }
                ((HashMap)localObject6).put(Long.valueOf(((FinderObject)localObject7).id), localObject4);
                localObject4 = ((aws)localObject2).tuO;
                if (localObject4 == null) {
                  break label420;
                }
                localObject4 = ((FinderObject)localObject4).liveInfo;
                if (localObject4 == null) {
                  break label420;
                }
                i = ((awe)localObject4).liveStatus;
                if (i == 2) {
                  break;
                }
                localObject4 = ((aws)localObject2).tuO;
                if (localObject4 == null) {
                  kotlin.g.b.p.hyc();
                }
                localHashMap.put(Long.valueOf(((FinderObject)localObject4).id), localObject2);
              }
              catch (Throwable localThrowable)
              {
                Log.e("MicroMsg.TaskBarViewPresenter", "FinderLiveMultiTaskData parse failed");
              }
              break;
              i = 2;
            }
          }
        }
      }
      long l;
      if (!localHashMap.isEmpty())
      {
        l = System.currentTimeMillis() / 1000L;
        if (l - ((d)localObject5).FUD <= ((d)localObject5).FUE) {
          Log.i("MicroMsg.TaskBarViewPresenter", "not check because of interval: " + ((d)localObject5).FUE + " last:" + ((d)localObject5).FUD);
        }
      }
      else
      {
        l.aeK(l.bUv());
        this.onK = true;
        this.onN = true;
        this.onO = true;
        ai.LX(0L);
        localObject3 = this.FUi;
        localObject1 = ((d)localObject3).FUF;
        ((com.tencent.mm.plugin.taskbar.a.a)localObject1).oCb = (System.currentTimeMillis() / 1000L);
        ((com.tencent.mm.plugin.taskbar.a.a)localObject1).FSr = String.valueOf((int)((com.tencent.mm.plugin.taskbar.a.a)localObject1).oCb);
        ((d)localObject3).mZq = cl.aWA();
        Log.i("MicroMsg.TaskBarViewPresenter", "onDidAppear lastStartTime:%d", new Object[] { Long.valueOf(((d)localObject3).mZq) });
        n = 0;
        j = 0;
        i1 = 0;
        i = 0;
        k = i1;
        m = n;
        if (((d)localObject3).FUC.get(Integer.valueOf(5)) == null) {
          break label1017;
        }
        localObject1 = (com.tencent.mm.plugin.taskbar.ui.section.g)((d)localObject3).FUC.get(Integer.valueOf(5));
        if (localObject1 == null) {
          break label995;
        }
      }
      label995:
      for (localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject1).FVH;; localObject1 = null)
      {
        k = i1;
        m = n;
        if (localObject1 == null) {
          break label1017;
        }
        localObject1 = (com.tencent.mm.plugin.taskbar.ui.section.g)((d)localObject3).FUC.get(Integer.valueOf(5));
        k = i1;
        m = n;
        if (localObject1 == null) {
          break label1017;
        }
        localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject1).FVH;
        k = i1;
        m = n;
        if (localObject1 == null) {
          break label1017;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          k = i;
          m = j;
          if (!((Iterator)localObject1).hasNext()) {
            break label1017;
          }
          localObject4 = (MultiTaskInfo)((Iterator)localObject1).next();
          if (((MultiTaskInfo)localObject4).field_type != 4) {
            break;
          }
          j += 1;
        }
        ((d)localObject5).FUD = l;
        Log.i("MicroMsg.TaskBarViewPresenter", "start check");
        localObject7 = (aj)com.tencent.mm.kernel.g.ah(aj.class);
        localObject1 = localHashMap.values();
        kotlin.g.b.p.g(localObject1, "objId2LiveDataNotEnded.values");
        localObject1 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (aws)localIterator.next();
          localObject1 = ((aws)localObject3).tuO;
          if (localObject1 != null) {}
          for (localObject1 = Long.valueOf(((FinderObject)localObject1).id);; localObject1 = Long.valueOf(0L))
          {
            localObject3 = ((aws)localObject3).tuO;
            if (localObject3 != null)
            {
              localObject4 = ((FinderObject)localObject3).objectNonceId;
              localObject3 = localObject4;
              if (localObject4 != null) {}
            }
            else
            {
              localObject3 = "";
            }
            localCollection.add(new Pair(localObject1, localObject3));
            break;
          }
        }
        ((aj)localObject7).batchGetLiveStatus(kotlin.a.j.v((Collection)localCollection), (aj.a)new d.f((d)localObject5, localHashMap, (HashMap)localObject6));
        break;
      }
      if (((MultiTaskInfo)localObject4).field_type != 3) {
        break label1451;
      }
      i += 1;
    }
    label1048:
    label1451:
    for (;;)
    {
      break;
      label1017:
      if (e.atB())
      {
        i = 1;
        localObject1 = ((d)localObject3).FUF;
        if (((d)localObject3).FUB.size() < 8) {
          break label1359;
        }
        j = 8;
        localObject4 = (com.tencent.mm.plugin.taskbar.ui.section.g)((d)localObject3).FUC.get(Integer.valueOf(3));
        if (localObject4 == null) {
          break label1371;
        }
        localObject4 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject4).FVH;
        if (localObject4 == null) {
          break label1371;
        }
        n = ((List)localObject4).size();
        localObject4 = (com.tencent.mm.plugin.taskbar.ui.section.g)((d)localObject3).FUC.get(Integer.valueOf(4));
        if (localObject4 == null) {
          break label1377;
        }
        localObject4 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject4).FVH;
        if (localObject4 == null) {
          break label1377;
        }
        i1 = ((List)localObject4).size();
        localObject4 = (com.tencent.mm.plugin.taskbar.ui.section.g)((d)localObject3).FUC.get(Integer.valueOf(2));
        if (localObject4 == null) {
          break label1383;
        }
        localObject4 = ((com.tencent.mm.plugin.taskbar.ui.section.g)localObject4).FVH;
        if (localObject4 == null) {
          break label1383;
        }
      }
      label1091:
      label1134:
      for (int i2 = ((List)localObject4).size();; i2 = 0)
      {
        localObject4 = new o();
        ((o)localObject4).ekH = ((o)localObject4).x("session_id", ((com.tencent.mm.plugin.taskbar.a.a)localObject1).FSr, true);
        ((o)localObject4).ekI = 1L;
        ((o)localObject4).ekJ = i;
        ((o)localObject4).ekK = j;
        ((o)localObject4).ekL = n;
        ((o)localObject4).ekM = k;
        ((o)localObject4).ekN = m;
        ((o)localObject4).ekP = i1;
        ((o)localObject4).ekQ = i2;
        ((o)localObject4).bfK();
        localObject1 = ((d)localObject3).FUH.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (d.d)((Iterator)localObject1).next();
          localObject5 = ((d.d)localObject4).Agu;
          if (localObject5 != null) {
            ((PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyExposeTaskBarItem$plugin_taskbar_release((MultiTaskInfo)localObject5);
          }
          ((d)localObject3).FUF.J(((d.d)localObject4).FUN, ((d.d)localObject4).pageType, ((d.d)localObject4).pFK);
        }
        i = 0;
        break;
        j = ((d)localObject3).FUB.size();
        break label1048;
        n = 0;
        break label1091;
        i1 = 0;
        break label1134;
      }
      label1359:
      label1371:
      label1377:
      label1383:
      ((d)localObject3).FUH.clear();
      com.tencent.mm.plugin.appbrand.appusage.j.bxQ().a(Util.nowMilliSecond(), true, null, 6, 0);
      h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPD, z.nMB);
      h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPE, z.nMB);
      setLayoutFrozen(false);
      AppMethodBeat.o(238280);
      return;
    }
  }
  
  public final void caC()
  {
    AppMethodBeat.i(238283);
    caB();
    AppMethodBeat.o(238283);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(238266);
    if (this.FUp)
    {
      AppMethodBeat.o(238266);
      return true;
    }
    boolean bool;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(238266);
      return bool;
    case 0: 
      this.CBd = paramMotionEvent.getRawX();
      this.onW = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      this.FUq = 0.0F;
      this.onX = 0.0F;
      this.onY = false;
      this.onZ = false;
      this.FUr = false;
      this.FUs = false;
      break;
      if (this.FUr)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(238266);
        return bool;
      }
      float f2;
      if (!this.FUs)
      {
        float f1 = Math.abs(paramMotionEvent.getRawX() - this.CBd);
        f2 = Math.abs(paramMotionEvent.getRawY() - this.onW);
        if (f1 <= this.mTouchSlop) {
          break label335;
        }
        if ((f2 > this.mTouchSlop) && (f2 > f1)) {
          this.FUs = true;
        }
      }
      else
      {
        label208:
        Log.v("MicroMsg.TaskBarView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.onY), Float.valueOf(this.onX), Integer.valueOf(this.mTouchSlop) });
        if ((this.oDV == null) || (this.FUj == null)) {
          break label359;
        }
        if (this.oDV.kv() != this.FUj.size() - 1) {
          break label353;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (!this.onY))
        {
          if (!this.onZ)
          {
            this.onW = paramMotionEvent.getRawY();
            this.onX = 0.0F;
            this.onZ = true;
            break;
            this.FUr = true;
            break;
            label335:
            if (f2 <= this.mTouchSlop) {
              break label208;
            }
            this.FUs = true;
            break label208;
            label353:
            i = 0;
            continue;
            label359:
            i = 0;
            continue;
          }
          this.onX = ((paramMotionEvent.getRawY() - this.onW) * 0.55F);
          if (this.onX >= 0.0F) {
            break;
          }
          this.onY = true;
          break;
        }
      }
      if (!this.onY) {
        break;
      }
      this.onX = ((paramMotionEvent.getRawY() - this.onW) * 0.55F);
      if (this.onX > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(238266);
        return bool;
      }
      if (this.onX < -this.mTouchSlop)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
      }
      int i = (int)Math.abs(this.onX);
      Log.v("MicroMsg.TaskBarView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(238266);
      return true;
      if (this.onY) {
        if ((Math.abs(this.onX) >= this.onV) && (this.onh != null))
        {
          Log.i("MicroMsg.TaskBarView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.onh.ac(0L, 15);
        }
        else
        {
          animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).setListener(this.wY).start();
        }
      }
    }
  }
  
  public final void eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238281);
    Log.i("MicroMsg.TaskBarView", "[onCloseHeader] reason: %d duration:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i;
    label129:
    Object localObject1;
    if (this.onK)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238244);
          if (!TaskBarView.k(TaskBarView.this)) {
            TaskBarView.l(TaskBarView.this);
          }
          AppMethodBeat.o(238244);
        }
      }, paramInt2);
      if ((this.onh != null) && (this.onh.getDesktopBgView() != null)) {
        break label319;
      }
      getDesktopViewContainer().T(paramInt1, true);
      this.onK = false;
      this.FUp = false;
      Object localObject2 = this.FUi;
      Log.i("MicroMsg.TaskBarViewPresenter", "onDidClose reason:%d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 != 13) && (paramInt1 != 0)) {
        break label334;
      }
      i = 2;
      ((d)localObject2).FUG += cl.aWA() - ((d)localObject2).mZq;
      Log.i("MicroMsg.TaskBarViewPresenter", "reportTaskBarClose viewDuration:%d,lastStartTime:%d,currentTime:%d", new Object[] { Long.valueOf(((d)localObject2).FUG / 1000L), Long.valueOf(((d)localObject2).mZq), Long.valueOf(cl.aWA()) });
      localObject1 = ((d)localObject2).FUF;
      int j = (int)(((d)localObject2).FUG / 1000L);
      localObject2 = new com.tencent.mm.g.b.a.q();
      ((com.tencent.mm.g.b.a.q)localObject2).ekH = ((com.tencent.mm.g.b.a.q)localObject2).x("session_id", ((com.tencent.mm.plugin.taskbar.a.a)localObject1).FSr, true);
      ((com.tencent.mm.g.b.a.q)localObject2).ekI = i;
      ((com.tencent.mm.g.b.a.q)localObject2).ekU = j;
      ((com.tencent.mm.g.b.a.q)localObject2).bfK();
      this.onN = false;
      this.onO = false;
      this.FUi.qE(true);
      localObject1 = new TaskBarView.2(this);
      if (paramInt1 != 15) {
        break label339;
      }
    }
    label319:
    label334:
    label339:
    for (long l = paramInt2;; l = 0L)
    {
      postDelayed((Runnable)localObject1, l);
      AppMethodBeat.o(238281);
      return;
      this.onh.getDesktopBgView().setVisibility(8);
      break;
      i = 1;
      break label129;
    }
  }
  
  public final boolean esy()
  {
    return this.onK;
  }
  
  public final void fuO()
  {
    AppMethodBeat.i(238270);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238240);
        TaskBarView.d(TaskBarView.this).ci(TaskBarView.c(TaskBarView.this).indexOf(Integer.valueOf(2)));
        AppMethodBeat.o(238240);
      }
    });
    AppMethodBeat.o(238270);
  }
  
  public final void fuP()
  {
    AppMethodBeat.i(238271);
    Log.i("MicroMsg.TaskBarView", "onDataUpdated");
    this.FUm = true;
    fuQ();
    AppMethodBeat.o(238271);
  }
  
  public final void fuQ()
  {
    AppMethodBeat.i(238272);
    if (((!this.FUm) || (this.onK) || (this.isPaused) || (!this.FUi.fuX())) && ((!this.onK) || (!getDesktopViewContainer().caF())))
    {
      AppMethodBeat.o(238272);
      return;
    }
    reloadData();
    AppMethodBeat.o(238272);
  }
  
  public final void fuR()
  {
    AppMethodBeat.i(238273);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238241);
        TaskBarView.e(TaskBarView.this);
        AppBrandDesktopView localAppBrandDesktopView = TaskBarView.f(TaskBarView.this).getDesktopView();
        localAppBrandDesktopView.cau();
        localAppBrandDesktopView.jb(true);
        localAppBrandDesktopView.cav();
        AppMethodBeat.o(238241);
      }
    });
    AppMethodBeat.o(238273);
  }
  
  final void fuS()
  {
    AppMethodBeat.i(238284);
    if ((this.onh != null) && (e.atB()))
    {
      Log.i("MicroMsg.TaskBarView", "alvinluo switchToGradientBackgroundView");
      Object localObject = this.onh.getParent();
      if ((localObject instanceof View)) {
        ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131101287));
      }
      localObject = this.onh.getBackgroundGradientView();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((View)localObject).setAlpha(1.0F);
      }
      if ((this.onh.getBackgroundGLSurfaceView() instanceof DynamicBackgroundGLSurfaceView)) {
        this.onT = true;
      }
    }
    AppMethodBeat.o(238284);
  }
  
  final void fuT()
  {
    AppMethodBeat.i(238285);
    if ((e.atB()) && (this.onh != null) && (this.onh.fuw()) && (!getDesktopViewContainer().caF()))
    {
      Log.i("MicroMsg.TaskBarView", "alvinluo switchToDynamicBackgroundView");
      ((View)this.onh.getParent()).setBackgroundColor(this.mContext.getResources().getColor(2131101287));
      final View localView = this.onh.getBackgroundGradientView();
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = this.onh.getBackgroundGLSurfaceView();
      if ((localView instanceof DynamicBackgroundGLSurfaceView))
      {
        localView.setVisibility(0);
        if (this.onT)
        {
          ((DynamicBackgroundGLSurfaceView)localView).onResume();
          this.onT = false;
        }
        Log.i("MicroMsg.TaskBarView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(238234);
            Log.i("MicroMsg.TaskBarView", "do show");
            ((DynamicBackgroundGLSurfaceView)localView).setShowGradientView(false);
            AppMethodBeat.o(238234);
          }
        }, 100L);
      }
    }
    AppMethodBeat.o(238285);
  }
  
  AppBrandDesktopViewContainer getDesktopViewContainer()
  {
    AppMethodBeat.i(238286);
    if (this.onh != null)
    {
      AppBrandDesktopViewContainer localAppBrandDesktopViewContainer = (AppBrandDesktopViewContainer)this.onh.getDesktopContainerView();
      AppMethodBeat.o(238286);
      return localAppBrandDesktopViewContainer;
    }
    AppMethodBeat.o(238286);
    return null;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this;
  }
  
  public int getTaskBarContainerBottom()
  {
    AppMethodBeat.i(238288);
    int i = getBottom();
    AppMethodBeat.o(238288);
    return i;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public final void jd(boolean paramBoolean)
  {
    this.FUo = paramBoolean;
    this.FUn = true;
  }
  
  public final void n(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(238293);
    d locald = this.FUi;
    kotlin.g.b.p.h(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear type:%d,multiTaskId:%s", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), paramMultiTaskInfo.field_id });
    int i = com.tencent.mm.plugin.taskbar.a.a.Mm(paramMultiTaskInfo.field_type);
    Object localObject = locald.FUL;
    if ((localObject != null) && (((d.b)localObject).esy() == true))
    {
      locald.FUF.J(2, i, paramMultiTaskInfo.field_id);
      AppMethodBeat.o(238293);
      return;
    }
    localObject = new d.d();
    ((d.d)localObject).FUN = 1;
    ((d.d)localObject).pageType = i;
    ((d.d)localObject).pFK = paramMultiTaskInfo.field_id;
    ((d.d)localObject).Agu = paramMultiTaskInfo;
    locald.FUH.add(localObject);
    AppMethodBeat.o(238293);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(238267);
    super.onAttachedToWindow();
    View localView = getRootView();
    if (localView == null)
    {
      AppMethodBeat.o(238267);
      return;
    }
    this.onl = ((RelativeLayout)localView.findViewById(2131304341));
    AppMethodBeat.o(238267);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(238265);
    if (this.FUr)
    {
      AppMethodBeat.o(238265);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(238265);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238278);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.onh != null) && (this.onp != this.onh.getViewHeight()))
    {
      this.onp = this.onh.getViewHeight();
      Log.i("MicroMsg.TaskBarView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.onp), Integer.valueOf(this.onh.getMeasuredHeight()) });
    }
    AppMethodBeat.o(238278);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(238264);
    super.onVisibilityChanged(paramView, paramInt);
    Log.d("MicroMsg.TaskBarView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.FUn) && (this.onh != null))
      {
        this.onh.ad(100L, this.onP);
        this.onP = 0;
        this.FUn = false;
      }
      if (this.dXX)
      {
        Log.i("MicroMsg.TaskBarView", "alvinluo onVisibilityChanged needRefresh");
        this.dXX = false;
        if (this.onu != null) {
          removeCallbacks(this.onu);
        }
        paramView = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(238232);
            TaskBarView.this.setLayoutFrozen(false);
            AppMethodBeat.o(238232);
          }
        };
        this.onu = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(238264);
  }
  
  final void reloadData()
  {
    AppMethodBeat.i(238277);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238243);
        Log.i("MicroMsg.TaskBarView", "doReloadData");
        TaskBarView.h(TaskBarView.this);
        if (TaskBarView.this.asn) {
          TaskBarView.i(TaskBarView.this);
        }
        if (TaskBarView.this.getRecyclerView().ld())
        {
          AppMethodBeat.o(238243);
          return;
        }
        TaskBarView.g(TaskBarView.this).FUH.clear();
        TaskBarView.d(TaskBarView.this).atj.notifyChanged();
        TaskBarView.j(TaskBarView.this);
        AppMethodBeat.o(238243);
      }
    });
    AppMethodBeat.o(238277);
  }
  
  public void setCloseReason(int paramInt)
  {
    this.onP = paramInt;
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(238263);
    this.onh = paramHeaderContainer;
    getDesktopViewContainer().getDesktopView().setHeaderContainer(this.onh);
    AppMethodBeat.o(238263);
  }
  
  public final void wo(boolean paramBoolean)
  {
    this.FUp = paramBoolean;
  }
  
  public final void zT(int paramInt)
  {
    AppMethodBeat.i(238282);
    eG(paramInt, 0);
    AppMethodBeat.o(238282);
  }
  
  final class a
    extends RecyclerView.a<com.tencent.mm.plugin.taskbar.ui.section.a>
  {
    a()
    {
      AppMethodBeat.i(238252);
      au(true);
      AppMethodBeat.o(238252);
    }
    
    private void a(com.tencent.mm.plugin.taskbar.ui.section.a parama, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(258561);
      Log.i("MicroMsg.TaskBarView", "onBind %d %d", new Object[] { Integer.valueOf(parama.auw), Integer.valueOf(paramInt) });
      switch (parama.auw)
      {
      default: 
      case 1: 
        for (;;)
        {
          parama.fvh().getViewModel().fvk();
          parama.fvh().notifyDataSetChanged();
          AppMethodBeat.o(258561);
          return;
          TaskBarView.a(TaskBarView.this, (com.tencent.mm.plugin.taskbar.ui.section.weapp.b)parama.aus);
          TaskBarView.p(TaskBarView.this).setDataList(TaskBarView.g(TaskBarView.this).FUB);
        }
      }
      Object localObject = (com.tencent.mm.plugin.taskbar.ui.section.c)parama.aus;
      label150:
      TextView localTextView;
      if (TaskBarView.c(TaskBarView.this).size() == 1)
      {
        paramInt = i;
        localTextView = ((com.tencent.mm.plugin.taskbar.ui.section.c)localObject).qco;
        localObject = ((com.tencent.mm.plugin.taskbar.ui.section.c)localObject).getContext();
        if (paramInt == 0) {
          break label193;
        }
      }
      label193:
      for (paramInt = 2131755723;; paramInt = 2131755726)
      {
        localTextView.setText((CharSequence)com.tencent.mm.cb.a.aI((Context)localObject, paramInt));
        break;
        paramInt = 0;
        break label150;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(238256);
      int i = TaskBarView.c(TaskBarView.this).size();
      AppMethodBeat.o(238256);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(238253);
      long l = ((Integer)TaskBarView.c(TaskBarView.this).get(paramInt)).intValue();
      AppMethodBeat.o(238253);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(238254);
      paramInt = TaskBarView.c(TaskBarView.this, paramInt);
      AppMethodBeat.o(238254);
      return paramInt;
    }
  }
  
  final class b
    extends RecyclerView.h
  {
    private b() {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(238260);
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRecyclerView = paramRecyclerView.bi(paramView);
      if (paramRecyclerView == null)
      {
        Log.w("MicroMsg.TaskBarView", "null holder");
        AppMethodBeat.o(238260);
        return;
      }
      int i = paramRecyclerView.lR();
      if ((params.aui) && (i == -1)) {
        i = paramRecyclerView.auu;
      }
      for (;;)
      {
        int j = paramRecyclerView.auw;
        if (i == 0)
        {
          paramRect.top = com.tencent.mm.cb.a.aH(paramView.getContext(), 2131165314);
          if (j == 6) {
            if ((TaskBarView.c(TaskBarView.this).size() != 1) && (TaskBarView.p(TaskBarView.this) != null)) {
              break label228;
            }
          }
        }
        label228:
        for (paramRect.top = TaskBarView.y(TaskBarView.this);; paramRect.top = (TaskBarView.y(TaskBarView.this) - TaskBarView.p(TaskBarView.this).getHeight() - com.tencent.mm.cb.a.aH(paramView.getContext(), 2131165314)))
        {
          if (j == ((Integer)TaskBarView.c(TaskBarView.this).get(TaskBarView.c(TaskBarView.this).size() - 1)).intValue()) {
            paramRect.bottom = com.tencent.mm.cb.a.aH(paramView.getContext(), 2131165306);
          }
          Log.i("MicroMsg.TaskBarView", "getItemOffsets index:%d sectionType:%d rect:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRect });
          AppMethodBeat.o(238260);
          return;
          paramRect.top = com.tencent.mm.cb.a.aH(paramView.getContext(), 2131165300);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarView
 * JD-Core Version:    0.7.0.1
 */