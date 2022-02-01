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
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.a;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.s;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class MainUI
  extends AbstractTabChildActivity.AbStractTabFragment
  implements k.a
{
  private i IBS;
  private a IER;
  public ConversationListView IFc;
  private View IFd;
  private View IFe;
  private TextView IFf;
  private k IFg;
  private p IFh;
  private n IFi;
  public com.tencent.mm.plugin.appbrand.widget.header.a IFj;
  private com.tencent.mm.ui.i.a IFk;
  private com.tencent.mm.sdk.b.c IFl;
  com.tencent.mm.sdk.b.c IFm;
  private a IFn;
  private boolean dnN;
  private View ijA;
  private View mtU;
  public MMFragmentActivity mvz;
  private int[] qMm;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.IER = new a();
    this.IFg = new k();
    this.IFh = new p();
    this.IFi = new n();
    this.qMm = new int[2];
    this.IFk = new com.tencent.mm.ui.i.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = d.IBj;
          d.xD(paramAnonymousBoolean);
          localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).dnN)
          {
            ac.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).frT();
          }
          localObject = d.IBj;
          d.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.IFl = new com.tencent.mm.sdk.b.c() {};
    this.IFm = new com.tencent.mm.sdk.b.c()
    {
      long IFq;
      int IFr;
      private final long INTERVAL;
    };
    this.ijA = null;
    this.dnN = false;
    AppMethodBeat.o(38633);
  }
  
  private void acb(int paramInt)
  {
    AppMethodBeat.i(38637);
    ac.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.dnN) });
    ViewGroup.LayoutParams localLayoutParams = this.IFc.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    int i;
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      ac.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i <= 0) || (this.dnN)) {
        if (this.dnN) {
          break label206;
        }
      }
    }
    label206:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.IFc.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.mtU == null) {
        break label228;
      }
      i = this.mtU.getLayoutParams().height;
      ac.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i > 0) && (!this.dnN)) {
        break label228;
      }
      if (this.dnN) {
        break;
      }
      this.mtU.getLayoutParams().height = paramInt;
      AppMethodBeat.o(38637);
      return;
    }
    this.mtU.getLayoutParams().height = 0;
    label228:
    AppMethodBeat.o(38637);
  }
  
  public final void ZB(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.IBS != null) {
      this.IBS.abZ(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final void abk()
  {
    AppMethodBeat.i(38655);
    if (this.IBS != null)
    {
      this.IBS.uaQ = false;
      this.IBS.fsn();
      LauncherUI.getInstance().Hlj.getMainTabUI().fgW();
    }
    AppMethodBeat.o(38655);
  }
  
  public final void feA()
  {
    AppMethodBeat.i(38646);
    ac.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void feB()
  {
    AppMethodBeat.i(38647);
    ac.i("MicroMsg.MainUI", "onTabPause");
    com.tencent.mm.blink.b.TR().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196838);
        MainUI.c(MainUI.this).feB();
        AppMethodBeat.o(196838);
      }
    });
    Object localObject = this.IFg;
    if (((k)localObject).wakeLock.isHeld())
    {
      ac.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((k)localObject).wakeLock.release();
    }
    hideVKB();
    localObject = this.IFh;
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.b((com.tencent.mm.bh.a)localObject);
    }
    o.fsI();
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dgE;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aH(((p)localObject).Itm);
    }
    fsy();
    AppMethodBeat.o(38647);
  }
  
  public final void feC()
  {
    AppMethodBeat.i(38648);
    ac.i("MicroMsg.MainUI", "onTabStop");
    AppMethodBeat.o(38648);
  }
  
  public final void feD()
  {
    AppMethodBeat.i(38649);
    ac.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(com.tencent.mm.model.az.agM()) });
    com.tencent.mm.blink.b.TR().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196839);
        a locala = MainUI.c(MainUI.this);
        ac.i("MicroMsg.BannerHelper", "destroyBanner");
        locala.feB();
        a.iv(locala.IAv);
        a.iv(locala.IAw);
        a.iv(locala.IAx);
        a.iv(locala.IAy);
        Iterator localIterator = locala.IAz.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        com.tencent.mm.model.az.b(locala.zVK);
        com.tencent.mm.sdk.b.a.GpY.d(locala.IAB);
        com.tencent.mm.sdk.b.a.GpY.d(locala.IAC);
        if (com.tencent.mm.model.az.agM())
        {
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(196839);
      }
    });
    Object localObject = this.IFg;
    ((k)localObject).IEV.unlock();
    com.tencent.mm.model.az.agi().b(-1, (com.tencent.mm.ak.g)localObject);
    if (((k)localObject).fts != null)
    {
      ((k)localObject).fts.dismiss();
      ((k)localObject).fts = null;
    }
    com.tencent.mm.sdk.b.a.GpY.d(((k)localObject).IET);
    com.tencent.mm.sdk.b.a.GpY.d(((k)localObject).IEU);
    localObject = this.IFh;
    if (((p)localObject).oYF != null)
    {
      com.tencent.mm.sdk.b.a.GpY.d(((p)localObject).oYF);
      ((p)localObject).oYF = null;
    }
    com.tencent.mm.sdk.b.a.GpY.d(((p)localObject).IGt);
    com.tencent.mm.sdk.b.a.GpY.d(((p)localObject).IGu);
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.b((com.tencent.mm.bh.a)localObject);
    }
    if (com.tencent.mm.model.az.agM()) {
      com.tencent.mm.platformtools.ae.aNy();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.IFl);
    com.tencent.mm.sdk.b.a.GpY.d(this.IFm);
    if (com.tencent.mm.model.az.agM())
    {
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().a(h.ICD);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awB().a(h.ICD);
      if (this.IBS != null)
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().b(this.IBS);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awB().b(this.IBS);
      }
    }
    if (this.IBS != null)
    {
      localObject = this.IBS;
      if (((i)localObject).IBq != null)
      {
        com.tencent.mm.sdk.b.a.GpY.d(((i)localObject).IBq);
        ((i)localObject).IBq = null;
      }
      this.IBS.IDG = null;
      localObject = this.IBS;
      ((i)localObject).IDG = null;
      if (((i)localObject).HGM != null)
      {
        ((i)localObject).HGM.clear();
        ((i)localObject).HGM = null;
      }
      ((com.tencent.mm.ui.f)localObject).wn(true);
      ((i)localObject).feY();
      ((i)localObject).IDJ.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.cIj() != null)) {
        localb.cIj().remove(((i)localObject).Hsb);
      }
      ac.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.IFk = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(38649);
  }
  
  public final void feE() {}
  
  public final void feF()
  {
    AppMethodBeat.i(38650);
    ac.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void feG()
  {
    AppMethodBeat.i(38651);
    ac.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void fey()
  {
    AppMethodBeat.i(38641);
    ac.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.aX(4, false);
    }
    ac.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    com.tencent.mm.model.az.agU().eVm();
    ac.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.IFc != null)
    {
      localObject1 = this.IER;
      if (((a)localObject1).IAD != null)
      {
        ((a)localObject1).is(((a)localObject1).IAv);
        ((a)localObject1).is(((a)localObject1).IAw);
        ((a)localObject1).is(((a)localObject1).IAx);
        ((a)localObject1).is(((a)localObject1).IAy);
        localObject2 = ((a)localObject1).IAz.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).IAD.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.IFf = ((TextView)findViewById(2131299462));
    this.IFc = ((ConversationListView)findViewById(2131301984));
    this.mtU = findViewById(2131305195);
    this.IFc.setStatusBarMaskView(this.mtU);
    int i;
    int j;
    if (this.IFc != null)
    {
      i = com.tencent.mm.ui.ap.Q(getContext(), -1);
      j = com.tencent.mm.pluginsdk.g.dT(this.IFc.getContext());
      ac.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      localObject1 = new Runnable()
      {
        int gLY = 0;
        
        public final void run()
        {
          AppMethodBeat.i(38620);
          if (MainUI.a(MainUI.this) == null)
          {
            AppMethodBeat.o(38620);
            return;
          }
          int i = com.tencent.mm.ui.ap.Q(MainUI.this.getContext(), -1);
          int j = com.tencent.mm.pluginsdk.g.dT(MainUI.a(MainUI.this).getContext());
          if ((i <= 0) || (j <= 0)) {
            if (this.gLY < 2)
            {
              ac.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
              MainUI.a(MainUI.this).post(this);
              this.gLY += 1;
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.gLY), Integer.valueOf(i) });
            AppMethodBeat.o(38620);
            return;
            ac.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
            break;
            if (i != MainUI.a(MainUI.this).getPaddingTop())
            {
              ac.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(MainUI.a(MainUI.this).getPaddingTop()) });
              MainUI.b(MainUI.this, i);
            }
            else
            {
              ac.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", new Object[] { Integer.valueOf(i) });
            }
          }
        }
      };
      if (i <= 0) {
        this.IFc.post((Runnable)localObject1);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      if (localObject1 != null) {
        break label1556;
      }
      ac.e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
      label351:
      this.IFc.setDrawingCacheEnabled(false);
      this.IFc.setScrollingCacheEnabled(false);
      this.IFe = findViewById(2131296700);
      localObject1 = this.IFc;
      localObject2 = this.IFd;
      localObject3 = this.IFe;
      ((ConversationListView)localObject1).ICp = ((View)localObject2);
      if (((ConversationListView)localObject1).mtL != null) {
        ((ConversationListView)localObject1).mtL.g((View)localObject2, (View)localObject3);
      }
      this.IBS = new i(getContext(), this.IFc, new f.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(196849);
          try
          {
            j = LauncherUI.getInstance().Hlj.getMainTabUI().fgW();
            localIterator = new HashMap(MainUI.b(MainUI.this).ffd()).values().iterator();
            i = 0;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              int j;
              Iterator localIterator;
              int i;
              com.tencent.mm.storage.ap localap;
              ac.printErrStackTrace("MicroMsg.MainUI", localException, "report unread", new Object[0]);
            }
          }
          if (localIterator.hasNext())
          {
            localap = (com.tencent.mm.storage.ap)localIterator.next();
            if (i.k(localap) == 2) {
              i = localap.field_unReadCount + i;
            }
          }
          else
          {
            ac.i("MicroMsg.MainUI", "realUnread %d, showUnread %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (j != i)
            {
              ac.e("MicroMsg.MainUI", "realUnread != showUnread");
              com.tencent.e.h.JZN.aS(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196846);
                  h.fsa();
                  AppMethodBeat.o(196846);
                }
              });
              com.tencent.mm.plugin.report.service.h.wUl.dB(931, 23);
            }
            if (MainUI.b(MainUI.this) != null) {
              MainUI.b(MainUI.this).ghi();
            }
            MainUI.a(MainUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196847);
                MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                ConversationListView localConversationListView;
                if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                {
                  localConversationListView = MainUI.a(MainUI.this);
                  ac.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.muq) });
                  if (!localConversationListView.muq)
                  {
                    localConversationListView.xE(false);
                    if (localConversationListView.ICx != null) {
                      localConversationListView.ICx.setBackgroundColor(ao.aJ(localConversationListView.getContext(), 2130968579));
                    }
                    if (!aj.DT()) {
                      break label176;
                    }
                    localConversationListView.jJ(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
                  }
                }
                for (;;)
                {
                  MainUI.c(MainUI.this).frL();
                  com.tencent.mm.plugin.report.service.g.MI(12);
                  AppMethodBeat.o(196847);
                  return;
                  label176:
                  localConversationListView.jJ(localConversationListView.getResources().getColor(2131100705), localConversationListView.getResources().getColor(2131099885));
                }
              }
            });
            AppMethodBeat.o(196849);
            return;
          }
        }
        
        public final void ffk()
        {
          AppMethodBeat.i(196848);
          com.tencent.mm.plugin.report.service.g.MH(12);
          AppMethodBeat.o(196848);
        }
      });
      this.IBS.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
        {
          AppMethodBeat.i(196850);
          int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(196850);
          return i;
        }
      });
      this.IBS.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(196851);
          MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(196851);
        }
      });
      if (!com.tencent.mm.compatible.util.d.lb(18)) {
        break label1653;
      }
      com.tencent.mm.blink.b.TR().w(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38631);
          MainUI.c(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.d(MainUI.this));
          AppMethodBeat.o(38631);
        }
      });
      label502:
      localObject1 = this.IFi;
      localObject2 = this.IFc;
      localObject3 = this.IBS;
      ((n)localObject1).IAD = ((ListView)localObject2);
      ((n)localObject1).IBS = ((i)localObject3);
      ((ListView)localObject2).setOnScrollListener(((n)localObject1).ftW);
      ((i)localObject3).IBm = ((n)localObject1).ftW;
      com.tencent.mm.sdk.platformtools.ap.f(new n.2((n)localObject1));
      LauncherUI.getInstance().Hlj.getMainTabUI().fgW();
      this.IFc.setAdapter(this.IBS);
      this.IFc.setOnItemClickListener(new f(this.IBS, this.IFc, getActivity()));
      this.IFc.setOnItemLongClickListener(new g(this.IBS, this.IFc, getActivity(), this.qMm));
      this.IFc.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196852);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(196852);
            return false;
            MainUI.this.hideVKB();
            MainUI.e(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.e(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.IFj != null) {
        this.IFc.setActionBarUpdateCallback(this.IFj);
      }
      if (this.mvz != null) {
        this.IFc.setActivity(this.mvz);
      }
      if (this.IFn != null) {
        j(this.IFn.daU, this.IFn.isT, this.IFn.IFv);
      }
      this.IFc.setSelection(0);
      localObject1 = this.IFg;
      localObject2 = getActivity();
      localObject3 = this.IER;
      ((k)localObject1).dgE = ((Activity)localObject2);
      ((k)localObject1).IER = ((a)localObject3);
      ((k)localObject1).IES = this;
      ((k)localObject1).jrI = new WeakReference(localObject2);
      ((k)localObject1).wakeLock = ((PowerManager)ai.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      com.tencent.mm.model.az.agi().a(-1, (com.tencent.mm.ak.g)localObject1);
      ((k)localObject1).IEO = false;
      com.tencent.mm.sdk.b.a.GpY.c(((k)localObject1).IET);
      com.tencent.mm.sdk.b.a.GpY.c(((k)localObject1).IEU);
      localObject2 = new com.tencent.mm.vfs.e(ai.getContext().getFilesDir(), "DBRecoverStarted");
      if (((com.tencent.mm.vfs.e)localObject2).exists())
      {
        com.tencent.mm.plugin.report.e.wTc.g("DBRepair", "Last recovery interrupted.", null);
        ((com.tencent.mm.vfs.e)localObject2).delete();
      }
      ((k)localObject1).IEV = new FLock(com.tencent.mm.vfs.i.k(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(ai.getContext().getFilesDir(), "MMStarted").mUri), true));
      if (!((k)localObject1).IEV.eUy()) {
        break label1675;
      }
      ((k)localObject1).IEV.unlock();
      ac.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((k)localObject1).IEV.lockRead();
      localObject1 = this.IFh;
      localObject2 = this.IBS;
      localObject3 = this.IFc;
      FragmentActivity localFragmentActivity = getActivity();
      ((p)localObject1).IBS = ((i)localObject2);
      ((p)localObject1).dgE = localFragmentActivity;
      ((p)localObject1).IFc = ((ConversationListView)localObject3);
      if (((p)localObject1).oYF == null) {
        ((p)localObject1).oYF = new p.3((p)localObject1, new p.1((p)localObject1));
      }
      if (((p)localObject1).IGt == null) {
        ((p)localObject1).IGt = new p.4((p)localObject1);
      }
      if (((p)localObject1).IGu == null) {
        ((p)localObject1).IGu = new p.5((p)localObject1, (ConversationListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.GpY.c(((p)localObject1).oYF);
      com.tencent.mm.sdk.b.a.GpY.c(((p)localObject1).IGt);
      com.tencent.mm.sdk.b.a.GpY.c(((p)localObject1).IGu);
      ((p)localObject1).nEp = new p.6((p)localObject1);
      Looper.myQueue().addIdleHandler(((p)localObject1).nEp);
      ((ConversationListView)localObject3).post(new p.7((p)localObject1));
      localObject1 = com.tencent.mm.av.o.aFz();
      ac.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.av.b)localObject1).hGn + " to 2131231564");
      ((com.tencent.mm.av.b)localObject1).hGn = 2131231564;
      com.tencent.mm.sdk.b.a.GpY.c(this.IFl);
      com.tencent.mm.sdk.b.a.GpY.c(this.IFm);
      com.tencent.mm.model.az.ayI();
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().a(h.ICD);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awB().a(h.ICD);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().a(this.IBS);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awB().a(this.IBS);
      localObject1 = this.IBS;
      if (((i)localObject1).IBq == null) {
        ((i)localObject1).IBq = new i.3((i)localObject1);
      }
      com.tencent.mm.sdk.b.a.GpY.c(((i)localObject1).IBq);
      this.IBS.IDG = new i.b()
      {
        public final void fsq()
        {
          AppMethodBeat.i(196845);
          MainUI.b(MainUI.this).clearCache();
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().a(MainUI.b(MainUI.this));
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awB().a(MainUI.b(MainUI.this));
          AppMethodBeat.o(196845);
        }
      };
      localObject1 = this.IBS;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cIj() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cIj().add(((i)localObject1).Hsb);
      }
      l = bs.Ap(l);
      com.tencent.mm.model.az.ayM();
      ac.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.DIc) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {
        this.dnN = LauncherUI.getInstance().isInMultiWindowMode();
      }
      this.IFc.postDelayed(new Runnable()
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
      setOnVisibilityChangedListener(this.IFk);
      AppMethodBeat.o(38641);
      return;
      acb(i);
      ac.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.IFc.postDelayed((Runnable)localObject1, 100L);
      break;
      label1556:
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bxX();
      if (!((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bxY()) {
        break label351;
      }
      this.IFd = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).dV(getContext());
      if ((this.IFd == null) || (!(this.ijA instanceof ViewGroup))) {
        break label351;
      }
      ac.i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.IFd.setVisibility(8);
      ((ViewGroup)this.ijA).addView(this.IFd, 0, (ViewGroup.LayoutParams)localObject1);
      break label351;
      label1653:
      this.IER.a(getContext(), this.IFc, this.IFf);
      break label502;
      label1675:
      ac.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void fez()
  {
    AppMethodBeat.i(38645);
    ac.i("MicroMsg.MainUI", "onTabResume");
    long l = bs.eWj();
    fsx();
    com.tencent.mm.blink.b.TR().w(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38622);
        a locala = MainUI.c(MainUI.this);
        if (!locala.IAF)
        {
          locala.IAF = true;
          com.tencent.mm.aj.p.aBh().d(locala);
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.agA().a(locala);
          locala.frL();
        }
        AppMethodBeat.o(38622);
      }
    });
    ac.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(bs.Ap(l)) });
    Object localObject = this.IFh;
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.a((com.tencent.mm.bh.a)localObject);
    }
    com.tencent.mm.sdk.platformtools.ap.f(new p.8((p)localObject));
    o.ke(((p)localObject).dgE);
    if ((((p)localObject).dgE != null) && (((p)localObject).dgE.getIntent() != null) && (((p)localObject).dgE.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      com.tencent.mm.sdk.platformtools.ap.n(new p.9((p)localObject), 500L);
      ((p)localObject).dgE.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dgE;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().setTitleBarDoubleClickListener(((p)localObject).Itm);
    }
    if ((x.getBooleanExtra(((p)localObject).dgE.getIntent(), "Main_ListToTop", false)) && (((p)localObject).IFc != null)) {
      ((p)localObject).IFc.post(new p.2((p)localObject));
    }
    x.b(((p)localObject).dgE.getIntent(), "Main_ListToTop", false);
    localObject = this.IFg;
    int i;
    if (((k)localObject).fts == null) {
      i = -1;
    }
    for (;;)
    {
      ac.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((k)localObject).fsu()) });
      ((k)localObject).fss();
      com.tencent.mm.sdk.platformtools.ap.n(new k.7((k)localObject), 100L);
      if ((com.tencent.mm.model.az.agM()) && (!this.IFg.fsv()))
      {
        com.tencent.mm.sdk.b.a.GpY.a(new vm(), Looper.getMainLooper());
        localObject = new us();
        ((us)localObject).dxs.action = 4;
        com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(196837);
            com.tencent.e.h.JZN.aS(paramAnonymousRunnable);
            AppMethodBeat.o(196837);
          }
        });
      }
      AppMethodBeat.o(38645);
      return;
      if (((k)localObject).fts.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void ffG()
  {
    AppMethodBeat.i(38652);
    ac.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    k localk = this.IFg;
    int i;
    if (localk.fts == null) {
      i = -1;
    }
    for (;;)
    {
      ac.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localk.fsu()) });
      if (localk.wakeLock != null) {
        localk.fss();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      AppMethodBeat.o(38652);
      return;
      if (localk.fts.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void ffH()
  {
    AppMethodBeat.i(38653);
    ac.i("MicroMsg.MainUI", "onTabSwitchOut");
    if (this.IFc != null)
    {
      ConversationListView localConversationListView = this.IFc;
      localConversationListView.frX();
      if (localConversationListView.IBU != null) {
        localConversationListView.IBU.bys();
      }
    }
    AppMethodBeat.o(38653);
  }
  
  public final void fqR()
  {
    AppMethodBeat.i(38639);
    if (this.IBS != null) {
      this.IBS.fqR();
    }
    AppMethodBeat.o(38639);
  }
  
  public final void fsw()
  {
    if (this.IBS != null) {
      this.IBS.uaQ = true;
    }
  }
  
  public final void fsx()
  {
    AppMethodBeat.i(38642);
    if (this.IBS != null) {
      this.IBS.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void fsy()
  {
    AppMethodBeat.i(38643);
    if (this.IBS != null) {
      this.IBS.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void fsz()
  {
    AppMethodBeat.i(38657);
    if ((this.IFc != null) && (this.IFc.byu())) {
      this.IFc.frU();
    }
    AppMethodBeat.o(38657);
  }
  
  public int getLayoutId()
  {
    return 2131494680;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(38634);
    com.tencent.mm.kiss.a.b.ahR();
    this.ijA = com.tencent.mm.kiss.a.b.c(getContext(), 2131494680);
    View localView = this.ijA;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.IFc instanceof ConversationListView))
    {
      this.IFc.j(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.IFn = new a(paramBoolean1, paramBoolean2, paramBoolean3);
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
    this.IER.frL();
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    ac.i("MicroMsg.MainUI", "onDestroy");
    this.IFi.fsH();
    if (this.IFc != null)
    {
      ConversationListView localConversationListView = this.IFc;
      if (localConversationListView.mtL != null) {
        localConversationListView.mtL.onDestroy();
      }
      if (localConversationListView.IBU != null) {
        localConversationListView.IBU.onDestroy();
      }
      if (localConversationListView.ICo != null) {
        localConversationListView.removeCallbacks(localConversationListView.ICo);
      }
      if (localConversationListView.ICn != null) {
        localConversationListView.removeCallbacks(localConversationListView.ICn);
      }
      if (localConversationListView.ICm != null) {
        localConversationListView.removeCallbacks(localConversationListView.ICm);
      }
      if (localConversationListView.ICt != null) {
        localConversationListView.ICt.dead();
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
      if ((this.IFc != null) && (this.IFc.byu()))
      {
        paramKeyEvent = this.IFc;
        ac.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", new Object[] { Long.valueOf(10L), Integer.valueOf(11) });
        if (paramKeyEvent.getFirstVisiblePosition() == 0)
        {
          if (10L <= 0L) {
            break label133;
          }
          if (paramKeyEvent.ICn != null) {
            paramKeyEvent.removeCallbacks(paramKeyEvent.ICn);
          }
          paramKeyEvent.ICn = new ConversationListView.8(paramKeyEvent);
          paramKeyEvent.postDelayed(paramKeyEvent.ICn, 10L);
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
    ac.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    if (this.IFc != null)
    {
      ConversationListView localConversationListView = this.IFc;
      if (localConversationListView.mtL != null) {
        localConversationListView.mtL.onPause();
      }
    }
    AppMethodBeat.o(38636);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38635);
    ac.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    ConversationListView localConversationListView;
    if (this.IFc != null)
    {
      localConversationListView = this.IFc;
      if (localConversationListView.mtL != null) {
        localConversationListView.mtL.onResume();
      }
      if ((localConversationListView.IBU != null) && (localConversationListView.IBU.byv()) && (localConversationListView.mtL.getBottom() < com.tencent.mm.cc.a.fromDPToPix(localConversationListView.getContext(), 100)))
      {
        if (!aj.DT()) {
          break label131;
        }
        localConversationListView.jJ(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
      }
    }
    for (;;)
    {
      if (localConversationListView.IBU != null) {
        localConversationListView.IBU.onResume();
      }
      AppMethodBeat.o(38635);
      return;
      label131:
      localConversationListView.jJ(localConversationListView.getResources().getColor(2131100705), localConversationListView.getResources().getColor(2131099885));
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean IFv;
    boolean daU;
    boolean isT;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.daU = paramBoolean1;
      this.isT = paramBoolean2;
      this.IFv = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */