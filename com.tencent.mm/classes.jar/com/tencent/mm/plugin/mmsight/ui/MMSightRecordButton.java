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
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.List;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final float LbE;
  private static final int bsP;
  private boolean AYD;
  private long LbF;
  private View LbG;
  private View LbH;
  private View LbI;
  private MMSightCircularProgressBar LbJ;
  private boolean LbK;
  private boolean LbL;
  private ViewPropertyAnimator LbM;
  private ViewPropertyAnimator LbN;
  private ValueAnimator LbO;
  private ValueAnimator LbP;
  private ViewPropertyAnimator LbQ;
  private ViewPropertyAnimator LbR;
  private int LbS;
  private int LbT;
  private int LbU;
  private int LbV;
  private d LbW;
  private b LbX;
  private c LbY;
  private a LbZ;
  public boolean Lbz;
  private Drawable Lca;
  private Drawable Lcb;
  private boolean Lcc;
  private boolean Lcd;
  public boolean Lce;
  private Runnable Lcf;
  private float cxN;
  private boolean enable;
  private boolean isAnimating;
  private MMHandler mRi;
  private Runnable mkq;
  public boolean nJm;
  
  static
  {
    AppMethodBeat.i(94555);
    bsP = ViewConfiguration.getTapTimeout();
    LbE = MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_max) / MMApplicationContext.getContext().getResources().getDimensionPixelSize(a.c.mmsight_recorder_button_outer_size_init);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.LbF = -1L;
    this.nJm = false;
    this.LbK = false;
    this.LbL = false;
    this.isAnimating = false;
    this.AYD = false;
    this.LbU = -1;
    this.LbV = -2130706433;
    this.cxN = -1.0F;
    this.enable = true;
    this.Lcc = false;
    this.Lcd = false;
    this.Lbz = false;
    this.Lce = false;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.mkq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).eI();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.Lcf = new MMSightRecordButton.6(this);
    init();
    AppMethodBeat.o(94538);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94539);
    this.LbF = -1L;
    this.nJm = false;
    this.LbK = false;
    this.LbL = false;
    this.isAnimating = false;
    this.AYD = false;
    this.LbU = -1;
    this.LbV = -2130706433;
    this.cxN = -1.0F;
    this.enable = true;
    this.Lcc = false;
    this.Lcd = false;
    this.Lbz = false;
    this.Lce = false;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.mkq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).eI();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.Lcf = new MMSightRecordButton.6(this);
    init();
    AppMethodBeat.o(94539);
  }
  
  private void f(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.LbQ != null)
    {
      this.LbQ.cancel();
      this.LbQ = null;
    }
    this.LbQ = this.LbG.animate().scaleX(1.0F).scaleY(1.0F);
    this.LbQ.setListener(new AnimatorListenerAdapter()
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
    this.LbR = this.LbH.animate().scaleX(1.0F).scaleY(1.0F);
    this.LbR.setDuration(150L).start();
    if (this.LbP != null) {
      this.LbP.cancel();
    }
    this.LbP = ObjectAnimator.ofInt(this.Lca, "color", new int[] { this.LbV, this.LbU });
    this.LbP.setDuration(150L);
    this.LbP.setEvaluator(a.getInstance());
    this.LbP.start();
    if (this.LbT != this.LbS)
    {
      if (this.LbO != null) {
        this.LbO.cancel();
      }
      this.LbO = ObjectAnimator.ofInt(this.Lcb, "color", new int[] { this.LbS, this.LbT });
      this.LbO.setDuration(150L);
      this.LbO.setEvaluator(a.getInstance());
      this.LbO.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void gdd()
  {
    AppMethodBeat.i(303642);
    Log.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.LbM != null)
    {
      this.LbM.cancel();
      this.LbM = null;
    }
    this.LbM = this.LbG.animate().scaleX(0.5F).scaleY(0.5F);
    this.LbM.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.Lck != null) {
          this.Lck.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.Lck != null) {
          this.Lck.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.LbN != null)
    {
      this.LbN.cancel();
      this.LbN = null;
    }
    this.LbN = this.LbH.animate().scaleX(LbE).scaleY(LbE);
    this.LbN.setDuration(150L).start();
    if (this.LbT != this.LbS)
    {
      if (this.LbO != null) {
        this.LbO.cancel();
      }
      this.LbO = ObjectAnimator.ofInt(this.Lcb, "color", new int[] { this.LbT, this.LbS });
      this.LbO.setDuration(150L);
      this.LbO.setEvaluator(a.getInstance());
      this.LbO.start();
    }
    if (this.LbP != null) {
      this.LbP.cancel();
    }
    this.LbP = ObjectAnimator.ofInt(this.Lca, "color", new int[] { this.LbU, this.LbV });
    this.LbP.setDuration(150L);
    this.LbP.setEvaluator(a.getInstance());
    this.LbP.start();
    AppMethodBeat.o(303642);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(bsP) });
    this.Lca = getContext().getResources().getDrawable(a.d.mmsight_recorder_button_inner);
    this.Lcb = getContext().getResources().getDrawable(a.d.mmsight_recorder_button_outer);
    af.mU(getContext()).inflate(a.f.mmsight_recorder_button, this, true);
    this.LbG = findViewById(a.e.inner);
    this.LbH = findViewById(a.e.outer);
    this.LbI = findViewById(a.e.progress_bar);
    this.LbJ = ((MMSightCircularProgressBar)findViewById(a.e.circular_progress));
    this.LbG.setBackgroundDrawable(this.Lca);
    this.LbH.setBackgroundDrawable(this.Lcb);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    Log.printInfoStack("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.nJm = true;
    this.LbJ.setInitProgress(0);
    this.LbJ.setMaxProgress(100);
    this.LbJ.setDuration(paramInt1);
    if (!this.Lbz) {
      this.LbJ.setVisibility(0);
    }
    this.LbJ.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void ad(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(303626);
        if (parama != null) {
          parama.ad(paramAnonymousArrayList);
        }
        AppMethodBeat.o(303626);
      }
      
      public final void ov(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(303625);
        Log.printInfoStack("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            Log.printInfoStack("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.Lcg != null) {
              MMSightRecordButton.1.this.Lcg.ov(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(303625);
      }
    };
    this.LbJ.setProgressCallback(parama);
    this.LbJ.start();
    AppMethodBeat.o(94546);
  }
  
  public final void abi(int paramInt)
  {
    AppMethodBeat.i(303666);
    int i = this.LbJ.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.LbJ;
      if (localMMSightCircularProgressBar.Lbx.size() > 0)
      {
        localMMSightCircularProgressBar.Lbx.remove(localMMSightCircularProgressBar.Lbx.size() - 1);
        if (localMMSightCircularProgressBar.Lbx.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.Lbs = ((Float)localMMSightCircularProgressBar.Lbx.get(localMMSightCircularProgressBar.Lbx.size() - 1)).floatValue();; localMMSightCircularProgressBar.Lbs = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(303666);
      return;
    }
  }
  
  public final void gdb()
  {
    AppMethodBeat.i(94545);
    Log.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.LbI.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void gdc()
  {
    AppMethodBeat.i(303665);
    this.LbJ.setVisibility(0);
    AppMethodBeat.o(303665);
  }
  
  public List<Float> getSubProgress()
  {
    AppMethodBeat.i(303667);
    ArrayList localArrayList = this.LbJ.getSubProgress();
    AppMethodBeat.o(303667);
    return localArrayList;
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.Lbz)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.LbJ;
      if (localMMSightCircularProgressBar.Lbv != null)
      {
        localMMSightCircularProgressBar.Lbv.cancel();
        localMMSightCircularProgressBar.Lbv = null;
      }
      if ((localMMSightCircularProgressBar.Lbs > 0.0F) && (((localMMSightCircularProgressBar.Lbx.size() > 0) && (localMMSightCircularProgressBar.Lbs > ((Float)localMMSightCircularProgressBar.Lbx.get(localMMSightCircularProgressBar.Lbx.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.Lbx.size() == 0))) {
        localMMSightCircularProgressBar.Lbx.add(Float.valueOf(localMMSightCircularProgressBar.Lbs));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.LbJ.reset();
    this.LbJ.setVisibility(8);
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
      if ((this.nJm) && (!this.Lbz) && (!this.Lce))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.AYD = true;
      this.LbF = System.currentTimeMillis();
      this.LbK = false;
      this.LbL = false;
      this.cxN = paramMotionEvent.getRawY();
      if ((this.LbX != null) && (!this.nJm)) {
        this.LbX.dEL();
      }
      this.mRi.removeCallbacksAndMessages(null);
      if (!this.nJm)
      {
        this.mRi.postDelayed(this.mkq, 550L);
        this.mRi.postDelayed(this.Lcf, 250L);
      }
      this.Lcd = true;
      this.Lcc = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.LbL) || (!this.Lbz))) {
        if (this.cxN <= 0.0F)
        {
          this.cxN = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.cxN);
          int i;
          if ((f1 < this.cxN) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Lcc) });
            i = Math.min(i, 3);
            if (this.LbY != null)
            {
              paramMotionEvent = this.LbY;
              if (this.Lcc) {
                i = 1;
              }
              paramMotionEvent.KY(i);
            }
            this.cxN = f1;
            this.Lcc = false;
          }
          else if ((f1 > this.cxN) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Lcd) });
            i = Math.min(i, 3);
            if (this.LbY != null)
            {
              paramMotionEvent = this.LbY;
              if (this.Lcd) {
                i = 1;
              }
              paramMotionEvent.KZ(i);
            }
            this.Lcd = false;
            this.cxN = f1;
            continue;
            this.AYD = false;
            this.mRi.removeCallbacks(this.Lcf, Integer.valueOf(bsP));
            this.mRi.removeCallbacks(this.mkq);
            if ((this.LbM != null) && (this.LbN != null))
            {
              this.LbM.cancel();
              this.LbN.cancel();
            }
            final long l = System.currentTimeMillis() - this.LbF;
            Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.LbL), Boolean.valueOf(this.LbK), Long.valueOf(this.LbF), Long.valueOf(l) });
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
                      MMSightRecordButton.k(MMSightRecordButton.this).onSimpleTap();
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
                    MMSightRecordButton.e(MMSightRecordButton.this).dEK();
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
                    MMSightRecordButton.m(MMSightRecordButton.this).gde();
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
    this.LbG.setScaleX(1.0F);
    this.LbG.setScaleY(1.0F);
    this.LbH.setScaleX(1.0F);
    this.LbH.setScaleY(1.0F);
    this.LbI.setVisibility(8);
    hideProgress();
    this.LbJ.reset();
    AppMethodBeat.o(94550);
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.LbZ = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.LbT = paramInt;
    if ((this.Lcb instanceof GradientDrawable)) {
      ((GradientDrawable)this.Lcb).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.Lca instanceof GradientDrawable)) {
      ((GradientDrawable)this.Lca).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.LbX = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.LbY = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.LbW = paramd;
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
    AppMethodBeat.i(303663);
    Log.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.LbI.setVisibility(0);
    AppMethodBeat.o(303663);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(303671);
    if ((this.nJm) && (!this.AYD))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(303671);
  }
  
  public final void yB(boolean paramBoolean)
  {
    AppMethodBeat.i(303664);
    this.Lbz = paramBoolean;
    this.LbJ.setEnableSubProgress(paramBoolean);
    this.LbJ.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.LbJ.setVisibility(4);
      AppMethodBeat.o(303664);
      return;
    }
    this.LbJ.reset();
    this.LbJ.setVisibility(0);
    AppMethodBeat.o(303664);
  }
  
  public final void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(303668);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.LbJ;
    localMMSightCircularProgressBar.LbB = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(303668);
  }
  
  public static abstract interface a
  {
    public abstract void gde();
  }
  
  public static abstract interface b
  {
    public abstract void dEK();
    
    public abstract void dEL();
    
    public abstract void eI();
  }
  
  public static abstract interface c
  {
    public abstract void KY(int paramInt);
    
    public abstract void KZ(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void onSimpleTap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */