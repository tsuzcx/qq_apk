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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.autogen.a.ef;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.b.c;
import com.tencent.mm.plugin.taskbar.ui.b.d.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  public int Awb;
  private boolean EKW;
  public int Qhp;
  public boolean RXF;
  private int RYp;
  public TaskBarContainer SQO;
  private float SQP;
  private float SQQ;
  private int SQR;
  private int SQS;
  private List<a> SQT;
  public com.tencent.mm.plugin.taskbar.api.a SQU;
  private DynamicBgContainer SQV;
  public View SQW;
  private boolean SQX;
  private boolean SQY;
  private View SQZ;
  public Runnable SRA;
  public boolean SRB;
  private boolean SRC;
  private boolean SRD;
  private Runnable SRE;
  private int SRF;
  private PointF SRG;
  private PointF SRH;
  private boolean SRI;
  private Runnable SRJ;
  private boolean SRK;
  private GyroView SRL;
  private View SRM;
  private AppBrandDesktopContainerView SRN;
  private boolean SRO;
  private boolean SRP;
  private boolean SRQ;
  View SRa;
  private int SRb;
  private int SRc;
  private int SRd;
  public Runnable SRe;
  public Runnable SRf;
  private com.tencent.threadpool.i.b SRg;
  private com.tencent.threadpool.i.b SRh;
  public boolean SRi;
  private boolean SRj;
  private boolean SRk;
  private boolean SRl;
  private boolean SRm;
  private int SRn;
  private boolean SRo;
  private boolean SRp;
  public boolean SRq;
  private boolean SRr;
  public boolean SRs;
  private boolean SRt;
  int SRu;
  private int SRv;
  private int SRw;
  private int SRx;
  private com.tencent.mm.plugin.appbrand.widget.e.a SRy;
  private boolean SRz;
  private Vibrator cqQ;
  private Context mContext;
  public ListView mListView;
  public View ugI;
  public View yk;
  
  public a(Context paramContext, ListView paramListView, TaskBarContainer paramTaskBarContainer)
  {
    AppMethodBeat.i(264058);
    this.SQP = 0.2F;
    this.SQQ = 0.05F;
    this.SQR = 0;
    this.SQS = 0;
    this.SQT = new LinkedList();
    this.SQX = true;
    this.SQY = false;
    this.SRb = 0;
    this.SRc = 0;
    this.SRd = 0;
    this.SRe = null;
    this.SRf = null;
    this.SRg = null;
    this.SRh = null;
    this.SRi = false;
    this.SRj = false;
    this.SRk = true;
    this.SRl = false;
    this.SRm = false;
    this.SRn = 0;
    this.SRo = false;
    this.SRp = true;
    this.SRq = true;
    this.SRr = true;
    this.SRs = false;
    this.SRt = false;
    this.RYp = -2;
    this.SRu = 0;
    this.SRv = 0;
    this.SRw = 0;
    this.SRx = 0;
    this.Awb = 0;
    this.SRz = false;
    this.SRB = true;
    this.SRC = false;
    this.SRD = false;
    this.SRF = 0;
    this.SRG = new PointF();
    this.SRH = new PointF();
    this.RXF = false;
    this.SRI = false;
    this.SRJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264098);
        a.j(a.this);
        AppMethodBeat.o(264098);
      }
    };
    this.SRK = true;
    this.SRO = true;
    this.SRP = false;
    this.SRQ = false;
    this.mContext = paramContext;
    this.mListView = paramListView;
    this.SQO = paramTaskBarContainer;
    this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.Qhp = (bf.fs(this.mContext) + bf.getStatusBarHeight(this.mContext));
    boolean bool = paramListView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264117);
        a.a(a.this, bf.fs(a.a(a.this)) + bf.getStatusBarHeight(a.a(a.this)));
        Log.i("MicroMsg.TaskBarAnimController", "[run] mScrollOffset:%d UIUtilsStatusBar:%d WeUIToolHelperStatusBar:%d", new Object[] { Integer.valueOf(a.b(a.this)), Integer.valueOf(aw.getStatusBarHeight(a.a(a.this))), Integer.valueOf(bf.getStatusBarHeight(a.a(a.this))) });
        AppMethodBeat.o(264117);
      }
    });
    e.hCT();
    this.SRr = e.aTo();
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", new Object[] { Boolean.valueOf(this.SRr), Integer.valueOf(this.Qhp), Boolean.valueOf(bool) });
    hDk();
    hDl();
    dHj();
    hCY();
    this.SRy = new com.tencent.mm.plugin.appbrand.widget.e.a(this.mContext.getResources().getColor(d.a.FG_0), bb.gy(this.mContext.getResources().getColor(d.a.BW_100_Alpha_0_8), 60));
    AppMethodBeat.o(264058);
  }
  
  private void anS(int paramInt)
  {
    AppMethodBeat.i(264069);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo setActionBarVisible: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.ugI != null) && (this.ugI.getVisibility() != paramInt)) {
      this.ugI.setVisibility(paramInt);
    }
    AppMethodBeat.o(264069);
  }
  
  private void dx(float paramFloat)
  {
    AppMethodBeat.i(264145);
    Log.d("MicroMsg.TaskBarAnimController", "alvinluo updateActionBarFgColor ratio: %f", new Object[] { Float.valueOf(paramFloat) });
    int i = this.SRy.ca(1.0F - paramFloat);
    if (this.SQU != null) {
      this.SQU.h(paramFloat, i, i);
    }
    if (this.SQO != null) {
      this.SQO.me(i, i);
    }
    AppMethodBeat.o(264145);
  }
  
  private int hDa()
  {
    AppMethodBeat.i(264063);
    if (this.SQO.getMeasuredHeight() == 0)
    {
      AppMethodBeat.o(264063);
      return 0;
    }
    int i = this.SQO.getBottom();
    int j = this.Qhp;
    AppMethodBeat.o(264063);
    return i - j;
  }
  
  private void hDb()
  {
    AppMethodBeat.i(264079);
    this.SRn = 0;
    this.SRs = true;
    if ((this.SQZ != null) && (this.SQZ.getVisibility() == 0)) {
      this.SQZ.invalidate();
    }
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", new Object[] { Boolean.valueOf(this.SRm), Boolean.valueOf(this.SRr) });
    if (this.yk == null)
    {
      AppMethodBeat.o(264079);
      return;
    }
    if (this.SRm)
    {
      hDd();
      AppMethodBeat.o(264079);
      return;
    }
    if (!hDg())
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo onOpen header not visible");
      this.yk.setTranslationY(0.0F);
      AppMethodBeat.o(264079);
      return;
    }
    this.yk.animate().translationY(this.yk.getHeight()).setDuration(260L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(264095);
        a.k(a.this).setVisibility(4);
        a.k(a.this).animate().setListener(null);
        AppMethodBeat.o(264095);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    hDc();
    AppMethodBeat.o(264079);
  }
  
  private void hDc()
  {
    AppMethodBeat.i(264085);
    this.SRz = true;
    if (this.SRA != null) {
      this.mListView.removeCallbacks(this.SRA);
    }
    ListView localListView = this.mListView;
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264108);
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo setIgnoreInLayout false");
        a.l(a.this);
        AppMethodBeat.o(264108);
      }
    };
    this.SRA = local9;
    localListView.postDelayed(local9, 500L);
    AppMethodBeat.o(264085);
  }
  
  private void hDe()
  {
    AppMethodBeat.i(264094);
    this.SRs = false;
    hDl();
    hDf();
    if (this.yk == null)
    {
      AppMethodBeat.o(264094);
      return;
    }
    this.yk.setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.yk.animate().translationY(0.0F);
    if (this.yk.getTranslationY() == 0.0F) {}
    for (long l = 130L;; l = 260L)
    {
      localViewPropertyAnimator.setDuration(l).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264073);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(264073);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(264068);
          a.k(a.this).animate().setListener(null);
          a.k(a.this).setTranslationY(0.0F);
          AppMethodBeat.o(264068);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      hDc();
      AppMethodBeat.o(264094);
      return;
    }
  }
  
  private void hDf()
  {
    AppMethodBeat.i(264102);
    if (this.SRe != null) {
      MMHandlerThread.removeRunnable(this.SRe);
    }
    if (this.SRk)
    {
      Runnable local11 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264056);
          Log.i("MicroMsg.TaskBarAnimController", "virbg: delayHideBackgroundView");
          a.m(a.this);
          AppMethodBeat.o(264056);
        }
      };
      this.SRe = local11;
      MMHandlerThread.postToMainThreadDelayed(local11, 500L);
      AppMethodBeat.o(264102);
      return;
    }
    hDm();
    AppMethodBeat.o(264102);
  }
  
  private boolean hDh()
  {
    AppMethodBeat.i(264106);
    if ((Math.abs(this.SRH.y - this.SRG.y) <= 5.0F) || (this.SRH.y <= this.SRG.y))
    {
      AppMethodBeat.o(264106);
      return true;
    }
    AppMethodBeat.o(264106);
    return false;
  }
  
  private int hDi()
  {
    AppMethodBeat.i(264113);
    if (this.SQR == 0) {
      this.SQR = ((int)(this.SQO.getHeight() * this.SQP));
    }
    int i = this.SQR;
    AppMethodBeat.o(264113);
    return i;
  }
  
  private int hDj()
  {
    AppMethodBeat.i(264115);
    if (this.SQS == 0) {
      this.SQS = ((int)(this.SQO.getHeight() * this.SQQ));
    }
    int i = this.SQS;
    AppMethodBeat.o(264115);
    return i;
  }
  
  private void hDk()
  {
    this.SRQ = true;
    this.SRO = true;
  }
  
  private void hDl()
  {
    AppMethodBeat.i(264125);
    if (this.SRL != null)
    {
      this.SRL.f(0.0F, hDi());
      this.SRL.setTranslationY(0.0F);
    }
    AppMethodBeat.o(264125);
  }
  
  private void hDm()
  {
    AppMethodBeat.i(264136);
    boolean bool = this.SRr;
    this.SRr = e.aTo();
    Log.i("MicroMsg.TaskBarAnimController", "virbg: hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", new Object[] { Boolean.valueOf(this.SRr), Boolean.valueOf(bool) });
    if ((this.SRk) && (hDg()))
    {
      AppMethodBeat.o(264136);
      return;
    }
    if ((bool) && (this.SRr) && (!this.SQX))
    {
      Log.i("MicroMsg.TaskBarAnimController", "virbg: hideBackgroundView SurfaceView onPause and set GONE");
      this.SQV.gkI();
      this.SQX = true;
    }
    AppMethodBeat.o(264136);
  }
  
  public final void Eb(final int paramInt)
  {
    AppMethodBeat.i(264295);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", new Object[] { Boolean.valueOf(hDg()), Integer.valueOf(paramInt) });
    Object localObject = this.SQO;
    if ((paramInt == 11) && (((TaskBarContainer)localObject).SSp.cPi())) {
      ((TaskBarContainer)localObject).SSp.cPh();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(264295);
      return;
    }
    this.SRm = true;
    this.RXF = false;
    anS(0);
    if (!hDg())
    {
      hDe();
      AppMethodBeat.o(264295);
      return;
    }
    this.SRC = true;
    this.mListView.removeCallbacks(this.SRE);
    localObject = this.mListView;
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264107);
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
          AppMethodBeat.o(264107);
          return;
          i = 600;
          break;
          label149:
          j = paramInt;
        }
      }
    };
    this.SRE = local5;
    ((ListView)localObject).post(local5);
    AppMethodBeat.o(264295);
  }
  
  public final void Fi(boolean paramBoolean)
  {
    AppMethodBeat.i(264399);
    if ((TaskBarView.hDE()) && (paramBoolean != this.SRK))
    {
      if (WeChatEnvironment.hasDebugger()) {
        Log.v("MicroMsg.TaskBarAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.SRK) });
      }
      this.SRK = paramBoolean;
      ef localef = new ef();
      localef.hDY.enable = paramBoolean;
      localef.publish();
    }
    AppMethodBeat.o(264399);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(264302);
    if (!this.SQT.contains(parama)) {
      this.SQT.add(parama);
    }
    AppMethodBeat.o(264302);
  }
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264319);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1) });
    Iterator localIterator;
    if (paramBoolean1)
    {
      hDb();
      if ((this.SRF & 0x2) != 0)
      {
        AppMethodBeat.o(264319);
        return;
      }
      this.SRF |= 0x2;
      this.SRF &= 0xFFFFFFFB;
      localIterator = this.SQT.iterator();
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
          locala.hDo();
          continue;
          hDe();
          if ((this.SRF & 0x4) != 0)
          {
            AppMethodBeat.o(264319);
            return;
          }
          this.SRF |= 0x4;
          this.SRF &= 0xFFFFFFFD;
          break;
        }
        locala.hDn();
        continue;
      }
      if (paramBoolean2) {
        locala.anU(paramInt1);
      } else {
        locala.md(paramInt1, paramInt2);
      }
    }
    label218:
    AppMethodBeat.o(264319);
  }
  
  public final void anT(int paramInt)
  {
    AppMethodBeat.i(264394);
    Log.i("MicroMsg.TaskBarAnimController", "updateScrollOffset %d", new Object[] { Integer.valueOf(paramInt) });
    this.Qhp = paramInt;
    AppMethodBeat.o(264394);
  }
  
  public final void ao(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264335);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
    this.mListView.removeCallbacks(this.SRE);
    this.mListView.removeCallbacks(this.SRf);
    this.SRG.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    this.SRD = false;
    this.SRz = false;
    this.RXF = true;
    AppMethodBeat.o(264335);
  }
  
  protected final void bg(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(264309);
    a(paramBoolean1, paramBoolean2, 0, 0);
    AppMethodBeat.o(264309);
  }
  
  public final void dHj()
  {
    AppMethodBeat.i(264279);
    try
    {
      this.SRb = ((int)(this.mContext.getResources().getDisplayMetrics().heightPixels * 0.2F));
      this.SRc = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 16);
      if (this.SRb < this.SRc) {
        this.SRc = 0;
      }
      this.SRd = this.SRb;
      this.SRw = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 100);
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", new Object[] { Integer.valueOf(this.SRb), Integer.valueOf(this.SRd), Integer.valueOf(this.SRw) });
      AppMethodBeat.o(264279);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(264279);
    }
  }
  
  public final void dw(float paramFloat)
  {
    AppMethodBeat.i(264435);
    int j = com.tencent.mm.plugin.taskbar.ui.c.a.g(paramFloat, this.mContext.getResources().getColor(d.a.BG_0));
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!g.isMIUIV8()))
    {
      if (paramFloat >= 1.0F) {
        break label128;
      }
      i = 0;
    }
    for (;;)
    {
      if (this.mListView != null) {
        this.mListView.setBackgroundColor(j);
      }
      if (this.SQW != null) {
        this.SQW.setBackgroundColor(i);
      }
      AppMethodBeat.o(264435);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        i = com.tencent.mm.plugin.taskbar.ui.c.a.g(paramFloat, bb.av(this.mContext.getResources().getColor(a.d.statusbar_fg_drak_color), this.mContext.getResources().getColor(d.a.BG_0)));
      } else {
        label128:
        i = j;
      }
    }
  }
  
  public final void g(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264446);
    Log.d("MicroMsg.TaskBarAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.plugin.taskbar.ui.c.a.g(paramFloat, paramInt1);
    if (this.SQU != null) {
      this.SQU.g(paramFloat, paramInt1, paramInt2);
    }
    if (this.SQO != null) {
      this.SQO.anX(paramInt1);
    }
    AppMethodBeat.o(264446);
  }
  
  public final boolean glK()
  {
    AppMethodBeat.i(264409);
    if ((hDg()) && (this.SRs))
    {
      AppMethodBeat.o(264409);
      return true;
    }
    AppMethodBeat.o(264409);
    return false;
  }
  
  public final void hCY()
  {
    AppMethodBeat.i(264273);
    this.Awb = this.mContext.getResources().getColor(d.a.BG_0);
    AppMethodBeat.o(264273);
  }
  
  public final void hCZ()
  {
    AppMethodBeat.i(264288);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", new Object[] { Boolean.valueOf(hDg()), Boolean.valueOf(this.SRs) });
    if (!hDg())
    {
      AppMethodBeat.o(264288);
      return;
    }
    if ((this.SRO) && (this.SRP)) {
      PlaySound.play(this.mContext, d.g.app_brand_recent_view_down_sound_path, 3);
    }
    this.SRC = true;
    this.SRm = false;
    this.mListView.removeCallbacks(this.SRE);
    Object localObject = this.mListView;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264110);
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo doOpenHeader");
        int i = a.c(a.this).getTop();
        a.d(a.this).smoothScrollBy(i, 600);
        a.e(a.this);
        a.this.bg(true, false);
        AppMethodBeat.o(264110);
      }
    };
    this.SRE = local4;
    ((ListView)localObject).post(local4);
    if (!this.SRr)
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
      AppMethodBeat.o(264288);
      return;
    }
    localObject = com.tencent.mm.plugin.taskbar.ui.a.a.STE;
    if (!com.tencent.mm.plugin.taskbar.ui.a.a.hDX())
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
      AppMethodBeat.o(264288);
      return;
    }
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", new Object[] { Boolean.valueOf(this.SRi), Boolean.valueOf(this.SRj) });
    if ((!this.SRi) && (!this.SRj))
    {
      this.SRi = true;
      if (this.SRg != null) {
        this.SRg.cancel();
      }
      this.SRg = new com.tencent.threadpool.i.b()
      {
        public final String getKey()
        {
          return "MicroMsg.TaskBarAnimController#startMonitorRunnable";
        }
        
        public final void run()
        {
          AppMethodBeat.i(264123);
          com.tencent.mm.plugin.taskbar.ui.b.d locald;
          if (!c.STP.mvL)
          {
            Log.i("MicroMsg.TaskBarAnimController", "alvinluo doStart performanceMonitor");
            ??? = c.STP;
            if (!((c)???).mvL)
            {
              ((c)???).mvL = true;
              Log.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { Util.getStack() });
              ((c)???).aXZ().postFrameCallback((Choreographer.FrameCallback)???);
            }
            locald = com.tencent.mm.plugin.taskbar.ui.b.d.STS;
          }
          synchronized (locald.mvS)
          {
            if (locald.Uz)
            {
              Log.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
              a.n(a.this);
              AppMethodBeat.o(264123);
              return;
            }
            if (locald.Lox != null) {
              locald.Lox.cancel(false);
            }
            System.gc();
            locald.mvQ.clear();
            locald.mvQ.put(Integer.valueOf(1), new com.tencent.mm.plugin.taskbar.ui.b.a());
            locald.Lox = h.ahAA.b(new d.1(locald), 0L, 5L);
            locald.Uz = true;
          }
        }
      };
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo execute startMonitorRunnable");
      h.ahAA.g(this.SRg, "AppBrandDesktopPerformanceMonitor");
    }
    AppMethodBeat.o(264288);
  }
  
  public final void hDd()
  {
    AppMethodBeat.i(264386);
    if (this.yk != null)
    {
      this.SRm = true;
      this.yk.setTranslationY(0.0F);
    }
    AppMethodBeat.o(264386);
  }
  
  public final boolean hDg()
  {
    AppMethodBeat.i(264420);
    Log.v("MicroMsg.TaskBarAnimController", "alvinluo isVisibleHeader bottom: %d, scrollOffset: %d, firstVisiblePosition: %d HeaderOpen:%b", new Object[] { Integer.valueOf(this.SQO.getBottom()), Integer.valueOf(this.Qhp), Integer.valueOf(this.mListView.getFirstVisiblePosition()), Boolean.valueOf(this.SRs) });
    if ((this.SQO.getBottom() >= this.Qhp + 10) && (this.mListView.getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(264420);
      return true;
    }
    AppMethodBeat.o(264420);
    return false;
  }
  
  public final void j(long paramLong, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(264323);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.SRf != null) {
      this.mListView.removeCallbacks(this.SRf);
    }
    ListView localListView = this.mListView;
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264103);
        a.a(a.this, paramBoolean);
        a.this.Eb(paramInt);
        AppMethodBeat.o(264103);
      }
    };
    this.SRf = local6;
    localListView.postDelayed(local6, paramLong);
    AppMethodBeat.o(264323);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(264378);
    if ((!this.SRz) && (paramAbsListView.isInLayout()) && (!this.SRm) && (this.SQO.getBottom() < this.SQO.getHeight() - 5) && (this.SRs))
    {
      Log.i("MicroMsg.TaskBarAnimController", "isInLayout");
      Eb(0);
      AppMethodBeat.o(264378);
      return;
    }
    if ((this.SRD) && (!this.SRC) && (this.EKW) && (paramInt1 <= 0) && (hDg()))
    {
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo [onScroll] stop fling!");
      this.mListView.scrollBy(0, 0);
      Eb(4);
    }
    if ((this.SQO != null) && (this.SQO.getHeight() != this.SRx))
    {
      this.SRu = ((int)(this.SQO.getHeight() * this.SQP) + 60);
      this.SRv = (this.SQO.getHeight() - this.Qhp);
      this.SQR = ((int)(this.SQO.getHeight() * this.SQP));
      this.SQS = ((int)(this.SQO.getHeight() * this.SQQ));
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", new Object[] { Integer.valueOf(this.SQO.getHeight()), Integer.valueOf(this.SRx), Integer.valueOf(this.SRu), Integer.valueOf(this.SRv), Integer.valueOf(this.SQR), Integer.valueOf(this.SQS) });
      this.SRx = this.SQO.getHeight();
    }
    Log.v("MicroMsg.TaskBarAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", new Object[] { Boolean.valueOf(this.EKW), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.SRD), Integer.valueOf(this.SRu) });
    Object localObject;
    label563:
    label752:
    int i;
    label769:
    float f1;
    label937:
    int j;
    if ((!this.SRD) && (paramInt1 == 0) && (this.SQO != null))
    {
      paramInt3 = this.SQO.getBottom();
      localObject = this.SQU;
      Log.d("MicroMsg.TaskBarAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(this.Qhp), Integer.valueOf(this.SQO.getHeight()), Integer.valueOf(this.SQO.getBottom()), Boolean.valueOf(this.SQY) });
      if ((this.SRr) || (this.SQZ != null))
      {
        if (!this.SRr) {
          break label1266;
        }
        if ((hDg()) && (this.SQX) && (this.SQY))
        {
          this.SQX = false;
          this.SQZ.setVisibility(0);
          this.SQV.gkJ();
        }
      }
      if (this.SRq) {
        break label1326;
      }
      Log.i("MicroMsg.TaskBarAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
    }
    else
    {
      if ((this.mListView != null) && ((Build.VERSION.SDK_INT < 23) || (g.isMIUIV8())) && (Build.VERSION.SDK_INT >= 21) && (!glK()) && (this.SQO != null) && (this.SQO.getBottom() <= this.Qhp + 20))
      {
        if (this.SQZ != null) {
          this.SQZ.setVisibility(8);
        }
        if (this.SRr)
        {
          this.SQX = true;
          this.SQV.gkI();
        }
      }
      if (hDg()) {
        break label1741;
      }
      this.SRD = true;
      paramInt2 = hDa() - 60;
      Log.i("MicroMsg.TaskBarAnimController", "checkClose moveUp:%b offset:%d closeLimit:%d", new Object[] { Boolean.valueOf(hDh()), Integer.valueOf(paramInt2), Integer.valueOf(hDj()) });
      if (((this.SQO != null) && (this.SQO.getBottom() <= 0)) || (!hDh())) {
        break label1713;
      }
      if (paramInt2 >= hDj()) {
        break label1708;
      }
      paramInt2 = 1;
      if ((paramInt2 == 0) || (!this.SRt)) {
        break label1718;
      }
      bg(false, true);
      if (this.SRL == null) {
        this.SRL = ((GyroView)this.SQO.findViewById(d.d.gyro_view));
      }
      if (this.SRM == null) {
        this.SRM = this.SQO.findViewById(d.d.app_brand_desktop_root_layout);
      }
      if (this.SRN == null) {
        this.SRN = this.SQO.getDesktopContainerView();
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = hDi();
        paramInt2 = this.SQO.getBottom();
        paramInt3 = hDa();
        i = this.SRv - this.SRu;
        f1 = 1.0F * (paramInt3 - this.SRu) / i;
        this.SRM.setAlpha(f1);
        localObject = this.SRN;
        if (!((AppBrandDesktopContainerView)localObject).isAnimating)
        {
          ((AppBrandDesktopContainerView)localObject).uzB.setAlpha(f1);
          if (f1 >= 0.2F) {
            break label1749;
          }
          ((AppBrandDesktopContainerView)localObject).uzC.setAlpha(5.0F * f1);
        }
        j = paramInt3 - 60;
        Log.v("MicroMsg.TaskBarAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Integer.valueOf(this.SRu), Integer.valueOf(this.SRv), Boolean.valueOf(this.EKW), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.SQO.getHeight()), Integer.valueOf(this.SRL.getHeight()) });
        if (((!this.EKW) && (paramInt2 >= 5)) || (this.SRl))
        {
          if (paramInt1 < j) {
            break label1761;
          }
          this.SRL.f(j, paramInt1);
          this.SRL.setAlpha(1.0F);
        }
        label1109:
        f1 = 1.0F * (j - paramInt1) / this.SRw;
        localObject = this.SRL;
        ((GyroView)localObject).setTranslationY(-(paramInt3 - ((GyroView)localObject).getHeight()) / 2.0F);
        this.SRL.setAlpha(1.0F - f1);
        if ((j >= paramInt1) && (this.SRQ) && (hDg()) && (!paramAbsListView.isInLayout()))
        {
          this.cqQ.vibrate(10L);
          this.SRQ = false;
        }
        if (paramInt2 < this.Qhp + 10) {
          hDk();
        }
      }
      this.SRI = hDg();
      if ((!hDg()) || (!this.RXF)) {
        break label1774;
      }
      Fi(false);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.SRJ);
      MMHandlerThread.postToMainThreadDelayed(this.SRJ, 60L);
      AppMethodBeat.o(264378);
      return;
      label1266:
      this.SQX = true;
      if ((!hDg()) || (this.SQZ == null) || ((this.SQZ.getVisibility() == 0) && (this.SQZ.getAlpha() == 1.0F))) {
        break;
      }
      this.SQZ.setAlpha(1.0F);
      this.SQZ.setVisibility(0);
      break;
      label1326:
      paramInt3 = hDa();
      f1 = 1.0F - Math.min(1.0F, Math.max(0.0F, 1.0F * (paramInt3 - this.SRu) / (this.SQO.getMeasuredHeight() - this.Qhp - this.SRu)));
      dw(f1);
      boolean bool;
      float f2;
      if (localObject != null)
      {
        if (f1 >= 1.0F)
        {
          bool = true;
          ((com.tencent.mm.plugin.taskbar.api.a)localObject).Fh(bool);
        }
      }
      else
      {
        i = this.SQO.getHeight() - this.Qhp - this.SRb;
        j = hDa() - i;
        f2 = Math.min(1.0F, Math.max(0.0F, 1.0F * j / (this.SRb - this.SRc)));
        Log.v("MicroMsg.TaskBarAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", new Object[] { Integer.valueOf(paramInt3), Float.valueOf(f1), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f2) });
        if (paramInt3 >= this.SRu / 2) {
          break label1622;
        }
        if (this.SRp)
        {
          this.SRp = false;
          this.SQO.Fj(false);
        }
        label1541:
        if (paramInt3 >= this.SRu) {
          break label1645;
        }
        anS(0);
        g(1.0F, this.Awb, paramInt3);
        dx(1.0F);
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
        bool = false;
        break;
        label1622:
        if (this.SRp) {
          break label1541;
        }
        this.SRp = true;
        this.SQO.Fj(true);
        break label1541;
        label1645:
        if (f2 >= 0.0F)
        {
          anS(4);
          g(f2, this.mContext.getResources().getColor(d.a.app_brand_desktop_bottom_action_bar_color), paramInt3);
          dx(1.0F - f2);
        }
      }
      if (this.SRa == null) {
        break label563;
      }
      this.SRa.setAlpha(f1);
      break label563;
      label1708:
      paramInt2 = 0;
      break label752;
      label1713:
      paramInt2 = 0;
      break label752;
      label1718:
      if ((!this.SRI) || (!this.SRt)) {
        break label769;
      }
      bg(false, true);
      break label769;
      label1741:
      this.SRD = false;
      break label769;
      label1749:
      ((AppBrandDesktopContainerView)localObject).uzC.setAlpha(1.0F);
      break label937;
      label1761:
      this.SRL.f(paramInt1, paramInt1);
      break label1109;
      label1774:
      if (!this.SRs) {
        Fi(true);
      } else if (this.SRs) {
        Fi(false);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(264345);
    Log.i("MicroMsg.TaskBarAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(hDh()) });
    this.SQY = true;
    this.RYp = paramInt;
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.SRt = false;
      if ((this.SRC) && (paramInt == 0))
      {
        Log.i("MicroMsg.TaskBarAnimController", "isScrollingByAnim True!!!");
        this.SRC = false;
        AppMethodBeat.o(264345);
        return;
      }
      int i = hDa() - 60;
      Log.i("MicroMsg.TaskBarAnimController", "checkOpen moveUp:%b offset:%d openLimit:%d", new Object[] { Boolean.valueOf(hDh()), Integer.valueOf(i), Integer.valueOf(hDi()) });
      if (((this.SQO == null) || (this.SQO.getBottom() > 0)) && (!hDh())) {
        if (i > hDi()) {
          i = 1;
        }
      }
      while (i != 0)
      {
        hCZ();
        AppMethodBeat.o(264345);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((hDh()) && (paramInt == -1))
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onScrollStateChanged closeHeader");
        Eb(4);
        AppMethodBeat.o(264345);
        return;
      }
      if (paramInt == -1)
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onScrollStateChanged closeHeader auto");
        Eb(0);
        this.SRl = true;
        AppMethodBeat.o(264345);
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.EKW = true;
        this.SRt = true;
        AppMethodBeat.o(264345);
        return;
      }
      if (paramInt == 1)
      {
        this.EKW = false;
        this.SRq = true;
        this.SRt = true;
        if (hDh())
        {
          this.EKW = false;
          this.SRn = 4;
        }
      }
    }
    AppMethodBeat.o(264345);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264330);
    if (paramMotionEvent.getAction() == 0) {
      ao(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(264330);
      return false;
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        this.RXF = false;
        this.SRH.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
        if ((this.SQO != null) && (this.SQO.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) && (hDh()))
        {
          if (this.SRn == 0) {
            this.SRn = 12;
          }
          Log.i("MicroMsg.TaskBarAnimController", "alvinluo onTouch ActionUp reason: %d", new Object[] { Integer.valueOf(this.SRn) });
        }
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo onTouch ActionUp");
        onScrollStateChanged(this.mListView, -1);
      }
    }
  }
  
  public final void u(View paramView1, View paramView2)
  {
    AppMethodBeat.i(264427);
    Log.i("MicroMsg.TaskBarAnimController", "setBackgroundView");
    this.SQV = ((DynamicBgContainer)paramView1);
    this.SRr = e.aTo();
    this.SQZ = paramView2;
    this.SQV.setGradientBgView((GradientColorBackgroundView)this.SQZ);
    AppMethodBeat.o(264427);
  }
  
  public static abstract interface a
  {
    public abstract void anU(int paramInt);
    
    public abstract void hDn();
    
    public abstract void hDo();
    
    public abstract void md(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a
 * JD-Core Version:    0.7.0.1
 */