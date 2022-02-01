package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  public d(Activity paramActivity, View paramView, final boolean paramBoolean)
  {
    super(paramActivity, paramView, paramBoolean);
    AppMethodBeat.i(99899);
    this.tbV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tbV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99896);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ViewGroup localViewGroup;
        if (paramBoolean)
        {
          d.this.view.setAlpha(1.0F - 0.2F * f);
          if (f != 0.0F)
          {
            paramAnonymousValueAnimator = (FrameLayout.LayoutParams)d.this.view.getLayoutParams();
            paramAnonymousValueAnimator.leftMargin = ((int)(d.this.xNV * f));
            paramAnonymousValueAnimator.topMargin = ((int)(d.this.xNW * f));
            localViewGroup = (ViewGroup)d.this.view.getParent();
            if (!paramBoolean) {
              break label238;
            }
            paramAnonymousValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() - (d.this.gnh - d.this.xOa * f) - paramAnonymousValueAnimator.leftMargin));
          }
        }
        for (paramAnonymousValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() - (d.this.gni - d.this.xNZ * f) - paramAnonymousValueAnimator.topMargin));; paramAnonymousValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() * f - d.this.xNY * f - paramAnonymousValueAnimator.topMargin)))
        {
          d.this.view.setLayoutParams(paramAnonymousValueAnimator);
          if (d.this.xNU != null) {
            d.this.xNU.bu(f);
          }
          AppMethodBeat.o(99896);
          return;
          d.this.view.setAlpha(1.0F - f);
          break;
          label238:
          paramAnonymousValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() * f - d.this.xNX * f - paramAnonymousValueAnimator.leftMargin));
        }
      }
    });
    this.tbV.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99898);
        if (d.this.xNU != null) {
          d.this.xNU.onAnimationEnd();
        }
        d.this.view.setVisibility(8);
        AppMethodBeat.o(99898);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99897);
        if (d.this.xNU != null) {
          d.this.xNU.onAnimationStart();
        }
        d.this.view.setVisibility(0);
        AppMethodBeat.o(99897);
      }
    });
    if (paramBoolean)
    {
      this.tbV.setDuration(300L);
      AppMethodBeat.o(99899);
      return;
    }
    this.tbV.setDuration(400L);
    AppMethodBeat.o(99899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.d
 * JD-Core Version:    0.7.0.1
 */