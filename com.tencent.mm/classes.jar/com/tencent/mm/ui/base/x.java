package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class x
  extends q
{
  private final w Gde;
  
  public x()
  {
    this(new w());
  }
  
  private x(w paramw)
  {
    this.Gde = paramw;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramw.uWk = 1;
    paramw.Gdd = arrayOfSparseArray[0];
    paramw.Gdc = arrayOfSparseArray;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.Gde;
    if (paramViewGroup.uWk == 1) {
      paramViewGroup.Gdd.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      paramViewGroup.Gdc[0].put(paramInt, paramObject);
    }
  }
  
  public abstract View e(int paramInt, View paramView);
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.Gde;
    if (((w)localObject).uWk == 1) {
      localObject = w.c(((w)localObject).Gdd, paramInt);
    }
    for (;;)
    {
      localObject = e(paramInt, (View)localObject);
      paramViewGroup.addView((View)localObject);
      return localObject;
      if (((w)localObject).Gdc.length > 0) {
        localObject = w.c(localObject.Gdc[0], paramInt);
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
    w localw = this.Gde;
    View[] arrayOfView = localw.Gda;
    int[] arrayOfInt = localw.Gdb;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localw.uWk > 1)
    {
      i = 1;
      localObject1 = localw.Gdd;
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
          localObject1 = localw.Gdc[m];
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
    int m = localw.Gda.length;
    int n = localw.uWk;
    Object localObject1 = localw.Gdc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.x
 * JD-Core Version:    0.7.0.1
 */