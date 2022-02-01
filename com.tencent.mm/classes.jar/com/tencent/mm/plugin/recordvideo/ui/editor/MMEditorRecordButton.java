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
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;

public class MMEditorRecordButton
  extends FrameLayout
{
  private static final float Fge;
  private static final int MN;
  private boolean FfZ;
  private Drawable FgA;
  private boolean FgB;
  private boolean FgC;
  private Runnable FgE;
  private long Fgf;
  private View Fgg;
  private View Fgh;
  private boolean Fgj;
  private boolean Fgk;
  private ViewPropertyAnimator Fgm;
  private ValueAnimator Fgn;
  private ViewPropertyAnimator Fgp;
  private ViewPropertyAnimator Fgq;
  private int Fgr;
  private int Fgs;
  private int Fgt;
  private int Fgu;
  private Drawable Fgz;
  private ImageView HZW;
  private MMEditorCircularProgressBar HZX;
  private d HZY;
  private b HZZ;
  private c Iaa;
  private a Iab;
  private Drawable Iac;
  private float aCb;
  private boolean enable;
  private boolean isAnimating;
  private Runnable jLe;
  private MMHandler knk;
  private boolean xBb;
  
  static
  {
    AppMethodBeat.i(218859);
    MN = ViewConfiguration.getTapTimeout();
    Fge = MMApplicationContext.getContext().getResources().getDimensionPixelSize(b.c.Edge_14A) / MMApplicationContext.getContext().getResources().getDimensionPixelSize(b.c.Edge_8A);
    AppMethodBeat.o(218859);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(218808);
    this.Fgf = -1L;
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
    this.knk = new MMHandler(Looper.getMainLooper());
    this.jLe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218151);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this);
          }
        }
        AppMethodBeat.o(218151);
      }
    };
    this.FgE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219610);
        Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(219610);
      }
    };
    init();
    AppMethodBeat.o(218808);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(218813);
    this.Fgf = -1L;
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
    this.knk = new MMHandler(Looper.getMainLooper());
    this.jLe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218151);
        Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this);
          }
        }
        AppMethodBeat.o(218151);
      }
    };
    this.FgE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219610);
        Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(219610);
      }
    };
    init();
    AppMethodBeat.o(218813);
  }
  
  private void init()
  {
    AppMethodBeat.i(218819);
    Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(MN) });
    this.Fgz = getContext().getResources().getDrawable(b.d.mmeditor_recorder_button_inner);
    this.FgA = getContext().getResources().getDrawable(b.d.mmeditor_recorder_button_outer);
    this.Iac = au.o(getContext(), b.g.icons_filled_mike, getResources().getColor(b.b.Orange));
    this.Fgr = Color.parseColor("#FFDDDDDD");
    this.Fgs = Color.parseColor("#4CFA9D3B");
    ad.kS(getContext()).inflate(b.f.mmeditor_recorder_button, this, true);
    this.HZW = ((ImageView)findViewById(b.e.inner_icon));
    this.Fgg = findViewById(b.e.inner);
    this.Fgh = findViewById(b.e.outer);
    this.HZX = ((MMEditorCircularProgressBar)findViewById(b.e.circular_progress));
    this.HZW.setImageDrawable(this.Iac);
    this.Fgg.setBackground(this.Fgz);
    this.Fgh.setBackground(this.FgA);
    this.enable = true;
    AppMethodBeat.o(218819);
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(218852);
    if (!this.enable)
    {
      Log.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(218852);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(218852);
      return true;
      this.xBb = true;
      this.Fgf = System.currentTimeMillis();
      this.Fgj = false;
      this.Fgk = false;
      this.aCb = paramMotionEvent.getRawY();
      this.knk.removeCallbacksAndMessages(null);
      this.knk.postDelayed(this.jLe, 550L);
      this.knk.postDelayed(this.FgE, 250L);
      this.FgC = true;
      this.FgB = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.Fgk) || (!this.FfZ)))
      {
        if (this.aCb <= 0.0F) {
          this.aCb = paramMotionEvent.getRawY();
        }
        while (this.HZZ != null)
        {
          break;
          float f2 = Math.abs(f1 - this.aCb);
          int i;
          if ((f1 < this.aCb) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.FgB) });
            Math.min(i, 3);
            this.aCb = f1;
            this.FgB = false;
          }
          else if ((f1 > this.aCb) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.FgC) });
            Math.min(i, 3);
            this.FgC = false;
            this.aCb = f1;
          }
        }
        this.xBb = false;
        this.knk.removeCallbacks(this.FgE, Integer.valueOf(MN));
        this.knk.removeCallbacks(this.jLe);
        final long l = System.currentTimeMillis() - this.Fgf;
        Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.Fgk), Boolean.valueOf(this.Fgj), Long.valueOf(this.Fgf), Long.valueOf(l) });
        paramMotionEvent = new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(218910);
            if ((MMEditorRecordButton.g(MMEditorRecordButton.this) > 0L) && (l <= 500L) && (!MMEditorRecordButton.b(MMEditorRecordButton.this)))
            {
              Log.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
              MMEditorRecordButton.h(MMEditorRecordButton.this);
              if ((!MMEditorRecordButton.b(MMEditorRecordButton.this)) && (MMEditorRecordButton.i(MMEditorRecordButton.this) != null))
              {
                MMEditorRecordButton.i(MMEditorRecordButton.this);
                AppMethodBeat.o(218910);
              }
            }
            else if (MMEditorRecordButton.b(MMEditorRecordButton.this))
            {
              if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null)
              {
                MMEditorRecordButton.d(MMEditorRecordButton.this);
                AppMethodBeat.o(218910);
              }
            }
            else
            {
              Log.i("MicroMsg.MMSightRecordButton", "error action up");
              if (MMEditorRecordButton.j(MMEditorRecordButton.this) != null) {
                MMEditorRecordButton.j(MMEditorRecordButton.this);
              }
            }
            AppMethodBeat.o(218910);
          }
        };
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
            AppMethodBeat.i(220198);
            MMEditorRecordButton.a(MMEditorRecordButton.this, false);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationEnd(paramAnonymousAnimator);
            }
            AppMethodBeat.o(220198);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(220194);
            MMEditorRecordButton.a(MMEditorRecordButton.this, true);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationStart(paramAnonymousAnimator);
            }
            AppMethodBeat.o(220194);
          }
        }).setDuration(150L).start();
        this.Fgq = this.Fgh.animate().scaleX(1.0F).scaleY(1.0F);
        this.Fgq.setDuration(150L).start();
        if (this.Fgs != this.Fgr)
        {
          if (this.Fgn != null) {
            this.Fgn.cancel();
          }
          this.Fgn = ObjectAnimator.ofArgb(this.FgA, "color", new int[] { this.Fgs, this.Fgr });
          this.Fgn.setDuration(150L);
          this.Fgn.start();
        }
      }
    }
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.Iab = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(218822);
    this.Fgs = paramInt;
    if ((this.FgA instanceof GradientDrawable)) {
      ((GradientDrawable)this.FgA).setColor(paramInt);
    }
    AppMethodBeat.o(218822);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(218824);
    if ((this.Fgz instanceof GradientDrawable)) {
      ((GradientDrawable)this.Fgz).setColor(paramInt);
    }
    AppMethodBeat.o(218824);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.HZZ = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.Iaa = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.HZY = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(218830);
    Log.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(218830);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(218832);
    Log.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220403);
          MMEditorRecordButton.a(MMEditorRecordButton.this, paramInt);
          AppMethodBeat.o(220403);
        }
      }, 150L);
      AppMethodBeat.o(218832);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(218832);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton
 * JD-Core Version:    0.7.0.1
 */