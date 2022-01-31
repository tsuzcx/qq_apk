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
import com.tencent.mm.ai.p;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.q;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainUI
  extends AbstractTabChildActivity.AbStractTabFragment
  implements j.a
{
  private h Ahr;
  private a Ala;
  public ConversationListView All;
  private View Alm;
  private View Aln;
  private TextView Alo;
  private j Alp;
  private d Alq;
  private m Alr;
  private k Als;
  public com.tencent.mm.plugin.appbrand.widget.header.a Alt;
  private com.tencent.mm.ui.i.a Alu;
  private MainUI.a Alv;
  private boolean czT;
  private View iCk;
  private View jbY;
  public MMFragmentActivity jdB;
  private int[] myL;
  
  public MainUI()
  {
    AppMethodBeat.i(34505);
    this.Ala = new a();
    this.Alp = new j();
    this.Alq = new d();
    this.Alr = new m();
    this.Als = new k();
    this.myL = new int[2];
    this.Alu = new MainUI.1(this);
    this.iCk = null;
    this.czT = false;
    AppMethodBeat.o(34505);
  }
  
  private void QD(int paramInt)
  {
    AppMethodBeat.i(34509);
    ab.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.czT) });
    ViewGroup.LayoutParams localLayoutParams = this.All.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    int i;
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      ab.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i <= 0) || (this.czT)) {
        if (this.czT) {
          break label206;
        }
      }
    }
    label206:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.All.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.jbY == null) {
        break label228;
      }
      i = this.jbY.getLayoutParams().height;
      ab.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if ((i > 0) && (!this.czT)) {
        break label228;
      }
      if (this.czT) {
        break;
      }
      this.jbY.getLayoutParams().height = paramInt;
      AppMethodBeat.o(34509);
      return;
    }
    this.jbY.getLayoutParams().height = 0;
    label228:
    AppMethodBeat.o(34509);
  }
  
  public final void Oj(int paramInt)
  {
    AppMethodBeat.i(34516);
    if (this.Ahr != null) {
      this.Ahr.QB(paramInt);
    }
    AppMethodBeat.o(34516);
  }
  
  public final void dAA()
  {
    AppMethodBeat.i(34518);
    ab.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(34518);
  }
  
  public final void dAB()
  {
    AppMethodBeat.i(34519);
    ab.i("MicroMsg.MainUI", "onTabPause");
    com.tencent.mm.blink.b.HP().o(new MainUI.3(this));
    Object localObject = this.Alp;
    if (((j)localObject).wakeLock.isHeld())
    {
      ab.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((j)localObject).wakeLock.release();
    }
    hideVKB();
    localObject = this.Alr;
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.b((com.tencent.mm.bg.a)localObject);
    }
    l.dMZ();
    LauncherUI localLauncherUI = (LauncherUI)((m)localObject).cup;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().av(((m)localObject).AaN);
    }
    dMW();
    AppMethodBeat.o(34519);
  }
  
  public final void dAC()
  {
    AppMethodBeat.i(34520);
    ab.i("MicroMsg.MainUI", "onTabStop");
    AppMethodBeat.o(34520);
  }
  
  public final void dAD()
  {
    AppMethodBeat.i(34521);
    ab.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(aw.RG()) });
    com.tencent.mm.blink.b.HP().o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(154002);
        a locala = MainUI.d(MainUI.this);
        ab.i("MicroMsg.BannerHelper", "destroyBanner");
        a.fE(locala.AgF);
        a.fE(locala.AgG);
        a.fE(locala.AgH);
        a.fE(locala.AgI);
        Iterator localIterator = locala.AgJ.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        aw.b(locala.qwx);
        com.tencent.mm.sdk.b.a.ymk.d(locala.AgL);
        com.tencent.mm.sdk.b.a.ymk.d(locala.AgM);
        if (aw.RG())
        {
          aw.aaz();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(154002);
      }
    });
    Object localObject = this.Alp;
    ((j)localObject).Ale.unlock();
    aw.Rc().b(-1, (com.tencent.mm.ai.f)localObject);
    if (((j)localObject).eeN != null)
    {
      ((j)localObject).eeN.dismiss();
      ((j)localObject).eeN = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(((j)localObject).Alc);
    com.tencent.mm.sdk.b.a.ymk.d(((j)localObject).Ald);
    localObject = this.Alr;
    if (((m)localObject).lfx != null)
    {
      com.tencent.mm.sdk.b.a.ymk.d(((m)localObject).lfx);
      ((m)localObject).lfx = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(((m)localObject).AlP);
    com.tencent.mm.sdk.b.a.ymk.d(((m)localObject).AlQ);
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.b((com.tencent.mm.bg.a)localObject);
    }
    if (aw.RG()) {
      com.tencent.mm.platformtools.ah.aoz();
    }
    localObject = this.Alq;
    com.tencent.mm.sdk.b.a.ymk.d(((d)localObject).Ahu);
    com.tencent.mm.sdk.b.a.ymk.d(((d)localObject).Ahs);
    com.tencent.mm.sdk.b.a.ymk.d(((d)localObject).Aht);
    ((d)localObject).activity = null;
    if ((aw.RG()) && (this.Ahr != null))
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().b(this.Ahr);
      aw.aaz();
      com.tencent.mm.model.c.YA().b(this.Ahr);
    }
    if (this.Ahr != null)
    {
      localObject = this.Ahr;
      if (((h)localObject).AhH != null)
      {
        com.tencent.mm.sdk.b.a.ymk.d(((h)localObject).AhH);
        ((h)localObject).AhH = null;
      }
      this.Ahr.AjS = null;
      localObject = this.Ahr;
      ((h)localObject).AjS = null;
      if (((h)localObject).zte != null)
      {
        ((h)localObject).zte.clear();
        ((h)localObject).zte = null;
      }
      ((com.tencent.mm.ui.f)localObject).qd(true);
      ((h)localObject).dAW();
      ((h)localObject).AjV.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.bzI() != null)) {
        localb.bzI().remove(((h)localObject).zfd);
      }
      ab.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.Alu = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(34521);
  }
  
  public final void dAE() {}
  
  public final void dAF()
  {
    AppMethodBeat.i(34522);
    ab.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(34522);
  }
  
  public final void dAG()
  {
    AppMethodBeat.i(34523);
    ab.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(34523);
  }
  
  public final void dAy()
  {
    AppMethodBeat.i(34513);
    ab.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.aF(4, false);
    }
    ab.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    aw.RO().dtd();
    ab.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.All != null)
    {
      localObject1 = this.Ala;
      if (((a)localObject1).AgN != null)
      {
        ((a)localObject1).fB(((a)localObject1).AgF);
        ((a)localObject1).fB(((a)localObject1).AgG);
        ((a)localObject1).fB(((a)localObject1).AgH);
        ((a)localObject1).fB(((a)localObject1).AgI);
        localObject2 = ((a)localObject1).AgJ.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).AgN.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.Alo = ((TextView)findViewById(2131825887));
    this.All = ((ConversationListView)findViewById(2131825885));
    this.jbY = findViewById(2131825886);
    this.All.setStatusBarMaskView(this.jbY);
    int i;
    int j;
    if (this.All != null)
    {
      i = am.K(getContext(), -1);
      j = com.tencent.mm.pluginsdk.f.di(this.All.getContext());
      ab.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      localObject1 = new MainUI.11(this);
      if (i <= 0) {
        this.All.post((Runnable)localObject1);
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
      if (localObject1 != null) {
        break label1572;
      }
      ab.e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
      label351:
      this.All.setDrawingCacheEnabled(false);
      this.All.setScrollingCacheEnabled(false);
      this.Aln = findViewById(2131825884);
      localObject1 = this.All;
      localObject2 = this.Alm;
      localObject3 = this.Aln;
      ((ConversationListView)localObject1).AiG = ((View)localObject2);
      if (((ConversationListView)localObject1).jbP != null) {
        ((ConversationListView)localObject1).jbP.e((View)localObject2, (View)localObject3);
      }
      this.Ahr = new h(getContext(), this.All, new MainUI.6(this));
      this.Ahr.setGetViewPositionCallback(new MainUI.7(this));
      this.Ahr.setPerformItemClickListener(new MainUI.8(this));
      if (!com.tencent.mm.compatible.util.d.iU(18)) {
        break label1669;
      }
      com.tencent.mm.blink.b.HP().o(new MainUI.9(this));
      label502:
      localObject1 = this.Als;
      localObject2 = this.All;
      localObject3 = this.Ahr;
      ((k)localObject1).AgN = ((ListView)localObject2);
      ((k)localObject1).Ahr = ((h)localObject3);
      ((ListView)localObject2).setOnScrollListener(((k)localObject1).efo);
      ((h)localObject3).AhC = ((k)localObject1).efo;
      al.d(new k.2((k)localObject1));
      this.Alq.aF(getActivity());
      this.All.setAdapter(this.Ahr);
      this.All.setOnItemClickListener(new f(this.Ahr, this.All, getActivity()));
      this.All.setOnItemLongClickListener(new g(this.Ahr, this.All, getActivity(), this.myL));
      this.All.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(154010);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(154010);
            return false;
            MainUI.this.hideVKB();
            MainUI.f(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.f(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.Alt != null) {
        this.All.setActionBarUpdateCallback(this.Alt);
      }
      if (this.jdB != null) {
        this.All.setActivity(this.jdB);
      }
      if (this.Alv != null) {
        g(this.Alv.coy, this.Alv.Aly, this.Alv.Alz);
      }
      this.All.setSelection(0);
      localObject1 = this.Alp;
      localObject2 = getActivity();
      localObject3 = this.Ala;
      ((j)localObject1).cup = ((Activity)localObject2);
      ((j)localObject1).Ala = ((a)localObject3);
      ((j)localObject1).Alb = this;
      ((j)localObject1).gYJ = new WeakReference(localObject2);
      ((j)localObject1).wakeLock = ((PowerManager)((Activity)localObject2).getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      aw.Rc().a(-1, (com.tencent.mm.ai.f)localObject1);
      ((j)localObject1).AkX = false;
      com.tencent.mm.sdk.b.a.ymk.c(((j)localObject1).Alc);
      com.tencent.mm.sdk.b.a.ymk.c(((j)localObject1).Ald);
      localObject2 = new File(com.tencent.mm.sdk.platformtools.ah.getContext().getFilesDir(), "DBRecoverStarted");
      if (((File)localObject2).exists())
      {
        com.tencent.mm.plugin.report.e.qrI.g("DBRepair", "Last recovery interrupted.", null);
        ((File)localObject2).delete();
      }
      ((j)localObject1).Ale = new FLock(new File(com.tencent.mm.sdk.platformtools.ah.getContext().getFilesDir(), "MMStarted"));
      if (!((j)localObject1).Ale.dsq()) {
        break label1691;
      }
      ((j)localObject1).Ale.unlock();
      ab.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((j)localObject1).Ale.lockRead();
      localObject1 = this.Alq;
      localObject2 = this.Ahr;
      localObject3 = this.All;
      FragmentActivity localFragmentActivity = getActivity();
      ((d)localObject1).Ahr = ((h)localObject2);
      ((d)localObject1).AgN = ((ListView)localObject3);
      ((d)localObject1).activity = localFragmentActivity;
      com.tencent.mm.sdk.b.a.ymk.c(((d)localObject1).Ahu);
      com.tencent.mm.sdk.b.a.ymk.c(((d)localObject1).Ahs);
      com.tencent.mm.sdk.b.a.ymk.c(((d)localObject1).Aht);
      localObject1 = this.Alr;
      localObject2 = this.Ahr;
      localObject3 = this.All;
      localFragmentActivity = getActivity();
      ((m)localObject1).Ahr = ((h)localObject2);
      ((m)localObject1).cup = localFragmentActivity;
      ((m)localObject1).All = ((ConversationListView)localObject3);
      if (((m)localObject1).lfx == null) {
        ((m)localObject1).lfx = new m.3((m)localObject1, new m.1((m)localObject1));
      }
      if (((m)localObject1).AlP == null) {
        ((m)localObject1).AlP = new m.4((m)localObject1);
      }
      if (((m)localObject1).AlQ == null) {
        ((m)localObject1).AlQ = new m.5((m)localObject1, (ConversationListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.ymk.c(((m)localObject1).lfx);
      com.tencent.mm.sdk.b.a.ymk.c(((m)localObject1).AlP);
      com.tencent.mm.sdk.b.a.ymk.c(((m)localObject1).AlQ);
      ((m)localObject1).jZm = new m.6((m)localObject1);
      Looper.myQueue().addIdleHandler(((m)localObject1).jZm);
      ((ConversationListView)localObject3).post(new m.7((m)localObject1));
      localObject1 = o.ahE();
      ab.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.at.b)localObject1).fDk + " to 2130838228");
      ((com.tencent.mm.at.b)localObject1).fDk = 2130838228;
      aw.aav();
      aw.aaz();
      com.tencent.mm.model.c.YF().a(this.Ahr);
      aw.aaz();
      com.tencent.mm.model.c.YA().a(this.Ahr);
      localObject1 = this.Ahr;
      if (((h)localObject1).AhH == null) {
        ((h)localObject1).AhH = new h.3((h)localObject1);
      }
      com.tencent.mm.sdk.b.a.ymk.c(((h)localObject1).AhH);
      this.Ahr.AjS = new MainUI.5(this);
      localObject1 = this.Ahr;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).bzI() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).bzI().add(((h)localObject1).zfd);
      }
      l = com.tencent.mm.platformtools.ah.hl(l);
      aw.aaz();
      ab.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.whH) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {
        this.czT = LauncherUI.getInstance().isInMultiWindowMode();
      }
      this.All.postDelayed(new MainUI.12(this), 200L);
      setOnVisibilityChangedListener(this.Alu);
      AppMethodBeat.o(34513);
      return;
      QD(i);
      ab.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.All.postDelayed((Runnable)localObject1, 100L);
      break;
      label1572:
      ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).aOA();
      if (!((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).aOB()) {
        break label351;
      }
      this.Alm = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)localObject1).dk(getContext());
      if ((this.Alm == null) || (!(this.iCk instanceof ViewGroup))) {
        break label351;
      }
      ab.i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      this.Alm.setVisibility(8);
      ((ViewGroup)this.iCk).addView(this.Alm, 0, (ViewGroup.LayoutParams)localObject1);
      break label351;
      label1669:
      this.Ala.a(getContext(), this.All, this.Alo);
      break label502;
      label1691:
      ab.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void dAz()
  {
    AppMethodBeat.i(34517);
    ab.i("MicroMsg.MainUI", "onTabResume");
    long l = com.tencent.mm.platformtools.ah.aoy();
    Object localObject = this.Alq;
    if (((d)localObject).Ahq < 0)
    {
      ab.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", new Object[] { Integer.valueOf(((d)localObject).Ahq) });
      if (((d)localObject).Ahr != null) {
        ((d)localObject).Ahr.dML();
      }
    }
    dMV();
    com.tencent.mm.blink.b.HP().o(new MainUI.2(this));
    ab.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(com.tencent.mm.platformtools.ah.hl(l)) });
    localObject = this.Alr;
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.a((com.tencent.mm.bg.a)localObject);
    }
    al.d(new m.8((m)localObject));
    l.ir(((m)localObject).cup);
    if ((((m)localObject).cup != null) && (((m)localObject).cup.getIntent() != null) && (((m)localObject).cup.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      al.p(new m.9((m)localObject), 500L);
      ((m)localObject).cup.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((m)localObject).cup;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().setTitleBarDoubleClickListener(((m)localObject).AaN);
    }
    if ((w.a(((m)localObject).cup.getIntent(), "Main_ListToTop", false)) && (((m)localObject).All != null)) {
      ((m)localObject).All.post(new m.2((m)localObject));
    }
    w.b(((m)localObject).cup.getIntent(), "Main_ListToTop", false);
    localObject = this.Alp;
    int i;
    if (((j)localObject).eeN == null) {
      i = -1;
    }
    for (;;)
    {
      ab.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((j)localObject).dMR()) });
      ((j)localObject).dMP();
      al.p(new j.7((j)localObject), 100L);
      if ((aw.RG()) && (!this.Alp.dMS()))
      {
        com.tencent.mm.sdk.b.a.ymk.a(new tf(), Looper.getMainLooper());
        localObject = new sn();
        ((sn)localObject).cIP.action = 4;
        com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject, com.tencent.mm.sdk.g.d.ysm.cjN());
      }
      AppMethodBeat.o(34517);
      return;
      if (((j)localObject).eeN.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(34524);
    ab.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    j localj = this.Alp;
    int i;
    if (localj.eeN == null) {
      i = -1;
    }
    for (;;)
    {
      ab.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localj.dMR()) });
      if (localj.wakeLock != null) {
        localj.dMP();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      AppMethodBeat.o(34524);
      return;
      if (localj.eeN.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void dBD()
  {
    AppMethodBeat.i(34525);
    ab.i("MicroMsg.MainUI", "onTabSwitchOut");
    if (this.All != null)
    {
      ConversationListView localConversationListView = this.All;
      localConversationListView.dMz();
      if (localConversationListView.Ail != null) {
        localConversationListView.Ail.aOV();
      }
    }
    AppMethodBeat.o(34525);
  }
  
  public final void dLE()
  {
    AppMethodBeat.i(34511);
    if (this.Ahr != null) {
      this.Ahr.dLE();
    }
    AppMethodBeat.o(34511);
  }
  
  public final void dMT()
  {
    if (this.Ahr != null) {
      this.Ahr.odR = true;
    }
  }
  
  public final void dMU()
  {
    AppMethodBeat.i(34527);
    if (this.Ahr != null)
    {
      this.Ahr.odR = false;
      this.Ahr.dML();
      if (thisActivity() != null) {
        this.Alq.aF(getActivity());
      }
    }
    AppMethodBeat.o(34527);
  }
  
  public final void dMV()
  {
    AppMethodBeat.i(34514);
    if (this.Ahr != null) {
      this.Ahr.onResume();
    }
    AppMethodBeat.o(34514);
  }
  
  public final void dMW()
  {
    AppMethodBeat.i(34515);
    if (this.Ahr != null) {
      this.Ahr.onPause();
    }
    AppMethodBeat.o(34515);
  }
  
  public final void dMX()
  {
    AppMethodBeat.i(156158);
    if ((this.All != null) && (this.All.aOX())) {
      this.All.dMw();
    }
    AppMethodBeat.o(156158);
  }
  
  public final void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(34510);
    if ((this.All instanceof ConversationListView))
    {
      this.All.g(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(34510);
      return;
    }
    this.Alv = new MainUI.a(this, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(34510);
  }
  
  public int getLayoutId()
  {
    return 2130970066;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(34506);
    com.tencent.mm.kiss.a.b.SH();
    this.iCk = com.tencent.mm.kiss.a.b.b(getContext(), 2130970066);
    View localView = this.iCk;
    AppMethodBeat.o(34506);
    return localView;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(34512);
    super.onConfigurationChanged(paramConfiguration);
    this.Ala.dMn();
    AppMethodBeat.o(34512);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34526);
    ab.i("MicroMsg.MainUI", "onDestroy");
    this.Als.dMY();
    if (this.All != null)
    {
      ConversationListView localConversationListView = this.All;
      if (localConversationListView.jbP != null) {
        localConversationListView.jbP.onDestroy();
      }
      if (localConversationListView.Ail != null) {
        localConversationListView.Ail.onDestroy();
      }
      if (localConversationListView.AiF != null) {
        localConversationListView.removeCallbacks(localConversationListView.AiF);
      }
      if (localConversationListView.AiE != null) {
        localConversationListView.removeCallbacks(localConversationListView.AiE);
      }
      if (localConversationListView.AiD != null) {
        localConversationListView.removeCallbacks(localConversationListView.AiD);
      }
      if (localConversationListView.AiK != null) {
        localConversationListView.AiK.dead();
      }
    }
    super.onDestroy();
    AppMethodBeat.o(34526);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(34528);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((this.All != null) && (this.All.aOX()))
      {
        paramKeyEvent = this.All;
        ab.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", new Object[] { Long.valueOf(10L), Integer.valueOf(11) });
        if (paramKeyEvent.getFirstVisiblePosition() == 0)
        {
          if (10L <= 0L) {
            break label133;
          }
          if (paramKeyEvent.AiE != null) {
            paramKeyEvent.removeCallbacks(paramKeyEvent.AiE);
          }
          paramKeyEvent.AiE = new ConversationListView.6(paramKeyEvent);
          paramKeyEvent.postDelayed(paramKeyEvent.AiE, 10L);
        }
        for (;;)
        {
          AppMethodBeat.o(34528);
          return true;
          label133:
          paramKeyEvent.setSelection(0);
        }
      }
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(34528);
      return bool;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(34528);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34508);
    ab.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    if (this.All != null)
    {
      ConversationListView localConversationListView = this.All;
      if (localConversationListView.jbP != null) {
        localConversationListView.jbP.onPause();
      }
    }
    AppMethodBeat.o(34508);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34507);
    ab.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    if (this.All != null)
    {
      ConversationListView localConversationListView = this.All;
      if (localConversationListView.jbP != null) {
        localConversationListView.jbP.onResume();
      }
      if ((localConversationListView.Ail != null) && (localConversationListView.Ail.aOY()) && (localConversationListView.jbP.getBottom() < com.tencent.mm.cb.a.fromDPToPix(localConversationListView.getContext(), 100))) {
        localConversationListView.hK(localConversationListView.getResources().getColor(2131690316), localConversationListView.getResources().getColor(2131689652));
      }
      if (localConversationListView.Ail != null) {
        localConversationListView.Ail.onResume();
      }
    }
    AppMethodBeat.o(34507);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */