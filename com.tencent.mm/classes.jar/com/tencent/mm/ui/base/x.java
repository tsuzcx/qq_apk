package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class x
  extends q
{
  private final w zpF;
  
  public x()
  {
    this(new w());
  }
  
  private x(w paramw)
  {
    this.zpF = paramw;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramw.zpD = 1;
    paramw.zpE = arrayOfSparseArray[0];
    paramw.zpC = arrayOfSparseArray;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    int i = getItemViewType(paramInt);
    if (i != -1)
    {
      paramViewGroup = this.zpF;
      if (paramViewGroup.zpD != 1) {
        break label59;
      }
      paramViewGroup.zpE.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      label59:
      paramViewGroup.zpC[i].put(paramInt, paramObject);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = null;
    int i = getItemViewType(paramInt);
    Object localObject1 = localObject2;
    w localw;
    if (i != -1)
    {
      localw = this.zpF;
      if (localw.zpD != 1) {
        break label63;
      }
      localObject1 = w.a(localw.zpE, paramInt);
    }
    for (;;)
    {
      localObject1 = getView(paramInt, (View)localObject1, paramViewGroup);
      paramViewGroup.addView((View)localObject1);
      return localObject1;
      label63:
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < localw.zpC.length) {
          localObject1 = w.a(localw.zpC[i], paramInt);
        }
      }
    }
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    w localw = this.zpF;
    View[] arrayOfView = localw.zpA;
    int[] arrayOfInt = localw.zpB;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localw.zpD > 1)
    {
      i = 1;
      localObject1 = localw.zpE;
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
          localObject1 = localw.zpC[m];
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
    int m = localw.zpA.length;
    int n = localw.zpD;
    Object localObject1 = localw.zpC;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.x
 * JD-Core Version:    0.7.0.1
 */