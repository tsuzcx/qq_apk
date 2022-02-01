package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int requestType;
  public n ztw;
  public SparseArray<n> ztx;
  
  public e()
  {
    AppMethodBeat.i(95067);
    this.ztx = new SparseArray();
    AppMethodBeat.o(95067);
  }
  
  public e(SparseArray<n> paramSparseArray)
  {
    this.ztx = paramSparseArray;
    this.requestType = 9;
  }
  
  public e(n paramn, int paramInt)
  {
    this.ztw = paramn;
    this.requestType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.e
 * JD-Core Version:    0.7.0.1
 */