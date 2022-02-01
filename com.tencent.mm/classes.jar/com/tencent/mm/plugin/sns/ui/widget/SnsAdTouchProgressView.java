package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected GestureDetector ktZ;
  protected Context mContext;
  protected boolean mGk;
  protected View mInnerView;
  protected boolean mIsCanceled;
  protected Handler xSa;
  protected float xXD;
  protected float xXE;
  protected View xXF;
  protected FrameLayout.LayoutParams xXG;
  protected FrameLayout.LayoutParams xXH;
  protected int xXI;
  protected int xXJ;
  protected boolean xXK;
  protected boolean xXL;
  protected AnimatorSet xXM;
  protected AnimatorSet xXN;
  protected int xXO;
  protected int xXP;
  protected a xve;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.xXD = 0.0F;
    this.xXE = 0.0F;
    this.xXK = false;
    this.mGk = false;
    this.mIsCanceled = false;
    this.xXL = false;
    this.xSa = new Handler(Looper.getMainLooper());
    this.xXP = 4000;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.xXD = 0.0F;
    this.xXE = 0.0F;
    this.xXK = false;
    this.mGk = false;
    this.mIsCanceled = false;
    this.xXL = false;
    this.xSa = new Handler(Looper.getMainLooper());
    this.xXP = 4000;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void NX(int paramInt)
  {
    AppMethodBeat.i(179411);
    int i = (int)(0.125D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.xXF, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(i);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.xXF, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.xXF, "alpha", new float[] { 0.4F, 0.4F });
    localObjectAnimator3.setDuration(i);
    i = (int)(0.75D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.xXF, "scaleX", new float[] { 1.0F, 1.0F });
    localObjectAnimator4.setDuration(i);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.xXF, "scaleY", new float[] { 1.0F, 1.0F });
    localObjectAnimator5.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.xXF, "scaleX", new float[] { 1.0F, 0.875F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.xXF, "scaleY", new float[] { 1.0F, 0.875F });
    localObjectAnimator7.setDuration(i);
    paramInt = (int)(0.075D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.xXF, "scaleX", new float[] { 0.875F, 1.16667F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.xXF, "scaleY", new float[] { 0.875F, 1.16667F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.xXF, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.xXN = new AnimatorSet();
    this.xXN.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.xXN.play(localObjectAnimator4).with(localObjectAnimator5).after(localObjectAnimator1);
    this.xXN.play(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.xXN.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator6);
    AppMethodBeat.o(179411);
  }
  
  private void NY(int paramInt)
  {
    AppMethodBeat.i(179412);
    this.xXO = ((int)(0.125D * paramInt));
    int i = (int)(0.75D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", new float[] { 0.5F, 1.0F });
    localObjectAnimator1.setDuration(i);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", new float[] { 0.5F, 1.0F });
    localObjectAnimator2.setDuration(i);
    i = (int)(0.3125D * paramInt);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator3.setDuration(i);
    i = (int)(0.4375D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.8F, 0.9F });
    localObjectAnimator4.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", new float[] { 1.0F, 0.875F });
    localObjectAnimator5.setDuration(i);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", new float[] { 1.0F, 0.875F });
    localObjectAnimator6.setDuration(i);
    paramInt = (int)(0.075D * paramInt);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", new float[] { 0.875F, 1.16667F });
    localObjectAnimator7.setDuration(paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", new float[] { 0.875F, 1.16667F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.9F, 0.0F });
    localObjectAnimator9.setDuration(paramInt);
    this.xXM = new AnimatorSet();
    this.xXM.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.xXM.play(localObjectAnimator4).after(localObjectAnimator3);
    this.xXM.play(localObjectAnimator5).with(localObjectAnimator6).after(localObjectAnimator2);
    this.xXM.play(localObjectAnimator7).with(localObjectAnimator8).with(localObjectAnimator9).after(localObjectAnimator6);
    ad.i("SnsAdTouchProgressView", "initInnerAnim, animSet.hash=" + this.xXM.hashCode());
    this.xXM.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(179403);
        StringBuilder localStringBuilder = new StringBuilder("onAnimationEnd, isCanceled=").append(SnsAdTouchProgressView.this.mIsCanceled).append(", hash=");
        if (paramAnonymousAnimator == null) {}
        for (paramAnonymousAnimator = "";; paramAnonymousAnimator = Integer.valueOf(paramAnonymousAnimator.hashCode()))
        {
          ad.i("SnsAdTouchProgressView", paramAnonymousAnimator);
          SnsAdTouchProgressView.this.mGk = false;
          if ((SnsAdTouchProgressView.this.xve != null) && (!SnsAdTouchProgressView.this.mIsCanceled))
          {
            SnsAdTouchProgressView.this.xve.onFinish();
            SnsAdTouchProgressView.this.xXK = true;
          }
          AppMethodBeat.o(179403);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(187790);
        StringBuilder localStringBuilder = new StringBuilder("onAnimationStart, hash=");
        if (paramAnonymousAnimator == null) {}
        for (paramAnonymousAnimator = "";; paramAnonymousAnimator = Integer.valueOf(paramAnonymousAnimator.hashCode()))
        {
          ad.i("SnsAdTouchProgressView", paramAnonymousAnimator);
          AppMethodBeat.o(187790);
          return;
        }
      }
    });
    AppMethodBeat.o(179412);
  }
  
  private void hz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179415);
    int i = this.xXI;
    int j = this.xXI;
    int k = this.xXJ;
    int m = this.xXJ;
    this.xXG.leftMargin = (paramInt1 - i);
    this.xXG.topMargin = (paramInt2 - j);
    this.xXH.leftMargin = (paramInt1 - k);
    this.xXH.topMargin = (paramInt2 - m);
    this.mInnerView.setLayoutParams(this.xXG);
    this.xXF.setLayoutParams(this.xXH);
    AppMethodBeat.o(179415);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.mInnerView = new View(paramContext);
    this.mInnerView.setBackgroundResource(2131234091);
    this.xXF = new View(paramContext);
    this.xXF.setBackgroundResource(2131234092);
    this.xXI = a.fromDPToPix(paramContext, 60);
    this.xXJ = this.xXI;
    this.xXG = new FrameLayout.LayoutParams(this.xXI * 2, this.xXI * 2);
    this.xXH = new FrameLayout.LayoutParams(this.xXJ * 2, this.xXJ * 2);
    addView(this.xXF, this.xXH);
    addView(this.mInnerView, this.xXG);
    hz(0, 0);
    NY(this.xXP);
    NX(this.xXP);
    this.xXF.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.ktZ = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179402);
        ad.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.mGk = true;
        SnsAdTouchProgressView.this.xXL = true;
        if (SnsAdTouchProgressView.this.xve != null) {
          SnsAdTouchProgressView.this.xve.onStart();
        }
        SnsAdTouchProgressView.this.dEh();
        SnsAdTouchProgressView.this.dEi();
        AppMethodBeat.o(179402);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
      
      public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179401);
        if (SnsAdTouchProgressView.this.xve != null) {
          SnsAdTouchProgressView.this.xve.onClick(SnsAdTouchProgressView.this);
        }
        AppMethodBeat.o(179401);
        return true;
      }
    });
    AppMethodBeat.o(179407);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179409);
    ad.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.xXF.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.xXN.cancel();
    this.xXM.cancel();
    this.xSa.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179409);
  }
  
  protected final void dEh()
  {
    AppMethodBeat.i(179413);
    ad.i("SnsAdTouchProgressView", "doOuterAnim");
    this.xXF.setVisibility(0);
    this.xXN.cancel();
    this.xXN.start();
    AppMethodBeat.o(179413);
  }
  
  protected final void dEi()
  {
    AppMethodBeat.i(179414);
    ad.i("SnsAdTouchProgressView", "doInnerAnim");
    this.mInnerView.setVisibility(4);
    this.xSa.removeCallbacksAndMessages(null);
    this.xXM.cancel();
    this.xSa.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179404);
        SnsAdTouchProgressView.this.mInnerView.setVisibility(0);
        SnsAdTouchProgressView.this.xXM.start();
        AppMethodBeat.o(179404);
      }
    }, this.xXO);
    AppMethodBeat.o(179414);
  }
  
  public final boolean isAnimating()
  {
    return this.mGk;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    boolean bool = this.ktZ.onTouchEvent(paramMotionEvent);
    if (i == 0)
    {
      this.xXD = paramMotionEvent.getX();
      this.xXE = paramMotionEvent.getY();
      hz((int)this.xXD, (int)this.xXE);
      this.xXK = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        ad.i("SnsAdTouchProgressView", "onTouchEvent cancel, action=" + i + ", IsLongClicked=" + this.xXL + ", isSuccFinish=" + this.xXK);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.mGk = false;
        if ((!this.xXK) && (this.xXL) && (this.xve != null)) {
          this.xve.onCancel();
        }
        this.xXL = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.xve = parama;
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(179408);
    ad.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.xXP;
    }
    NY(i);
    NX(i);
    AppMethodBeat.o(179408);
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onClick(View paramView);
    
    public abstract void onFinish();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView
 * JD-Core Version:    0.7.0.1
 */