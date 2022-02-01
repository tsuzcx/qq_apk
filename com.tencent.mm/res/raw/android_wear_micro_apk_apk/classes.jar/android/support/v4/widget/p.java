package android.support.v4.widget;

import android.view.View;

final class p
  extends ae
{
  p(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  public final boolean P(View paramView)
  {
    if (this.rx.nq) {
      return false;
    }
    return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).rz;
  }
  
  public final void Q(View paramView)
  {
    this.rx.cs();
  }
  
  public final int R(View paramView)
  {
    return this.rx.rr;
  }
  
  public final int S(View paramView)
  {
    return paramView.getTop();
  }
  
  public final void V(int paramInt)
  {
    if (this.rx.rt.cB() == 0)
    {
      if (this.rx.rp == 0.0F)
      {
        this.rx.V(this.rx.ro);
        this.rx.sendAccessibilityEvent(32);
        this.rx.ru = false;
      }
    }
    else {
      return;
    }
    this.rx.sendAccessibilityEvent(32);
    this.rx.ru = true;
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    this.rx.rt.l(this.rx.ro, paramInt2);
  }
  
  public final void f(View paramView, float paramFloat)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i;
    int j;
    if (this.rx.cu())
    {
      i = this.rx.getPaddingRight();
      j = localLayoutParams.rightMargin + i;
      if (paramFloat >= 0.0F)
      {
        i = j;
        if (paramFloat == 0.0F)
        {
          i = j;
          if (this.rx.rp <= 0.5F) {}
        }
      }
      else
      {
        i = j + this.rx.rr;
      }
      j = this.rx.ro.getWidth();
      i = this.rx.getWidth() - i - j;
    }
    for (;;)
    {
      this.rx.rt.j(i, paramView.getTop());
      this.rx.invalidate();
      return;
      i = this.rx.getPaddingLeft();
      j = localLayoutParams.leftMargin + i;
      if (paramFloat <= 0.0F)
      {
        i = j;
        if (paramFloat == 0.0F)
        {
          i = j;
          if (this.rx.rp <= 0.5F) {}
        }
      }
      else
      {
        i = j + this.rx.rr;
      }
    }
  }
  
  public final void j(View paramView, int paramInt)
  {
    this.rx.ab(paramInt);
    this.rx.invalidate();
  }
  
  public final int k(View paramView, int paramInt)
  {
    paramView = (SlidingPaneLayout.LayoutParams)this.rx.ro.getLayoutParams();
    if (this.rx.cu())
    {
      i = this.rx.getWidth();
      j = this.rx.getPaddingRight();
      i -= paramView.rightMargin + j + this.rx.ro.getWidth();
      j = this.rx.rr;
      return Math.max(Math.min(paramInt, i), i - j);
    }
    int i = this.rx.getPaddingLeft();
    i = paramView.leftMargin + i;
    int j = this.rx.rr;
    return Math.min(Math.max(paramInt, i), j + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.p
 * JD-Core Version:    0.7.0.1
 */