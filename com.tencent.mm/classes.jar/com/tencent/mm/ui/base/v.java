package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;

public final class v
{
  View[] vbk = new View[0];
  int[] vbl = new int[0];
  SparseArray<View>[] vbm;
  int vbn;
  SparseArray<View> vbo;
  
  static View a(SparseArray<View> paramSparseArray, int paramInt)
  {
    int j = paramSparseArray.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        localView = (View)paramSparseArray.get(k);
        if (k == paramInt)
        {
          paramSparseArray.remove(k);
          return localView;
        }
        i += 1;
      }
      paramInt = j - 1;
      View localView = (View)paramSparseArray.valueAt(paramInt);
      paramSparseArray.remove(paramSparseArray.keyAt(paramInt));
      return localView;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.v
 * JD-Core Version:    0.7.0.1
 */