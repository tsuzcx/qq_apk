package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class d
{
  final f sX;
  final e sY;
  final List<View> sZ;
  
  d(f paramf)
  {
    this.sX = paramf;
    this.sY = new e();
    this.sZ = new ArrayList();
  }
  
  private void Z(View paramView)
  {
    this.sZ.add(paramView);
    this.sX.ag(paramView);
  }
  
  private boolean aa(View paramView)
  {
    if (this.sZ.remove(paramView))
    {
      this.sX.ah(paramView);
      return true;
    }
    return false;
  }
  
  private int al(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = this.sX.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - this.sY.ao(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!this.sY.get(i)) {
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
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.sX.getChildCount();; paramInt = al(paramInt))
    {
      this.sY.c(paramInt, paramBoolean);
      if (paramBoolean) {
        Z(paramView);
      }
      this.sX.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = this.sX.getChildCount();; paramInt = al(paramInt))
    {
      this.sY.c(paramInt, paramBoolean);
      if (paramBoolean) {
        Z(paramView);
      }
      this.sX.addView(paramView, paramInt);
      return;
    }
  }
  
  final void ab(View paramView)
  {
    a(paramView, -1, true);
  }
  
  final boolean ac(View paramView)
  {
    return this.sZ.contains(paramView);
  }
  
  final void ad(View paramView)
  {
    int i = this.sX.indexOfChild(paramView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(paramView)));
    }
    this.sY.set(i);
    Z(paramView);
  }
  
  final boolean ae(View paramView)
  {
    int i = this.sX.indexOfChild(paramView);
    if (i == -1)
    {
      aa(paramView);
      return true;
    }
    if (this.sY.get(i))
    {
      this.sY.an(i);
      aa(paramView);
      this.sX.removeViewAt(i);
      return true;
    }
    return false;
  }
  
  final View am(int paramInt)
  {
    return this.sX.getChildAt(paramInt);
  }
  
  final void cL()
  {
    for (e locale = this.sY;; locale = locale.tb)
    {
      locale.ta = 0L;
      if (locale.tb == null) {
        break;
      }
    }
    int i = this.sZ.size() - 1;
    while (i >= 0)
    {
      this.sX.ah((View)this.sZ.get(i));
      this.sZ.remove(i);
      i -= 1;
    }
    this.sX.removeAllViews();
  }
  
  final int cM()
  {
    return this.sX.getChildCount();
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = al(paramInt);
    this.sY.an(paramInt);
    this.sX.detachViewFromParent(paramInt);
  }
  
  final View getChildAt(int paramInt)
  {
    paramInt = al(paramInt);
    return this.sX.getChildAt(paramInt);
  }
  
  final int getChildCount()
  {
    return this.sX.getChildCount() - this.sZ.size();
  }
  
  final int indexOfChild(View paramView)
  {
    int i = this.sX.indexOfChild(paramView);
    if (i == -1) {}
    while (this.sY.get(i)) {
      return -1;
    }
    return i - this.sY.ao(i);
  }
  
  final void removeView(View paramView)
  {
    int i = this.sX.indexOfChild(paramView);
    if (i < 0) {
      return;
    }
    if (this.sY.an(i)) {
      aa(paramView);
    }
    this.sX.removeViewAt(i);
  }
  
  final void removeViewAt(int paramInt)
  {
    paramInt = al(paramInt);
    View localView = this.sX.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (this.sY.an(paramInt)) {
      aa(localView);
    }
    this.sX.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return this.sY.toString() + ", hidden list:" + this.sZ.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.d
 * JD-Core Version:    0.7.0.1
 */