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

public final class c
  extends a
{
  public c(Activity paramActivity, View paramView, final boolean paramBoolean)
  {
    super(paramActivity, paramView, paramBoolean);
    AppMethodBeat.i(99895);
    this.KpR = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.KpR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(99892);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        c.this.view.setAlpha(1.0F - f);
        ViewGroup localViewGroup;
        if (f != 1.0F)
        {
          paramAnonymousValueAnimator = (FrameLayout.LayoutParams)c.this.view.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = ((int)(c.this.RHZ * f));
          paramAnonymousValueAnimator.topMargin = ((int)(c.this.RIa * f));
          localViewGroup = (ViewGroup)c.this.view.getParent();
          if (!paramBoolean) {
            break label212;
          }
          paramAnonymousValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() - (c.this.nxO - c.this.RIe * f) - paramAnonymousValueAnimator.leftMargin));
        }
        for (paramAnonymousValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() - (c.this.nxP - c.this.RId * f) - paramAnonymousValueAnimator.topMargin));; paramAnonymousValueAnimator.bottomMargin = ((int)(localViewGroup.getHeight() * f - c.this.RIc * f - paramAnonymousValueAnimator.topMargin)))
        {
          c.this.view.setLayoutParams(paramAnonymousValueAnimator);
          if (c.this.RHY != null) {
            c.this.RHY.dg(f);
          }
          AppMethodBeat.o(99892);
          return;
          label212:
          paramAnonymousValueAnimator.rightMargin = ((int)(localViewGroup.getWidth() * f - c.this.RIb * f - paramAnonymousValueAnimator.leftMargin));
        }
      }
    });
    this.KpR.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99894);
        if (c.this.RHY != null) {
          c.this.RHY.onAnimationEnd();
        }
        if (!paramBoolean) {
          c.this.view.setVisibility(8);
        }
        AppMethodBeat.o(99894);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(99893);
        paramAnonymousAnimator = (FrameLayout.LayoutParams)c.this.view.getLayoutParams();
        paramAnonymousAnimator.leftMargin = c.this.RHZ;
        paramAnonymousAnimator.topMargin = c.this.RIa;
        ViewGroup localViewGroup = (ViewGroup)c.this.view.getParent();
        if (paramBoolean) {
          paramAnonymousAnimator.rightMargin = (localViewGroup.getWidth() - (c.this.nxO - c.this.RIe) - paramAnonymousAnimator.leftMargin);
        }
        for (paramAnonymousAnimator.bottomMargin = (localViewGroup.getHeight() - (c.this.nxP - c.this.RId) - paramAnonymousAnimator.topMargin);; paramAnonymousAnimator.bottomMargin = (localViewGroup.getHeight() - c.this.RIc - paramAnonymousAnimator.topMargin))
        {
          c.this.view.setLayoutParams(paramAnonymousAnimator);
          c.this.view.setVisibility(0);
          if (c.this.RHY != null) {
            c.this.RHY.onAnimationStart();
          }
          AppMethodBeat.o(99893);
          return;
          paramAnonymousAnimator.rightMargin = (localViewGroup.getWidth() - c.this.RIb - paramAnonymousAnimator.leftMargin);
        }
      }
    });
    this.KpR.setDuration(400L);
    AppMethodBeat.o(99895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.c
 * JD-Core Version:    0.7.0.1
 */