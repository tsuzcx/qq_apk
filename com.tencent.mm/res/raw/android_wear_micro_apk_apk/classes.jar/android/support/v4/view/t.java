package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;

class t
  extends s
{
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }
  
  public final void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public final void b(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public void f(View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 2;
    }
    paramView.setImportantForAccessibility(i);
  }
  
  public final boolean f(View paramView)
  {
    return paramView.hasTransientState();
  }
  
  public final void g(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public final int h(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public final ViewParent k(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
  
  public final int n(View paramView)
  {
    return paramView.getMinimumWidth();
  }
  
  public final int o(View paramView)
  {
    return paramView.getMinimumHeight();
  }
  
  public void s(View paramView)
  {
    paramView.requestFitSystemWindows();
  }
  
  public final boolean t(View paramView)
  {
    return paramView.getFitsSystemWindows();
  }
  
  public final boolean u(View paramView)
  {
    return paramView.hasOverlappingRendering();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.t
 * JD-Core Version:    0.7.0.1
 */