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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.List;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int Pw;
  private static final float zBj;
  private float aTE;
  private boolean enable;
  private MMHandler hAk;
  private Runnable had;
  private boolean ipv;
  private boolean isAnimating;
  private View progressBar;
  private boolean tQl;
  private d zBA;
  private b zBB;
  private c zBC;
  private a zBD;
  private Drawable zBE;
  private Drawable zBF;
  private boolean zBG;
  private boolean zBH;
  private Runnable zBI;
  private boolean zBe;
  private long zBk;
  private View zBl;
  private View zBm;
  private MMSightCircularProgressBar zBn;
  private boolean zBo;
  private boolean zBp;
  private ViewPropertyAnimator zBq;
  private ViewPropertyAnimator zBr;
  private ValueAnimator zBs;
  private ValueAnimator zBt;
  private ViewPropertyAnimator zBu;
  private ViewPropertyAnimator zBv;
  private int zBw;
  private int zBx;
  private int zBy;
  private int zBz;
  
  static
  {
    AppMethodBeat.i(94555);
    Pw = ViewConfiguration.getTapTimeout();
    zBj = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166695) / MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131166694);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.zBk = -1L;
    this.ipv = false;
    this.zBo = false;
    this.zBp = false;
    this.isAnimating = false;
    this.tQl = false;
    this.zBy = -1;
    this.zBz = -2130706433;
    this.aTE = -1.0F;
    this.enable = true;
    this.zBG = false;
    this.zBH = false;
    this.zBe = false;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.had = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).jK();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.zBI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
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
    this.zBk = -1L;
    this.ipv = false;
    this.zBo = false;
    this.zBp = false;
    this.isAnimating = false;
    this.tQl = false;
    this.zBy = -1;
    this.zBz = -2130706433;
    this.aTE = -1.0F;
    this.enable = true;
    this.zBG = false;
    this.zBH = false;
    this.zBe = false;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.had = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.b(MMSightRecordButton.this))
        {
          MMSightRecordButton.d(MMSightRecordButton.this);
          if (MMSightRecordButton.e(MMSightRecordButton.this) != null) {
            MMSightRecordButton.e(MMSightRecordButton.this).jK();
          }
        }
        AppMethodBeat.o(94535);
      }
    };
    this.zBI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
        if (MMSightRecordButton.f(MMSightRecordButton.this)) {
          MMSightRecordButton.g(MMSightRecordButton.this);
        }
        AppMethodBeat.o(94536);
      }
    };
    init();
    AppMethodBeat.o(94539);
  }
  
  private void ekH()
  {
    AppMethodBeat.i(187090);
    Log.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.zBq != null)
    {
      this.zBq.cancel();
      this.zBq = null;
    }
    this.zBq = this.zBl.animate().scaleX(0.5F).scaleY(0.5F);
    this.zBq.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.zBN != null) {
          this.zBN.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.zBN != null) {
          this.zBN.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.zBr != null)
    {
      this.zBr.cancel();
      this.zBr = null;
    }
    this.zBr = this.zBm.animate().scaleX(zBj).scaleY(zBj);
    this.zBr.setDuration(150L).start();
    if (this.zBx != this.zBw)
    {
      if (this.zBs != null) {
        this.zBs.cancel();
      }
      this.zBs = ObjectAnimator.ofInt(this.zBF, "color", new int[] { this.zBx, this.zBw });
      this.zBs.setDuration(150L);
      this.zBs.setEvaluator(a.getInstance());
      this.zBs.start();
    }
    if (this.zBt != null) {
      this.zBt.cancel();
    }
    this.zBt = ObjectAnimator.ofInt(this.zBE, "color", new int[] { this.zBy, this.zBz });
    this.zBt.setDuration(150L);
    this.zBt.setEvaluator(a.getInstance());
    this.zBt.start();
    AppMethodBeat.o(187090);
  }
  
  private void f(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.zBu != null)
    {
      this.zBu.cancel();
      this.zBu = null;
    }
    this.zBu = this.zBl.animate().scaleX(1.0F).scaleY(1.0F);
    this.zBu.setListener(new AnimatorListenerAdapter()
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
    this.zBv = this.zBm.animate().scaleX(1.0F).scaleY(1.0F);
    this.zBv.setDuration(150L).start();
    if (this.zBt != null) {
      this.zBt.cancel();
    }
    this.zBt = ObjectAnimator.ofInt(this.zBE, "color", new int[] { this.zBz, this.zBy });
    this.zBt.setDuration(150L);
    this.zBt.setEvaluator(a.getInstance());
    this.zBt.start();
    if (this.zBx != this.zBw)
    {
      if (this.zBs != null) {
        this.zBs.cancel();
      }
      this.zBs = ObjectAnimator.ofInt(this.zBF, "color", new int[] { this.zBw, this.zBx });
      this.zBs.setDuration(150L);
      this.zBs.setEvaluator(a.getInstance());
      this.zBs.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Pw) });
    this.zBE = getContext().getResources().getDrawable(2131233988);
    this.zBF = getContext().getResources().getDrawable(2131233989);
    aa.jQ(getContext()).inflate(2131495659, this, true);
    this.zBl = findViewById(2131302665);
    this.zBm = findViewById(2131305744);
    this.progressBar = findViewById(2131306284);
    this.zBn = ((MMSightCircularProgressBar)findViewById(2131298731));
    this.zBl.setBackgroundDrawable(this.zBE);
    this.zBm.setBackgroundDrawable(this.zBF);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void QS(int paramInt)
  {
    AppMethodBeat.i(187087);
    int i = this.zBn.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.zBn;
      if (localMMSightCircularProgressBar.zBc.size() > 0)
      {
        localMMSightCircularProgressBar.zBc.remove(localMMSightCircularProgressBar.zBc.size() - 1);
        if (localMMSightCircularProgressBar.zBc.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.zAX = ((Float)localMMSightCircularProgressBar.zBc.get(localMMSightCircularProgressBar.zBc.size() - 1)).floatValue();; localMMSightCircularProgressBar.zAX = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(187087);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    Log.printInfoStack("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.ipv = true;
    this.zBn.setInitProgress(0);
    this.zBn.setMaxProgress(100);
    this.zBn.setDuration(paramInt1);
    if (!this.zBe) {
      this.zBn.setVisibility(0);
    }
    this.zBn.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void Z(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(187083);
        if (parama != null) {
          parama.Z(paramAnonymousArrayList);
        }
        AppMethodBeat.o(187083);
      }
      
      public final void lK(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187082);
        Log.printInfoStack("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            Log.printInfoStack("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.zBJ != null) {
              MMSightRecordButton.1.this.zBJ.lK(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(187082);
      }
    };
    this.zBn.setProgressCallback(parama);
    parama = this.zBn;
    Log.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(parama.zAY), Integer.valueOf(parama.zAZ), Integer.valueOf(parama.duration), Float.valueOf(parama.zAX) });
    parama.isStart = true;
    if (parama.zBa != null)
    {
      parama.zBa.cancel();
      parama.zBa = null;
    }
    parama.zBa = new c(parama.zAX, parama.zAZ, parama.duration);
    c localc = parama.zBa;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    Log.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.zCL = local1;
    parama = parama.zBa;
    Log.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.gXF = Util.currentTicks();
    parama.jer.startTimer(20L);
    AppMethodBeat.o(94546);
  }
  
  public final void ekF()
  {
    AppMethodBeat.i(94545);
    Log.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void ekG()
  {
    AppMethodBeat.i(187086);
    this.zBn.setVisibility(0);
    AppMethodBeat.o(187086);
  }
  
  public final boolean ekI()
  {
    AppMethodBeat.i(187092);
    if ((!this.zBe) || (getSubProgress().isEmpty()))
    {
      AppMethodBeat.o(187092);
      return true;
    }
    AppMethodBeat.o(187092);
    return false;
  }
  
  public List<Float> getSubProgress()
  {
    AppMethodBeat.i(187088);
    ArrayList localArrayList = this.zBn.getSubProgress();
    AppMethodBeat.o(187088);
    return localArrayList;
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.zBe)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.zBn;
      if (localMMSightCircularProgressBar.zBa != null)
      {
        localMMSightCircularProgressBar.zBa.cancel();
        localMMSightCircularProgressBar.zBa = null;
      }
      if ((localMMSightCircularProgressBar.zAX > 0.0F) && (((localMMSightCircularProgressBar.zBc.size() > 0) && (localMMSightCircularProgressBar.zAX > ((Float)localMMSightCircularProgressBar.zBc.get(localMMSightCircularProgressBar.zBc.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.zBc.size() == 0))) {
        localMMSightCircularProgressBar.zBc.add(Float.valueOf(localMMSightCircularProgressBar.zAX));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.zBn.reset();
    this.zBn.setVisibility(8);
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
      if ((this.ipv) && (!this.zBe))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.tQl = true;
      this.zBk = System.currentTimeMillis();
      this.zBo = false;
      this.zBp = false;
      this.aTE = paramMotionEvent.getRawY();
      if ((this.zBB != null) && (!this.ipv)) {
        this.zBB.cJJ();
      }
      this.hAk.removeCallbacksAndMessages(null);
      if (!this.ipv)
      {
        this.hAk.postDelayed(this.had, 550L);
        this.hAk.postDelayed(this.zBI, 250L);
      }
      this.zBH = true;
      this.zBG = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.zBp) || (!this.zBe))) {
        if (this.aTE <= 0.0F)
        {
          this.aTE = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.aTE);
          int i;
          if ((f1 < this.aTE) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.zBG) });
            i = Math.min(i, 3);
            if (this.zBC != null)
            {
              paramMotionEvent = this.zBC;
              if (this.zBG) {
                i = 1;
              }
              paramMotionEvent.Gt(i);
            }
            this.aTE = f1;
            this.zBG = false;
          }
          else if ((f1 > this.aTE) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.zBH) });
            i = Math.min(i, 3);
            if (this.zBC != null)
            {
              paramMotionEvent = this.zBC;
              if (this.zBH) {
                i = 1;
              }
              paramMotionEvent.Gu(i);
            }
            this.zBH = false;
            this.aTE = f1;
            continue;
            this.tQl = false;
            this.hAk.removeCallbacks(this.zBI, Integer.valueOf(Pw));
            this.hAk.removeCallbacks(this.had);
            if ((this.zBq != null) && (this.zBr != null))
            {
              this.zBq.cancel();
              this.zBr.cancel();
            }
            final long l = System.currentTimeMillis() - this.zBk;
            Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.zBp), Boolean.valueOf(this.zBo), Long.valueOf(this.zBk), Long.valueOf(l) });
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
                      MMSightRecordButton.k(MMSightRecordButton.this).cJK();
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
                    MMSightRecordButton.e(MMSightRecordButton.this).cJI();
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
                    MMSightRecordButton.m(MMSightRecordButton.this).ekJ();
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
    this.zBl.setScaleX(1.0F);
    this.zBl.setScaleY(1.0F);
    this.zBm.setScaleX(1.0F);
    this.zBm.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    this.zBn.reset();
    AppMethodBeat.o(94550);
  }
  
  public final void rk(boolean paramBoolean)
  {
    AppMethodBeat.i(187085);
    this.zBe = paramBoolean;
    this.zBn.setEnableSubProgress(paramBoolean);
    this.zBn.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.zBn.setVisibility(4);
      AppMethodBeat.o(187085);
      return;
    }
    this.zBn.reset();
    this.zBn.setVisibility(0);
    AppMethodBeat.o(187085);
  }
  
  public final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(187089);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.zBn;
    localMMSightCircularProgressBar.zBg = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(187089);
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.zBD = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.zBx = paramInt;
    if ((this.zBF instanceof GradientDrawable)) {
      ((GradientDrawable)this.zBF).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.zBE instanceof GradientDrawable)) {
      ((GradientDrawable)this.zBE).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.zBB = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.zBC = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.zBA = paramd;
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
    AppMethodBeat.i(187084);
    Log.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(187084);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(187091);
    if ((this.ipv) && (!this.tQl))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(187091);
  }
  
  public static abstract interface a
  {
    public abstract void ekJ();
  }
  
  public static abstract interface b
  {
    public abstract void cJI();
    
    public abstract void cJJ();
    
    public abstract void jK();
  }
  
  public static abstract interface c
  {
    public abstract void Gt(int paramInt);
    
    public abstract void Gu(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void cJK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */