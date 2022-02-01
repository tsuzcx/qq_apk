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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected GestureDetector kVo;
  protected Context mContext;
  protected View mInnerView;
  protected boolean mIsCanceled;
  protected boolean nip;
  protected a yHU;
  protected Handler zeV;
  protected float zkA;
  protected View zkB;
  protected FrameLayout.LayoutParams zkC;
  protected FrameLayout.LayoutParams zkD;
  protected int zkE;
  protected int zkF;
  protected boolean zkG;
  protected boolean zkH;
  protected AnimatorSet zkI;
  protected AnimatorSet zkJ;
  protected int zkK;
  protected int zkL;
  protected float zkz;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.zkz = 0.0F;
    this.zkA = 0.0F;
    this.zkG = false;
    this.nip = false;
    this.mIsCanceled = false;
    this.zkH = false;
    this.zeV = new Handler(Looper.getMainLooper());
    this.zkL = 4000;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.zkz = 0.0F;
    this.zkA = 0.0F;
    this.zkG = false;
    this.nip = false;
    this.mIsCanceled = false;
    this.zkH = false;
    this.zeV = new Handler(Looper.getMainLooper());
    this.zkL = 4000;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void Qb(int paramInt)
  {
    AppMethodBeat.i(179411);
    int i = (int)(0.125D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.zkB, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(i);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.zkB, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.zkB, "alpha", new float[] { 0.4F, 0.4F });
    localObjectAnimator3.setDuration(i);
    i = (int)(0.75D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.zkB, "scaleX", new float[] { 1.0F, 1.0F });
    localObjectAnimator4.setDuration(i);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.zkB, "scaleY", new float[] { 1.0F, 1.0F });
    localObjectAnimator5.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.zkB, "scaleX", new float[] { 1.0F, 0.875F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.zkB, "scaleY", new float[] { 1.0F, 0.875F });
    localObjectAnimator7.setDuration(i);
    paramInt = (int)(0.075D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.zkB, "scaleX", new float[] { 0.875F, 1.16667F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.zkB, "scaleY", new float[] { 0.875F, 1.16667F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.zkB, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.zkJ = new AnimatorSet();
    this.zkJ.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.zkJ.play(localObjectAnimator4).with(localObjectAnimator5).after(localObjectAnimator1);
    this.zkJ.play(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.zkJ.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator6);
    AppMethodBeat.o(179411);
  }
  
  private void Qc(int paramInt)
  {
    AppMethodBeat.i(179412);
    this.zkK = ((int)(0.125D * paramInt));
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
    this.zkI = new AnimatorSet();
    this.zkI.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.zkI.play(localObjectAnimator4).after(localObjectAnimator3);
    this.zkI.play(localObjectAnimator5).with(localObjectAnimator6).after(localObjectAnimator2);
    this.zkI.play(localObjectAnimator7).with(localObjectAnimator8).with(localObjectAnimator9).after(localObjectAnimator6);
    ac.i("SnsAdTouchProgressView", "initInnerAnim, animSet.hash=" + this.zkI.hashCode());
    this.zkI.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(179403);
        StringBuilder localStringBuilder = new StringBuilder("onAnimationEnd, isCanceled=").append(SnsAdTouchProgressView.this.mIsCanceled).append(", hash=");
        if (paramAnonymousAnimator == null) {}
        for (paramAnonymousAnimator = "";; paramAnonymousAnimator = Integer.valueOf(paramAnonymousAnimator.hashCode()))
        {
          ac.i("SnsAdTouchProgressView", paramAnonymousAnimator);
          SnsAdTouchProgressView.this.nip = false;
          if ((SnsAdTouchProgressView.this.yHU != null) && (!SnsAdTouchProgressView.this.mIsCanceled))
          {
            SnsAdTouchProgressView.this.yHU.onFinish();
            SnsAdTouchProgressView.this.zkG = true;
          }
          AppMethodBeat.o(179403);
          return;
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200663);
        StringBuilder localStringBuilder = new StringBuilder("onAnimationStart, hash=");
        if (paramAnonymousAnimator == null) {}
        for (paramAnonymousAnimator = "";; paramAnonymousAnimator = Integer.valueOf(paramAnonymousAnimator.hashCode()))
        {
          ac.i("SnsAdTouchProgressView", paramAnonymousAnimator);
          AppMethodBeat.o(200663);
          return;
        }
      }
    });
    AppMethodBeat.o(179412);
  }
  
  private void hI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179415);
    int i = this.zkE;
    int j = this.zkE;
    int k = this.zkF;
    int m = this.zkF;
    this.zkC.leftMargin = (paramInt1 - i);
    this.zkC.topMargin = (paramInt2 - j);
    this.zkD.leftMargin = (paramInt1 - k);
    this.zkD.topMargin = (paramInt2 - m);
    this.mInnerView.setLayoutParams(this.zkC);
    this.zkB.setLayoutParams(this.zkD);
    AppMethodBeat.o(179415);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.mInnerView = new View(paramContext);
    this.mInnerView.setBackgroundResource(2131234091);
    this.zkB = new View(paramContext);
    this.zkB.setBackgroundResource(2131234092);
    this.zkE = a.fromDPToPix(paramContext, 60);
    this.zkF = this.zkE;
    this.zkC = new FrameLayout.LayoutParams(this.zkE * 2, this.zkE * 2);
    this.zkD = new FrameLayout.LayoutParams(this.zkF * 2, this.zkF * 2);
    addView(this.zkB, this.zkD);
    addView(this.mInnerView, this.zkC);
    hI(0, 0);
    Qc(this.zkL);
    Qb(this.zkL);
    this.zkB.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.kVo = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
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
        ac.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.nip = true;
        SnsAdTouchProgressView.this.zkH = true;
        if (SnsAdTouchProgressView.this.yHU != null) {
          SnsAdTouchProgressView.this.yHU.onStart();
        }
        SnsAdTouchProgressView.this.dSF();
        SnsAdTouchProgressView.this.dSG();
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
        if (SnsAdTouchProgressView.this.yHU != null) {
          SnsAdTouchProgressView.this.yHU.onClick(SnsAdTouchProgressView.this);
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
    ac.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.zkB.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.zkJ.cancel();
    this.zkI.cancel();
    this.zeV.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179409);
  }
  
  protected final void dSF()
  {
    AppMethodBeat.i(179413);
    ac.i("SnsAdTouchProgressView", "doOuterAnim");
    this.zkB.setVisibility(0);
    this.zkJ.cancel();
    this.zkJ.start();
    AppMethodBeat.o(179413);
  }
  
  protected final void dSG()
  {
    AppMethodBeat.i(179414);
    ac.i("SnsAdTouchProgressView", "doInnerAnim");
    this.mInnerView.setVisibility(4);
    this.zeV.removeCallbacksAndMessages(null);
    this.zkI.cancel();
    this.zeV.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179404);
        SnsAdTouchProgressView.this.mInnerView.setVisibility(0);
        SnsAdTouchProgressView.this.zkI.start();
        AppMethodBeat.o(179404);
      }
    }, this.zkK);
    AppMethodBeat.o(179414);
  }
  
  public final boolean isAnimating()
  {
    return this.nip;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    boolean bool = this.kVo.onTouchEvent(paramMotionEvent);
    if (i == 0)
    {
      this.zkz = paramMotionEvent.getX();
      this.zkA = paramMotionEvent.getY();
      hI((int)this.zkz, (int)this.zkA);
      this.zkG = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        ac.i("SnsAdTouchProgressView", "onTouchEvent cancel, action=" + i + ", IsLongClicked=" + this.zkH + ", isSuccFinish=" + this.zkG);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.nip = false;
        if ((!this.zkG) && (this.zkH) && (this.yHU != null)) {
          this.yHU.onCancel();
        }
        this.zkH = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.yHU = parama;
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(179408);
    ac.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.zkL;
    }
    Qc(i);
    Qb(i);
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