package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

public final class b
  extends a
{
  public b(Context paramContext, View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, final View paramView6, View paramView7, View paramView8, View paramView9)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8, paramView9);
    paramView2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        paramView2.getViewTreeObserver().removeOnPreDrawListener(this);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
        b.this.rvj = (localLayoutParams.leftMargin - b.this.mvy);
        return true;
      }
    });
    paramView6.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        paramView6.getViewTreeObserver().removeOnPreDrawListener(this);
        b.this.rvi = ((int)paramView6.getX());
        return true;
      }
    });
  }
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    if (paramb == this.rvt) {
      return;
    }
    switch (b.6.rvC[paramb.ordinal()])
    {
    default: 
      return;
    case 1: 
      cfK();
      return;
    }
    if (paramBoolean)
    {
      cfL();
      return;
    }
    this.rvl.setAlpha(0.0F);
    this.rvk.setPadding(this.rvj, 0, 0, 0);
    int i = this.rvg;
    paramb = (RelativeLayout.LayoutParams)this.rvk.getLayoutParams();
    paramb.leftMargin = (this.rvg - i);
    paramb.rightMargin = (this.rvg - i);
    paramb.width = (i * 2 + (int)this.rvs[2][0]);
    this.rvk.setLayoutParams(paramb);
    this.rvk.post(new Runnable()
    {
      public final void run()
      {
        b.this.rvk.setY(b.this.rvs[0][1]);
        b.this.rvk.setX(b.this.rvs[1][1]);
      }
    });
  }
  
  public final void b(a.b paramb)
  {
    a(paramb, true);
  }
  
  protected final void cfK()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.rvs[0][0] - this.rvh >= 0.0F) {
      localValueAnimator.addUpdateListener(this.rvx);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.rvr, "alpha", new float[] { 0.0F, 1.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.rvl, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          b.this.isAnimating = false;
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          b.this.isAnimating = false;
          if (b.this.rvu != null) {
            b.this.rvu.onAnimationEnd();
          }
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          b.this.isAnimating = true;
          if (b.this.rvu != null) {
            b.this.rvu.onAnimationStart();
          }
          b.this.rvl.setVisibility(0);
        }
      });
      localAnimatorSet.start();
      return;
      localValueAnimator.addUpdateListener(this.rvy);
    }
  }
  
  protected final void cfL()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    if (this.rvs[0][0] - this.rvh >= 0.0F) {
      localValueAnimator.addUpdateListener(this.rvv);
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.rvr, "alpha", new float[] { 1.0F, 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.rvl, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator, localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new b.5(this));
      localAnimatorSet.start();
      return;
      localValueAnimator.addUpdateListener(this.rvw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.b
 * JD-Core Version:    0.7.0.1
 */