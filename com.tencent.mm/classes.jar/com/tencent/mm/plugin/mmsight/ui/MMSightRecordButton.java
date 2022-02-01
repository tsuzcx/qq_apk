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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import java.util.ArrayList;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int Pk;
  private static final float wgJ;
  private float aTM;
  private boolean enable;
  private aq gKO;
  private Runnable gpk;
  private boolean hvU;
  private boolean isAnimating;
  private View progressBar;
  private boolean svS;
  private boolean wgE;
  private long wgK;
  private View wgL;
  private View wgM;
  private MMSightCircularProgressBar wgN;
  private boolean wgO;
  private boolean wgP;
  private ViewPropertyAnimator wgQ;
  private ViewPropertyAnimator wgR;
  private ValueAnimator wgS;
  private ValueAnimator wgT;
  private ViewPropertyAnimator wgU;
  private ViewPropertyAnimator wgV;
  private int wgW;
  private int wgX;
  private int wgY;
  private int wgZ;
  private d wha;
  private b whb;
  private c whc;
  private a whd;
  private Drawable whe;
  private Drawable whf;
  private boolean whg;
  private boolean whh;
  private Runnable whi;
  
  static
  {
    AppMethodBeat.i(94555);
    Pk = ViewConfiguration.getTapTimeout();
    wgJ = ak.getContext().getResources().getDimensionPixelSize(2131166579) / ak.getContext().getResources().getDimensionPixelSize(2131166578);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.wgK = -1L;
    this.hvU = false;
    this.wgO = false;
    this.wgP = false;
    this.isAnimating = false;
    this.svS = false;
    this.wgY = -1;
    this.wgZ = -2130706433;
    this.aTM = -1.0F;
    this.enable = true;
    this.whg = false;
    this.whh = false;
    this.wgE = false;
    this.gKO = new aq(Looper.getMainLooper());
    this.gpk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ae.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).jB();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.whi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ae.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
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
    this.wgK = -1L;
    this.hvU = false;
    this.wgO = false;
    this.wgP = false;
    this.isAnimating = false;
    this.svS = false;
    this.wgY = -1;
    this.wgZ = -2130706433;
    this.aTM = -1.0F;
    this.enable = true;
    this.whg = false;
    this.whh = false;
    this.wgE = false;
    this.gKO = new aq(Looper.getMainLooper());
    this.gpk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ae.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).jB();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.whi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ae.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
        if (MMSightRecordButton.f(MMSightRecordButton.this)) {
          MMSightRecordButton.g(MMSightRecordButton.this);
        }
        AppMethodBeat.o(94536);
      }
    };
    init();
    AppMethodBeat.o(94539);
  }
  
  private void dqO()
  {
    AppMethodBeat.i(189043);
    ae.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.wgQ != null)
    {
      this.wgQ.cancel();
      this.wgQ = null;
    }
    this.wgQ = this.wgL.animate().scaleX(0.5F).scaleY(0.5F);
    this.wgQ.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.whn != null) {
          this.whn.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.whn != null) {
          this.whn.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.wgR != null)
    {
      this.wgR.cancel();
      this.wgR = null;
    }
    this.wgR = this.wgM.animate().scaleX(wgJ).scaleY(wgJ);
    this.wgR.setDuration(150L).start();
    if (this.wgX != this.wgW)
    {
      if (this.wgS != null) {
        this.wgS.cancel();
      }
      this.wgS = ObjectAnimator.ofInt(this.whf, "color", new int[] { this.wgX, this.wgW });
      this.wgS.setDuration(150L);
      this.wgS.setEvaluator(a.getInstance());
      this.wgS.start();
    }
    if (this.wgT != null) {
      this.wgT.cancel();
    }
    this.wgT = ObjectAnimator.ofInt(this.whe, "color", new int[] { this.wgY, this.wgZ });
    this.wgT.setDuration(150L);
    this.wgT.setEvaluator(a.getInstance());
    this.wgT.start();
    AppMethodBeat.o(189043);
  }
  
  private void e(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.wgU != null)
    {
      this.wgU.cancel();
      this.wgU = null;
    }
    this.wgU = this.wgL.animate().scaleX(1.0F).scaleY(1.0F);
    this.wgU.setListener(new AnimatorListenerAdapter()
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
    this.wgV = this.wgM.animate().scaleX(1.0F).scaleY(1.0F);
    this.wgV.setDuration(150L).start();
    if (this.wgT != null) {
      this.wgT.cancel();
    }
    this.wgT = ObjectAnimator.ofInt(this.whe, "color", new int[] { this.wgZ, this.wgY });
    this.wgT.setDuration(150L);
    this.wgT.setEvaluator(a.getInstance());
    this.wgT.start();
    if (this.wgX != this.wgW)
    {
      if (this.wgS != null) {
        this.wgS.cancel();
      }
      this.wgS = ObjectAnimator.ofInt(this.whf, "color", new int[] { this.wgW, this.wgX });
      this.wgS.setDuration(150L);
      this.wgS.setEvaluator(a.getInstance());
      this.wgS.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    ae.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Pk) });
    this.whe = getContext().getResources().getDrawable(2131233311);
    this.whf = getContext().getResources().getDrawable(2131233312);
    z.jV(getContext()).inflate(2131494919, this, true);
    this.wgL = findViewById(2131301021);
    this.wgM = findViewById(2131303113);
    this.progressBar = findViewById(2131303518);
    this.wgN = ((MMSightCircularProgressBar)findViewById(2131298337));
    this.wgL.setBackgroundDrawable(this.whe);
    this.wgM.setBackgroundDrawable(this.whf);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void KS(int paramInt)
  {
    AppMethodBeat.i(189041);
    int i = this.wgN.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.wgN;
      if (localMMSightCircularProgressBar.wgC.size() > 0)
      {
        localMMSightCircularProgressBar.wgC.remove(localMMSightCircularProgressBar.wgC.size() - 1);
        if (localMMSightCircularProgressBar.wgC.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.wgx = ((Float)localMMSightCircularProgressBar.wgC.get(localMMSightCircularProgressBar.wgC.size() - 1)).floatValue();; localMMSightCircularProgressBar.wgx = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(189041);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    ae.m("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.hvU = true;
    this.wgN.setInitProgress(0);
    this.wgN.setMaxProgress(100);
    this.wgN.setDuration(paramInt1);
    if (!this.wgE) {
      this.wgN.setVisibility(0);
    }
    this.wgN.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void S(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(189038);
        if (parama != null) {
          parama.S(paramAnonymousArrayList);
        }
        AppMethodBeat.o(189038);
      }
      
      public final void kI(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(189037);
        ae.m("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            ae.m("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.whj != null) {
              MMSightRecordButton.1.this.whj.kI(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(189037);
      }
    };
    this.wgN.setProgressCallback(parama);
    parama = this.wgN;
    ae.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(parama.wgy), Integer.valueOf(parama.wgz), Integer.valueOf(parama.duration), Float.valueOf(parama.wgx) });
    parama.isStart = true;
    if (parama.wgA != null)
    {
      parama.wgA.cancel();
      parama.wgA = null;
    }
    parama.wgA = new c(parama.wgx, parama.wgz, parama.duration);
    c localc = parama.wgA;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    ae.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.wil = local1;
    parama = parama.wgA;
    ae.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.gmN = bu.HQ();
    parama.ijv.ay(20L, 20L);
    AppMethodBeat.o(94546);
  }
  
  public final void dqN()
  {
    AppMethodBeat.i(94545);
    ae.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.wgE)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.wgN;
      if (localMMSightCircularProgressBar.wgA != null)
      {
        localMMSightCircularProgressBar.wgA.cancel();
        localMMSightCircularProgressBar.wgA = null;
      }
      if ((localMMSightCircularProgressBar.wgx > 0.0F) && (((localMMSightCircularProgressBar.wgC.size() > 0) && (localMMSightCircularProgressBar.wgx > ((Float)localMMSightCircularProgressBar.wgC.get(localMMSightCircularProgressBar.wgC.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.wgC.size() == 0))) {
        localMMSightCircularProgressBar.wgC.add(Float.valueOf(localMMSightCircularProgressBar.wgx));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.wgN.reset();
    this.wgN.setVisibility(8);
    AppMethodBeat.o(94547);
  }
  
  public final void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(189040);
    this.wgE = paramBoolean;
    this.wgN.setEnableSubProgress(paramBoolean);
    this.wgN.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.wgN.setVisibility(4);
      AppMethodBeat.o(189040);
      return;
    }
    this.wgN.reset();
    this.wgN.setVisibility(0);
    AppMethodBeat.o(189040);
  }
  
  public final void oD(boolean paramBoolean)
  {
    AppMethodBeat.i(189042);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.wgN;
    localMMSightCircularProgressBar.wgG = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(189042);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(94551);
    if (!this.enable)
    {
      ae.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
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
      if ((this.hvU) && (!this.wgE))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.svS = true;
      this.wgK = System.currentTimeMillis();
      this.wgO = false;
      this.wgP = false;
      this.aTM = paramMotionEvent.getRawY();
      if ((this.whb != null) && (!this.hvU)) {
        this.whb.clH();
      }
      this.gKO.removeCallbacksAndMessages(null);
      if (!this.hvU)
      {
        this.gKO.postDelayed(this.gpk, 550L);
        this.gKO.postDelayed(this.whi, 250L);
      }
      this.whh = true;
      this.whg = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.wgP) || (!this.wgE))) {
        if (this.aTM <= 0.0F)
        {
          this.aTM = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.aTM);
          int i;
          if ((f1 < this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ae.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.whg) });
            i = Math.min(i, 3);
            if (this.whc != null)
            {
              paramMotionEvent = this.whc;
              if (this.whg) {
                i = 1;
              }
              paramMotionEvent.CI(i);
            }
            this.aTM = f1;
            this.whg = false;
          }
          else if ((f1 > this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ae.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.whh) });
            i = Math.min(i, 3);
            if (this.whc != null)
            {
              paramMotionEvent = this.whc;
              if (this.whh) {
                i = 1;
              }
              paramMotionEvent.CJ(i);
            }
            this.whh = false;
            this.aTM = f1;
            continue;
            this.svS = false;
            this.gKO.removeCallbacks(this.whi, Integer.valueOf(Pk));
            this.gKO.removeCallbacks(this.gpk);
            if ((this.wgQ != null) && (this.wgR != null))
            {
              this.wgQ.cancel();
              this.wgR.cancel();
            }
            final long l = System.currentTimeMillis() - this.wgK;
            ae.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.wgP), Boolean.valueOf(this.wgO), Long.valueOf(this.wgK), Long.valueOf(l) });
            hideProgress();
            e(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(94537);
                if ((MMSightRecordButton.h(MMSightRecordButton.this) > 0L) && (l <= 500L) && (!MMSightRecordButton.c(MMSightRecordButton.this)))
                {
                  ae.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
                  MMSightRecordButton.i(MMSightRecordButton.this);
                  if (!MMSightRecordButton.c(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                    if (MMSightRecordButton.k(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.k(MMSightRecordButton.this).clI();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else if (MMSightRecordButton.c(MMSightRecordButton.this))
                {
                  ae.i("MicroMsg.MMSightRecordButton", "on Long Press finish ，isRecordIng:%b", new Object[] { Boolean.valueOf(MMSightRecordButton.l(MMSightRecordButton.this)) });
                  if (MMSightRecordButton.l(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.a(MMSightRecordButton.this);
                    if (MMSightRecordButton.e(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.e(MMSightRecordButton.this).clG();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else
                {
                  ae.i("MicroMsg.MMSightRecordButton", "error action up");
                  if (MMSightRecordButton.l(MMSightRecordButton.this)) {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                  }
                  if (MMSightRecordButton.m(MMSightRecordButton.this) != null) {
                    MMSightRecordButton.m(MMSightRecordButton.this).dqP();
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
    this.wgL.setScaleX(1.0F);
    this.wgL.setScaleY(1.0F);
    this.wgM.setScaleX(1.0F);
    this.wgM.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    this.wgN.reset();
    AppMethodBeat.o(94550);
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.whd = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.wgX = paramInt;
    if ((this.whf instanceof GradientDrawable)) {
      ((GradientDrawable)this.whf).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.whe instanceof GradientDrawable)) {
      ((GradientDrawable)this.whe).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.whb = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.whc = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.wha = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(94543);
    ae.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(94543);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(94549);
    ae.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
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
    AppMethodBeat.i(189039);
    ae.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(189039);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(189044);
    if ((this.hvU) && (!this.svS))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(189044);
  }
  
  public static abstract interface a
  {
    public abstract void dqP();
  }
  
  public static abstract interface b
  {
    public abstract void clG();
    
    public abstract void clH();
    
    public abstract void jB();
  }
  
  public static abstract interface c
  {
    public abstract void CI(int paramInt);
    
    public abstract void CJ(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void clI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */