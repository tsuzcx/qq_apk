package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
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
import com.tencent.mm.autogen.a.or;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer;
import com.tencent.mm.plugin.taskbar.ui.TaskBarView;
import com.tencent.mm.plugin.taskbar.ui.TaskBarViewPresenter.homeTabChangedListener.1;
import com.tencent.mm.plugin.taskbar.ui.TaskBarViewPresenter.taskBarUpdateEventListener.1;
import com.tencent.mm.plugin.taskbar.ui.a.a;
import com.tencent.mm.plugin.taskbar.ui.d.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.g.a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MainUI
  extends AbstractTabChildActivity.AbStractTabFragment
  implements n.a
{
  private int[] AgN;
  public MMFragmentActivity PIA;
  private View SQW;
  private Runnable aeJU;
  private k afnq;
  public ConversationListView afpp;
  private a afqa;
  private m afqb;
  private com.tencent.mm.plugin.taskbar.ui.d afqn;
  private View afqo;
  private View afqp;
  private TextView afqq;
  private LinearLayout afqr;
  private n afqs;
  private u afqt;
  private s afqu;
  public com.tencent.mm.plugin.taskbar.api.a afqv;
  private com.tencent.mm.ui.m.a afqw;
  private IMvvmObserver<Object> afqx;
  private IMvvmObserver<Integer> afqy;
  private a afqz;
  private boolean hRD;
  private View plc;
  private SharedPreferences sp;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.afqn = new com.tencent.mm.plugin.taskbar.ui.d();
    this.afqa = new a();
    this.afqb = new m();
    this.afqs = new n();
    this.afqt = new u();
    this.afqu = new s();
    this.AgN = new int[2];
    Log.i("MicroMsg.MainUI", "create mainUI");
    this.afqw = new com.tencent.mm.ui.m.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = e.afmD;
          e.MG(paramAnonymousBoolean);
          localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).hRD)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).jzZ();
          }
          localObject = e.afmD;
          e.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.afqx = new IMvvmObserver()
    {
      public final void onChanged(Object paramAnonymousObject)
      {
        AppMethodBeat.i(256612);
        if (MainUI.b(MainUI.this) != null)
        {
          Log.d("MicroMsg.MainUI", "refresh main ui unread count.");
          MainUI.b(MainUI.this).notifyDataSetChanged();
          LauncherUI.getInstance().adBG.getMainTabUI().jkj();
        }
        AppMethodBeat.o(256612);
      }
    };
    this.afqy = new IMvvmObserver()
    {
      private final long INTERVAL = 3000L;
      private long afqD = 0L;
      private int afqE = -1;
      private int afqF = 0;
    };
    this.plc = null;
    this.hRD = false;
    AppMethodBeat.o(38633);
  }
  
  private void jAJ()
  {
    AppMethodBeat.i(256521);
    if (this.afpp == null)
    {
      AppMethodBeat.o(256521);
      return;
    }
    final boolean bool = this.afpp.getShowHeaderContainer();
    int k = bf.I(getContext(), -1);
    int j = com.tencent.mm.pluginsdk.h.fs(this.afpp.getContext());
    Log.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d, showHeadrContainer: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) });
    Runnable local2 = new Runnable()
    {
      int nrQ = 0;
      
      public final void run()
      {
        AppMethodBeat.i(38620);
        if (MainUI.a(MainUI.this) == null)
        {
          AppMethodBeat.o(38620);
          return;
        }
        int j = bf.I(MainUI.this.getContext(), -1);
        int i = com.tencent.mm.pluginsdk.h.fs(MainUI.a(MainUI.this).getContext());
        if ((j <= 0) || (i <= 0)) {
          if (this.nrQ < 2)
          {
            Log.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
            MainUI.a(MainUI.this).post(this);
            this.nrQ += 1;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.nrQ), Integer.valueOf(j) });
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
      this.afpp.post(local2);
      AppMethodBeat.o(256521);
      return;
    }
    if (bool) {}
    for (int i = 0;; i = j)
    {
      oz(i, k);
      Log.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
      this.afpp.postDelayed(local2, 100L);
      AppMethodBeat.o(256521);
      return;
    }
  }
  
  private void oz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256530);
    Log.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.hRD) });
    ViewGroup.LayoutParams localLayoutParams = this.afpp.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      int i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      Log.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if ((i <= 0) || (this.hRD)) {
        if (this.hRD) {
          break label227;
        }
      }
    }
    label227:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.afpp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.SQW == null) {
        break label250;
      }
      paramInt1 = this.SQW.getLayoutParams().height;
      Log.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d isInMultiWindowMode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.hRD) });
      if ((paramInt1 > 0) && (!this.hRD)) {
        break label250;
      }
      if (this.hRD) {
        break;
      }
      this.SQW.getLayoutParams().height = paramInt2;
      AppMethodBeat.o(256530);
      return;
    }
    this.SQW.getLayoutParams().height = 0;
    label250:
    AppMethodBeat.o(256530);
  }
  
  public final void aAq(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.afnq != null) {
      this.afnq.aDC(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final void aTu()
  {
    AppMethodBeat.i(38655);
    if (this.afnq != null)
    {
      this.afnq.Kgb = false;
      this.afnq.jAi();
      LauncherUI.getInstance().adBG.getMainTabUI().jkj();
    }
    AppMethodBeat.o(38655);
  }
  
  public int getLayoutId()
  {
    return R.i.main;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(38634);
    com.tencent.mm.kiss.layout.b.bbG();
    this.plc = com.tencent.mm.kiss.layout.b.d(getContext(), R.i.main);
    View localView = this.plc;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public final boolean glK()
  {
    AppMethodBeat.i(256682);
    if (this.afpp != null)
    {
      boolean bool = this.afpp.glK();
      AppMethodBeat.o(256682);
      return bool;
    }
    AppMethodBeat.o(256682);
    return false;
  }
  
  public final void hFp()
  {
    AppMethodBeat.i(38653);
    Log.i("MicroMsg.MainUI", "onTabSwitchOut");
    Object localObject;
    if (this.afpp != null)
    {
      localObject = this.afpp;
      ((ConversationListView)localObject).jAd();
      if (((ConversationListView)localObject).afnv != null) {
        ((ConversationListView)localObject).afnv.hDd();
      }
    }
    if (this.afnq != null)
    {
      this.afnq.afom = false;
      localObject = com.tencent.mm.ui.report.d.afBU;
      com.tencent.mm.ui.report.d.jCs();
    }
    AppMethodBeat.o(38653);
  }
  
  public final void hFq()
  {
    AppMethodBeat.i(38652);
    Log.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    n localn = this.afqs;
    int i;
    if (localn.lzP == null) {
      i = -1;
    }
    for (;;)
    {
      Log.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localn.jAF()) });
      if (localn.wakeLock != null) {
        localn.jAD();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      if (this.afnq != null) {
        this.afnq.afom = true;
      }
      AppMethodBeat.o(38652);
      return;
      if (localn.lzP.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void jAI()
  {
    if (this.afnq != null) {
      this.afnq.Kgb = true;
    }
  }
  
  public final void jAK()
  {
    AppMethodBeat.i(38642);
    if (this.afnq != null) {
      this.afnq.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void jAL()
  {
    AppMethodBeat.i(38643);
    if (this.afnq != null) {
      this.afnq.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void jAM()
  {
    AppMethodBeat.i(38657);
    if ((this.afpp != null) && (this.afpp.glK())) {
      this.afpp.jAb();
    }
    AppMethodBeat.o(38657);
  }
  
  public final void jhn()
  {
    AppMethodBeat.i(38641);
    Log.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.cD(4, false);
    }
    Log.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    bh.baH().setLowPriority();
    Log.i("MicroMsg.MainUI", "main ui init view");
    if (this.afpp != null)
    {
      localObject1 = this.afqa;
      if (((a)localObject1).aflX != null)
      {
        ((a)localObject1).oe(((a)localObject1).aflP);
        ((a)localObject1).oe(((a)localObject1).aflQ);
        ((a)localObject1).oe(((a)localObject1).aflR);
        ((a)localObject1).oe(((a)localObject1).aflS);
        localObject2 = ((a)localObject1).aflT.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.a.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.a.b)localObject3).getView() != null)) {
            ((a)localObject1).aflX.removeFooterView(((com.tencent.mm.pluginsdk.ui.a.b)localObject3).getView());
          }
        }
      }
      localObject1 = this.afqb.afpq;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(8);
      }
    }
    this.afqq = ((TextView)findViewById(R.h.fGC));
    this.afqr = ((LinearLayout)findViewById(R.h.fNy));
    this.afpp = ((ConversationListView)findViewById(R.h.fNz));
    Object localObject1 = this.afpp;
    ((ConversationListView)localObject1).afnD = getBounceView();
    Object localObject2 = ((ConversationListView)localObject1).getContext();
    if (((ConversationListView)localObject1).SQO == null)
    {
      Log.i("MicroMsg.ConversationListView", "do initHeaderContainer");
      ((ConversationListView)localObject1).SQO = new TaskBarContainer((Context)localObject2);
      ((ConversationListView)localObject1).SQO.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((ConversationListView)localObject1).afnv = new com.tencent.mm.plugin.taskbar.ui.a((Context)localObject2, (ListView)localObject1, ((ConversationListView)localObject1).SQO);
      ((ConversationListView)localObject1).afnv.a((a.a)localObject1);
      ((ConversationListView)localObject1).SQO.setAnimController(((ConversationListView)localObject1).afnv);
      if (((ConversationListView)localObject1).afnt)
      {
        ((ConversationListView)localObject1).afnu = true;
        ((ConversationListView)localObject1).addHeaderView(((ConversationListView)localObject1).SQO);
      }
    }
    this.SQW = findViewById(R.h.fYb);
    this.afpp.setStatusBarMaskView(this.SQW);
    jAJ();
    this.afqo = new DynamicBgContainer(getContext());
    localObject1 = new ViewGroup.LayoutParams(-1, -1);
    ((ViewGroup)this.plc).addView(this.afqo, 0, (ViewGroup.LayoutParams)localObject1);
    this.afpp.setDrawingCacheEnabled(false);
    this.afpp.setScrollingCacheEnabled(false);
    this.afqp = findViewById(R.h.fri);
    localObject1 = this.afpp;
    localObject2 = this.afqo;
    Object localObject3 = this.afqp;
    if (((ConversationListView)localObject1).SQO != null) {
      ((ConversationListView)localObject1).SQO.a((DynamicBgContainer)localObject2, (GradientColorBackgroundView)localObject3);
    }
    this.afnq = new k(getContext(), this.afpp, this.afqb, new g.a()
    {
      public final void bWC()
      {
        AppMethodBeat.i(256598);
        k localk;
        if (MainUI.b(MainUI.this) != null)
        {
          localk = MainUI.b(MainUI.this);
          if ((localk.aebd != null) && (localk.afoh != null) && (!localk.afoh.isEmpty())) {}
        }
        else
        {
          MainUI.a(MainUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256651);
              try
              {
                LauncherUI.getInstance().adBG.getMainTabUI().jkj();
                MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                {
                  ConversationListView localConversationListView = MainUI.a(MainUI.this);
                  Log.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.SRs) });
                  if (!localConversationListView.SRs)
                  {
                    localConversationListView.MI(false);
                    if (localConversationListView.afnL != null) {
                      localConversationListView.afnL.setBackgroundColor(localConversationListView.getContext().getResources().getColor(R.e.BG_2));
                    }
                    if (!aw.isDarkMode()) {
                      break label223;
                    }
                    localConversationListView.oy(localConversationListView.getResources().getColor(R.e.dark_actionbar_color), localConversationListView.getResources().getColor(R.e.actionbar_title_light_color));
                  }
                }
                MainUI.c(MainUI.this).ery();
                MainUI.d(MainUI.this).jAq();
                com.tencent.mm.plugin.report.service.g.ahx(12);
                AppMethodBeat.o(256651);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.MainUI", localException, "report unread", new Object[0]);
                  continue;
                  label223:
                  localException.oy(localException.getResources().getColor(R.e.normal_actionbar_color), localException.getResources().getColor(R.e.actionbar_title_color));
                }
              }
            }
          });
          AppMethodBeat.o(256598);
          return;
        }
        if (localk.afoi)
        {
          localk.aebd.clear();
          localk.afoi = false;
        }
        for (;;)
        {
          localk.afoh.clear();
          break;
          Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(localk.afoh.size()) });
          Iterator localIterator = localk.afoh.iterator();
          while (localIterator.hasNext()) {
            localk.aebd.remove(localIterator.next());
          }
        }
      }
      
      public final void jia()
      {
        AppMethodBeat.i(256592);
        com.tencent.mm.plugin.report.service.g.ahw(12);
        AppMethodBeat.o(256592);
      }
    });
    bh.bCz();
    com.tencent.mm.model.c.bzG().add(this.afnq);
    this.afnq.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(256588);
        int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(256588);
        return i;
      }
    });
    this.afnq.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(256589);
        MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(256589);
      }
    });
    if (com.tencent.mm.compatible.util.d.rd(18)) {
      com.tencent.mm.blink.b.aJY().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38631);
          MainUI.c(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.e(MainUI.this));
          AppMethodBeat.o(38631);
        }
      });
    }
    for (;;)
    {
      this.afqb.a(getContext(), this.afpp, this.afnq, this.afqr);
      localObject1 = this.afqu;
      localObject2 = this.afpp;
      localObject3 = this.afnq;
      Object localObject4 = this.afqb;
      ((s)localObject1).aflX = ((ListView)localObject2);
      ((s)localObject1).afnq = ((k)localObject3);
      ((s)localObject1).afrX = ((m)localObject4);
      ((ListView)localObject2).setOnScrollListener(((s)localObject1).adKd);
      ((k)localObject3).afmK = ((s)localObject1).adKd;
      MMHandlerThread.postToMainThread(new s.2((s)localObject1));
      LauncherUI.getInstance().adBG.getMainTabUI().jkj();
      this.afpp.setAdapter(this.afnq);
      this.afpp.setOnItemClickListener(new h(this.afnq, this.afpp, getActivity()));
      this.afpp.setOnItemLongClickListener(new i(this.afnq, this.afpp, getActivity(), this.AgN));
      this.afpp.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(256597);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(256597);
            return false;
            MainUI.this.hideVKB();
            MainUI.f(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.f(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.afqv != null) {
        this.afpp.setActionBarUpdateCallback(this.afqv);
      }
      if (this.PIA != null) {
        this.afpp.setActivity(this.PIA);
      }
      if (this.afqz != null) {
        s(this.afqz.hBY, this.afqz.pzq, this.afqz.afqK);
      }
      this.afpp.setSelection(0);
      if (this.afpp.getTaskBarView() != null)
      {
        localObject1 = this.afpp.getTaskBarView();
        localObject2 = this.afqn;
        Log.i("MicroMsg.TaskBarView", "TaskBarView initPresenter");
        ((TaskBarView)localObject1).SSB = ((com.tencent.mm.plugin.taskbar.ui.d)localObject2);
        kotlin.g.b.s.u(localObject1, "view");
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).STk = ((d.b)localObject1);
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).cPw();
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject2).hDU();
        ((d.b)localObject1).hDz();
      }
      this.afqs.a(getActivity(), this.afqa, this.afqb, this);
      localObject1 = this.afqt;
      localObject3 = this.afnq;
      localObject2 = this.afpp;
      localObject4 = getActivity();
      ((u)localObject1).afnq = ((k)localObject3);
      ((u)localObject1).hHU = ((Activity)localObject4);
      ((u)localObject1).afpp = ((ConversationListView)localObject2);
      if (((u)localObject1).xKL == null)
      {
        localObject3 = new u.1((u)localObject1);
        ((u)localObject1).xKL = new RefreshHelper.2((u)localObject1, com.tencent.mm.app.f.hfK, (MMHandler)localObject3);
      }
      if (((u)localObject1).afsi == null) {
        ((u)localObject1).afsi = new RefreshHelper.3((u)localObject1, com.tencent.mm.app.f.hfK);
      }
      if (((u)localObject1).afsj == null) {
        ((u)localObject1).afsj = new RefreshHelper.4((u)localObject1, com.tencent.mm.app.f.hfK, (ConversationListView)localObject2);
      }
      ((u)localObject1).xKL.alive();
      ((u)localObject1).afsi.alive();
      ((u)localObject1).afsj.alive();
      ((u)localObject1).fgm = new u.3((u)localObject1);
      Looper.myQueue().addIdleHandler(((u)localObject1).fgm);
      ((ConversationListView)localObject2).post(new u.4((u)localObject1));
      localObject1 = r.bKc();
      int i = R.g.chat_img_template;
      Log.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.modelimage.b)localObject1).oFM + " to " + i);
      ((com.tencent.mm.modelimage.b)localObject1).oFM = i;
      ((com.tencent.mm.u.b)MvvmEventCenter.getEvent(com.tencent.mm.u.b.class)).observeInUIThread(thisActivity(), this.afqx);
      ((com.tencent.mm.u.a)MvvmEventCenter.getEvent(com.tencent.mm.u.a.class)).observeInUIThread(thisActivity(), this.afqy);
      bh.bCv();
      bh.bCz();
      com.tencent.mm.model.c.bzG().add(j.afnT);
      bh.bCz();
      com.tencent.mm.model.c.bzA().add(j.afnT);
      bh.bCz();
      com.tencent.mm.model.c.bzA().add(com.tencent.mm.contact.b.maH);
      bh.bCz();
      com.tencent.mm.model.c.bzA().add(this.afnq);
      localObject1 = this.afnq;
      if (((k)localObject1).afmO == null) {
        ((k)localObject1).afmO = new ConversationWithCacheAdapter.2((k)localObject1, com.tencent.mm.app.f.hfK);
      }
      ((k)localObject1).afmO.alive();
      this.afnq.afnZ = new k.b()
      {
        public final void jAl()
        {
          AppMethodBeat.i(256624);
          MainUI.b(MainUI.this).clearCache();
          bh.bCz();
          com.tencent.mm.model.c.bzG().add(MainUI.b(MainUI.this));
          bh.bCz();
          com.tencent.mm.model.c.bzA().add(MainUI.b(MainUI.this));
          AppMethodBeat.o(256624);
        }
      };
      localObject1 = this.afnq;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).fwy() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).fwy().add(((k)localObject1).adKf);
      }
      l = Util.milliSecondsToNow(l);
      bh.bCz();
      Log.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.hRD = LauncherUI.getInstance().isInMultiWindowMode();
        Log.i("MicroMsg.MainUI", "initMultiWindowModeListener %s", new Object[] { Boolean.valueOf(this.hRD) });
      }
      this.afpp.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(180078);
          if (MainUI.this.thisActivity() != null) {
            MainUI.this.thisActivity().supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(180078);
        }
      }, 200L);
      setOnVisibilityChangedListener(this.afqw);
      AppMethodBeat.o(38641);
      return;
      this.afqa.a(getContext(), this.afpp, this.afqq);
    }
  }
  
  public final void jho()
  {
    AppMethodBeat.i(38645);
    Log.i("MicroMsg.MainUI", "onTabResume");
    long l = Util.nowMilliSecond();
    jAK();
    com.tencent.mm.blink.b.aJY().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256541);
        Object localObject1 = MainUI.c(MainUI.this);
        if (!((a)localObject1).aflZ)
        {
          ((a)localObject1).aflZ = true;
          q.bFp().d((AvatarStorage.a)localObject1);
          bh.bCz();
          com.tencent.mm.model.c.ban().add((MStorageEx.IOnStorageChange)localObject1);
          ((a)localObject1).ery();
        }
        m localm = MainUI.d(MainUI.this);
        if (!localm.aflZ)
        {
          localm.aflZ = true;
          bh.bCz();
          com.tencent.mm.model.c.ban().add((MStorageEx.IOnStorageChange)localm);
          localm.jAq();
          if (m.jdO())
          {
            localObject1 = com.tencent.mm.ui.conversation.fold.b.a.afuo;
            localObject1 = localm.afnq;
            if (localObject1 != null) {
              break label133;
            }
            localObject1 = null;
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.conversation.fold.b.a.a((Collection)localObject1, localm.afpz, localm.jAo() * 100L);
          AppMethodBeat.o(256541);
          return;
          label133:
          localObject1 = ((k)localObject1).jhT();
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = ((HashMap)localObject1).values();
            if (localObject1 == null)
            {
              localObject1 = null;
            }
            else
            {
              Object localObject2 = (Iterable)localObject1;
              localObject1 = (Collection)new ArrayList();
              localObject2 = ((Iterable)localObject2).iterator();
              label241:
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                if (!au.bwB(((bb)localObject3).field_username)) {}
                for (int i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label241;
                  }
                  ((Collection)localObject1).add(localObject3);
                  break;
                }
              }
              localObject1 = (List)localObject1;
            }
          }
        }
      }
    });
    Log.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
    Object localObject1 = this.afqt;
    if (com.tencent.mm.bc.g.oXL != null) {
      com.tencent.mm.bc.g.oXL.a((com.tencent.mm.bc.a)localObject1);
    }
    MMHandlerThread.postToMainThread(new u.5((u)localObject1));
    t.nu(((u)localObject1).hHU);
    if ((((u)localObject1).hHU != null) && (((u)localObject1).hHU.getIntent() != null) && (((u)localObject1).hHU.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      MMHandlerThread.postToMainThreadDelayed(new u.6((u)localObject1), 500L);
      ((u)localObject1).hHU.getIntent().putExtra("resend_fail_messages", false);
    }
    Object localObject2 = (LauncherUI)((u)localObject1).hHU;
    if (localObject2 != null) {
      ((LauncherUI)localObject2).getHomeUI().setTitleBarDoubleClickListener(((u)localObject1).afbw);
    }
    if ((IntentUtil.getBooleanExtra(((u)localObject1).hHU.getIntent(), "Main_ListToTop", false)) && (((u)localObject1).afpp != null)) {
      ((u)localObject1).afpp.post(new u.2((u)localObject1));
    }
    IntentUtil.putExtra(((u)localObject1).hHU.getIntent(), "Main_ListToTop", false);
    localObject1 = this.afqs;
    int i;
    if (((n)localObject1).lzP == null) {
      i = -1;
    }
    for (;;)
    {
      Log.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((n)localObject1).jAF()) });
      ((n)localObject1).jAD();
      MMHandlerThread.postToMainThreadDelayed(new n.5((n)localObject1), 100L);
      if ((bh.baz()) && (!this.afqs.jAG()))
      {
        ((com.tencent.mm.u.c)MvvmEventCenter.getEvent(com.tencent.mm.u.c.class)).publish();
        ((com.tencent.mm.plugin.sport.a.c)MvvmEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(4));
      }
      if (bh.baz())
      {
        localObject1 = new or();
        ((or)localObject1).hRw.hRx = 3;
        ((or)localObject1).asyncPublish(Looper.getMainLooper());
      }
      localObject1 = getBounceView();
      if (localObject1 != null)
      {
        ((com.tencent.mm.ui.widget.pulldown.f)localObject1).NI(false);
        ((com.tencent.mm.ui.widget.pulldown.f)localObject1).setEnd2StartBgColor(getContext().getResources().getColor(R.e.BG_2));
        ((com.tencent.mm.ui.widget.pulldown.f)localObject1).a(new com.tencent.mm.ui.widget.pulldown.a()
        {
          public final boolean aau()
          {
            AppMethodBeat.i(256536);
            View localView = MainUI.a(MainUI.this).getChildAt(MainUI.a(MainUI.this).getChildCount() - 1);
            if ((localView != null) && (localView.getBottom() <= MainUI.a(MainUI.this).getHeight()) && ((MainUI.a(MainUI.this).getLastVisiblePosition() == MainUI.a(MainUI.this).getAdapter().getCount() - 1) || (localView.getId() == R.h.fzl)))
            {
              AppMethodBeat.o(256536);
              return true;
            }
            AppMethodBeat.o(256536);
            return false;
          }
        }, this.afpp);
      }
      y localy = getController();
      if (localy != null)
      {
        i = getActivity().getResources().getColor(R.e.normal_actionbar_color);
        if (localy.adDH != null)
        {
          localObject2 = localy.adDH.findViewById(a.g.top_status_bar);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new View(localy.getContext());
            ((View)localObject1).setId(a.g.top_status_bar);
            localy.adDH.addView((View)localObject1);
            localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject2).width = -1;
            ((FrameLayout.LayoutParams)localObject2).height = bf.I(localy.getContext(), -1);
          }
          ((View)localObject1).setBackgroundColor(i);
        }
      }
      com.tencent.mm.ui.mmfb.sdk.f.jBR();
      AppMethodBeat.o(38645);
      return;
      if (((n)localObject1).lzP.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void jhp()
  {
    AppMethodBeat.i(38646);
    Log.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void jhq()
  {
    AppMethodBeat.i(38647);
    Log.i("MicroMsg.MainUI", "onTabPause");
    if (!aw.jkS())
    {
      com.tencent.mm.blink.b.aJY().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256538);
          MainUI.c(MainUI.this).jhq();
          MainUI.d(MainUI.this).jhq();
          AppMethodBeat.o(256538);
        }
      });
      this.afqs.jhq();
      hideVKB();
      this.afqt.jhq();
      jAL();
    }
    AppMethodBeat.o(38647);
  }
  
  public final void jhr()
  {
    AppMethodBeat.i(38648);
    Log.i("MicroMsg.MainUI", "onTabStop");
    if (aw.jkS())
    {
      com.tencent.mm.blink.b.aJY().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256540);
          MainUI.c(MainUI.this).jhq();
          MainUI.d(MainUI.this).jhq();
          AppMethodBeat.o(256540);
        }
      });
      this.afqs.jhq();
      hideVKB();
      this.afqt.jhq();
      jAL();
    }
    if (this.afpp != null)
    {
      Object localObject = this.afpp;
      if ((((ConversationListView)localObject).afnt) && (((ConversationListView)localObject).SQO != null))
      {
        localObject = ((ConversationListView)localObject).SQO;
        if (((TaskBarContainer)localObject).SRZ != null)
        {
          localObject = ((TaskBarContainer)localObject).SRZ;
          Log.i("MicroMsg.TaskBarView", "onStop");
          ((TaskBarView)localObject).nAi = true;
        }
      }
    }
    AppMethodBeat.o(38648);
  }
  
  public final void jhs()
  {
    AppMethodBeat.i(38649);
    Log.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(bh.baz()) });
    com.tencent.mm.blink.b.aJY().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256620);
        a locala = MainUI.c(MainUI.this);
        Log.i("MicroMsg.BannerHelper", "destroyBanner");
        locala.jhq();
        a.oh(locala.aflP);
        a.oh(locala.aflQ);
        a.oh(locala.aflR);
        a.oh(locala.aflS);
        Iterator localIterator = locala.aflT.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.a.b localb = (com.tencent.mm.pluginsdk.ui.a.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        bh.b(locala.mPf);
        locala.aflV.dead();
        locala.aflW.dead();
        if (bh.baz())
        {
          bh.bCz();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(256620);
      }
    });
    Object localObject1 = this.afqb;
    Log.i("MicroMsg.FolderHelper", "onTabDestroy");
    ((m)localObject1).jhq();
    Object localObject2 = ((m)localObject1).hAo;
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.ui.a.b)localObject2).destroy();
    }
    localObject2 = ((m)localObject1).afpH;
    if (localObject2 != null) {
      ((com.tencent.mm.ui.conversation.fold.a.b)localObject2).reset();
    }
    if (bh.baz())
    {
      bh.bCz();
      com.tencent.mm.model.c.b((com.tencent.mm.model.bd)localObject1);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a((i.a)localObject1);
      bh.bCz();
      com.tencent.mm.model.c.bzG().remove((MStorageEx.IOnStorageChange)localObject1);
    }
    ((m)localObject1).afpI.dead();
    ((m)localObject1).context = null;
    localObject1 = this.afqs;
    try
    {
      ((n)localObject1).afqf.unlock();
      bh.aZW().b(-1, (com.tencent.mm.am.h)localObject1);
      if (((n)localObject1).lzP != null)
      {
        ((n)localObject1).lzP.dismiss();
        ((n)localObject1).lzP = null;
      }
      ((n)localObject1).afqd.dead();
      ((n)localObject1).afqe.dead();
      localObject1 = this.afqt;
      if (((u)localObject1).xKL != null)
      {
        ((u)localObject1).xKL.dead();
        ((u)localObject1).xKL = null;
      }
      ((u)localObject1).afsi.dead();
      ((u)localObject1).afsj.dead();
      if (com.tencent.mm.bc.g.oXL != null) {
        com.tencent.mm.bc.g.oXL.b((com.tencent.mm.bc.a)localObject1);
      }
      if (bh.baz()) {
        com.tencent.mm.platformtools.ab.bTP();
      }
      if (bh.baz())
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().add(j.afnT);
        bh.bCz();
        com.tencent.mm.model.c.bzA().add(j.afnT);
        if (this.afnq != null)
        {
          bh.bCz();
          com.tencent.mm.model.c.bzG().remove(this.afnq);
          bh.bCz();
          com.tencent.mm.model.c.bzA().remove(this.afnq);
        }
      }
      if (this.afnq != null)
      {
        localObject1 = this.afnq;
        if (((k)localObject1).afmO != null)
        {
          ((k)localObject1).afmO.dead();
          ((k)localObject1).afmO = null;
        }
        this.afnq.afnZ = null;
        localObject1 = this.afnq;
        ((k)localObject1).afnZ = null;
        if (((k)localObject1).aebd != null)
        {
          ((k)localObject1).aebd.clear();
          ((k)localObject1).aebd = null;
        }
        ((k)localObject1).afoe.clear();
        ((k)localObject1).afoe = null;
        ((k)localObject1).afof.clear();
        ((k)localObject1).afof = null;
        ((com.tencent.mm.ui.g)localObject1).KV(true);
        ((k)localObject1).jhO();
        k.afoc.clear();
        localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.b.class);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).fwy() != null)) {
          ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).fwy().remove(((k)localObject1).adKf);
        }
        Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
      }
      this.afqw = null;
      setOnVisibilityChangedListener(null);
      AppMethodBeat.o(38649);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.InitHelper", "onTabDestroy, dupDetectLock unlock failed : " + localObject3.getMessage());
      }
    }
  }
  
  public final void jht() {}
  
  public final void jhu()
  {
    AppMethodBeat.i(38650);
    Log.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void jhv()
  {
    AppMethodBeat.i(38651);
    Log.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void jkk()
  {
    AppMethodBeat.i(256677);
    if (this.afpp != null) {
      this.afpp.jkk();
    }
    AppMethodBeat.o(256677);
  }
  
  public final void jxZ()
  {
    AppMethodBeat.i(38639);
    if (this.afnq != null) {
      this.afnq.jxZ();
    }
    AppMethodBeat.o(38639);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38640);
    super.onConfigurationChanged(paramConfiguration);
    this.afqa.ery();
    m localm = this.afqb;
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    localm.cO(aw.bf(localm.context).y, true);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null) && (this.hRD != LauncherUI.getInstance().isInMultiWindowMode()))
    {
      this.hRD = LauncherUI.getInstance().isInMultiWindowMode();
      jAJ();
    }
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    Log.i("MicroMsg.MainUI", "onDestroy");
    this.afqu.jBb();
    Object localObject1;
    Object localObject2;
    TaskBarView localTaskBarView;
    if (this.afpp != null)
    {
      localObject1 = this.afpp;
      Log.i("MicroMsg.ConversationListView", "onDestroy");
      if (((ConversationListView)localObject1).SQO != null)
      {
        localObject2 = ((ConversationListView)localObject1).SQO;
        Log.i("MicroMsg.AppBrandDesktopContainer", "onDestroy");
        if (((TaskBarContainer)localObject2).SRZ != null)
        {
          localTaskBarView = ((TaskBarContainer)localObject2).SRZ;
          Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onDestroy %d", new Object[] { Integer.valueOf(localTaskBarView.hashCode()) });
          localTaskBarView.SSB.STk = null;
        }
      }
    }
    for (;;)
    {
      try {}catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.TaskBarView", localException, "alvinluo onDestroy exception", new Object[0]);
        continue;
      }
      try
      {
        if (localTaskBarView.mHandler != null) {
          localTaskBarView.mHandler.removeCallbacksAndMessages(null);
        }
        localTaskBarView.mHandler = null;
        if (((TaskBarContainer)localObject2).SSv != null) {
          ((TaskBarContainer)localObject2).SSv.dead();
        }
        if (((TaskBarContainer)localObject2).SSu != null)
        {
          ((TaskBarContainer)localObject2).removeCallbacks(((TaskBarContainer)localObject2).SSu);
          ((TaskBarContainer)localObject2).SSu = null;
        }
        if (((TaskBarContainer)localObject2).SSa != null) {
          ((TaskBarContainer)localObject2).SSa.release();
        }
        if (((ConversationListView)localObject1).afnv != null)
        {
          localObject2 = ((ConversationListView)localObject1).afnv;
          Log.i("MicroMsg.TaskBarAnimController", "alvinluo DesktopAnimController onDestroy");
          if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView != null)
          {
            if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRf != null)
            {
              ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView.removeCallbacks(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRf);
              ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRf = null;
            }
            if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRe != null)
            {
              ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView.removeCallbacks(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRe);
              ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRe = null;
            }
            if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRA != null)
            {
              ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).mListView.removeCallbacks(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRA);
              ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRA = null;
            }
          }
          com.tencent.threadpool.h.ahAA.bFQ("AppBrandDesktopPerformanceMonitor");
          com.tencent.mm.plugin.taskbar.ui.b.d.STS.aYb();
          com.tencent.mm.plugin.taskbar.ui.b.d.STS.release();
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRi = false;
        }
        if (((ConversationListView)localObject1).afnC != null) {
          ((ConversationListView)localObject1).removeCallbacks(((ConversationListView)localObject1).afnC);
        }
        if (((ConversationListView)localObject1).afnB != null) {
          ((ConversationListView)localObject1).removeCallbacks(((ConversationListView)localObject1).afnB);
        }
        if (((ConversationListView)localObject1).afnA != null) {
          ((ConversationListView)localObject1).removeCallbacks(((ConversationListView)localObject1).afnA);
        }
        if (((ConversationListView)localObject1).afnI != null) {
          ((ConversationListView)localObject1).afnI.dead();
        }
        localObject1 = this.afqn;
        Log.i("MicroMsg.TaskBarViewPresenter", "onDestroy");
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).STk = null;
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).STz.dead();
        ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).STx.dead();
        localObject2 = ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).hDN();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject2).remove(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).STv);
        }
        localObject2 = ((com.tencent.mm.plugin.taskbar.ui.d)localObject1).hDO();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject2).remove(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).STw);
        }
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).qCv);
        localObject2 = ((PluginTaskBar)com.tencent.mm.kernel.h.az(PluginTaskBar.class)).getTaskBarStorage();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.taskbar.h)localObject2).remove(((com.tencent.mm.plugin.taskbar.ui.d)localObject1).STy);
        }
        super.onDestroy();
        AppMethodBeat.o(38654);
        return;
      }
      finally
      {
        AppMethodBeat.o(38654);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38656);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((this.afpp != null) && (this.afpp.glK()))
      {
        this.afpp.j(10L, 11, false);
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
    Object localObject;
    if (this.afpp != null)
    {
      localObject = this.afpp;
      if ((((ConversationListView)localObject).afnt) && (((ConversationListView)localObject).SQO != null))
      {
        localObject = ((ConversationListView)localObject).SQO;
        if (((TaskBarContainer)localObject).SRZ != null)
        {
          localObject = ((TaskBarContainer)localObject).SRZ;
          ((TaskBarView)localObject).isPaused = true;
          Log.i("MicroMsg.TaskBarView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b", new Object[] { Boolean.valueOf(((TaskBarView)localObject).SSK), Boolean.valueOf(((TaskBarView)localObject).SSO) });
          if ((((TaskBarView)localObject).SSK) && (((TaskBarView)localObject).SSO))
          {
            ((TaskBarView)localObject).SSP = true;
            ((TaskBarView)localObject).hDF();
          }
          if (((TaskBarView)localObject).SSR)
          {
            ((TaskBarView)localObject).SSR = false;
            if (((TaskBarView)localObject).SQO != null)
            {
              ((TaskBarView)localObject).SQO.aD(1000L, ((TaskBarView)localObject).SST);
              ((TaskBarView)localObject).SST = 0;
            }
          }
          localObject = ((TaskBarView)localObject).SSB;
          d.b localb = ((com.tencent.mm.plugin.taskbar.ui.d)localObject).STk;
          if ((localb == null) || (localb.glK() != true)) {
            break label298;
          }
        }
      }
    }
    label298:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        long l = System.currentTimeMillis();
        if (l >= ((com.tencent.mm.plugin.taskbar.ui.d)localObject).teM) {
          ((com.tencent.mm.plugin.taskbar.ui.d)localObject).STs += l - ((com.tencent.mm.plugin.taskbar.ui.d)localObject).teM;
        }
        Log.i("MicroMsg.TaskBarViewPresenter", "onPause lastStartTime:%d,duration:%d,currentTime:%d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject).teM), Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject).STs), Long.valueOf(l) });
      }
      AppMethodBeat.o(38636);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38635);
    Log.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    Object localObject1;
    Object localObject2;
    int i;
    label553:
    label723:
    int k;
    int j;
    if (this.afpp != null)
    {
      localObject1 = this.afpp;
      if ((((ConversationListView)localObject1).afnt) && (((ConversationListView)localObject1).SQO != null))
      {
        localObject2 = ((ConversationListView)localObject1).SQO;
        ((TaskBarContainer)localObject2).hDs();
        if (((TaskBarContainer)localObject2).SRZ != null)
        {
          localObject2 = ((TaskBarContainer)localObject2).SRZ;
          Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume");
          ((TaskBarView)localObject2).isPaused = false;
          ((TaskBarView)localObject2).nAi = false;
          ((TaskBarView)localObject2).SSN = false;
          if (((RecyclerView)localObject2).bYK)
          {
            Log.v("MicroMsg.TaskBarView", "alvinluo TaskBarView onResume setLayoutFrozen false");
            ((TaskBarView)localObject2).setLayoutFrozen(false);
          }
          Log.i("MicroMsg.TaskBarView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(((TaskBarView)localObject2).SSK), Boolean.valueOf(((TaskBarView)localObject2).SSP), Boolean.valueOf(((TaskBarView)localObject2).SSQ) });
          Object localObject3;
          if ((((TaskBarView)localObject2).SSK) && (((TaskBarView)localObject2).SSP))
          {
            if ((com.tencent.mm.plugin.taskbar.e.aTo()) && (((TaskBarView)localObject2).SQO != null) && (((TaskBarView)localObject2).SQO.hDt()))
            {
              Log.i("MicroMsg.TaskBarView", "alvinluo switchToDynamicBackgroundView");
              ((View)((TaskBarView)localObject2).SQO.getParent()).setBackgroundColor(((TaskBarView)localObject2).mContext.getResources().getColor(d.a.transparent));
              localObject3 = ((TaskBarView)localObject2).SQO.getBackgroundGLSurfaceContainer();
              if ((localObject3 != null) && (((TaskBarView)localObject2).SSU))
              {
                ((DynamicBgContainer)localObject3).resume();
                ((TaskBarView)localObject2).SSU = false;
              }
            }
            ((TaskBarView)localObject2).SSO = true;
            ((TaskBarView)localObject2).SSP = true;
          }
          if ((((TaskBarView)localObject2).SSQ) && (((TaskBarView)localObject2).SQO != null))
          {
            if (((TaskBarView)localObject2).SSK) {
              ((TaskBarView)localObject2).SQO.aE(0L, ((TaskBarView)localObject2).SST);
            }
            ((TaskBarView)localObject2).SST = 0;
            ((TaskBarView)localObject2).SSQ = false;
          }
          if (((TaskBarView)localObject2).SSB != null)
          {
            localObject3 = ((TaskBarView)localObject2).SSB;
            ((com.tencent.mm.plugin.taskbar.ui.d)localObject3).cPw();
            d.b localb = ((com.tencent.mm.plugin.taskbar.ui.d)localObject3).STk;
            if ((localb == null) || (localb.glK() != true)) {
              break label937;
            }
            i = 1;
            if (i != 0)
            {
              long l = System.currentTimeMillis();
              if (l >= ((com.tencent.mm.plugin.taskbar.ui.d)localObject3).teM) {
                ((com.tencent.mm.plugin.taskbar.ui.d)localObject3).teM = l;
              }
              Log.i("MicroMsg.TaskBarViewPresenter", "onResume lastStartTime:%d,duration:%d,currentTime:%d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject3).teM), Long.valueOf(((com.tencent.mm.plugin.taskbar.ui.d)localObject3).STs), Long.valueOf(l) });
            }
          }
          ((TaskBarView)localObject2).hDx();
        }
      }
      if ((((ConversationListView)localObject1).afnt) && (((ConversationListView)localObject1).afnv != null) && (((ConversationListView)localObject1).afnv.hDg()) && (((ConversationListView)localObject1).SQO != null) && (((ConversationListView)localObject1).SQO.getBottom() < com.tencent.mm.cd.a.fromDPToPix(((ConversationListView)localObject1).getContext(), 100)))
      {
        if (!aw.isDarkMode()) {
          break label942;
        }
        ((ConversationListView)localObject1).oy(((ConversationListView)localObject1).getResources().getColor(R.e.dark_actionbar_color), ((ConversationListView)localObject1).getResources().getColor(R.e.actionbar_title_light_color));
      }
      if ((((ConversationListView)localObject1).afnt) && (((ConversationListView)localObject1).afnv != null))
      {
        localObject2 = ((ConversationListView)localObject1).afnv;
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, scrollOffset:%d isCurrentMainUI: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).hDg()), Integer.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SQO.getBottom()), Integer.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SQO.getHeight()), Integer.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).Qhp), Boolean.valueOf(((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRB) });
        ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).RXF = false;
        if ((((com.tencent.mm.plugin.taskbar.ui.a)localObject2).hDg()) && (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SQO.getBottom() < ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SQO.getHeight()))
        {
          Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume fastCloseHeader");
          ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).j(0L, 0, true);
        }
        if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRs) {
          break label972;
        }
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume enableBottomTabSwitch true");
        ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).Fi(true);
      }
      ((ConversationListView)localObject1).cPw();
      ((ConversationListView)localObject1).MH(true);
    }
    else
    {
      this.sp = MMApplicationContext.getDefaultPreference();
      if ((this.sp != null) && (this.sp.getBoolean("conversation_box_tip", false)))
      {
        Log.i("MicroMsg.MainUI", "firstInit ConvBox navigation page");
        if (this.afnq != null)
        {
          k = this.afnq.getCount();
          if (k > 0)
          {
            j = this.afpp.getFirstVisiblePosition() - this.afpp.getHeaderViewsCount() + 1;
            if (j >= 0) {
              break label1014;
            }
            j = 0;
          }
        }
      }
    }
    label824:
    label972:
    label1014:
    for (;;)
    {
      i = Math.abs((j + 1) % k);
      if (i != j) {
        if (!au.bwz(((bb)this.afnq.azn(i)).field_username)) {}
      }
      for (;;)
      {
        j = this.afpp.getHeaderViewsCount();
        this.afpp.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38621);
            MainUI.a(MainUI.this).smoothScrollToPositionFromTop(this.afqC, com.tencent.mm.cd.a.fromDPToPix(MainUI.this.getContext(), 120), 900);
            AppMethodBeat.o(38621);
          }
        });
        MMHandlerThread.removeRunnable(this.aeJU);
        localObject1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38622);
            int i = 0;
            while (i < MainUI.a(MainUI.this).getChildCount())
            {
              k.f localf = (k.f)MainUI.a(MainUI.this).getChildAt(i).getTag();
              if ((localf != null) && (au.bwz(localf.username)))
              {
                MainUI.a(MainUI.this).setHighLightChildNew(i);
                AppMethodBeat.o(38622);
                return;
              }
              i += 1;
            }
            AppMethodBeat.o(38622);
          }
        };
        this.aeJU = ((Runnable)localObject1);
        MMHandlerThread.postToMainThreadDelayed((Runnable)localObject1, 1000L);
        this.sp.edit().putBoolean("conversation_box_tip", false).apply();
        AppMethodBeat.o(38635);
        return;
        i = 0;
        break;
        ((ConversationListView)localObject1).oy(((ConversationListView)localObject1).getResources().getColor(R.e.normal_actionbar_color), ((ConversationListView)localObject1).getResources().getColor(R.e.actionbar_title_color));
        break label553;
        if (((com.tencent.mm.plugin.taskbar.ui.a)localObject2).SRB) {
          break label723;
        }
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onResume not main ui and header open, then close header");
        ((com.tencent.mm.plugin.taskbar.ui.a)localObject2).j(0L, 0, true);
        break label723;
        i = (i + 1) % k;
        break label824;
        i = 0;
      }
    }
  }
  
  public final void s(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.afpp instanceof ConversationListView))
    {
      this.afpp.s(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.afqz = new a(paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(38638);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean afqK;
    boolean hBY;
    boolean pzq;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.hBY = paramBoolean1;
      this.pzq = paramBoolean2;
      this.afqK = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */