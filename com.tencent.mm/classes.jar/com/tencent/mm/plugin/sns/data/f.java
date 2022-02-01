package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public n DDH;
  public SparseArray<n> DDI;
  public int requestType;
  
  public f()
  {
    AppMethodBeat.i(95067);
    this.DDI = new SparseArray();
    AppMethodBeat.o(95067);
  }
  
  public f(SparseArray<n> paramSparseArray)
  {
    this.DDI = paramSparseArray;
    this.requestType = 9;
  }
  
  public f(n paramn, int paramInt)
  {
    this.DDH = paramn;
    this.requestType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.f
 * JD-Core Version:    0.7.0.1
 */