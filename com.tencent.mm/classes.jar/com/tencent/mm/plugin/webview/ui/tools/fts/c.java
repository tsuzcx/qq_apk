package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

public final class c
  extends a
{
  public c(Context paramContext, View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9)
  {
    super(paramContext, paramView1, paramView2, paramView3, paramView4, paramView5, paramView6, paramView7, paramView8, paramView9);
    paramView2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        paramView2.getViewTreeObserver().removeOnPreDrawListener(this);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
        c.this.rvj = (localLayoutParams.leftMargin - c.this.mvy);
        return true;
      }
    });
    paramView6.getViewTreeObserver().addOnPreDrawListener(new c.2(this, paramView6));
  }
  
  public final void b(a.b paramb)
  {
    if (paramb != this.rvt) {}
    switch (c.5.rvC[paramb.ordinal()])
    {
    default: 
      return;
    case 1: 
      cfK();
      return;
    }
    cfL();
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
      localAnimatorSet.addListener(new c.3(this));
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
      localAnimatorSet.addListener(new c.4(this));
      localAnimatorSet.start();
      return;
      localValueAnimator.addUpdateListener(this.rvw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.c
 * JD-Core Version:    0.7.0.1
 */