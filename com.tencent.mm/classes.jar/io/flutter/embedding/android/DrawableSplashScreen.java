package io.flutter.embedding.android;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DrawableSplashScreen
  implements SplashScreen
{
  private final long crossfadeDurationInMillis;
  private final Drawable drawable;
  private final ImageView.ScaleType scaleType;
  private DrawableSplashScreenView splashView;
  
  public DrawableSplashScreen(Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY, 500L);
  }
  
  public DrawableSplashScreen(Drawable paramDrawable, ImageView.ScaleType paramScaleType, long paramLong)
  {
    this.drawable = paramDrawable;
    this.scaleType = paramScaleType;
    this.crossfadeDurationInMillis = paramLong;
  }
  
  public final View createSplashView(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(190354);
    this.splashView = new DrawableSplashScreenView(paramContext);
    this.splashView.setSplashDrawable(this.drawable, this.scaleType);
    paramContext = this.splashView;
    AppMethodBeat.o(190354);
    return paramContext;
  }
  
  public final boolean doesSplashViewRememberItsTransition()
  {
    return false;
  }
  
  public final Bundle saveSplashScreenState()
  {
    return null;
  }
  
  public final void transitionToFlutter(final Runnable paramRunnable)
  {
    AppMethodBeat.i(10068);
    if (this.splashView == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(10068);
      return;
    }
    this.splashView.animate().alpha(0.0F).setDuration(this.crossfadeDurationInMillis).setListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(10027);
        paramRunnable.run();
        AppMethodBeat.o(10027);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(10026);
        paramRunnable.run();
        AppMethodBeat.o(10026);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(10068);
  }
  
  public static class DrawableSplashScreenView
    extends ImageView
  {
    public DrawableSplashScreenView(Context paramContext)
    {
      this(paramContext, null, 0);
    }
    
    public DrawableSplashScreenView(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 0);
    }
    
    public DrawableSplashScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public void setSplashDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(10069);
      setSplashDrawable(paramDrawable, ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(10069);
    }
    
    public void setSplashDrawable(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(10070);
      setScaleType(paramScaleType);
      setImageDrawable(paramDrawable);
      AppMethodBeat.o(10070);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen
 * JD-Core Version:    0.7.0.1
 */