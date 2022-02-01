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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;
import java.util.ArrayList;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int Nt;
  private static final float uRv;
  private boolean enable;
  private Runnable fTk;
  private ao gox;
  private boolean hba;
  private boolean isAnimating;
  private View progressBar;
  private float tmJ;
  private boolean uRA;
  private boolean uRB;
  private ViewPropertyAnimator uRC;
  private ViewPropertyAnimator uRD;
  private ValueAnimator uRE;
  private ValueAnimator uRF;
  private ViewPropertyAnimator uRG;
  private ViewPropertyAnimator uRH;
  private boolean uRI;
  private int uRJ;
  private int uRK;
  private int uRL;
  private int uRM;
  private d uRN;
  private b uRO;
  private c uRP;
  private a uRQ;
  private Drawable uRR;
  private Drawable uRS;
  private boolean uRT;
  private boolean uRU;
  private Runnable uRV;
  private boolean uRq;
  private long uRw;
  private View uRx;
  private View uRy;
  private MMSightCircularProgressBar uRz;
  
  static
  {
    AppMethodBeat.i(94555);
    Nt = ViewConfiguration.getTapTimeout();
    uRv = ai.getContext().getResources().getDimensionPixelSize(2131166579) / ai.getContext().getResources().getDimensionPixelSize(2131166578);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.uRw = -1L;
    this.hba = false;
    this.uRA = false;
    this.uRB = false;
    this.isAnimating = false;
    this.uRI = false;
    this.uRL = -1;
    this.uRM = -2130706433;
    this.tmJ = -1.0F;
    this.enable = true;
    this.uRT = false;
    this.uRU = false;
    this.uRq = false;
    this.gox = new ao(Looper.getMainLooper());
    this.fTk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ac.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).jl();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.uRV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ac.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
        if (MMSightRecordButton.f(MMSightRecordButton.this)) {
          MMSightRecordButton.g(MMSightRecordButton.this);
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
    this.uRw = -1L;
    this.hba = false;
    this.uRA = false;
    this.uRB = false;
    this.isAnimating = false;
    this.uRI = false;
    this.uRL = -1;
    this.uRM = -2130706433;
    this.tmJ = -1.0F;
    this.enable = true;
    this.uRT = false;
    this.uRU = false;
    this.uRq = false;
    this.gox = new ao(Looper.getMainLooper());
    this.fTk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ac.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).jl();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.uRV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ac.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
        if (MMSightRecordButton.f(MMSightRecordButton.this)) {
          MMSightRecordButton.g(MMSightRecordButton.this);
        }
        AppMethodBeat.o(94536);
      }
    };
    init();
    AppMethodBeat.o(94539);
  }
  
  private void des()
  {
    AppMethodBeat.i(209946);
    ac.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.uRC != null)
    {
      this.uRC.cancel();
      this.uRC = null;
    }
    this.uRC = this.uRx.animate().scaleX(0.5F).scaleY(0.5F);
    this.uRC.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.uSa != null) {
          this.uSa.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.uSa != null) {
          this.uSa.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.uRD != null)
    {
      this.uRD.cancel();
      this.uRD = null;
    }
    this.uRD = this.uRy.animate().scaleX(uRv).scaleY(uRv);
    this.uRD.setDuration(150L).start();
    if (this.uRK != this.uRJ)
    {
      if (this.uRE != null) {
        this.uRE.cancel();
      }
      this.uRE = ObjectAnimator.ofInt(this.uRS, "color", new int[] { this.uRK, this.uRJ });
      this.uRE.setDuration(150L);
      this.uRE.setEvaluator(a.getInstance());
      this.uRE.start();
    }
    if (this.uRF != null) {
      this.uRF.cancel();
    }
    this.uRF = ObjectAnimator.ofInt(this.uRR, "color", new int[] { this.uRL, this.uRM });
    this.uRF.setDuration(150L);
    this.uRF.setEvaluator(a.getInstance());
    this.uRF.start();
    AppMethodBeat.o(209946);
  }
  
  private void e(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.uRG != null)
    {
      this.uRG.cancel();
      this.uRG = null;
    }
    this.uRG = this.uRx.animate().scaleX(1.0F).scaleY(1.0F);
    this.uRG.setListener(new AnimatorListenerAdapter()
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
    this.uRH = this.uRy.animate().scaleX(1.0F).scaleY(1.0F);
    this.uRH.setDuration(150L).start();
    if (this.uRF != null) {
      this.uRF.cancel();
    }
    this.uRF = ObjectAnimator.ofInt(this.uRR, "color", new int[] { this.uRM, this.uRL });
    this.uRF.setDuration(150L);
    this.uRF.setEvaluator(a.getInstance());
    this.uRF.start();
    if (this.uRK != this.uRJ)
    {
      if (this.uRE != null) {
        this.uRE.cancel();
      }
      this.uRE = ObjectAnimator.ofInt(this.uRS, "color", new int[] { this.uRJ, this.uRK });
      this.uRE.setDuration(150L);
      this.uRE.setEvaluator(a.getInstance());
      this.uRE.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    ac.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Nt) });
    this.uRR = getContext().getResources().getDrawable(2131233311);
    this.uRS = getContext().getResources().getDrawable(2131233312);
    z.jD(getContext()).inflate(2131494919, this, true);
    this.uRx = findViewById(2131301021);
    this.uRy = findViewById(2131303113);
    this.progressBar = findViewById(2131303518);
    this.uRz = ((MMSightCircularProgressBar)findViewById(2131298337));
    this.uRx.setBackgroundDrawable(this.uRR);
    this.uRy.setBackgroundDrawable(this.uRS);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void IV(int paramInt)
  {
    AppMethodBeat.i(209944);
    int i = this.uRz.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.uRz;
      if (localMMSightCircularProgressBar.uRo.size() > 0)
      {
        localMMSightCircularProgressBar.uRo.remove(localMMSightCircularProgressBar.uRo.size() - 1);
        if (localMMSightCircularProgressBar.uRo.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.uRj = ((Float)localMMSightCircularProgressBar.uRo.get(localMMSightCircularProgressBar.uRo.size() - 1)).floatValue();; localMMSightCircularProgressBar.uRj = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(209944);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    ac.m("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.hba = true;
    this.uRz.setInitProgress(0);
    this.uRz.setMaxProgress(100);
    this.uRz.setDuration(paramInt1);
    if (!this.uRq) {
      this.uRz.setVisibility(0);
    }
    this.uRz.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void S(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(209941);
        if (parama != null) {
          parama.S(paramAnonymousArrayList);
        }
        AppMethodBeat.o(209941);
      }
      
      public final void kw(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(209940);
        ac.m("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            ac.m("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.uRW != null) {
              MMSightRecordButton.1.this.uRW.kw(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(209940);
      }
    };
    this.uRz.setProgressCallback(parama);
    parama = this.uRz;
    ac.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(parama.uRk), Integer.valueOf(parama.uRl), Integer.valueOf(parama.duration), Float.valueOf(parama.uRj) });
    parama.isStart = true;
    if (parama.uRm != null)
    {
      parama.uRm.cancel();
      parama.uRm = null;
    }
    parama.uRm = new c(parama.uRj, parama.uRl, parama.duration);
    c localc = parama.uRm;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    ac.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.uSX = local1;
    parama = parama.uRm;
    ac.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.fQT = bs.Gn();
    parama.hNn.au(20L, 20L);
    AppMethodBeat.o(94546);
  }
  
  public final void der()
  {
    AppMethodBeat.i(94545);
    ac.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.uRq)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.uRz;
      if (localMMSightCircularProgressBar.uRm != null)
      {
        localMMSightCircularProgressBar.uRm.cancel();
        localMMSightCircularProgressBar.uRm = null;
      }
      if ((localMMSightCircularProgressBar.uRj > 0.0F) && (((localMMSightCircularProgressBar.uRo.size() > 0) && (localMMSightCircularProgressBar.uRj > ((Float)localMMSightCircularProgressBar.uRo.get(localMMSightCircularProgressBar.uRo.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.uRo.size() == 0))) {
        localMMSightCircularProgressBar.uRo.add(Float.valueOf(localMMSightCircularProgressBar.uRj));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.uRz.reset();
    this.uRz.setVisibility(8);
    AppMethodBeat.o(94547);
  }
  
  public final void od(boolean paramBoolean)
  {
    AppMethodBeat.i(209943);
    this.uRq = paramBoolean;
    this.uRz.setEnableSubProgress(paramBoolean);
    this.uRz.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.uRz.setVisibility(4);
      AppMethodBeat.o(209943);
      return;
    }
    this.uRz.reset();
    this.uRz.setVisibility(0);
    AppMethodBeat.o(209943);
  }
  
  public final void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(209945);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.uRz;
    localMMSightCircularProgressBar.uRs = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(209945);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94551);
    if (!this.enable)
    {
      ac.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
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
      if ((this.hba) && (!this.uRq))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.uRI = true;
      this.uRw = System.currentTimeMillis();
      this.uRA = false;
      this.uRB = false;
      this.tmJ = paramMotionEvent.getRawY();
      if ((this.uRO != null) && (!this.hba)) {
        this.uRO.cfO();
      }
      this.gox.removeCallbacksAndMessages(null);
      if (!this.hba)
      {
        this.gox.postDelayed(this.fTk, 550L);
        this.gox.postDelayed(this.uRV, 250L);
      }
      this.uRU = true;
      this.uRT = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.uRB) || (!this.uRq))) {
        if (this.tmJ <= 0.0F)
        {
          this.tmJ = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.tmJ);
          int i;
          if ((f1 < this.tmJ) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ac.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.uRT) });
            i = Math.min(i, 3);
            if (this.uRP != null)
            {
              paramMotionEvent = this.uRP;
              if (this.uRT) {
                i = 1;
              }
              paramMotionEvent.BO(i);
            }
            this.tmJ = f1;
            this.uRT = false;
          }
          else if ((f1 > this.tmJ) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ac.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.uRU) });
            i = Math.min(i, 3);
            if (this.uRP != null)
            {
              paramMotionEvent = this.uRP;
              if (this.uRU) {
                i = 1;
              }
              paramMotionEvent.BP(i);
            }
            this.uRU = false;
            this.tmJ = f1;
            continue;
            this.uRI = false;
            this.gox.removeCallbacks(this.uRV, Integer.valueOf(Nt));
            this.gox.removeCallbacks(this.fTk);
            if ((this.uRC != null) && (this.uRD != null))
            {
              this.uRC.cancel();
              this.uRD.cancel();
            }
            final long l = System.currentTimeMillis() - this.uRw;
            ac.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.uRB), Boolean.valueOf(this.uRA), Long.valueOf(this.uRw), Long.valueOf(l) });
            hideProgress();
            e(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(94537);
                if ((MMSightRecordButton.h(MMSightRecordButton.this) > 0L) && (l <= 500L) && (!MMSightRecordButton.c(MMSightRecordButton.this)))
                {
                  ac.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
                  MMSightRecordButton.i(MMSightRecordButton.this);
                  if (!MMSightRecordButton.c(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                    if (MMSightRecordButton.k(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.k(MMSightRecordButton.this).cfP();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else if (MMSightRecordButton.c(MMSightRecordButton.this))
                {
                  ac.i("MicroMsg.MMSightRecordButton", "on Long Press finish ，isRecordIng:%b", new Object[] { Boolean.valueOf(MMSightRecordButton.l(MMSightRecordButton.this)) });
                  if (MMSightRecordButton.l(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.a(MMSightRecordButton.this);
                    if (MMSightRecordButton.e(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.e(MMSightRecordButton.this).cfN();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else
                {
                  ac.i("MicroMsg.MMSightRecordButton", "error action up");
                  if (MMSightRecordButton.l(MMSightRecordButton.this)) {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                  }
                  if (MMSightRecordButton.m(MMSightRecordButton.this) != null) {
                    MMSightRecordButton.m(MMSightRecordButton.this).det();
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
    this.uRx.setScaleX(1.0F);
    this.uRx.setScaleY(1.0F);
    this.uRy.setScaleX(1.0F);
    this.uRy.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    this.uRz.reset();
    AppMethodBeat.o(94550);
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.uRQ = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.uRK = paramInt;
    if ((this.uRS instanceof GradientDrawable)) {
      ((GradientDrawable)this.uRS).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.uRR instanceof GradientDrawable)) {
      ((GradientDrawable)this.uRR).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.uRO = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.uRP = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.uRN = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(94543);
    ac.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(94543);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(94549);
    ac.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
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
    AppMethodBeat.i(209942);
    ac.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(209942);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(209947);
    if ((this.hba) && (!this.uRI))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(209947);
  }
  
  public static abstract interface a
  {
    public abstract void det();
  }
  
  public static abstract interface b
  {
    public abstract void cfN();
    
    public abstract void cfO();
    
    public abstract void jl();
  }
  
  public static abstract interface c
  {
    public abstract void BO(int paramInt);
    
    public abstract void BP(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void cfP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */