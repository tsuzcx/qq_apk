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
import android.os.PowerManager.WakeLock;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.lr.a;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class MainUI
  extends AbstractTabChildActivity.AbStractTabFragment
  implements k.a
{
  private i KPs;
  public ConversationListView KSA;
  private View KSB;
  private View KSC;
  private TextView KSD;
  private k KSE;
  private p KSF;
  private n KSG;
  public com.tencent.mm.plugin.appbrand.widget.header.a KSH;
  private com.tencent.mm.ui.i.a KSI;
  private com.tencent.mm.sdk.b.c KSJ;
  com.tencent.mm.sdk.b.c KSK;
  private a KSL;
  private a KSo;
  private boolean dAG;
  private View iFK;
  private View mZH;
  public MMFragmentActivity nbm;
  private int[] rEA;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.KSo = new a();
    this.KSE = new k();
    this.KSF = new p();
    this.KSG = new n();
    this.rEA = new int[2];
    this.KSI = new com.tencent.mm.ui.i.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = d.KOJ;
          d.yE(paramAnonymousBoolean);
          localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).dAG)
          {
            ae.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).fNa();
          }
          localObject = d.KOJ;
          d.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.KSJ = new com.tencent.mm.sdk.b.c() {};
    this.KSK = new com.tencent.mm.sdk.b.c()
    {
      private final long INTERVAL;
      long KSO;
      int KSP;
      int KSQ;
    };
    this.iFK = null;
    this.dAG = false;
    AppMethodBeat.o(38633);
  }
  
  private void afi(int paramInt)
  {
    AppMethodBeat.i(38637);
    ae.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.dAG) });
    ViewGroup.LayoutParams localLayoutParams = this.KSA.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    int i;
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      ae.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i <= 0) || (this.dAG)) {
        if (this.dAG) {
          break label206;
        }
      }
    }
    label206:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.KSA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.mZH == null) {
        break label228;
      }
      i = this.mZH.getLayoutParams().height;
      ae.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i > 0) && (!this.dAG)) {
        break label228;
      }
      if (this.dAG) {
        break;
      }
      this.mZH.getLayoutParams().height = paramInt;
      AppMethodBeat.o(38637);
      return;
    }
    this.mZH.getLayoutParams().height = 0;
    label228:
    AppMethodBeat.o(38637);
  }
  
  public final void act(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.KPs != null) {
      this.KPs.aff(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final void aea()
  {
    AppMethodBeat.i(38655);
    if (this.KPs != null)
    {
      this.KPs.vpK = false;
      this.KPs.fNs();
      LauncherUI.getInstance().Jty.getMainTabUI().fBk();
    }
    AppMethodBeat.o(38655);
  }
  
  public final void fLW()
  {
    AppMethodBeat.i(38639);
    if (this.KPs != null) {
      this.KPs.fLW();
    }
    AppMethodBeat.o(38639);
  }
  
  public final void fNB()
  {
    if (this.KPs != null) {
      this.KPs.vpK = true;
    }
  }
  
  public final void fNC()
  {
    AppMethodBeat.i(38642);
    if (this.KPs != null) {
      this.KPs.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void fND()
  {
    AppMethodBeat.i(38643);
    if (this.KPs != null) {
      this.KPs.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void fNE()
  {
    AppMethodBeat.i(38657);
    if ((this.KSA != null) && (this.KSA.bDr())) {
      this.KSA.fNb();
    }
    AppMethodBeat.o(38657);
  }
  
  public final void fyG()
  {
    AppMethodBeat.i(38641);
    ae.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.bk(4, false);
    }
    ae.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    bc.ajU().foO();
    ae.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.KSA != null)
    {
      localObject1 = this.KSo;
      if (((a)localObject1).KOd != null)
      {
        ((a)localObject1).iO(((a)localObject1).KNV);
        ((a)localObject1).iO(((a)localObject1).KNW);
        ((a)localObject1).iO(((a)localObject1).KNX);
        ((a)localObject1).iO(((a)localObject1).KNY);
        localObject2 = ((a)localObject1).KNZ.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).KOd.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.KSD = ((TextView)findViewById(2131299462));
    this.KSA = ((ConversationListView)findViewById(2131301984));
    this.mZH = findViewById(2131305195);
    this.KSA.setStatusBarMaskView(this.mZH);
    int i;
    int j;
    if (this.KSA != null)
    {
      i = com.tencent.mm.ui.ar.B(getContext(), -1);
      j = com.tencent.mm.pluginsdk.h.dX(this.KSA.getContext());
      ae.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      localObject1 = new Runnable()
      {
        int hiJ = 0;
        
        public final void run()
        {
          AppMethodBeat.i(38620);
          if (MainUI.a(MainUI.this) == null)
          {
            AppMethodBeat.o(38620);
            return;
          }
          int i = com.tencent.mm.ui.ar.B(MainUI.this.getContext(), -1);
          int j = com.tencent.mm.pluginsdk.h.dX(MainUI.a(MainUI.this).getContext());
          if ((i <= 0) || (j <= 0)) {
            if (this.hiJ < 2)
            {
              ae.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
              MainUI.a(MainUI.this).post(this);
              this.hiJ += 1;
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.hiJ), Integer.valueOf(i) });
            AppMethodBeat.o(38620);
            return;
            ae.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
            break;
            if (i != MainUI.a(MainUI.this).getPaddingTop())
            {
              ae.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(MainUI.a(MainUI.this).getPaddingTop()) });
              MainUI.b(MainUI.this, i);
            }
            else
            {
              ae.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", new Object[] { Integer.valueOf(i) });
            }
          }
        }
      };
      if (i <= 0) {
        this.KSA.post((Runnable)localObject1);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      if (localObject1 != null) {
        break label1555;
      }
      ae.e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
      label351:
      this.KSA.setDrawingCacheEnabled(false);
      this.KSA.setScrollingCacheEnabled(false);
      this.KSC = findViewById(2131296700);
      localObject1 = this.KSA;
      localObject2 = this.KSB;
      localObject3 = this.KSC;
      ((ConversationListView)localObject1).KPP = ((View)localObject2);
      if (((ConversationListView)localObject1).mZy != null) {
        ((ConversationListView)localObject1).mZy.g((View)localObject2, (View)localObject3);
      }
      this.KPs = new i(getContext(), this.KSA, new f.a()
      {
        public final void aSR()
        {
          AppMethodBeat.i(188100);
          i locali;
          if (MainUI.b(MainUI.this) != null)
          {
            locali = MainUI.b(MainUI.this);
            if ((locali.JPs != null) && (locali.KRj != null) && (!locali.KRj.isEmpty())) {}
          }
          else
          {
            MainUI.a(MainUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(188098);
                try
                {
                  LauncherUI.getInstance().Jty.getMainTabUI().fBk();
                  MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                  if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                  {
                    ConversationListView localConversationListView = MainUI.a(MainUI.this);
                    ae.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.nad) });
                    if (!localConversationListView.nad)
                    {
                      localConversationListView.yF(false);
                      if (localConversationListView.KPX != null) {
                        localConversationListView.KPX.setBackgroundColor(localConversationListView.getContext().getResources().getColor(2131099650));
                      }
                      if (!al.isDarkMode()) {
                        break label207;
                      }
                      localConversationListView.kc(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
                    }
                  }
                  MainUI.c(MainUI.this).fMS();
                  com.tencent.mm.plugin.report.service.f.OQ(12);
                  AppMethodBeat.o(188098);
                  return;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    ae.printErrStackTrace("MicroMsg.MainUI", localException, "report unread", new Object[0]);
                    continue;
                    label207:
                    localException.kc(localException.getResources().getColor(2131100705), localException.getResources().getColor(2131099885));
                  }
                }
              }
            });
            AppMethodBeat.o(188100);
            return;
          }
          if (locali.KRk)
          {
            locali.JPs.clear();
            locali.KRk = false;
          }
          for (;;)
          {
            locali.KRj.clear();
            break;
            ae.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(locali.KRj.size()) });
            Iterator localIterator = locali.KRj.iterator();
            while (localIterator.hasNext()) {
              locali.JPs.remove(localIterator.next());
            }
          }
        }
        
        public final void fzs()
        {
          AppMethodBeat.i(188099);
          com.tencent.mm.plugin.report.service.f.OP(12);
          AppMethodBeat.o(188099);
        }
      });
      this.KPs.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(188101);
          int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(188101);
          return i;
        }
      });
      this.KPs.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(188102);
          MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(188102);
        }
      });
      if (!com.tencent.mm.compatible.util.d.lC(18)) {
        break label1652;
      }
      com.tencent.mm.blink.b.Wq().u(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38631);
          MainUI.c(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.d(MainUI.this));
          AppMethodBeat.o(38631);
        }
      });
      label502:
      localObject1 = this.KSG;
      localObject2 = this.KSA;
      localObject3 = this.KPs;
      ((n)localObject1).KOd = ((ListView)localObject2);
      ((n)localObject1).KPs = ((i)localObject3);
      ((ListView)localObject2).setOnScrollListener(((n)localObject1).fPf);
      ((i)localObject3).KOM = ((n)localObject1).fPf;
      com.tencent.mm.sdk.platformtools.ar.f(new n.2((n)localObject1));
      LauncherUI.getInstance().Jty.getMainTabUI().fBk();
      this.KSA.setAdapter(this.KPs);
      this.KSA.setOnItemClickListener(new f(this.KPs, this.KSA, getActivity()));
      this.KSA.setOnItemLongClickListener(new g(this.KPs, this.KSA, getActivity(), this.rEA));
      this.KSA.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(188103);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/MainUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/MainUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(188103);
            return false;
            MainUI.this.hideVKB();
            MainUI.e(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.e(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.KSH != null) {
        this.KSA.setActionBarUpdateCallback(this.KSH);
      }
      if (this.nbm != null) {
        this.KSA.setActivity(this.nbm);
      }
      if (this.KSL != null) {
        m(this.KSL.dnq, this.KSL.iOP, this.KSL.KSV);
      }
      this.KSA.setSelection(0);
      localObject1 = this.KSE;
      localObject2 = getActivity();
      localObject3 = this.KSo;
      ((k)localObject1).dtg = ((Activity)localObject2);
      ((k)localObject1).KSo = ((a)localObject3);
      ((k)localObject1).KSp = this;
      ((k)localObject1).jOO = new WeakReference(localObject2);
      ((k)localObject1).wakeLock = ((PowerManager)ak.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      bc.ajj().a(-1, (com.tencent.mm.ak.f)localObject1);
      ((k)localObject1).KSl = false;
      com.tencent.mm.sdk.b.a.IvT.c(((k)localObject1).KSq);
      com.tencent.mm.sdk.b.a.IvT.c(((k)localObject1).KSr);
      localObject2 = new com.tencent.mm.vfs.k(ak.getContext().getFilesDir(), "DBRecoverStarted");
      if (((com.tencent.mm.vfs.k)localObject2).exists())
      {
        com.tencent.mm.plugin.report.e.ywz.g("DBRepair", "Last recovery interrupted.", null);
        ((com.tencent.mm.vfs.k)localObject2).delete();
      }
      ((k)localObject1).KSs = new FLock(com.tencent.mm.vfs.o.k(w.B(new com.tencent.mm.vfs.k(ak.getContext().getFilesDir(), "MMStarted").mUri), true));
      if (!((k)localObject1).KSs.fnW()) {
        break label1674;
      }
      ((k)localObject1).KSs.unlock();
      ae.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((k)localObject1).KSs.lockRead();
      localObject1 = this.KSF;
      localObject2 = this.KPs;
      localObject3 = this.KSA;
      FragmentActivity localFragmentActivity = getActivity();
      ((p)localObject1).KPs = ((i)localObject2);
      ((p)localObject1).dtg = localFragmentActivity;
      ((p)localObject1).KSA = ((ConversationListView)localObject3);
      if (((p)localObject1).pIT == null) {
        ((p)localObject1).pIT = new p.3((p)localObject1, new p.1((p)localObject1));
      }
      if (((p)localObject1).KTT == null) {
        ((p)localObject1).KTT = new p.4((p)localObject1);
      }
      if (((p)localObject1).KTU == null) {
        ((p)localObject1).KTU = new p.5((p)localObject1, (ConversationListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.IvT.c(((p)localObject1).pIT);
      com.tencent.mm.sdk.b.a.IvT.c(((p)localObject1).KTT);
      com.tencent.mm.sdk.b.a.IvT.c(((p)localObject1).KTU);
      ((p)localObject1).omO = new p.6((p)localObject1);
      Looper.myQueue().addIdleHandler(((p)localObject1).omO);
      ((ConversationListView)localObject3).post(new p.7((p)localObject1));
      localObject1 = com.tencent.mm.av.q.aIZ();
      ae.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.av.b)localObject1).ibM + " to 2131231564");
      ((com.tencent.mm.av.b)localObject1).ibM = 2131231564;
      com.tencent.mm.sdk.b.a.IvT.c(this.KSJ);
      com.tencent.mm.sdk.b.a.IvT.c(this.KSK);
      bc.aCc();
      bc.aCg();
      com.tencent.mm.model.c.azL().a(h.KQd);
      bc.aCg();
      com.tencent.mm.model.c.azF().a(h.KQd);
      bc.aCg();
      com.tencent.mm.model.c.azL().a(this.KPs);
      bc.aCg();
      com.tencent.mm.model.c.azF().a(this.KPs);
      localObject1 = this.KPs;
      if (((i)localObject1).KOQ == null) {
        ((i)localObject1).KOQ = new i.3((i)localObject1);
      }
      com.tencent.mm.sdk.b.a.IvT.c(((i)localObject1).KOQ);
      this.KPs.KRd = new i.b()
      {
        public final void fNv()
        {
          AppMethodBeat.i(188097);
          MainUI.b(MainUI.this).clearCache();
          bc.aCg();
          com.tencent.mm.model.c.azL().a(MainUI.b(MainUI.this));
          bc.aCg();
          com.tencent.mm.model.c.azF().a(MainUI.b(MainUI.this));
          AppMethodBeat.o(188097);
        }
      };
      localObject1 = this.KPs;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cTd() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cTd().add(((i)localObject1).JAv);
      }
      l = bu.DD(l);
      bc.aCg();
      ae.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.FFH) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {
        this.dAG = LauncherUI.getInstance().isInMultiWindowMode();
      }
      this.KSA.postDelayed(new Runnable()
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
      setOnVisibilityChangedListener(this.KSI);
      AppMethodBeat.o(38641);
      return;
      afi(i);
      ae.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.KSA.postDelayed((Runnable)localObject1, 100L);
      break;
      label1555:
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bCX();
      if (!((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bCY()) {
        break label351;
      }
      this.KSB = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).dZ(getContext());
      if ((this.KSB == null) || (!(this.iFK instanceof ViewGroup))) {
        break label351;
      }
      ae.i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.KSB.setVisibility(8);
      ((ViewGroup)this.iFK).addView(this.KSB, 0, (ViewGroup.LayoutParams)localObject1);
      break label351;
      label1652:
      this.KSo.a(getContext(), this.KSA, this.KSD);
      break label502;
      label1674:
      ae.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void fyH()
  {
    AppMethodBeat.i(38645);
    ae.i("MicroMsg.MainUI", "onTabResume");
    long l = bu.fpO();
    fNC();
    com.tencent.mm.blink.b.Wq().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38622);
        a locala = MainUI.c(MainUI.this);
        if (!locala.KOf)
        {
          locala.KOf = true;
          com.tencent.mm.aj.p.aEA().d(locala);
          bc.aCg();
          com.tencent.mm.model.c.ajA().a(locala);
          locala.fMS();
        }
        AppMethodBeat.o(38622);
      }
    });
    ae.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(bu.DD(l)) });
    Object localObject = this.KSF;
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.a((com.tencent.mm.bh.a)localObject);
    }
    com.tencent.mm.sdk.platformtools.ar.f(new p.8((p)localObject));
    o.kx(((p)localObject).dtg);
    if ((((p)localObject).dtg != null) && (((p)localObject).dtg.getIntent() != null) && (((p)localObject).dtg.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      com.tencent.mm.sdk.platformtools.ar.o(new p.9((p)localObject), 500L);
      ((p)localObject).dtg.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dtg;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().setTitleBarDoubleClickListener(((p)localObject).KGm);
    }
    if ((z.getBooleanExtra(((p)localObject).dtg.getIntent(), "Main_ListToTop", false)) && (((p)localObject).KSA != null)) {
      ((p)localObject).KSA.post(new p.2((p)localObject));
    }
    z.b(((p)localObject).dtg.getIntent(), "Main_ListToTop", false);
    localObject = this.KSE;
    int i;
    if (((k)localObject).fOC == null) {
      i = -1;
    }
    for (;;)
    {
      ae.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((k)localObject).fNz()) });
      ((k)localObject).fNx();
      com.tencent.mm.sdk.platformtools.ar.o(new k.7((k)localObject), 100L);
      if ((bc.ajM()) && (!this.KSE.fNA()))
      {
        com.tencent.mm.sdk.b.a.IvT.a(new wj(), Looper.getMainLooper());
        localObject = new vp();
        ((vp)localObject).dKS.action = 4;
        com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(188087);
            com.tencent.e.h.MqF.aO(paramAnonymousRunnable);
            AppMethodBeat.o(188087);
          }
        });
      }
      AppMethodBeat.o(38645);
      return;
      if (((k)localObject).fOC.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fyI()
  {
    AppMethodBeat.i(38646);
    ae.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void fyJ()
  {
    AppMethodBeat.i(38647);
    ae.i("MicroMsg.MainUI", "onTabPause");
    com.tencent.mm.blink.b.Wq().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188088);
        MainUI.c(MainUI.this).fyJ();
        AppMethodBeat.o(188088);
      }
    });
    Object localObject = this.KSE;
    if (((k)localObject).wakeLock.isHeld())
    {
      ae.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((k)localObject).wakeLock.release();
    }
    hideVKB();
    localObject = this.KSF;
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.b((com.tencent.mm.bh.a)localObject);
    }
    o.fNN();
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dtg;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aD(((p)localObject).KGm);
    }
    fND();
    AppMethodBeat.o(38647);
  }
  
  public final void fyK()
  {
    AppMethodBeat.i(38648);
    ae.i("MicroMsg.MainUI", "onTabStop");
    AppMethodBeat.o(38648);
  }
  
  public final void fyL()
  {
    AppMethodBeat.i(38649);
    ae.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(bc.ajM()) });
    com.tencent.mm.blink.b.Wq().u(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188089);
        a locala = MainUI.c(MainUI.this);
        ae.i("MicroMsg.BannerHelper", "destroyBanner");
        locala.fyJ();
        a.iR(locala.KNV);
        a.iR(locala.KNW);
        a.iR(locala.KNX);
        a.iR(locala.KNY);
        Iterator localIterator = locala.KNZ.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        bc.b(locala.BEN);
        com.tencent.mm.sdk.b.a.IvT.d(locala.KOb);
        com.tencent.mm.sdk.b.a.IvT.d(locala.KOc);
        if (bc.ajM())
        {
          bc.aCg();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(188089);
      }
    });
    Object localObject = this.KSE;
    ((k)localObject).KSs.unlock();
    bc.ajj().b(-1, (com.tencent.mm.ak.f)localObject);
    if (((k)localObject).fOC != null)
    {
      ((k)localObject).fOC.dismiss();
      ((k)localObject).fOC = null;
    }
    com.tencent.mm.sdk.b.a.IvT.d(((k)localObject).KSq);
    com.tencent.mm.sdk.b.a.IvT.d(((k)localObject).KSr);
    localObject = this.KSF;
    if (((p)localObject).pIT != null)
    {
      com.tencent.mm.sdk.b.a.IvT.d(((p)localObject).pIT);
      ((p)localObject).pIT = null;
    }
    com.tencent.mm.sdk.b.a.IvT.d(((p)localObject).KTT);
    com.tencent.mm.sdk.b.a.IvT.d(((p)localObject).KTU);
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.b((com.tencent.mm.bh.a)localObject);
    }
    if (bc.ajM()) {
      af.aRj();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.KSJ);
    com.tencent.mm.sdk.b.a.IvT.d(this.KSK);
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.azL().a(h.KQd);
      bc.aCg();
      com.tencent.mm.model.c.azF().a(h.KQd);
      if (this.KPs != null)
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().b(this.KPs);
        bc.aCg();
        com.tencent.mm.model.c.azF().b(this.KPs);
      }
    }
    if (this.KPs != null)
    {
      localObject = this.KPs;
      if (((i)localObject).KOQ != null)
      {
        com.tencent.mm.sdk.b.a.IvT.d(((i)localObject).KOQ);
        ((i)localObject).KOQ = null;
      }
      this.KPs.KRd = null;
      localObject = this.KPs;
      ((i)localObject).KRd = null;
      if (((i)localObject).JPs != null)
      {
        ((i)localObject).JPs.clear();
        ((i)localObject).JPs = null;
      }
      ((com.tencent.mm.ui.f)localObject).xh(true);
      ((i)localObject).fzh();
      ((i)localObject).KRg.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.cTd() != null)) {
        localb.cTd().remove(((i)localObject).JAv);
      }
      ae.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.KSI = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(38649);
  }
  
  public final void fyM() {}
  
  public final void fyN()
  {
    AppMethodBeat.i(38650);
    ae.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void fyO()
  {
    AppMethodBeat.i(38651);
    ae.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void fzQ()
  {
    AppMethodBeat.i(38652);
    ae.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    k localk = this.KSE;
    int i;
    if (localk.fOC == null) {
      i = -1;
    }
    for (;;)
    {
      ae.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localk.fNz()) });
      if (localk.wakeLock != null) {
        localk.fNx();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      AppMethodBeat.o(38652);
      return;
      if (localk.fOC.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fzR()
  {
    AppMethodBeat.i(38653);
    ae.i("MicroMsg.MainUI", "onTabSwitchOut");
    if (this.KSA != null)
    {
      ConversationListView localConversationListView = this.KSA;
      localConversationListView.fNe();
      if (localConversationListView.KPu != null) {
        localConversationListView.KPu.bDp();
      }
    }
    AppMethodBeat.o(38653);
  }
  
  public int getLayoutId()
  {
    return 2131494680;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(38634);
    com.tencent.mm.kiss.a.b.akR();
    this.iFK = com.tencent.mm.kiss.a.b.c(getContext(), 2131494680);
    View localView = this.iFK;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public final void m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.KSA instanceof ConversationListView))
    {
      this.KSA.m(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.KSL = new a(paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(38638);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38640);
    super.onConfigurationChanged(paramConfiguration);
    this.KSo.fMS();
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    ae.i("MicroMsg.MainUI", "onDestroy");
    this.KSG.fNM();
    if (this.KSA != null)
    {
      ConversationListView localConversationListView = this.KSA;
      if (localConversationListView.mZy != null) {
        localConversationListView.mZy.onDestroy();
      }
      if (localConversationListView.KPu != null) {
        localConversationListView.KPu.onDestroy();
      }
      if (localConversationListView.KPO != null) {
        localConversationListView.removeCallbacks(localConversationListView.KPO);
      }
      if (localConversationListView.KPN != null) {
        localConversationListView.removeCallbacks(localConversationListView.KPN);
      }
      if (localConversationListView.KPM != null) {
        localConversationListView.removeCallbacks(localConversationListView.KPM);
      }
      if (localConversationListView.KPT != null) {
        localConversationListView.KPT.dead();
      }
    }
    super.onDestroy();
    AppMethodBeat.o(38654);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38656);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((this.KSA != null) && (this.KSA.bDr()))
      {
        paramKeyEvent = this.KSA;
        ae.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", new Object[] { Long.valueOf(10L), Integer.valueOf(11) });
        if (paramKeyEvent.getFirstVisiblePosition() == 0)
        {
          if (10L <= 0L) {
            break label133;
          }
          if (paramKeyEvent.KPN != null) {
            paramKeyEvent.removeCallbacks(paramKeyEvent.KPN);
          }
          paramKeyEvent.KPN = new ConversationListView.8(paramKeyEvent);
          paramKeyEvent.postDelayed(paramKeyEvent.KPN, 10L);
        }
        for (;;)
        {
          AppMethodBeat.o(38656);
          return true;
          label133:
          paramKeyEvent.setSelection(0);
        }
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
    ae.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    if (this.KSA != null)
    {
      ConversationListView localConversationListView = this.KSA;
      if (localConversationListView.mZy != null) {
        localConversationListView.mZy.onPause();
      }
    }
    AppMethodBeat.o(38636);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38635);
    ae.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    ConversationListView localConversationListView;
    if (this.KSA != null)
    {
      localConversationListView = this.KSA;
      if (localConversationListView.mZy != null) {
        localConversationListView.mZy.onResume();
      }
      if ((localConversationListView.KPu != null) && (localConversationListView.KPu.bDs()) && (localConversationListView.mZy.getBottom() < com.tencent.mm.cb.a.fromDPToPix(localConversationListView.getContext(), 100)))
      {
        if (!al.isDarkMode()) {
          break label131;
        }
        localConversationListView.kc(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
      }
    }
    for (;;)
    {
      if (localConversationListView.KPu != null) {
        localConversationListView.KPu.onResume();
      }
      AppMethodBeat.o(38635);
      return;
      label131:
      localConversationListView.kc(localConversationListView.getResources().getColor(2131100705), localConversationListView.getResources().getColor(2131099885));
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean KSV;
    boolean dnq;
    boolean iOP;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.dnq = paramBoolean1;
      this.iOP = paramBoolean2;
      this.KSV = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */