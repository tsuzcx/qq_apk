package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class d
{
  final f rh;
  final e ri;
  final List<View> rj;
  
  d(f paramf)
  {
    this.rh = paramf;
    this.ri = new e();
    this.rj = new ArrayList();
  }
  
  private void T(View paramView)
  {
    this.rj.add(paramView);
    this.rh.aa(paramView);
  }
  
  private boolean U(View paramView)
  {
    if (this.rj.remove(paramView))
    {
      this.rh.ab(paramView);
      return true;
    }
    return false;
  }
  
  private int aa(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.rh.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.ri.ad(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.ri.get(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  final void V(View paramView)
  {
    a(paramView, -1, true);
  }
  
  final boolean W(View paramView)
  {
    return this.rj.contains(paramView);
  }
  
  final void X(View paramView)
  {
    int i = this.rh.indexOfChild(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + paramView);
    }
    this.ri.set(i);
    T(paramView);
  }
  
  final boolean Y(View paramView)
  {
    int i = this.rh.indexOfChild(paramView);
    if (i == -1)
    {
      U(paramView);
      return true;
    }
    if (this.ri.get(i))
    {
      this.ri.ac(i);
      U(paramView);
      this.rh.removeViewAt(i);
      return true;
    }
    return false;
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.rh.getChildCount();; paramInt = aa(paramInt))
    {
      this.ri.b(paramInt, paramBoolean);
      if (paramBoolean) {
        T(paramView);
      }
      this.rh.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.rh.getChildCount();; paramInt = aa(paramInt))
    {
      this.ri.b(paramInt, paramBoolean);
      if (paramBoolean) {
        T(paramView);
      }
      this.rh.addView(paramView, paramInt);
      return;
    }
  }
  
  final View ab(int paramInt)
  {
    return this.rh.getChildAt(paramInt);
  }
  
  final int cE()
  {
    return this.rh.getChildCount();
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = aa(paramInt);
    this.ri.ac(paramInt);
    this.rh.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = aa(paramInt);
    return this.rh.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.rh.getChildCount() - this.rj.size();
  }
  
  final void removeView(View paramView)
  {
    int i = this.rh.indexOfChild(paramView);
    if (i < 0) {
      return;
    }
    if (this.ri.ac(i)) {
      U(paramView);
    }
    this.rh.removeViewAt(i);
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = aa(paramInt);
    View localView = this.rh.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.ri.ac(paramInt)) {
      U(localView);
    }
    this.rh.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.ri.toString() + ", hidden list:" + this.rj.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.d
 * JD-Core Version:    0.7.0.1
 */