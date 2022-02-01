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
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mh.a;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
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
  public MMFragmentActivity Dpx;
  private View FSz;
  private i Qct;
  public ConversationListView QfG;
  private View QfH;
  private View QfI;
  private TextView QfJ;
  private k QfK;
  private p QfL;
  private n QfM;
  public com.tencent.mm.plugin.taskbar.api.a QfN;
  private com.tencent.mm.ui.k.a QfO;
  private IListener QfP;
  IListener QfQ;
  private a QfR;
  private a Qfu;
  private boolean dSv;
  private View jBN;
  private int[] tef;
  
  public MainUI()
  {
    AppMethodBeat.i(38633);
    this.Qfu = new a();
    this.QfK = new k();
    this.QfL = new p();
    this.QfM = new n();
    this.tef = new int[2];
    Log.i("MicroMsg.MainUI", "create mainUI");
    this.QfO = new com.tencent.mm.ui.k.a()
    {
      public final void onFragmentVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38619);
        if (MainUI.a(MainUI.this) != null)
        {
          Object localObject = d.QbK;
          d.Cu(paramAnonymousBoolean);
          localObject = MainUI.a(MainUI.this);
          if (((ConversationListView)localObject).dSv)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo onFragmentVisibilityChanged visible: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            ((ConversationListView)localObject).gVu();
          }
          localObject = d.QbK;
          d.a(MainUI.a(MainUI.this), MainUI.b(MainUI.this), paramAnonymousBoolean, false);
        }
        AppMethodBeat.o(38619);
      }
    };
    this.QfP = new IListener() {};
    this.QfQ = new IListener()
    {
      private final long INTERVAL;
      private long QfV;
      private int QfW;
      private int QfX;
    };
    this.jBN = null;
    this.dSv = false;
    AppMethodBeat.o(38633);
  }
  
  private void lo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234196);
    Log.i("MicroMsg.MainUI", "alvinluo setListMargin isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(this.dSv) });
    ViewGroup.LayoutParams localLayoutParams = this.QfG.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
    }
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      int i = ((RelativeLayout.LayoutParams)localObject).topMargin;
      Log.i("MicroMsg.MainUI", "alvinluo setListMargin origin: %d, topMargin: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      if ((i <= 0) || (this.dSv)) {
        if (this.dSv) {
          break label212;
        }
      }
    }
    label212:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      this.QfG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.FSz == null) {
        break label235;
      }
      paramInt1 = this.FSz.getLayoutParams().height;
      Log.i("MicroMsg.MainUI", "alvinluo setStatusBarMaskView height origin: %d, new: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 > 0) && (!this.dSv)) {
        break label235;
      }
      if (this.dSv) {
        break;
      }
      this.FSz.getLayoutParams().height = paramInt2;
      AppMethodBeat.o(234196);
      return;
    }
    this.FSz.getLayoutParams().height = 0;
    label235:
    AppMethodBeat.o(234196);
  }
  
  public final void alb(int paramInt)
  {
    AppMethodBeat.i(38644);
    if (this.Qct != null) {
      this.Qct.anQ(paramInt);
    }
    AppMethodBeat.o(38644);
  }
  
  public final void atH()
  {
    AppMethodBeat.i(38655);
    if (this.Qct != null)
    {
      this.Qct.yJA = false;
      this.Qct.gVM();
      LauncherUI.getInstance().ODR.getMainTabUI().gJe();
    }
    AppMethodBeat.o(38655);
  }
  
  public final void gGA() {}
  
  public final void gGB()
  {
    AppMethodBeat.i(38650);
    Log.i("MicroMsg.MainUI", "turn to bg");
    AppMethodBeat.o(38650);
  }
  
  public final void gGC()
  {
    AppMethodBeat.i(38651);
    Log.i("MicroMsg.MainUI", "turn to fg");
    AppMethodBeat.o(38651);
  }
  
  public final void gGu()
  {
    AppMethodBeat.i(38641);
    Log.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.bF(4, false);
    }
    Log.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    bg.aAk().setLowPriority();
    Log.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.QfG != null)
    {
      localObject1 = this.Qfu;
      if (((a)localObject1).Qbd != null)
      {
        ((a)localObject1).jR(((a)localObject1).QaV);
        ((a)localObject1).jR(((a)localObject1).QaW);
        ((a)localObject1).jR(((a)localObject1).QaX);
        ((a)localObject1).jR(((a)localObject1).QaY);
        localObject2 = ((a)localObject1).QaZ.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).Qbd.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.QfJ = ((TextView)findViewById(2131300086));
    this.QfG = ((ConversationListView)findViewById(2131304320));
    this.QfG.kq(getContext());
    this.FSz = findViewById(2131308391);
    this.QfG.setStatusBarMaskView(this.FSz);
    final boolean bool;
    int k;
    int j;
    if (this.QfG != null)
    {
      bool = this.QfG.getShowHeaderContainer();
      k = au.D(getContext(), -1);
      j = com.tencent.mm.pluginsdk.h.eu(this.QfG.getContext());
      Log.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d, showHeadrContainer: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) });
      localObject1 = new Runnable()
      {
        int ibG = 0;
        
        public final void run()
        {
          AppMethodBeat.i(38620);
          if (MainUI.a(MainUI.this) == null)
          {
            AppMethodBeat.o(38620);
            return;
          }
          int j = au.D(MainUI.this.getContext(), -1);
          int i = com.tencent.mm.pluginsdk.h.eu(MainUI.a(MainUI.this).getContext());
          if ((j <= 0) || (i <= 0)) {
            if (this.ibG < 2)
            {
              Log.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
              MainUI.a(MainUI.this).post(this);
              this.ibG += 1;
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", new Object[] { Integer.valueOf(this.ibG), Integer.valueOf(j) });
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
      if (k <= 0) {
        this.QfG.post((Runnable)localObject1);
      }
    }
    else
    {
      this.QfH = new DynamicBgContainer(getContext());
      localObject1 = new ViewGroup.LayoutParams(-1, -1);
      ((ViewGroup)this.jBN).addView(this.QfH, 0, (ViewGroup.LayoutParams)localObject1);
      this.QfG.setDrawingCacheEnabled(false);
      this.QfG.setScrollingCacheEnabled(false);
      this.QfI = findViewById(2131296788);
      localObject1 = this.QfG;
      localObject2 = this.QfH;
      localObject3 = this.QfI;
      ((ConversationListView)localObject1).QcS = ((View)localObject2);
      if (((ConversationListView)localObject1).onh != null) {
        ((ConversationListView)localObject1).onh.o((View)localObject2, (View)localObject3);
      }
      this.Qct = new i(getContext(), this.QfG, new f.a()
      {
        public final void bnE()
        {
          AppMethodBeat.i(234192);
          i locali;
          if (MainUI.b(MainUI.this) != null)
          {
            locali = MainUI.b(MainUI.this);
            if ((locali.Pax != null) && (locali.Qep != null) && (!locali.Qep.isEmpty())) {}
          }
          else
          {
            MainUI.a(MainUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(234190);
                try
                {
                  LauncherUI.getInstance().ODR.getMainTabUI().gJe();
                  MainUI.a(MainUI.this, MainUI.b(MainUI.this).getCount());
                  if ((MainUI.b(MainUI.this).getCount() <= 0) && (MainUI.a(MainUI.this) != null))
                  {
                    ConversationListView localConversationListView = MainUI.a(MainUI.this);
                    Log.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", new Object[] { Boolean.valueOf(localConversationListView.FSV) });
                    if (!localConversationListView.FSV)
                    {
                      localConversationListView.Cw(false);
                      if (localConversationListView.Qda != null) {
                        localConversationListView.Qda.setBackgroundColor(localConversationListView.getContext().getResources().getColor(2131099650));
                      }
                      if (!com.tencent.mm.ui.ao.isDarkMode()) {
                        break label207;
                      }
                      localConversationListView.ln(localConversationListView.getResources().getColor(2131100229), localConversationListView.getResources().getColor(2131099904));
                    }
                  }
                  MainUI.c(MainUI.this).gVm();
                  com.tencent.mm.plugin.report.service.g.Wm(12);
                  AppMethodBeat.o(234190);
                  return;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.MainUI", localException, "report unread", new Object[0]);
                    continue;
                    label207:
                    localException.ln(localException.getResources().getColor(2131100898), localException.getResources().getColor(2131099903));
                  }
                }
              }
            });
            AppMethodBeat.o(234192);
            return;
          }
          if (locali.Qeq)
          {
            locali.Pax.clear();
            locali.Qeq = false;
          }
          for (;;)
          {
            locali.Qep.clear();
            break;
            Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(locali.Qep.size()) });
            Iterator localIterator = locali.Qep.iterator();
            while (localIterator.hasNext()) {
              locali.Pax.remove(localIterator.next());
            }
          }
        }
        
        public final void gHg()
        {
          AppMethodBeat.i(234191);
          com.tencent.mm.plugin.report.service.g.Wl(12);
          AppMethodBeat.o(234191);
        }
      });
      bg.aVF();
      com.tencent.mm.model.c.aST().add(this.Qct);
      this.Qct.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(234193);
          int i = MainUI.a(MainUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(234193);
          return i;
        }
      });
      this.Qct.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(234194);
          MainUI.a(MainUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(234194);
        }
      });
      if (!com.tencent.mm.compatible.util.d.oF(18)) {
        break label1646;
      }
      com.tencent.mm.blink.b.ake().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38631);
          MainUI.c(MainUI.this).a(MainUI.this.getContext(), MainUI.a(MainUI.this), MainUI.d(MainUI.this));
          AppMethodBeat.o(38631);
        }
      });
      label568:
      localObject1 = this.QfM;
      localObject2 = this.QfG;
      localObject3 = this.Qct;
      ((n)localObject1).Qbd = ((ListView)localObject2);
      ((n)localObject1).Qct = ((i)localObject3);
      ((ListView)localObject2).setOnScrollListener(((n)localObject1).gup);
      ((i)localObject3).QbN = ((n)localObject1).gup;
      MMHandlerThread.postToMainThread(new n.2((n)localObject1));
      LauncherUI.getInstance().ODR.getMainTabUI().gJe();
      this.QfG.setAdapter(this.Qct);
      this.QfG.setOnItemClickListener(new f(this.Qct, this.QfG, getActivity()));
      this.QfG.setOnItemLongClickListener(new g(this.Qct, this.QfG, getActivity(), this.tef));
      this.QfG.setonDispatchTouchEventListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(234195);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(234195);
            return false;
            MainUI.this.hideVKB();
            MainUI.e(MainUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            MainUI.e(MainUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      if (this.QfN != null) {
        this.QfG.setActionBarUpdateCallback(this.QfN);
      }
      if (this.Dpx != null) {
        this.QfG.setActivity(this.Dpx);
      }
      if (this.QfR != null) {
        q(this.QfR.dEF, this.QfR.jLE, this.QfR.Qgc);
      }
      this.QfG.setSelection(0);
      localObject1 = this.QfK;
      localObject2 = getActivity();
      localObject3 = this.Qfu;
      Log.i("MicroMsg.InitHelper", "onCreate %s", new Object[] { Integer.valueOf(localObject2.hashCode()) });
      ((k)localObject1).dKq = ((Activity)localObject2);
      ((k)localObject1).Qfu = ((a)localObject3);
      ((k)localObject1).Qfv = this;
      ((k)localObject1).kRw = new WeakReference(localObject2);
      ((k)localObject1).wakeLock = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      bg.azz().a(-1, (com.tencent.mm.ak.i)localObject1);
      ((k)localObject1).Qfr = false;
      EventCenter.instance.addListener(((k)localObject1).Qfw);
      EventCenter.instance.addListener(((k)localObject1).Qfx);
      localObject2 = new com.tencent.mm.vfs.o(MMApplicationContext.getContext().getFilesDir(), "DBRecoverStarted");
      if (((com.tencent.mm.vfs.o)localObject2).exists())
      {
        com.tencent.mm.plugin.report.e.Cxv.e("DBRepair", "Last recovery interrupted.", null);
        ((com.tencent.mm.vfs.o)localObject2).delete();
      }
      ((k)localObject1).Qfy = new FLock(s.k(aa.z(new com.tencent.mm.vfs.o(MMApplicationContext.getContext().getFilesDir(), "MMStarted").mUri), true), true);
      if (!((k)localObject1).Qfy.tryLockWrite()) {
        break label1668;
      }
      ((k)localObject1).Qfy.unlock();
      Log.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((k)localObject1).Qfy.lockRead();
      localObject1 = this.QfL;
      localObject2 = this.Qct;
      localObject3 = this.QfG;
      FragmentActivity localFragmentActivity = getActivity();
      ((p)localObject1).Qct = ((i)localObject2);
      ((p)localObject1).dKq = localFragmentActivity;
      ((p)localObject1).QfG = ((ConversationListView)localObject3);
      if (((p)localObject1).qZo == null) {
        ((p)localObject1).qZo = new p.3((p)localObject1, new p.1((p)localObject1));
      }
      if (((p)localObject1).Qhb == null) {
        ((p)localObject1).Qhb = new p.4((p)localObject1);
      }
      if (((p)localObject1).Qhc == null) {
        ((p)localObject1).Qhc = new p.5((p)localObject1, (ConversationListView)localObject3);
      }
      EventCenter.instance.addListener(((p)localObject1).qZo);
      EventCenter.instance.addListener(((p)localObject1).Qhb);
      EventCenter.instance.addListener(((p)localObject1).Qhc);
      ((p)localObject1).pzA = new p.6((p)localObject1);
      Looper.myQueue().addIdleHandler(((p)localObject1).pzA);
      ((ConversationListView)localObject3).post(new p.7((p)localObject1));
      localObject1 = q.bcT();
      Log.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.av.b)localObject1).iWK + " to 2131231628");
      ((com.tencent.mm.av.b)localObject1).iWK = 2131231628;
      EventCenter.instance.addListener(this.QfP);
      EventCenter.instance.addListener(this.QfQ);
      bg.aVB();
      bg.aVF();
      com.tencent.mm.model.c.aST().add(h.Qdi);
      bg.aVF();
      com.tencent.mm.model.c.aSN().add(h.Qdi);
      bg.aVF();
      com.tencent.mm.model.c.aSN().add(this.Qct);
      localObject1 = this.Qct;
      if (((i)localObject1).QbR == null) {
        ((i)localObject1).QbR = new i.3((i)localObject1);
      }
      EventCenter.instance.addListener(((i)localObject1).QbR);
      this.Qct.Qej = new i.b()
      {
        public final void gVP()
        {
          AppMethodBeat.i(234189);
          MainUI.b(MainUI.this).clearCache();
          bg.aVF();
          com.tencent.mm.model.c.aST().add(MainUI.b(MainUI.this));
          bg.aVF();
          com.tencent.mm.model.c.aSN().add(MainUI.b(MainUI.this));
          AppMethodBeat.o(234189);
        }
      };
      localObject1 = this.Qct;
      localObject2 = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.forcenotify.a.b)localObject2).dMm() != null)) {
        ((com.tencent.mm.plugin.forcenotify.a.b)localObject2).dMm().add(((i)localObject1).OLa);
      }
      l = Util.milliSecondsToNow(l);
      bg.aVF();
      Log.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.getUin()), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {
        this.dSv = LauncherUI.getInstance().isInMultiWindowMode();
      }
      this.QfG.postDelayed(new Runnable()
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
      setOnVisibilityChangedListener(this.QfO);
      AppMethodBeat.o(38641);
      return;
      if (bool) {}
      for (int i = 0;; i = j)
      {
        lo(i, k);
        Log.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
        this.QfG.postDelayed((Runnable)localObject1, 100L);
        break;
      }
      label1646:
      this.Qfu.a(getContext(), this.QfG, this.QfJ);
      break label568;
      label1668:
      Log.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(579L, 0L, 1L, true);
    }
  }
  
  public final void gGv()
  {
    AppMethodBeat.i(38645);
    Log.i("MicroMsg.MainUI", "onTabResume");
    long l = Util.nowMilliSecond();
    gVW();
    com.tencent.mm.blink.b.ake().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38622);
        a locala = MainUI.c(MainUI.this);
        if (!locala.Qbf)
        {
          locala.Qbf = true;
          com.tencent.mm.aj.p.aYn().d(locala);
          bg.aVF();
          com.tencent.mm.model.c.azQ().add(locala);
          locala.gVm();
        }
        AppMethodBeat.o(38622);
      }
    });
    Log.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
    Object localObject = this.QfL;
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.a((com.tencent.mm.bh.a)localObject);
    }
    MMHandlerThread.postToMainThread(new p.8((p)localObject));
    o.kr(((p)localObject).dKq);
    if ((((p)localObject).dKq != null) && (((p)localObject).dKq.getIntent() != null) && (((p)localObject).dKq.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      MMHandlerThread.postToMainThreadDelayed(new p.9((p)localObject), 500L);
      ((p)localObject).dKq.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dKq;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().setTitleBarDoubleClickListener(((p)localObject).PTi);
    }
    if ((IntentUtil.getBooleanExtra(((p)localObject).dKq.getIntent(), "Main_ListToTop", false)) && (((p)localObject).QfG != null)) {
      ((p)localObject).QfG.post(new p.2((p)localObject));
    }
    IntentUtil.putExtra(((p)localObject).dKq.getIntent(), "Main_ListToTop", false);
    localObject = this.QfK;
    int i;
    if (((k)localObject).gtM == null) {
      i = -1;
    }
    for (;;)
    {
      Log.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((k)localObject).gVT()) });
      ((k)localObject).gVR();
      MMHandlerThread.postToMainThreadDelayed(new k.7((k)localObject), 100L);
      if ((bg.aAc()) && (!this.QfK.gVU()))
      {
        EventCenter.instance.asyncPublish(new xj(), Looper.getMainLooper());
        localObject = new wp();
        ((wp)localObject).ecH.action = 4;
        EventCenter.instance.asyncPublish((IEvent)localObject, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(234178);
            com.tencent.f.h.RTc.aX(paramAnonymousRunnable);
            AppMethodBeat.o(234178);
          }
        });
      }
      AppMethodBeat.o(38645);
      return;
      if (((k)localObject).gtM.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void gGw()
  {
    AppMethodBeat.i(38646);
    Log.i("MicroMsg.MainUI", "onTabStart");
    AppMethodBeat.o(38646);
  }
  
  public final void gGx()
  {
    AppMethodBeat.i(38647);
    Log.i("MicroMsg.MainUI", "onTabPause");
    if (!com.tencent.mm.ui.ao.gJK())
    {
      com.tencent.mm.blink.b.ake().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234179);
          MainUI.c(MainUI.this).gGx();
          AppMethodBeat.o(234179);
        }
      });
      this.QfK.gGx();
      hideVKB();
      this.QfL.gGx();
      gVX();
    }
    AppMethodBeat.o(38647);
  }
  
  public final void gGy()
  {
    AppMethodBeat.i(38648);
    Log.i("MicroMsg.MainUI", "onTabStop");
    if (com.tencent.mm.ui.ao.gJK())
    {
      com.tencent.mm.blink.b.ake().arrange(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234180);
          MainUI.c(MainUI.this).gGx();
          AppMethodBeat.o(234180);
        }
      });
      this.QfK.gGx();
      hideVKB();
      this.QfL.gGx();
      gVX();
    }
    AppMethodBeat.o(38648);
  }
  
  public final void gGz()
  {
    AppMethodBeat.i(38649);
    Log.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(bg.aAc()) });
    com.tencent.mm.blink.b.ake().arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234181);
        a locala = MainUI.c(MainUI.this);
        Log.i("MicroMsg.BannerHelper", "destroyBanner");
        locala.gGx();
        a.jU(locala.QaV);
        a.jU(locala.QaW);
        a.jU(locala.QaX);
        a.jU(locala.QaY);
        Iterator localIterator = locala.QaZ.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.destroy();
          }
        }
        bg.b(locala.FPE);
        EventCenter.instance.removeListener(locala.Qbb);
        EventCenter.instance.removeListener(locala.Qbc);
        if (bg.aAc())
        {
          bg.aVF();
          com.tencent.mm.model.c.b(locala);
        }
        locala.context = null;
        AppMethodBeat.o(234181);
      }
    });
    Object localObject = this.QfK;
    ((k)localObject).Qfy.unlock();
    bg.azz().b(-1, (com.tencent.mm.ak.i)localObject);
    if (((k)localObject).gtM != null)
    {
      ((k)localObject).gtM.dismiss();
      ((k)localObject).gtM = null;
    }
    EventCenter.instance.removeListener(((k)localObject).Qfw);
    EventCenter.instance.removeListener(((k)localObject).Qfx);
    localObject = this.QfL;
    if (((p)localObject).qZo != null)
    {
      EventCenter.instance.removeListener(((p)localObject).qZo);
      ((p)localObject).qZo = null;
    }
    EventCenter.instance.removeListener(((p)localObject).Qhb);
    EventCenter.instance.removeListener(((p)localObject).Qhc);
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.b((com.tencent.mm.bh.a)localObject);
    }
    if (bg.aAc()) {
      af.blM();
    }
    EventCenter.instance.removeListener(this.QfP);
    EventCenter.instance.removeListener(this.QfQ);
    if (bg.aAc())
    {
      bg.aVF();
      com.tencent.mm.model.c.aST().add(h.Qdi);
      bg.aVF();
      com.tencent.mm.model.c.aSN().add(h.Qdi);
      if (this.Qct != null)
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(this.Qct);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this.Qct);
      }
    }
    if (this.Qct != null)
    {
      localObject = this.Qct;
      if (((i)localObject).QbR != null)
      {
        EventCenter.instance.removeListener(((i)localObject).QbR);
        ((i)localObject).QbR = null;
      }
      this.Qct.Qej = null;
      localObject = this.Qct;
      ((i)localObject).Qej = null;
      if (((i)localObject).Pax != null)
      {
        ((i)localObject).Pax.clear();
        ((i)localObject).Pax = null;
      }
      ((com.tencent.mm.ui.f)localObject).AV(true);
      ((i)localObject).gGV();
      ((i)localObject).Qem.clear();
      com.tencent.mm.plugin.forcenotify.a.b localb = (com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class);
      if ((localb != null) && (localb.dMm() != null)) {
        localb.dMm().remove(((i)localObject).OLa);
      }
      Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
    this.QfO = null;
    setOnVisibilityChangedListener(null);
    AppMethodBeat.o(38649);
  }
  
  public final void gHE()
  {
    AppMethodBeat.i(38652);
    Log.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    k localk = this.QfK;
    int i;
    if (localk.gtM == null) {
      i = -1;
    }
    for (;;)
    {
      Log.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localk.gVT()) });
      if (localk.wakeLock != null) {
        localk.gVR();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      if (this.Qct != null) {
        this.Qct.Qeu = true;
      }
      AppMethodBeat.o(38652);
      return;
      if (localk.gtM.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void gHF()
  {
    AppMethodBeat.i(38653);
    Log.i("MicroMsg.MainUI", "onTabSwitchOut");
    if (this.QfG != null)
    {
      ConversationListView localConversationListView = this.QfG;
      localConversationListView.gVz();
      if (localConversationListView.Qcx != null) {
        localConversationListView.Qcx.fuy();
      }
    }
    if (this.Qct != null) {
      this.Qct.Qeu = false;
    }
    AppMethodBeat.o(38653);
  }
  
  public final void gUq()
  {
    AppMethodBeat.i(38639);
    if (this.Qct != null) {
      this.Qct.gUq();
    }
    AppMethodBeat.o(38639);
  }
  
  public final void gVV()
  {
    if (this.Qct != null) {
      this.Qct.yJA = true;
    }
  }
  
  public final void gVW()
  {
    AppMethodBeat.i(38642);
    if (this.Qct != null) {
      this.Qct.onResume();
    }
    AppMethodBeat.o(38642);
  }
  
  public final void gVX()
  {
    AppMethodBeat.i(38643);
    if (this.Qct != null) {
      this.Qct.onPause();
    }
    AppMethodBeat.o(38643);
  }
  
  public final void gVY()
  {
    AppMethodBeat.i(38657);
    if ((this.QfG != null) && (this.QfG.esy())) {
      this.QfG.gVw();
    }
    AppMethodBeat.o(38657);
  }
  
  public int getLayoutId()
  {
    return 2131495406;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(38634);
    com.tencent.mm.kiss.a.b.aBh();
    this.jBN = com.tencent.mm.kiss.a.b.c(getContext(), 2131495406);
    View localView = this.jBN;
    AppMethodBeat.o(38634);
    return localView;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38640);
    super.onConfigurationChanged(paramConfiguration);
    this.Qfu.gVm();
    AppMethodBeat.o(38640);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38654);
    Log.i("MicroMsg.MainUI", "onDestroy");
    this.QfM.gWg();
    if (this.QfG != null)
    {
      ConversationListView localConversationListView = this.QfG;
      com.tencent.mm.kernel.g.aAi().b(localConversationListView.UuW);
      if (localConversationListView.onh != null) {
        localConversationListView.onh.onDestroy();
      }
      if (localConversationListView.Qcx != null) {
        localConversationListView.Qcx.onDestroy();
      }
      if (localConversationListView.QcR != null) {
        localConversationListView.removeCallbacks(localConversationListView.QcR);
      }
      if (localConversationListView.QcQ != null) {
        localConversationListView.removeCallbacks(localConversationListView.QcQ);
      }
      if (localConversationListView.QcP != null) {
        localConversationListView.removeCallbacks(localConversationListView.QcP);
      }
      if (localConversationListView.QcW != null) {
        localConversationListView.QcW.dead();
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
      if ((this.QfG != null) && (this.QfG.esy()))
      {
        this.QfG.i(10L, 11, false);
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
    if (this.QfG != null)
    {
      ConversationListView localConversationListView = this.QfG;
      if ((localConversationListView.Qcv) && (localConversationListView.onh != null)) {
        localConversationListView.onh.onPause();
      }
    }
    AppMethodBeat.o(38636);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38635);
    Log.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    ConversationListView localConversationListView;
    if (this.QfG != null)
    {
      localConversationListView = this.QfG;
      if ((localConversationListView.Qcv) && (localConversationListView.onh != null)) {
        localConversationListView.onh.onResume();
      }
      if ((localConversationListView.Qcv) && (localConversationListView.Qcx != null) && (localConversationListView.Qcx.fuw()) && (localConversationListView.onh.getBottom() < com.tencent.mm.cb.a.fromDPToPix(localConversationListView.getContext(), 100)))
      {
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
          break label161;
        }
        localConversationListView.ln(localConversationListView.getResources().getColor(2131100229), localConversationListView.getResources().getColor(2131099904));
      }
    }
    for (;;)
    {
      if ((localConversationListView.Qcv) && (localConversationListView.Qcx != null)) {
        localConversationListView.Qcx.onResume();
      }
      localConversationListView.cau();
      localConversationListView.Cv(true);
      AppMethodBeat.o(38635);
      return;
      label161:
      localConversationListView.ln(localConversationListView.getResources().getColor(2131100898), localConversationListView.getResources().getColor(2131099903));
    }
  }
  
  public final void q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38638);
    if ((this.QfG instanceof ConversationListView))
    {
      this.QfG.q(paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(38638);
      return;
    }
    this.QfR = new a(paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(38638);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  final class a
  {
    boolean Qgc;
    boolean dEF;
    boolean jLE;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.dEF = paramBoolean1;
      this.jLE = paramBoolean2;
      this.Qgc = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI
 * JD-Core Version:    0.7.0.1
 */