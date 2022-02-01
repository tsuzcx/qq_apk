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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;
import java.util.ArrayList;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int Mw;
  private static final float tIP;
  private boolean LmS;
  private ValueAnimator LmV;
  private int LmW;
  private int LmX;
  private boolean enable;
  private Runnable fPp;
  private ap gAC;
  private boolean gAF;
  private boolean isAnimating;
  private View progressBar;
  private float seQ;
  private long tIQ;
  private View tIR;
  private View tIS;
  private MMSightCircularProgressBar tIT;
  private boolean tIU;
  private boolean tIV;
  private ViewPropertyAnimator tIW;
  private ViewPropertyAnimator tIX;
  private ValueAnimator tIY;
  private ViewPropertyAnimator tIZ;
  private ViewPropertyAnimator tJa;
  private boolean tJb;
  private int tJc;
  private int tJd;
  private MMSightRecordButton.d tJe;
  private b tJf;
  private c tJg;
  private MMSightRecordButton.a tJh;
  private Drawable tJi;
  private Drawable tJj;
  private boolean tJk;
  private boolean tJl;
  private Runnable tJm;
  
  static
  {
    AppMethodBeat.i(94555);
    Mw = ViewConfiguration.getTapTimeout();
    tIP = aj.getContext().getResources().getDimensionPixelSize(2131166579) / aj.getContext().getResources().getDimensionPixelSize(2131166578);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.tIQ = -1L;
    this.gAF = false;
    this.tIU = false;
    this.tIV = false;
    this.isAnimating = false;
    this.tJb = false;
    this.LmW = -1;
    this.LmX = -2130706433;
    this.seQ = -1.0F;
    this.enable = true;
    this.tJk = false;
    this.tJl = false;
    this.LmS = false;
    this.gAC = new ap(Looper.getMainLooper());
    this.fPp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ad.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.d(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.e(MMSightRecordButton.this);
          if (MMSightRecordButton.f(MMSightRecordButton.this) != null) {
            MMSightRecordButton.f(MMSightRecordButton.this).jd();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.tJm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ad.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.g(MMSightRecordButton.this)) });
        if (MMSightRecordButton.g(MMSightRecordButton.this)) {
          MMSightRecordButton.h(MMSightRecordButton.this);
        }
        AppMethodBeat.o(94536);
      }
    };
    init();
    AppMethodBeat.o(94538);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94539);
    this.tIQ = -1L;
    this.gAF = false;
    this.tIU = false;
    this.tIV = false;
    this.isAnimating = false;
    this.tJb = false;
    this.LmW = -1;
    this.LmX = -2130706433;
    this.seQ = -1.0F;
    this.enable = true;
    this.tJk = false;
    this.tJl = false;
    this.LmS = false;
    this.gAC = new ap(Looper.getMainLooper());
    this.fPp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ad.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.d(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.e(MMSightRecordButton.this);
          if (MMSightRecordButton.f(MMSightRecordButton.this) != null) {
            MMSightRecordButton.f(MMSightRecordButton.this).jd();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.tJm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ad.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.g(MMSightRecordButton.this)) });
        if (MMSightRecordButton.g(MMSightRecordButton.this)) {
          MMSightRecordButton.h(MMSightRecordButton.this);
        }
        AppMethodBeat.o(94536);
      }
    };
    init();
    AppMethodBeat.o(94539);
  }
  
  private void e(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.tIZ != null)
    {
      this.tIZ.cancel();
      this.tIZ = null;
    }
    this.tIZ = this.tIR.animate().scaleX(1.0F).scaleY(1.0F);
    this.tIZ.setListener(new AnimatorListenerAdapter()
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
    this.tJa = this.tIS.animate().scaleX(1.0F).scaleY(1.0F);
    this.tJa.setDuration(150L).start();
    if (this.LmV != null) {
      this.LmV.cancel();
    }
    this.LmV = ObjectAnimator.ofInt(this.tJi, "color", new int[] { this.LmX, this.LmW });
    this.LmV.setDuration(150L);
    this.LmV.setEvaluator(a.getInstance());
    this.LmV.start();
    if (this.tJd != this.tJc)
    {
      if (this.tIY != null) {
        this.tIY.cancel();
      }
      this.tIY = ObjectAnimator.ofInt(this.tJj, "color", new int[] { this.tJc, this.tJd });
      this.tIY.setDuration(150L);
      this.tIY.setEvaluator(a.getInstance());
      this.tIY.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void fXW()
  {
    AppMethodBeat.i(205863);
    ad.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.tIW != null)
    {
      this.tIW.cancel();
      this.tIW = null;
    }
    this.tIW = this.tIR.animate().scaleX(0.5F).scaleY(0.5F);
    this.tIW.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.tJq != null) {
          this.tJq.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.tJq != null) {
          this.tJq.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.tIX != null)
    {
      this.tIX.cancel();
      this.tIX = null;
    }
    this.tIX = this.tIS.animate().scaleX(tIP).scaleY(tIP);
    this.tIX.setDuration(150L).start();
    if (this.tJd != this.tJc)
    {
      if (this.tIY != null) {
        this.tIY.cancel();
      }
      this.tIY = ObjectAnimator.ofInt(this.tJj, "color", new int[] { this.tJd, this.tJc });
      this.tIY.setDuration(150L);
      this.tIY.setEvaluator(a.getInstance());
      this.tIY.start();
    }
    if (this.LmV != null) {
      this.LmV.cancel();
    }
    this.LmV = ObjectAnimator.ofInt(this.tJi, "color", new int[] { this.LmW, this.LmX });
    this.LmV.setDuration(150L);
    this.LmV.setEvaluator(a.getInstance());
    this.LmV.start();
    AppMethodBeat.o(205863);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    ad.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Mw) });
    this.tJi = getContext().getResources().getDrawable(2131233311);
    this.tJj = getContext().getResources().getDrawable(2131233312);
    y.js(getContext()).inflate(2131494919, this, true);
    this.tIR = findViewById(2131301021);
    this.tIS = findViewById(2131303113);
    this.progressBar = findViewById(2131303518);
    this.tIT = ((MMSightCircularProgressBar)findViewById(2131298337));
    this.tIR.setBackgroundDrawable(this.tJi);
    this.tIS.setBackgroundDrawable(this.tJj);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    ad.m("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.gAF = true;
    this.tIT.setInitProgress(0);
    this.tIT.setMaxProgress(100);
    this.tIT.setDuration(paramInt1);
    if (!this.LmS) {
      this.tIT.setVisibility(0);
    }
    this.tIT.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void aV(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(205858);
        if (parama != null) {
          parama.aV(paramAnonymousArrayList);
        }
        AppMethodBeat.o(205858);
      }
      
      public final void yw(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205857);
        ad.m("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            ad.m("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.tJn != null) {
              MMSightRecordButton.1.this.tJn.yw(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(205857);
      }
    };
    this.tIT.setProgressCallback(parama);
    parama = this.tIT;
    ad.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(parama.tIH), Integer.valueOf(parama.tII), Integer.valueOf(parama.duration), Float.valueOf(parama.tIG) });
    parama.isStart = true;
    if (parama.tIK != null)
    {
      parama.tIK.cancel();
      parama.tIK = null;
    }
    parama.tIK = new c(parama.tIG, parama.tII, parama.duration);
    c localc = parama.tIK;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    ad.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.tKq = local1;
    parama = parama.tIK;
    ad.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.fNi = bt.GC();
    parama.hmK.av(20L, 20L);
    AppMethodBeat.o(94546);
  }
  
  public final void aic(int paramInt)
  {
    AppMethodBeat.i(205861);
    int i = this.tIT.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.tIT;
      if (localMMSightCircularProgressBar.LmQ.size() > 0)
      {
        localMMSightCircularProgressBar.LmQ.remove(localMMSightCircularProgressBar.LmQ.size() - 1);
        if (localMMSightCircularProgressBar.LmQ.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.tIG = ((Float)localMMSightCircularProgressBar.LmQ.get(localMMSightCircularProgressBar.LmQ.size() - 1)).floatValue();; localMMSightCircularProgressBar.tIG = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(205861);
      return;
    }
  }
  
  public final void cQI()
  {
    AppMethodBeat.i(94545);
    ad.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.LmS)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.tIT;
      if (localMMSightCircularProgressBar.tIK != null)
      {
        localMMSightCircularProgressBar.tIK.cancel();
        localMMSightCircularProgressBar.tIK = null;
      }
      if ((localMMSightCircularProgressBar.tIG > 0.0F) && (((localMMSightCircularProgressBar.LmQ.size() > 0) && (localMMSightCircularProgressBar.tIG > ((Float)localMMSightCircularProgressBar.LmQ.get(localMMSightCircularProgressBar.LmQ.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.LmQ.size() == 0))) {
        localMMSightCircularProgressBar.LmQ.add(Float.valueOf(localMMSightCircularProgressBar.tIG));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.tIT.reset();
    this.tIT.setVisibility(8);
    AppMethodBeat.o(94547);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94551);
    if (!this.enable)
    {
      ad.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
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
      if ((this.gAF) && (!this.LmS))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.tJb = true;
      this.tIQ = System.currentTimeMillis();
      this.tIU = false;
      this.tIV = false;
      this.seQ = paramMotionEvent.getRawY();
      if ((this.tJf != null) && (!this.gAF)) {
        this.tJf.bYA();
      }
      this.gAC.removeCallbacksAndMessages(null);
      if (!this.gAF)
      {
        this.gAC.postDelayed(this.fPp, 550L);
        this.gAC.postDelayed(this.tJm, 250L);
      }
      this.tJl = true;
      this.tJk = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.tIV) || (!this.LmS))) {
        if (this.seQ <= 0.0F)
        {
          this.seQ = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.seQ);
          int i;
          if ((f1 < this.seQ) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ad.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.tJk) });
            i = Math.min(i, 3);
            if (this.tJg != null)
            {
              paramMotionEvent = this.tJg;
              if (this.tJk) {
                i = 1;
              }
              paramMotionEvent.AW(i);
            }
            this.seQ = f1;
            this.tJk = false;
          }
          else if ((f1 > this.seQ) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ad.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.tJl) });
            i = Math.min(i, 3);
            if (this.tJg != null)
            {
              paramMotionEvent = this.tJg;
              if (this.tJl) {
                i = 1;
              }
              paramMotionEvent.AX(i);
            }
            this.tJl = false;
            this.seQ = f1;
            continue;
            this.tJb = false;
            this.gAC.removeCallbacks(this.tJm, Integer.valueOf(Mw));
            this.gAC.removeCallbacks(this.fPp);
            if ((this.tIW != null) && (this.tIX != null))
            {
              this.tIW.cancel();
              this.tIX.cancel();
            }
            final long l = System.currentTimeMillis() - this.tIQ;
            ad.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.tIV), Boolean.valueOf(this.tIU), Long.valueOf(this.tIQ), Long.valueOf(l) });
            hideProgress();
            e(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(94537);
                if ((MMSightRecordButton.i(MMSightRecordButton.this) > 0L) && (l <= 500L) && (!MMSightRecordButton.d(MMSightRecordButton.this)))
                {
                  ad.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.d(MMSightRecordButton.this)) });
                  MMSightRecordButton.c(MMSightRecordButton.this);
                  if (!MMSightRecordButton.d(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                    if (MMSightRecordButton.k(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.k(MMSightRecordButton.this).bYC();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else if (MMSightRecordButton.d(MMSightRecordButton.this))
                {
                  ad.i("MicroMsg.MMSightRecordButton", "on Long Press finish ，isRecordIng:%b", new Object[] { Boolean.valueOf(MMSightRecordButton.l(MMSightRecordButton.this)) });
                  if (MMSightRecordButton.l(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.a(MMSightRecordButton.this);
                    if (MMSightRecordButton.f(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.f(MMSightRecordButton.this).bYz();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else
                {
                  ad.i("MicroMsg.MMSightRecordButton", "error action up");
                  if (MMSightRecordButton.l(MMSightRecordButton.this)) {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                  }
                  if (MMSightRecordButton.m(MMSightRecordButton.this) != null) {
                    MMSightRecordButton.m(MMSightRecordButton.this).cQJ();
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
    this.tIR.setScaleX(1.0F);
    this.tIR.setScaleY(1.0F);
    this.tIS.setScaleX(1.0F);
    this.tIS.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    this.tIT.reset();
    AppMethodBeat.o(94550);
  }
  
  public void setErrorPressCallback(MMSightRecordButton.a parama)
  {
    this.tJh = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.tJd = paramInt;
    if ((this.tJj instanceof GradientDrawable)) {
      ((GradientDrawable)this.tJj).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.tJi instanceof GradientDrawable)) {
      ((GradientDrawable)this.tJi).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.tJf = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.tJg = paramc;
  }
  
  public void setSimpleTapCallback(MMSightRecordButton.d paramd)
  {
    this.tJe = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(94543);
    ad.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(94543);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(94549);
    ad.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new MMSightRecordButton.4(this, paramInt), 150L);
      AppMethodBeat.o(94549);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(94549);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(205859);
    ad.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(205859);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(205864);
    if ((this.gAF) && (!this.tJb))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(205864);
  }
  
  public final void yX(boolean paramBoolean)
  {
    AppMethodBeat.i(205860);
    this.LmS = paramBoolean;
    this.tIT.setEnableSubProgress(paramBoolean);
    this.tIT.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.tIT.setVisibility(4);
      AppMethodBeat.o(205860);
      return;
    }
    this.tIT.reset();
    this.tIT.setVisibility(0);
    AppMethodBeat.o(205860);
  }
  
  public final void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(205862);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.tIT;
    localMMSightCircularProgressBar.LmU = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(205862);
  }
  
  public static abstract interface b
  {
    public abstract void bYA();
    
    public abstract void bYz();
    
    public abstract void jd();
  }
  
  public static abstract interface c
  {
    public abstract void AW(int paramInt);
    
    public abstract void AX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */