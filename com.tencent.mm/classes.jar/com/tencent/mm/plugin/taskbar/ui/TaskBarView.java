package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.u;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.a.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

public class TaskBarView
  extends RecyclerView
  implements AppBrandDesktopView.b, a.a, d.b, b.a
{
  private float BpS;
  private RelativeLayout DpU;
  public TaskBarContainer Mnv;
  public int MpA;
  public boolean MpB;
  private float MpC;
  private boolean MpD;
  private boolean MpE;
  public final Runnable MpF;
  private boolean MpG;
  private c Mpg;
  public d Mph;
  private final ArrayList<Integer> Mpi;
  private boolean Mpj;
  private com.tencent.mm.plugin.taskbar.ui.section.weapp.d Mpk;
  private com.tencent.mm.plugin.taskbar.ui.section.weapp.a Mpl;
  private com.tencent.mm.plugin.taskbar.ui.section.other.a Mpm;
  public int Mpn;
  public Runnable Mpo;
  public Runnable Mpp;
  private boolean Mpq;
  public boolean Mpr;
  private boolean Mps;
  private boolean Mpt;
  public boolean Mpu;
  public boolean Mpv;
  public boolean Mpw;
  public boolean Mpx;
  public boolean Mpy;
  private boolean Mpz;
  private RecyclerView.a afJ;
  private int alG;
  boolean fLS;
  private boolean fRO;
  private RecyclerView.l iZi;
  public boolean isPaused;
  public boolean kUD;
  public int kwr;
  public Context mContext;
  private Interpolator mInterpolator;
  private int mLastState;
  private int mTouchSlop;
  private LinearLayoutManager rFD;
  private String rpR;
  private float rpT;
  private float rpU;
  private boolean rpV;
  private boolean rpW;
  
  public TaskBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(214457);
    this.Mpg = new c();
    this.Mpi = new ArrayList();
    this.rFD = null;
    this.Mpj = false;
    this.alG = 0;
    this.rpR = "";
    this.Mpn = 0;
    this.Mpo = null;
    this.Mpp = null;
    this.fRO = false;
    this.kwr = 0;
    this.Mpq = false;
    this.Mpr = false;
    this.Mps = true;
    this.Mpt = false;
    this.Mpu = false;
    this.isPaused = false;
    this.kUD = false;
    this.Mpv = false;
    this.Mpw = false;
    this.Mpx = false;
    this.Mpy = false;
    this.Mpz = false;
    this.MpA = 0;
    this.MpB = false;
    this.fLS = false;
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.BpS = 0.0F;
    this.rpT = 0.0F;
    this.MpC = 0.0F;
    this.rpU = 0.0F;
    this.rpV = false;
    this.MpD = false;
    this.MpE = false;
    this.rpW = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.MpF = new Runnable()
    {
      @SuppressLint({"NotifyDataSetChanged"})
      public final void run()
      {
        AppMethodBeat.i(214442);
        Log.i("MicroMsg.TaskBarView", "doReloadData");
        TaskBarView.g(TaskBarView.this);
        if (TaskBarView.this.aki) {
          TaskBarView.h(TaskBarView.this);
        }
        if (TaskBarView.this.getRecyclerView().lq())
        {
          Log.i("MicroMsg.TaskBarView", "isComputingLayout not update");
          TaskBarView.a(TaskBarView.this, true);
          AppMethodBeat.o(214442);
          return;
        }
        TaskBarView.e(TaskBarView.this).MpY.clear();
        TaskBarView.i(TaskBarView.this).alc.notifyChanged();
        TaskBarView.a(TaskBarView.this, false);
        AppMethodBeat.o(214442);
      }
    };
    this.mLastState = -1;
    this.MpG = false;
    this.iZi = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(214169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          if (!TaskBarView.q(TaskBarView.this)) {
            break label94;
          }
          TaskBarView.r(TaskBarView.this);
        }
        for (;;)
        {
          TaskBarView.c(TaskBarView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(214169);
          return;
          label94:
          if ((TaskBarView.s(TaskBarView.this) == 1) || (TaskBarView.s(TaskBarView.this) == 2)) {
            TaskBarView.gjJ();
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(214171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (TaskBarView.t(TaskBarView.this))
        {
          TaskBarView.u(TaskBarView.this);
          if (TaskBarView.v(TaskBarView.this) != null)
          {
            paramAnonymousInt1 = TaskBarView.w(TaskBarView.this) - TaskBarView.v(TaskBarView.this).kJ();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < TaskBarView.this.getChildCount()))
            {
              paramAnonymousInt1 = TaskBarView.this.getChildAt(paramAnonymousInt1).getTop();
              TaskBarView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(214171);
      }
    };
    bv(paramContext);
    AppMethodBeat.o(214457);
  }
  
  public TaskBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(214460);
    this.Mpg = new c();
    this.Mpi = new ArrayList();
    this.rFD = null;
    this.Mpj = false;
    this.alG = 0;
    this.rpR = "";
    this.Mpn = 0;
    this.Mpo = null;
    this.Mpp = null;
    this.fRO = false;
    this.kwr = 0;
    this.Mpq = false;
    this.Mpr = false;
    this.Mps = true;
    this.Mpt = false;
    this.Mpu = false;
    this.isPaused = false;
    this.kUD = false;
    this.Mpv = false;
    this.Mpw = false;
    this.Mpx = false;
    this.Mpy = false;
    this.Mpz = false;
    this.MpA = 0;
    this.MpB = false;
    this.fLS = false;
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.BpS = 0.0F;
    this.rpT = 0.0F;
    this.MpC = 0.0F;
    this.rpU = 0.0F;
    this.rpV = false;
    this.MpD = false;
    this.MpE = false;
    this.rpW = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.MpF = new Runnable()
    {
      @SuppressLint({"NotifyDataSetChanged"})
      public final void run()
      {
        AppMethodBeat.i(214442);
        Log.i("MicroMsg.TaskBarView", "doReloadData");
        TaskBarView.g(TaskBarView.this);
        if (TaskBarView.this.aki) {
          TaskBarView.h(TaskBarView.this);
        }
        if (TaskBarView.this.getRecyclerView().lq())
        {
          Log.i("MicroMsg.TaskBarView", "isComputingLayout not update");
          TaskBarView.a(TaskBarView.this, true);
          AppMethodBeat.o(214442);
          return;
        }
        TaskBarView.e(TaskBarView.this).MpY.clear();
        TaskBarView.i(TaskBarView.this).alc.notifyChanged();
        TaskBarView.a(TaskBarView.this, false);
        AppMethodBeat.o(214442);
      }
    };
    this.mLastState = -1;
    this.MpG = false;
    this.iZi = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(214169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          if (!TaskBarView.q(TaskBarView.this)) {
            break label94;
          }
          TaskBarView.r(TaskBarView.this);
        }
        for (;;)
        {
          TaskBarView.c(TaskBarView.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(214169);
          return;
          label94:
          if ((TaskBarView.s(TaskBarView.this) == 1) || (TaskBarView.s(TaskBarView.this) == 2)) {
            TaskBarView.gjJ();
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(214171);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (TaskBarView.t(TaskBarView.this))
        {
          TaskBarView.u(TaskBarView.this);
          if (TaskBarView.v(TaskBarView.this) != null)
          {
            paramAnonymousInt1 = TaskBarView.w(TaskBarView.this) - TaskBarView.v(TaskBarView.this).kJ();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < TaskBarView.this.getChildCount()))
            {
              paramAnonymousInt1 = TaskBarView.this.getChildAt(paramAnonymousInt1).getTop();
              TaskBarView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(214171);
      }
    };
    bv(paramContext);
    AppMethodBeat.o(214460);
  }
  
  private int aiY(int paramInt)
  {
    AppMethodBeat.i(214534);
    paramInt = this.Mpi.indexOf(Integer.valueOf(paramInt));
    AppMethodBeat.o(214534);
    return paramInt;
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(214474);
    this.mContext = paramContext;
    setItemAnimator(this.Mpg);
    a(new b((byte)0));
    com.tencent.mm.plugin.appbrand.widget.recent.d.init(this.mContext);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(com.tencent.mm.plugin.taskbar.d.a.transparent));
    this.rFD = new LinearLayoutManager()
    {
      public final boolean canScrollVertically()
      {
        AppMethodBeat.i(215667);
        if (!TaskBarView.a(TaskBarView.this))
        {
          AppMethodBeat.o(215667);
          return true;
        }
        AppMethodBeat.o(215667);
        return false;
      }
    };
    setLayoutManager(this.rFD);
    setOverScrollMode(2);
    a(this.iZi);
    this.afJ = new a();
    setAdapter(this.afJ);
    Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView init %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(214474);
  }
  
  private boolean cnI()
  {
    return ((this.Mpk != null) && (this.Mpk.MrR.rqI)) || ((this.Mpl != null) && (this.Mpl.MrR.rqI));
  }
  
  private AppBrandDesktopContainerView getDesktopContainer()
  {
    AppMethodBeat.i(214541);
    AppBrandDesktopContainerView localAppBrandDesktopContainerView = this.Mnv.getDesktopContainerView();
    AppMethodBeat.o(214541);
    return localAppBrandDesktopContainerView;
  }
  
  private int getEmptyViewTopMargin()
  {
    AppMethodBeat.i(214537);
    boolean bool = gjH();
    int i = com.tencent.mm.ci.a.aZ(getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_7_5_A);
    if (bool)
    {
      j = getHeight();
      if (this.Mpi.contains(Integer.valueOf(5))) {}
      for (;;)
      {
        i = (j - i) / 3;
        AppMethodBeat.o(214537);
        return i;
        i = 0;
      }
    }
    int j = getHeight();
    if (this.Mpi.contains(Integer.valueOf(5))) {
      j -= i;
    }
    for (;;)
    {
      i = j;
      if (this.Mpi.contains(Integer.valueOf(1)))
      {
        i = j;
        if (this.Mpk != null) {
          i = j - this.Mpk.getHeight();
        }
      }
      j = i;
      if (this.Mpi.contains(Integer.valueOf(2)))
      {
        j = i;
        if (this.Mpl != null) {
          j = i - this.Mpl.getHeight();
        }
      }
      i = Math.max(j / 3, com.tencent.mm.ci.a.aZ(getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_2A));
      AppMethodBeat.o(214537);
      return i;
    }
  }
  
  private static boolean gjC()
  {
    AppMethodBeat.i(214495);
    boolean bool2 = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDU, false);
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.TaskBarView", "enableOthersWording %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool2) {
        break;
      }
      AppMethodBeat.o(214495);
      return true;
    }
    AppMethodBeat.o(214495);
    return false;
  }
  
  private void gjD()
  {
    AppMethodBeat.i(214498);
    this.Mpi.clear();
    int j;
    com.tencent.mm.plugin.taskbar.ui.section.d.a locala;
    if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks() == 1))
    {
      j = 1;
      if (j != 0) {
        this.Mpi.add(Integer.valueOf(5));
      }
      if (this.Mph.MpQ.size() <= 0) {
        break label263;
      }
      locala = com.tencent.mm.plugin.taskbar.ui.section.d.MqY;
      if (com.tencent.mm.plugin.taskbar.ui.section.d.a.aje(1)) {
        break label263;
      }
      this.Mpi.add(Integer.valueOf(1));
    }
    label263:
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (this.Mph.MpR.size() > 0)
      {
        locala = com.tencent.mm.plugin.taskbar.ui.section.d.MqY;
        k = i;
        if (!com.tencent.mm.plugin.taskbar.ui.section.d.a.aje(1))
        {
          k = i + 1;
          this.Mpi.add(Integer.valueOf(2));
        }
      }
      if (this.Mph.aiZ(4).MqU.size() > 0) {
        this.Mpi.add(Integer.valueOf(4));
      }
      int m = this.Mpi.size();
      if (j != 0) {}
      for (i = 1;; i = 0)
      {
        if ((m - i == k) && ((k == 0) || (gjC()))) {
          this.Mpi.add(Integer.valueOf(3));
        }
        Log.i("MicroMsg.TaskBarView", "update section: %s", new Object[] { gjE() });
        AppMethodBeat.o(214498);
        return;
        j = 0;
        break;
      }
    }
  }
  
  private String gjE()
  {
    AppMethodBeat.i(214500);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.Mpi.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((Integer)localIterator.next()).intValue()).append(",");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(214500);
    return localObject;
  }
  
  private void gjG()
  {
    this.Mpv = false;
    this.Mpw = false;
  }
  
  private boolean gjH()
  {
    AppMethodBeat.i(214528);
    int j = this.Mpi.size();
    if (this.Mpi.contains(Integer.valueOf(5))) {}
    for (int i = 1; j - i == 1; i = 0)
    {
      AppMethodBeat.o(214528);
      return true;
    }
    AppMethodBeat.o(214528);
    return false;
  }
  
  private void gjx()
  {
    AppMethodBeat.i(214483);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215599);
        if (TaskBarView.d(TaskBarView.this) != null)
        {
          Log.i("MicroMsg.TaskBarView", "checkWeAppSectionData recent: %d", new Object[] { Integer.valueOf(TaskBarView.e(TaskBarView.this).MpQ.size()) });
          TaskBarView.d(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).MpQ);
        }
        if (TaskBarView.f(TaskBarView.this) != null)
        {
          Log.i("MicroMsg.TaskBarView", "checkWeAppSectionData my: %d", new Object[] { Integer.valueOf(TaskBarView.e(TaskBarView.this).MpR.size()) });
          TaskBarView.f(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).MpR);
        }
        AppMethodBeat.o(215599);
      }
    });
    AppMethodBeat.o(214483);
  }
  
  private void setupMultiTaskScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(214504);
    Log.i("MicroMsg.TaskBarView", "setupMultiTaskScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.lm(getContext()).i(com.tencent.mm.plugin.multitask.ui.a.c.class)).in(paramBoolean);
    AppMethodBeat.o(214504);
  }
  
  public final void DC(int paramInt)
  {
    AppMethodBeat.i(214542);
    this.Mnv.al(0L, paramInt);
    AppMethodBeat.o(214542);
  }
  
  public final void a(final int paramInt, final AppBrandDesktopView.a parama, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(214526);
    Log.i("MicroMsg.TaskBarView", "launchAppBrandWithCheck, %d %s %b %b", new Object[] { Integer.valueOf(paramInt), parama.rqa.nickname, Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.isPaused) });
    if (this.isPaused)
    {
      AppMethodBeat.o(214526);
      return;
    }
    d locald = this.Mph;
    LocalUsageInfo localLocalUsageInfo = parama.rqa;
    parama = new d.c()
    {
      public final void ep(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(214638);
        Log.i("MicroMsg.TaskBarView", "checkLaunchAppBrand checkOk: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(TaskBarView.p(TaskBarView.this));
          com.tencent.mm.plugin.appbrand.launching.f.a.aki(parama.rqa.username);
          AppMethodBeat.o(214638);
          return;
        }
        TaskBarView.l(TaskBarView.this);
        Object localObject2;
        Object localObject1;
        int k;
        boolean bool;
        if (paramBoolean1)
        {
          TaskBarView.a(TaskBarView.this, 1104, parama.rqa, paramInt, paramBoolean2);
          localObject2 = TaskBarView.this;
          localObject1 = parama.rqa;
          k = paramInt;
          paramAnonymousBoolean = paramBoolean1;
          bool = paramBoolean2;
          localObject2 = ((TaskBarView)localObject2).Mph;
          p.k(localObject1, "appItem");
          Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked appId:%s,pos:%d,isMy:%b,desktop:%b", new Object[] { ((LocalUsageInfo)localObject1).appId, Integer.valueOf(k), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool) });
          localObject1 = com.tencent.mm.plugin.multitask.g.fq(((LocalUsageInfo)localObject1).appId, ((LocalUsageInfo)localObject1).cBU);
          if (!paramAnonymousBoolean) {
            break label289;
          }
        }
        label289:
        for (int j = 3;; j = 1)
        {
          ((d)localObject2).MpZ = j;
          if (!bool) {}
          for (;;)
          {
            ((d)localObject2).MpW.g(j, k, (String)localObject1, i);
            AppMethodBeat.o(214638);
            return;
            TaskBarView.a(TaskBarView.this, 1089, parama.rqa, paramInt, paramBoolean2);
            break;
            if (paramAnonymousBoolean) {
              i = 3;
            } else {
              i = 2;
            }
          }
        }
      }
    };
    if ((!locald.lsi) || (locald.rec == 1))
    {
      parama.ep(true);
      AppMethodBeat.o(214526);
      return;
    }
    if ((localLocalUsageInfo != null) && (!Util.isNullOrNil(localLocalUsageInfo.username)))
    {
      Object localObject = ((q)com.tencent.mm.kernel.h.ae(q.class)).aeW(localLocalUsageInfo.username);
      if (localObject != null)
      {
        localObject = ((WxaAttributes)localObject).bLF();
        p.j(localObject, "attrs.appInfo");
        parama.ep(locald.a(localLocalUsageInfo, (WxaAttributes.a)localObject));
        AppMethodBeat.o(214526);
        return;
      }
      ((q)com.tencent.mm.kernel.h.ae(q.class)).a(localLocalUsageInfo.username, (q.a)new d.e(locald, parama, localLocalUsageInfo));
      AppMethodBeat.o(214526);
      return;
    }
    parama.ep(true);
    AppMethodBeat.o(214526);
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214561);
    d locald = this.Mph;
    p.k(paramLocalUsageInfo, "appItem");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemReorderWeApp appId:%s,start:%d end:%d", new Object[] { paramLocalUsageInfo.appId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramLocalUsageInfo = com.tencent.mm.plugin.multitask.g.fq(paramLocalUsageInfo.appId, paramLocalUsageInfo.cBU);
    locald.MpW.a(3, 0, 3, paramLocalUsageInfo, 0, 3, paramInt1, paramInt2);
    AppMethodBeat.o(214561);
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(214557);
    d locald = this.Mph;
    p.k(paramLocalUsageInfo, "appItem");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemManualDeleted appId:%s,pos:%d", new Object[] { paramLocalUsageInfo.appId, Integer.valueOf(paramInt) });
    paramLocalUsageInfo = com.tencent.mm.plugin.multitask.g.fq(paramLocalUsageInfo.appId, paramLocalUsageInfo.cBU);
    if (paramBoolean) {}
    for (paramInt = 3;; paramInt = 1)
    {
      locald.MpW.a(2, 7, paramInt, paramLocalUsageInfo, 0, 1, 0, 0);
      AppMethodBeat.o(214557);
      return;
    }
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 3;
    AppMethodBeat.i(214555);
    if ((!paramBoolean2) && (this.Mpu))
    {
      AppMethodBeat.o(214555);
      return;
    }
    d locald = this.Mph;
    p.k(paramLocalUsageInfo, "appItem");
    String str = com.tencent.mm.plugin.multitask.g.fq(paramLocalUsageInfo.appId, paramLocalUsageInfo.cBU);
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear appId:%s,multiTaskId:%s desktop:%b loadMore:%b isMy:%b", new Object[] { paramLocalUsageInfo.appId, str, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean1) });
    if (paramBoolean1) {}
    for (int i = 3;; i = 1)
    {
      if (!paramBoolean2)
      {
        paramLocalUsageInfo = locald.MpP;
        if ((paramLocalUsageInfo != null) && (paramLocalUsageInfo.fcH() == true))
        {
          locald.MpW.h(2, i, str, 1);
          AppMethodBeat.o(214555);
          return;
        }
        paramLocalUsageInfo = new d.d();
        paramLocalUsageInfo.Mqg = 1;
        paramLocalUsageInfo.pageType = i;
        paramLocalUsageInfo.sQY = str;
        locald.MpY.add(paramLocalUsageInfo);
        AppMethodBeat.o(214555);
        return;
      }
      int j;
      if (paramBoolean1)
      {
        j = 3;
        if (!paramBoolean3) {
          break label235;
        }
      }
      for (;;)
      {
        locald.MpW.h(k, i, str, j);
        AppMethodBeat.o(214555);
        return;
        j = 2;
        break;
        label235:
        k = 2;
      }
    }
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, int paramInt)
  {
    AppMethodBeat.i(214545);
    d locald = this.Mph;
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d,pos:%d", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), Integer.valueOf(paramInt) });
    int i = com.tencent.mm.plugin.taskbar.a.a.RC(paramMultiTaskInfo.field_type);
    locald.MpZ = i;
    locald.MpW.g(i, paramInt, paramMultiTaskInfo.field_id, 1);
    AppMethodBeat.o(214545);
  }
  
  public final void a(boolean paramBoolean1, LocalUsageInfo paramLocalUsageInfo, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(214558);
    d locald = this.Mph;
    p.k(paramLocalUsageInfo, "appItem");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemManualAddDeleteMyWeApp appId:%s,pos:%d", new Object[] { paramLocalUsageInfo.appId, Integer.valueOf(paramInt1) });
    paramLocalUsageInfo = com.tencent.mm.plugin.multitask.g.fq(paramLocalUsageInfo.appId, paramLocalUsageInfo.cBU);
    if (paramBoolean2) {}
    for (paramInt1 = 3;; paramInt1 = 1)
    {
      if (paramBoolean1) {}
      for (;;)
      {
        int j = 7;
        if (paramBoolean1) {
          j = 6;
        }
        locald.MpW.a(i, j, paramInt1, paramLocalUsageInfo, 0, paramInt2, 0, 0);
        AppMethodBeat.o(214558);
        return;
        i = 2;
      }
    }
  }
  
  public final void aiS(int paramInt)
  {
    AppMethodBeat.i(214515);
    kr(paramInt, 0);
    AppMethodBeat.o(214515);
  }
  
  public final void aiW(final int paramInt)
  {
    AppMethodBeat.i(214493);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214702);
        Log.i("MicroMsg.TaskBarView", "onSectionDeleted %d", new Object[] { Integer.valueOf(paramInt) });
        if ((paramInt == 4) && (!TaskBarView.e(TaskBarView.this).aiZ(4).MqV.isEmpty()))
        {
          Log.i("MicroMsg.TaskBarView", "showDataList not empty!");
          AppMethodBeat.o(214702);
          return;
        }
        int i = TaskBarView.a(TaskBarView.this, paramInt);
        if (i == -1)
        {
          Log.i("MicroMsg.TaskBarView", "section not found!");
          AppMethodBeat.o(214702);
          return;
        }
        TaskBarView.b(TaskBarView.this).remove(i);
        TaskBarView.this.getAdapter().cN(i);
        int k = TaskBarView.b(TaskBarView.this).size();
        if (TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(5)))
        {
          i = 1;
          if ((k - i != 1) || (((Integer)TaskBarView.b(TaskBarView.this).get(i)).intValue() != 3)) {
            break label312;
          }
        }
        label312:
        for (int j = 1;; j = 0)
        {
          TaskBarView.g(TaskBarView.this);
          if ((TaskBarView.b(TaskBarView.this).size() > k) || (j != 0))
          {
            if (j != 0)
            {
              TaskBarView.this.getAdapter().cL(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(3)));
              AppMethodBeat.o(214702);
              return;
              i = 0;
              break;
            }
            if (TaskBarView.b(TaskBarView.this).size() > i + 1)
            {
              Log.i("MicroMsg.TaskBarView", "other tips show[remove section], mark");
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDV, Boolean.TRUE);
            }
            TaskBarView.this.getAdapter().cM(TaskBarView.b(TaskBarView.this).size() - 1);
          }
          AppMethodBeat.o(214702);
          return;
        }
      }
    });
    AppMethodBeat.o(214493);
  }
  
  public final void aiX(int paramInt)
  {
    AppMethodBeat.i(214533);
    if ((paramInt == 4) && (aiY(paramInt) != -1) && (this.Mph.aiZ(4).MqV.isEmpty()))
    {
      Log.i("MicroMsg.TaskBarView", "other last item removed");
      this.Mph.a(this.Mph.aiZ(4));
      aiW(4);
      AppMethodBeat.o(214533);
      return;
    }
    getAdapter().d(aiY(paramInt), Boolean.TRUE);
    AppMethodBeat.o(214533);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(214549);
    this.Mph.c(paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(214549);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214470);
    if (this.Mpz)
    {
      AppMethodBeat.o(214470);
      return true;
    }
    boolean bool;
    if (cnI())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(214470);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(214470);
      return bool;
    case 0: 
      this.BpS = paramMotionEvent.getRawX();
      this.rpT = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      this.MpC = 0.0F;
      this.rpU = 0.0F;
      this.rpV = false;
      this.rpW = false;
      this.MpD = false;
      this.MpE = false;
      break;
      if (this.MpD)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(214470);
        return bool;
      }
      float f2;
      if (!this.MpE)
      {
        float f1 = Math.abs(paramMotionEvent.getRawX() - this.BpS);
        f2 = Math.abs(paramMotionEvent.getRawY() - this.rpT);
        if (f1 <= this.mTouchSlop) {
          break label359;
        }
        if ((f2 > this.mTouchSlop) && (f2 > f1)) {
          this.MpE = true;
        }
      }
      else
      {
        label232:
        Log.v("MicroMsg.TaskBarView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.rpV), Float.valueOf(this.rpU), Integer.valueOf(this.mTouchSlop) });
        if ((this.rFD == null) || (this.Mpi == null)) {
          break label383;
        }
        if (this.rFD.kM() != this.Mpi.size() - 1) {
          break label377;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (!this.rpV))
        {
          if (!this.rpW)
          {
            this.rpT = paramMotionEvent.getRawY();
            this.rpU = 0.0F;
            this.rpW = true;
            break;
            this.MpD = true;
            break;
            label359:
            if (f2 <= this.mTouchSlop) {
              break label232;
            }
            this.MpE = true;
            break label232;
            label377:
            i = 0;
            continue;
            label383:
            i = 0;
            continue;
          }
          this.rpU = ((paramMotionEvent.getRawY() - this.rpT) * 0.55F);
          if (this.rpU >= 0.0F) {
            break;
          }
          this.rpV = true;
          break;
        }
      }
      if (!this.rpV) {
        break;
      }
      this.rpU = ((paramMotionEvent.getRawY() - this.rpT) * 0.55F);
      if (this.rpU > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(214470);
        return bool;
      }
      if (this.rpU < -this.mTouchSlop)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
      }
      int i = (int)Math.abs(this.rpU);
      Log.v("MicroMsg.TaskBarView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(214470);
      return true;
      if (this.rpV) {
        if ((Math.abs(this.rpU) >= AppBrandDesktopView.rpG) && (this.Mnv != null))
        {
          Log.i("MicroMsg.TaskBarView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.Mnv.al(0L, 15);
        }
        else
        {
          animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).start();
        }
      }
    }
  }
  
  public final boolean fcH()
  {
    return this.Mpr;
  }
  
  public RecyclerView getRecyclerView()
  {
    return this;
  }
  
  public int getTaskBarContainerBottom()
  {
    AppMethodBeat.i(214523);
    int i = getBottom();
    AppMethodBeat.o(214523);
    return i;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public final void gjA()
  {
    AppMethodBeat.i(214489);
    int i = this.Mpi.indexOf(Integer.valueOf(4));
    if (i != -1)
    {
      Log.i("MicroMsg.TaskBarView", "do reloadOtherData");
      if (this.Mph.aiZ(4).MqU.isEmpty())
      {
        gjD();
        this.afJ.cN(i);
        AppMethodBeat.o(214489);
        return;
      }
      this.afJ.cL(i);
    }
    AppMethodBeat.o(214489);
  }
  
  public final void gjB()
  {
    AppMethodBeat.i(214491);
    Log.i("MicroMsg.TaskBarView", "onTeenModeStatusChanged");
    this.Mph.gjU();
    AppBrandDesktopView localAppBrandDesktopView = getDesktopContainer().rpr;
    localAppBrandDesktopView.cnt();
    localAppBrandDesktopView.cnu();
    AppMethodBeat.o(214491);
  }
  
  public final void gjF()
  {
    AppMethodBeat.i(214519);
    if ((this.Mnv != null) && (e.aAt()))
    {
      Log.i("MicroMsg.TaskBarView", "alvinluo switchToGradientBackgroundView");
      Object localObject = this.Mnv.getParent();
      if ((localObject instanceof View)) {
        ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.taskbar.d.a.transparent));
      }
      localObject = this.Mnv.getBackgroundGLSurfaceContainer();
      if (localObject != null)
      {
        ((DynamicBgContainer)localObject).pause();
        this.MpB = true;
      }
    }
    AppMethodBeat.o(214519);
  }
  
  public final void gjI()
  {
    AppMethodBeat.i(214531);
    gjG();
    this.Mpx = false;
    com.tencent.mm.plugin.websearch.api.h localh = (com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class);
    if (localh != null)
    {
      this.Mpu = true;
      localh.b(this.mContext, 42, this.rpR, "");
    }
    c(12, false, false);
    AppMethodBeat.o(214531);
  }
  
  public final void gjn()
  {
    AppMethodBeat.i(214508);
    Log.i("MicroMsg.TaskBarView", "[onOpenHeader]");
    if (!this.Mpr)
    {
      if ((this.Mpi.size() > 1) && (this.Mpi.contains(Integer.valueOf(3))))
      {
        Log.i("MicroMsg.TaskBarView", "other tips show[speard], mark");
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDV, Boolean.TRUE);
      }
      if ((gjC()) && (this.Mpi.contains(Integer.valueOf(4))) && (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDV, false)))
      {
        Log.i("MicroMsg.TaskBarView", "other tips hide[speard], mark disabled");
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDU, Boolean.TRUE);
      }
      this.Mpz = false;
      setupMultiTaskScroll(false);
      Object localObject1 = this.rpR;
      Object localObject2 = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vom, null);
      if ((localObject2 instanceof String)) {
        this.rpR = Util.nullAs((String)localObject2, this.rpR);
      }
      Log.d("MicroMsg.TaskBarView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.rpR });
      m.amE(m.chF());
      this.Mpr = true;
      this.Mps = false;
      this.Mpv = true;
      this.Mpw = true;
      ai.Tv(0L);
      localObject1 = this.Mph;
      localObject2 = ((d)localObject1).MpW;
      ((com.tencent.mm.plugin.taskbar.a.a)localObject2).Mnt = (System.currentTimeMillis() / 1000L);
      ((com.tencent.mm.plugin.taskbar.a.a)localObject2).Mnu = String.valueOf((int)((com.tencent.mm.plugin.taskbar.a.a)localObject2).Mnt);
      ((d)localObject1).pZO = System.currentTimeMillis();
      ((d)localObject1).MpZ = 0;
      Log.i("MicroMsg.TaskBarViewPresenter", "onDidAppear lastStartTime:%d", new Object[] { Long.valueOf(((d)localObject1).pZO) });
      ((d)localObject1).zZ(false);
      localObject2 = ((d)localObject1).MpY.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        d.d locald = (d.d)((Iterator)localObject2).next();
        MultiTaskInfo localMultiTaskInfo = locald.FNi;
        if (localMultiTaskInfo != null) {
          ((PluginTaskBar)com.tencent.mm.kernel.h.ag(PluginTaskBar.class)).notifyExposeTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
        }
        ((d)localObject1).MpW.h(locald.Mqg, locald.pageType, locald.sQY, 1);
      }
      ((d)localObject1).MpY.clear();
      j.bJf().a(Util.nowMilliSecond(), true, null, 6, 0);
      i.cjb().a(LuggageServiceType.cBP, z.qOT);
      i.cjb().a(LuggageServiceType.cBQ, z.qOT);
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(214508);
  }
  
  public final void gjo()
  {
    AppMethodBeat.i(214518);
    gjn();
    AppMethodBeat.o(214518);
  }
  
  public final void gju()
  {
    AppMethodBeat.i(214479);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215119);
        com.tencent.mm.plugin.taskbar.ui.section.other.a locala;
        Object localObject;
        int i;
        int j;
        label144:
        if ((TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(4))) && (TaskBarView.c(TaskBarView.this) != null))
        {
          locala = TaskBarView.c(TaskBarView.this);
          localObject = locala.getViewModel().MqV.iterator();
          i = 0;
          if (!((Iterator)localObject).hasNext()) {
            break label200;
          }
          if (((MultiTaskInfo)((Iterator)localObject).next()).field_type != 21) {
            break label188;
          }
          j = 1;
          label85:
          if (j == 0) {
            break label193;
          }
          label89:
          if (i != -1)
          {
            Iterator localIterator = ((Iterable)locala.getViewModel().MqU).iterator();
            label112:
            if (!localIterator.hasNext()) {
              break label210;
            }
            localObject = localIterator.next();
            if (((MultiTaskInfo)localObject).field_type != 21) {
              break label205;
            }
            j = 1;
            if (j == 0) {
              break label208;
            }
          }
        }
        for (;;)
        {
          localObject = (MultiTaskInfo)localObject;
          if (localObject != null) {
            locala.getViewModel().MqV.set(i, localObject);
          }
          locala.Mrg.cL(i);
          AppMethodBeat.o(215119);
          return;
          label188:
          j = 0;
          break label85;
          label193:
          i += 1;
          break;
          label200:
          i = -1;
          break label89;
          label205:
          j = 0;
          break label144;
          label208:
          break label112;
          label210:
          localObject = null;
        }
      }
    });
    AppMethodBeat.o(214479);
  }
  
  public final void gjv()
  {
    AppMethodBeat.i(214480);
    Log.i("MicroMsg.TaskBarView", "onDataUpdated");
    this.Mpt = true;
    gjw();
    AppMethodBeat.o(214480);
  }
  
  public final void gjw()
  {
    boolean bool2 = true;
    AppMethodBeat.i(214481);
    gjx();
    boolean bool3 = this.Mpu;
    boolean bool4 = this.kUD;
    boolean bool5 = this.Mpt;
    boolean bool6 = this.Mps;
    boolean bool1;
    boolean bool7;
    if (!this.isPaused)
    {
      bool1 = true;
      bool7 = this.Mph.gjO();
      if (this.Mpq) {
        break label203;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TaskBarView", "reloadDataIfNeed isInSecondaryPage[%b],isStopped[%b] | shouldReloadOnAppear[%b] isHeaderDidClose[%b] !isPaused[%b] isOnMainTab[%b] !isHeaderStartOpen[%b]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool2) });
      if ((this.Mpu) || ((this.kUD) && (!this.Mps)) || ((this.Mpt) && (this.Mps) && (!this.isPaused) && (this.Mph.gjO()) && (!this.Mpq))) {
        gjz();
      }
      AppMethodBeat.o(214481);
      return;
      bool1 = false;
      break;
      label203:
      bool2 = false;
    }
  }
  
  public final void gjy()
  {
    AppMethodBeat.i(214485);
    Log.i("MicroMsg.TaskBarView", "forceReloadData");
    gjz();
    AppMethodBeat.o(214485);
  }
  
  public final void gjz()
  {
    AppMethodBeat.i(214487);
    removeCallbacks(this.MpF);
    post(this.MpF);
    AppMethodBeat.o(214487);
  }
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(214547);
    this.Mpu = false;
    if (paramBoolean) {
      this.Mph.zZ(true);
    }
    AppMethodBeat.o(214547);
  }
  
  public final void kr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214511);
    Log.i("MicroMsg.TaskBarView", "[onCloseHeader] reason: %d duration:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    if (this.Mpr)
    {
      this.Mpu = false;
      this.Mpr = false;
      this.Mpq = false;
      this.Mpz = false;
      localObject1 = this.Mph;
      boolean bool = getDesktopContainer().cnm();
      localObject2 = getDesktopContainer().rpr.getViewModel();
      if ((localObject2 == null) || (((com.tencent.mm.plugin.appbrand.widget.desktop.c)localObject2).cnA() != 2)) {
        break label508;
      }
      i = 1;
      Log.i("MicroMsg.TaskBarViewPresenter", "onDidClose reason:%d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 != 13) && (paramInt1 != 0)) {
        break label513;
      }
      j = 2;
      label136:
      l = System.currentTimeMillis();
      ((d)localObject1).MpX += l - ((d)localObject1).pZO;
      if (bool) {
        break label519;
      }
      i = 1;
      label167:
      Log.i("MicroMsg.TaskBarViewPresenter", "reportTaskBarClose viewDuration:%d,lastStartTime:%d,currentTime:%d,closeType:%d,reportTime:%d,page:%d", new Object[] { Long.valueOf(((d)localObject1).MpX), Long.valueOf(((d)localObject1).pZO), Long.valueOf(l), Integer.valueOf(((d)localObject1).MpZ), Integer.valueOf((int)(((d)localObject1).MpX / 1000L)), Integer.valueOf(i) });
      localObject2 = ((d)localObject1).MpW;
      int k = (int)(((d)localObject1).MpX / 1000L);
      int m = ((d)localObject1).MpZ;
      u localu = new u();
      localu.gfz = localu.z("session_id", ((com.tencent.mm.plugin.taskbar.a.a)localObject2).Mnu, true);
      localu.gfA = j;
      localu.gfP = k;
      localu.gfM = m;
      localu.gfL = i;
      localu.bpa();
      ((d)localObject1).MpX = 0L;
      ((d)localObject1).pZO = 0L;
      if (this.Mpk != null) {
        this.Mpk.Ab(getDesktopContainer().cnm());
      }
      if (this.Mpl != null) {
        this.Mpl.Ab(getDesktopContainer().cnm());
      }
      this.Mpv = false;
      this.Mpw = false;
      this.Mph.gjU();
      localObject1 = new TaskBarView.10(this);
      if (paramInt1 != 15) {
        break label533;
      }
      l = paramInt2;
      label427:
      postDelayed((Runnable)localObject1, l);
      localObject1 = getDesktopContainer();
      localObject2 = (Runnable)new AppBrandDesktopContainerView.e((AppBrandDesktopContainerView)localObject1, paramInt1, paramInt2);
      if ((paramInt1 != 15) || (!((AppBrandDesktopContainerView)localObject1).cnm())) {
        break label539;
      }
    }
    label513:
    label519:
    label533:
    label539:
    for (long l = paramInt2;; l = 0L)
    {
      ((AppBrandDesktopContainerView)localObject1).postDelayed((Runnable)localObject2, l);
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214735);
          TaskBarView.j(TaskBarView.this);
          AppMethodBeat.o(214735);
        }
      }, paramInt2);
      AppMethodBeat.o(214511);
      return;
      label508:
      i = 0;
      break;
      j = 1;
      break label136;
      if (i != 0)
      {
        i = 3;
        break label167;
      }
      i = 2;
      break label167;
      l = 0L;
      break label427;
    }
  }
  
  public final void n(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214551);
    if (this.Mpu)
    {
      AppMethodBeat.o(214551);
      return;
    }
    d locald = this.Mph;
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear type:%d,multiTaskId:%s", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), paramMultiTaskInfo.field_id });
    int i = com.tencent.mm.plugin.taskbar.a.a.RC(paramMultiTaskInfo.field_type);
    Object localObject = locald.MpP;
    if ((localObject != null) && (((d.b)localObject).fcH() == true))
    {
      locald.MpW.h(2, i, paramMultiTaskInfo.field_id, 1);
      AppMethodBeat.o(214551);
      return;
    }
    localObject = new d.d();
    ((d.d)localObject).Mqg = 1;
    ((d.d)localObject).pageType = i;
    ((d.d)localObject).sQY = paramMultiTaskInfo.field_id;
    ((d.d)localObject).FNi = paramMultiTaskInfo;
    locald.MpY.add(localObject);
    AppMethodBeat.o(214551);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(214471);
    super.onAttachedToWindow();
    View localView = getRootView();
    if (localView == null)
    {
      AppMethodBeat.o(214471);
      return;
    }
    this.DpU = ((RelativeLayout)localView.findViewById(com.tencent.mm.plugin.taskbar.d.d.main_ui_container));
    AppMethodBeat.o(214471);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214467);
    if (this.MpD)
    {
      AppMethodBeat.o(214467);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(214467);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214501);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.Mnv != null) && (this.Mpn != this.Mnv.getViewHeight()))
    {
      this.Mpn = this.Mnv.getViewHeight();
      Log.i("MicroMsg.TaskBarView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.Mpn), Integer.valueOf(this.Mnv.getMeasuredHeight()) });
    }
    AppMethodBeat.o(214501);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(214465);
    super.onVisibilityChanged(paramView, paramInt);
    Log.d("MicroMsg.TaskBarView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.Mpx) && (this.Mnv != null))
      {
        this.Mnv.am(100L, this.MpA);
        this.MpA = 0;
        this.Mpx = false;
      }
      if (this.fRO)
      {
        Log.i("MicroMsg.TaskBarView", "alvinluo onVisibilityChanged needRefresh");
        this.fRO = false;
        if (this.Mpp != null) {
          removeCallbacks(this.Mpp);
        }
        paramView = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215587);
            TaskBarView.this.setLayoutFrozen(false);
            AppMethodBeat.o(215587);
          }
        };
        this.Mpp = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(214465);
  }
  
  public void setHeaderContainer(TaskBarContainer paramTaskBarContainer)
  {
    AppMethodBeat.i(214462);
    this.Mnv = paramTaskBarContainer;
    getDesktopContainer().setCallback(this);
    AppMethodBeat.o(214462);
  }
  
  public final void z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(214562);
    Object localObject = this.Mph;
    int i;
    int j;
    if (e.aAt())
    {
      i = 1;
      localObject = ((d)localObject).MpW;
      if (paramBoolean) {
        break label75;
      }
      j = paramInt;
      label34:
      if (!paramBoolean) {
        break label81;
      }
      label38:
      if (!paramBoolean) {
        break label86;
      }
    }
    label75:
    label81:
    label86:
    for (int k = 3;; k = 2)
    {
      ((com.tencent.mm.plugin.taskbar.a.a)localObject).a(2, i, j, 0, 0, 0, 0, 0, paramInt, 0, k);
      AppMethodBeat.o(214562);
      return;
      i = 0;
      break;
      j = 0;
      break label34;
      paramInt = 0;
      break label38;
    }
  }
  
  public final void zU(boolean paramBoolean)
  {
    AppMethodBeat.i(214506);
    Log.i("MicroMsg.TaskBarView", "onStartPull isStart:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.Mpq = true;
      this.Mph.gjR();
      AppMethodBeat.o(214506);
      return;
    }
    this.Mpq = false;
    AppMethodBeat.o(214506);
  }
  
  public final void zV(boolean paramBoolean)
  {
    this.Mpz = paramBoolean;
  }
  
  public final void zW(boolean paramBoolean)
  {
    this.Mpy = paramBoolean;
    this.Mpx = true;
  }
  
  final class a
    extends RecyclerView.a<com.tencent.mm.plugin.taskbar.ui.section.a>
  {
    private TaskBarSectionWeAppRecyclerView.b MpN;
    
    a()
    {
      AppMethodBeat.i(215218);
      this.MpN = new TaskBarSectionWeAppRecyclerView.b()
      {
        private void zY(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(215323);
          Log.i("MicroMsg.TaskBarView", "jumpToWeAppList %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          TaskBarView.l(TaskBarView.this);
          TaskBarView.m(TaskBarView.this);
          TaskBarView.n(TaskBarView.this).kc(paramAnonymousBoolean);
          TaskBarView localTaskBarView = TaskBarView.this;
          if (paramAnonymousBoolean) {}
          for (int i = 2;; i = 11)
          {
            localTaskBarView.c(i, false, false);
            AppMethodBeat.o(215323);
            return;
          }
        }
        
        public final void a(int paramAnonymousInt, AppBrandDesktopView.a paramAnonymousa)
        {
          AppMethodBeat.i(215320);
          Log.i("MicroMsg.TaskBarView", "notifyMyWeAppChanged %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          int i = TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(2));
          if (i != -1) {
            if (TaskBarView.f(TaskBarView.this) != null)
            {
              TaskBarView.f(TaskBarView.this).a(paramAnonymousa);
              if (!TaskBarView.this.getRecyclerView().lq()) {
                TaskBarView.i(TaskBarView.this).d(i, Boolean.TRUE);
              }
            }
          }
          for (;;)
          {
            TaskBarView.this.a(true, paramAnonymousa.rqa, paramAnonymousInt, true, 1);
            AppMethodBeat.o(215320);
            return;
            if (!TaskBarView.this.getRecyclerView().lq())
            {
              if (TaskBarView.e(TaskBarView.this).MpR.isEmpty()) {
                TaskBarView.e(TaskBarView.this).MpR.add(paramAnonymousa);
              }
              TaskBarView.g(TaskBarView.this);
              TaskBarView.i(TaskBarView.this).cM(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(2)));
            }
          }
        }
        
        public final void a(RecyclerView.v paramAnonymousv, View paramAnonymousView, AppBrandDesktopView.a paramAnonymousa, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(215314);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(215314);
            return;
          }
          TaskBarView.this.a(paramAnonymousv.md(), paramAnonymousa, paramAnonymousBoolean, false);
          AppMethodBeat.o(215314);
        }
        
        public final void a(AppBrandDesktopView.a paramAnonymousa, int paramAnonymousInt)
        {
          AppMethodBeat.i(215317);
          TaskBarView.e(TaskBarView.this).bn(paramAnonymousInt, false);
          TaskBarView.i(TaskBarView.this).d(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(1)), Boolean.TRUE);
          TaskBarView.this.a(paramAnonymousa.rqa, paramAnonymousInt, false);
          AppMethodBeat.o(215317);
        }
        
        public final void a(AppBrandDesktopView.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(215319);
          TaskBarView.this.a(paramAnonymousa.rqa, paramAnonymousBoolean, false, false);
          AppMethodBeat.o(215319);
        }
        
        public final boolean ar(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(215322);
          if (TaskBarView.f(TaskBarView.this) != null)
          {
            boolean bool = TaskBarView.f(TaskBarView.this).as(paramAnonymousFloat1, paramAnonymousFloat2);
            AppMethodBeat.o(215322);
            return bool;
          }
          AppMethodBeat.o(215322);
          return false;
        }
        
        public final void b(AppBrandDesktopView.a paramAnonymousa, int paramAnonymousInt)
        {
          AppMethodBeat.i(215318);
          TaskBarView.e(TaskBarView.this).bn(paramAnonymousInt, true);
          TaskBarView.i(TaskBarView.this).d(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(2)), Boolean.TRUE);
          TaskBarView.this.a(paramAnonymousa.rqa, paramAnonymousInt, true);
          AppMethodBeat.o(215318);
        }
        
        public final void cm(float paramAnonymousFloat) {}
        
        public final void gjK()
        {
          AppMethodBeat.i(215315);
          zY(false);
          AppMethodBeat.o(215315);
        }
        
        public final void gjL()
        {
          AppMethodBeat.i(215316);
          zY(true);
          AppMethodBeat.o(215316);
        }
        
        public final void zX(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(215321);
          if (TaskBarView.f(TaskBarView.this) != null)
          {
            Object localObject1 = TaskBarView.f(TaskBarView.this);
            Object localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv;
            p.j(localObject2, "starMaskView");
            if ((((FrameLayout)localObject2).getVisibility() == 4) && (paramAnonymousBoolean))
            {
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).as(-1.0F, -1.0F);
              localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv;
              p.j(localObject2, "starMaskView");
              ((FrameLayout)localObject2).setVisibility(0);
              Object localObject3;
              if (!((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).MrA)
              {
                int i = com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.app_brand_desktop_close_area_height);
                int j = com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.app_brand_desktop_close_area_extra);
                localObject2 = new Rect();
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mry.getGlobalVisibleRect((Rect)localObject2);
                localObject3 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mry;
                p.j(localObject3, "starMaskContent");
                localObject3 = ((LinearLayout)localObject3).getLayoutParams();
                if (localObject3 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                  AppMethodBeat.o(215321);
                  throw ((Throwable)localObject1);
                }
                localObject3 = (RelativeLayout.LayoutParams)localObject3;
                if (((Rect)localObject2).bottom + com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_A) <= com.tencent.mm.ci.a.ks(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext()) - (j + i)) {
                  break label354;
                }
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).MrA = true;
                Log.i("MicroMsg.AppBrandDesktopSectionMyWeAppView", "need adjust mask view height");
                ((RelativeLayout.LayoutParams)localObject3).removeRule(13);
                ((RelativeLayout.LayoutParams)localObject3).addRule(14);
              }
              for (((RelativeLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.ci.a.aZ(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_A);; ((RelativeLayout.LayoutParams)localObject3).topMargin = 0)
              {
                localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mry;
                p.j(localObject2, "starMaskContent");
                ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
                localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv;
                p.j(localObject2, "starMaskView");
                ((FrameLayout)localObject2).setAlpha(0.0F);
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv.clearAnimation();
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv.animate().alpha(1.0F).setDuration(250L).setListener(null).start();
                AppMethodBeat.o(215321);
                return;
                label354:
                ((RelativeLayout.LayoutParams)localObject3).addRule(13);
                ((RelativeLayout.LayoutParams)localObject3).removeRule(14);
              }
            }
            localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv;
            p.j(localObject2, "starMaskView");
            if ((((FrameLayout)localObject2).getVisibility() == 0) && (!paramAnonymousBoolean))
            {
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv.clearAnimation();
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).Mrv.animate().alpha(0.0F).setDuration(250L).setListener((Animator.AnimatorListener)new a.b((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1)).start();
            }
          }
          AppMethodBeat.o(215321);
        }
      };
      aw(true);
      AppMethodBeat.o(215218);
    }
    
    private void a(com.tencent.mm.plugin.taskbar.ui.section.a parama, int paramInt)
    {
      AppMethodBeat.i(215228);
      Log.i("MicroMsg.TaskBarView", "onBind %d %d", new Object[] { Integer.valueOf(parama.amo), Integer.valueOf(paramInt) });
      switch (parama.amo)
      {
      default: 
      case 1: 
      case 2: 
        for (;;)
        {
          localObject1 = parama.gkf().getViewModel();
          Log.i("MicroMsg.TaskBarSectionViewModel", "update show data oldCount:" + ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).MqV.size() + " new:" + ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).MqU.size());
          ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).MqV.clear();
          ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).MqV.addAll((Collection)((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).MqU);
          parama.gkf().notifyDataSetChanged();
          AppMethodBeat.o(215228);
          return;
          TaskBarView.a(TaskBarView.this, (com.tencent.mm.plugin.taskbar.ui.section.weapp.d)parama.amk);
          TaskBarView.d(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).MpQ);
          continue;
          TaskBarView.a(TaskBarView.this, (com.tencent.mm.plugin.taskbar.ui.section.weapp.a)parama.amk);
          TaskBarView.f(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).MpR);
        }
      }
      Object localObject2 = (com.tencent.mm.plugin.taskbar.ui.section.c)parama.amk;
      boolean bool = TaskBarView.o(TaskBarView.this);
      Object localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.c)localObject2).tym;
      localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.c)localObject2).getContext();
      if (bool) {}
      for (paramInt = d.g.MmN;; paramInt = d.g.MmP)
      {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.ci.a.ba((Context)localObject2, paramInt));
        break;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(215230);
      int i = TaskBarView.b(TaskBarView.this).size();
      AppMethodBeat.o(215230);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(215220);
      long l = ((Integer)TaskBarView.b(TaskBarView.this).get(paramInt)).intValue();
      AppMethodBeat.o(215220);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(215223);
      paramInt = TaskBarView.b(TaskBarView.this, paramInt);
      AppMethodBeat.o(215223);
      return paramInt;
    }
  }
  
  final class b
    extends RecyclerView.h
  {
    private b() {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(214793);
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRecyclerView = paramRecyclerView.aQ(paramView);
      if (paramRecyclerView == null)
      {
        Log.w("MicroMsg.TaskBarView", "null holder");
        AppMethodBeat.o(214793);
        return;
      }
      int i = paramRecyclerView.md();
      if ((params.ama) && (i == -1)) {
        i = paramRecyclerView.amm;
      }
      for (;;)
      {
        int j = paramRecyclerView.amo;
        if (i != 0) {
          if (j == 2) {
            if (TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(1))) {
              paramRect.top = com.tencent.mm.ci.a.aZ(paramView.getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_A);
            }
          }
        }
        for (;;)
        {
          if (j == 3) {
            paramRect.top = TaskBarView.x(TaskBarView.this);
          }
          if (j == ((Integer)TaskBarView.b(TaskBarView.this).get(TaskBarView.b(TaskBarView.this).size() - 1)).intValue()) {
            paramRect.bottom = com.tencent.mm.ci.a.aZ(paramView.getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_5A);
          }
          Log.i("MicroMsg.TaskBarView", "getItemOffsets index:%d sectionType:%d rect:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRect });
          AppMethodBeat.o(214793);
          return;
          paramRect.top = 0;
          continue;
          if (j == 4) {
            if ((TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(2))) || (TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(1)))) {
              paramRect.top = com.tencent.mm.ci.a.aZ(paramView.getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_4A);
            } else {
              paramRect.top = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarView
 * JD-Core Version:    0.7.0.1
 */