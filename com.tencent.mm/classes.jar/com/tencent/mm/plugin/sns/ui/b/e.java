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
  private boolean DsW;
  private float ETS;
  private AnimatorSet ETT;
  private ViewOutlineProvider ETU;
  float auL;
  
  public e(Activity paramActivity, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramActivity, paramView, false);
    AppMethodBeat.i(203876);
    this.ETU = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(203875);
        paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), e.this.auL);
        AppMethodBeat.o(203875);
      }
    };
    aG(paramBundle);
    this.ETS = com.tencent.mm.cb.a.fromDPToPix(this.ETH, 8);
    this.auL = this.ETS;
    this.DsW = paramBoolean;
    Object localObject = this.view;
    ((View)localObject).setClipToOutline(true);
    ((View)localObject).setOutlineProvider(this.ETU);
    paramActivity = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
    paramActivity.setDuration(400L);
    int i = 90;
    if (this.DsW) {
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
        f1 = this.ETM * 1.0F / this.targetWidth;
        f2 = this.ETL * 1.0F / this.targetHeight;
      }
    }
    paramBundle = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { f1, 1.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { f2, 1.0F });
    paramBundle.setDuration(400L);
    localObjectAnimator1.setDuration(400L);
    f1 = this.ETJ;
    f2 = this.ETL / 2.0F;
    f3 = this.ETK;
    f4 = this.ETM / 2.0F;
    float f5 = this.targetWidth / 2.0F;
    float f6 = this.targetHeight / 2.0F;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { f1 + f2 - f5, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { f3 + f4 - f6, 0.0F });
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator3.setDuration(400L);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.ETS, 0.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setStartDelay(300L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(203871);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        e.this.auL = f;
        this.ETV.invalidateOutline();
        AppMethodBeat.o(203871);
      }
    });
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).setStartDelay(300L);
    ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(203872);
        if (e.this.ETI != null)
        {
          float f = ((Float)this.ETX.getAnimatedValue()).floatValue();
          e.this.ETI.bX(f);
        }
        AppMethodBeat.o(203872);
      }
    });
    this.ETT = new AnimatorSet();
    this.ETT.playTogether(new Animator[] { paramActivity, paramView, paramBundle, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localValueAnimator, localObject });
    this.ETT.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203874);
        if (e.this.ETI != null) {
          e.this.ETI.onAnimationEnd();
        }
        AppMethodBeat.o(203874);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203873);
        if (e.this.ETI != null) {
          e.this.ETI.onAnimationStart();
        }
        AppMethodBeat.o(203873);
      }
    });
    AppMethodBeat.o(203876);
  }
  
  public final void fkj()
  {
    AppMethodBeat.i(203877);
    if ((this.ETT != null) && (!this.ETT.isStarted()))
    {
      this.ETT.setStartDelay(0L);
      this.ETT.start();
    }
    AppMethodBeat.o(203877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.e
 * JD-Core Version:    0.7.0.1
 */