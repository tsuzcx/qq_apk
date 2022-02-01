package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private boolean JzI;
  private float LhU;
  private AnimatorSet LhV;
  private ViewOutlineProvider LhW;
  float yT;
  
  public e(Activity paramActivity, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramActivity, paramView, false);
    AppMethodBeat.i(216220);
    this.LhW = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(267635);
        paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), e.this.yT);
        AppMethodBeat.o(267635);
      }
    };
    aC(paramBundle);
    this.LhU = com.tencent.mm.ci.a.fromDPToPix(this.LhJ, 8);
    this.yT = this.LhU;
    this.JzI = paramBoolean;
    Object localObject = this.view;
    ((View)localObject).setClipToOutline(true);
    ((View)localObject).setOutlineProvider(this.LhW);
    paramActivity = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
    paramActivity.setDuration(400L);
    int i = 90;
    if (this.JzI) {
      i = -90;
    }
    paramView = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { i, 0.0F });
    paramView.setDuration(400L);
    float f3 = 1.0F;
    float f4 = 1.0F;
    float f2 = f4;
    float f1 = f3;
    if (this.targetWidth != 0)
    {
      f2 = f4;
      f1 = f3;
      if (this.targetHeight != 0)
      {
        f1 = this.LhO * 1.0F / this.targetWidth;
        f2 = this.LhN * 1.0F / this.targetHeight;
      }
    }
    paramBundle = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { f1, 1.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { f2, 1.0F });
    paramBundle.setDuration(400L);
    localObjectAnimator1.setDuration(400L);
    f1 = this.LhL;
    f2 = this.LhN / 2.0F;
    f3 = this.LhM;
    f4 = this.LhO / 2.0F;
    float f5 = this.targetWidth / 2.0F;
    float f6 = this.targetHeight / 2.0F;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { f1 + f2 - f5, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { f3 + f4 - f6, 0.0F });
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator3.setDuration(400L);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.LhU, 0.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setStartDelay(300L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(213097);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        e.this.yT = f;
        this.LhX.invalidateOutline();
        AppMethodBeat.o(213097);
      }
    });
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).setStartDelay(300L);
    ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(269373);
        if (e.this.LhK != null)
        {
          float f = ((Float)this.LhZ.getAnimatedValue()).floatValue();
          e.this.LhK.ca(f);
        }
        AppMethodBeat.o(269373);
      }
    });
    this.LhV = new AnimatorSet();
    this.LhV.playTogether(new Animator[] { paramActivity, paramView, paramBundle, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localValueAnimator, localObject });
    this.LhV.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(226475);
        if (e.this.LhK != null) {
          e.this.LhK.onAnimationEnd();
        }
        AppMethodBeat.o(226475);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(226473);
        if (e.this.LhK != null) {
          e.this.LhK.onAnimationStart();
        }
        AppMethodBeat.o(226473);
      }
    });
    AppMethodBeat.o(216220);
  }
  
  public final void fYs()
  {
    AppMethodBeat.i(216223);
    if ((this.LhV != null) && (!this.LhV.isStarted()))
    {
      this.LhV.setStartDelay(0L);
      this.LhV.start();
    }
    AppMethodBeat.o(216223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.e
 * JD-Core Version:    0.7.0.1
 */