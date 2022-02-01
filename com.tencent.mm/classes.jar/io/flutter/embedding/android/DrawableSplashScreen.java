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
  implements j
{
  private final ImageView.ScaleType SMv;
  private final long SMw;
  private DrawableSplashScreenView SMx;
  private final Drawable drawable;
  
  public DrawableSplashScreen(Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY);
  }
  
  private DrawableSplashScreen(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    this.drawable = paramDrawable;
    this.SMv = paramScaleType;
    this.SMw = 500L;
  }
  
  public final void bc(final Runnable paramRunnable)
  {
    AppMethodBeat.i(10068);
    if (this.SMx == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(10068);
      return;
    }
    this.SMx.animate().alpha(0.0F).setDuration(this.SMw).setListener(new Animator.AnimatorListener()
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
  
  public final View lM(Context paramContext)
  {
    AppMethodBeat.i(10067);
    this.SMx = new DrawableSplashScreenView(paramContext);
    this.SMx.a(this.drawable, this.SMv);
    paramContext = this.SMx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen
 * JD-Core Version:    0.7.0.1
 */