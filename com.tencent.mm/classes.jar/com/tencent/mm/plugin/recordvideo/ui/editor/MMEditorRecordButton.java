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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;

public class MMEditorRecordButton
  extends FrameLayout
{
  private static final int Pw;
  private static final float zBj;
  private ImageView CdG;
  private MMEditorCircularProgressBar CdH;
  private d CdI;
  private b CdJ;
  private c CdK;
  private a CdL;
  private Drawable CdM;
  private float aTE;
  private boolean enable;
  private MMHandler hAk;
  private Runnable had;
  private boolean isAnimating;
  private boolean tQl;
  private Drawable zBE;
  private Drawable zBF;
  private boolean zBG;
  private boolean zBH;
  private Runnable zBI;
  private boolean zBe;
  private long zBk;
  private View zBl;
  private View zBm;
  private boolean zBo;
  private boolean zBp;
  private ViewPropertyAnimator zBr;
  private ValueAnimator zBs;
  private ViewPropertyAnimator zBu;
  private ViewPropertyAnimator zBv;
  private int zBw;
  private int zBx;
  private int zBy;
  private int zBz;
  
  static
  {
    AppMethodBeat.i(237234);
    Pw = ViewConfiguration.getTapTimeout();
    zBj = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131165283) / MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131165312);
    AppMethodBeat.o(237234);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237221);
    this.zBk = -1L;
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
        AppMethodBeat.i(237218);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this).jK();
          }
        }
        AppMethodBeat.o(237218);
      }
    };
    this.zBI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237219);
        Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(237219);
      }
    };
    init();
    AppMethodBeat.o(237221);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237222);
    this.zBk = -1L;
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
        AppMethodBeat.i(237218);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this).jK();
          }
        }
        AppMethodBeat.o(237218);
      }
    };
    this.zBI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237219);
        Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(237219);
      }
    };
    init();
    AppMethodBeat.o(237222);
  }
  
  private void init()
  {
    AppMethodBeat.i(237223);
    Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Pw) });
    this.zBE = getContext().getResources().getDrawable(2131233982);
    this.zBF = getContext().getResources().getDrawable(2131233983);
    this.CdM = ar.m(getContext(), 2131690602, getResources().getColor(2131099792));
    this.zBw = Color.parseColor("#FFDDDDDD");
    this.zBx = Color.parseColor("#4CFA9D3B");
    aa.jQ(getContext()).inflate(2131495654, this, true);
    this.CdG = ((ImageView)findViewById(2131302667));
    this.zBl = findViewById(2131302665);
    this.zBm = findViewById(2131305744);
    this.CdH = ((MMEditorCircularProgressBar)findViewById(2131298731));
    this.CdG.setImageDrawable(this.CdM);
    this.zBl.setBackground(this.zBE);
    this.zBm.setBackground(this.zBF);
    this.enable = true;
    AppMethodBeat.o(237223);
  }
  
  public final void VU(int paramInt)
  {
    AppMethodBeat.i(237227);
    Log.printInfoStack("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s", new Object[] { Float.valueOf(0.0F), Float.valueOf(100.0F) });
    this.CdH.setCircularColor(paramInt);
    this.CdH.setMaxProgress(100.0F);
    this.CdH.setCurrentProgress(0.0F);
    this.CdH.setVisibility(0);
    AppMethodBeat.o(237227);
  }
  
  public final void bi(float paramFloat)
  {
    AppMethodBeat.i(237228);
    this.CdH.setCurrentProgress(paramFloat);
    AppMethodBeat.o(237228);
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237231);
    if (!this.enable)
    {
      Log.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(237231);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(237231);
      return true;
      this.tQl = true;
      this.zBk = System.currentTimeMillis();
      this.zBo = false;
      this.zBp = false;
      this.aTE = paramMotionEvent.getRawY();
      this.hAk.removeCallbacksAndMessages(null);
      this.hAk.postDelayed(this.had, 550L);
      this.hAk.postDelayed(this.zBI, 250L);
      this.zBH = true;
      this.zBG = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.zBp) || (!this.zBe)))
      {
        if (this.aTE <= 0.0F) {
          this.aTE = paramMotionEvent.getRawY();
        }
        while (this.CdJ != null)
        {
          break;
          float f2 = Math.abs(f1 - this.aTE);
          int i;
          if ((f1 < this.aTE) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.zBG) });
            Math.min(i, 3);
            this.aTE = f1;
            this.zBG = false;
          }
          else if ((f1 > this.aTE) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.zBH) });
            Math.min(i, 3);
            this.zBH = false;
            this.aTE = f1;
          }
        }
        this.tQl = false;
        this.hAk.removeCallbacks(this.zBI, Integer.valueOf(Pw));
        this.hAk.removeCallbacks(this.had);
        final long l = System.currentTimeMillis() - this.zBk;
        Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.zBp), Boolean.valueOf(this.zBo), Long.valueOf(this.zBk), Long.valueOf(l) });
        paramMotionEvent = new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(237220);
            if ((MMEditorRecordButton.g(MMEditorRecordButton.this) > 0L) && (l <= 500L) && (!MMEditorRecordButton.b(MMEditorRecordButton.this)))
            {
              Log.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
              MMEditorRecordButton.h(MMEditorRecordButton.this);
              if ((!MMEditorRecordButton.b(MMEditorRecordButton.this)) && (MMEditorRecordButton.i(MMEditorRecordButton.this) != null))
              {
                MMEditorRecordButton.i(MMEditorRecordButton.this);
                AppMethodBeat.o(237220);
              }
            }
            else if (MMEditorRecordButton.b(MMEditorRecordButton.this))
            {
              if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null)
              {
                MMEditorRecordButton.d(MMEditorRecordButton.this).cJI();
                AppMethodBeat.o(237220);
              }
            }
            else
            {
              Log.i("MicroMsg.MMSightRecordButton", "error action up");
              if (MMEditorRecordButton.j(MMEditorRecordButton.this) != null) {
                MMEditorRecordButton.j(MMEditorRecordButton.this);
              }
            }
            AppMethodBeat.o(237220);
          }
        };
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
            AppMethodBeat.i(237216);
            MMEditorRecordButton.a(MMEditorRecordButton.this, false);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationEnd(paramAnonymousAnimator);
            }
            AppMethodBeat.o(237216);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(237215);
            MMEditorRecordButton.a(MMEditorRecordButton.this, true);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationStart(paramAnonymousAnimator);
            }
            AppMethodBeat.o(237215);
          }
        }).setDuration(150L).start();
        this.zBv = this.zBm.animate().scaleX(1.0F).scaleY(1.0F);
        this.zBv.setDuration(150L).start();
        if (this.zBx != this.zBw)
        {
          if (this.zBs != null) {
            this.zBs.cancel();
          }
          this.zBs = ObjectAnimator.ofArgb(this.zBF, "color", new int[] { this.zBx, this.zBw });
          this.zBs.setDuration(150L);
          this.zBs.start();
        }
      }
    }
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.CdL = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(237224);
    this.zBx = paramInt;
    if ((this.zBF instanceof GradientDrawable)) {
      ((GradientDrawable)this.zBF).setColor(paramInt);
    }
    AppMethodBeat.o(237224);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(237225);
    if ((this.zBE instanceof GradientDrawable)) {
      ((GradientDrawable)this.zBE).setColor(paramInt);
    }
    AppMethodBeat.o(237225);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.CdJ = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.CdK = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.CdI = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(237226);
    Log.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(237226);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(237229);
    Log.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(237217);
          MMEditorRecordButton.a(MMEditorRecordButton.this, paramInt);
          AppMethodBeat.o(237217);
        }
      }, 150L);
      AppMethodBeat.o(237229);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(237229);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(237230);
    if (this.tQl)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(237230);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void cJI();
    
    public abstract void jK();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton
 * JD-Core Version:    0.7.0.1
 */