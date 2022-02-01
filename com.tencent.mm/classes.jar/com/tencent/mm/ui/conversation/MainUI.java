package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.an.t;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.f.a.nk;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer;
import com.tencent.mm.plugin.taskbar.ui.TaskBarView;
import com.tencent.mm.plugin.taskbar.ui.a.a;
import com.tencent.mm.plugin.taskbar.ui.d.b;
import com.tencent.mm.plugin.taskbar.ui.d.g;
import com.tencent.mm.plugin.taskbar.ui.d.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.ILifecycleEventObserver;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MainUI
  extends AbstractTabChildActivity.AbStractTabFragment
  implements l.a
{
  public MMFragmentActivity Jvc;
  private View MnD;
  private j XAI;
  public ConversationListView XCL;
  private com.tencent.mm.plugin.taskbar.ui.d XCM;
  private View XCN;
  private View XCO;
  private TextView XCP;
  private l XCQ;
  private q XCR;
  private o XCS;
  public com.tencent.mm.plugin.taskbar.api.a XCT;
  private com.tencent.mm.ui.m.a XCU;
  private ILifecycleEventObserver<Object> XCV;
  private ILifecycleEventObserver<Integer> XCW;
  private a XCX;
  private a XCz;
  private boolean fLS;
  private View mrI;
  private int[] wKq;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.XCM = new com.tencent.mm.plugin.taskbar.ui.d();
    this.XCz = new a();
    this.XCQ = new l();
    this.XCR = new q();
    this.XCS = new o();
    this.wKq = new int[2];
    Log.i("MicroMsg.MainUI", "create mainUI");
    this.XCU = new com.tencent.mm.ui.m.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = d.XzX;
          d.GS(paramAnonymousBoolean);
          localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).fLS)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).hWb();
          }
          localObject = d.XzX;
          d.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.XCV = new ILifecycleEventObserver()
    {
      public final void onEventHappen(Object paramAnonymousObject)
      {
        AppMethodBeat.i(289443);
        if (MainUI.b(MainUI.this) != null)
        {
          Log.d("MicroMsg.MainUI", "refresh main ui unread count.");
          MainUI.b(MainUI.this).notifyDataSetChanged();
          LauncherUI.getInstance().VXk.getMainTabUI().hIc();
        }
        AppMethodBeat.o(289443);
      }
    };
    this.XCW = new ILifecycleEventObserver()
    {
      private final long INTERVAL = 3000L;
      private long XDa = 0L;
      private int XDb = -1;
      private int XDc = 0;
    };
    this.mrI = null;
    this.fLS = false;
    AppMethodBeat.o(38633);
  }
  
  private void hWu()
  {
    AppMethodBeat.i(284959);
    if (this.XCL == null)
    {
      AppMethodBeat.o(284959);
      return;
    }
    final boolean bool = this.XCL.getShowHeaderContainer();
    int k = ax.F(getContext(), -1);
    int j = com.tencent.mm.pluginsdk.h.ew(this.XCL.getContext());
    Log.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d, showHeadrContainer: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) });
    Runnable local2 = new Runnable()
    {
      int kQn = 0;
      
      public final void run()
      {
        AppMethodBeat.i(38620);
        if (MainUI.a(MainUI.this) == null)
        {
          AppMethodBeat.o(38620);
          return;
        }
        int j = ax.F(MainUI.this.getContext(), -1);
        int i = com.tencent.mm.pluginsdk.h.ew(MainUI.a(MainUI.this).getContext());
        if ((j <= 0) || (i <= 0)) {
          if (this.kQn < 2)
          {
            Log.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
            MainUI.a(MainUI.this).post(this);
            this.kQn += 1;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.kQn), Integer.valueOf(j) });
          AppMethodBeat.o(38620);
          return;
          Log.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
          break;
          if (j != MainUI.a(MainUI.this).getPaddingTop())
          {
            Log.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(MainUI.a(MainUI.this).getPaddingTop()) });
            MainUI localMainUI = MainUI.this;
            if (bool) {
              i = 0;
            }
            MainUI.a(localMainUI, i, j);
          }
          else
          {
            Log.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", new Object[] { Integer.valueOf(j) });
          }
        }
      }
    };
    if (k <= 0)
    {
      this.XCL.post(local2);
      AppMethodBeat.o(284959);
      return;
    }
    if (bool) {}
    for (int i = 0;; i = j)
    {
      mF(i, k);
      Log.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
      this.XCL.postDelayed(local2, 100L);
      AppMethodBeat.o(284959);
      return;
    }
  }
  
  private void mF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284960);
    Log.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.fLS) });
    ViewGroup.LayoutParams localLayoutParams = this.XCL.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      int i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      Log.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if ((i <= 0) || (this.fLS)) {
        if (this.fLS) {
          break label227;
        }
      }
    }
    label227:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.XCL.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.MnD == null) {
        break label250;
      }
      paramInt1 = this.MnD.getLayoutParams().height;
      Log.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d isInMultiWindowMode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.fLS) });
      if ((paramInt1 > 0) && (!this.fLS)) {
        break label250;
      }
      if (this.fLS) {
        break;
      }
      this.MnD.getLayoutParams().height = paramInt2;
      AppMethodBeat.o(284960);
      return;
    }
    this.MnD.getLayoutParams().height = 0;
    label250:
    AppMethodBeat.o(284960);
  }
  
  public final void aAz()
  {
    AppMethodBeat.i(38655);
    if (this.XAI != null)
    {
      this.XAI.Ent = false;
      this.XAI.hWk();
      LauncherUI.getInstance().VXk.getMainTabUI().hIc();
    }
    AppMethodBeat.o(38655);
  }
  
  public final void atY(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.XAI != null) {
      this.XAI.awV(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final boolean fcH()
  {
    AppMethodBeat.i(284967);
    if (this.XCL != null)
    {
      boolean bool = this.XCL.fcH();
      AppMethodBeat.o(284967);
      return bool;
    }
    AppMethodBeat.o(284967);
    return false;
  }
  
  public int getLayoutId()
  {
    return R.i.dLQ;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(38634);
    com.tencent.mm.kiss.a.b.aIK();
    this.mrI = com.tencent.mm.kiss.a.b.d(getContext(), R.i.dLQ);
    View localView = this.mrI;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public final void gkE()
  {
    AppMethodBeat.i(38653);
    Log.i("MicroMsg.MainUI", "onTabSwitchOut");
    Object localObject;
    if (this.XCL != null)
    {
      localObject = this.XCL;
      ((ConversationListView)localObject).hWf();
      if (((ConversationListView)localObject).XAN != null) {
        ((ConversationListView)localObject).XAN.gjd();
      }
    }
    if (this.XAI != null)
    {
      this.XAI.XBy = false;
      localObject = com.tencent.mm.ui.report.b.XLO;
      com.tencent.mm.ui.report.b.hXL();
    }
    AppMethodBeat.o(38653);
  }
  
  public final void gkF()
  {
    AppMethodBeat.i(38652);
    Log.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    l locall = this.XCQ;
    int i;
    if (locall.iXX == null) {
      i = -1;
    }
    for (;;)
    {
      Log.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(locall.hWr()) });
      if (locall.wakeLock != null) {
        locall.hWp();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      if (this.XAI != null) {
        this.XAI.XBy = true;
      }
      AppMethodBeat.o(38652);
      return;
      if (locall.iXX.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void hFb()
  {
    AppMethodBeat.i(38641);
    Log.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.bS(4, false);
    }
    Log.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    bh.aHJ().setLowPriority();
    Log.i("MicroMsg.MainUI", "main ui init view");
    if (this.XCL != null)
    {
      localObject1 = this.XCz;
      if (((a)localObject1).Xzq != null)
      {
        ((a)localObject1).kM(((a)localObject1).Xzi);
        ((a)localObject1).kM(((a)localObject1).Xzj);
        ((a)localObject1).kM(((a)localObject1).Xzk);
        ((a)localObject1).kM(((a)localObject1).Xzl);
        localObject2 = ((a)localObject1).Xzm.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).Xzq.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.XCP = ((TextView)findViewById(R.h.dFw));
    this.XCL = ((ConversationListView)findViewById(R.h.dLR));
    Object localObject1 = this.XCL;
    Object localObject2 = ((ConversationListView)localObject1).getContext();
    if (((ConversationListView)localObject1).Mnv == null)
    {
      Log.i("MicroMsg.ConversationListView", "do initHeaderContainer");
      ((ConversationListView)localObject1).Mnv = new TaskBarContainer((Context)localObject2);
      ((ConversationListView)localObject1).Mnv.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((ConversationListView)localObject1).XAN = new com.tencent.mm.plugin.taskbar.ui.a((Context)localObject2, (ListView)localObject1, ((ConversationListView)localObject1).Mnv);
      ((ConversationListView)localObject1).XAN.a((a.a)localObject1);
      ((ConversationListView)localObject1).Mnv.setAnimController(((ConversationListView)localObject1).XAN);
      if (((ConversationListView)localObject1).XAL)
      {
        ((ConversationListView)localObject1).XAM = true;
        ((ConversationListView)localObject1).addHeaderView(((ConversationListView)localObject1).Mnv);
      }
    }
    this.MnD = findViewById(R.h.dVD);
    this.XCL.setStatusBarMaskView(this.MnD);
    hWu();
    this.XCN = new DynamicBgContainer(getContext());
    localObject1 = new ViewGroup.LayoutParams(-1, -1);
    ((ViewGroup)this.mrI).addView(this.XCN, 0, (ViewGroup.LayoutParams)localObject1);
    this.XCL.setDrawingCacheEnabled(false);
    this.XCL.setScrollingCacheEnabled(false);
    this.XCO = findViewById(R.h.dqV);
    localObject1 = this.XCL;
    localObject2 = this.XCN;
    Object localObject3 = this.XCO;
    if (((ConversationListView)localObject1).Mnv != null) {
      ((ConversationListView)localObject1).Mnv.a((DynamicBgContainer)localObject2, (GradientColorBackgroundView)localObject3);
    }
    this.XAI = new j(getContext(), this.XCL, new g.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(289512);
        j localj;
        if (MainUI.b(MainUI.this) != null)
        {
          localj = MainUI.b(MainUI.this);
          if ((localj.WtK != null) && (localj.XBt != null) && (!localj.XBt.isEmpty())) {}
        }
        else
        {
          MainUI.a(MainUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(291799);
              try
              {
                LauncherUI.getInstance().VXk.getMainTabUI().hIc();
                MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                {
                  ConversationListView localConversationListView = MainUI.a(MainUI.this);
                  Log.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.MnY) });
                  if (!localConversationListView.MnY)
                  {
                    localConversationListView.GU(false);
                    if (localConversationListView.XAZ != null) {
                      localConversationListView.XAZ.setBackgroundColor(localConversationListView.getContext().getResources().getColor(R.e.BG_2));
                    }
                    if (!ar.isDarkMode()) {
                      break label210;
                    }
                    localConversationListView.mE(localConversationListView.getResources().getColor(R.e.dark_actionbar_color), localConversationListView.getResources().getColor(R.e.actionbar_title_light_color));
                  }
                }
                MainUI.c(MainUI.this).hVT();
                com.tencent.mm.plugin.report.service.g.adb(12);
                AppMethodBeat.o(291799);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.MainUI", localException, "report unread", new Object[0]);
                  continue;
                  label210:
                  localException.mE(localException.getResources().getColor(R.e.normal_actionbar_color), localException.getResources().getColor(R.e.actionbar_title_color));
                }
              }
            }
          });
          AppMethodBeat.o(289512);
          return;
        }
        if (localj.XBu)
        {
          localj.WtK.clear();
          localj.XBu = false;
        }
        for (;;)
        {
          localj.XBt.clear();
          break;
          Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(localj.XBt.size()) });
          Iterator localIterator = localj.XBt.iterator();
          while (localIterator.hasNext()) {
            localj.WtK.remove(localIterator.next());
          }
        }
      }
      
      public final void hFP()
      {
        AppMethodBeat.i(289511);
        com.tencent.mm.plugin.report.service.g.ada(12);
        AppMethodBeat.o(289511);
      }
    });
    bh.beI();
    com.tencent.mm.model.c.bbR().add(this.XAI);
    this.XAI.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(289588);
        int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(289588);
        return i;
      }
    });
    this.XAI.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(273683);
        MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(273683);
      }
    });
    if (com.tencent.mm.compatible.util.d.qX(18))
    {
      com.tencent.mm.blink.b.aqa().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38631);
          MainUI.c(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.d(MainUI.this));
          AppMethodBeat.o(38631);
        }
      });
      localObject1 = this.XCS;
      localObject2 = this.XCL;
      localObject3 = this.XAI;
      ((o)localObject1).Xzq = ((ListView)localObject2);
      ((o)localObject1).XAI = ((j)localObject3);
      ((ListView)localObject2).setOnScrollListener(((o)localObject1).iYA);
      ((j)localObject3).XAc = ((o)localObject1).iYA;
      MMHandlerThread.postToMainThread(new o.2((o)localObject1));
      LauncherUI.getInstance().VXk.getMainTabUI().hIc();
      this.XCL.setAdapter(this.XAI);
      this.XCL.setOnItemClickListener(new g(this.XAI, this.XCL, getActivity()));
      this.XCL.setOnItemLongClickListener(new h(this.XAI, this.XCL, getActivity(), this.wKq));
      this.XCL.setonDispatchTouchEventListener(new MainUI.16(this));
      if (this.XCT != null) {
        this.XCL.setActionBarUpdateCallback(this.XCT);
      }
      if (this.Jvc != null) {
        this.XCL.setActivity(this.Jvc);
      }
      if (this.XCX != null) {
        o(this.XCX.fxt, this.XCX.mCI, this.XCX.XDh);
      }
      this.XCL.setSelection(0);
      if (this.XCL.getTaskBarView() != null)
      {
        localObject1 = this.XCL.getTaskBarView();
        localObject2 = this.XCM;
        Log.i("MicroMsg.TaskBarView", "TaskBarView initPresenter");
        ((TaskBarView)localObject1).Mph = ((com.tencent.mm.plugin.taskbar.ui.d)localObject2);
        kotlin.g.b.p.k(localObject1, "view");
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).MpP = ((d.b)localObject1);
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).cnt();
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).gjU();
        ((d.b)localObject1).gjy();
      }
      localObject1 = this.XCQ;
      localObject2 = getActivity();
      localObject3 = this.XCz;
      Log.i("MicroMsg.InitHelper", "onCreate %s", new Object[] { Integer.valueOf(localObject2.hashCode()) });
      ((l)localObject1).fDf = ((Activity)localObject2);
      ((l)localObject1).XCz = ((a)localObject3);
      ((l)localObject1).XCA = this;
      ((l)localObject1).nLE = new WeakReference(localObject2);
      ((l)localObject1).wakeLock = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      bh.aGY().a(-1, (com.tencent.mm.an.i)localObject1);
      ((l)localObject1).XCw = false;
      EventCenter.instance.addListener(((l)localObject1).XCB);
      EventCenter.instance.addListener(((l)localObject1).XCC);
      localObject2 = new com.tencent.mm.vfs.q(MMApplicationContext.getContext().getFilesDir(), "DBRecoverStarted");
      if (((com.tencent.mm.vfs.q)localObject2).ifE())
      {
        f.Iyx.e("DBRepair", "Last recovery interrupted.", null);
        ((com.tencent.mm.vfs.q)localObject2).cFq();
      }
      ((l)localObject1).XCD = new FLock(u.n(new com.tencent.mm.vfs.q(MMApplicationContext.getContext().getFilesDir(), "MMStarted").getPath(), true), true);
      if (!((l)localObject1).XCD.tryLockWrite()) {
        break label1761;
      }
      ((l)localObject1).XCD.unlock();
      Log.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((l)localObject1).XCD.lockRead();
      localObject1 = this.XCR;
      localObject2 = this.XAI;
      localObject3 = this.XCL;
      FragmentActivity localFragmentActivity = getActivity();
      ((q)localObject1).XAI = ((j)localObject2);
      ((q)localObject1).fDf = localFragmentActivity;
      ((q)localObject1).XCL = ((ConversationListView)localObject3);
      if (((q)localObject1).uCp == null) {
        ((q)localObject1).uCp = new q.3((q)localObject1, new q.1((q)localObject1));
      }
      if (((q)localObject1).XEl == null) {
        ((q)localObject1).XEl = new q.4((q)localObject1);
      }
      if (((q)localObject1).XEm == null) {
        ((q)localObject1).XEm = new q.5((q)localObject1, (ConversationListView)localObject3);
      }
      EventCenter.instance.addListener(((q)localObject1).uCp);
      EventCenter.instance.addListener(((q)localObject1).XEl);
      EventCenter.instance.addListener(((q)localObject1).XEm);
      ((q)localObject1).sJE = new q.6((q)localObject1);
      Looper.myQueue().addIdleHandler(((q)localObject1).sJE);
      ((ConversationListView)localObject3).post(new q.7((q)localObject1));
      localObject1 = com.tencent.mm.ay.q.bmj();
      int i = R.g.chat_img_template;
      Log.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.ay.b)localObject1).lNf + " to " + i);
      ((com.tencent.mm.ay.b)localObject1).lNf = i;
      ((com.tencent.mm.v.b)LifecycleEventCenter.getEvent(com.tencent.mm.v.b.class)).observeInUIThread(thisActivity(), this.XCV);
      ((com.tencent.mm.v.a)LifecycleEventCenter.getEvent(com.tencent.mm.v.a.class)).observeInUIThread(thisActivity(), this.XCW);
      bh.beE();
      bh.beI();
      com.tencent.mm.model.c.bbR().add(i.XBh);
      bh.beI();
      com.tencent.mm.model.c.bbL().add(i.XBh);
      bh.beI();
      com.tencent.mm.model.c.bbL().add(com.tencent.mm.contact.b.jxn);
      bh.beI();
      com.tencent.mm.model.c.bbL().add(this.XAI);
      localObject1 = this.XAI;
      if (((j)localObject1).XAg == null) {
        ((j)localObject1).XAg = new j.3((j)localObject1);
      }
      EventCenter.instance.addListener(((j)localObject1).XAg);
      this.XAI.XBn = new j.b()
      {
        public final void hWn()
        {
          AppMethodBeat.i(224388);
          MainUI.b(MainUI.this).clearCache();
          bh.beI();
          com.tencent.mm.model.c.bbR().add(MainUI.b(MainUI.this));
          bh.beI();
          com.tencent.mm.model.c.bbL().add(MainUI.b(MainUI.this));
          AppMethodBeat.o(224388);
        }
      };
      localObject1 = this.XAI;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).eqe() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).eqe().add(((j)localObject1).Wez);
      }
      l = Util.milliSecondsToNow(l);
      bh.beI();
      Log.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.RAD) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.fLS = LauncherUI.getInstance().isInMultiWindowMode();
        Log.i("MicroMsg.MainUI", "initMultiWindowModeListener %s", new Object[] { Boolean.valueOf(this.fLS) });
      }
      this.XCL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38621);
          if (MainUI.this.thisActivity() != null) {
            MainUI.this.thisActivity().supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(38621);
        }
      }, 200L);
      setOnVisibilityChangedListener(this.XCU);
      AppMethodBeat.o(38641);
      return;
      this.XCz.a(getContext(), this.XCL, this.XCP);
      break;
      label1761:
      Log.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      f.Iyx.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void hFc()
  {
    AppMethodBeat.i(38645);
    Log.i("MicroMsg.MainUI", "onTabResume");
    long l = Util.nowMilliSecond();
    hWv();
    com.tencent.mm.blink.b.aqa().arrange(new MainUI.4(this));
    Log.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
    Object localObject1 = this.XCR;
    if (com.tencent.mm.bj.g.meT != null) {
      com.tencent.mm.bj.g.meT.a((com.tencent.mm.bj.a)localObject1);
    }
    MMHandlerThread.postToMainThread(new q.8((q)localObject1));
    p.lp(((q)localObject1).fDf);
    if ((((q)localObject1).fDf != null) && (((q)localObject1).fDf.getIntent() != null) && (((q)localObject1).fDf.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      MMHandlerThread.postToMainThreadDelayed(new q.9((q)localObject1), 500L);
      ((q)localObject1).fDf.getIntent().putExtra("resend_fail_messages", false);
    }
    Object localObject2 = (LauncherUI)((q)localObject1).fDf;
    if (localObject2 != null) {
      ((LauncherUI)localObject2).getHomeUI().setTitleBarDoubleClickListener(((q)localObject1).XpT);
    }
    if ((IntentUtil.getBooleanExtra(((q)localObject1).fDf.getIntent(), "Main_ListToTop", false)) && (((q)localObject1).XCL != null)) {
      ((q)localObject1).XCL.post(new q.2((q)localObject1));
    }
    IntentUtil.putExtra(((q)localObject1).fDf.getIntent(), "Main_ListToTop", false);
    localObject1 = this.XCQ;
    int i;
    if (((l)localObject1).iXX == null) {
      i = -1;
    }
    for (;;)
    {
      Log.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((l)localObject1).hWr()) });
      ((l)localObject1).hWp();
      MMHandlerThread.postToMainThreadDelayed(new l.7((l)localObject1), 100L);
      if ((bh.aHB()) && (!this.XCQ.hWs()))
      {
        ((com.tencent.mm.v.c)LifecycleEventCenter.getEvent(com.tencent.mm.v.c.class)).publish();
        ((com.tencent.mm.plugin.sport.a.c)LifecycleEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(4));
      }
      if (bh.aHB())
      {
        localObject1 = new nk();
        ((nk)localObject1).fLN.fLO = 3;
        EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.getMainLooper());
      }
      localObject1 = getBounceView();
      if (localObject1 != null)
      {
        ((com.tencent.mm.ui.widget.pulldown.e)localObject1).HO(false);
        ((com.tencent.mm.ui.widget.pulldown.e)localObject1).setEnd2StartBgColor(getContext().getResources().getColor(R.e.BG_2));
        ((com.tencent.mm.ui.widget.pulldown.e)localObject1).a(new com.tencent.mm.ui.widget.pulldown.a()
        {
          public final boolean hWy()
          {
            AppMethodBeat.i(250050);
            View localView = MainUI.a(MainUI.this).getChildAt(MainUI.a(MainUI.this).getChildCount() - 1);
            if ((localView != null) && (localView.getBottom() <= MainUI.a(MainUI.this).getHeight()) && ((MainUI.a(MainUI.this).getLastVisiblePosition() == MainUI.a(MainUI.this).getAdapter().getCount() - 1) || (localView.getId() == R.h.dyB)))
            {
              AppMethodBeat.o(250050);
              return true;
            }
            AppMethodBeat.o(250050);
            return false;
          }
        }, this.XCL);
      }
      w localw = getController();
      if (localw != null)
      {
        i = getActivity().getResources().getColor(R.e.normal_actionbar_color);
        if (localw.VZm != null)
        {
          localObject2 = localw.VZm.findViewById(a.g.top_status_bar);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new View(localw.VZx);
            ((View)localObject1).setId(a.g.top_status_bar);
            localw.VZm.addView((View)localObject1);
            localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject2).width = -1;
            ((FrameLayout.LayoutParams)localObject2).height = ax.F(localw.VZx, -1);
          }
          ((View)localObject1).setBackgroundColor(i);
        }
      }
      AppMethodBeat.o(38645);
      return;
      if (((l)localObject1).iXX.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void hFd()
  {
    AppMethodBeat.i(38646);
    Log.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void hFe()
  {
    AppMethodBeat.i(38647);
    Log.i("MicroMsg.MainUI", "onTabPause");
    if (!ar.hIH())
    {
      com.tencent.mm.blink.b.aqa().arrange(new MainUI.6(this));
      this.XCQ.hFe();
      hideVKB();
      this.XCR.hFe();
      hWw();
    }
    AppMethodBeat.o(38647);
  }
  
  public final void hFf()
  {
    AppMethodBeat.i(38648);
    Log.i("MicroMsg.MainUI", "onTabStop");
    if (ar.hIH())
    {
      com.tencent.mm.blink.b.aqa().arrange(new MainUI.7(this));
      this.XCQ.hFe();
      hideVKB();
      this.XCR.hFe();
      hWw();
    }
    if (this.XCL != null)
    {
      Object localObject = this.XCL;
      if ((((ConversationListView)localObject).XAL) && (((ConversationListView)localObject).Mnv != null))
      {
        localObject = ((ConversationListView)localObject).Mnv;
        if (((TaskBarContainer)localObject).MoG != null)
        {
          localObject = ((TaskBarContainer)localObject).MoG;
          Log.i("MicroMsg.TaskBarView", "onStop");
          ((TaskBarView)localObject).kUD = true;
        }
      }
    }
    AppMethodBeat.o(38648);
  }
  
  public final void hFg()
  {
    AppMethodBeat.i(38649);
    Log.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(bh.aHB()) });
    com.tencent.mm.blink.b.aqa().arrange(new MainUI.8(this));
    Object localObject = this.XCQ;
    ((l)localObject).XCD.unlock();
    bh.aGY().b(-1, (com.tencent.mm.an.i)localObject);
    if (((l)localObject).iXX != null)
    {
      ((l)localObject).iXX.dismiss();
      ((l)localObject).iXX = null;
    }
    EventCenter.instance.removeListener(((l)localObject).XCB);
    EventCenter.instance.removeListener(((l)localObject).XCC);
    localObject = this.XCR;
    if (((q)localObject).uCp != null)
    {
      EventCenter.instance.removeListener(((q)localObject).uCp);
      ((q)localObject).uCp = null;
    }
    EventCenter.instance.removeListener(((q)localObject).XEl);
    EventCenter.instance.removeListener(((q)localObject).XEm);
    if (com.tencent.mm.bj.g.meT != null) {
      com.tencent.mm.bj.g.meT.b((com.tencent.mm.bj.a)localObject);
    }
    if (bh.aHB()) {
      ae.bvC();
    }
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().add(i.XBh);
      bh.beI();
      com.tencent.mm.model.c.bbL().add(i.XBh);
      if (this.XAI != null)
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().remove(this.XAI);
        bh.beI();
        com.tencent.mm.model.c.bbL().remove(this.XAI);
      }
    }
    if (this.XAI != null)
    {
      localObject = this.XAI;
      if (((j)localObject).XAg != null)
      {
        EventCenter.instance.removeListener(((j)localObject).XAg);
        ((j)localObject).XAg = null;
      }
      this.XAI.XBn = null;
      localObject = this.XAI;
      ((j)localObject).XBn = null;
      if (((j)localObject).WtK != null)
      {
        ((j)localObject).WtK.clear();
        ((j)localObject).WtK = null;
      }
      ((com.tencent.mm.ui.g)localObject).Fk(true);
      ((j)localObject).hFC();
      ((j)localObject).XBq.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.eqe() != null)) {
        localb.eqe().remove(((j)localObject).Wez);
      }
      Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.XCU = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(38649);
  }
  
  public final void hFh() {}
  
  public final void hFi()
  {
    AppMethodBeat.i(38650);
    Log.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void hFj()
  {
    AppMethodBeat.i(38651);
    Log.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void hId()
  {
    AppMethodBeat.i(284966);
    if (this.XCL != null) {
      this.XCL.hId();
    }
    AppMethodBeat.o(284966);
  }
  
  public final void hUj()
  {
    AppMethodBeat.i(38639);
    if (this.XAI != null) {
      this.XAI.hUj();
    }
    AppMethodBeat.o(38639);
  }
  
  public final void hWt()
  {
    if (this.XAI != null) {
      this.XAI.Ent = true;
    }
  }
  
  public final void hWv()
  {
    AppMethodBeat.i(38642);
    if (this.XAI != null) {
      this.XAI.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void hWw()
  {
    AppMethodBeat.i(38643);
    if (this.XAI != null) {
      this.XAI.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void hWx()
  {
    AppMethodBeat.i(38657);
    if ((this.XCL != null) && (this.XCL.fcH())) {
      this.XCL.hWd();
    }
    AppMethodBeat.o(38657);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public final void o(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.XCL instanceof ConversationListView))
    {
      this.XCL.o(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.XCX = new a(paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(38638);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38640);
    super.onConfigurationChanged(paramConfiguration);
    this.XCz.hVT();
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null) && (this.fLS != LauncherUI.getInstance().isInMultiWindowMode()))
    {
      this.fLS = LauncherUI.getInstance().isInMultiWindowMode();
      hWu();
    }
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    Log.i("MicroMsg.MainUI", "onDestroy");
    this.XCS.hWJ();
    TaskBarView localTaskBarView;
    if (this.XCL != null)
    {
      localObject1 = this.XCL;
      Log.i("MicroMsg.ConversationListView", "onDestroy");
      if (((ConversationListView)localObject1).Mnv != null)
      {
        localObject2 = ((ConversationListView)localObject1).Mnv;
        Log.i("MicroMsg.AppBrandDesktopContainer", "onDestroy");
        if (((TaskBarContainer)localObject2).MoG != null)
        {
          localTaskBarView = ((TaskBarContainer)localObject2).MoG;
          Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onDestroy %d", new Object[] { Integer.valueOf(localTaskBarView.hashCode()) });
          localTaskBarView.removeCallbacks(localTaskBarView.MpF);
          localTaskBarView.Mph.MpP = null;
        }
      }
    }
    try
    {
      if (localTaskBarView.Mpo != null)
      {
        localTaskBarView.removeCallbacks(localTaskBarView.Mpo);
        localTaskBarView.Mpo = null;
      }
      if (localTaskBarView.Mpp != null)
      {
        localTaskBarView.removeCallbacks(localTaskBarView.Mpp);
        localTaskBarView.Mpp = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TaskBarView", localException, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (((TaskBarContainer)localObject2).Mpb != null) {
      ((TaskBarContainer)localObject2).Mpb.dead();
    }
    if (((TaskBarContainer)localObject2).Mpa != null)
    {
      ((TaskBarContainer)localObject2).removeCallbacks(((TaskBarContainer)localObject2).Mpa);
      ((TaskBarContainer)localObject2).Mpa = null;
    }
    if (((TaskBarContainer)localObject2).MoH != null) {
      ((TaskBarContainer)localObject2).MoH.release();
    }
    if (((ConversationListView)localObject1).XAN != null)
    {
      localObject2 = ((ConversationListView)localObject1).XAN;
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo DesktopAnimController onDestroy");
      if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView != null)
      {
        if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnL != null)
        {
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView.removeCallbacks(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnL);
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnL = null;
        }
        if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnK != null)
        {
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView.removeCallbacks(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnK);
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnK = null;
        }
        if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).Mog != null)
        {
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView.removeCallbacks(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).Mog);
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).Mog = null;
        }
      }
      com.tencent.e.h.ZvG.bDh("AppBrandDesktopPerformanceMonitor");
      com.tencent.mm.plugin.taskbar.ui.b.d.MqG.aEZ();
      com.tencent.mm.plugin.taskbar.ui.b.d.MqG.release();
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).MnO = false;
    }
    if (((ConversationListView)localObject1).XAS != null) {
      ((ConversationListView)localObject1).removeCallbacks(((ConversationListView)localObject1).XAS);
    }
    if (((ConversationListView)localObject1).XAR != null) {
      ((ConversationListView)localObject1).removeCallbacks(((ConversationListView)localObject1).XAR);
    }
    if (((ConversationListView)localObject1).XAQ != null) {
      ((ConversationListView)localObject1).removeCallbacks(((ConversationListView)localObject1).XAQ);
    }
    if (((ConversationListView)localObject1).XAW != null) {
      ((ConversationListView)localObject1).XAW.dead();
    }
    Object localObject1 = this.XCM;
    Log.i("MicroMsg.TaskBarViewPresenter", "onDestroy");
    ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).MpP = null;
    ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).Mqe.dead();
    ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).Mqc.dead();
    Object localObject2 = ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).gjM();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject2).remove(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).Mqa);
    }
    localObject2 = ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).gjN();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject2).remove(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).Mqb);
    }
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).b(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).nCC);
    localObject2 = ((PluginTaskBar)com.tencent.mm.kernel.h.ag(PluginTaskBar.class)).getTaskBarStorage();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.taskbar.h)localObject2).remove(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).Mqd);
    }
    super.onDestroy();
    AppMethodBeat.o(38654);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38656);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((this.XCL != null) && (this.XCL.fcH()))
      {
        this.XCL.i(10L, 11, false);
        AppMethodBeat.o(38656);
        return true;
      }
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(38656);
      return bool;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(38656);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38636);
    Log.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    if (this.XCL != null)
    {
      Object localObject = this.XCL;
      if ((((ConversationListView)localObject).XAL) && (((ConversationListView)localObject).Mnv != null))
      {
        localObject = ((ConversationListView)localObject).Mnv;
        if (((TaskBarContainer)localObject).MoG != null)
        {
          localObject = ((TaskBarContainer)localObject).MoG;
          ((TaskBarView)localObject).isPaused = true;
          Log.i("MicroMsg.TaskBarView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b", new Object[] { Boolean.valueOf(((TaskBarView)localObject).Mpr), Boolean.valueOf(((TaskBarView)localObject).Mpv) });
          if ((((TaskBarView)localObject).Mpr) && (((TaskBarView)localObject).Mpv))
          {
            ((TaskBarView)localObject).Mpw = true;
            ((TaskBarView)localObject).gjF();
          }
          if (((TaskBarView)localObject).Mpy)
          {
            ((TaskBarView)localObject).Mpy = false;
            if (((TaskBarView)localObject).Mnv != null)
            {
              ((TaskBarView)localObject).Mnv.al(1000L, ((TaskBarView)localObject).MpA);
              ((TaskBarView)localObject).MpA = 0;
            }
          }
          localObject = ((TaskBarView)localObject).Mph;
          d.b localb = ((com.tencent.mm.plugin.taskbar.ui.d)localObject).MpP;
          if (localb == null) {
            break label262;
          }
          if (localb.fcH() == true)
          {
            long l = System.currentTimeMillis();
            if (l >= ((com.tencent.mm.plugin.taskbar.ui.d)localObject).pZO) {
              ((com.tencent.mm.plugin.taskbar.ui.d)localObject).MpX += l - ((com.tencent.mm.plugin.taskbar.ui.d)localObject).pZO;
            }
            Log.i("MicroMsg.TaskBarViewPresenter", "onPause lastStartTime:%d,duration:%d,currentTime:%d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject).pZO), Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject).MpX), Long.valueOf(l) });
          }
        }
      }
    }
    AppMethodBeat.o(38636);
    return;
    label262:
    AppMethodBeat.o(38636);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38635);
    Log.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    ConversationListView localConversationListView;
    Object localObject1;
    if (this.XCL != null)
    {
      localConversationListView = this.XCL;
      if ((localConversationListView.XAL) && (localConversationListView.Mnv != null))
      {
        localObject1 = localConversationListView.Mnv;
        ((TaskBarContainer)localObject1).gjs();
        if (((TaskBarContainer)localObject1).MoG != null)
        {
          localObject1 = ((TaskBarContainer)localObject1).MoG;
          Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume");
          ((TaskBarView)localObject1).isPaused = false;
          ((TaskBarView)localObject1).kUD = false;
          ((TaskBarView)localObject1).Mpu = false;
          if (((RecyclerView)localObject1).aki)
          {
            Log.v("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume setLayoutFrozen false");
            ((TaskBarView)localObject1).setLayoutFrozen(false);
          }
          Log.i("MicroMsg.TaskBarView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(((TaskBarView)localObject1).Mpr), Boolean.valueOf(((TaskBarView)localObject1).Mpw), Boolean.valueOf(((TaskBarView)localObject1).Mpx) });
          Object localObject2;
          if ((((TaskBarView)localObject1).Mpr) && (((TaskBarView)localObject1).Mpw))
          {
            if ((com.tencent.mm.plugin.taskbar.e.aAt()) && (((TaskBarView)localObject1).Mnv != null) && (((TaskBarView)localObject1).Mnv.gjt()))
            {
              Log.i("MicroMsg.TaskBarView", "alvinluo switchToDynamicBackgroundView");
              ((View)((TaskBarView)localObject1).Mnv.getParent()).setBackgroundColor(((TaskBarView)localObject1).mContext.getResources().getColor(d.a.transparent));
              localObject2 = ((TaskBarView)localObject1).Mnv.getBackgroundGLSurfaceContainer();
              if ((localObject2 != null) && (((TaskBarView)localObject1).MpB))
              {
                ((DynamicBgContainer)localObject2).resume();
                ((TaskBarView)localObject1).MpB = false;
              }
            }
            ((TaskBarView)localObject1).Mpv = true;
            ((TaskBarView)localObject1).Mpw = true;
          }
          if ((((TaskBarView)localObject1).Mpx) && (((TaskBarView)localObject1).Mnv != null))
          {
            if (((TaskBarView)localObject1).Mpr) {
              ((TaskBarView)localObject1).Mnv.am(0L, ((TaskBarView)localObject1).MpA);
            }
            ((TaskBarView)localObject1).MpA = 0;
            ((TaskBarView)localObject1).Mpx = false;
          }
          if (((TaskBarView)localObject1).Mph != null)
          {
            localObject2 = ((TaskBarView)localObject1).Mph;
            ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).cnt();
            d.b localb = ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).MpP;
            if ((localb != null) && (localb.fcH() == true))
            {
              long l = System.currentTimeMillis();
              if (l >= ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).pZO) {
                ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).pZO = l;
              }
              Log.i("MicroMsg.TaskBarViewPresenter", "onResume lastStartTime:%d,duration:%d,currentTime:%d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject2).pZO), Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject2).MpX), Long.valueOf(l) });
            }
          }
          ((TaskBarView)localObject1).gjw();
        }
      }
      if ((localConversationListView.XAL) && (localConversationListView.XAN != null) && (localConversationListView.XAN.gjg()) && (localConversationListView.Mnv != null) && (localConversationListView.Mnv.getBottom() < com.tencent.mm.ci.a.fromDPToPix(localConversationListView.getContext(), 100)))
      {
        if (!ar.isDarkMode()) {
          break label713;
        }
        localConversationListView.mE(localConversationListView.getResources().getColor(R.e.dark_actionbar_color), localConversationListView.getResources().getColor(R.e.actionbar_title_light_color));
      }
      if ((localConversationListView.XAL) && (localConversationListView.XAN != null))
      {
        localObject1 = localConversationListView.XAN;
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, scrollOffset:%d isCurrentMainUI: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject1).gjg()), Integer.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Mnv.getBottom()), Integer.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Mnv.getHeight()), Integer.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject1).JMP), Boolean.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Moh) });
        ((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Lue = false;
        if ((((com.tencent.mm.plugin.taskbar.ui.a)localObject1).gjg()) && (((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Mnv.getBottom() < ((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Mnv.getHeight()))
        {
          Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume fastCloseHeader");
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject1).i(0L, 0, true);
        }
        if (((com.tencent.mm.plugin.taskbar.ui.a)localObject1).MnY) {
          break label740;
        }
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume enableBottomTabSwitch true");
        ((com.tencent.mm.plugin.taskbar.ui.a)localObject1).zR(true);
      }
    }
    for (;;)
    {
      localConversationListView.cnt();
      localConversationListView.GT(true);
      AppMethodBeat.o(38635);
      return;
      label713:
      localConversationListView.mE(localConversationListView.getResources().getColor(R.e.normal_actionbar_color), localConversationListView.getResources().getColor(R.e.actionbar_title_color));
      break;
      label740:
      if (!((com.tencent.mm.plugin.taskbar.ui.a)localObject1).Moh)
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume not main ui and header open, then close header");
        ((com.tencent.mm.plugin.taskbar.ui.a)localObject1).i(0L, 0, true);
      }
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean XDh;
    boolean fxt;
    boolean mCI;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.fxt = paramBoolean1;
      this.mCI = paramBoolean2;
      this.XDh = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */