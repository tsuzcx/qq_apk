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

public final class p
{
  protected View Dbo;
  protected View JzE;
  protected AnimatorSet JzF;
  protected AnimatorSet JzG;
  protected boolean JzH;
  protected boolean JzI;
  private int JzJ;
  public a JzL;
  private int eYt;
  protected Context mContext;
  protected boolean qov;
  
  public p(View paramView1, View paramView2, Context paramContext)
  {
    AppMethodBeat.i(270500);
    this.qov = false;
    this.JzE = paramView1;
    this.Dbo = paramView2;
    this.mContext = paramContext;
    this.JzI = false;
    this.eYt = 1000;
    this.JzJ = -6000;
    paramView2 = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
    paramView2.setDuration(0L);
    if (this.JzI)
    {
      paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -180.0F, 0.0F });
      paramView1.setDuration(this.eYt);
      paramContext = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
      paramContext.setDuration(0L);
      paramContext.setStartDelay(this.eYt / 2);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(paramView2).with(paramView1).with(paramContext);
      this.JzF = localAnimatorSet;
      if (!this.JzI) {
        break label375;
      }
    }
    label375:
    for (paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, 180.0F });; paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, -180.0F }))
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
          AppMethodBeat.i(270128);
          super.onAnimationStart(paramAnonymousAnimator);
          p.this.qov = true;
          AppMethodBeat.o(270128);
        }
      });
      this.JzG.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(232812);
          super.onAnimationEnd(paramAnonymousAnimator);
          p.this.qov = false;
          if (p.this.JzL != null) {
            p.this.JzL.fKb();
          }
          AppMethodBeat.o(232812);
        }
      });
      int i = this.JzJ;
      float f = this.JzE.getContext().getResources().getDisplayMetrics().density;
      f = i * f;
      this.JzE.setCameraDistance(f);
      this.Dbo.setCameraDistance(f);
      AppMethodBeat.o(270500);
      return;
      paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 180.0F, 0.0F });
      break;
    }
  }
  
  public final void fKa()
  {
    AppMethodBeat.i(270501);
    if (!this.qov)
    {
      if (!this.JzH)
      {
        this.JzF.setTarget(this.JzE);
        this.JzG.setTarget(this.Dbo);
        this.JzF.start();
        this.JzG.start();
        this.JzH = true;
        AppMethodBeat.o(270501);
        return;
      }
      this.JzF.setTarget(this.Dbo);
      this.JzG.setTarget(this.JzE);
      this.JzF.start();
      this.JzG.start();
      this.JzH = false;
    }
    AppMethodBeat.o(270501);
  }
  
  public static abstract interface a
  {
    public abstract void fKb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.p
 * JD-Core Version:    0.7.0.1
 */