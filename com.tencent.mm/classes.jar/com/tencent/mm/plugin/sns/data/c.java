package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public e rbc;
  public SparseArray<e> rbd;
  public int requestType;
  
  public c()
  {
    AppMethodBeat.i(35787);
    this.rbd = new SparseArray();
    AppMethodBeat.o(35787);
  }
  
  public c(SparseArray<e> paramSparseArray)
  {
    this.rbd = paramSparseArray;
    this.requestType = 9;
  }
  
  public c(e parame, int paramInt)
  {
    this.rbc = parame;
    this.requestType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.c
 * JD-Core Version:    0.7.0.1
 */