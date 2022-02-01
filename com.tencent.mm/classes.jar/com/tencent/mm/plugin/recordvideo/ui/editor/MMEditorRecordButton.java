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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bb;

public class MMEditorRecordButton
  extends FrameLayout
{
  private static final float LbE;
  private static final int bsP;
  private boolean AYD;
  private long LbF;
  private View LbG;
  private View LbH;
  private boolean LbK;
  private boolean LbL;
  private ViewPropertyAnimator LbN;
  private ValueAnimator LbO;
  private ViewPropertyAnimator LbQ;
  private ViewPropertyAnimator LbR;
  private int LbS;
  private int LbT;
  private int LbU;
  private int LbV;
  private boolean Lbz;
  private Drawable Lca;
  private Drawable Lcb;
  private boolean Lcc;
  private boolean Lcd;
  private Runnable Lcf;
  private d NWA;
  private MMEditorRecordButton.b NWB;
  private c NWC;
  private a NWD;
  private Drawable NWE;
  private ImageView NWy;
  private MMEditorCircularProgressBar NWz;
  private float cxN;
  private boolean enable;
  private boolean isAnimating;
  private MMHandler mRi;
  private Runnable mkq;
  
  static
  {
    AppMethodBeat.i(279979);
    bsP = ViewConfiguration.getTapTimeout();
    LbE = MMApplicationContext.getContext().getResources().getDimensionPixelSize(b.c.Edge_14A) / MMApplicationContext.getContext().getResources().getDimensionPixelSize(b.c.Edge_8A);
    AppMethodBeat.o(279979);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(279906);
    this.LbF = -1L;
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
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.mkq = new MMEditorRecordButton.3(this);
    this.Lcf = new MMEditorRecordButton.4(this);
    init();
    AppMethodBeat.o(279906);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279911);
    this.LbF = -1L;
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
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.mkq = new MMEditorRecordButton.3(this);
    this.Lcf = new MMEditorRecordButton.4(this);
    init();
    AppMethodBeat.o(279911);
  }
  
  private void init()
  {
    AppMethodBeat.i(279922);
    Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(bsP) });
    this.Lca = getContext().getResources().getDrawable(b.d.mmeditor_recorder_button_inner);
    this.Lcb = getContext().getResources().getDrawable(b.d.mmeditor_recorder_button_outer);
    this.NWE = bb.m(getContext(), b.g.icons_filled_mike, getResources().getColor(b.b.Orange));
    this.LbS = Color.parseColor("#FFDDDDDD");
    this.LbT = Color.parseColor("#4CFA9D3B");
    af.mU(getContext()).inflate(b.f.mmeditor_recorder_button, this, true);
    this.NWy = ((ImageView)findViewById(b.e.inner_icon));
    this.LbG = findViewById(b.e.inner);
    this.LbH = findViewById(b.e.outer);
    this.NWz = ((MMEditorCircularProgressBar)findViewById(b.e.circular_progress));
    this.NWy.setImageDrawable(this.NWE);
    this.LbG.setBackground(this.Lca);
    this.LbH.setBackground(this.Lcb);
    this.enable = true;
    AppMethodBeat.o(279922);
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280031);
    if (!this.enable)
    {
      Log.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(280031);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(280031);
      return true;
      this.AYD = true;
      this.LbF = System.currentTimeMillis();
      this.LbK = false;
      this.LbL = false;
      this.cxN = paramMotionEvent.getRawY();
      this.mRi.removeCallbacksAndMessages(null);
      this.mRi.postDelayed(this.mkq, 550L);
      this.mRi.postDelayed(this.Lcf, 250L);
      this.Lcd = true;
      this.Lcc = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.LbL) || (!this.Lbz)))
      {
        if (this.cxN <= 0.0F) {
          this.cxN = paramMotionEvent.getRawY();
        }
        while (this.NWB != null)
        {
          break;
          float f2 = Math.abs(f1 - this.cxN);
          int i;
          if ((f1 < this.cxN) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Lcc) });
            Math.min(i, 3);
            this.cxN = f1;
            this.Lcc = false;
          }
          else if ((f1 > this.cxN) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Lcd) });
            Math.min(i, 3);
            this.Lcd = false;
            this.cxN = f1;
          }
        }
        this.AYD = false;
        this.mRi.removeCallbacks(this.Lcf, Integer.valueOf(bsP));
        this.mRi.removeCallbacks(this.mkq);
        final long l = System.currentTimeMillis() - this.LbF;
        Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.LbL), Boolean.valueOf(this.LbK), Long.valueOf(this.LbF), Long.valueOf(l) });
        paramMotionEvent = new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(279919);
            if ((MMEditorRecordButton.g(MMEditorRecordButton.this) > 0L) && (l <= 500L) && (!MMEditorRecordButton.b(MMEditorRecordButton.this)))
            {
              Log.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
              MMEditorRecordButton.h(MMEditorRecordButton.this);
              if ((!MMEditorRecordButton.b(MMEditorRecordButton.this)) && (MMEditorRecordButton.i(MMEditorRecordButton.this) != null))
              {
                MMEditorRecordButton.i(MMEditorRecordButton.this);
                AppMethodBeat.o(279919);
              }
            }
            else if (MMEditorRecordButton.b(MMEditorRecordButton.this))
            {
              if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null)
              {
                MMEditorRecordButton.d(MMEditorRecordButton.this);
                AppMethodBeat.o(279919);
              }
            }
            else
            {
              Log.i("MicroMsg.MMSightRecordButton", "error action up");
              if (MMEditorRecordButton.j(MMEditorRecordButton.this) != null) {
                MMEditorRecordButton.j(MMEditorRecordButton.this);
              }
            }
            AppMethodBeat.o(279919);
          }
        };
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
            AppMethodBeat.i(279938);
            MMEditorRecordButton.a(MMEditorRecordButton.this, false);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationEnd(paramAnonymousAnimator);
            }
            AppMethodBeat.o(279938);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(279930);
            MMEditorRecordButton.a(MMEditorRecordButton.this, true);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationStart(paramAnonymousAnimator);
            }
            AppMethodBeat.o(279930);
          }
        }).setDuration(150L).start();
        this.LbR = this.LbH.animate().scaleX(1.0F).scaleY(1.0F);
        this.LbR.setDuration(150L).start();
        if (this.LbT != this.LbS)
        {
          if (this.LbO != null) {
            this.LbO.cancel();
          }
          this.LbO = ObjectAnimator.ofArgb(this.Lcb, "color", new int[] { this.LbT, this.LbS });
          this.LbO.setDuration(150L);
          this.LbO.start();
        }
      }
    }
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.NWD = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(279984);
    this.LbT = paramInt;
    if ((this.Lcb instanceof GradientDrawable)) {
      ((GradientDrawable)this.Lcb).setColor(paramInt);
    }
    AppMethodBeat.o(279984);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(279992);
    if ((this.Lca instanceof GradientDrawable)) {
      ((GradientDrawable)this.Lca).setColor(paramInt);
    }
    AppMethodBeat.o(279992);
  }
  
  public void setLongPressCallback(MMEditorRecordButton.b paramb)
  {
    this.NWB = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.NWC = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.NWA = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(280015);
    Log.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(280015);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280023);
    Log.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new MMEditorRecordButton.2(this, paramInt), 150L);
      AppMethodBeat.o(280023);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(280023);
  }
  
  public static abstract interface a {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton
 * JD-Core Version:    0.7.0.1
 */