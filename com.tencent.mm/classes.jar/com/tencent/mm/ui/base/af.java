package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;

public abstract class af
  extends a
{
  private final ae adWT;
  
  public af()
  {
    this(new ae());
  }
  
  private af(ae paramae)
  {
    this.adWT = paramae;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramae.Nwm = 1;
    paramae.adWS = arrayOfSparseArray[0];
    paramae.adWR = arrayOfSparseArray;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.adWT;
    if (paramViewGroup.Nwm == 1) {
      paramViewGroup.adWS.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      paramViewGroup.adWR[0].put(paramInt, paramObject);
    }
  }
  
  public abstract View g(int paramInt, View paramView);
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.adWT;
    if (((ae)localObject).Nwm == 1) {
      localObject = ae.e(((ae)localObject).adWS, paramInt);
    }
    for (;;)
    {
      localObject = g(paramInt, (View)localObject);
      paramViewGroup.addView((View)localObject);
      return localObject;
      if (((ae)localObject).adWR.length > 0) {
        localObject = ae.e(localObject.adWR[0], paramInt);
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
    ae localae = this.adWT;
    View[] arrayOfView = localae.adWP;
    int[] arrayOfInt = localae.adWQ;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localae.Nwm > 1)
    {
      i = 1;
      localObject1 = localae.adWS;
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
          localObject1 = localae.adWR[m];
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
    int m = localae.adWP.length;
    int n = localae.Nwm;
    Object localObject1 = localae.adWR;
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
 * Qualified Name:     com.tencent.mm.ui.base.af
 * JD-Core Version:    0.7.0.1
 */