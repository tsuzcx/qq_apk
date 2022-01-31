package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.r;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class a
  extends ImageView
{
  private Animation.AnimationListener nm;
  int nn;
  
  a(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.nn = ((int)(3.5F * f));
    if (bV())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      r.d(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      r.a(this, paramContext);
      return;
      paramContext = new ShapeDrawable(new b(this, this.nn));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.nn, j, i, 503316480);
      i = this.nn;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean bV()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.nm != null) {
      this.nm.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.nm != null) {
      this.nm.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!bV()) {
      setMeasuredDimension(getMeasuredWidth() + this.nn * 2, getMeasuredHeight() + this.nn * 2);
    }
  }
  
  public final void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.nm = paramAnimationListener;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.a
 * JD-Core Version:    0.7.0.1
 */