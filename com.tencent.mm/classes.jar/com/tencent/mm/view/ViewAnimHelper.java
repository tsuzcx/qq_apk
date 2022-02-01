package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ViewAnimHelper
{
  public static void a(View paramView1, final View paramView2, ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(143624);
    ViewInfo localViewInfo = q(paramView1, null);
    final float f1 = Math.max(1.0F * paramViewInfo.YkY.height() / localViewInfo.YkY.height(), 1.0F * paramViewInfo.YkY.width() / localViewInfo.YkY.width());
    final float f2 = paramView1.getScaleX();
    final float f3 = paramView1.getTranslationX();
    final float f4 = paramView1.getScaleY();
    final float f5 = paramView1.getTranslationY();
    final float f6 = paramView2.getAlpha();
    final float f7 = localViewInfo.YkY.centerX();
    final float f8 = localViewInfo.YkY.centerY();
    final float f9 = paramViewInfo.YkY.centerX();
    final float f10 = paramViewInfo.YkY.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new DecelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(143612);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.tHb.setTranslationX(f3 + (f9 - f7) * f);
        this.tHb.setTranslationY(f5 + (f10 - f8) * f);
        this.tHb.setScaleX(f2 + (f1 * f2 - f2) * f);
        this.tHb.setScaleY(f4 + (f1 * f4 - f4) * f);
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
        if (this.YJU != null) {
          this.YJU.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143615);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143614);
        if (this.YJU != null) {
          this.YJU.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143614);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143616);
        if (this.YJU != null) {
          this.YJU.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(143616);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143613);
        if (this.YJU != null) {
          this.YJU.onAnimationStart(paramAnonymousAnimator);
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
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect1.left = arrayOfInt[0];
    paramRect1.right = (paramRect1.left + paramView.getWidth());
    paramRect1.top = arrayOfInt[1];
    paramRect1.bottom = (paramRect1.top + paramView.getHeight());
    if ((!paramRect2.isEmpty()) && (paramRect1.bottom - paramView.getHeight() < paramRect2.top)) {
      paramRect1.top = (paramRect1.bottom - paramView.getHeight());
    }
    AppMethodBeat.o(143622);
  }
  
  public static void c(View paramView1, final View paramView2, ViewInfo paramViewInfo, Animator.AnimatorListener paramAnimatorListener, final ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    AppMethodBeat.i(203793);
    ViewInfo localViewInfo = q(paramView1, null);
    final float f1 = Math.max(paramViewInfo.YkY.height() * 1.0F / localViewInfo.YkY.height(), paramViewInfo.YkY.width() * 1.0F / localViewInfo.YkY.width());
    final float f2 = localViewInfo.YkY.centerX();
    final float f3 = localViewInfo.YkY.centerY();
    final float f4 = paramViewInfo.YkY.centerX();
    final float f5 = paramViewInfo.YkY.centerY();
    paramViewInfo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramViewInfo.setInterpolator(new AccelerateInterpolator(1.2F));
    paramViewInfo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(164324);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.tHb.setTranslationX((1.0F - f) * (f4 - f2));
        this.tHb.setTranslationY((1.0F - f) * (f5 - f3));
        this.tHb.setScaleX(f1 * (1.0F - f) + f);
        this.tHb.setScaleY(f1 * (1.0F - f) + f);
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
        if (this.YJU != null) {
          this.YJU.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164327);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164326);
        if (this.YJU != null) {
          this.YJU.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164326);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164328);
        if (this.YJU != null) {
          this.YJU.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164328);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(164325);
        if (this.YJU != null) {
          this.YJU.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(164325);
      }
    });
    paramViewInfo.setInterpolator(new LinearInterpolator());
    paramViewInfo.setDuration(240L);
    paramViewInfo.start();
    AppMethodBeat.o(203793);
  }
  
  public static ViewInfo q(View paramView1, View paramView2)
  {
    AppMethodBeat.i(143623);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    if (paramView2 != null) {
      paramView2.getGlobalVisibleRect(localRect2);
    }
    b(paramView1, localRect1, localRect2);
    paramView1 = new ViewInfo(localRect1);
    AppMethodBeat.o(143623);
    return paramView1;
  }
  
  public static class ViewInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<ViewInfo> CREATOR;
    public Rect YkY;
    
    static
    {
      AppMethodBeat.i(143621);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(143621);
    }
    
    public ViewInfo(Rect paramRect)
    {
      AppMethodBeat.i(143618);
      this.YkY = new Rect();
      this.YkY.set(paramRect);
      AppMethodBeat.o(143618);
    }
    
    protected ViewInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(143620);
      this.YkY = new Rect();
      this.YkY = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      AppMethodBeat.o(143620);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(143619);
      paramParcel.writeParcelable(this.YkY, paramInt);
      AppMethodBeat.o(143619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ViewAnimHelper
 * JD-Core Version:    0.7.0.1
 */