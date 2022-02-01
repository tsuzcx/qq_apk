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
  private boolean POw;
  private AnimatorSet Qgq;
  private float RIi;
  private ViewOutlineProvider RIj;
  float Ri;
  
  public e(Activity paramActivity, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramActivity, paramView, false);
    AppMethodBeat.i(309320);
    this.RIj = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(309309);
        paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), e.this.Ri);
        AppMethodBeat.o(309309);
      }
    };
    bd(paramBundle);
    this.RIi = com.tencent.mm.cd.a.fromDPToPix(this.hOx, 8);
    this.Ri = this.RIi;
    this.POw = paramBoolean;
    Object localObject = this.view;
    ((View)localObject).setClipToOutline(true);
    ((View)localObject).setOutlineProvider(this.RIj);
    paramActivity = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
    paramActivity.setDuration(400L);
    int i = 90;
    if (this.POw) {
      i = -90;
    }
    paramView = ObjectAnimator.ofFloat(localObject, "rotation", new float[] { i, 0.0F });
    paramView.setDuration(400L);
    float f3 = 1.0F;
    float f4 = 1.0F;
    float f2 = f4;
    float f1 = f3;
    if (this.nxO != 0)
    {
      f2 = f4;
      f1 = f3;
      if (this.nxP != 0)
      {
        f1 = this.RIc * 1.0F / this.nxO;
        f2 = this.RIb * 1.0F / this.nxP;
      }
    }
    paramBundle = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { f1, 1.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { f2, 1.0F });
    paramBundle.setDuration(400L);
    localObjectAnimator1.setDuration(400L);
    f1 = this.RHZ;
    f2 = this.RIb / 2.0F;
    f3 = this.RIa;
    f4 = this.RIc / 2.0F;
    float f5 = this.nxO / 2.0F;
    float f6 = this.nxP / 2.0F;
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "translationX", new float[] { f1 + f2 - f5, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { f3 + f4 - f6, 0.0F });
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator3.setDuration(400L);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.RIi, 0.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setStartDelay(300L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(309310);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        e.this.Ri = f;
        this.RIk.invalidateOutline();
        AppMethodBeat.o(309310);
      }
    });
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).setStartDelay(300L);
    ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(309311);
        if (e.this.RHY != null)
        {
          float f = ((Float)this.RIm.getAnimatedValue()).floatValue();
          e.this.RHY.dg(f);
        }
        AppMethodBeat.o(309311);
      }
    });
    this.Qgq = new AnimatorSet();
    this.Qgq.playTogether(new Animator[] { paramActivity, paramView, paramBundle, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localValueAnimator, localObject });
    this.Qgq.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(309316);
        if (e.this.RHY != null) {
          e.this.RHY.onAnimationEnd();
        }
        AppMethodBeat.o(309316);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(309313);
        if (e.this.RHY != null) {
          e.this.RHY.onAnimationStart();
        }
        AppMethodBeat.o(309313);
      }
    });
    AppMethodBeat.o(309320);
  }
  
  public final void hqQ()
  {
    AppMethodBeat.i(309322);
    if ((this.Qgq != null) && (!this.Qgq.isStarted()))
    {
      this.Qgq.setStartDelay(0L);
      this.Qgq.start();
    }
    AppMethodBeat.o(309322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.e
 * JD-Core Version:    0.7.0.1
 */