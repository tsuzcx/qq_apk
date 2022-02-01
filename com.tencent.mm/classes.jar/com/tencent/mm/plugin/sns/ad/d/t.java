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

public final class t
{
  public a POD;
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
  
  public t(View paramView, Object paramObject, Context paramContext)
  {
    AppMethodBeat.i(309986);
    this.ttc = false;
    this.POr = paramView;
    this.POs = paramObject;
    this.mContext = paramContext;
    this.POw = false;
    this.hbT = 1000;
    this.POx = -6000;
    paramObject = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
    paramObject.setDuration(0L);
    if (this.POw)
    {
      paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { -180.0F, 0.0F });
      paramView.setDuration(this.hbT);
      paramContext = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
      paramContext.setDuration(0L);
      paramContext.setStartDelay(this.hbT / 2);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(paramObject).with(paramView).with(paramContext);
      this.POt = localAnimatorSet;
      if (!this.POw) {
        break label384;
      }
    }
    label384:
    for (paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, 180.0F });; paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 0.0F, -180.0F }))
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
          AppMethodBeat.i(310097);
          super.onAnimationStart(paramAnonymousAnimator);
          t.this.ttc = true;
          AppMethodBeat.o(310097);
        }
      });
      this.POu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(310105);
          super.onAnimationEnd(paramAnonymousAnimator);
          t.this.ttc = false;
          if (t.this.POD != null) {
            t.this.POD.gZY();
          }
          AppMethodBeat.o(310105);
        }
      });
      int i = this.POx;
      float f = this.POr.getContext().getResources().getDisplayMetrics().density * i;
      this.POr.setCameraDistance(f);
      if ((this.POs instanceof View)) {
        ((View)this.POs).setCameraDistance(f);
      }
      AppMethodBeat.o(309986);
      return;
      paramView = ObjectAnimator.ofFloat(null, "rotationY", new float[] { 180.0F, 0.0F });
      break;
    }
  }
  
  public final void gZV()
  {
    AppMethodBeat.i(309993);
    if (!this.ttc)
    {
      if (!this.POv)
      {
        this.POt.setTarget(this.POr);
        this.POu.setTarget(this.POs);
        this.POt.start();
        this.POu.start();
        this.POv = true;
        AppMethodBeat.o(309993);
        return;
      }
      this.POt.setTarget(this.POs);
      this.POu.setTarget(this.POr);
      this.POt.start();
      this.POu.start();
      this.POv = false;
    }
    AppMethodBeat.o(309993);
  }
  
  public static abstract interface a
  {
    public abstract void gZY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.t
 * JD-Core Version:    0.7.0.1
 */