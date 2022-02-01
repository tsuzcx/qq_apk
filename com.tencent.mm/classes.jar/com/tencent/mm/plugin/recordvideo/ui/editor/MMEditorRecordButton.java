package com.tencent.mm.plugin.recordvideo.ui.editor;

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
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.z;

public class MMEditorRecordButton
  extends FrameLayout
{
  private static final int Pk;
  private static final float wgJ;
  private float aTM;
  private boolean enable;
  private aq gKO;
  private Runnable gpk;
  private boolean isAnimating;
  private boolean svS;
  private boolean wgE;
  private long wgK;
  private View wgL;
  private View wgM;
  private boolean wgO;
  private boolean wgP;
  private ViewPropertyAnimator wgR;
  private ValueAnimator wgS;
  private ViewPropertyAnimator wgU;
  private ViewPropertyAnimator wgV;
  private int wgW;
  private int wgX;
  private int wgY;
  private int wgZ;
  private Drawable whe;
  private Drawable whf;
  private boolean whg;
  private boolean whh;
  private Runnable whi;
  private ImageView ycE;
  private MMEditorCircularProgressBar ycF;
  private d ycG;
  private b ycH;
  private c ycI;
  private a ycJ;
  private Drawable ycK;
  
  static
  {
    AppMethodBeat.i(206529);
    Pk = ViewConfiguration.getTapTimeout();
    wgJ = ak.getContext().getResources().getDimensionPixelSize(2131165279) / ak.getContext().getResources().getDimensionPixelSize(2131165301);
    AppMethodBeat.o(206529);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206516);
    this.wgK = -1L;
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
        AppMethodBeat.i(206513);
        ae.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this).jB();
          }
        }
        AppMethodBeat.o(206513);
      }
    };
    this.whi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206514);
        ae.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(206514);
      }
    };
    init();
    AppMethodBeat.o(206516);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206517);
    this.wgK = -1L;
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
        AppMethodBeat.i(206513);
        ae.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this).jB();
          }
        }
        AppMethodBeat.o(206513);
      }
    };
    this.whi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206514);
        ae.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(206514);
      }
    };
    init();
    AppMethodBeat.o(206517);
  }
  
  private void init()
  {
    AppMethodBeat.i(206518);
    ae.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Pk) });
    this.whe = getContext().getResources().getDrawable(2131235064);
    this.whf = getContext().getResources().getDrawable(2131235065);
    this.ycK = ao.k(getContext(), 2131690428, getResources().getColor(2131099777));
    this.wgW = Color.parseColor("#FFDDDDDD");
    this.wgX = Color.parseColor("#4CFA9D3B");
    z.jV(getContext()).inflate(2131496477, this, true);
    this.ycE = ((ImageView)findViewById(2131308331));
    this.wgL = findViewById(2131301021);
    this.wgM = findViewById(2131303113);
    this.ycF = ((MMEditorCircularProgressBar)findViewById(2131298337));
    this.ycE.setImageDrawable(this.ycK);
    this.wgL.setBackground(this.whe);
    this.wgM.setBackground(this.whf);
    this.enable = true;
    AppMethodBeat.o(206518);
  }
  
  public final void Oz(int paramInt)
  {
    AppMethodBeat.i(206522);
    ae.m("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s", new Object[] { Float.valueOf(0.0F), Float.valueOf(100.0F) });
    this.ycF.setCircularColor(paramInt);
    this.ycF.setMaxProgress(100.0F);
    this.ycF.setCurrentProgress(0.0F);
    this.ycF.setVisibility(0);
    AppMethodBeat.o(206522);
  }
  
  public final void bc(float paramFloat)
  {
    AppMethodBeat.i(206523);
    this.ycF.setCurrentProgress(paramFloat);
    AppMethodBeat.o(206523);
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206526);
    if (!this.enable)
    {
      ae.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(206526);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206526);
      return true;
      this.svS = true;
      this.wgK = System.currentTimeMillis();
      this.wgO = false;
      this.wgP = false;
      this.aTM = paramMotionEvent.getRawY();
      this.gKO.removeCallbacksAndMessages(null);
      this.gKO.postDelayed(this.gpk, 550L);
      this.gKO.postDelayed(this.whi, 250L);
      this.whh = true;
      this.whg = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.wgP) || (!this.wgE)))
      {
        if (this.aTM <= 0.0F) {
          this.aTM = paramMotionEvent.getRawY();
        }
        while (this.ycH != null)
        {
          break;
          float f2 = Math.abs(f1 - this.aTM);
          int i;
          if ((f1 < this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ae.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.whg) });
            Math.min(i, 3);
            this.aTM = f1;
            this.whg = false;
          }
          else if ((f1 > this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ae.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.whh) });
            Math.min(i, 3);
            this.whh = false;
            this.aTM = f1;
          }
        }
        this.svS = false;
        this.gKO.removeCallbacks(this.whi, Integer.valueOf(Pk));
        this.gKO.removeCallbacks(this.gpk);
        final long l = System.currentTimeMillis() - this.wgK;
        ae.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.wgP), Boolean.valueOf(this.wgO), Long.valueOf(this.wgK), Long.valueOf(l) });
        paramMotionEvent = new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(206515);
            if ((MMEditorRecordButton.g(MMEditorRecordButton.this) > 0L) && (l <= 500L) && (!MMEditorRecordButton.b(MMEditorRecordButton.this)))
            {
              ae.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
              MMEditorRecordButton.h(MMEditorRecordButton.this);
              if ((!MMEditorRecordButton.b(MMEditorRecordButton.this)) && (MMEditorRecordButton.i(MMEditorRecordButton.this) != null))
              {
                MMEditorRecordButton.i(MMEditorRecordButton.this);
                AppMethodBeat.o(206515);
              }
            }
            else if (MMEditorRecordButton.b(MMEditorRecordButton.this))
            {
              if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null)
              {
                MMEditorRecordButton.d(MMEditorRecordButton.this).clG();
                AppMethodBeat.o(206515);
              }
            }
            else
            {
              ae.i("MicroMsg.MMSightRecordButton", "error action up");
              if (MMEditorRecordButton.j(MMEditorRecordButton.this) != null) {
                MMEditorRecordButton.j(MMEditorRecordButton.this);
              }
            }
            AppMethodBeat.o(206515);
          }
        };
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
            AppMethodBeat.i(206511);
            MMEditorRecordButton.a(MMEditorRecordButton.this, false);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationEnd(paramAnonymousAnimator);
            }
            AppMethodBeat.o(206511);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(206510);
            MMEditorRecordButton.a(MMEditorRecordButton.this, true);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationStart(paramAnonymousAnimator);
            }
            AppMethodBeat.o(206510);
          }
        }).setDuration(150L).start();
        this.wgV = this.wgM.animate().scaleX(1.0F).scaleY(1.0F);
        this.wgV.setDuration(150L).start();
        if (this.wgX != this.wgW)
        {
          if (this.wgS != null) {
            this.wgS.cancel();
          }
          this.wgS = ObjectAnimator.ofArgb(this.whf, "color", new int[] { this.wgX, this.wgW });
          this.wgS.setDuration(150L);
          this.wgS.start();
        }
      }
    }
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.ycJ = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(206519);
    this.wgX = paramInt;
    if ((this.whf instanceof GradientDrawable)) {
      ((GradientDrawable)this.whf).setColor(paramInt);
    }
    AppMethodBeat.o(206519);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(206520);
    if ((this.whe instanceof GradientDrawable)) {
      ((GradientDrawable)this.whe).setColor(paramInt);
    }
    AppMethodBeat.o(206520);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.ycH = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.ycI = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.ycG = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(206521);
    ae.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(206521);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(206524);
    ae.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206512);
          MMEditorRecordButton.a(MMEditorRecordButton.this, paramInt);
          AppMethodBeat.o(206512);
        }
      }, 150L);
      AppMethodBeat.o(206524);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(206524);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(206525);
    if (this.svS)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(206525);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void clG();
    
    public abstract void jB();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton
 * JD-Core Version:    0.7.0.1
 */