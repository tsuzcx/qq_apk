package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class az
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final View cZ;
  private ViewTreeObserver hy;
  private final Runnable hz;
  
  private az(View paramView, Runnable paramRunnable)
  {
    this.cZ = paramView;
    this.hy = paramView.getViewTreeObserver();
    this.hz = paramRunnable;
  }
  
  public static az a(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new az(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  private void aS()
  {
    if (this.hy.isAlive()) {
      this.hy.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.cZ.removeOnAttachStateChangeListener(this);
      return;
      this.cZ.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
  
  public final boolean onPreDraw()
  {
    aS();
    this.hz.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.hy = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    aS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.az
 * JD-Core Version:    0.7.0.1
 */