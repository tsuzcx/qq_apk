package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.List;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final float Fge;
  private static final int MN;
  private boolean FfZ;
  private Drawable FgA;
  private boolean FgB;
  private boolean FgC;
  private boolean FgD;
  private Runnable FgE;
  private long Fgf;
  private View Fgg;
  private View Fgh;
  private MMSightCircularProgressBar Fgi;
  private boolean Fgj;
  private boolean Fgk;
  private ViewPropertyAnimator Fgl;
  private ViewPropertyAnimator Fgm;
  private ValueAnimator Fgn;
  private ValueAnimator Fgo;
  private ViewPropertyAnimator Fgp;
  private ViewPropertyAnimator Fgq;
  private int Fgr;
  private int Fgs;
  private int Fgt;
  private int Fgu;
  private d Fgv;
  private b Fgw;
  private c Fgx;
  private a Fgy;
  private Drawable Fgz;
  private float aCb;
  private boolean enable;
  private boolean isAnimating;
  private Runnable jLe;
  private MMHandler knk;
  private boolean leA;
  private View progressBar;
  private boolean xBb;
  
  static
  {
    AppMethodBeat.i(94555);
    MN = ViewConfiguration.getTapTimeout();
    Fge = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_max) / MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_init);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.Fgf = -1L;
    this.leA = false;
    this.Fgj = false;
    this.Fgk = false;
    this.isAnimating = false;
    this.xBb = false;
    this.Fgt = -1;
    this.Fgu = -2130706433;
    this.aCb = -1.0F;
    this.enable = true;
    this.FgB = false;
    this.FgC = false;
    this.FfZ = false;
    this.FgD = false;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.jLe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).dJ();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.FgE = new MMSightRecordButton.6(this);
    init();
    AppMethodBeat.o(94538);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94539);
    this.Fgf = -1L;
    this.leA = false;
    this.Fgj = false;
    this.Fgk = false;
    this.isAnimating = false;
    this.xBb = false;
    this.Fgt = -1;
    this.Fgu = -2130706433;
    this.aCb = -1.0F;
    this.enable = true;
    this.FgB = false;
    this.FgC = false;
    this.FfZ = false;
    this.FgD = false;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.jLe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).dJ();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.FgE = new MMSightRecordButton.6(this);
    init();
    AppMethodBeat.o(94539);
  }
  
  private void eUq()
  {
    AppMethodBeat.i(249034);
    Log.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.Fgl != null)
    {
      this.Fgl.cancel();
      this.Fgl = null;
    }
    this.Fgl = this.Fgg.animate().scaleX(0.5F).scaleY(0.5F);
    this.Fgl.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.FgJ != null) {
          this.FgJ.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.FgJ != null) {
          this.FgJ.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.Fgm != null)
    {
      this.Fgm.cancel();
      this.Fgm = null;
    }
    this.Fgm = this.Fgh.animate().scaleX(Fge).scaleY(Fge);
    this.Fgm.setDuration(150L).start();
    if (this.Fgs != this.Fgr)
    {
      if (this.Fgn != null) {
        this.Fgn.cancel();
      }
      this.Fgn = ObjectAnimator.ofInt(this.FgA, "color", new int[] { this.Fgs, this.Fgr });
      this.Fgn.setDuration(150L);
      this.Fgn.setEvaluator(a.getInstance());
      this.Fgn.start();
    }
    if (this.Fgo != null) {
      this.Fgo.cancel();
    }
    this.Fgo = ObjectAnimator.ofInt(this.Fgz, "color", new int[] { this.Fgt, this.Fgu });
    this.Fgo.setDuration(150L);
    this.Fgo.setEvaluator(a.getInstance());
    this.Fgo.start();
    AppMethodBeat.o(249034);
  }
  
  private void f(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.Fgp != null)
    {
      this.Fgp.cancel();
      this.Fgp = null;
    }
    this.Fgp = this.Fgg.animate().scaleX(1.0F).scaleY(1.0F);
    this.Fgp.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94533);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (paramAnimatorListenerAdapter != null) {
          paramAnimatorListenerAdapter.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94533);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94532);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (paramAnimatorListenerAdapter != null) {
          paramAnimatorListenerAdapter.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94532);
      }
    }).setDuration(150L).start();
    this.Fgq = this.Fgh.animate().scaleX(1.0F).scaleY(1.0F);
    this.Fgq.setDuration(150L).start();
    if (this.Fgo != null) {
      this.Fgo.cancel();
    }
    this.Fgo = ObjectAnimator.ofInt(this.Fgz, "color", new int[] { this.Fgu, this.Fgt });
    this.Fgo.setDuration(150L);
    this.Fgo.setEvaluator(a.getInstance());
    this.Fgo.start();
    if (this.Fgs != this.Fgr)
    {
      if (this.Fgn != null) {
        this.Fgn.cancel();
      }
      this.Fgn = ObjectAnimator.ofInt(this.FgA, "color", new int[] { this.Fgr, this.Fgs });
      this.Fgn.setDuration(150L);
      this.Fgn.setEvaluator(a.getInstance());
      this.Fgn.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(MN) });
    this.Fgz = getContext().getResources().getDrawable(a.d.mmsight_recorder_button_inner);
    this.FgA = getContext().getResources().getDrawable(a.d.mmsight_recorder_button_outer);
    ad.kS(getContext()).inflate(a.f.mmsight_recorder_button, this, true);
    this.Fgg = findViewById(a.e.inner);
    this.Fgh = findViewById(a.e.outer);
    this.progressBar = findViewById(a.e.progress_bar);
    this.Fgi = ((MMSightCircularProgressBar)findViewById(a.e.circular_progress));
    this.Fgg.setBackgroundDrawable(this.Fgz);
    this.Fgh.setBackgroundDrawable(this.FgA);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void Xg(int paramInt)
  {
    AppMethodBeat.i(249025);
    int i = this.Fgi.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.Fgi;
      if (localMMSightCircularProgressBar.FfX.size() > 0)
      {
        localMMSightCircularProgressBar.FfX.remove(localMMSightCircularProgressBar.FfX.size() - 1);
        if (localMMSightCircularProgressBar.FfX.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.FfS = ((Float)localMMSightCircularProgressBar.FfX.get(localMMSightCircularProgressBar.FfX.size() - 1)).floatValue();; localMMSightCircularProgressBar.FfS = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(249025);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    Log.printInfoStack("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.leA = true;
    this.Fgi.setInitProgress(0);
    this.Fgi.setMaxProgress(100);
    this.Fgi.setDuration(paramInt1);
    if (!this.FfZ) {
      this.Fgi.setVisibility(0);
    }
    this.Fgi.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void Z(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(249078);
        if (parama != null) {
          parama.Z(paramAnonymousArrayList);
        }
        AppMethodBeat.o(249078);
      }
      
      public final void mV(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(249077);
        Log.printInfoStack("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            Log.printInfoStack("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.FgF != null) {
              MMSightRecordButton.1.this.FgF.mV(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(249077);
      }
    };
    this.Fgi.setProgressCallback(parama);
    parama = this.Fgi;
    Log.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(parama.FfT), Integer.valueOf(parama.FfU), Integer.valueOf(parama.duration), Float.valueOf(parama.FfS) });
    parama.isStart = true;
    if (parama.FfV != null)
    {
      parama.FfV.cancel();
      parama.FfV = null;
    }
    parama.FfV = new c(parama.FfS, parama.FfU, parama.duration);
    c localc = parama.FfV;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    Log.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.FhH = local1;
    parama = parama.FfV;
    Log.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.jID = Util.currentTicks();
    parama.lUQ.startTimer(20L);
    AppMethodBeat.o(94546);
  }
  
  public final void eUn()
  {
    AppMethodBeat.i(94545);
    Log.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void eUo()
  {
    this.FgD = true;
  }
  
  public final void eUp()
  {
    AppMethodBeat.i(249024);
    this.Fgi.setVisibility(0);
    AppMethodBeat.o(249024);
  }
  
  public final boolean eUr()
  {
    AppMethodBeat.i(249041);
    if ((!this.FfZ) || (getSubProgress().isEmpty()))
    {
      AppMethodBeat.o(249041);
      return true;
    }
    AppMethodBeat.o(249041);
    return false;
  }
  
  public List<Float> getSubProgress()
  {
    AppMethodBeat.i(249026);
    ArrayList localArrayList = this.Fgi.getSubProgress();
    AppMethodBeat.o(249026);
    return localArrayList;
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.FfZ)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.Fgi;
      if (localMMSightCircularProgressBar.FfV != null)
      {
        localMMSightCircularProgressBar.FfV.cancel();
        localMMSightCircularProgressBar.FfV = null;
      }
      if ((localMMSightCircularProgressBar.FfS > 0.0F) && (((localMMSightCircularProgressBar.FfX.size() > 0) && (localMMSightCircularProgressBar.FfS > ((Float)localMMSightCircularProgressBar.FfX.get(localMMSightCircularProgressBar.FfX.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.FfX.size() == 0))) {
        localMMSightCircularProgressBar.FfX.add(Float.valueOf(localMMSightCircularProgressBar.FfS));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.Fgi.reset();
    this.Fgi.setVisibility(8);
    AppMethodBeat.o(94547);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94551);
    if (!this.enable)
    {
      Log.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(94551);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(94551);
      return true;
      if ((this.leA) && (!this.FfZ) && (!this.FgD))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.xBb = true;
      this.Fgf = System.currentTimeMillis();
      this.Fgj = false;
      this.Fgk = false;
      this.aCb = paramMotionEvent.getRawY();
      if ((this.Fgw != null) && (!this.leA)) {
        this.Fgw.cYt();
      }
      this.knk.removeCallbacksAndMessages(null);
      if (!this.leA)
      {
        this.knk.postDelayed(this.jLe, 550L);
        this.knk.postDelayed(this.FgE, 250L);
      }
      this.FgC = true;
      this.FgB = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.Fgk) || (!this.FfZ))) {
        if (this.aCb <= 0.0F)
        {
          this.aCb = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.aCb);
          int i;
          if ((f1 < this.aCb) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.FgB) });
            i = Math.min(i, 3);
            if (this.Fgx != null)
            {
              paramMotionEvent = this.Fgx;
              if (this.FgB) {
                i = 1;
              }
              paramMotionEvent.Ka(i);
            }
            this.aCb = f1;
            this.FgB = false;
          }
          else if ((f1 > this.aCb) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.FgC) });
            i = Math.min(i, 3);
            if (this.Fgx != null)
            {
              paramMotionEvent = this.Fgx;
              if (this.FgC) {
                i = 1;
              }
              paramMotionEvent.Kb(i);
            }
            this.FgC = false;
            this.aCb = f1;
            continue;
            this.xBb = false;
            this.knk.removeCallbacks(this.FgE, Integer.valueOf(MN));
            this.knk.removeCallbacks(this.jLe);
            if ((this.Fgl != null) && (this.Fgm != null))
            {
              this.Fgl.cancel();
              this.Fgm.cancel();
            }
            final long l = System.currentTimeMillis() - this.Fgf;
            Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.Fgk), Boolean.valueOf(this.Fgj), Long.valueOf(this.Fgf), Long.valueOf(l) });
            hideProgress();
            f(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(94537);
                if ((MMSightRecordButton.h(MMSightRecordButton.this) > 0L) && (l <= 500L) && (!MMSightRecordButton.c(MMSightRecordButton.this)))
                {
                  Log.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
                  MMSightRecordButton.i(MMSightRecordButton.this);
                  if (!MMSightRecordButton.c(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                    if (MMSightRecordButton.k(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.k(MMSightRecordButton.this).cYu();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else if (MMSightRecordButton.c(MMSightRecordButton.this))
                {
                  Log.i("MicroMsg.MMSightRecordButton", "on Long Press finish ，isRecordIng:%b", new Object[] { Boolean.valueOf(MMSightRecordButton.l(MMSightRecordButton.this)) });
                  if (MMSightRecordButton.l(MMSightRecordButton.this)) {
                    MMSightRecordButton.a(MMSightRecordButton.this);
                  }
                  if (MMSightRecordButton.e(MMSightRecordButton.this) != null)
                  {
                    MMSightRecordButton.e(MMSightRecordButton.this).cYs();
                    AppMethodBeat.o(94537);
                  }
                }
                else
                {
                  Log.i("MicroMsg.MMSightRecordButton", "error action up");
                  if (MMSightRecordButton.l(MMSightRecordButton.this)) {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                  }
                  if (MMSightRecordButton.m(MMSightRecordButton.this) != null) {
                    MMSightRecordButton.m(MMSightRecordButton.this).eUs();
                  }
                }
                AppMethodBeat.o(94537);
              }
            });
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94550);
    setClipChildren(false);
    this.enable = true;
    this.Fgg.setScaleX(1.0F);
    this.Fgg.setScaleY(1.0F);
    this.Fgh.setScaleX(1.0F);
    this.Fgh.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    this.Fgi.reset();
    AppMethodBeat.o(94550);
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.Fgy = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.Fgs = paramInt;
    if ((this.FgA instanceof GradientDrawable)) {
      ((GradientDrawable)this.FgA).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.Fgz instanceof GradientDrawable)) {
      ((GradientDrawable)this.Fgz).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.Fgw = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.Fgx = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.Fgv = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(94543);
    Log.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(94543);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(94549);
    Log.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(94534);
          MMSightRecordButton.a(MMSightRecordButton.this, paramInt);
          AppMethodBeat.o(94534);
        }
      }, 150L);
      AppMethodBeat.o(94549);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(94549);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(249020);
    Log.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(249020);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(249039);
    if ((this.leA) && (!this.xBb))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(249039);
  }
  
  public final void uo(boolean paramBoolean)
  {
    AppMethodBeat.i(249021);
    this.FfZ = paramBoolean;
    this.Fgi.setEnableSubProgress(paramBoolean);
    this.Fgi.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.Fgi.setVisibility(4);
      AppMethodBeat.o(249021);
      return;
    }
    this.Fgi.reset();
    this.Fgi.setVisibility(0);
    AppMethodBeat.o(249021);
  }
  
  public final void up(boolean paramBoolean)
  {
    AppMethodBeat.i(249028);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.Fgi;
    localMMSightCircularProgressBar.Fgb = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(249028);
  }
  
  public static abstract interface a
  {
    public abstract void eUs();
  }
  
  public static abstract interface b
  {
    public abstract void cYs();
    
    public abstract void cYt();
    
    public abstract void dJ();
  }
  
  public static abstract interface c
  {
    public abstract void Ka(int paramInt);
    
    public abstract void Kb(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void cYu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */