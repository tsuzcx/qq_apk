package com.tencent.mm.plugin.sns.ad.e;

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

public final class i
{
  protected View DsR;
  protected View DsS;
  protected AnimatorSet DsT;
  protected AnimatorSet DsU;
  protected boolean DsV;
  protected boolean DsW;
  private final int dgM;
  protected Context mContext;
  protected boolean nmN;
  
  public i(View paramView1, View paramView2, Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(201937);
    this.nmN = false;
    this.dgM = 500;
    this.DsR = paramView1;
    this.DsS = paramView2;
    this.mContext = paramContext;
    this.DsW = paramBoolean;
    paramContext = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
    paramContext.setDuration(0L);
    if (this.DsW)
    {
      paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -180.0F, 10.0F });
      paramView1.setDuration(500L);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(0L);
      localObjectAnimator.setStartDelay(250L);
      if (!this.DsW) {
        break label397;
      }
      paramView2 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 10.0F, 0.0F });
      label161:
      paramView2.setDuration(500L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(paramContext).with(paramView1).with(localObjectAnimator);
      localAnimatorSet.play(paramView2).after(paramView1);
      this.DsT = localAnimatorSet;
      if (!this.DsW) {
        break label419;
      }
    }
    label397:
    label419:
    for (paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, 190.0F });; paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, -190.0F }))
    {
      paramView1.setDuration(500L);
      paramView2 = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
      paramView2.setDuration(0L);
      paramView2.setStartDelay(250L);
      paramContext = new AnimatorSet();
      paramContext.play(paramView1).with(paramView2);
      this.DsU = paramContext;
      this.DsT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(201935);
          super.onAnimationStart(paramAnonymousAnimator);
          i.this.nmN = true;
          AppMethodBeat.o(201935);
        }
      });
      this.DsU.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(201936);
          super.onAnimationEnd(paramAnonymousAnimator);
          i.this.nmN = false;
          AppMethodBeat.o(201936);
        }
      });
      float f = this.DsR.getContext().getResources().getDisplayMetrics().density * -3000.0F;
      this.DsR.setCameraDistance(f);
      this.DsS.setCameraDistance(f);
      AppMethodBeat.o(201937);
      return;
      paramView1 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 180.0F, -10.0F });
      break;
      paramView2 = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -10.0F, 0.0F });
      break label161;
    }
  }
  
  public final void eWQ()
  {
    AppMethodBeat.i(201938);
    if (!this.nmN)
    {
      if (!this.DsV)
      {
        this.DsT.setTarget(this.DsR);
        this.DsU.setTarget(this.DsS);
        this.DsT.start();
        this.DsU.start();
        this.DsV = true;
        AppMethodBeat.o(201938);
        return;
      }
      this.DsT.setTarget(this.DsS);
      this.DsU.setTarget(this.DsR);
      this.DsT.start();
      this.DsU.start();
      this.DsV = false;
    }
    AppMethodBeat.o(201938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.i
 * JD-Core Version:    0.7.0.1
 */