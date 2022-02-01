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
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.lq.a;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.s;
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
  private i KsY;
  private a KvU;
  public ConversationListView Kwg;
  private View Kwh;
  private View Kwi;
  private TextView Kwj;
  private k Kwk;
  private p Kwl;
  private n Kwm;
  public com.tencent.mm.plugin.appbrand.widget.header.a Kwn;
  private com.tencent.mm.ui.i.a Kwo;
  private com.tencent.mm.sdk.b.c Kwp;
  com.tencent.mm.sdk.b.c Kwq;
  private a Kwr;
  private boolean dzB;
  private View iCR;
  private View mUB;
  public MMFragmentActivity mWg;
  private int[] rwo;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.KvU = new a();
    this.Kwk = new k();
    this.Kwl = new p();
    this.Kwm = new n();
    this.rwo = new int[2];
    this.Kwo = new com.tencent.mm.ui.i.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = d.Ksp;
          d.yr(paramAnonymousBoolean);
          localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).dzB)
          {
            ad.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).fII();
          }
          localObject = d.Ksp;
          d.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.Kwp = new com.tencent.mm.sdk.b.c() {};
    this.Kwq = new com.tencent.mm.sdk.b.c()
    {
      private final long INTERVAL;
      long Kwu;
      int Kwv;
      int Kww;
    };
    this.iCR = null;
    this.dzB = false;
    AppMethodBeat.o(38633);
  }
  
  private void aez(int paramInt)
  {
    AppMethodBeat.i(38637);
    ad.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.dzB) });
    ViewGroup.LayoutParams localLayoutParams = this.Kwg.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    int i;
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      ad.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i <= 0) || (this.dzB)) {
        if (this.dzB) {
          break label206;
        }
      }
    }
    label206:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.Kwg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.mUB == null) {
        break label228;
      }
      i = this.mUB.getLayoutParams().height;
      ad.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i > 0) && (!this.dzB)) {
        break label228;
      }
      if (this.dzB) {
        break;
      }
      this.mUB.getLayoutParams().height = paramInt;
      AppMethodBeat.o(38637);
      return;
    }
    this.mUB.getLayoutParams().height = 0;
    label228:
    AppMethodBeat.o(38637);
  }
  
  public final void abL(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.KsY != null) {
      this.KsY.aew(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final void adO()
  {
    AppMethodBeat.i(38655);
    if (this.KsY != null)
    {
      this.KsY.vdz = false;
      this.KsY.fJb();
      LauncherUI.getInstance().IYQ.getMainTabUI().gzT();
    }
    AppMethodBeat.o(38655);
  }
  
  public final void fHE()
  {
    AppMethodBeat.i(38639);
    if (this.KsY != null) {
      this.KsY.fHE();
    }
    AppMethodBeat.o(38639);
  }
  
  public final void fJk()
  {
    if (this.KsY != null) {
      this.KsY.vdz = true;
    }
  }
  
  public final void fJl()
  {
    AppMethodBeat.i(38642);
    if (this.KsY != null) {
      this.KsY.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void fJm()
  {
    AppMethodBeat.i(38643);
    if (this.KsY != null) {
      this.KsY.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void fJn()
  {
    AppMethodBeat.i(38657);
    if ((this.Kwg != null) && (this.Kwg.bCz())) {
      this.Kwg.fIJ();
    }
    AppMethodBeat.o(38657);
  }
  
  public final void fuF()
  {
    AppMethodBeat.i(38641);
    ad.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.be(4, false);
    }
    ad.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    com.tencent.mm.model.ba.ajF().fkT();
    ad.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.Kwg != null)
    {
      localObject1 = this.KvU;
      if (((a)localObject1).KrJ != null)
      {
        ((a)localObject1).iE(((a)localObject1).KrB);
        ((a)localObject1).iE(((a)localObject1).KrC);
        ((a)localObject1).iE(((a)localObject1).KrD);
        ((a)localObject1).iE(((a)localObject1).KrE);
        localObject2 = ((a)localObject1).KrF.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).KrJ.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.Kwj = ((TextView)findViewById(2131299462));
    this.Kwg = ((ConversationListView)findViewById(2131301984));
    this.mUB = findViewById(2131305195);
    this.Kwg.setStatusBarMaskView(this.mUB);
    int i;
    int j;
    if (this.Kwg != null)
    {
      i = ar.B(getContext(), -1);
      j = com.tencent.mm.pluginsdk.h.dT(this.Kwg.getContext());
      ad.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      localObject1 = new Runnable()
      {
        int hfV = 0;
        
        public final void run()
        {
          AppMethodBeat.i(38620);
          if (MainUI.a(MainUI.this) == null)
          {
            AppMethodBeat.o(38620);
            return;
          }
          int i = ar.B(MainUI.this.getContext(), -1);
          int j = com.tencent.mm.pluginsdk.h.dT(MainUI.a(MainUI.this).getContext());
          if ((i <= 0) || (j <= 0)) {
            if (this.hfV < 2)
            {
              ad.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
              MainUI.a(MainUI.this).post(this);
              this.hfV += 1;
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.hfV), Integer.valueOf(i) });
            AppMethodBeat.o(38620);
            return;
            ad.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
            break;
            if (i != MainUI.a(MainUI.this).getPaddingTop())
            {
              ad.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(MainUI.a(MainUI.this).getPaddingTop()) });
              MainUI.b(MainUI.this, i);
            }
            else
            {
              ad.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", new Object[] { Integer.valueOf(i) });
            }
          }
        }
      };
      if (i <= 0) {
        this.Kwg.post((Runnable)localObject1);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      if (localObject1 != null) {
        break label1555;
      }
      ad.e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
      label351:
      this.Kwg.setDrawingCacheEnabled(false);
      this.Kwg.setScrollingCacheEnabled(false);
      this.Kwi = findViewById(2131296700);
      localObject1 = this.Kwg;
      localObject2 = this.Kwh;
      localObject3 = this.Kwi;
      ((ConversationListView)localObject1).Ktv = ((View)localObject2);
      if (((ConversationListView)localObject1).mUr != null) {
        ((ConversationListView)localObject1).mUr.g((View)localObject2, (View)localObject3);
      }
      this.KsY = new i(getContext(), this.Kwg, new f.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(194698);
          i locali;
          if (MainUI.b(MainUI.this) != null)
          {
            locali = MainUI.b(MainUI.this);
            if ((locali.JuD != null) && (locali.KuP != null) && (!locali.KuP.isEmpty())) {}
          }
          else
          {
            MainUI.a(MainUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(194696);
                try
                {
                  LauncherUI.getInstance().IYQ.getMainTabUI().gzT();
                  MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                  if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                  {
                    ConversationListView localConversationListView = MainUI.a(MainUI.this);
                    ad.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.mUX) });
                    if (!localConversationListView.mUX)
                    {
                      localConversationListView.ys(false);
                      if (localConversationListView.KtD != null) {
                        localConversationListView.KtD.setBackgroundColor(localConversationListView.getContext().getResources().getColor(2131099650));
                      }
                      if (!al.isDarkMode()) {
                        break label207;
                      }
                      localConversationListView.jV(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
                    }
                  }
                  MainUI.c(MainUI.this).fIA();
                  com.tencent.mm.plugin.report.service.f.Ok(12);
                  AppMethodBeat.o(194696);
                  return;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    ad.printErrStackTrace("MicroMsg.MainUI", localException, "report unread", new Object[0]);
                    continue;
                    label207:
                    localException.jV(localException.getResources().getColor(2131100705), localException.getResources().getColor(2131099885));
                  }
                }
              }
            });
            AppMethodBeat.o(194698);
            return;
          }
          if (locali.KuQ)
          {
            locali.JuD.clear();
            locali.KuQ = false;
          }
          for (;;)
          {
            locali.KuP.clear();
            break;
            ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(locali.KuP.size()) });
            Iterator localIterator = locali.KuP.iterator();
            while (localIterator.hasNext()) {
              locali.JuD.remove(localIterator.next());
            }
          }
        }
        
        public final void fvs()
        {
          AppMethodBeat.i(194697);
          com.tencent.mm.plugin.report.service.f.Oj(12);
          AppMethodBeat.o(194697);
        }
      });
      this.KsY.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(194699);
          int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(194699);
          return i;
        }
      });
      this.KsY.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(194700);
          MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(194700);
        }
      });
      if (!com.tencent.mm.compatible.util.d.lA(18)) {
        break label1652;
      }
      com.tencent.mm.blink.b.Wi().w(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38631);
          MainUI.c(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.d(MainUI.this));
          AppMethodBeat.o(38631);
        }
      });
      label502:
      localObject1 = this.Kwm;
      localObject2 = this.Kwg;
      localObject3 = this.KsY;
      ((n)localObject1).KrJ = ((ListView)localObject2);
      ((n)localObject1).KsY = ((i)localObject3);
      ((ListView)localObject2).setOnScrollListener(((n)localObject1).fMX);
      ((i)localObject3).Kss = ((n)localObject1).fMX;
      aq.f(new n.2((n)localObject1));
      LauncherUI.getInstance().IYQ.getMainTabUI().gzT();
      this.Kwg.setAdapter(this.KsY);
      this.Kwg.setOnItemClickListener(new f(this.KsY, this.Kwg, getActivity()));
      this.Kwg.setOnItemLongClickListener(new g(this.KsY, this.Kwg, getActivity(), this.rwo));
      this.Kwg.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(194701);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/MainUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/MainUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(194701);
            return false;
            MainUI.this.hideVKB();
            MainUI.e(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.e(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.Kwn != null) {
        this.Kwg.setActionBarUpdateCallback(this.Kwn);
      }
      if (this.mWg != null) {
        this.Kwg.setActivity(this.mWg);
      }
      if (this.Kwr != null) {
        j(this.Kwr.dmo, this.Kwr.iLW, this.Kwr.KwB);
      }
      this.Kwg.setSelection(0);
      localObject1 = this.Kwk;
      localObject2 = getActivity();
      localObject3 = this.KvU;
      ((k)localObject1).dsa = ((Activity)localObject2);
      ((k)localObject1).KvU = ((a)localObject3);
      ((k)localObject1).KvV = this;
      ((k)localObject1).jLC = new WeakReference(localObject2);
      ((k)localObject1).wakeLock = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      com.tencent.mm.model.ba.aiU().a(-1, (com.tencent.mm.al.f)localObject1);
      ((k)localObject1).KvR = false;
      com.tencent.mm.sdk.b.a.IbL.c(((k)localObject1).KvW);
      com.tencent.mm.sdk.b.a.IbL.c(((k)localObject1).KvX);
      localObject2 = new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "DBRecoverStarted");
      if (((com.tencent.mm.vfs.e)localObject2).exists())
      {
        com.tencent.mm.plugin.report.e.ygI.g("DBRepair", "Last recovery interrupted.", null);
        ((com.tencent.mm.vfs.e)localObject2).delete();
      }
      ((k)localObject1).KvY = new FLock(com.tencent.mm.vfs.i.k(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "MMStarted").mUri), true));
      if (!((k)localObject1).KvY.fkc()) {
        break label1674;
      }
      ((k)localObject1).KvY.unlock();
      ad.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((k)localObject1).KvY.lockRead();
      localObject1 = this.Kwl;
      localObject2 = this.KsY;
      localObject3 = this.Kwg;
      FragmentActivity localFragmentActivity = getActivity();
      ((p)localObject1).KsY = ((i)localObject2);
      ((p)localObject1).dsa = localFragmentActivity;
      ((p)localObject1).Kwg = ((ConversationListView)localObject3);
      if (((p)localObject1).pCp == null) {
        ((p)localObject1).pCp = new p.3((p)localObject1, new p.1((p)localObject1));
      }
      if (((p)localObject1).Kxz == null) {
        ((p)localObject1).Kxz = new p.4((p)localObject1);
      }
      if (((p)localObject1).KxA == null) {
        ((p)localObject1).KxA = new p.5((p)localObject1, (ConversationListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.IbL.c(((p)localObject1).pCp);
      com.tencent.mm.sdk.b.a.IbL.c(((p)localObject1).Kxz);
      com.tencent.mm.sdk.b.a.IbL.c(((p)localObject1).KxA);
      ((p)localObject1).ogP = new p.6((p)localObject1);
      Looper.myQueue().addIdleHandler(((p)localObject1).ogP);
      ((ConversationListView)localObject3).post(new p.7((p)localObject1));
      localObject1 = com.tencent.mm.aw.q.aIH();
      ad.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.aw.b)localObject1).hYU + " to 2131231564");
      ((com.tencent.mm.aw.b)localObject1).hYU = 2131231564;
      com.tencent.mm.sdk.b.a.IbL.c(this.Kwp);
      com.tencent.mm.sdk.b.a.IbL.c(this.Kwq);
      com.tencent.mm.model.ba.aBM();
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(h.KtJ);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azp().a(h.KtJ);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(this.KsY);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azp().a(this.KsY);
      localObject1 = this.KsY;
      if (((i)localObject1).Ksw == null) {
        ((i)localObject1).Ksw = new i.3((i)localObject1);
      }
      com.tencent.mm.sdk.b.a.IbL.c(((i)localObject1).Ksw);
      this.KsY.KuJ = new i.b()
      {
        public final void fJe()
        {
          AppMethodBeat.i(194695);
          MainUI.b(MainUI.this).clearCache();
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().a(MainUI.b(MainUI.this));
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azp().a(MainUI.b(MainUI.this));
          AppMethodBeat.o(194695);
        }
      };
      localObject1 = this.KsY;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cQy() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cQy().add(((i)localObject1).JfK);
      }
      l = bt.Df(l);
      com.tencent.mm.model.ba.aBQ();
      ad.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.Fnj) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {
        this.dzB = LauncherUI.getInstance().isInMultiWindowMode();
      }
      this.Kwg.postDelayed(new Runnable()
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
      setOnVisibilityChangedListener(this.Kwo);
      AppMethodBeat.o(38641);
      return;
      aez(i);
      ad.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.Kwg.postDelayed((Runnable)localObject1, 100L);
      break;
      label1555:
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bCd();
      if (!((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bCe()) {
        break label351;
      }
      this.Kwh = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).dV(getContext());
      if ((this.Kwh == null) || (!(this.iCR instanceof ViewGroup))) {
        break label351;
      }
      ad.i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.Kwh.setVisibility(8);
      ((ViewGroup)this.iCR).addView(this.Kwh, 0, (ViewGroup.LayoutParams)localObject1);
      break label351;
      label1652:
      this.KvU.a(getContext(), this.Kwg, this.Kwj);
      break label502;
      label1674:
      ad.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void fuG()
  {
    AppMethodBeat.i(38645);
    ad.i("MicroMsg.MainUI", "onTabResume");
    long l = bt.flT();
    fJl();
    com.tencent.mm.blink.b.Wi().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38622);
        a locala = MainUI.c(MainUI.this);
        if (!locala.KrL)
        {
          locala.KrL = true;
          com.tencent.mm.ak.p.aEk().d(locala);
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.ajl().a(locala);
          locala.fIA();
        }
        AppMethodBeat.o(38622);
      }
    });
    ad.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(bt.Df(l)) });
    Object localObject = this.Kwl;
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.a((com.tencent.mm.bi.a)localObject);
    }
    aq.f(new p.8((p)localObject));
    o.kq(((p)localObject).dsa);
    if ((((p)localObject).dsa != null) && (((p)localObject).dsa.getIntent() != null) && (((p)localObject).dsa.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      aq.o(new p.9((p)localObject), 500L);
      ((p)localObject).dsa.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dsa;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().setTitleBarDoubleClickListener(((p)localObject).KjS);
    }
    if ((y.getBooleanExtra(((p)localObject).dsa.getIntent(), "Main_ListToTop", false)) && (((p)localObject).Kwg != null)) {
      ((p)localObject).Kwg.post(new p.2((p)localObject));
    }
    y.b(((p)localObject).dsa.getIntent(), "Main_ListToTop", false);
    localObject = this.Kwk;
    int i;
    if (((k)localObject).fMu == null) {
      i = -1;
    }
    for (;;)
    {
      ad.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((k)localObject).fJi()) });
      ((k)localObject).fJg();
      aq.o(new k.7((k)localObject), 100L);
      if ((com.tencent.mm.model.ba.ajx()) && (!this.Kwk.fJj()))
      {
        com.tencent.mm.sdk.b.a.IbL.a(new wf(), Looper.getMainLooper());
        localObject = new vl();
        ((vl)localObject).dJE.action = 4;
        com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(194685);
            com.tencent.e.h.LTJ.aR(paramAnonymousRunnable);
            AppMethodBeat.o(194685);
          }
        });
      }
      AppMethodBeat.o(38645);
      return;
      if (((k)localObject).fMu.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fuH()
  {
    AppMethodBeat.i(38646);
    ad.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void fuI()
  {
    AppMethodBeat.i(38647);
    ad.i("MicroMsg.MainUI", "onTabPause");
    com.tencent.mm.blink.b.Wi().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194686);
        MainUI.c(MainUI.this).fuI();
        AppMethodBeat.o(194686);
      }
    });
    Object localObject = this.Kwk;
    if (((k)localObject).wakeLock.isHeld())
    {
      ad.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((k)localObject).wakeLock.release();
    }
    hideVKB();
    localObject = this.Kwl;
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.b((com.tencent.mm.bi.a)localObject);
    }
    o.fJw();
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dsa;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aF(((p)localObject).KjS);
    }
    fJm();
    AppMethodBeat.o(38647);
  }
  
  public final void fuJ()
  {
    AppMethodBeat.i(38648);
    ad.i("MicroMsg.MainUI", "onTabStop");
    AppMethodBeat.o(38648);
  }
  
  public final void fuK()
  {
    AppMethodBeat.i(38649);
    ad.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(com.tencent.mm.model.ba.ajx()) });
    com.tencent.mm.blink.b.Wi().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194687);
        a locala = MainUI.c(MainUI.this);
        ad.i("MicroMsg.BannerHelper", "destroyBanner");
        locala.fuI();
        a.iH(locala.KrB);
        a.iH(locala.KrC);
        a.iH(locala.KrD);
        a.iH(locala.KrE);
        Iterator localIterator = locala.KrF.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        com.tencent.mm.model.ba.b(locala.Bno);
        com.tencent.mm.sdk.b.a.IbL.d(locala.KrH);
        com.tencent.mm.sdk.b.a.IbL.d(locala.KrI);
        if (com.tencent.mm.model.ba.ajx())
        {
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(194687);
      }
    });
    Object localObject = this.Kwk;
    ((k)localObject).KvY.unlock();
    com.tencent.mm.model.ba.aiU().b(-1, (com.tencent.mm.al.f)localObject);
    if (((k)localObject).fMu != null)
    {
      ((k)localObject).fMu.dismiss();
      ((k)localObject).fMu = null;
    }
    com.tencent.mm.sdk.b.a.IbL.d(((k)localObject).KvW);
    com.tencent.mm.sdk.b.a.IbL.d(((k)localObject).KvX);
    localObject = this.Kwl;
    if (((p)localObject).pCp != null)
    {
      com.tencent.mm.sdk.b.a.IbL.d(((p)localObject).pCp);
      ((p)localObject).pCp = null;
    }
    com.tencent.mm.sdk.b.a.IbL.d(((p)localObject).Kxz);
    com.tencent.mm.sdk.b.a.IbL.d(((p)localObject).KxA);
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.b((com.tencent.mm.bi.a)localObject);
    }
    if (com.tencent.mm.model.ba.ajx()) {
      af.aQK();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.Kwp);
    com.tencent.mm.sdk.b.a.IbL.d(this.Kwq);
    if (com.tencent.mm.model.ba.ajx())
    {
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(h.KtJ);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azp().a(h.KtJ);
      if (this.KsY != null)
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().b(this.KsY);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azp().b(this.KsY);
      }
    }
    if (this.KsY != null)
    {
      localObject = this.KsY;
      if (((i)localObject).Ksw != null)
      {
        com.tencent.mm.sdk.b.a.IbL.d(((i)localObject).Ksw);
        ((i)localObject).Ksw = null;
      }
      this.KsY.KuJ = null;
      localObject = this.KsY;
      ((i)localObject).KuJ = null;
      if (((i)localObject).JuD != null)
      {
        ((i)localObject).JuD.clear();
        ((i)localObject).JuD = null;
      }
      ((com.tencent.mm.ui.f)localObject).wZ(true);
      ((i)localObject).fvg();
      ((i)localObject).KuM.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.cQy() != null)) {
        localb.cQy().remove(((i)localObject).JfK);
      }
      ad.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.Kwo = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(38649);
  }
  
  public final void fuL() {}
  
  public final void fuM()
  {
    AppMethodBeat.i(38650);
    ad.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void fuN()
  {
    AppMethodBeat.i(38651);
    ad.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void fvQ()
  {
    AppMethodBeat.i(38652);
    ad.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    k localk = this.Kwk;
    int i;
    if (localk.fMu == null) {
      i = -1;
    }
    for (;;)
    {
      ad.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localk.fJi()) });
      if (localk.wakeLock != null) {
        localk.fJg();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      AppMethodBeat.o(38652);
      return;
      if (localk.fMu.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void fvR()
  {
    AppMethodBeat.i(38653);
    ad.i("MicroMsg.MainUI", "onTabSwitchOut");
    if (this.Kwg != null)
    {
      ConversationListView localConversationListView = this.Kwg;
      localConversationListView.fIM();
      if (localConversationListView.Kta != null) {
        localConversationListView.Kta.bCx();
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
    com.tencent.mm.kiss.a.b.akC();
    this.iCR = com.tencent.mm.kiss.a.b.c(getContext(), 2131494680);
    View localView = this.iCR;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.Kwg instanceof ConversationListView))
    {
      this.Kwg.j(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.Kwr = new a(paramBoolean1, paramBoolean2, paramBoolean3);
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
    this.KvU.fIA();
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    ad.i("MicroMsg.MainUI", "onDestroy");
    this.Kwm.fJv();
    if (this.Kwg != null)
    {
      ConversationListView localConversationListView = this.Kwg;
      if (localConversationListView.mUr != null) {
        localConversationListView.mUr.onDestroy();
      }
      if (localConversationListView.Kta != null) {
        localConversationListView.Kta.onDestroy();
      }
      if (localConversationListView.Ktu != null) {
        localConversationListView.removeCallbacks(localConversationListView.Ktu);
      }
      if (localConversationListView.Ktt != null) {
        localConversationListView.removeCallbacks(localConversationListView.Ktt);
      }
      if (localConversationListView.Kts != null) {
        localConversationListView.removeCallbacks(localConversationListView.Kts);
      }
      if (localConversationListView.Ktz != null) {
        localConversationListView.Ktz.dead();
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
      if ((this.Kwg != null) && (this.Kwg.bCz()))
      {
        paramKeyEvent = this.Kwg;
        ad.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", new Object[] { Long.valueOf(10L), Integer.valueOf(11) });
        if (paramKeyEvent.getFirstVisiblePosition() == 0)
        {
          if (10L <= 0L) {
            break label133;
          }
          if (paramKeyEvent.Ktt != null) {
            paramKeyEvent.removeCallbacks(paramKeyEvent.Ktt);
          }
          paramKeyEvent.Ktt = new ConversationListView.8(paramKeyEvent);
          paramKeyEvent.postDelayed(paramKeyEvent.Ktt, 10L);
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
    ad.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    if (this.Kwg != null)
    {
      ConversationListView localConversationListView = this.Kwg;
      if (localConversationListView.mUr != null) {
        localConversationListView.mUr.onPause();
      }
    }
    AppMethodBeat.o(38636);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38635);
    ad.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    ConversationListView localConversationListView;
    if (this.Kwg != null)
    {
      localConversationListView = this.Kwg;
      if (localConversationListView.mUr != null) {
        localConversationListView.mUr.onResume();
      }
      if ((localConversationListView.Kta != null) && (localConversationListView.Kta.bCA()) && (localConversationListView.mUr.getBottom() < com.tencent.mm.cc.a.fromDPToPix(localConversationListView.getContext(), 100)))
      {
        if (!al.isDarkMode()) {
          break label131;
        }
        localConversationListView.jV(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
      }
    }
    for (;;)
    {
      if (localConversationListView.Kta != null) {
        localConversationListView.Kta.onResume();
      }
      AppMethodBeat.o(38635);
      return;
      label131:
      localConversationListView.jV(localConversationListView.getResources().getColor(2131100705), localConversationListView.getResources().getColor(2131099885));
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean KwB;
    boolean dmo;
    boolean iLW;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.dmo = paramBoolean1;
      this.iLW = paramBoolean2;
      this.KwB = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */