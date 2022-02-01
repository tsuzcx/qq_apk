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
  protected View POr;
  protected Object POs;
  protected AnimatorSet POt;
  protected AnimatorSet POu;
  protected boolean POv;
  protected boolean POw;
  private int POx;
  private int hbT;
  protected Context mContext;
  protected boolean ttc;
  
  public p(View paramView, Object paramObject, Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(309959);
    this.ttc = false;
    this.POr = paramView;
    this.POs = paramObject;
    this.mContext = paramContext;
    this.POw = paramBoolean;
    this.hbT = 500;
    this.POx = paramInt;
    paramContext = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
    paramContext.setDuration(0L);
    if (this.POw)
    {
      paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -180.0F, 10.0F });
      paramView.setDuration(this.hbT);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(0L);
      localObjectAnimator.setStartDelay(this.hbT / 2);
      if (!this.POw) {
        break label437;
      }
      paramObject = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 10.0F, 0.0F });
      label173:
      paramObject.setDuration(this.hbT);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(paramContext).with(paramView).with(localObjectAnimator);
      localAnimatorSet.play(paramObject).after(paramView);
      this.POt = localAnimatorSet;
      if (!this.POw) {
        break label459;
      }
    }
    label437:
    label459:
    for (paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, 190.0F });; paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, -190.0F }))
    {
      paramView.setDuration(this.hbT);
      paramObject = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
      paramObject.setDuration(0L);
      paramObject.setStartDelay(this.hbT / 2);
      paramContext = new AnimatorSet();
      paramContext.play(paramView).with(paramObject);
      this.POu = paramContext;
      this.POt.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(310075);
          super.onAnimationStart(paramAnonymousAnimator);
          p.this.ttc = true;
          AppMethodBeat.o(310075);
        }
      });
      this.POu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(310067);
          super.onAnimationEnd(paramAnonymousAnimator);
          p.this.ttc = false;
          AppMethodBeat.o(310067);
        }
      });
      paramInt = this.POx;
      float f = this.POr.getContext().getResources().getDisplayMetrics().density * paramInt;
      this.POr.setCameraDistance(f);
      if ((this.POs instanceof View)) {
        ((View)this.POs).setCameraDistance(f);
      }
      AppMethodBeat.o(309959);
      return;
      paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 180.0F, -10.0F });
      break;
      paramObject = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -10.0F, 0.0F });
      break label173;
    }
  }
  
  public final void gZV()
  {
    AppMethodBeat.i(309967);
    if (!this.ttc)
    {
      if (!this.POv)
      {
        this.POt.setTarget(this.POr);
        this.POu.setTarget(this.POs);
        this.POt.start();
        this.POu.start();
        this.POv = true;
        AppMethodBeat.o(309967);
        return;
      }
      this.POt.setTarget(this.POs);
      this.POu.setTarget(this.POr);
      this.POt.start();
      this.POu.start();
      this.POv = false;
    }
    AppMethodBeat.o(309967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.p
 * JD-Core Version:    0.7.0.1
 */