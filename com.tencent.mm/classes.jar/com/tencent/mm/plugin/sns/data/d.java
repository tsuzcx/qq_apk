package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int requestType;
  public m xMO;
  public SparseArray<m> xMP;
  
  public d()
  {
    AppMethodBeat.i(95067);
    this.xMP = new SparseArray();
    AppMethodBeat.o(95067);
  }
  
  public d(SparseArray<m> paramSparseArray)
  {
    this.xMP = paramSparseArray;
    this.requestType = 9;
  }
  
  public d(m paramm, int paramInt)
  {
    this.xMO = paramm;
    this.requestType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.d
 * JD-Core Version:    0.7.0.1
 */