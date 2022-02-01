package io.flutter.embedding.android;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DrawableSplashScreen
  implements h
{
  private final ImageView.ScaleType MYi;
  private final long MYj;
  private DrawableSplashScreenView MYk;
  private final Drawable drawable;
  
  public DrawableSplashScreen(Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY);
  }
  
  private DrawableSplashScreen(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    this.drawable = paramDrawable;
    this.MYi = paramScaleType;
    this.MYj = 500L;
  }
  
  public final void aS(final Runnable paramRunnable)
  {
    AppMethodBeat.i(10068);
    if (this.MYk == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(10068);
      return;
    }
    this.MYk.animate().alpha(0.0F).setDuration(this.MYj).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(10027);
        paramRunnable.run();
        AppMethodBeat.o(10027);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(10026);
        paramRunnable.run();
        AppMethodBeat.o(10026);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(10068);
  }
  
  public final View lN(Context paramContext)
  {
    AppMethodBeat.i(10067);
    this.MYk = new DrawableSplashScreenView(paramContext);
    this.MYk.a(this.drawable, this.MYi);
    paramContext = this.MYk;
    AppMethodBeat.o(10067);
    return paramContext;
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
    
    public final void a(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
    {
      AppMethodBeat.i(10070);
      setScaleType(paramScaleType);
      setImageDrawable(paramDrawable);
      AppMethodBeat.o(10070);
    }
    
    public void setSplashDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(10069);
      a(paramDrawable, ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(10069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen
 * JD-Core Version:    0.7.0.1
 */