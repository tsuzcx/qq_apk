package com.tencent.mm.ui.base;

import android.os.Build.VERSION;
import android.support.v4.view.n;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class w
  extends n
{
  private final v vbp;
  
  public w()
  {
    this(new v());
  }
  
  private w(v paramv)
  {
    this.vbp = paramv;
    SparseArray[] arrayOfSparseArray = new SparseArray[1];
    int i = 0;
    while (i <= 0)
    {
      arrayOfSparseArray[0] = new SparseArray();
      i += 1;
    }
    paramv.vbn = 1;
    paramv.vbo = arrayOfSparseArray[0];
    paramv.vbm = arrayOfSparseArray;
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    int i = getItemViewType(paramInt);
    if (i != -1)
    {
      paramViewGroup = this.vbp;
      if (paramViewGroup.vbn != 1) {
        break label59;
      }
      paramViewGroup.vbo.put(paramInt, paramObject);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        paramObject.setAccessibilityDelegate(null);
      }
      return;
      label59:
      paramViewGroup.vbm[i].put(paramInt, paramObject);
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = null;
    int i = getItemViewType(paramInt);
    Object localObject1 = localObject2;
    v localv;
    if (i != -1)
    {
      localv = this.vbp;
      if (localv.vbn != 1) {
        break label63;
      }
      localObject1 = v.a(localv.vbo, paramInt);
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
        if (i < localv.vbm.length) {
          localObject1 = v.a(localv.vbm[i], paramInt);
        }
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public void notifyDataSetChanged()
  {
    v localv = this.vbp;
    View[] arrayOfView = localv.vbk;
    int[] arrayOfInt = localv.vbl;
    int j;
    label44:
    View localView;
    Object localObject2;
    if (localv.vbn > 1)
    {
      i = 1;
      localObject1 = localv.vbo;
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
          localObject1 = localv.vbm[m];
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
    int m = localv.vbk.length;
    int n = localv.vbn;
    Object localObject1 = localv.vbm;
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
 * Qualified Name:     com.tencent.mm.ui.base.w
 * JD-Core Version:    0.7.0.1
 */