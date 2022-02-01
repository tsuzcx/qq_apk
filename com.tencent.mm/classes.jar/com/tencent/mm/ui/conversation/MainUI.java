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
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.r;
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
  private i HaU;
  private a HeE;
  public ConversationListView HeP;
  private View HeQ;
  private View HeR;
  private TextView HeS;
  private k HeT;
  private e HeU;
  private p HeV;
  private n HeW;
  public com.tencent.mm.plugin.appbrand.widget.header.a HeX;
  private com.tencent.mm.ui.i.a HeY;
  private a HeZ;
  private boolean dqc;
  private View hIZ;
  private View lRS;
  public MMFragmentActivity lTx;
  private int[] qdJ;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.HeE = new a();
    this.HeT = new k();
    this.HeU = new e();
    this.HeV = new p();
    this.HeW = new n();
    this.qdJ = new int[2];
    this.HeY = new com.tencent.mm.ui.i.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).dqc)
          {
            ad.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).fcc();
          }
          localObject = d.HaQ;
          d.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.hIZ = null;
    this.dqc = false;
    AppMethodBeat.o(38633);
  }
  
  private void ZO(int paramInt)
  {
    AppMethodBeat.i(38637);
    ad.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.dqc) });
    ViewGroup.LayoutParams localLayoutParams = this.HeP.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    int i;
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      ad.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i <= 0) || (this.dqc)) {
        if (this.dqc) {
          break label206;
        }
      }
    }
    label206:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.HeP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.lRS == null) {
        break label228;
      }
      i = this.lRS.getLayoutParams().height;
      ad.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i > 0) && (!this.dqc)) {
        break label228;
      }
      if (this.dqc) {
        break;
      }
      this.lRS.getLayoutParams().height = paramInt;
      AppMethodBeat.o(38637);
      return;
    }
    this.lRS.getLayoutParams().height = 0;
    label228:
    AppMethodBeat.o(38637);
  }
  
  public final void Xp(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.HaU != null) {
      this.HaU.ZM(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final void aal()
  {
    AppMethodBeat.i(38655);
    if (this.HaU != null)
    {
      this.HaU.sSE = false;
      this.HaU.fcs();
      if (thisActivity() != null) {
        this.HeU.bi(getActivity());
      }
    }
    AppMethodBeat.o(38655);
  }
  
  public final void eOU()
  {
    AppMethodBeat.i(38641);
    ad.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.aT(4, false);
    }
    ad.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    az.afE().eFR();
    ad.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.HeP != null)
    {
      localObject1 = this.HeE;
      if (((a)localObject1).Hal != null)
      {
        ((a)localObject1).jdMethod_if(((a)localObject1).Had);
        ((a)localObject1).jdMethod_if(((a)localObject1).Hae);
        ((a)localObject1).jdMethod_if(((a)localObject1).Haf);
        ((a)localObject1).jdMethod_if(((a)localObject1).Hag);
        localObject2 = ((a)localObject1).Hah.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).Hal.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.HeS = ((TextView)findViewById(2131299462));
    this.HeP = ((ConversationListView)findViewById(2131301984));
    this.lRS = findViewById(2131305195);
    this.HeP.setStatusBarMaskView(this.lRS);
    int i;
    int j;
    if (this.HeP != null)
    {
      i = ap.M(getContext(), -1);
      j = com.tencent.mm.pluginsdk.g.dL(this.HeP.getContext());
      ad.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      localObject1 = new Runnable()
      {
        int gll = 0;
        
        public final void run()
        {
          AppMethodBeat.i(38631);
          if (MainUI.a(MainUI.this) == null)
          {
            AppMethodBeat.o(38631);
            return;
          }
          int i = ap.M(MainUI.this.getContext(), -1);
          int j = com.tencent.mm.pluginsdk.g.dL(MainUI.a(MainUI.this).getContext());
          if ((i <= 0) || (j <= 0)) {
            if (this.gll < 2)
            {
              ad.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
              MainUI.a(MainUI.this).post(this);
              this.gll += 1;
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.gll), Integer.valueOf(i) });
            AppMethodBeat.o(38631);
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
        this.HeP.post((Runnable)localObject1);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      if (localObject1 != null) {
        break label1583;
      }
      ad.e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
      label351:
      this.HeP.setDrawingCacheEnabled(false);
      this.HeP.setScrollingCacheEnabled(false);
      this.HeR = findViewById(2131296700);
      localObject1 = this.HeP;
      localObject2 = this.HeQ;
      localObject3 = this.HeR;
      ((ConversationListView)localObject1).Hci = ((View)localObject2);
      if (((ConversationListView)localObject1).lRJ != null) {
        ((ConversationListView)localObject1).lRJ.g((View)localObject2, (View)localObject3);
      }
      this.HaU = new i(getContext(), this.HeP, new f.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(38626);
          MainUI.c(MainUI.this).fbW();
          i locali;
          if (MainUI.b(MainUI.this) != null)
          {
            locali = MainUI.b(MainUI.this);
            if ((locali.GgX != null) && (locali.Hdz != null) && (!locali.Hdz.isEmpty())) {}
          }
          else
          {
            MainUI.a(MainUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(38624);
                MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                ConversationListView localConversationListView;
                if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                {
                  localConversationListView = MainUI.a(MainUI.this);
                  ad.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.lSo) });
                  if (!localConversationListView.lSo)
                  {
                    localConversationListView.wx(false);
                    if (localConversationListView.Hcq != null) {
                      localConversationListView.Hcq.setBackgroundColor(ao.aD(localConversationListView.getContext(), 2130968579));
                    }
                    if (!ai.Eq()) {
                      break label176;
                    }
                    localConversationListView.jx(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
                  }
                }
                for (;;)
                {
                  MainUI.d(MainUI.this).fbU();
                  com.tencent.mm.plugin.report.service.g.KJ(12);
                  AppMethodBeat.o(38624);
                  return;
                  label176:
                  localConversationListView.jx(localConversationListView.getResources().getColor(2131100705), localConversationListView.getResources().getColor(2131099885));
                }
              }
            });
            AppMethodBeat.o(38626);
            return;
          }
          if (locali.HdA)
          {
            locali.GgX.clear();
            locali.HdA = false;
          }
          for (;;)
          {
            locali.Hdz.clear();
            break;
            ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(locali.Hdz.size()) });
            Iterator localIterator = locali.Hdz.iterator();
            while (localIterator.hasNext()) {
              locali.GgX.remove(localIterator.next());
            }
          }
        }
        
        public final void ePF()
        {
          AppMethodBeat.i(38625);
          com.tencent.mm.plugin.report.service.g.KI(12);
          e locale = MainUI.c(MainUI.this);
          locale.HaS = -1;
          locale.HaR.clear();
          if ((locale.HaU == null) || (locale.HaT < 0) || (!locale.HaU.eNX()))
          {
            locale.HaS = 0;
            AppMethodBeat.o(38625);
            return;
          }
          if (locale.HaU.HdA)
          {
            locale.HaS = 0;
            AppMethodBeat.o(38625);
            return;
          }
          if (locale.HaU.Hdy)
          {
            ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
            locale.HaS = 0;
            locale.HaU.Hdy = false;
            AppMethodBeat.o(38625);
            return;
          }
          Object localObject1 = (HashSet)locale.HaU.Hdz.clone();
          ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", new Object[] { Integer.valueOf(((HashSet)localObject1).size()) });
          if (((HashSet)localObject1).contains("floatbottle"))
          {
            locale.HaS = 0;
            AppMethodBeat.o(38625);
            return;
          }
          ((HashSet)localObject1).remove("officialaccounts");
          if (((HashSet)localObject1).isEmpty())
          {
            locale.HaS = 1;
            AppMethodBeat.o(38625);
            return;
          }
          localObject1 = ((HashSet)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            String str = (String)((Iterator)localObject1).next();
            Object localObject2 = locale.HaU;
            boolean bool;
            if (((i)localObject2).aLz(str)) {
              bool = false;
            }
            for (;;)
            {
              if (bool) {
                break label351;
              }
              localObject2 = locale.aLy(str);
              if (localObject2 != null) {
                break label353;
              }
              locale.HaR.put(str, Integer.valueOf(0));
              ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(0) });
              break;
              localObject2 = (i.d)((i)localObject2).GgX.get(str);
              if (localObject2 == null) {
                bool = false;
              } else if (w.pF(str)) {
                bool = ((i.d)localObject2).HbG;
              } else {
                bool = ((i.d)localObject2).HbC;
              }
            }
            label351:
            continue;
            label353:
            locale.HaR.put(str, Integer.valueOf(((ay)localObject2).field_unReadCount));
            ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(((ay)localObject2).field_unReadCount) });
          }
          ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", new Object[] { Integer.valueOf(locale.HaR.size()) });
          if (locale.HaR.isEmpty())
          {
            locale.HaS = 1;
            AppMethodBeat.o(38625);
            return;
          }
          if (locale.HaR.size() > 20)
          {
            locale.HaS = 0;
            AppMethodBeat.o(38625);
            return;
          }
          locale.HaS = 2;
          AppMethodBeat.o(38625);
        }
      });
      this.HaU.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dw(View paramAnonymousView)
        {
          AppMethodBeat.i(38627);
          int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38627);
          return i;
        }
      });
      this.HaU.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38628);
          MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38628);
        }
      });
      if (!com.tencent.mm.compatible.util.d.lh(18)) {
        break label1680;
      }
      com.tencent.mm.blink.b.SX().v(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38629);
          MainUI.d(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.e(MainUI.this));
          AppMethodBeat.o(38629);
        }
      });
      label502:
      localObject1 = this.HeW;
      localObject2 = this.HeP;
      localObject3 = this.HaU;
      ((n)localObject1).Hal = ((ListView)localObject2);
      ((n)localObject1).HaU = ((i)localObject3);
      ((ListView)localObject2).setOnScrollListener(((n)localObject1).fqs);
      ((i)localObject3).Hbf = ((n)localObject1).fqs;
      aq.f(new n.2((n)localObject1));
      this.HeU.bi(getActivity());
      this.HeP.setAdapter(this.HaU);
      this.HeP.setOnItemClickListener(new g(this.HaU, this.HeP, getActivity()));
      this.HeP.setOnItemLongClickListener(new h(this.HaU, this.HeP, getActivity(), this.qdJ));
      this.HeP.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(38630);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(38630);
            return false;
            MainUI.this.hideVKB();
            MainUI.f(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.f(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.HeX != null) {
        this.HeP.setActionBarUpdateCallback(this.HeX);
      }
      if (this.lTx != null) {
        this.HeP.setActivity(this.lTx);
      }
      if (this.HeZ != null) {
        i(this.HeZ.ddw, this.HeZ.hSO, this.HeZ.Hfc);
      }
      this.HeP.setSelection(0);
      localObject1 = this.HeT;
      localObject2 = getActivity();
      localObject3 = this.HeE;
      ((k)localObject1).djj = ((Activity)localObject2);
      ((k)localObject1).HeE = ((a)localObject3);
      ((k)localObject1).HeF = this;
      ((k)localObject1).iRx = new WeakReference(localObject2);
      ((k)localObject1).wakeLock = ((PowerManager)aj.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      az.aeS().a(-1, (com.tencent.mm.al.g)localObject1);
      ((k)localObject1).HeB = false;
      com.tencent.mm.sdk.b.a.ESL.c(((k)localObject1).HeG);
      com.tencent.mm.sdk.b.a.ESL.c(((k)localObject1).HeH);
      localObject2 = new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "DBRecoverStarted");
      if (((com.tencent.mm.vfs.e)localObject2).exists())
      {
        com.tencent.mm.plugin.report.e.vIY.e("DBRepair", "Last recovery interrupted.", null);
        ((com.tencent.mm.vfs.e)localObject2).delete();
      }
      ((k)localObject1).HeI = new FLock(com.tencent.mm.vfs.i.k(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "MMStarted").mUri), true));
      if (!((k)localObject1).HeI.eFe()) {
        break label1702;
      }
      ((k)localObject1).HeI.unlock();
      ad.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((k)localObject1).HeI.lockRead();
      localObject1 = this.HeU;
      localObject2 = this.HaU;
      localObject3 = this.HeP;
      FragmentActivity localFragmentActivity = getActivity();
      ((e)localObject1).HaU = ((i)localObject2);
      ((e)localObject1).Hal = ((ListView)localObject3);
      ((e)localObject1).activity = localFragmentActivity;
      com.tencent.mm.sdk.b.a.ESL.c(((e)localObject1).HaX);
      com.tencent.mm.sdk.b.a.ESL.c(((e)localObject1).HaV);
      com.tencent.mm.sdk.b.a.ESL.c(((e)localObject1).HaW);
      localObject1 = this.HeV;
      localObject2 = this.HaU;
      localObject3 = this.HeP;
      localFragmentActivity = getActivity();
      ((p)localObject1).HaU = ((i)localObject2);
      ((p)localObject1).djj = localFragmentActivity;
      ((p)localObject1).HeP = ((ConversationListView)localObject3);
      if (((p)localObject1).ovf == null) {
        ((p)localObject1).ovf = new p.3((p)localObject1, new p.1((p)localObject1));
      }
      if (((p)localObject1).Hga == null) {
        ((p)localObject1).Hga = new p.4((p)localObject1);
      }
      if (((p)localObject1).Hgb == null) {
        ((p)localObject1).Hgb = new p.5((p)localObject1, (ConversationListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.ESL.c(((p)localObject1).ovf);
      com.tencent.mm.sdk.b.a.ESL.c(((p)localObject1).Hga);
      com.tencent.mm.sdk.b.a.ESL.c(((p)localObject1).Hgb);
      ((p)localObject1).nbI = new p.6((p)localObject1);
      Looper.myQueue().addIdleHandler(((p)localObject1).nbI);
      ((ConversationListView)localObject3).post(new p.7((p)localObject1));
      localObject1 = com.tencent.mm.aw.o.ayH();
      ad.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.aw.b)localObject1).hfK + " to 2131231564");
      ((com.tencent.mm.aw.b)localObject1).hfK = 2131231564;
      az.arR();
      az.arV();
      com.tencent.mm.model.c.apR().a(this.HaU);
      az.arV();
      com.tencent.mm.model.c.apM().a(this.HaU);
      localObject1 = this.HaU;
      if (((i)localObject1).Hbj == null) {
        ((i)localObject1).Hbj = new i.3((i)localObject1);
      }
      com.tencent.mm.sdk.b.a.ESL.c(((i)localObject1).Hbj);
      this.HaU.Hdt = new i.b()
      {
        public final void fcv()
        {
          AppMethodBeat.i(38623);
          MainUI.b(MainUI.this).clearCache();
          az.arV();
          com.tencent.mm.model.c.apR().a(MainUI.b(MainUI.this));
          az.arV();
          com.tencent.mm.model.c.apM().a(MainUI.b(MainUI.this));
          AppMethodBeat.o(38623);
        }
      };
      localObject1 = this.HaU;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cuX() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).cuX().add(((i)localObject1).FSm);
      }
      l = bt.vM(l);
      az.arV();
      ad.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.CpK) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {
        this.dqc = LauncherUI.getInstance().isInMultiWindowMode();
      }
      this.HeP.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38632);
          if (MainUI.this.thisActivity() != null) {
            MainUI.this.thisActivity().supportInvalidateOptionsMenu();
          }
          AppMethodBeat.o(38632);
        }
      }, 200L);
      setOnVisibilityChangedListener(this.HeY);
      AppMethodBeat.o(38641);
      return;
      ZO(i);
      ad.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.HeP.postDelayed((Runnable)localObject1, 100L);
      break;
      label1583:
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bqX();
      if (!((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).bqY()) {
        break label351;
      }
      this.HeQ = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).dN(getContext());
      if ((this.HeQ == null) || (!(this.hIZ instanceof ViewGroup))) {
        break label351;
      }
      ad.i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.HeQ.setVisibility(8);
      ((ViewGroup)this.hIZ).addView(this.HeQ, 0, (ViewGroup.LayoutParams)localObject1);
      break label351;
      label1680:
      this.HeE.a(getContext(), this.HeP, this.HeS);
      break label502;
      label1702:
      ad.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void eOV()
  {
    AppMethodBeat.i(38645);
    ad.i("MicroMsg.MainUI", "onTabResume");
    long l = bt.eGO();
    Object localObject = this.HeU;
    if (((e)localObject).HaT < 0)
    {
      ad.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", new Object[] { Integer.valueOf(((e)localObject).HaT) });
      if (((e)localObject).HaU != null) {
        ((e)localObject).HaU.fcs();
      }
    }
    fcC();
    com.tencent.mm.blink.b.SX().v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38620);
        a locala = MainUI.d(MainUI.this);
        if (!locala.Han)
        {
          locala.Han = true;
          com.tencent.mm.ak.p.auq().d(locala);
          az.arV();
          com.tencent.mm.model.c.afk().a(locala);
          locala.fbU();
        }
        AppMethodBeat.o(38620);
      }
    });
    ad.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(bt.vM(l)) });
    localObject = this.HeV;
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.a((com.tencent.mm.bi.a)localObject);
    }
    aq.f(new p.8((p)localObject));
    o.jT(((p)localObject).djj);
    if ((((p)localObject).djj != null) && (((p)localObject).djj.getIntent() != null) && (((p)localObject).djj.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      aq.n(new p.9((p)localObject), 500L);
      ((p)localObject).djj.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).djj;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().setTitleBarDoubleClickListener(((p)localObject).GTb);
    }
    if ((y.getBooleanExtra(((p)localObject).djj.getIntent(), "Main_ListToTop", false)) && (((p)localObject).HeP != null)) {
      ((p)localObject).HeP.post(new p.2((p)localObject));
    }
    y.b(((p)localObject).djj.getIntent(), "Main_ListToTop", false);
    localObject = this.HeT;
    int i;
    if (((k)localObject).fpP == null) {
      i = -1;
    }
    for (;;)
    {
      ad.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((k)localObject).fcz()) });
      ((k)localObject).fcx();
      aq.n(new k.7((k)localObject), 100L);
      if ((az.afw()) && (!this.HeT.fcA()))
      {
        com.tencent.mm.sdk.b.a.ESL.a(new vc(), Looper.getMainLooper());
        localObject = new ui();
        ((ui)localObject).dzG.action = 4;
        com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(180077);
            com.tencent.e.h.Iye.aP(paramAnonymousRunnable);
            AppMethodBeat.o(180077);
          }
        });
      }
      AppMethodBeat.o(38645);
      return;
      if (((k)localObject).fpP.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void eOW()
  {
    AppMethodBeat.i(38646);
    ad.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void eOX()
  {
    AppMethodBeat.i(38647);
    ad.i("MicroMsg.MainUI", "onTabPause");
    com.tencent.mm.blink.b.SX().v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38622);
        MainUI.d(MainUI.this).eOX();
        AppMethodBeat.o(38622);
      }
    });
    Object localObject = this.HeT;
    if (((k)localObject).wakeLock.isHeld())
    {
      ad.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((k)localObject).wakeLock.release();
    }
    hideVKB();
    localObject = this.HeV;
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.b((com.tencent.mm.bi.a)localObject);
    }
    o.fcN();
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).djj;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aF(((p)localObject).GTb);
    }
    fcD();
    AppMethodBeat.o(38647);
  }
  
  public final void eOY()
  {
    AppMethodBeat.i(38648);
    ad.i("MicroMsg.MainUI", "onTabStop");
    AppMethodBeat.o(38648);
  }
  
  public final void eOZ()
  {
    AppMethodBeat.i(38649);
    ad.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(az.afw()) });
    com.tencent.mm.blink.b.SX().v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180078);
        a locala = MainUI.d(MainUI.this);
        ad.i("MicroMsg.BannerHelper", "destroyBanner");
        locala.eOX();
        a.ii(locala.Had);
        a.ii(locala.Hae);
        a.ii(locala.Haf);
        a.ii(locala.Hag);
        Iterator localIterator = locala.Hah.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        az.b(locala.yIx);
        com.tencent.mm.sdk.b.a.ESL.d(locala.Haj);
        com.tencent.mm.sdk.b.a.ESL.d(locala.Hak);
        if (az.afw())
        {
          az.arV();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(180078);
      }
    });
    Object localObject = this.HeT;
    ((k)localObject).HeI.unlock();
    az.aeS().b(-1, (com.tencent.mm.al.g)localObject);
    if (((k)localObject).fpP != null)
    {
      ((k)localObject).fpP.dismiss();
      ((k)localObject).fpP = null;
    }
    com.tencent.mm.sdk.b.a.ESL.d(((k)localObject).HeG);
    com.tencent.mm.sdk.b.a.ESL.d(((k)localObject).HeH);
    localObject = this.HeV;
    if (((p)localObject).ovf != null)
    {
      com.tencent.mm.sdk.b.a.ESL.d(((p)localObject).ovf);
      ((p)localObject).ovf = null;
    }
    com.tencent.mm.sdk.b.a.ESL.d(((p)localObject).Hga);
    com.tencent.mm.sdk.b.a.ESL.d(((p)localObject).Hgb);
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.b((com.tencent.mm.bi.a)localObject);
    }
    if (az.afw()) {
      ae.aGL();
    }
    localObject = this.HeU;
    com.tencent.mm.sdk.b.a.ESL.d(((e)localObject).HaX);
    com.tencent.mm.sdk.b.a.ESL.d(((e)localObject).HaV);
    com.tencent.mm.sdk.b.a.ESL.d(((e)localObject).HaW);
    ((e)localObject).activity = null;
    if ((az.afw()) && (this.HaU != null))
    {
      az.arV();
      com.tencent.mm.model.c.apR().b(this.HaU);
      az.arV();
      com.tencent.mm.model.c.apM().b(this.HaU);
    }
    if (this.HaU != null)
    {
      localObject = this.HaU;
      if (((i)localObject).Hbj != null)
      {
        com.tencent.mm.sdk.b.a.ESL.d(((i)localObject).Hbj);
        ((i)localObject).Hbj = null;
      }
      this.HaU.Hdt = null;
      localObject = this.HaU;
      ((i)localObject).Hdt = null;
      if (((i)localObject).GgX != null)
      {
        ((i)localObject).GgX.clear();
        ((i)localObject).GgX = null;
      }
      ((f)localObject).vl(true);
      ((i)localObject).ePu();
      ((i)localObject).Hdw.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.cuX() != null)) {
        localb.cuX().remove(((i)localObject).FSm);
      }
      ad.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.HeY = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(38649);
  }
  
  public final void ePa() {}
  
  public final void ePb()
  {
    AppMethodBeat.i(38650);
    ad.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void ePc()
  {
    AppMethodBeat.i(38651);
    ad.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void eQa()
  {
    AppMethodBeat.i(38652);
    ad.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    k localk = this.HeT;
    int i;
    if (localk.fpP == null) {
      i = -1;
    }
    for (;;)
    {
      ad.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localk.fcz()) });
      if (localk.wakeLock != null) {
        localk.fcx();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      AppMethodBeat.o(38652);
      return;
      if (localk.fpP.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void eQb()
  {
    AppMethodBeat.i(38653);
    ad.i("MicroMsg.MainUI", "onTabSwitchOut");
    if (this.HeP != null)
    {
      ConversationListView localConversationListView = this.HeP;
      localConversationListView.fcg();
      if (localConversationListView.HbN != null) {
        localConversationListView.HbN.brs();
      }
    }
    AppMethodBeat.o(38653);
  }
  
  public final void fba()
  {
    AppMethodBeat.i(38639);
    if (this.HaU != null) {
      this.HaU.fba();
    }
    AppMethodBeat.o(38639);
  }
  
  public final void fcB()
  {
    if (this.HaU != null) {
      this.HaU.sSE = true;
    }
  }
  
  public final void fcC()
  {
    AppMethodBeat.i(38642);
    if (this.HaU != null) {
      this.HaU.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void fcD()
  {
    AppMethodBeat.i(38643);
    if (this.HaU != null) {
      this.HaU.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void fcE()
  {
    AppMethodBeat.i(38657);
    if ((this.HeP != null) && (this.HeP.bru())) {
      this.HeP.fcd();
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
    com.tencent.mm.kiss.a.b.agA();
    this.hIZ = com.tencent.mm.kiss.a.b.c(getContext(), 2131494680);
    View localView = this.hIZ;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public final void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.HeP instanceof ConversationListView))
    {
      this.HeP.i(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.HeZ = new a(paramBoolean1, paramBoolean2, paramBoolean3);
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
    this.HeE.fbU();
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    ad.i("MicroMsg.MainUI", "onDestroy");
    this.HeW.fcM();
    if (this.HeP != null)
    {
      ConversationListView localConversationListView = this.HeP;
      if (localConversationListView.lRJ != null) {
        localConversationListView.lRJ.onDestroy();
      }
      if (localConversationListView.HbN != null) {
        localConversationListView.HbN.onDestroy();
      }
      if (localConversationListView.Hch != null) {
        localConversationListView.removeCallbacks(localConversationListView.Hch);
      }
      if (localConversationListView.Hcg != null) {
        localConversationListView.removeCallbacks(localConversationListView.Hcg);
      }
      if (localConversationListView.Hcf != null) {
        localConversationListView.removeCallbacks(localConversationListView.Hcf);
      }
      if (localConversationListView.Hcm != null) {
        localConversationListView.Hcm.dead();
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
      if ((this.HeP != null) && (this.HeP.bru()))
      {
        paramKeyEvent = this.HeP;
        ad.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", new Object[] { Long.valueOf(10L), Integer.valueOf(11) });
        if (paramKeyEvent.getFirstVisiblePosition() == 0)
        {
          if (10L <= 0L) {
            break label133;
          }
          if (paramKeyEvent.Hcg != null) {
            paramKeyEvent.removeCallbacks(paramKeyEvent.Hcg);
          }
          paramKeyEvent.Hcg = new ConversationListView.8(paramKeyEvent);
          paramKeyEvent.postDelayed(paramKeyEvent.Hcg, 10L);
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
    if (this.HeP != null)
    {
      ConversationListView localConversationListView = this.HeP;
      if (localConversationListView.lRJ != null) {
        localConversationListView.lRJ.onPause();
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
    if (this.HeP != null)
    {
      localConversationListView = this.HeP;
      if (localConversationListView.lRJ != null) {
        localConversationListView.lRJ.onResume();
      }
      if ((localConversationListView.HbN != null) && (localConversationListView.HbN.brv()) && (localConversationListView.lRJ.getBottom() < com.tencent.mm.cd.a.fromDPToPix(localConversationListView.getContext(), 100)))
      {
        if (!ai.Eq()) {
          break label131;
        }
        localConversationListView.jx(localConversationListView.getResources().getColor(2131100196), localConversationListView.getResources().getColor(2131099886));
      }
    }
    for (;;)
    {
      if (localConversationListView.HbN != null) {
        localConversationListView.HbN.onResume();
      }
      AppMethodBeat.o(38635);
      return;
      label131:
      localConversationListView.jx(localConversationListView.getResources().getColor(2131100705), localConversationListView.getResources().getColor(2131099885));
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean Hfc;
    boolean ddw;
    boolean hSO;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.ddw = paramBoolean1;
      this.hSO = paramBoolean2;
      this.Hfc = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */