package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;

public class MMSightRecordButton
  extends FrameLayout
{
  private static final int Fy;
  private static final float oNG;
  private boolean enable;
  private ak faV;
  private boolean isAnimating;
  private float nvm;
  private long oNH;
  private View oNI;
  private View oNJ;
  private MMSightCircularProgressBar oNK;
  private boolean oNL;
  private boolean oNM;
  private ViewPropertyAnimator oNN;
  private ViewPropertyAnimator oNO;
  private ValueAnimator oNP;
  private ViewPropertyAnimator oNQ;
  private ViewPropertyAnimator oNR;
  private boolean oNS;
  private int oNT;
  private int oNU;
  private MMSightRecordButton.d oNV;
  private MMSightRecordButton.b oNW;
  private MMSightRecordButton.c oNX;
  private MMSightRecordButton.a oNY;
  private Drawable oNZ;
  private Drawable oOa;
  private boolean oOb;
  private boolean oOc;
  private Runnable oOd;
  private Runnable oOe;
  private View progressBar;
  
  static
  {
    AppMethodBeat.i(55116);
    Fy = ViewConfiguration.getTapTimeout();
    oNG = ah.getContext().getResources().getDimensionPixelSize(2131428580) / ah.getContext().getResources().getDimensionPixelSize(2131428579);
    AppMethodBeat.o(55116);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55100);
    this.oNH = -1L;
    this.oNL = false;
    this.oNM = false;
    this.isAnimating = false;
    this.oNS = false;
    this.nvm = -1.0F;
    this.enable = true;
    this.oOb = false;
    this.oOc = false;
    this.faV = new ak(Looper.getMainLooper());
    this.oOd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55097);
        ab.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.a(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.a(MMSightRecordButton.this))
        {
          MMSightRecordButton.c(MMSightRecordButton.this);
          if (MMSightRecordButton.d(MMSightRecordButton.this) != null) {
            MMSightRecordButton.d(MMSightRecordButton.this).hH();
          }
        }
        AppMethodBeat.o(55097);
      }
    };
    this.oOe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55098);
        ab.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.e(MMSightRecordButton.this)) });
        if (MMSightRecordButton.e(MMSightRecordButton.this)) {
          MMSightRecordButton.f(MMSightRecordButton.this);
        }
        AppMethodBeat.o(55098);
      }
    };
    init();
    AppMethodBeat.o(55100);
  }
  
  public MMSightRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55101);
    this.oNH = -1L;
    this.oNL = false;
    this.oNM = false;
    this.isAnimating = false;
    this.oNS = false;
    this.nvm = -1.0F;
    this.enable = true;
    this.oOb = false;
    this.oOc = false;
    this.faV = new ak(Looper.getMainLooper());
    this.oOd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55097);
        ab.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.a(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)) });
        if (!MMSightRecordButton.a(MMSightRecordButton.this))
        {
          MMSightRecordButton.c(MMSightRecordButton.this);
          if (MMSightRecordButton.d(MMSightRecordButton.this) != null) {
            MMSightRecordButton.d(MMSightRecordButton.this).hH();
          }
        }
        AppMethodBeat.o(55097);
      }
    };
    this.oOe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(55098);
        ab.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.e(MMSightRecordButton.this)) });
        if (MMSightRecordButton.e(MMSightRecordButton.this)) {
          MMSightRecordButton.f(MMSightRecordButton.this);
        }
        AppMethodBeat.o(55098);
      }
    };
    init();
    AppMethodBeat.o(55101);
  }
  
  private void a(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(55109);
    this.isAnimating = true;
    if (this.oNQ != null)
    {
      this.oNQ.cancel();
      this.oNQ = null;
    }
    this.oNQ = this.oNI.animate().scaleX(1.0F).scaleY(1.0F);
    this.oNQ.setListener(new MMSightRecordButton.3(this, paramAnimatorListenerAdapter)).setDuration(150L).start();
    if (this.oNR != null)
    {
      this.oNR.cancel();
      this.oNR = null;
    }
    this.oNR = this.oNJ.animate().scaleX(1.0F).scaleY(1.0F);
    this.oNR.setDuration(150L).start();
    if (this.oNU != this.oNT)
    {
      if (this.oNP != null) {
        this.oNP.cancel();
      }
      this.oNP = ObjectAnimator.ofInt(this.oOa, "color", new int[] { this.oNT, this.oNU });
      this.oNP.setDuration(150L);
      this.oNP.setEvaluator(a.getInstance());
      this.oNP.start();
    }
    AppMethodBeat.o(55109);
  }
  
  private void init()
  {
    AppMethodBeat.i(55102);
    ab.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Fy) });
    this.oNZ = getContext().getResources().getDrawable(2130839688);
    this.oOa = getContext().getResources().getDrawable(2130839689);
    this.oNT = -2236963;
    this.oNU = this.oNT;
    if ((this.oOa instanceof GradientDrawable)) {
      ((GradientDrawable)this.oOa).setColor(this.oNT);
    }
    w.hM(getContext()).inflate(2130970287, this, true);
    this.oNI = findViewById(2131826297);
    this.oNJ = findViewById(2131826296);
    this.progressBar = findViewById(2131821119);
    this.oNK = ((MMSightCircularProgressBar)findViewById(2131826298));
    this.oNI.setBackgroundDrawable(this.oNZ);
    this.oNJ.setBackgroundDrawable(this.oOa);
    this.enable = true;
    AppMethodBeat.o(55102);
  }
  
  public final void a(int paramInt1, int paramInt2, MMSightCircularProgressBar.a parama)
  {
    AppMethodBeat.i(55107);
    ab.b("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(paramInt1), parama });
    this.oNK.setInitProgress(0);
    this.oNK.setMaxProgress(100);
    this.oNK.setDuration(paramInt1);
    this.oNK.setVisibility(0);
    this.oNK.setCircularColor(paramInt2);
    parama = new MMSightRecordButton.1(this, parama);
    this.oNK.setProgressCallback(parama);
    parama = this.oNK;
    ab.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", new Object[] { Integer.valueOf(parama.oNy), Integer.valueOf(parama.oNz), Integer.valueOf(parama.duration) });
    parama.oNx = 0.0F;
    parama.oNB = new c(parama.oNy, parama.oNz, parama.duration);
    c localc = parama.oNB;
    MMSightCircularProgressBar.1 local1 = new MMSightCircularProgressBar.1(parama);
    ab.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.oPf = local1;
    parama = parama.oNB;
    ab.i("MicroMsg.ProgressHandlerAnimator", "Start");
    parama.isStart = true;
    parama.ewN = bo.yB();
    parama.fJH.ag(20L, 20L);
    AppMethodBeat.o(55107);
  }
  
  public final void bRN()
  {
    AppMethodBeat.i(55105);
    ab.i("MicroMsg.MMSightRecordButton", "showProgressBar");
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(55105);
  }
  
  public final void bRO()
  {
    AppMethodBeat.i(55106);
    ab.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(55106);
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(55108);
    MMSightCircularProgressBar localMMSightCircularProgressBar = this.oNK;
    localMMSightCircularProgressBar.oNC = null;
    localMMSightCircularProgressBar.oNy = 0;
    localMMSightCircularProgressBar.oNz = 0;
    localMMSightCircularProgressBar.duration = 0;
    localMMSightCircularProgressBar.isStart = false;
    if (localMMSightCircularProgressBar.oNB != null)
    {
      c localc = localMMSightCircularProgressBar.oNB;
      localc.isStart = false;
      localc.ewN = 0L;
      localMMSightCircularProgressBar.oNB = null;
    }
    this.oNK.setVisibility(8);
    AppMethodBeat.o(55108);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55112);
    if (!this.enable)
    {
      ab.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(55112);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55112);
      return true;
      this.oNS = true;
      this.oNH = System.currentTimeMillis();
      this.oNL = false;
      this.oNM = false;
      this.nvm = paramMotionEvent.getRawY();
      if (this.oNW != null) {
        this.oNW.boY();
      }
      this.faV.postDelayed(this.oOd, 550L);
      this.faV.postDelayed(this.oOe, 250L);
      this.oOc = true;
      this.oOb = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      if ((f1 < getTop()) && (this.oNM)) {
        if (this.nvm <= 0.0F)
        {
          this.nvm = paramMotionEvent.getRawY();
        }
        else
        {
          float f2 = Math.abs(f1 - this.nvm);
          int i;
          if ((f1 < this.nvm) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ab.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.oOb) });
            i = Math.min(i, 3);
            if (this.oNX != null)
            {
              paramMotionEvent = this.oNX;
              if (this.oOb) {
                i = 1;
              }
              paramMotionEvent.uR(i);
            }
            this.nvm = f1;
            this.oOb = false;
          }
          else if ((f1 > this.nvm) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ab.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.oOc) });
            i = Math.min(i, 3);
            if (this.oNX != null)
            {
              paramMotionEvent = this.oNX;
              if (this.oOc) {
                i = 1;
              }
              paramMotionEvent.uS(i);
            }
            this.oOc = false;
            this.nvm = f1;
            continue;
            this.oNS = false;
            this.faV.removeCallbacks(this.oOe, Integer.valueOf(Fy));
            this.faV.removeCallbacks(this.oOd);
            if ((this.oNN != null) && (this.oNO != null))
            {
              this.oNN.cancel();
              this.oNO.cancel();
            }
            final long l = System.currentTimeMillis() - this.oNH;
            ab.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.oNM), Boolean.valueOf(this.oNL), Long.valueOf(this.oNH), Long.valueOf(l) });
            hideProgress();
            a(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(55099);
                if ((MMSightRecordButton.g(MMSightRecordButton.this) > 0L) && (l <= 500L))
                {
                  ab.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMSightRecordButton.a(MMSightRecordButton.this)), Boolean.valueOf(MMSightRecordButton.b(MMSightRecordButton.this)) });
                  MMSightRecordButton.h(MMSightRecordButton.this);
                  if ((!MMSightRecordButton.b(MMSightRecordButton.this)) && (MMSightRecordButton.i(MMSightRecordButton.this) != null))
                  {
                    MMSightRecordButton.i(MMSightRecordButton.this).bpa();
                    AppMethodBeat.o(55099);
                  }
                }
                else if (MMSightRecordButton.b(MMSightRecordButton.this))
                {
                  ab.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
                  if (MMSightRecordButton.d(MMSightRecordButton.this) != null)
                  {
                    MMSightRecordButton.d(MMSightRecordButton.this).boX();
                    AppMethodBeat.o(55099);
                  }
                }
                else
                {
                  ab.i("MicroMsg.MMSightRecordButton", "error action up");
                  if (MMSightRecordButton.j(MMSightRecordButton.this) != null) {
                    MMSightRecordButton.j(MMSightRecordButton.this).bRP();
                  }
                }
                AppMethodBeat.o(55099);
              }
            });
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(55111);
    setClipChildren(false);
    this.enable = true;
    this.oNI.setScaleX(1.0F);
    this.oNI.setScaleY(1.0F);
    this.oNJ.setScaleX(1.0F);
    this.oNJ.setScaleY(1.0F);
    this.progressBar.setVisibility(8);
    hideProgress();
    AppMethodBeat.o(55111);
  }
  
  public void setErrorPressCallback(MMSightRecordButton.a parama)
  {
    this.oNY = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(55103);
    this.oNU = paramInt;
    if ((this.oOa instanceof GradientDrawable)) {
      ((GradientDrawable)this.oOa).setColor(paramInt);
    }
    AppMethodBeat.o(55103);
  }
  
  public void setLongPressCallback(MMSightRecordButton.b paramb)
  {
    this.oNW = paramb;
  }
  
  public void setLongPressScrollCallback(MMSightRecordButton.c paramc)
  {
    this.oNX = paramc;
  }
  
  public void setSimpleTapCallback(MMSightRecordButton.d paramd)
  {
    this.oNV = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(55104);
    ab.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(55104);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(55110);
    ab.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55096);
          MMSightRecordButton.a(MMSightRecordButton.this, paramInt);
          AppMethodBeat.o(55096);
        }
      }, 150L);
      AppMethodBeat.o(55110);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(55110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton
 * JD-Core Version:    0.7.0.1
 */