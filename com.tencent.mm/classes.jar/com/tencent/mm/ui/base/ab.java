package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;

public abstract class ab
  extends a
{
  private final aa WpF;
  
  public ab()
  {
    this(new aa());
  }
  
  private ab(aa paramaa)
  {
    this.WpF = paramaa;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramaa.HyH = 1;
    paramaa.WpE = arrayOfSparseArray[0];
    paramaa.WpD = arrayOfSparseArray;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.WpF;
    if (paramViewGroup.HyH == 1) {
      paramViewGroup.WpE.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      paramViewGroup.WpD[0].put(paramInt, paramObject);
    }
  }
  
  public abstract View e(int paramInt, View paramView);
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.WpF;
    if (((aa)localObject).HyH == 1) {
      localObject = aa.d(((aa)localObject).WpE, paramInt);
    }
    for (;;)
    {
      localObject = e(paramInt, (View)localObject);
      paramViewGroup.addView((View)localObject);
      return localObject;
      if (((aa)localObject).WpD.length > 0) {
        localObject = aa.d(localObject.WpD[0], paramInt);
      } else {
        localObject = null;
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    aa localaa = this.WpF;
    View[] arrayOfView = localaa.WpB;
    int[] arrayOfInt = localaa.WpC;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localaa.HyH > 1)
    {
      i = 1;
      localObject1 = localaa.WpE;
      j = arrayOfView.length - 1;
      if (j < 0) {
        break label159;
      }
      localView = arrayOfView[j];
      localObject2 = localObject1;
      if (localView != null)
      {
        m = arrayOfInt[j];
        arrayOfView[j] = null;
        arrayOfInt[j] = -1;
        if (m < 0) {
          break label154;
        }
      }
    }
    label154:
    for (int k = 1;; k = 0)
    {
      localObject2 = localObject1;
      if (k != 0)
      {
        if (i != 0) {
          localObject1 = localaa.WpD[m];
        }
        ((SparseArray)localObject1).put(j, localView);
        localObject2 = localObject1;
        if (Build.VERSION.SDK_INT >= 14)
        {
          localView.setAccessibilityDelegate(null);
          localObject2 = localObject1;
        }
      }
      j -= 1;
      localObject1 = localObject2;
      break label44;
      i = 0;
      break;
    }
    label159:
    int m = localaa.WpB.length;
    int n = localaa.HyH;
    Object localObject1 = localaa.WpD;
    int i = 0;
    while (i < n)
    {
      localObject2 = localObject1[i];
      int i1 = localObject2.size();
      j = i1 - 1;
      k = 0;
      while (k < i1 - m)
      {
        localObject2.remove(localObject2.keyAt(j));
        k += 1;
        j -= 1;
      }
      i += 1;
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.ab
 * JD-Core Version:    0.7.0.1
 */