package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DrawableSplashScreen
  implements f
{
  private final ImageView.ScaleType IXe;
  private final long IXf;
  private DrawableSplashScreenView IXg;
  private final Drawable drawable;
  
  public DrawableSplashScreen(Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY);
  }
  
  private DrawableSplashScreen(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    this.drawable = paramDrawable;
    this.IXe = paramScaleType;
    this.IXf = 500L;
  }
  
  public final void aT(Runnable paramRunnable)
  {
    AppMethodBeat.i(10068);
    if (this.IXg == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(10068);
      return;
    }
    this.IXg.animate().alpha(0.0F).setDuration(this.IXf).setListener(new DrawableSplashScreen.1(this, paramRunnable));
    AppMethodBeat.o(10068);
  }
  
  public final View lh(Context paramContext)
  {
    AppMethodBeat.i(10067);
    this.IXg = new DrawableSplashScreenView(paramContext);
    this.IXg.a(this.drawable, this.IXe);
    paramContext = this.IXg;
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