package com.tencent.mm.plugin.sns.ad.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  protected View Dbo;
  protected View JzE;
  protected AnimatorSet JzF;
  protected AnimatorSet JzG;
  protected boolean JzH;
  protected boolean JzI;
  private int JzJ;
  private int eYt;
  protected Context mContext;
  protected boolean qov;
  
  public m(View paramView1, View paramView2, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(234575);
    this.qov = false;
    this.JzE = paramView1;
    this.Dbo = paramView2;
    this.mContext = paramContext;
    this.JzI = paramBoolean;
    this.eYt = 500;
    this.JzJ = -3000;
    paramContext = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
    paramContext.setDuration(0L);
    if (this.JzI)
    {
      paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -180.0F, 10.0F });
      paramView1.setDuration(this.eYt);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(0L);
      localObjectAnimator.setStartDelay(this.eYt / 2);
      if (!this.JzI) {
        break label429;
      }
      paramView2 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 10.0F, 0.0F });
      label174:
      paramView2.setDuration(this.eYt);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(paramContext).with(paramView1).with(localObjectAnimator);
      localAnimatorSet.play(paramView2).after(paramView1);
      this.JzF = localAnimatorSet;
      if (!this.JzI) {
        break label451;
      }
    }
    label429:
    label451:
    for (paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, 190.0F });; paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, -190.0F }))
    {
      paramView1.setDuration(this.eYt);
      paramView2 = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
      paramView2.setDuration(0L);
      paramView2.setStartDelay(this.eYt / 2);
      paramContext = new AnimatorSet();
      paramContext.play(paramView1).with(paramView2);
      this.JzG = paramContext;
      this.JzF.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(224211);
          super.onAnimationStart(paramAnonymousAnimator);
          m.this.qov = true;
          AppMethodBeat.o(224211);
        }
      });
      this.JzG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(270283);
          super.onAnimationEnd(paramAnonymousAnimator);
          m.this.qov = false;
          AppMethodBeat.o(270283);
        }
      });
      int i = this.JzJ;
      float f = this.JzE.getContext().getResources().getDisplayMetrics().density;
      f = i * f;
      this.JzE.setCameraDistance(f);
      this.Dbo.setCameraDistance(f);
      AppMethodBeat.o(234575);
      return;
      paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 180.0F, -10.0F });
      break;
      paramView2 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -10.0F, 0.0F });
      break label174;
    }
  }
  
  public final void fKa()
  {
    AppMethodBeat.i(234577);
    if (!this.qov)
    {
      if (!this.JzH)
      {
        this.JzF.setTarget(this.JzE);
        this.JzG.setTarget(this.Dbo);
        this.JzF.start();
        this.JzG.start();
        this.JzH = true;
        AppMethodBeat.o(234577);
        return;
      }
      this.JzF.setTarget(this.Dbo);
      this.JzG.setTarget(this.JzE);
      this.JzF.start();
      this.JzG.start();
      this.JzH = false;
    }
    AppMethodBeat.o(234577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.m
 * JD-Core Version:    0.7.0.1
 */