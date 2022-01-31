package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class bs
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final View bo;
  private final Runnable fA;
  private ViewTreeObserver fz;
  
  private bs(View paramView, Runnable paramRunnable)
  {
    this.bo = paramView;
    this.fz = paramView.getViewTreeObserver();
    this.fA = paramRunnable;
  }
  
  public static bs a(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new bs(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  private void aC()
  {
    if (this.fz.isAlive()) {
      this.fz.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.bo.removeOnAttachStateChangeListener(this);
      return;
      this.bo.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
  
  public final boolean onPreDraw()
  {
    aC();
    this.fA.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.fz = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    aC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.bs
 * JD-Core Version:    0.7.0.1
 */