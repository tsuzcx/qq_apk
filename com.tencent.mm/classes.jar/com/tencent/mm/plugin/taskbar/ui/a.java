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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.f.a.dv;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.b.c;
import com.tencent.mm.plugin.taskbar.ui.b.d.1;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  private boolean BNw;
  public int JMP;
  private int LuO;
  public boolean Lue;
  private List<a> MnA;
  public com.tencent.mm.plugin.taskbar.api.a MnB;
  private DynamicBgContainer MnC;
  public View MnD;
  private boolean MnE;
  private boolean MnF;
  private View MnG;
  private int MnH;
  private int MnI;
  private int MnJ;
  public Runnable MnK;
  public Runnable MnL;
  private com.tencent.e.i.b MnM;
  private com.tencent.e.i.b MnN;
  public boolean MnO;
  private boolean MnP;
  private boolean MnQ;
  private boolean MnR;
  private boolean MnS;
  private int MnT;
  private boolean MnU;
  private boolean MnV;
  public boolean MnW;
  private boolean MnX;
  public boolean MnY;
  private boolean MnZ;
  public TaskBarContainer Mnv;
  private float Mnw;
  private float Mnx;
  private int Mny;
  private int Mnz;
  int Moa;
  private int Mob;
  private int Moc;
  private int Mod;
  private com.tencent.mm.plugin.appbrand.widget.d.a Moe;
  private boolean Mof;
  public Runnable Mog;
  public boolean Moh;
  private boolean Moi;
  private boolean Moj;
  private Runnable Mok;
  private int Mol;
  private PointF Mom;
  private PointF Mon;
  private boolean Moo;
  private Runnable Mop;
  private boolean Moq;
  private GyroView Mor;
  private View Mos;
  private AppBrandDesktopContainerView Mot;
  private boolean Mou;
  private boolean Mov;
  private boolean Mow;
  private Context mContext;
  public ListView mListView;
  public View raR;
  private Vibrator rqy;
  public int wYT;
  public View xp;
  
  public a(Context paramContext, ListView paramListView, TaskBarContainer paramTaskBarContainer)
  {
    AppMethodBeat.i(215354);
    this.Mnw = 0.2F;
    this.Mnx = 0.05F;
    this.Mny = 0;
    this.Mnz = 0;
    this.MnA = new LinkedList();
    this.MnE = true;
    this.MnF = false;
    this.MnH = 0;
    this.MnI = 0;
    this.MnJ = 0;
    this.MnK = null;
    this.MnL = null;
    this.MnM = null;
    this.MnN = null;
    this.MnO = false;
    this.MnP = false;
    this.MnQ = true;
    this.MnR = false;
    this.MnS = false;
    this.MnT = 0;
    this.MnU = false;
    this.MnV = true;
    this.MnW = true;
    this.MnX = true;
    this.MnY = false;
    this.MnZ = false;
    this.LuO = -2;
    this.Moa = 0;
    this.Mob = 0;
    this.Moc = 0;
    this.Mod = 0;
    this.wYT = 0;
    this.Mof = false;
    this.Moh = true;
    this.Moi = false;
    this.Moj = false;
    this.Mol = 0;
    this.Mom = new PointF();
    this.Mon = new PointF();
    this.Lue = false;
    this.Moo = false;
    this.Mop = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214688);
        a.j(a.this);
        AppMethodBeat.o(214688);
      }
    };
    this.Moq = true;
    this.Mou = true;
    this.Mov = false;
    this.Mow = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.Mnv = paramTaskBarContainer;
    this.rqy = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.JMP = (ax.ew(this.mContext) + ax.getStatusBarHeight(this.mContext));
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214808);
        a.a(a.this, ax.ew(a.a(a.this)) + ax.getStatusBarHeight(a.a(a.this)));
        Log.i("MicroMsg.TaskBarAnimController", "[run] mScrollOffset:%d UIUtilsStatusBar:%d WeUIToolHelperStatusBar:%d", new Object[] { Integer.valueOf(a.b(a.this)), Integer.valueOf(ar.getStatusBarHeight(a.a(a.this))), Integer.valueOf(ax.getStatusBarHeight(a.a(a.this))) });
        AppMethodBeat.o(214808);
      }
    });
    e.giT();
    this.MnX = e.aAt();
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.MnX), Integer.valueOf(this.JMP), Boolean.valueOf(bool) });
    gjk();
    gjl();
    daP();
    giY();
    this.Moe = new com.tencent.mm.plugin.appbrand.widget.d.a(this.mContext.getResources().getColor(d.a.FG_0), au.fG(this.mContext.getResources().getColor(d.a.BW_100_Alpha_0_8), 60));
    AppMethodBeat.o(215354);
  }
  
  private void aiQ(int paramInt)
  {
    AppMethodBeat.i(215374);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.raR != null) && (this.raR.getVisibility() != paramInt)) {
      this.raR.setVisibility(paramInt);
    }
    AppMethodBeat.o(215374);
  }
  
  private void cl(float paramFloat)
  {
    AppMethodBeat.i(215402);
    Log.d("MicroMsg.TaskBarAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.Moe.aY(1.0F - paramFloat);
    if (this.MnB != null) {
      this.MnB.g(paramFloat, i, i);
    }
    if (this.Mnv != null) {
      this.Mnv.ks(i, i);
    }
    AppMethodBeat.o(215402);
  }
  
  private int gja()
  {
    AppMethodBeat.i(215369);
    if (this.Mnv.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(215369);
      return 0;
    }
    int i = this.Mnv.getBottom();
    int j = this.JMP;
    AppMethodBeat.o(215369);
    return i - j;
  }
  
  private void gjb()
  {
    AppMethodBeat.i(215382);
    this.MnT = 0;
    this.MnY = true;
    if ((this.MnG != null) && (this.MnG.getVisibility() == 0)) {
      this.MnG.invalidate();
    }
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.MnS), Boolean.valueOf(this.MnX) });
    if (this.xp == null)
    {
      AppMethodBeat.o(215382);
      return;
    }
    if (this.MnS)
    {
      gjd();
      AppMethodBeat.o(215382);
      return;
    }
    if (!gjg())
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo onOpen header not visible");
      this.xp.setTranslationY(0.0F);
      AppMethodBeat.o(215382);
      return;
    }
    this.xp.animate().translationY(this.xp.getHeight()).setDuration(260L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(215544);
        a.k(a.this).setVisibility(4);
        a.k(a.this).animate().setListener(null);
        AppMethodBeat.o(215544);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    gjc();
    AppMethodBeat.o(215382);
  }
  
  private void gjc()
  {
    AppMethodBeat.i(215383);
    this.Mof = true;
    if (this.Mog != null) {
      this.mListView.removeCallbacks(this.Mog);
    }
    ListView localListView = this.mListView;
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215302);
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo setIgnoreInLayout false");
        a.l(a.this);
        AppMethodBeat.o(215302);
      }
    };
    this.Mog = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(215383);
  }
  
  private void gje()
  {
    AppMethodBeat.i(215385);
    this.MnY = false;
    gjl();
    gjf();
    if (this.xp == null)
    {
      AppMethodBeat.o(215385);
      return;
    }
    this.xp.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.xp.animate().translationY(0.0F);
    if (this.xp.getTranslationY() == 0.0F) {}
    for (long l = 130L;; l = 260L)
    {
      localViewPropertyAnimator.setDuration(l).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(215678);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(215678);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(215677);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(215677);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      gjc();
      AppMethodBeat.o(215385);
      return;
    }
  }
  
  private void gjf()
  {
    AppMethodBeat.i(215386);
    if (this.MnK != null) {
      MMHandlerThread.removeRunnable(this.MnK);
    }
    if (this.MnQ)
    {
      Runnable local11 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215466);
          Log.i("MicroMsg.TaskBarAnimController", "virbg: delayHideBackgroundView");
          a.m(a.this);
          AppMethodBeat.o(215466);
        }
      };
      this.MnK = local11;
      MMHandlerThread.postToMainThreadDelayed(local11, 500L);
      AppMethodBeat.o(215386);
      return;
    }
    gjm();
    AppMethodBeat.o(215386);
  }
  
  private boolean gjh()
  {
    AppMethodBeat.i(215391);
    if ((Math.abs(this.Mon.y - this.Mom.y) <= 5.0F) || (this.Mon.y <= this.Mom.y))
    {
      AppMethodBeat.o(215391);
      return true;
    }
    AppMethodBeat.o(215391);
    return false;
  }
  
  private int gji()
  {
    AppMethodBeat.i(215392);
    if (this.Mny == 0) {
      this.Mny = ((int)(this.Mnv.getHeight() * this.Mnw));
    }
    int i = this.Mny;
    AppMethodBeat.o(215392);
    return i;
  }
  
  private int gjj()
  {
    AppMethodBeat.i(215394);
    if (this.Mnz == 0) {
      this.Mnz = ((int)(this.Mnv.getHeight() * this.Mnx));
    }
    int i = this.Mnz;
    AppMethodBeat.o(215394);
    return i;
  }
  
  private void gjk()
  {
    this.Mow = true;
    this.Mou = true;
  }
  
  private void gjl()
  {
    AppMethodBeat.i(215395);
    if (this.Mor != null)
    {
      this.Mor.f(0.0F, gji());
      this.Mor.setTranslationY(0.0F);
    }
    AppMethodBeat.o(215395);
  }
  
  private void gjm()
  {
    AppMethodBeat.i(215396);
    boolean bool = this.MnX;
    this.MnX = e.aAt();
    Log.i("MicroMsg.TaskBarAnimController", "virbg: hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.MnX), Boolean.valueOf(bool) });
    if ((this.MnQ) && (gjg()))
    {
      AppMethodBeat.o(215396);
      return;
    }
    if ((bool) && (this.MnX) && (!this.MnE))
    {
      Log.i("MicroMsg.TaskBarAnimController", "virbg: hideBackgroundView SurfaceView onPause and set GONE");
      this.MnC.fbE();
      this.MnE = true;
    }
    AppMethodBeat.o(215396);
  }
  
  public final void DC(final int paramInt)
  {
    AppMethodBeat.i(215360);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(gjg()), Integer.valueOf(paramInt) });
    Object localObject = this.Mnv;
    if ((paramInt == 11) && (((TaskBarContainer)localObject).MoV.cnm())) {
      ((TaskBarContainer)localObject).MoV.cnl();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(215360);
      return;
    }
    this.MnS = true;
    this.Lue = false;
    aiQ(0);
    if (!gjg())
    {
      gje();
      AppMethodBeat.o(215360);
      return;
    }
    this.Moi = true;
    this.mListView.removeCallbacks(this.Mok);
    localObject = this.mListView;
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215039);
        int j = a.c(a.this).getBottom() - a.b(a.this);
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo closeHeader distance: %d, bottom: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(a.c(a.this).getBottom()) });
        int i;
        if (a.f(a.this))
        {
          i = 10;
          a.d(a.this).smoothScrollBy(j, i);
          a.g(a.this);
          a.a(a.this, false);
          if (a.h(a.this) == 0) {
            break label149;
          }
          j = a.h(a.this);
          a.i(a.this);
        }
        for (;;)
        {
          a.this.a(false, false, j, i);
          AppMethodBeat.o(215039);
          return;
          i = 600;
          break;
          label149:
          j = paramInt;
        }
      }
    };
    this.Mok = local5;
    ((ListView)localObject).post(local5);
    AppMethodBeat.o(215360);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(215361);
    if (!this.MnA.contains(parama)) {
      this.MnA.add(parama);
    }
    AppMethodBeat.o(215361);
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215365);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1) });
    Iterator localIterator;
    if (paramBoolean1)
    {
      gjb();
      if ((this.Mol & 0x2) != 0)
      {
        AppMethodBeat.o(215365);
        return;
      }
      this.Mol |= 0x2;
      this.Mol &= 0xFFFFFFFB;
      localIterator = this.MnA.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label218;
      }
      a locala = (a)localIterator.next();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          locala.gjo();
          continue;
          gje();
          if ((this.Mol & 0x4) != 0)
          {
            AppMethodBeat.o(215365);
            return;
          }
          this.Mol |= 0x4;
          this.Mol &= 0xFFFFFFFD;
          break;
        }
        locala.gjn();
        continue;
      }
      if (paramBoolean2) {
        locala.aiS(paramInt1);
      } else {
        locala.kr(paramInt1, paramInt2);
      }
    }
    label218:
    AppMethodBeat.o(215365);
  }
  
  protected final void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215363);
    a(paramBoolean1, paramBoolean2, 0, 0);
    AppMethodBeat.o(215363);
  }
  
  public final void aiR(int paramInt)
  {
    AppMethodBeat.i(215387);
    Log.i("MicroMsg.TaskBarAnimController", "updateScrollOffset %d", new Object[] { Integer.valueOf(paramInt) });
    this.JMP = paramInt;
    AppMethodBeat.o(215387);
  }
  
  public final void al(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215371);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.Mok);
    this.mListView.removeCallbacks(this.MnL);
    this.Mom.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.Moj = false;
    this.Mof = false;
    this.Lue = true;
    AppMethodBeat.o(215371);
  }
  
  public final void ck(float paramFloat)
  {
    AppMethodBeat.i(215399);
    int j = com.tencent.mm.plugin.taskbar.ui.c.a.g(paramFloat, this.mContext.getResources().getColor(d.a.BG_0));
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!g.isMIUIV8())) {
      i = j;
    }
    for (;;)
    {
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(j);
      }
      if (this.MnD != null) {
        this.MnD.setBackgroundColor(i);
      }
      AppMethodBeat.o(215399);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        i = com.tencent.mm.plugin.taskbar.ui.c.a.g(paramFloat, au.A(this.mContext.getResources().getColor(a.d.statusbar_fg_drak_color), this.mContext.getResources().getColor(d.a.BG_0)));
      } else {
        i = j;
      }
    }
  }
  
  public final void daP()
  {
    AppMethodBeat.i(215357);
    try
    {
      this.MnH = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.MnI = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 16);
      if (this.MnH < this.MnI) {
        this.MnI = 0;
      }
      this.MnJ = this.MnH;
      this.Moc = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 100);
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.MnH), Integer.valueOf(this.MnJ), Integer.valueOf(this.Moc) });
      AppMethodBeat.o(215357);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(215357);
    }
  }
  
  public final void f(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215400);
    Log.d("MicroMsg.TaskBarAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.taskbar.ui.c.a.g(paramFloat, paramInt1);
    if (this.MnB != null) {
      this.MnB.f(paramFloat, paramInt1, paramInt2);
    }
    if (this.Mnv != null) {
      this.Mnv.aiV(paramInt1);
    }
    AppMethodBeat.o(215400);
  }
  
  public final boolean fcH()
  {
    AppMethodBeat.i(215389);
    if ((gjg()) && (this.MnY))
    {
      AppMethodBeat.o(215389);
      return true;
    }
    AppMethodBeat.o(215389);
    return false;
  }
  
  public final void giY()
  {
    AppMethodBeat.i(215356);
    this.wYT = this.mContext.getResources().getColor(d.a.BG_0);
    AppMethodBeat.o(215356);
  }
  
  public final void giZ()
  {
    AppMethodBeat.i(215358);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(gjg()), Boolean.valueOf(this.MnY) });
    if (!gjg())
    {
      AppMethodBeat.o(215358);
      return;
    }
    if ((this.Mou) && (this.Mov)) {
      PlaySound.play(this.mContext, d.g.app_brand_recent_view_down_sound_path, 3);
    }
    this.Moi = true;
    this.MnS = false;
    this.mListView.removeCallbacks(this.Mok);
    Object localObject = this.mListView;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215118);
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo doOpenHeader");
        int i = a.c(a.this).getTop();
        a.d(a.this).smoothScrollBy(i, 600);
        a.e(a.this);
        a.this.aJ(true, false);
        AppMethodBeat.o(215118);
      }
    };
    this.Mok = local4;
    ((ListView)localObject).post(local4);
    if (!this.MnX)
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(215358);
      return;
    }
    localObject = com.tencent.mm.plugin.taskbar.ui.a.a.Mqu;
    if (!com.tencent.mm.plugin.taskbar.ui.a.a.gjX())
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(215358);
      return;
    }
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.MnO), Boolean.valueOf(this.MnP) });
    if ((!this.MnO) && (!this.MnP))
    {
      this.MnO = true;
      if (this.MnM != null) {
        this.MnM.cancel();
      }
      this.MnM = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "MicroMsg.TaskBarAnimController#startMonitorRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(215005);
          com.tencent.mm.plugin.taskbar.ui.b.d locald;
          if (!c.MqD.jVR)
          {
            Log.i("MicroMsg.TaskBarAnimController", "alvinluo doStart performanceMonitor");
            ??? = c.MqD;
            if (!((c)???).jVR)
            {
              ((c)???).jVR = true;
              Log.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { Util.getStack() });
              ((c)???).aEX().postFrameCallback((Choreographer.FrameCallback)???);
            }
            locald = com.tencent.mm.plugin.taskbar.ui.b.d.MqG;
          }
          synchronized (locald.jVY)
          {
            if (locald.isRunning)
            {
              Log.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
              a.n(a.this);
              AppMethodBeat.o(215005);
              return;
            }
            if (locald.FpU != null) {
              locald.FpU.cancel(false);
            }
            System.gc();
            locald.jVW.clear();
            locald.jVW.put(Integer.valueOf(1), new com.tencent.mm.plugin.taskbar.ui.b.a());
            locald.FpU = h.ZvG.b(new d.1(locald), 0L, 5L);
            locald.isRunning = true;
          }
        }
      };
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo execute startMonitorRunnable");
      h.ZvG.d(this.MnM, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(215358);
  }
  
  public final void gjd()
  {
    AppMethodBeat.i(215384);
    if (this.xp != null)
    {
      this.MnS = true;
      this.xp.setTranslationY(0.0F);
    }
    AppMethodBeat.o(215384);
  }
  
  public final boolean gjg()
  {
    AppMethodBeat.i(215390);
    Log.v("MicroMsg.TaskBarAnimController", "alvinluo isVisibleHeader bottom: %d, scrollOffset: %d, firstVisiblePosition: %d HeaderOpen:%b", new Object[] { Integer.valueOf(this.Mnv.getBottom()), Integer.valueOf(this.JMP), Integer.valueOf(this.mListView.getFirstVisiblePosition()), Boolean.valueOf(this.MnY) });
    if ((this.Mnv.getBottom() >= this.JMP + 10) && (this.mListView.getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(215390);
      return true;
    }
    AppMethodBeat.o(215390);
    return false;
  }
  
  public final void i(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(215368);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.MnL != null) {
      this.mListView.removeCallbacks(this.MnL);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214380);
        a.a(a.this, paramBoolean);
        a.this.DC(paramInt);
        AppMethodBeat.o(214380);
      }
    };
    this.MnL = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(215368);
  }
  
  public final void o(View paramView1, View paramView2)
  {
    AppMethodBeat.i(215397);
    Log.i("MicroMsg.TaskBarAnimController", "setBackgroundView");
    this.MnC = ((DynamicBgContainer)paramView1);
    this.MnX = e.aAt();
    this.MnG = paramView2;
    this.MnC.setGradientBgView((GradientColorBackgroundView)this.MnG);
    AppMethodBeat.o(215397);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(215379);
    if ((!this.Mof) && (paramAbsListView.isInLayout()) && (!this.MnS) && (this.Mnv.getBottom() < this.Mnv.getHeight() - 5) && (this.MnY))
    {
      Log.i("MicroMsg.TaskBarAnimController", "isInLayout");
      DC(0);
      AppMethodBeat.o(215379);
      return;
    }
    if ((this.Moj) && (!this.Moi) && (this.BNw) && (paramInt1 <= 0) && (gjg()))
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      DC(4);
    }
    if ((this.Mnv != null) && (this.Mnv.getHeight() != this.Mod))
    {
      this.Moa = ((int)(this.Mnv.getHeight() * this.Mnw) + 60);
      this.Mob = (this.Mnv.getHeight() - this.JMP);
      this.Mny = ((int)(this.Mnv.getHeight() * this.Mnw));
      this.Mnz = ((int)(this.Mnv.getHeight() * this.Mnx));
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.Mnv.getHeight()), Integer.valueOf(this.Mod), Integer.valueOf(this.Moa), Integer.valueOf(this.Mob), Integer.valueOf(this.Mny), Integer.valueOf(this.Mnz) });
      this.Mod = this.Mnv.getHeight();
    }
    Log.v("MicroMsg.TaskBarAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.BNw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.Moj), Integer.valueOf(this.Moa) });
    label742:
    label759:
    int i;
    float f1;
    Object localObject;
    label927:
    int j;
    if ((!this.Moj) && (paramInt1 == 0) && (this.Mnv != null))
    {
      Log.d("MicroMsg.TaskBarAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(this.Mnv.getBottom()), Integer.valueOf(this.JMP), Integer.valueOf(this.Mnv.getHeight()), Integer.valueOf(this.Mnv.getBottom()), Boolean.valueOf(this.MnF) });
      if ((this.MnX) || (this.MnG != null))
      {
        if (!this.MnX) {
          break label1256;
        }
        if ((gjg()) && (this.MnE) && (this.MnF))
        {
          this.MnE = false;
          this.MnG.setVisibility(0);
          this.MnC.fbF();
        }
      }
      if (this.MnW) {
        break label1316;
      }
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (g.isMIUIV8())) && (Build.VERSION.SDK_INT >= 21) && (!fcH()) && (this.Mnv != null) && (this.Mnv.getBottom() <= this.JMP + 20))
      {
        if (this.MnG != null) {
          this.MnG.setVisibility(8);
        }
        if (this.MnX)
        {
          this.MnE = true;
          this.MnC.fbE();
        }
      }
      if (gjg()) {
        break label1682;
      }
      this.Moj = true;
      paramInt2 = gja() - 60;
      Log.i("MicroMsg.TaskBarAnimController", "checkClose moveUp:%b offset:%d closeLimit:%d", new Object[] { Boolean.valueOf(gjh()), Integer.valueOf(paramInt2), Integer.valueOf(gjj()) });
      if (((this.Mnv != null) && (this.Mnv.getBottom() <= 0)) || (!gjh())) {
        break label1654;
      }
      if (paramInt2 >= gjj()) {
        break label1649;
      }
      paramInt2 = 1;
      if ((paramInt2 == 0) || (!this.MnZ)) {
        break label1659;
      }
      aJ(false, true);
      if (this.Mor == null) {
        this.Mor = ((GyroView)this.Mnv.findViewById(d.d.gyro_view));
      }
      if (this.Mos == null) {
        this.Mos = this.Mnv.findViewById(d.d.app_brand_desktop_root_layout);
      }
      if (this.Mot == null) {
        this.Mot = this.Mnv.getDesktopContainerView();
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = gji();
        paramInt2 = this.Mnv.getBottom();
        paramInt3 = gja();
        i = this.Mob - this.Moa;
        f1 = 1.0F * (paramInt3 - this.Moa) / i;
        this.Mos.setAlpha(f1);
        localObject = this.Mot;
        if (!((AppBrandDesktopContainerView)localObject).isAnimating)
        {
          ((AppBrandDesktopContainerView)localObject).rpp.setAlpha(f1);
          if (f1 >= 0.2F) {
            break label1690;
          }
          ((AppBrandDesktopContainerView)localObject).rpq.setAlpha(5.0F * f1);
        }
        j = paramInt3 - 60;
        Log.v("MicroMsg.TaskBarAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.Moa), Integer.valueOf(this.Mob), Boolean.valueOf(this.BNw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.Mnv.getHeight()), Integer.valueOf(this.Mor.getHeight()) });
        if (((!this.BNw) && (paramInt2 >= 5)) || (this.MnR))
        {
          if (paramInt1 < j) {
            break label1702;
          }
          this.Mor.f(j, paramInt1);
          this.Mor.setAlpha(1.0F);
        }
        label1099:
        f1 = 1.0F * (j - paramInt1) / this.Moc;
        localObject = this.Mor;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.Mor.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.Mow) && (gjg()) && (!paramAbsListView.isInLayout()))
        {
          this.rqy.vibrate(10L);
          this.Mow = false;
        }
        if (paramInt2 < this.JMP + 10) {
          gjk();
        }
      }
      this.Moo = gjg();
      if ((!gjg()) || (!this.Lue)) {
        break label1715;
      }
      zR(false);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.Mop);
      MMHandlerThread.postToMainThreadDelayed(this.Mop, 60L);
      AppMethodBeat.o(215379);
      return;
      label1256:
      this.MnE = true;
      if ((!gjg()) || (this.MnG == null) || ((this.MnG.getVisibility() == 0) && (this.MnG.getAlpha() == 1.0F))) {
        break;
      }
      this.MnG.setAlpha(1.0F);
      this.MnG.setVisibility(0);
      break;
      label1316:
      paramInt3 = gja();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.Moa) / (this.Mnv.getMeasuredHeight() - this.JMP - this.Moa)));
      ck(f1);
      i = this.Mnv.getHeight() - this.JMP - this.MnH;
      j = gja() - i;
      float f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.MnH - this.MnI)));
      Log.v("MicroMsg.TaskBarAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
      if (paramInt3 < this.Moa / 2)
      {
        if (this.MnV)
        {
          this.MnV = false;
          this.Mnv.zS(false);
        }
        label1507:
        if (paramInt3 >= this.Moa) {
          break label1605;
        }
        aiQ(0);
        f(1.0F, this.wYT, paramInt3);
        cl(1.0F);
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
        if (this.MnV) {
          break label1507;
        }
        this.MnV = true;
        this.Mnv.zS(true);
        break label1507;
        label1605:
        if (f2 >= 0.0F)
        {
          aiQ(4);
          f(f2, this.mContext.getResources().getColor(d.a.app_brand_desktop_bottom_action_bar_color), paramInt3);
          cl(1.0F - f2);
        }
      }
      label1649:
      paramInt2 = 0;
      break label742;
      label1654:
      paramInt2 = 0;
      break label742;
      label1659:
      if ((!this.Moo) || (!this.MnZ)) {
        break label759;
      }
      aJ(false, true);
      break label759;
      label1682:
      this.Moj = false;
      break label759;
      label1690:
      ((AppBrandDesktopContainerView)localObject).rpq.setAlpha(1.0F);
      break label927;
      label1702:
      this.Mor.f(paramInt1, paramInt1);
      break label1099;
      label1715:
      if (!this.MnY) {
        zR(true);
      } else if (this.MnY) {
        zR(false);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(215372);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(gjh()) });
    this.MnF = true;
    this.LuO = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.MnZ = false;
      if ((this.Moi) && (paramInt == 0))
      {
        Log.i("MicroMsg.TaskBarAnimController", "isScrollingByAnim True!!!");
        this.Moi = false;
        AppMethodBeat.o(215372);
        return;
      }
      int i = gja() - 60;
      Log.i("MicroMsg.TaskBarAnimController", "checkOpen moveUp:%b offset:%d openLimit:%d", new Object[] { Boolean.valueOf(gjh()), Integer.valueOf(i), Integer.valueOf(gji()) });
      if (((this.Mnv == null) || (this.Mnv.getBottom() > 0)) && (!gjh())) {
        if (i > gji()) {
          i = 1;
        }
      }
      while (i != 0)
      {
        giZ();
        AppMethodBeat.o(215372);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((gjh()) && (paramInt == -1))
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onScrollStateChanged closeHeader");
        DC(4);
        AppMethodBeat.o(215372);
        return;
      }
      if (paramInt == -1)
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        DC(0);
        this.MnR = true;
        AppMethodBeat.o(215372);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.BNw = true;
        this.MnZ = true;
        AppMethodBeat.o(215372);
        return;
      }
      if (paramInt == 1)
      {
        this.BNw = false;
        this.MnW = true;
        this.MnZ = true;
        if (gjh())
        {
          this.BNw = false;
          this.MnT = 4;
        }
      }
    }
    AppMethodBeat.o(215372);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215370);
    if (paramMotionEvent.getAction() == 0) {
      al(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(215370);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.Lue = false;
        this.Mon.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.Mnv != null) && (this.Mnv.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (gjh()))
        {
          if (this.MnT == 0) {
            this.MnT = 12;
          }
          Log.i("MicroMsg.TaskBarAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.MnT) });
        }
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void zR(boolean paramBoolean)
  {
    AppMethodBeat.i(215388);
    if (paramBoolean != this.Moq)
    {
      if (WeChatEnvironment.hasDebugger()) {
        Log.v("MicroMsg.TaskBarAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Moq) });
      }
      this.Moq = paramBoolean;
      dv localdv = new dv();
      localdv.fzp.enable = paramBoolean;
      EventCenter.instance.publish(localdv);
    }
    AppMethodBeat.o(215388);
  }
  
  public static abstract interface a
  {
    public abstract void aiS(int paramInt);
    
    public abstract void gjn();
    
    public abstract void gjo();
    
    public abstract void kr(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a
 * JD-Core Version:    0.7.0.1
 */