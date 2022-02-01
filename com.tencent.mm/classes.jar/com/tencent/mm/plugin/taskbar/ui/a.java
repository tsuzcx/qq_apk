package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.b.d;
import com.tencent.mm.plugin.taskbar.ui.b.d.1;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.util.HashMap;
import java.util.Timer;

public final class a
  extends com.tencent.mm.plugin.taskbar.api.b
{
  private int DBe;
  private boolean FSA;
  private boolean FSB;
  private boolean FSC;
  private View FSD;
  private boolean FSE;
  private int FSF;
  private int FSG;
  private int FSH;
  private Runnable FSI;
  private Runnable FSJ;
  private com.tencent.f.i.b FSK;
  private com.tencent.f.i.b FSL;
  private boolean FSM;
  private boolean FSN;
  private boolean FSO;
  private boolean FSP;
  private boolean FSQ;
  private int FSR;
  private boolean FSS;
  private boolean FST;
  private boolean FSU;
  private boolean FSV;
  private boolean FSW;
  private int FSX;
  private int FSY;
  private int FSZ;
  private float FSs;
  private float FSt;
  private int FSu;
  private int FSv;
  private com.tencent.mm.plugin.taskbar.api.a FSw;
  private DynamicBgContainer FSx;
  private DynamicBackgroundGLSurfaceView FSy;
  private View FSz;
  private int FTa;
  private int FTb;
  private com.tencent.mm.plugin.appbrand.widget.c.a FTc;
  private boolean FTd;
  private Runnable FTe;
  private boolean FTf;
  private boolean FTg;
  private boolean FTh;
  private Runnable FTi;
  private PointF FTj;
  private PointF FTk;
  private boolean FTl;
  private Runnable FTm;
  private boolean FTn;
  private GyroView FTo;
  private View FTp;
  private View FTq;
  private boolean FTr;
  private boolean FTs;
  private boolean FTt;
  private int Fgj;
  private View azm;
  private Context mContext;
  private ListView mListView;
  private View nZg;
  private HeaderContainer onh;
  private Vibrator ooM;
  private boolean pJi;
  private int vaf;
  private boolean xbw;
  
  public a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(238118);
    this.FSs = 0.2F;
    this.FSt = 0.05F;
    this.FSu = 0;
    this.FSv = 0;
    this.FSA = true;
    this.FSB = false;
    this.FSC = false;
    this.FSE = true;
    this.FSF = 0;
    this.FSG = 0;
    this.FSH = 0;
    this.FSI = null;
    this.FSJ = null;
    this.FSK = null;
    this.FSL = null;
    this.FSM = false;
    this.FSN = false;
    this.FSO = true;
    this.FSP = false;
    this.FSQ = false;
    this.FSR = 0;
    this.FSS = false;
    this.FST = true;
    this.FSU = true;
    this.FSV = false;
    this.FSW = false;
    this.Fgj = -2;
    this.FSX = 0;
    this.FSY = 0;
    this.FSZ = 0;
    this.FTa = 0;
    this.FTb = 0;
    this.vaf = 0;
    this.FTd = false;
    this.FTf = true;
    this.FTg = false;
    this.FTh = false;
    this.FTj = new PointF();
    this.FTk = new PointF();
    this.pJi = false;
    this.FTl = false;
    this.FTm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238112);
        a.k(a.this);
        AppMethodBeat.o(238112);
      }
    };
    this.FTn = true;
    this.FTr = true;
    this.FTs = false;
    this.FTt = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.onh = paramHeaderContainer;
    this.ooM = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.DBe = (au.eu(this.mContext) + au.getStatusBarHeight(this.mContext));
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238105);
        a.a(a.this, au.eu(a.a(a.this)) + au.getStatusBarHeight(a.a(a.this)));
        Log.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:%d UIUtilsStatusBar:%d WeUIToolHelperStatusBar:%d", new Object[] { Integer.valueOf(a.b(a.this)), Integer.valueOf(ao.getStatusBarHeight(a.a(a.this))), Integer.valueOf(au.getStatusBarHeight(a.a(a.this))) });
        AppMethodBeat.o(238105);
      }
    });
    e.fur();
    this.FSU = e.atB();
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.FSU), Integer.valueOf(this.DBe), Boolean.valueOf(bool) });
    fuH();
    fuI();
    cMc();
    fuz();
    this.FTc = new com.tencent.mm.plugin.appbrand.widget.c.a(this.mContext.getResources().getColor(2131099746), ar.fj(this.mContext.getResources().getColor(2131099679), 60));
    AppMethodBeat.o(238118);
  }
  
  private void aby(int paramInt)
  {
    AppMethodBeat.i(238128);
    Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.nZg != null) && (this.nZg.getVisibility() != paramInt)) {
      this.nZg.setVisibility(paramInt);
    }
    AppMethodBeat.o(238128);
  }
  
  private void cMc()
  {
    AppMethodBeat.i(238120);
    try
    {
      this.FSF = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.FSG = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
      if (this.FSF < this.FSG) {
        this.FSG = 0;
      }
      this.FSH = this.FSF;
      this.FSZ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100);
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.FSF), Integer.valueOf(this.FSH), Integer.valueOf(this.FSZ) });
      AppMethodBeat.o(238120);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(238120);
    }
  }
  
  private void cb(float paramFloat)
  {
    AppMethodBeat.i(238146);
    int j = com.tencent.mm.plugin.taskbar.ui.c.a.d(paramFloat, this.mContext.getResources().getColor(2131099648));
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8())) {
      i = j;
    }
    for (;;)
    {
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(j);
      }
      if (this.FSz != null) {
        this.FSz.setBackgroundColor(i);
      }
      AppMethodBeat.o(238146);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        i = com.tencent.mm.plugin.taskbar.ui.c.a.d(paramFloat, ar.v(this.mContext.getResources().getColor(2131101173), this.mContext.getResources().getColor(2131099648)));
      } else {
        i = j;
      }
    }
  }
  
  private void cc(float paramFloat)
  {
    AppMethodBeat.i(238148);
    Log.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.FTc.aW(1.0F - paramFloat);
    if (this.FSw != null) {
      this.FSw.g(paramFloat, i, i);
    }
    if (this.onh != null) {
      this.onh.ji(i, i);
    }
    AppMethodBeat.o(238148);
  }
  
  private void f(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238147);
    Log.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.taskbar.ui.c.a.d(paramFloat, paramInt1);
    if (this.FSw != null) {
      this.FSw.f(paramFloat, paramInt1, paramInt2);
    }
    if (this.onh != null) {
      this.onh.abx(paramInt1);
    }
    AppMethodBeat.o(238147);
  }
  
  private int fuB()
  {
    AppMethodBeat.i(238124);
    if (this.onh.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(238124);
      return 0;
    }
    int i = this.onh.getBottom();
    int j = this.DBe;
    AppMethodBeat.o(238124);
    return i - j;
  }
  
  private void fuC()
  {
    AppMethodBeat.i(238131);
    this.FTd = true;
    if (this.FTe != null) {
      this.mListView.removeCallbacks(this.FTe);
    }
    ListView localListView = this.mListView;
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238114);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIgnoreInLayout false");
        a.m(a.this);
        AppMethodBeat.o(238114);
      }
    };
    this.FTe = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(238131);
  }
  
  private void fuD()
  {
    AppMethodBeat.i(238134);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: request delayHideBackgroundView %b", new Object[] { Boolean.valueOf(this.FSO) });
    if (this.FSI != null) {
      MMHandlerThread.removeRunnable(this.FSI);
    }
    if (this.FSO)
    {
      Runnable local11 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238117);
          Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: delayHideBackgroundView");
          a.n(a.this);
          AppMethodBeat.o(238117);
        }
      };
      this.FSI = local11;
      MMHandlerThread.postToMainThreadDelayed(local11, 500L);
      AppMethodBeat.o(238134);
      return;
    }
    fuJ();
    AppMethodBeat.o(238134);
  }
  
  private boolean fuE()
  {
    AppMethodBeat.i(238140);
    if ((Math.abs(this.FTk.y - this.FTj.y) <= 5.0F) || (this.FTk.y <= this.FTj.y))
    {
      AppMethodBeat.o(238140);
      return true;
    }
    AppMethodBeat.o(238140);
    return false;
  }
  
  private int fuF()
  {
    AppMethodBeat.i(238141);
    if (this.FSu == 0) {
      this.FSu = ((int)(this.onh.getHeight() * this.FSs));
    }
    int i = this.FSu;
    AppMethodBeat.o(238141);
    return i;
  }
  
  private int fuG()
  {
    AppMethodBeat.i(238142);
    if (this.FSv == 0) {
      this.FSv = ((int)(this.onh.getHeight() * this.FSt));
    }
    int i = this.FSv;
    AppMethodBeat.o(238142);
    return i;
  }
  
  private void fuH()
  {
    this.FTt = true;
    this.FTr = true;
  }
  
  private void fuI()
  {
    AppMethodBeat.i(238143);
    if (this.FTo != null)
    {
      this.FTo.c(0.0F, fuF());
      this.FTo.setTranslationY(0.0F);
    }
    AppMethodBeat.o(238143);
  }
  
  private void fuJ()
  {
    AppMethodBeat.i(238144);
    boolean bool2 = this.FSU;
    if ((e.atB()) && (this.FSy != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.FSU = bool1;
      Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.FSU), Boolean.valueOf(bool2) });
      if ((!this.FSO) || (!fuw())) {
        break;
      }
      AppMethodBeat.o(238144);
      return;
    }
    if (bool2)
    {
      if ((this.FSy != null) && (!this.FSA))
      {
        Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: hideBackgroundView SurfaceView onPause and set GONE");
        this.FSx.ery();
        this.FSA = true;
        this.FSB = true;
        AppMethodBeat.o(238144);
      }
    }
    else if (this.FSy != null)
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: hideBackgroundView SurfaceView set GONE");
      this.FSy.setVisibility(8);
    }
    AppMethodBeat.o(238144);
  }
  
  public final void abu(final int paramInt)
  {
    AppMethodBeat.i(238122);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(fuw()), Integer.valueOf(paramInt) });
    if (this.onh.abw(paramInt))
    {
      AppMethodBeat.o(238122);
      return;
    }
    this.FSQ = true;
    this.pJi = false;
    aby(0);
    if (!fuw())
    {
      wm(false);
      AppMethodBeat.o(238122);
      return;
    }
    this.FTg = true;
    this.mListView.removeCallbacks(this.FTi);
    ListView localListView = this.mListView;
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238110);
        int j = a.c(a.this).getBottom() - a.b(a.this);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(a.c(a.this).getBottom()) });
        int i;
        if (a.g(a.this))
        {
          i = 10;
          a.d(a.this).smoothScrollBy(j, i);
          a.h(a.this);
          a.a(a.this, false);
          if (a.i(a.this) == 0) {
            break label147;
          }
          j = a.i(a.this);
          a.j(a.this);
        }
        for (;;)
        {
          a.a(a.this, j, i);
          AppMethodBeat.o(238110);
          return;
          i = 600;
          break;
          label147:
          j = paramInt;
        }
      }
    };
    this.FTi = local5;
    localListView.post(local5);
    AppMethodBeat.o(238122);
  }
  
  public final void abv(int paramInt)
  {
    AppMethodBeat.i(238135);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "updateScrollOffset %d", new Object[] { Integer.valueOf(paramInt) });
    this.DBe = paramInt;
    AppMethodBeat.o(238135);
  }
  
  public final void ac(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(238126);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.FTi);
    this.mListView.removeCallbacks(this.FSJ);
    this.FTj.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.FTh = false;
    this.FTd = false;
    this.pJi = true;
    AppMethodBeat.o(238126);
  }
  
  public final boolean esy()
  {
    AppMethodBeat.i(238138);
    if ((fuw()) && (this.FSV))
    {
      AppMethodBeat.o(238138);
      return true;
    }
    AppMethodBeat.o(238138);
    return false;
  }
  
  public final boolean fuw()
  {
    AppMethodBeat.i(238139);
    Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo isVisibleHeader bottom: %d, scrollOffset: %d, firstVisiblePosition: %d HeaderOpen:%b", new Object[] { Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.DBe), Integer.valueOf(this.mListView.getFirstVisiblePosition()), Boolean.valueOf(this.FSV) });
    if ((this.onh.getBottom() >= this.DBe + 10) && (this.mListView.getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(238139);
      return true;
    }
    AppMethodBeat.o(238139);
    return false;
  }
  
  public final void fux()
  {
    AppMethodBeat.i(238121);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(fuw()), Boolean.valueOf(this.FSV) });
    if (!fuw())
    {
      AppMethodBeat.o(238121);
      return;
    }
    if ((this.FTr) && (this.FTs)) {
      PlaySound.play(this.mContext, 2131755659, 3);
    }
    this.FTg = true;
    this.FSQ = false;
    this.mListView.removeCallbacks(this.FTi);
    Object localObject = this.mListView;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238109);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
        int i = a.c(a.this).getTop();
        a.d(a.this).smoothScrollBy(i, 600);
        a.e(a.this);
        a.f(a.this);
        AppMethodBeat.o(238109);
      }
    };
    this.FTi = local4;
    ((ListView)localObject).post(local4);
    if (!this.FSU)
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(238121);
      return;
    }
    localObject = com.tencent.mm.plugin.taskbar.ui.a.a.FUZ;
    if (!com.tencent.mm.plugin.taskbar.ui.a.a.fuZ())
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(238121);
      return;
    }
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.FSM), Boolean.valueOf(this.FSN) });
    if ((!this.FSM) && (!this.FSN))
    {
      this.FSM = true;
      if (this.FSK != null) {
        this.FSK.cancel();
      }
      this.FSK = new com.tencent.f.i.b()
      {
        public final String getKey()
        {
          return "MicroMsg.AppBrandDesktopAnimController#startMonitorRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(238106);
          d locald;
          if (!com.tencent.mm.plugin.taskbar.ui.b.c.FVi.hki)
          {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
            ??? = com.tencent.mm.plugin.taskbar.ui.b.c.FVi;
            if (!((com.tencent.mm.plugin.taskbar.ui.b.c)???).hki)
            {
              ((com.tencent.mm.plugin.taskbar.ui.b.c)???).hki = true;
              Log.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { Util.getStack() });
              ((com.tencent.mm.plugin.taskbar.ui.b.c)???).axF().postFrameCallback((Choreographer.FrameCallback)???);
            }
            locald = d.FVl;
          }
          synchronized (locald.hkp)
          {
            if (locald.isRunning)
            {
              Log.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
              a.o(a.this);
              AppMethodBeat.o(238106);
              return;
            }
            if (locald.mTimer != null) {
              locald.mTimer.cancel();
            }
            System.gc();
            locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
            locald.hkn.clear();
            locald.hkn.put(Integer.valueOf(1), new com.tencent.mm.plugin.taskbar.ui.b.a());
            locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
            locald.isRunning = true;
          }
        }
      };
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
      h.RTc.b(this.FSK, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(238121);
  }
  
  public final void fuy()
  {
    AppMethodBeat.i(238132);
    if (this.azm != null)
    {
      this.FSQ = true;
      this.azm.setTranslationY(0.0F);
    }
    AppMethodBeat.o(238132);
  }
  
  public final void fuz()
  {
    AppMethodBeat.i(238119);
    this.vaf = this.mContext.getResources().getColor(2131099648);
    AppMethodBeat.o(238119);
  }
  
  public final int getAnimationScrollOffset()
  {
    return this.FTb;
  }
  
  public final void i(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(238123);
    super.i(paramLong, paramInt, paramBoolean);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.FSJ != null) {
      this.mListView.removeCallbacks(this.FSJ);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238111);
        a.a(a.this, paramBoolean);
        a.this.abu(paramInt);
        AppMethodBeat.o(238111);
      }
    };
    this.FSJ = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(238123);
  }
  
  public final void iE()
  {
    AppMethodBeat.i(238136);
    cMc();
    f(1.0F, this.vaf, 0);
    cb(1.0F);
    this.FST = false;
    AppMethodBeat.o(238136);
  }
  
  public final void o(View paramView1, View paramView2)
  {
    AppMethodBeat.i(238145);
    this.FSx = ((DynamicBgContainer)paramView1);
    if (e.atB())
    {
      this.FSy = ((DynamicBackgroundGLSurfaceView)((com.tencent.mm.plugin.taskbar.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).ho(paramView1.getContext()));
      paramView1 = com.tencent.mm.plugin.multitask.ui.bg.a.erA();
      this.FSy.setColor(paramView1.gRQ, paramView1.gRR, paramView1.gRS, paramView1.gRT, paramView1.gRU);
    }
    if (this.FSy == null) {
      this.FSU = false;
    }
    this.FSD = paramView2;
    this.FSx.setGradientBgView((GradientColorBackgroundView)this.FSD);
    if ((this.FSy != null) && ((this.FSD instanceof GradientColorBackgroundView))) {
      this.FSx.erx();
    }
    AppMethodBeat.o(238145);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(238151);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
    if (this.mListView != null)
    {
      if (this.FSJ != null)
      {
        this.mListView.removeCallbacks(this.FSJ);
        this.FSJ = null;
      }
      if (this.FSI != null)
      {
        this.mListView.removeCallbacks(this.FSI);
        this.FSI = null;
      }
      if (this.FTe != null)
      {
        this.mListView.removeCallbacks(this.FTe);
        this.FTe = null;
      }
    }
    h.RTc.bqo("AppBrandDesktopPerformanceMonitor");
    d.FVl.axH();
    d.FVl.release();
    this.FSM = false;
    if (this.FSy != null)
    {
      DynamicBackgroundGLSurfaceView.b localb = this.FSy.gRw;
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.gRA;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.gRD = 0;
          localb.gRE = 0;
          localb.gRM = false;
          AppMethodBeat.o(238151);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeRelease exception", new Object[0]);
          AppMethodBeat.o(238151);
          return;
        }
      }
    }
    AppMethodBeat.o(238151);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(238150);
    super.onResume();
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", new Object[] { Boolean.valueOf(fuw()), Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.onh.getHeight()), Boolean.valueOf(this.FTf) });
    if ((fuw()) && (this.onh.getBottom() < this.onh.getHeight()))
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
      i(0L, 0, true);
    }
    if (!this.FSV)
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
      wk(true);
      AppMethodBeat.o(238150);
      return;
    }
    if (!this.FTf)
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume not main ui and header open, then close header");
      i(0L, 0, true);
    }
    AppMethodBeat.o(238150);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(238129);
    if ((!this.FTd) && (paramAbsListView.isInLayout()) && (!this.FSQ) && (this.onh.getBottom() < this.onh.getHeight() - 5) && (this.FSV))
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
      abu(0);
      AppMethodBeat.o(238129);
      return;
    }
    if ((this.FTh) && (!this.FTg) && (this.xbw) && (paramInt1 <= 0) && (fuw()))
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      abu(4);
    }
    if ((this.onh != null) && (this.onh.getHeight() != this.FTa))
    {
      this.FTb = ((int)(this.onh.getHeight() * this.FSs) + 60);
      this.FSX = ((int)(this.onh.getHeight() * this.FSs) + 60);
      this.FSY = (this.onh.getHeight() - this.DBe);
      this.FSu = ((int)(this.onh.getHeight() * this.FSs));
      this.FSv = ((int)(this.onh.getHeight() * this.FSt));
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.onh.getHeight()), Integer.valueOf(this.FTa), Integer.valueOf(this.FTb), Integer.valueOf(this.FSX), Integer.valueOf(this.FSY), Integer.valueOf(this.FSu), Integer.valueOf(this.FSv) });
      this.FTa = this.onh.getHeight();
    }
    Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.xbw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.FTh), Integer.valueOf(this.FSX) });
    label814:
    label831:
    int i;
    float f1;
    label986:
    int j;
    label1158:
    Object localObject;
    if ((!this.FTh) && (paramInt1 == 0) && (this.onh != null))
    {
      Log.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.DBe), Integer.valueOf(this.onh.getHeight()), Integer.valueOf(this.onh.getBottom()), Boolean.valueOf(this.FSC) });
      if ((this.FSy != null) || (this.FSD != null))
      {
        if (!this.FSU) {
          break label1315;
        }
        if ((fuw()) && (this.FSA) && (this.FSC))
        {
          this.FSA = false;
          this.FSD.setVisibility(0);
          this.FSx.erz();
          if ((this.FSB) && (this.FSy != null))
          {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
            this.FSy.onResume();
            this.FSB = false;
          }
        }
      }
      if (this.FST) {
        break label1403;
      }
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (com.tencent.mm.compatible.util.g.isMIUIV8())) && (Build.VERSION.SDK_INT >= 21) && (!esy()) && (this.onh != null) && (this.onh.getBottom() <= this.DBe + 20))
      {
        if (this.FSD != null) {
          this.FSD.setVisibility(8);
        }
        if (this.FSy != null)
        {
          this.FSA = true;
          this.FSB = true;
          this.FSx.ery();
        }
      }
      if (fuw()) {
        break label1724;
      }
      this.FTh = true;
      paramInt2 = fuB() - 60;
      Log.i("MicroMsg.AppBrandDesktopAnimController", "checkClose moveUp:%b offset:%d closeLimit:%d", new Object[] { Boolean.valueOf(fuE()), Integer.valueOf(paramInt2), Integer.valueOf(fuG()) });
      if (((this.onh != null) && (this.onh.getBottom() <= 0)) || (!fuE())) {
        break label1696;
      }
      if (paramInt2 >= fuG()) {
        break label1691;
      }
      paramInt2 = 1;
      if ((paramInt2 == 0) || (!this.FSW)) {
        break label1701;
      }
      ax(false, true);
      if (this.FTo == null) {
        this.FTo = ((GyroView)this.onh.findViewById(2131302234));
      }
      if (this.FTp == null) {
        this.FTp = this.onh.findViewById(2131296790);
      }
      if (this.FTq == null) {
        this.FTq = this.onh.findViewById(2131299537);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = fuF();
        paramInt2 = this.onh.getBottom();
        paramInt3 = fuB();
        i = this.FSY - this.FSX;
        f1 = 1.0F * (paramInt3 - this.FSX) / i;
        this.FTp.setAlpha(f1);
        this.FTq.setAlpha(f1);
        if (f1 >= 0.2F) {
          break label1732;
        }
        this.onh.setBlurAlpha(5.0F * f1);
        j = paramInt3 - 60;
        Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.FSX), Integer.valueOf(this.FSY), Boolean.valueOf(this.xbw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.onh.getHeight()), Integer.valueOf(this.FTo.getHeight()) });
        if (((!this.xbw) && (paramInt2 >= 5)) || (this.FSP))
        {
          if (paramInt1 < j) {
            break label1743;
          }
          this.FTo.c(j, paramInt1);
          this.FTo.setAlpha(1.0F);
        }
        f1 = 1.0F * (j - paramInt1) / this.FSZ;
        localObject = this.FTo;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.FTo.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.FTt) && (fuw()) && (!paramAbsListView.isInLayout()))
        {
          this.ooM.vibrate(10L);
          this.FTt = false;
        }
        if (paramInt2 < this.DBe + 10) {
          fuH();
        }
      }
      this.FTl = fuw();
      if ((!fuw()) || (!this.pJi)) {
        break label1756;
      }
      wk(false);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.FTm);
      MMHandlerThread.postToMainThreadDelayed(this.FTm, 60L);
      AppMethodBeat.o(238129);
      return;
      label1315:
      this.FSA = true;
      this.FSB = true;
      if (this.FSy != null)
      {
        this.FSy.setVisibility(8);
        this.FSy.onPause();
      }
      if ((!fuw()) || (this.FSD == null) || ((this.FSD.getVisibility() == 0) && (this.FSD.getAlpha() == 1.0F))) {
        break;
      }
      this.FSD.setAlpha(1.0F);
      this.FSD.setVisibility(0);
      break;
      label1403:
      paramInt3 = fuB();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.FTb) / (this.onh.getMeasuredHeight() - this.DBe - this.FTb)));
      cb(f1);
      i = this.onh.getHeight() - this.DBe - this.FSF;
      j = fuB() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.FSF - this.FSG)));
      Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if ((paramInt3 < this.FTb) || (paramInt3 < this.FSX))
      {
        aby(0);
        f(1.0F, this.vaf, paramInt3);
        cc(1.0F);
      }
      for (;;)
      {
        paramInt3 = paramInt1;
        while (paramInt3 < paramInt1 + paramInt2)
        {
          localObject = paramAbsListView.getChildAt(paramInt3);
          if ((localObject != null) && (paramInt3 != 0)) {
            ((View)localObject).setAlpha(f1);
          }
          paramInt3 += 1;
        }
        break;
        if (f2 >= 0.0F)
        {
          aby(4);
          f(f2, this.mContext.getResources().getColor(2131099949), paramInt3);
          cc(1.0F - f2);
        }
      }
      label1691:
      paramInt2 = 0;
      break label814;
      label1696:
      paramInt2 = 0;
      break label814;
      label1701:
      if ((!this.FTl) || (!this.FSW)) {
        break label831;
      }
      ax(false, true);
      break label831;
      label1724:
      this.FTh = false;
      break label831;
      label1732:
      this.onh.setBlurAlpha(1.0F);
      break label986;
      label1743:
      this.FTo.c(paramInt1, paramInt1);
      break label1158;
      label1756:
      if (!this.FSV) {
        wk(true);
      } else if (this.FSV) {
        wk(false);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(238127);
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(fuE()) });
    this.FSC = true;
    this.Fgj = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.FSW = false;
      if ((this.FTg) && (paramInt == 0))
      {
        Log.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
        this.FTg = false;
        AppMethodBeat.o(238127);
        return;
      }
      int i = fuB() - 60;
      Log.i("MicroMsg.AppBrandDesktopAnimController", "checkOpen moveUp:%b offset:%d openLimit:%d", new Object[] { Boolean.valueOf(fuE()), Integer.valueOf(i), Integer.valueOf(fuF()) });
      if (((this.onh == null) || (this.onh.getBottom() > 0)) && (!fuE())) {
        if (i > fuF()) {
          i = 1;
        }
      }
      while (i != 0)
      {
        fux();
        AppMethodBeat.o(238127);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((fuE()) && (paramInt == -1))
      {
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
        abu(4);
        AppMethodBeat.o(238127);
        return;
      }
      if (paramInt == -1)
      {
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        abu(0);
        this.FSP = true;
        AppMethodBeat.o(238127);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.xbw = true;
        this.FSW = true;
        AppMethodBeat.o(238127);
        return;
      }
      if (paramInt == 1)
      {
        this.xbw = false;
        this.FST = true;
        this.FSW = true;
        if (fuE())
        {
          this.xbw = false;
          this.FSR = 4;
        }
      }
    }
    AppMethodBeat.o(238127);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(238125);
    if (paramMotionEvent.getAction() == 0) {
      ac(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(238125);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.pJi = false;
        this.FTk.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.onh != null) && (this.onh.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (fuE()))
        {
          if (this.FSR == 0) {
            this.FSR = 12;
          }
          Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.FSR) });
        }
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void setActionBar(View paramView)
  {
    this.nZg = paramView;
  }
  
  public final void setActionBarUpdateCallback(com.tencent.mm.plugin.taskbar.api.a parama)
  {
    this.FSw = parama;
  }
  
  public final void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(238149);
    this.FTf = paramBoolean;
    if ((!paramBoolean) && (this.FSV))
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIsCurrentMainUI and header open, close");
      i(0L, 0, true);
    }
    AppMethodBeat.o(238149);
  }
  
  public final void setStatusBarMaskView(View paramView)
  {
    this.FSz = paramView;
  }
  
  public final void setTabView(View paramView)
  {
    this.azm = paramView;
  }
  
  public final void wk(boolean paramBoolean)
  {
    AppMethodBeat.i(238137);
    if ((this.onh.isFullScreen()) && (paramBoolean != this.FTn))
    {
      if (WeChatEnvironment.hasDebugger()) {
        Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.FTn) });
      }
      this.FTn = paramBoolean;
      dq localdq = new dq();
      localdq.dGE.enable = paramBoolean;
      EventCenter.instance.publish(localdq);
    }
    AppMethodBeat.o(238137);
  }
  
  public final void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(238130);
    super.wl(paramBoolean);
    this.FSR = 0;
    this.FSV = true;
    if ((this.FSD != null) && (this.FSD.getVisibility() == 0)) {
      this.FSD.invalidate();
    }
    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.FSQ), Boolean.valueOf(this.FSU) });
    if (this.azm == null)
    {
      AppMethodBeat.o(238130);
      return;
    }
    if (this.FSQ)
    {
      fuy();
      AppMethodBeat.o(238130);
      return;
    }
    if (!fuw())
    {
      Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
      this.azm.setTranslationY(0.0F);
      AppMethodBeat.o(238130);
      return;
    }
    this.azm.animate().translationY(this.azm.getHeight()).setDuration(260L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(238113);
        a.l(a.this).setVisibility(4);
        a.l(a.this).animate().setListener(null);
        AppMethodBeat.o(238113);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    fuC();
    AppMethodBeat.o(238130);
  }
  
  public final void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(238133);
    super.wm(paramBoolean);
    this.FSV = false;
    fuI();
    fuD();
    if (this.azm == null)
    {
      AppMethodBeat.o(238133);
      return;
    }
    this.azm.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.azm.animate().translationY(0.0F);
    if (this.azm.getTranslationY() == 0.0F) {}
    for (long l = 130L;; l = 260L)
    {
      localViewPropertyAnimator.setDuration(l).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(238116);
          a.l(a.this).animate().setListener(null);
          a.l(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(238116);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(238115);
          a.l(a.this).animate().setListener(null);
          a.l(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(238115);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      fuC();
      AppMethodBeat.o(238133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a
 * JD-Core Version:    0.7.0.1
 */