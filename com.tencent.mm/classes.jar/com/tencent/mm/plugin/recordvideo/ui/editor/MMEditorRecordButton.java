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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.z;

public class MMEditorRecordButton
  extends FrameLayout
{
  private static final int Pk;
  private static final float vUF;
  private float aTM;
  private boolean enable;
  private ap gIf;
  private Runnable gmO;
  private boolean isAnimating;
  private boolean smb;
  private boolean vUA;
  private long vUG;
  private View vUH;
  private View vUI;
  private boolean vUK;
  private boolean vUL;
  private ViewPropertyAnimator vUN;
  private ValueAnimator vUO;
  private ViewPropertyAnimator vUQ;
  private ViewPropertyAnimator vUR;
  private int vUS;
  private int vUT;
  private int vUU;
  private int vUV;
  private Drawable vVa;
  private Drawable vVb;
  private boolean vVc;
  private boolean vVd;
  private Runnable vVe;
  private ImageView xMK;
  private MMEditorCircularProgressBar xML;
  private d xMM;
  private b xMN;
  private c xMO;
  private a xMP;
  private Drawable xMQ;
  
  static
  {
    AppMethodBeat.i(200268);
    Pk = ViewConfiguration.getTapTimeout();
    vUF = aj.getContext().getResources().getDimensionPixelSize(2131165279) / aj.getContext().getResources().getDimensionPixelSize(2131165301);
    AppMethodBeat.o(200268);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200255);
    this.vUG = -1L;
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
        AppMethodBeat.i(200252);
        ad.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this).jB();
          }
        }
        AppMethodBeat.o(200252);
      }
    };
    this.vVe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200253);
        ad.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(200253);
      }
    };
    init();
    AppMethodBeat.o(200255);
  }
  
  public MMEditorRecordButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200256);
    this.vUG = -1L;
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
        AppMethodBeat.i(200252);
        ad.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
        if (!MMEditorRecordButton.a(MMEditorRecordButton.this))
        {
          MMEditorRecordButton.c(MMEditorRecordButton.this);
          if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null) {
            MMEditorRecordButton.d(MMEditorRecordButton.this).jB();
          }
        }
        AppMethodBeat.o(200252);
      }
    };
    this.vVe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200253);
        ad.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.e(MMEditorRecordButton.this)) });
        if (MMEditorRecordButton.e(MMEditorRecordButton.this)) {
          MMEditorRecordButton.f(MMEditorRecordButton.this);
        }
        AppMethodBeat.o(200253);
      }
    };
    init();
    AppMethodBeat.o(200256);
  }
  
  private void init()
  {
    AppMethodBeat.i(200257);
    ad.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", new Object[] { Integer.valueOf(500), Integer.valueOf(Pk) });
    this.vVa = getContext().getResources().getDrawable(2131235064);
    this.vVb = getContext().getResources().getDrawable(2131235065);
    this.xMQ = ao.k(getContext(), 2131690428, getResources().getColor(2131099777));
    this.vUS = Color.parseColor("#FFDDDDDD");
    this.vUT = Color.parseColor("#4CFA9D3B");
    z.jO(getContext()).inflate(2131496477, this, true);
    this.xMK = ((ImageView)findViewById(2131308331));
    this.vUH = findViewById(2131301021);
    this.vUI = findViewById(2131303113);
    this.xML = ((MMEditorCircularProgressBar)findViewById(2131298337));
    this.xMK.setImageDrawable(this.xMQ);
    this.vUH.setBackground(this.vVa);
    this.vUI.setBackground(this.vVb);
    this.enable = true;
    AppMethodBeat.o(200257);
  }
  
  public final void NT(int paramInt)
  {
    AppMethodBeat.i(200261);
    ad.m("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s", new Object[] { Float.valueOf(0.0F), Float.valueOf(100.0F) });
    this.xML.setCircularColor(paramInt);
    this.xML.setMaxProgress(100.0F);
    this.xML.setCurrentProgress(0.0F);
    this.xML.setVisibility(0);
    AppMethodBeat.o(200261);
  }
  
  public final void bc(float paramFloat)
  {
    AppMethodBeat.i(200262);
    this.xML.setCurrentProgress(paramFloat);
    AppMethodBeat.o(200262);
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200265);
    if (!this.enable)
    {
      ad.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
      AppMethodBeat.o(200265);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200265);
      return true;
      this.smb = true;
      this.vUG = System.currentTimeMillis();
      this.vUK = false;
      this.vUL = false;
      this.aTM = paramMotionEvent.getRawY();
      this.gIf.removeCallbacksAndMessages(null);
      this.gIf.postDelayed(this.gmO, 550L);
      this.gIf.postDelayed(this.vVe, 250L);
      this.vVd = true;
      this.vVc = true;
      continue;
      float f1 = paramMotionEvent.getRawY();
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      if ((f1 < arrayOfInt[1]) && ((this.vUL) || (!this.vUA)))
      {
        if (this.aTM <= 0.0F) {
          this.aTM = paramMotionEvent.getRawY();
        }
        while (this.xMN != null)
        {
          break;
          float f2 = Math.abs(f1 - this.aTM);
          int i;
          if ((f1 < this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ad.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.vVc) });
            Math.min(i, 3);
            this.aTM = f1;
            this.vVc = false;
          }
          else if ((f1 > this.aTM) && (f2 >= 10.0F))
          {
            i = (int)(f2 / 10.0F);
            ad.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.vVd) });
            Math.min(i, 3);
            this.vVd = false;
            this.aTM = f1;
          }
        }
        this.smb = false;
        this.gIf.removeCallbacks(this.vVe, Integer.valueOf(Pk));
        this.gIf.removeCallbacks(this.gmO);
        final long l = System.currentTimeMillis() - this.vUG;
        ad.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", new Object[] { Boolean.valueOf(this.vUL), Boolean.valueOf(this.vUK), Long.valueOf(this.vUG), Long.valueOf(l) });
        paramMotionEvent = new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(200254);
            if ((MMEditorRecordButton.g(MMEditorRecordButton.this) > 0L) && (l <= 500L) && (!MMEditorRecordButton.b(MMEditorRecordButton.this)))
            {
              ad.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", new Object[] { Boolean.valueOf(MMEditorRecordButton.a(MMEditorRecordButton.this)), Boolean.valueOf(MMEditorRecordButton.b(MMEditorRecordButton.this)) });
              MMEditorRecordButton.h(MMEditorRecordButton.this);
              if ((!MMEditorRecordButton.b(MMEditorRecordButton.this)) && (MMEditorRecordButton.i(MMEditorRecordButton.this) != null))
              {
                MMEditorRecordButton.i(MMEditorRecordButton.this);
                AppMethodBeat.o(200254);
              }
            }
            else if (MMEditorRecordButton.b(MMEditorRecordButton.this))
            {
              if (MMEditorRecordButton.d(MMEditorRecordButton.this) != null)
              {
                MMEditorRecordButton.d(MMEditorRecordButton.this).ckq();
                AppMethodBeat.o(200254);
              }
            }
            else
            {
              ad.i("MicroMsg.MMSightRecordButton", "error action up");
              if (MMEditorRecordButton.j(MMEditorRecordButton.this) != null) {
                MMEditorRecordButton.j(MMEditorRecordButton.this);
              }
            }
            AppMethodBeat.o(200254);
          }
        };
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
            AppMethodBeat.i(200250);
            MMEditorRecordButton.a(MMEditorRecordButton.this, false);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationEnd(paramAnonymousAnimator);
            }
            AppMethodBeat.o(200250);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(200249);
            MMEditorRecordButton.a(MMEditorRecordButton.this, true);
            if (paramMotionEvent != null) {
              paramMotionEvent.onAnimationStart(paramAnonymousAnimator);
            }
            AppMethodBeat.o(200249);
          }
        }).setDuration(150L).start();
        this.vUR = this.vUI.animate().scaleX(1.0F).scaleY(1.0F);
        this.vUR.setDuration(150L).start();
        if (this.vUT != this.vUS)
        {
          if (this.vUO != null) {
            this.vUO.cancel();
          }
          this.vUO = ObjectAnimator.ofArgb(this.vVb, "color", new int[] { this.vUT, this.vUS });
          this.vUO.setDuration(150L);
          this.vUO.start();
        }
      }
    }
  }
  
  public void setErrorPressCallback(a parama)
  {
    this.xMP = parama;
  }
  
  public void setHighLightOuter(int paramInt)
  {
    AppMethodBeat.i(200258);
    this.vUT = paramInt;
    if ((this.vVb instanceof GradientDrawable)) {
      ((GradientDrawable)this.vVb).setColor(paramInt);
    }
    AppMethodBeat.o(200258);
  }
  
  public void setInnerColor(int paramInt)
  {
    AppMethodBeat.i(200259);
    if ((this.vVa instanceof GradientDrawable)) {
      ((GradientDrawable)this.vVa).setColor(paramInt);
    }
    AppMethodBeat.o(200259);
  }
  
  public void setLongPressCallback(b paramb)
  {
    this.xMN = paramb;
  }
  
  public void setLongPressScrollCallback(c paramc)
  {
    this.xMO = paramc;
  }
  
  public void setSimpleTapCallback(d paramd)
  {
    this.xMM = paramd;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(200260);
    ad.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.enable = paramBoolean;
    AppMethodBeat.o(200260);
  }
  
  public void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(200263);
    ad.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", new Object[] { Boolean.valueOf(this.isAnimating) });
    if (this.isAnimating)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200251);
          MMEditorRecordButton.a(MMEditorRecordButton.this, paramInt);
          AppMethodBeat.o(200251);
        }
      }, 150L);
      AppMethodBeat.o(200263);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(200263);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(200264);
    if (this.smb)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 0, 0.0F, 0.0F, 0);
      localMotionEvent.setAction(3);
      onTouchEvent(localMotionEvent);
    }
    AppMethodBeat.o(200264);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void ckq();
    
    public abstract void jB();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton
 * JD-Core Version:    0.7.0.1
 */