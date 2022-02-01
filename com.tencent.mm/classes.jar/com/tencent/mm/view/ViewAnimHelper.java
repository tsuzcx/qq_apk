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
import com.tencent.mm.sdk.platformtools.Log;

public final class ViewAnimHelper
{
  public static void a(View paramView1, final View paramView2, ViewAnimHelper.ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(143624);
    ViewAnimHelper.ViewInfo localViewInfo = z(paramView1, null);
    final float f1 = Math.max(1.0F * paramViewInfo.agcX.height() / localViewInfo.agcX.height(), 1.0F * paramViewInfo.agcX.width() / localViewInfo.agcX.width());
    final float f2 = paramView1.getScaleX();
    final float f3 = paramView1.getTranslationX();
    final float f4 = paramView1.getScaleY();
    final float f5 = paramView1.getTranslationY();
    final float f6 = paramView2.getAlpha();
    final float f7 = localViewInfo.agcX.centerX();
    final float f8 = localViewInfo.agcX.centerY();
    final float f9 = paramViewInfo.agcX.centerX();
    final float f10 = paramViewInfo.agcX.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new DecelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(143612);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ViewAnimHelper.this.setTranslationX(f3 + (f9 - f7) * f);
        ViewAnimHelper.this.setTranslationY(f5 + (f10 - f8) * f);
        ViewAnimHelper.this.setScaleX(f2 + (f1 * f2 - f2) * f);
        ViewAnimHelper.this.setScaleY(f4 + (f1 * f4 - f4) * f);
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
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143615);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143614);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143614);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143616);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143616);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143613);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationStart(paramAnonymousAnimator);
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
    String str = "getGlobalVisibleRect";
    Object localObject = str;
    if (paramView.getWidth() > 0)
    {
      localObject = str;
      if (paramView.getHeight() > 0)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        paramRect1.left = localObject[0];
        paramRect1.top = localObject[1];
        paramRect1.right = (paramRect1.left + paramView.getWidth());
        paramRect1.bottom = (paramRect1.top + paramView.getHeight());
        localObject = "getLocationOnScreen";
      }
    }
    Log.i("ViewAnimHelper", (String)localObject + " left=" + paramRect1.left + " right=" + paramRect1.right + " top=" + paramRect1.top + " bottom=" + paramRect1.bottom);
    if ((!paramRect2.isEmpty()) && (paramRect1.bottom - paramView.getHeight() < paramRect2.top)) {
      paramRect1.top = (paramRect1.bottom - paramView.getHeight());
    }
    AppMethodBeat.o(143622);
  }
  
  public static void c(View paramView1, final View paramView2, ViewAnimHelper.ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(234639);
    ViewAnimHelper.ViewInfo localViewInfo = z(paramView1, null);
    final float f1 = Math.max(paramViewInfo.agcX.height() * 1.0F / localViewInfo.agcX.height(), paramViewInfo.agcX.width() * 1.0F / localViewInfo.agcX.width());
    final float f2 = localViewInfo.agcX.centerX();
    final float f3 = localViewInfo.agcX.centerY();
    final float f4 = paramViewInfo.agcX.centerX();
    final float f5 = paramViewInfo.agcX.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new AccelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(164324);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ViewAnimHelper.this.setTranslationX((1.0F - f1) * (f4 - f2));
        ViewAnimHelper.this.setTranslationY((1.0F - f1) * (f5 - f3));
        float f2 = f1 * (1.0F - f1) + f1;
        if (f2 > 0.0F) {}
        try
        {
          ViewAnimHelper.this.setScaleX(f2);
          ViewAnimHelper.this.setScaleY(f2);
          label89:
          paramView2.setAlpha(f1);
          if (paramAnimatorUpdateListener != null) {
            paramAnimatorUpdateListener.onAnimationUpdate(paramAnonymousValueAnimator);
          }
          AppMethodBeat.o(164324);
          return;
        }
        finally
        {
          break label89;
        }
      }
    });
    paramViewInfo.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164327);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164327);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164326);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164326);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164328);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164328);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164325);
        if (ViewAnimHelper.this != null) {
          ViewAnimHelper.this.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164325);
      }
    });
    paramViewInfo.setInterpolator(new LinearInterpolator());
    paramViewInfo.setDuration(240L);
    paramViewInfo.start();
    AppMethodBeat.o(234639);
  }
  
  public static ViewAnimHelper.ViewInfo z(View paramView1, View paramView2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.ViewAnimHelper
 * JD-Core Version:    0.7.0.1
 */