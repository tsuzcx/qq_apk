package android.support.v4.widget;

import android.view.View;

final class o
  extends ad
{
  o(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  public final boolean J(View paramView)
  {
    if (this.pH.lu) {
      return false;
    }
    return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).pJ;
  }
  
  public final void K(int paramInt)
  {
    if (this.pH.pD.cu() == 0)
    {
      if (this.pH.pz == 0.0F)
      {
        this.pH.P(this.pH.py);
        localSlidingPaneLayout = this.pH;
        localView = this.pH.py;
        localSlidingPaneLayout.sendAccessibilityEvent(32);
        this.pH.pE = false;
      }
    }
    else {
      return;
    }
    SlidingPaneLayout localSlidingPaneLayout = this.pH;
    View localView = this.pH.py;
    localSlidingPaneLayout.sendAccessibilityEvent(32);
    this.pH.pE = true;
  }
  
  public final void K(View paramView)
  {
    this.pH.co();
  }
  
  public final int L(View paramView)
  {
    return this.pH.pB;
  }
  
  public final int M(View paramView)
  {
    return paramView.getTop();
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    this.pH.pD.i(this.pH.py, paramInt2);
  }
  
  public final void f(View paramView, float paramFloat)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    int j;
    if (this.pH.cq())
    {
      i = this.pH.getPaddingRight();
      j = localLayoutParams.rightMargin + i;
      if (paramFloat >= 0.0F)
      {
        i = j;
        if (paramFloat == 0.0F)
        {
          i = j;
          if (this.pH.pz <= 0.5F) {}
        }
      }
      else
      {
        i = j + this.pH.pB;
      }
      j = this.pH.py.getWidth();
      i = this.pH.getWidth() - i - j;
    }
    for (;;)
    {
      this.pH.pD.i(i, paramView.getTop());
      this.pH.invalidate();
      return;
      i = this.pH.getPaddingLeft();
      j = localLayoutParams.leftMargin + i;
      if (paramFloat <= 0.0F)
      {
        i = j;
        if (paramFloat == 0.0F)
        {
          i = j;
          if (this.pH.pz <= 0.5F) {}
        }
      }
      else
      {
        i = j + this.pH.pB;
      }
    }
  }
  
  public final void g(View paramView, int paramInt)
  {
    this.pH.Q(paramInt);
    this.pH.invalidate();
  }
  
  public final int h(View paramView, int paramInt)
  {
    paramView = (SlidingPaneLayout.LayoutParams)this.pH.py.getLayoutParams();
    if (this.pH.cq())
    {
      i = this.pH.getWidth();
      j = this.pH.getPaddingRight();
      i -= paramView.rightMargin + j + this.pH.py.getWidth();
      j = this.pH.pB;
      return Math.max(Math.min(paramInt, i), i - j);
    }
    int i = this.pH.getPaddingLeft();
    i = paramView.leftMargin + i;
    int j = this.pH.pB;
    return Math.min(Math.max(paramInt, i), j + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.o
 * JD-Core Version:    0.7.0.1
 */