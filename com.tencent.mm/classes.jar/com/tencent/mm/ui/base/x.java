package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class x
  extends q
{
  private final w JqI;
  
  public x()
  {
    this(new w());
  }
  
  private x(w paramw)
  {
    this.JqI = paramw;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramw.xmI = 1;
    paramw.JqH = arrayOfSparseArray[0];
    paramw.JqG = arrayOfSparseArray;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.JqI;
    if (paramViewGroup.xmI == 1) {
      paramViewGroup.JqH.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      paramViewGroup.JqG[0].put(paramInt, paramObject);
    }
  }
  
  public abstract View e(int paramInt, View paramView);
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.JqI;
    if (((w)localObject).xmI == 1) {
      localObject = w.d(((w)localObject).JqH, paramInt);
    }
    for (;;)
    {
      localObject = e(paramInt, (View)localObject);
      paramViewGroup.addView((View)localObject);
      return localObject;
      if (((w)localObject).JqG.length > 0) {
        localObject = w.d(localObject.JqG[0], paramInt);
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
    w localw = this.JqI;
    View[] arrayOfView = localw.JqE;
    int[] arrayOfInt = localw.JqF;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localw.xmI > 1)
    {
      i = 1;
      localObject1 = localw.JqH;
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
          localObject1 = localw.JqG[m];
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
    int m = localw.JqE.length;
    int n = localw.xmI;
    Object localObject1 = localw.JqG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.x
 * JD-Core Version:    0.7.0.1
 */