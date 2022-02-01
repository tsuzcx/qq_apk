package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class z
  extends q
{
  private final y OWt;
  
  public z()
  {
    this(new y());
  }
  
  private z(y paramy)
  {
    this.OWt = paramy;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramy.BCE = 1;
    paramy.OWs = arrayOfSparseArray[0];
    paramy.OWr = arrayOfSparseArray;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.OWt;
    if (paramViewGroup.BCE == 1) {
      paramViewGroup.OWs.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      paramViewGroup.OWr[0].put(paramInt, paramObject);
    }
  }
  
  public abstract View e(int paramInt, View paramView);
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.OWt;
    if (((y)localObject).BCE == 1) {
      localObject = y.d(((y)localObject).OWs, paramInt);
    }
    for (;;)
    {
      localObject = e(paramInt, (View)localObject);
      paramViewGroup.addView((View)localObject);
      return localObject;
      if (((y)localObject).OWr.length > 0) {
        localObject = y.d(localObject.OWr[0], paramInt);
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
    y localy = this.OWt;
    View[] arrayOfView = localy.OWp;
    int[] arrayOfInt = localy.OWq;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localy.BCE > 1)
    {
      i = 1;
      localObject1 = localy.OWs;
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
          localObject1 = localy.OWr[m];
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
    int m = localy.OWp.length;
    int n = localy.BCE;
    Object localObject1 = localy.OWr;
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
 * Qualified Name:     com.tencent.mm.ui.base.z
 * JD-Core Version:    0.7.0.1
 */