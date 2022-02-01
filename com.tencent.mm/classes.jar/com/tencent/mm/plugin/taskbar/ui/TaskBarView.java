package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.tencent.mm.autogen.mmdata.rpt.w;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.app.h.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.b;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragRecyclerView;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.a.b;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TaskBarView
  extends RecyclerView
  implements AppBrandDesktopView.b, a.a, d.b, b.a
{
  private RelativeLayout JjC;
  public TaskBarContainer SQO;
  private c SSA;
  public d SSB;
  private final ArrayList<Integer> SSC;
  private boolean SSD;
  private com.tencent.mm.plugin.taskbar.ui.section.weapp.d SSE;
  private com.tencent.mm.plugin.taskbar.ui.section.weapp.a SSF;
  private com.tencent.mm.plugin.taskbar.ui.section.other.a SSG;
  public int SSH;
  private Runnable SSI;
  private boolean SSJ;
  public boolean SSK;
  private boolean SSL;
  private boolean SSM;
  public boolean SSN;
  public boolean SSO;
  public boolean SSP;
  public boolean SSQ;
  public boolean SSR;
  private boolean SSS;
  public int SST;
  public boolean SSU;
  private float SSV;
  private boolean SSW;
  private boolean SSX;
  private final Runnable SSY;
  private final Runnable SSZ;
  private boolean STa;
  private RecyclerView.a bUp;
  private int cag;
  boolean hRD;
  private boolean hXM;
  public boolean isPaused;
  private RecyclerView.l lBe;
  public Context mContext;
  public MMHandler mHandler;
  private Interpolator mInterpolator;
  private int mLastState;
  private int mTouchSlop;
  public int mZT;
  public boolean nAi;
  private float puO;
  private float puP;
  private String uAd;
  private float uAf;
  private boolean uAg;
  private boolean uAh;
  private LinearLayoutManager uQP;
  
  public TaskBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264208);
    this.SSA = new c();
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.SSC = new ArrayList();
    this.uQP = null;
    this.SSD = false;
    this.cag = 0;
    this.uAd = "";
    this.SSH = 0;
    this.SSI = null;
    this.hXM = false;
    this.mZT = 0;
    this.SSJ = false;
    this.SSK = false;
    this.SSL = true;
    this.SSM = false;
    this.SSN = false;
    this.isPaused = false;
    this.nAi = false;
    this.SSO = false;
    this.SSP = false;
    this.SSQ = false;
    this.SSR = false;
    this.SSS = false;
    this.SST = 0;
    this.SSU = false;
    this.hRD = false;
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.puO = 0.0F;
    this.puP = 0.0F;
    this.SSV = 0.0F;
    this.uAf = 0.0F;
    this.uAg = false;
    this.SSW = false;
    this.SSX = false;
    this.uAh = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.SSY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264015);
        if (TaskBarView.d(TaskBarView.this) != null)
        {
          Log.i("MicroMsg.TaskBarView", "checkWeAppSectionData recent: %d", new Object[] { Integer.valueOf(TaskBarView.e(TaskBarView.this).STl.size()) });
          TaskBarView.d(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).STl);
        }
        if (TaskBarView.f(TaskBarView.this) != null)
        {
          Log.i("MicroMsg.TaskBarView", "checkWeAppSectionData my: %d", new Object[] { Integer.valueOf(TaskBarView.e(TaskBarView.this).STm.size()) });
          TaskBarView.f(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).STm);
        }
        AppMethodBeat.o(264015);
      }
    };
    this.SSZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264018);
        Log.i("MicroMsg.TaskBarView", "doReloadData");
        TaskBarView.g(TaskBarView.this);
        if (TaskBarView.this.bYK) {
          TaskBarView.h(TaskBarView.this);
        }
        if (TaskBarView.this.getRecyclerView().Ka())
        {
          Log.i("MicroMsg.TaskBarView", "isComputingLayout not update");
          TaskBarView.a(TaskBarView.this, true);
          AppMethodBeat.o(264018);
          return;
        }
        d locald = TaskBarView.e(TaskBarView.this);
        locald.STt.clear();
        ArrayList localArrayList = new ArrayList((Collection)locald.STl);
        int k = kotlin.k.k.qv(localArrayList.size(), 8);
        if (k > 0) {}
        int j;
        for (int i = 0;; i = j)
        {
          j = i + 1;
          LocalUsageInfo localLocalUsageInfo = ((AppBrandDesktopView.a)localArrayList.get(i)).uAl;
          kotlin.g.b.s.s(localLocalUsageInfo, "dumpWeAppData[i].info");
          locald.a(localLocalUsageInfo, false);
          if (j >= k)
          {
            localArrayList = new ArrayList((Collection)locald.STm);
            k = kotlin.k.k.qv(localArrayList.size(), 8);
            if (k > 0) {}
            for (i = 0;; i = j)
            {
              j = i + 1;
              localLocalUsageInfo = ((AppBrandDesktopView.a)localArrayList.get(i)).uAl;
              kotlin.g.b.s.s(localLocalUsageInfo, "dumpWeAppData[i].info");
              locald.a(localLocalUsageInfo, true);
              if (j >= k)
              {
                TaskBarView.i(TaskBarView.this).bZE.notifyChanged();
                TaskBarView.a(TaskBarView.this, false);
                AppMethodBeat.o(264018);
                return;
              }
            }
          }
        }
      }
    };
    this.mLastState = -1;
    this.STa = false;
    this.lBe = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(264031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
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
          AppMethodBeat.o(264031);
          return;
          label94:
          if ((TaskBarView.s(TaskBarView.this) == 1) || (TaskBarView.s(TaskBarView.this) == 2)) {
            TaskBarView.hDJ();
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(264039);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (TaskBarView.t(TaskBarView.this))
        {
          TaskBarView.u(TaskBarView.this);
          if (TaskBarView.v(TaskBarView.this) != null)
          {
            paramAnonymousInt1 = TaskBarView.w(TaskBarView.this) - TaskBarView.v(TaskBarView.this).Ju();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < TaskBarView.this.getChildCount()))
            {
              paramAnonymousInt1 = TaskBarView.this.getChildAt(paramAnonymousInt1).getTop();
              TaskBarView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(264039);
      }
    };
    ci(paramContext);
    AppMethodBeat.o(264208);
  }
  
  public TaskBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(264215);
    this.SSA = new c();
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.SSC = new ArrayList();
    this.uQP = null;
    this.SSD = false;
    this.cag = 0;
    this.uAd = "";
    this.SSH = 0;
    this.SSI = null;
    this.hXM = false;
    this.mZT = 0;
    this.SSJ = false;
    this.SSK = false;
    this.SSL = true;
    this.SSM = false;
    this.SSN = false;
    this.isPaused = false;
    this.nAi = false;
    this.SSO = false;
    this.SSP = false;
    this.SSQ = false;
    this.SSR = false;
    this.SSS = false;
    this.SST = 0;
    this.SSU = false;
    this.hRD = false;
    this.mTouchSlop = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
    this.puO = 0.0F;
    this.puP = 0.0F;
    this.SSV = 0.0F;
    this.uAf = 0.0F;
    this.uAg = false;
    this.SSW = false;
    this.SSX = false;
    this.uAh = false;
    this.mInterpolator = new DecelerateInterpolator();
    this.SSY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264015);
        if (TaskBarView.d(TaskBarView.this) != null)
        {
          Log.i("MicroMsg.TaskBarView", "checkWeAppSectionData recent: %d", new Object[] { Integer.valueOf(TaskBarView.e(TaskBarView.this).STl.size()) });
          TaskBarView.d(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).STl);
        }
        if (TaskBarView.f(TaskBarView.this) != null)
        {
          Log.i("MicroMsg.TaskBarView", "checkWeAppSectionData my: %d", new Object[] { Integer.valueOf(TaskBarView.e(TaskBarView.this).STm.size()) });
          TaskBarView.f(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).STm);
        }
        AppMethodBeat.o(264015);
      }
    };
    this.SSZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264018);
        Log.i("MicroMsg.TaskBarView", "doReloadData");
        TaskBarView.g(TaskBarView.this);
        if (TaskBarView.this.bYK) {
          TaskBarView.h(TaskBarView.this);
        }
        if (TaskBarView.this.getRecyclerView().Ka())
        {
          Log.i("MicroMsg.TaskBarView", "isComputingLayout not update");
          TaskBarView.a(TaskBarView.this, true);
          AppMethodBeat.o(264018);
          return;
        }
        d locald = TaskBarView.e(TaskBarView.this);
        locald.STt.clear();
        ArrayList localArrayList = new ArrayList((Collection)locald.STl);
        int k = kotlin.k.k.qv(localArrayList.size(), 8);
        if (k > 0) {}
        int j;
        for (int i = 0;; i = j)
        {
          j = i + 1;
          LocalUsageInfo localLocalUsageInfo = ((AppBrandDesktopView.a)localArrayList.get(i)).uAl;
          kotlin.g.b.s.s(localLocalUsageInfo, "dumpWeAppData[i].info");
          locald.a(localLocalUsageInfo, false);
          if (j >= k)
          {
            localArrayList = new ArrayList((Collection)locald.STm);
            k = kotlin.k.k.qv(localArrayList.size(), 8);
            if (k > 0) {}
            for (i = 0;; i = j)
            {
              j = i + 1;
              localLocalUsageInfo = ((AppBrandDesktopView.a)localArrayList.get(i)).uAl;
              kotlin.g.b.s.s(localLocalUsageInfo, "dumpWeAppData[i].info");
              locald.a(localLocalUsageInfo, true);
              if (j >= k)
              {
                TaskBarView.i(TaskBarView.this).bZE.notifyChanged();
                TaskBarView.a(TaskBarView.this, false);
                AppMethodBeat.o(264018);
                return;
              }
            }
          }
        }
      }
    };
    this.mLastState = -1;
    this.STa = false;
    this.lBe = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(264031);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
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
          AppMethodBeat.o(264031);
          return;
          label94:
          if ((TaskBarView.s(TaskBarView.this) == 1) || (TaskBarView.s(TaskBarView.this) == 2)) {
            TaskBarView.hDJ();
          }
        }
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(264039);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (TaskBarView.t(TaskBarView.this))
        {
          TaskBarView.u(TaskBarView.this);
          if (TaskBarView.v(TaskBarView.this) != null)
          {
            paramAnonymousInt1 = TaskBarView.w(TaskBarView.this) - TaskBarView.v(TaskBarView.this).Ju();
            if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt1 < TaskBarView.this.getChildCount()))
            {
              paramAnonymousInt1 = TaskBarView.this.getChildAt(paramAnonymousInt1).getTop();
              TaskBarView.this.scrollBy(0, paramAnonymousInt1);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$11", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(264039);
      }
    };
    ci(paramContext);
    AppMethodBeat.o(264215);
  }
  
  private int aoa(int paramInt)
  {
    AppMethodBeat.i(264296);
    paramInt = this.SSC.indexOf(Integer.valueOf(paramInt));
    AppMethodBeat.o(264296);
    return paramInt;
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(264225);
    this.mContext = paramContext;
    setItemAnimator(this.SSA);
    a(new b((byte)0));
    com.tencent.mm.plugin.appbrand.widget.recent.d.init(this.mContext);
    setVerticalFadingEdgeEnabled(false);
    setNestedScrollingEnabled(true);
    setBackgroundColor(getContext().getResources().getColor(com.tencent.mm.plugin.taskbar.d.a.transparent));
    this.uQP = new LinearLayoutManager()
    {
      public final boolean canScrollVertically()
      {
        AppMethodBeat.i(264033);
        if (!TaskBarView.a(TaskBarView.this))
        {
          AppMethodBeat.o(264033);
          return true;
        }
        AppMethodBeat.o(264033);
        return false;
      }
    };
    setLayoutManager(this.uQP);
    setOverScrollMode(2);
    a(this.lBe);
    this.bUp = new a();
    setAdapter(this.bUp);
    Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView init %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(264225);
  }
  
  private void evQ()
  {
    AppMethodBeat.i(264262);
    this.SSC.clear();
    int j;
    com.tencent.mm.plugin.taskbar.ui.section.d.a locala;
    if (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      j = 1;
      if (j != 0) {
        this.SSC.add(Integer.valueOf(5));
      }
      if (this.SSB.STl.size() <= 0) {
        break label245;
      }
      locala = com.tencent.mm.plugin.taskbar.ui.section.d.SUa;
      if (com.tencent.mm.plugin.taskbar.ui.section.d.a.aog(1)) {
        break label245;
      }
      this.SSC.add(Integer.valueOf(1));
    }
    label245:
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (this.SSB.STm.size() > 0)
      {
        locala = com.tencent.mm.plugin.taskbar.ui.section.d.SUa;
        k = i;
        if (!com.tencent.mm.plugin.taskbar.ui.section.d.a.aog(1))
        {
          k = i + 1;
          this.SSC.add(Integer.valueOf(2));
        }
      }
      if (this.SSB.aob(4).SUc.size() > 0) {
        this.SSC.add(Integer.valueOf(4));
      }
      int m = this.SSC.size();
      if (j != 0) {}
      for (i = 1;; i = 0)
      {
        if ((m - i == k) && ((k == 0) || (hDC()))) {
          this.SSC.add(Integer.valueOf(3));
        }
        Log.i("MicroMsg.TaskBarView", "update section: %s", new Object[] { hDD() });
        AppMethodBeat.o(264262);
        return;
        j = 0;
        break;
      }
    }
  }
  
  private AppBrandDesktopContainerView getDesktopContainer()
  {
    AppMethodBeat.i(264311);
    AppBrandDesktopContainerView localAppBrandDesktopContainerView = this.SQO.getDesktopContainerView();
    AppMethodBeat.o(264311);
    return localAppBrandDesktopContainerView;
  }
  
  private int getEmptyViewTopMargin()
  {
    AppMethodBeat.i(264305);
    boolean bool = hDH();
    int i = com.tencent.mm.cd.a.bs(getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_7_5_A);
    if (bool)
    {
      j = getHeight();
      if (this.SSC.contains(Integer.valueOf(5))) {}
      for (;;)
      {
        i = (j - i) / 3;
        AppMethodBeat.o(264305);
        return i;
        i = 0;
      }
    }
    int j = getHeight();
    if (this.SSC.contains(Integer.valueOf(5))) {
      j -= i;
    }
    for (;;)
    {
      i = j;
      if (this.SSC.contains(Integer.valueOf(1)))
      {
        i = j;
        if (this.SSE != null) {
          i = j - this.SSE.getHeight();
        }
      }
      j = i;
      if (this.SSC.contains(Integer.valueOf(2)))
      {
        j = i;
        if (this.SSF != null) {
          j = i - this.SSF.getHeight();
        }
      }
      i = Math.max(j / 3, com.tencent.mm.cd.a.bs(getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_2A));
      AppMethodBeat.o(264305);
      return i;
    }
  }
  
  private static boolean hDC()
  {
    AppMethodBeat.i(264249);
    boolean bool2 = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgV, false);
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.TaskBarView", "enableOthersWording %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool2) {
        break;
      }
      AppMethodBeat.o(264249);
      return true;
    }
    AppMethodBeat.o(264249);
    return false;
  }
  
  private String hDD()
  {
    AppMethodBeat.i(264270);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.SSC.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((Integer)localIterator.next()).intValue()).append(",");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(264270);
    return localObject;
  }
  
  public static boolean hDE()
  {
    return true;
  }
  
  private void hDG()
  {
    this.SSO = false;
    this.SSP = false;
  }
  
  private boolean hDH()
  {
    AppMethodBeat.i(264292);
    int j = this.SSC.size();
    if (this.SSC.contains(Integer.valueOf(5))) {}
    for (int i = 1; j - i == 1; i = 0)
    {
      AppMethodBeat.o(264292);
      return true;
    }
    AppMethodBeat.o(264292);
    return false;
  }
  
  private boolean hDu()
  {
    return ((this.SSE != null) && (this.SSE.SUQ.uAR)) || ((this.SSF != null) && (this.SSF.SUQ.uAR));
  }
  
  private void hDy()
  {
    AppMethodBeat.i(264241);
    post(this.SSY);
    AppMethodBeat.o(264241);
  }
  
  private void setupMultiTaskScroll(boolean paramBoolean)
  {
    AppMethodBeat.i(264282);
    Log.i("MicroMsg.TaskBarView", "setupMultiTaskScroll %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.multitask.ui.uic.c)com.tencent.mm.ui.component.k.nq(getContext()).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).jr(paramBoolean);
    AppMethodBeat.o(264282);
  }
  
  public final void Eb(int paramInt)
  {
    AppMethodBeat.i(264749);
    this.SQO.aD(0L, paramInt);
    AppMethodBeat.o(264749);
  }
  
  public final void Fl(boolean paramBoolean)
  {
    AppMethodBeat.i(264639);
    Log.i("MicroMsg.TaskBarView", "onStartPull isStart:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.SSJ = true;
      this.SSB.hDS();
      AppMethodBeat.o(264639);
      return;
    }
    this.SSJ = false;
    AppMethodBeat.o(264639);
  }
  
  public final void Fm(boolean paramBoolean)
  {
    this.SSS = paramBoolean;
  }
  
  public final void Fn(boolean paramBoolean)
  {
    this.SSR = paramBoolean;
    this.SSQ = true;
  }
  
  public final void a(final int paramInt, final AppBrandDesktopView.a parama, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(264709);
    Log.i("MicroMsg.TaskBarView", "launchAppBrandWithCheck, %d %s %b %b", new Object[] { Integer.valueOf(paramInt), parama.uAl.nickname, Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.isPaused) });
    if (this.isPaused)
    {
      AppMethodBeat.o(264709);
      return;
    }
    d.a(new d.c()
    {
      public final void cqs()
      {
        int i = 1;
        AppMethodBeat.i(264036);
        Log.i("MicroMsg.TaskBarView", "checkLaunchAppBrand checkOk: %b", new Object[] { Boolean.TRUE });
        TaskBarView.l(TaskBarView.this);
        Object localObject2;
        Object localObject1;
        int k;
        boolean bool1;
        boolean bool2;
        if (paramBoolean1)
        {
          TaskBarView.a(TaskBarView.this, 1104, parama.uAl, paramInt, paramBoolean2);
          localObject2 = TaskBarView.this;
          localObject1 = parama.uAl;
          k = paramInt;
          bool1 = paramBoolean1;
          bool2 = paramBoolean2;
          localObject2 = ((TaskBarView)localObject2).SSB;
          kotlin.g.b.s.u(localObject1, "appItem");
          Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked appId:%s,pos:%d,isMy:%b,desktop:%b", new Object[] { ((LocalUsageInfo)localObject1).appId, Integer.valueOf(k), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          localObject1 = g.gj(((LocalUsageInfo)localObject1).appId, ((LocalUsageInfo)localObject1).euz);
          if (!bool1) {
            break label247;
          }
        }
        label247:
        for (int j = 3;; j = 1)
        {
          ((d)localObject2).STu = j;
          if (!bool2) {}
          for (;;)
          {
            ((d)localObject2).STr.a(j, k, (String)localObject1, i, null);
            AppMethodBeat.o(264036);
            return;
            TaskBarView.a(TaskBarView.this, 1089, parama.uAl, paramInt, paramBoolean2);
            break;
            if (bool1) {
              i = 3;
            } else {
              i = 2;
            }
          }
        }
      }
    });
    AppMethodBeat.o(264709);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(264764);
    if (this.SSB == null)
    {
      AppMethodBeat.o(264764);
      return;
    }
    this.SSB.a(paramInt, paramBoolean1, paramBoolean2, paramString);
    AppMethodBeat.o(264764);
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264814);
    if (this.SSB == null)
    {
      AppMethodBeat.o(264814);
      return;
    }
    this.SSB.a(paramLocalUsageInfo, paramInt1, paramInt2, false);
    AppMethodBeat.o(264814);
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(264796);
    d locald = this.SSB;
    kotlin.g.b.s.u(paramLocalUsageInfo, "appItem");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemManualDeleted appId:%s,pos:%d", new Object[] { paramLocalUsageInfo.appId, Integer.valueOf(paramInt) });
    paramLocalUsageInfo = g.gj(paramLocalUsageInfo.appId, paramLocalUsageInfo.euz);
    if (paramBoolean) {}
    for (paramInt = 3;; paramInt = 1)
    {
      locald.STr.a(2, 7, paramInt, paramLocalUsageInfo, 0, 1, 0, 0);
      AppMethodBeat.o(264796);
      return;
    }
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 1;
    int k = 3;
    AppMethodBeat.i(264780);
    if ((!paramBoolean2) && (this.SSN))
    {
      AppMethodBeat.o(264780);
      return;
    }
    if (paramBoolean2)
    {
      d locald = this.SSB;
      kotlin.g.b.s.u(paramLocalUsageInfo, "appItem");
      String str = g.gj(paramLocalUsageInfo.appId, paramLocalUsageInfo.euz);
      Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear appId:%s,multiTaskId:%s loadMore:%b isMy:%b", new Object[] { paramLocalUsageInfo.appId, str, Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1) {
        i = 3;
      }
      int j;
      if (paramBoolean1)
      {
        j = 3;
        if (!paramBoolean3) {
          break label150;
        }
      }
      for (;;)
      {
        locald.STr.b(k, i, str, j, "");
        AppMethodBeat.o(264780);
        return;
        j = 2;
        break;
        label150:
        k = 2;
      }
    }
    this.SSB.a(paramLocalUsageInfo, paramBoolean1);
    AppMethodBeat.o(264780);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, int paramInt)
  {
    AppMethodBeat.i(264752);
    d locald = this.SSB;
    kotlin.g.b.s.u(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d,pos:%d", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), Integer.valueOf(paramInt) });
    int i = com.tencent.mm.plugin.taskbar.a.a.UG(paramMultiTaskInfo.field_type);
    locald.STu = i;
    locald.STr.a(i, paramInt, paramMultiTaskInfo.field_id, 1, null);
    AppMethodBeat.o(264752);
  }
  
  public final void a(boolean paramBoolean1, LocalUsageInfo paramLocalUsageInfo, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(264809);
    d locald = this.SSB;
    kotlin.g.b.s.u(paramLocalUsageInfo, "appItem");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemManualAddDeleteMyWeApp appId:%s,pos:%d", new Object[] { paramLocalUsageInfo.appId, Integer.valueOf(paramInt1) });
    paramLocalUsageInfo = g.gj(paramLocalUsageInfo.appId, paramLocalUsageInfo.euz);
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
        locald.STr.a(i, j, paramInt1, paramLocalUsageInfo, 0, paramInt2, 0, 0);
        AppMethodBeat.o(264809);
        return;
        i = 2;
      }
    }
  }
  
  public final void anU(int paramInt)
  {
    AppMethodBeat.i(264674);
    md(paramInt, 0);
    AppMethodBeat.o(264674);
  }
  
  public final void anY(final int paramInt)
  {
    AppMethodBeat.i(264619);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264026);
        Log.i("MicroMsg.TaskBarView", "onSectionDeleted %d", new Object[] { Integer.valueOf(paramInt) });
        if ((paramInt == 4) && (!TaskBarView.e(TaskBarView.this).aob(4).SUd.isEmpty()))
        {
          Log.i("MicroMsg.TaskBarView", "showDataList not empty!");
          AppMethodBeat.o(264026);
          return;
        }
        int i = TaskBarView.a(TaskBarView.this, paramInt);
        if (i == -1)
        {
          Log.i("MicroMsg.TaskBarView", "section not found!");
          AppMethodBeat.o(264026);
          return;
        }
        TaskBarView.b(TaskBarView.this).remove(i);
        TaskBarView.this.getAdapter().fX(i);
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
              TaskBarView.this.getAdapter().fV(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(3)));
              AppMethodBeat.o(264026);
              return;
              i = 0;
              break;
            }
            if (TaskBarView.b(TaskBarView.this).size() > i + 1)
            {
              Log.i("MicroMsg.TaskBarView", "other tips show[remove section], mark");
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adgW, Boolean.TRUE);
            }
            TaskBarView.this.getAdapter().fW(TaskBarView.b(TaskBarView.this).size() - 1);
          }
          AppMethodBeat.o(264026);
          return;
        }
      }
    });
    AppMethodBeat.o(264619);
  }
  
  public final void anZ(int paramInt)
  {
    AppMethodBeat.i(264723);
    if ((paramInt == 4) && (aoa(paramInt) != -1) && (this.SSB.aob(4).SUd.isEmpty()))
    {
      Log.i("MicroMsg.TaskBarView", "other last item removed");
      this.SSB.a(this.SSB.aob(4));
      anY(4);
      AppMethodBeat.o(264723);
      return;
    }
    getAdapter().t(aoa(paramInt), Boolean.TRUE);
    AppMethodBeat.o(264723);
  }
  
  public final void bdj(String paramString)
  {
    AppMethodBeat.i(264785);
    if (this.SSB == null)
    {
      AppMethodBeat.o(264785);
      return;
    }
    this.SSB.R(2, 11, paramString);
    AppMethodBeat.o(264785);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264570);
    if (this.SSS)
    {
      AppMethodBeat.o(264570);
      return true;
    }
    boolean bool;
    if (hDu())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(264570);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(264570);
      return bool;
    case 0: 
      this.puO = paramMotionEvent.getRawX();
      this.puP = paramMotionEvent.getRawY();
    }
    for (;;)
    {
      this.SSV = 0.0F;
      this.uAf = 0.0F;
      this.uAg = false;
      this.uAh = false;
      this.SSW = false;
      this.SSX = false;
      break;
      if (this.SSW)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(264570);
        return bool;
      }
      float f2;
      if (!this.SSX)
      {
        float f1 = Math.abs(paramMotionEvent.getRawX() - this.puO);
        f2 = Math.abs(paramMotionEvent.getRawY() - this.puP);
        if (f1 <= this.mTouchSlop) {
          break label359;
        }
        if ((f2 > this.mTouchSlop) && (f2 > f1)) {
          this.SSX = true;
        }
      }
      else
      {
        label232:
        Log.v("MicroMsg.TaskBarView", "alvinluo ActionMove moveUp: %b, mMoveY: %f, touchSlop: %d", new Object[] { Boolean.valueOf(this.uAg), Float.valueOf(this.uAf), Integer.valueOf(this.mTouchSlop) });
        if ((this.uQP == null) || (this.SSC == null)) {
          break label383;
        }
        if (this.uQP.Jx() != this.SSC.size() - 1) {
          break label377;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (!this.uAg))
        {
          if (!this.uAh)
          {
            this.puP = paramMotionEvent.getRawY();
            this.uAf = 0.0F;
            this.uAh = true;
            break;
            this.SSW = true;
            break;
            label359:
            if (f2 <= this.mTouchSlop) {
              break label232;
            }
            this.SSX = true;
            break label232;
            label377:
            i = 0;
            continue;
            label383:
            i = 0;
            continue;
          }
          this.uAf = ((paramMotionEvent.getRawY() - this.puP) * 0.55F);
          if (this.uAf >= 0.0F) {
            break;
          }
          this.uAg = true;
          break;
        }
      }
      if (!this.uAg) {
        break;
      }
      this.uAf = ((paramMotionEvent.getRawY() - this.puP) * 0.55F);
      if (this.uAf > 0.0F)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(264570);
        return bool;
      }
      if (this.uAf < -this.mTouchSlop)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
      }
      int i = (int)Math.abs(this.uAf);
      Log.v("MicroMsg.TaskBarView", "alvinluo moveView: %d", new Object[] { Integer.valueOf(i) });
      setTranslationY(-i);
      AppMethodBeat.o(264570);
      return true;
      if (this.uAg) {
        if ((Math.abs(this.uAf) >= AppBrandDesktopView.uzS) && (this.SQO != null))
        {
          Log.i("MicroMsg.TaskBarView", "alvinluo checkAndClose closeHeader because of pull up bottom");
          this.SQO.aD(0L, 15);
        }
        else
        {
          animate().translationY(0.0F).setDuration(300L).setInterpolator(this.mInterpolator).start();
        }
      }
    }
  }
  
  public final void eia()
  {
    AppMethodBeat.i(264604);
    removeCallbacks(this.SSZ);
    post(this.SSZ);
    AppMethodBeat.o(264604);
  }
  
  public RecyclerView getRecyclerView()
  {
    return this;
  }
  
  public int getTaskBarContainerBottom()
  {
    AppMethodBeat.i(264693);
    int i = getBottom();
    AppMethodBeat.o(264693);
    return i;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public final boolean glK()
  {
    return this.SSK;
  }
  
  public final void hDA()
  {
    AppMethodBeat.i(264607);
    int i = this.SSC.indexOf(Integer.valueOf(4));
    if (i != -1)
    {
      Log.i("MicroMsg.TaskBarView", "do reloadOtherData");
      if (this.SSB.aob(4).SUc.isEmpty())
      {
        evQ();
        this.bUp.fX(i);
        AppMethodBeat.o(264607);
        return;
      }
      this.bUp.fV(i);
    }
    AppMethodBeat.o(264607);
  }
  
  public final void hDB()
  {
    AppMethodBeat.i(264614);
    Log.i("MicroMsg.TaskBarView", "onTeenModeStatusChanged");
    this.SSB.hDU();
    getDesktopContainer().uzD.cPv();
    AppMethodBeat.o(264614);
  }
  
  public final void hDF()
  {
    AppMethodBeat.i(264689);
    if ((this.SQO != null) && (e.aTo()))
    {
      Log.i("MicroMsg.TaskBarView", "alvinluo switchToGradientBackgroundView");
      Object localObject = this.SQO.getParent();
      if ((localObject instanceof View)) {
        ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.taskbar.d.a.transparent));
      }
      localObject = this.SQO.getBackgroundGLSurfaceContainer();
      if (localObject != null)
      {
        ((DynamicBgContainer)localObject).pause();
        this.SSU = true;
      }
    }
    AppMethodBeat.o(264689);
  }
  
  public final void hDI()
  {
    AppMethodBeat.i(264717);
    hDG();
    this.SSQ = false;
    if ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class) != null)
    {
      this.SSN = true;
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).bg(this.mContext, 42);
    }
    a(12, false, false, null);
    AppMethodBeat.o(264717);
  }
  
  public final void hDn()
  {
    AppMethodBeat.i(264654);
    Log.i("MicroMsg.TaskBarView", "[onOpenHeader]");
    if (!this.SSK)
    {
      if ((this.SSC.size() > 1) && (this.SSC.contains(Integer.valueOf(3))))
      {
        Log.i("MicroMsg.TaskBarView", "other tips show[speard], mark");
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgW, Boolean.TRUE);
      }
      if ((hDC()) && (this.SSC.contains(Integer.valueOf(4))) && (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgW, false)))
      {
        Log.i("MicroMsg.TaskBarView", "other tips hide[speard], mark disabled");
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgV, Boolean.TRUE);
      }
      this.SSS = false;
      setupMultiTaskScroll(false);
      Object localObject1 = this.uAd;
      Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acPI, null);
      if ((localObject2 instanceof String)) {
        this.uAd = Util.nullAs((String)localObject2, this.uAd);
      }
      Log.d("MicroMsg.TaskBarView", "alvinluo updateSearchWording last: %s, new: %s", new Object[] { localObject1, this.uAd });
      m.afQ(m.cIz());
      this.SSK = true;
      this.SSL = false;
      this.SSO = true;
      this.SSP = true;
      aj.ipW();
      localObject1 = this.SSB;
      localObject2 = ((d)localObject1).STr;
      ((com.tencent.mm.plugin.taskbar.a.a)localObject2).SQM = (System.currentTimeMillis() / 1000L);
      ((com.tencent.mm.plugin.taskbar.a.a)localObject2).SQN = String.valueOf((int)((com.tencent.mm.plugin.taskbar.a.a)localObject2).SQM);
      ((d)localObject1).teM = System.currentTimeMillis();
      ((d)localObject1).STu = 0;
      Log.i("MicroMsg.TaskBarViewPresenter", "onDidAppear lastStartTime:%d", new Object[] { Long.valueOf(((d)localObject1).teM) });
      ((d)localObject1).Fq(false);
      localObject2 = ((d)localObject1).STt.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        d.d locald = (d.d)((Iterator)localObject2).next();
        MultiTaskInfo localMultiTaskInfo = locald.LIj;
        if (localMultiTaskInfo != null) {
          ((PluginTaskBar)com.tencent.mm.kernel.h.az(PluginTaskBar.class)).notifyExposeTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
        }
        Log.i("MicroMsg.TaskBarViewPresenter", "do reportFirstFeedShow " + locald.vWA + ' ' + locald.pageType + ' ' + locald.STA);
        ((d)localObject1).STr.b(locald.STA, locald.pageType, locald.vWA, 1, null);
      }
      ((d)localObject1).STt.clear();
      com.tencent.mm.plugin.appbrand.appusage.i.ciJ().a(Util.nowMilliSecond(), true, null, 6, 0);
      com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euv, ab.tTK);
      com.tencent.mm.plugin.appbrand.task.i.cJV().a(LuggageServiceType.euw, ab.tTK);
      com.tencent.mm.plugin.appbrand.s.publish();
      com.tencent.mm.plugin.appbrand.app.h.a(h.b.qCc);
      if (this.SSB != null)
      {
        this.SSB.D(this.SSE, false);
        this.SSB.D(this.SSF, true);
      }
    }
    setLayoutFrozen(false);
    AppMethodBeat.o(264654);
  }
  
  public final void hDo()
  {
    AppMethodBeat.i(264682);
    hDn();
    AppMethodBeat.o(264682);
  }
  
  public final void hDv()
  {
    AppMethodBeat.i(264581);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264014);
        com.tencent.mm.plugin.taskbar.ui.section.other.a locala;
        Object localObject;
        int i;
        int j;
        label144:
        if ((TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(4))) && (TaskBarView.c(TaskBarView.this) != null))
        {
          locala = TaskBarView.c(TaskBarView.this);
          localObject = locala.getViewModel().SUd.iterator();
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
            Iterator localIterator = ((Iterable)locala.getViewModel().SUc).iterator();
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
            locala.getViewModel().SUd.set(i, localObject);
          }
          locala.SUj.fV(i);
          AppMethodBeat.o(264014);
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
    AppMethodBeat.o(264581);
  }
  
  public final void hDw()
  {
    AppMethodBeat.i(264586);
    Log.i("MicroMsg.TaskBarView", "onDataUpdated");
    this.SSM = true;
    hDx();
    AppMethodBeat.o(264586);
  }
  
  public final void hDx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(264594);
    hDy();
    boolean bool3 = this.SSN;
    boolean bool4 = this.nAi;
    boolean bool5 = this.SSM;
    boolean bool6 = this.SSL;
    boolean bool1;
    boolean bool7;
    if (!this.isPaused)
    {
      bool1 = true;
      bool7 = this.SSB.hDP();
      if (this.SSJ) {
        break label203;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TaskBarView", "reloadDataIfNeed isInSecondaryPage[%b],isStopped[%b] | shouldReloadOnAppear[%b] isHeaderDidClose[%b] !isPaused[%b] isOnMainTab[%b] !isHeaderStartOpen[%b]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool2) });
      if ((this.SSN) || ((this.nAi) && (!this.SSL)) || ((this.SSM) && (this.SSL) && (!this.isPaused) && (this.SSB.hDP()) && (!this.SSJ))) {
        eia();
      }
      AppMethodBeat.o(264594);
      return;
      bool1 = false;
      break;
      label203:
      bool2 = false;
    }
  }
  
  public final void hDz()
  {
    AppMethodBeat.i(264598);
    Log.i("MicroMsg.TaskBarView", "forceReloadData");
    eia();
    AppMethodBeat.o(264598);
  }
  
  public final void lo(boolean paramBoolean)
  {
    AppMethodBeat.i(264755);
    this.SSN = false;
    this.SQO.SSe.setImportantForAccessibility(2);
    if (paramBoolean) {
      this.SSB.Fq(true);
    }
    AppMethodBeat.o(264755);
  }
  
  public final void md(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264667);
    Log.i("MicroMsg.TaskBarView", "[onCloseHeader] reason: %d duration:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    int i;
    int j;
    if (this.SSK)
    {
      this.SSN = false;
      this.SSK = false;
      this.SSJ = false;
      this.SSS = false;
      localObject1 = this.SSB;
      boolean bool = getDesktopContainer().cPi();
      Object localObject2 = getDesktopContainer().uzD.getViewModel();
      if ((localObject2 == null) || (((com.tencent.mm.plugin.appbrand.widget.desktop.c)localObject2).cPD() != 2)) {
        break label543;
      }
      i = 1;
      Log.i("MicroMsg.TaskBarViewPresenter", "onDidClose reason:%d", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      default: 
        j = 1;
        label155:
        l = System.currentTimeMillis();
        ((d)localObject1).STs += l - ((d)localObject1).teM;
        if (!bool)
        {
          i = 1;
          label186:
          Log.i("MicroMsg.TaskBarViewPresenter", "reportTaskBarClose viewDuration:%d,lastStartTime:%d,currentTime:%d,closeType:%d,reportTime:%d,page:%d", new Object[] { Long.valueOf(((d)localObject1).STs), Long.valueOf(((d)localObject1).teM), Long.valueOf(l), Integer.valueOf(((d)localObject1).STu), Integer.valueOf((int)(((d)localObject1).STs / 1000L)), Integer.valueOf(i) });
          localObject2 = ((d)localObject1).STr;
          int k = (int)(((d)localObject1).STs / 1000L);
          int m = ((d)localObject1).STu;
          w localw = new w();
          localw.imd = localw.F("session_id", ((com.tencent.mm.plugin.taskbar.a.a)localObject2).SQN, true);
          localw.ime = j;
          localw.imv = k;
          localw.imr = m;
          localw.imq = i;
          localw.bMH();
          ((d)localObject1).STs = 0L;
          ((d)localObject1).teM = 0L;
          if (this.SSE != null) {
            this.SSE.Fs(getDesktopContainer().cPi());
          }
          if (this.SSF != null) {
            this.SSF.Fs(getDesktopContainer().cPi());
          }
          this.SSO = false;
          this.SSP = false;
          this.SSB.hDU();
          localObject1 = new TaskBarView.10(this);
          if (paramInt1 != 15) {
            break label568;
          }
        }
        break;
      }
    }
    label543:
    label568:
    for (long l = paramInt2;; l = 0L)
    {
      postDelayed((Runnable)localObject1, l);
      getDesktopContainer().fX(paramInt1, paramInt2);
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264020);
          TaskBarView.j(TaskBarView.this);
          AppMethodBeat.o(264020);
        }
      }, paramInt2);
      this.SQO.SSe.setImportantForAccessibility(2);
      if ((this.SSF != null) && (this.SSF.findViewById(com.tencent.mm.plugin.taskbar.d.d.more_icon) != null))
      {
        localObject1 = (ImageView)this.SSF.findViewById(com.tencent.mm.plugin.taskbar.d.d.more_icon);
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      AppMethodBeat.o(264667);
      return;
      i = 0;
      break;
      j = 2;
      break label155;
      if (i != 0)
      {
        i = 3;
        break label186;
      }
      i = 2;
      break label186;
    }
  }
  
  public final void n(MultiTaskInfo paramMultiTaskInfo)
  {
    int j = 0;
    AppMethodBeat.i(264773);
    if (this.SSN)
    {
      AppMethodBeat.o(264773);
      return;
    }
    d locald = this.SSB;
    kotlin.g.b.s.u(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAppear type:%d,multiTaskId:%s", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), paramMultiTaskInfo.field_id });
    int k = com.tencent.mm.plugin.taskbar.a.a.UG(paramMultiTaskInfo.field_type);
    Object localObject = locald.STk;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((d.b)localObject).glK() == true) {
        i = 1;
      }
    }
    if (i != 0)
    {
      locald.STr.b(2, k, paramMultiTaskInfo.field_id, 1, "");
      AppMethodBeat.o(264773);
      return;
    }
    localObject = new d.d();
    ((d.d)localObject).STA = 1;
    ((d.d)localObject).pageType = k;
    ((d.d)localObject).vWA = paramMultiTaskInfo.field_id;
    ((d.d)localObject).LIj = paramMultiTaskInfo;
    locald.STt.add(localObject);
    AppMethodBeat.o(264773);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(264576);
    super.onAttachedToWindow();
    View localView = getRootView();
    if (localView == null)
    {
      AppMethodBeat.o(264576);
      return;
    }
    this.JjC = ((RelativeLayout)localView.findViewById(com.tencent.mm.plugin.taskbar.d.d.main_ui_container));
    AppMethodBeat.o(264576);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264550);
    if (this.SSW)
    {
      AppMethodBeat.o(264550);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(264550);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264629);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.SQO != null) && (this.SSH != this.SQO.getViewHeight()))
    {
      this.SSH = this.SQO.getViewHeight();
      Log.i("MicroMsg.TaskBarView", "alvinluo onMeasure fixedViewHeight: %d, measuredHeight: %d", new Object[] { Integer.valueOf(this.SSH), Integer.valueOf(this.SQO.getMeasuredHeight()) });
    }
    AppMethodBeat.o(264629);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(264543);
    super.onVisibilityChanged(paramView, paramInt);
    Log.d("MicroMsg.TaskBarView", "[onVisibilityChanged] visibility:".concat(String.valueOf(paramInt)));
    if ((paramInt == 8) || (paramInt == 4))
    {
      if ((this.SSQ) && (this.SQO != null))
      {
        this.SQO.aE(100L, this.SST);
        this.SST = 0;
        this.SSQ = false;
      }
      if (this.hXM)
      {
        Log.i("MicroMsg.TaskBarView", "alvinluo onVisibilityChanged needRefresh");
        this.hXM = false;
        if (this.SSI != null) {
          removeCallbacks(this.SSI);
        }
        paramView = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(264030);
            TaskBarView.this.setLayoutFrozen(false);
            AppMethodBeat.o(264030);
          }
        };
        this.SSI = paramView;
        postDelayed(paramView, 1000L);
      }
    }
    AppMethodBeat.o(264543);
  }
  
  public boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(264735);
    try
    {
      if (this.mHandler != null)
      {
        boolean bool = this.mHandler.post(paramRunnable);
        return bool;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(264735);
    }
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(264737);
    try
    {
      if (this.mHandler != null)
      {
        boolean bool = this.mHandler.postDelayed(paramRunnable, paramLong);
        return bool;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(264737);
    }
  }
  
  public boolean removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(264744);
    try
    {
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacks(paramRunnable);
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(264744);
    }
  }
  
  public void setHeaderContainer(TaskBarContainer paramTaskBarContainer)
  {
    AppMethodBeat.i(264532);
    this.SQO = paramTaskBarContainer;
    getDesktopContainer().setCallback(this);
    AppMethodBeat.o(264532);
  }
  
  public final void x(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(264827);
    Object localObject = this.SSB;
    int i;
    int j;
    if (e.aTo())
    {
      i = 1;
      localObject = ((d)localObject).STr;
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
      AppMethodBeat.o(264827);
      return;
      i = 0;
      break;
      j = 0;
      break label34;
      paramInt = 0;
      break label38;
    }
  }
  
  final class a
    extends RecyclerView.a<com.tencent.mm.plugin.taskbar.ui.section.a>
  {
    private TaskBarSectionWeAppRecyclerView.b STh;
    
    a()
    {
      AppMethodBeat.i(264212);
      this.STh = new TaskBarSectionWeAppRecyclerView.b()
      {
        private void Fp(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(264114);
          Log.i("MicroMsg.TaskBarView", "jumpToWeAppList %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          TaskBarView.l(TaskBarView.this);
          TaskBarView.m(TaskBarView.this);
          Object localObject2 = Boolean.FALSE;
          Object localObject1;
          if ((TaskBarView.f(TaskBarView.this) != null) && (!paramAnonymousBoolean))
          {
            ImageView localImageView = (ImageView)TaskBarView.f(TaskBarView.this).findViewById(com.tencent.mm.plugin.taskbar.d.d.more_icon);
            if ((localImageView != null) && (localImageView.getDrawable() != null))
            {
              localObject1 = TaskBarView.f(TaskBarView.this).hEk();
              if ((localObject1 != null) && (((AppBrandDesktopView.a)localObject1).uAl != null))
              {
                localObject1 = ((AppBrandDesktopView.a)localObject1).uAl.appId;
                localObject2 = Boolean.TRUE;
                localImageView.setImageDrawable(null);
              }
            }
          }
          for (;;)
          {
            TaskBarView.n(TaskBarView.this).SSe.setImportantForAccessibility(4);
            TaskBarView.o(TaskBarView.this).H(paramAnonymousBoolean, ((Boolean)localObject2).booleanValue());
            localObject2 = TaskBarView.this;
            if (paramAnonymousBoolean) {}
            for (int i = 2;; i = 11)
            {
              ((TaskBarView)localObject2).a(i, false, false, (String)localObject1);
              AppMethodBeat.o(264114);
              return;
            }
            localObject1 = null;
          }
        }
        
        public final void Fo(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(264175);
          if (TaskBarView.f(TaskBarView.this) != null)
          {
            Object localObject1 = TaskBarView.f(TaskBarView.this);
            if ((((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.getVisibility() == 4) && (paramAnonymousBoolean))
            {
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).aY(-1.0F, -1.0F);
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.setVisibility(0);
              Object localObject2;
              if (!((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUy)
              {
                int i = com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.app_brand_desktop_close_area_height);
                int j = com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.app_brand_desktop_close_area_extra);
                Rect localRect = new Rect();
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUw.getGlobalVisibleRect(localRect);
                localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUw.getLayoutParams();
                if (localObject2 == null)
                {
                  localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                  AppMethodBeat.o(264175);
                  throw ((Throwable)localObject1);
                }
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                if (localRect.bottom + com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_A) <= com.tencent.mm.cd.a.mt(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext()) - (j + i)) {
                  break label294;
                }
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUy = true;
                Log.i("MicroMsg.AppBrandDesktopSectionMyWeAppView", "need adjust mask view height");
                ((RelativeLayout.LayoutParams)localObject2).removeRule(13);
                ((RelativeLayout.LayoutParams)localObject2).addRule(14);
              }
              for (((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.bs(((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_A);; ((RelativeLayout.LayoutParams)localObject2).topMargin = 0)
              {
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.setAlpha(0.0F);
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.clearAnimation();
                ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.animate().alpha(1.0F).setDuration(250L).setListener(null).start();
                AppMethodBeat.o(264175);
                return;
                label294:
                ((RelativeLayout.LayoutParams)localObject2).addRule(13);
                ((RelativeLayout.LayoutParams)localObject2).removeRule(14);
              }
            }
            if ((((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.getVisibility() == 0) && (!paramAnonymousBoolean))
            {
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.clearAnimation();
              ((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1).SUt.animate().alpha(0.0F).setDuration(250L).setListener((Animator.AnimatorListener)new a.b((com.tencent.mm.plugin.taskbar.ui.section.weapp.a)localObject1)).start();
            }
          }
          AppMethodBeat.o(264175);
        }
        
        public final void a(int paramAnonymousInt, AppBrandDesktopView.a paramAnonymousa)
        {
          AppMethodBeat.i(264157);
          Log.i("MicroMsg.TaskBarView", "notifyMyWeAppChanged %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          int i = TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(2));
          if (i != -1) {
            if (TaskBarView.f(TaskBarView.this) != null)
            {
              TaskBarView.f(TaskBarView.this).b(paramAnonymousInt, paramAnonymousa);
              if (!TaskBarView.this.getRecyclerView().Ka()) {
                TaskBarView.i(TaskBarView.this).t(i, Boolean.TRUE);
              }
            }
          }
          for (;;)
          {
            TaskBarView.this.a(true, paramAnonymousa.uAl, paramAnonymousInt, true, 1);
            AppMethodBeat.o(264157);
            return;
            if (!TaskBarView.this.getRecyclerView().Ka())
            {
              if (TaskBarView.e(TaskBarView.this).STm.isEmpty()) {
                TaskBarView.e(TaskBarView.this).STm.add(paramAnonymousa);
              }
              TaskBarView.g(TaskBarView.this);
              TaskBarView.i(TaskBarView.this).fW(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(2)));
            }
          }
        }
        
        public final void a(RecyclerView.v paramAnonymousv, View paramAnonymousView, AppBrandDesktopView.a paramAnonymousa, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(264116);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(264116);
            return;
          }
          TaskBarView.this.a(paramAnonymousv.KJ(), paramAnonymousa, paramAnonymousBoolean, false);
          AppMethodBeat.o(264116);
        }
        
        public final void a(LocalUsageInfo paramAnonymousLocalUsageInfo, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(264202);
          if (TaskBarView.e(TaskBarView.this) == null)
          {
            AppMethodBeat.o(264202);
            return;
          }
          TaskBarView.e(TaskBarView.this).a(paramAnonymousLocalUsageInfo, paramAnonymousInt1, paramAnonymousInt2, true);
          AppMethodBeat.o(264202);
        }
        
        public final void a(AppBrandDesktopView.a paramAnonymousa, int paramAnonymousInt)
        {
          AppMethodBeat.i(264138);
          TaskBarView.e(TaskBarView.this).bV(paramAnonymousInt, false);
          TaskBarView.i(TaskBarView.this).t(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(1)), Boolean.TRUE);
          TaskBarView.this.a(paramAnonymousa.uAl, paramAnonymousInt, false);
          AppMethodBeat.o(264138);
        }
        
        public final boolean aX(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(264184);
          if (TaskBarView.f(TaskBarView.this) != null)
          {
            boolean bool = TaskBarView.f(TaskBarView.this).aY(paramAnonymousFloat1, paramAnonymousFloat2);
            AppMethodBeat.o(264184);
            return bool;
          }
          AppMethodBeat.o(264184);
          return false;
        }
        
        public final void b(AppBrandDesktopView.a paramAnonymousa, int paramAnonymousInt)
        {
          AppMethodBeat.i(264146);
          TaskBarView.e(TaskBarView.this).bV(paramAnonymousInt, true);
          TaskBarView.i(TaskBarView.this).t(TaskBarView.b(TaskBarView.this).indexOf(Integer.valueOf(2)), Boolean.TRUE);
          TaskBarView.this.a(paramAnonymousa.uAl, paramAnonymousInt, true);
          AppMethodBeat.o(264146);
        }
        
        public final void dy(float paramAnonymousFloat) {}
        
        public final void hDK()
        {
          AppMethodBeat.i(264121);
          Fp(false);
          AppMethodBeat.o(264121);
        }
        
        public final void hDL()
        {
          AppMethodBeat.i(264126);
          Fp(true);
          AppMethodBeat.o(264126);
        }
        
        public final View hDM()
        {
          AppMethodBeat.i(264192);
          com.tencent.mm.plugin.taskbar.ui.section.weapp.a locala = TaskBarView.f(TaskBarView.this);
          AppMethodBeat.o(264192);
          return locala;
        }
      };
      bf(true);
      AppMethodBeat.o(264212);
    }
    
    private void a(com.tencent.mm.plugin.taskbar.ui.section.a parama, int paramInt)
    {
      AppMethodBeat.i(264236);
      Log.i("MicroMsg.TaskBarView", "onBind %d %d", new Object[] { Integer.valueOf(parama.caO), Integer.valueOf(paramInt) });
      switch (parama.caO)
      {
      default: 
      case 1: 
      case 2: 
        for (;;)
        {
          localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.b)parama.caK).getViewModel();
          Log.i("MicroMsg.TaskBarSectionViewModel", "update show data oldCount:" + ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).SUd.size() + " new:" + ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).SUc.size());
          ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).SUd.clear();
          ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).SUd.addAll((Collection)((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).SUc);
          ((com.tencent.mm.plugin.taskbar.ui.section.b)parama.caK).notifyDataSetChanged();
          AppMethodBeat.o(264236);
          return;
          TaskBarView.a(TaskBarView.this, (com.tencent.mm.plugin.taskbar.ui.section.weapp.d)parama.caK);
          TaskBarView.d(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).STl);
          Log.i("MicroMsg.TaskBarView", "onBind setWeAppList " + dL(TaskBarView.e(TaskBarView.this).STl));
          continue;
          TaskBarView.a(TaskBarView.this, (com.tencent.mm.plugin.taskbar.ui.section.weapp.a)parama.caK);
          TaskBarView.f(TaskBarView.this).setDataList(TaskBarView.e(TaskBarView.this).STm);
          Log.i("MicroMsg.TaskBarView", "onBind setMyWeAppList " + dL(TaskBarView.e(TaskBarView.this).STm));
        }
      }
      Object localObject2 = (com.tencent.mm.plugin.taskbar.ui.section.c)parama.caK;
      boolean bool = TaskBarView.p(TaskBarView.this);
      Object localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.c)localObject2).wCJ;
      localObject2 = ((com.tencent.mm.plugin.taskbar.ui.section.c)localObject2).getContext();
      if (bool) {}
      for (paramInt = d.g.SQf;; paramInt = d.g.SQi)
      {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.cd.a.bt((Context)localObject2, paramInt));
        break;
      }
    }
    
    private static String dL(List<AppBrandDesktopView.a> paramList)
    {
      AppMethodBeat.i(264220);
      Iterator localIterator = paramList.iterator();
      paramList = "";
      while (localIterator.hasNext())
      {
        AppBrandDesktopView.a locala = (AppBrandDesktopView.a)localIterator.next();
        if (locala.uAl != null) {
          paramList = paramList + locala.uAl.nickname + " ";
        } else {
          paramList = paramList + "info null ";
        }
      }
      AppMethodBeat.o(264220);
      return paramList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(264259);
      int i = TaskBarView.b(TaskBarView.this).size();
      AppMethodBeat.o(264259);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(264244);
      long l = ((Integer)TaskBarView.b(TaskBarView.this).get(paramInt)).intValue();
      AppMethodBeat.o(264244);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(264250);
      paramInt = TaskBarView.b(TaskBarView.this, paramInt);
      AppMethodBeat.o(264250);
      return paramInt;
    }
  }
  
  final class b
    extends RecyclerView.h
  {
    private b() {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(264439);
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRecyclerView = paramRecyclerView.bj(paramView);
      if (paramRecyclerView == null)
      {
        Log.w("MicroMsg.TaskBarView", "null holder");
        AppMethodBeat.o(264439);
        return;
      }
      int i = paramRecyclerView.KJ();
      if ((params.caA) && (i == -1)) {
        i = paramRecyclerView.caM;
      }
      for (;;)
      {
        int j = paramRecyclerView.caO;
        if (i != 0) {
          if (j == 2) {
            if (TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(1))) {
              paramRect.top = com.tencent.mm.cd.a.bs(paramView.getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_A);
            }
          }
        }
        for (;;)
        {
          if (j == 3) {
            paramRect.top = TaskBarView.x(TaskBarView.this);
          }
          if (j == ((Integer)TaskBarView.b(TaskBarView.this).get(TaskBarView.b(TaskBarView.this).size() - 1)).intValue()) {
            paramRect.bottom = com.tencent.mm.cd.a.bs(paramView.getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_5A);
          }
          Log.i("MicroMsg.TaskBarView", "getItemOffsets index:%d sectionType:%d rect:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRect });
          AppMethodBeat.o(264439);
          return;
          paramRect.top = 0;
          continue;
          if (j == 4) {
            if ((TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(2))) || (TaskBarView.b(TaskBarView.this).contains(Integer.valueOf(1)))) {
              paramRect.top = com.tencent.mm.cd.a.bs(paramView.getContext(), com.tencent.mm.plugin.taskbar.d.b.Edge_4A);
            } else {
              paramRect.top = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarView
 * JD-Core Version:    0.7.0.1
 */