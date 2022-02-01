package com.tencent.mm.view;

import android.animation.Animator;
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
    ViewAnimHelper.ViewInfo localViewInfo = q(paramView1, null);
    final float f1 = Math.max(1.0F * paramViewInfo.QMg.height() / localViewInfo.QMg.height(), 1.0F * paramViewInfo.QMg.width() / localViewInfo.QMg.width());
    final float f2 = paramView1.getScaleX();
    final float f3 = paramView1.getTranslationX();
    final float f4 = paramView1.getScaleY();
    final float f5 = paramView1.getTranslationY();
    final float f6 = paramView2.getAlpha();
    final float f7 = localViewInfo.QMg.centerX();
    final float f8 = localViewInfo.QMg.centerY();
    final float f9 = paramViewInfo.QMg.centerX();
    final float f10 = paramViewInfo.QMg.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new DecelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(143612);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.qlf.setTranslationX(f3 + (f9 - f7) * f);
        this.qlf.setTranslationY(f5 + (f10 - f8) * f);
        this.qlf.setScaleX(f2 + (f1 * f2 - f2) * f);
        this.qlf.setScaleY(f4 + (f1 * f4 - f4) * f);
        paramView2.setAlpha((1.0F - f) * f6);
        if (paramAnimatorUpdateListener != null) {
          paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(143612);
      }
    });
    paramViewInfo.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143615);
        if (this.Rin != null) {
          this.Rin.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143615);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143614);
        if (this.Rin != null) {
          this.Rin.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143614);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143616);
        if (this.Rin != null) {
          this.Rin.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143616);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143613);
        if (this.Rin != null) {
          this.Rin.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143613);
      }
    });
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
    AppMethodBeat.i(206184);
    ViewAnimHelper.ViewInfo localViewInfo = q(paramView1, null);
    final float f1 = Math.max(paramViewInfo.QMg.height() * 1.0F / localViewInfo.QMg.height(), paramViewInfo.QMg.width() * 1.0F / localViewInfo.QMg.width());
    final float f2 = localViewInfo.QMg.centerX();
    final float f3 = localViewInfo.QMg.centerY();
    final float f4 = paramViewInfo.QMg.centerX();
    final float f5 = paramViewInfo.QMg.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new AccelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(164324);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.qlf.setTranslationX((1.0F - f) * (f4 - f2));
        this.qlf.setTranslationY((1.0F - f) * (f5 - f3));
        this.qlf.setScaleX(f1 * (1.0F - f) + f);
        this.qlf.setScaleY(f1 * (1.0F - f) + f);
        paramView2.setAlpha(f);
        if (paramAnimatorUpdateListener != null) {
          paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(164324);
      }
    });
    paramViewInfo.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164327);
        if (this.Rin != null) {
          this.Rin.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164327);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164326);
        if (this.Rin != null) {
          this.Rin.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164326);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164328);
        if (this.Rin != null) {
          this.Rin.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164328);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164325);
        if (this.Rin != null) {
          this.Rin.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164325);
      }
    });
    paramViewInfo.setInterpolator(new LinearInterpolator());
    paramViewInfo.setDuration(240L);
    paramViewInfo.start();
    AppMethodBeat.o(206184);
  }
  
  public static ViewAnimHelper.ViewInfo q(View paramView1, View paramView2)
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