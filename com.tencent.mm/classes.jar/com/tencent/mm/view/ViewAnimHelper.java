package com.tencent.mm.view;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ViewAnimHelper
{
  public static void a(View paramView1, final View paramView2, ViewAnimHelper.ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(143624);
    ViewAnimHelper.ViewInfo localViewInfo = o(paramView1, null);
    final float f1 = Math.max(1.0F * paramViewInfo.Lro.height() / localViewInfo.Lro.height(), 1.0F * paramViewInfo.Lro.width() / localViewInfo.Lro.width());
    final float f2 = paramView1.getScaleX();
    final float f3 = paramView1.getTranslationX();
    final float f4 = paramView1.getScaleY();
    final float f5 = paramView1.getTranslationY();
    final float f6 = paramView2.getAlpha();
    final float f7 = localViewInfo.Lro.centerX();
    final float f8 = localViewInfo.Lro.centerY();
    final float f9 = paramViewInfo.Lro.centerX();
    final float f10 = paramViewInfo.Lro.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new DecelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(143612);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.oWl.setTranslationX(f3 + (f9 - f7) * f);
        this.oWl.setTranslationY(f5 + (f10 - f8) * f);
        this.oWl.setScaleX(f2 + (f1 * f2 - f2) * f);
        this.oWl.setScaleY(f4 + (f1 * f4 - f4) * f);
        paramView2.setAlpha((1.0F - f) * f6);
        if (paramAnimatorUpdateListener != null) {
          paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(143612);
      }
    });
    paramViewInfo.addListener(new ViewAnimHelper.4(paramAnimatorListener));
    paramViewInfo.setInterpolator(new LinearInterpolator());
    paramViewInfo.setDuration(240L);
    paramViewInfo.start();
    AppMethodBeat.o(143624);
  }
  
  private static void b(View paramView, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(143622);
    paramView.getGlobalVisibleRect(paramRect1);
    if ((!paramRect2.isEmpty()) && (paramRect1.bottom - paramView.getHeight() < paramRect2.top)) {
      paramRect1.top = (paramRect1.bottom - paramView.getHeight());
    }
    AppMethodBeat.o(143622);
  }
  
  public static void c(View paramView1, final View paramView2, ViewAnimHelper.ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(193822);
    ViewAnimHelper.ViewInfo localViewInfo = o(paramView1, null);
    final float f1 = Math.max(paramViewInfo.Lro.height() * 1.0F / localViewInfo.Lro.height(), paramViewInfo.Lro.width() * 1.0F / localViewInfo.Lro.width());
    final float f2 = localViewInfo.Lro.centerX();
    final float f3 = localViewInfo.Lro.centerY();
    final float f4 = paramViewInfo.Lro.centerX();
    final float f5 = paramViewInfo.Lro.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new AccelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(164324);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.oWl.setTranslationX((1.0F - f) * (f4 - f2));
        this.oWl.setTranslationY((1.0F - f) * (f5 - f3));
        this.oWl.setScaleX(f1 * (1.0F - f) + f);
        this.oWl.setScaleY(f1 * (1.0F - f) + f);
        paramView2.setAlpha(f);
        if (paramAnimatorUpdateListener != null) {
          paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(164324);
      }
    });
    paramViewInfo.addListener(new ViewAnimHelper.2(paramAnimatorListener));
    paramViewInfo.setInterpolator(new LinearInterpolator());
    paramViewInfo.setDuration(240L);
    paramViewInfo.start();
    AppMethodBeat.o(193822);
  }
  
  public static ViewAnimHelper.ViewInfo o(View paramView1, View paramView2)
  {
    AppMethodBeat.i(143623);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    if (paramView2 != null) {
      paramView2.getGlobalVisibleRect(localRect2);
    }
    b(paramView1, localRect1, localRect2);
    paramView1 = new ViewAnimHelper.ViewInfo(localRect1);
    AppMethodBeat.o(143623);
    return paramView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.ViewAnimHelper
 * JD-Core Version:    0.7.0.1
 */