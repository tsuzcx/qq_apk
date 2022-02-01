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
import com.tencent.mm.ui.z;
import java.util.ArrayList;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int Pk;
  private static final float vUF;
  private float aTM;
  private boolean enable;
  private ap gIf;
  private Runnable gmO;
  private boolean htg;
  private boolean isAnimating;
  private View progressBar;
  private boolean smb;
  private boolean vUA;
  private long vUG;
  private View vUH;
  private View vUI;
  private MMSightCircularProgressBar vUJ;
  private boolean vUK;
  private boolean vUL;
  private ViewPropertyAnimator vUM;
  private ViewPropertyAnimator vUN;
  private ValueAnimator vUO;
  private ValueAnimator vUP;
  private ViewPropertyAnimator vUQ;
  private ViewPropertyAnimator vUR;
  private int vUS;
  private int vUT;
  private int vUU;
  private int vUV;
  private d vUW;
  private b vUX;
  private c vUY;
  private a vUZ;
  private Drawable vVa;
  private Drawable vVb;
  private boolean vVc;
  private boolean vVd;
  private Runnable vVe;
  
  static
  {
    AppMethodBeat.i(94555);
    Pk = ViewConfiguration.getTapTimeout();
    vUF = aj.getContext().getResources().getDimensionPixelSize(2131166579) / aj.getContext().getResources().getDimensionPixelSize(2131166578);
    AppMethodBeat.o(94555);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94538);
    this.vUG = -1L;
    this.htg = false;
    this.vUK = false;
    this.vUL = false;
    this.isAnimating = false;
    this.smb = false;
    this.vUU = -1;
    this.vUV = -2130706433;
    this.aTM = -1.0F;
    this.enable = true;
    this.vVc = false;
    this.vVd = false;
    this.vUA = false;
    this.gIf = new ap(Looper.getMainLooper());
    this.gmO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ad.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
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
    this.vVe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ad.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
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
    this.vUG = -1L;
    this.htg = false;
    this.vUK = false;
    this.vUL = false;
    this.isAnimating = false;
    this.smb = false;
    this.vUU = -1;
    this.vUV = -2130706433;
    this.aTM = -1.0F;
    this.enable = true;
    this.vVc = false;
    this.vVd = false;
    this.vUA = false;
    this.gIf = new ap(Looper.getMainLooper());
    this.gmO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94535);
        ad.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
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
    this.vVe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94536);
        ad.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.f(MMSightRecordButton.this)) });
        if (MMSightRecordButton.f(MMSightRecordButton.this)) {
          MMSightRecordButton.g(MMSightRecordButton.this);
        }
        AppMethodBeat.o(94536);
      }
    };
    init();
    AppMethodBeat.o(94539);
  }
  
  private void dnQ()
  {
    AppMethodBeat.i(214507);
    ad.d("MicroMsg.MMSightRecordButton", "startTransition");
    this.isAnimating = true;
    if (this.vUM != null)
    {
      this.vUM.cancel();
      this.vUM = null;
    }
    this.vUM = this.vUH.animate().scaleX(0.5F).scaleY(0.5F);
    this.vUM.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94531);
        MMSightRecordButton.a(MMSightRecordButton.this, false);
        if (this.vVj != null) {
          this.vVj.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94531);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(94530);
        MMSightRecordButton.a(MMSightRecordButton.this, true);
        if (this.vVj != null) {
          this.vVj.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(94530);
      }
    }).setDuration(150L).start();
    if (this.vUN != null)
    {
      this.vUN.cancel();
      this.vUN = null;
    }
    this.vUN = this.vUI.animate().scaleX(vUF).scaleY(vUF);
    this.vUN.setDuration(150L).start();
    if (this.vUT != this.vUS)
    {
      if (this.vUO != null) {
        this.vUO.cancel();
      }
      this.vUO = ObjectAnimator.ofInt(this.vVb, "color", new int[] { this.vUT, this.vUS });
      this.vUO.setDuration(150L);
      this.vUO.setEvaluator(a.getInstance());
      this.vUO.start();
    }
    if (this.vUP != null) {
      this.vUP.cancel();
    }
    this.vUP = ObjectAnimator.ofInt(this.vVa, "color", new int[] { this.vUU, this.vUV });
    this.vUP.setDuration(150L);
    this.vUP.setEvaluator(a.getInstance());
    this.vUP.start();
    AppMethodBeat.o(214507);
  }
  
  private void e(final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(94548);
    this.isAnimating = true;
    if (this.vUQ != null)
    {
      this.vUQ.cancel();
      this.vUQ = null;
    }
    this.vUQ = this.vUH.animate().scaleX(1.0F).scaleY(1.0F);
    this.vUQ.setListener(new AnimatorListenerAdapter()
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
    this.vUR = this.vUI.animate().scaleX(1.0F).scaleY(1.0F);
    this.vUR.setDuration(150L).start();
    if (this.vUP != null) {
      this.vUP.cancel();
    }
    this.vUP = ObjectAnimator.ofInt(this.vVa, "color", new int[] { this.vUV, this.vUU });
    this.vUP.setDuration(150L);
    this.vUP.setEvaluator(a.getInstance());
    this.vUP.start();
    if (this.vUT != this.vUS)
    {
      if (this.vUO != null) {
        this.vUO.cancel();
      }
      this.vUO = ObjectAnimator.ofInt(this.vVb, "color", new int[] { this.vUS, this.vUT });
      this.vUO.setDuration(150L);
      this.vUO.setEvaluator(a.getInstance());
      this.vUO.start();
    }
    AppMethodBeat.o(94548);
  }
  
  private void init()
  {
    AppMethodBeat.i(94540);
    ad.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Pk) });
    this.vVa = getContext().getResources().getDrawable(2131233311);
    this.vVb = getContext().getResources().getDrawable(2131233312);
    z.jO(getContext()).inflate(2131494919, this, true);
    this.vUH = findViewById(2131301021);
    this.vUI = findViewById(2131303113);
    this.progressBar = findViewById(2131303518);
    this.vUJ = ((MMSightCircularProgressBar)findViewById(2131298337));
    this.vUH.setBackgroundDrawable(this.vVa);
    this.vUI.setBackgroundDrawable(this.vVb);
    this.enable = true;
    AppMethodBeat.o(94540);
  }
  
  public final void Ks(int paramInt)
  {
    AppMethodBeat.i(214505);
    int i = this.vUJ.getSubProgress().size();
    MMSightCircularProgressBar localMMSightCircularProgressBar;
    if ((i > 0) && (paramInt != i))
    {
      localMMSightCircularProgressBar = this.vUJ;
      if (localMMSightCircularProgressBar.vUy.size() > 0)
      {
        localMMSightCircularProgressBar.vUy.remove(localMMSightCircularProgressBar.vUy.size() - 1);
        if (localMMSightCircularProgressBar.vUy.size() <= 0) {
          break label105;
        }
      }
    }
    label105:
    for (localMMSightCircularProgressBar.vUt = ((Float)localMMSightCircularProgressBar.vUy.get(localMMSightCircularProgressBar.vUy.size() - 1)).floatValue();; localMMSightCircularProgressBar.vUt = 0.0F)
    {
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(214505);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(94546);
    ad.m("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.htg = true;
    this.vUJ.setInitProgress(0);
    this.vUJ.setMaxProgress(100);
    this.vUJ.setDuration(paramInt1);
    if (!this.vUA) {
      this.vUJ.setVisibility(0);
    }
    this.vUJ.setCircularColor(paramInt2);
    parama = new MMSightCircularProgressBar.a()
    {
      public final void S(ArrayList<Float> paramAnonymousArrayList)
      {
        AppMethodBeat.i(214502);
        if (parama != null) {
          parama.S(paramAnonymousArrayList);
        }
        AppMethodBeat.o(214502);
      }
      
      public final void kH(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(214501);
        ad.m("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
        MMSightRecordButton.this.hideProgress();
        MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(94528);
            ad.m("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
            MMSightRecordButton.a(MMSightRecordButton.this);
            if (MMSightRecordButton.1.this.vVf != null) {
              MMSightRecordButton.1.this.vVf.kH(paramAnonymousBoolean);
            }
            AppMethodBeat.o(94528);
          }
        });
        AppMethodBeat.o(214501);
      }
    };
    this.vUJ.setProgressCallback(parama);
    parama = this.vUJ;
    ad.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(parama.vUu), Integer.valueOf(parama.vUv), Integer.valueOf(parama.duration), Float.valueOf(parama.vUt) });
    parama.isStart = true;
    if (parama.vUw != null)
    {
      parama.vUw.cancel();
      parama.vUw = null;
    }
    parama.vUw = new c(parama.vUt, parama.vUv, parama.duration);
    c localc = parama.vUw;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    ad.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.vWh = local1;
    parama = parama.vUw;
    ad.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.gkt = bt.HI();
    parama.igC.az(20L, 20L);
    AppMethodBeat.o(94546);
  }
  
  public final void dnP()
  {
    AppMethodBeat.i(94545);
    ad.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(94545);
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(94547);
    if (this.vUA)
    {
      MMSightCircularProgressBar localMMSightCircularProgressBar = this.vUJ;
      if (localMMSightCircularProgressBar.vUw != null)
      {
        localMMSightCircularProgressBar.vUw.cancel();
        localMMSightCircularProgressBar.vUw = null;
      }
      if ((localMMSightCircularProgressBar.vUt > 0.0F) && (((localMMSightCircularProgressBar.vUy.size() > 0) && (localMMSightCircularProgressBar.vUt > ((Float)localMMSightCircularProgressBar.vUy.get(localMMSightCircularProgressBar.vUy.size() - 1)).floatValue())) || (localMMSightCircularProgressBar.vUy.size() == 0))) {
        localMMSightCircularProgressBar.vUy.add(Float.valueOf(localMMSightCircularProgressBar.vUt));
      }
      localMMSightCircularProgressBar.invalidate();
      AppMethodBeat.o(94547);
      return;
    }
    this.vUJ.reset();
    this.vUJ.setVisibility(8);
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
      if ((this.htg) && (!this.vUA))
      {
        AppMethodBeat.o(94551);
        return false;
      }
      this.smb = true;
      this.vUG = System.currentTimeMillis();
      this.vUK = false;
      this.vUL = false;
      this.aTM = paramMotionEvent.getRawY();
      if ((this.vUX != null) && (!this.htg)) {
        this.vUX.ckr();
      }
      this.gIf.removeCallbacksAndMessages(null);
      if (!this.htg)
      {
        this.gIf.postDelayed(this.gmO, 550L);
        this.gIf.postDelayed(this.vVe, 250L);
      }
      this.vVd = true;
      this.vVc = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.vUL) || (!this.vUA))) {
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
            ad.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.vVc) });
            i = Math.min(i, 3);
            if (this.vUY != null)
            {
              paramMotionEvent = this.vUY;
              if (this.vVc) {
                i = 1;
              }
              paramMotionEvent.Cw(i);
            }
            this.aTM = f1;
            this.vVc = false;
          }
          else if ((f1 > this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ad.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.vVd) });
            i = Math.min(i, 3);
            if (this.vUY != null)
            {
              paramMotionEvent = this.vUY;
              if (this.vVd) {
                i = 1;
              }
              paramMotionEvent.Cx(i);
            }
            this.vVd = false;
            this.aTM = f1;
            continue;
            this.smb = false;
            this.gIf.removeCallbacks(this.vVe, Integer.valueOf(Pk));
            this.gIf.removeCallbacks(this.gmO);
            if ((this.vUM != null) && (this.vUN != null))
            {
              this.vUM.cancel();
              this.vUN.cancel();
            }
            final long l = System.currentTimeMillis() - this.vUG;
            ad.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.vUL), Boolean.valueOf(this.vUK), Long.valueOf(this.vUG), Long.valueOf(l) });
            hideProgress();
            e(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(94537);
                if ((MMSightRecordButton.h(MMSightRecordButton.this) > 0L) && (l <= 500L) && (!MMSightRecordButton.c(MMSightRecordButton.this)))
                {
                  ad.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.c(MMSightRecordButton.this)) });
                  MMSightRecordButton.i(MMSightRecordButton.this);
                  if (!MMSightRecordButton.c(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.j(MMSightRecordButton.this);
                    if (MMSightRecordButton.k(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.k(MMSightRecordButton.this).cks();
                      AppMethodBeat.o(94537);
                    }
                  }
                }
                else if (MMSightRecordButton.c(MMSightRecordButton.this))
                {
                  ad.i("MicroMsg.MMSightRecordButton", "on Long Press finish ，isRecordIng:%b", new Object[] { Boolean.valueOf(MMSightRecordButton.l(MMSightRecordButton.this)) });
                  if (MMSightRecordButton.l(MMSightRecordButton.this))
                  {
                    MMSightRecordButton.a(MMSightRecordButton.this);
                    if (MMSightRecordButton.e(MMSightRecordButton.this) != null)
                    {
                      MMSightRecordButton.e(MMSightRecordButton.this).ckq();
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
                    MMSightRecordButton.m(MMSightRecordButton.this).dnR();
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
  
  public final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(214504);
    this.vUA = paramBoolean;
    this.vUJ.setEnableSubProgress(paramBoolean);
    this.vUJ.setCircularColor(Color.parseColor("#00000000"));
    if (paramBoolean)
    {
      this.vUJ.setVisibility(4);
      AppMethodBeat.o(214504);
      return;
    }
    this.vUJ.reset();
    this.vUJ.setVisibility(0);
    AppMethodBeat.o(214504);
  }
  
  public final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(214506);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.vUJ;
    localMMSightCircularProgressBar.vUC = paramBoolean;
    localMMSightCircularProgressBar.postInvalidate();
    AppMethodBeat.o(214506);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94550);
    setClipChildren(false);
    this.enable = true;
    this.vUH.setScaleX(1.0F);
    this.vUH.setScaleY(1.0F);
    this.vUI.setScaleX(1.0F);
    this.vUI.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    this.vUJ.reset();
    AppMethodBeat.o(94550);
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.vUZ = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(94541);
    this.vUT = paramInt;
    if ((this.vVb instanceof GradientDrawable)) {
      ((GradientDrawable)this.vVb).setColor(paramInt);
    }
    AppMethodBeat.o(94541);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(94542);
    if ((this.vVa instanceof GradientDrawable)) {
      ((GradientDrawable)this.vVa).setColor(paramInt);
    }
    AppMethodBeat.o(94542);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.vUX = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.vUY = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.vUW = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(94543);
    ad.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(94543);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(94549);
    ad.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
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
    AppMethodBeat.i(214503);
    ad.i("MicroMsg.MMSightRecordButton", "showLoading");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(214503);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(214508);
    if ((this.htg) && (!this.smb))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(214508);
  }
  
  public static abstract interface a
  {
    public abstract void dnR();
  }
  
  public static abstract interface b
  {
    public abstract void ckq();
    
    public abstract void ckr();
    
    public abstract void jB();
  }
  
  public static abstract interface c
  {
    public abstract void Cw(int paramInt);
    
    public abstract void Cx(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void cks();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */