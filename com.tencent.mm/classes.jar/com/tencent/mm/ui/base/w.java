package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  View[] JqE;
  int[] JqF;
  SparseArray<View>[] JqG;
  SparseArray<View> JqH;
  int xmI;
  
  public w()
  {
    AppMethodBeat.i(142451);
    this.JqE = new View[0];
    this.JqF = new int[0];
    AppMethodBeat.o(142451);
  }
  
  static View d(SparseArray<View> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(142452);
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
          AppMethodBeat.o(142452);
          return localView;
        }
        i += 1;
      }
      paramInt = j - 1;
      View localView = (View)paramSparseArray.valueAt(paramInt);
      paramSparseArray.remove(paramSparseArray.keyAt(paramInt));
      AppMethodBeat.o(142452);
      return localView;
    }
    AppMethodBeat.o(142452);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.w
 * JD-Core Version:    0.7.0.1
 */