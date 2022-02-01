package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int requestType;
  public m wAv;
  public SparseArray<m> wAw;
  
  public d()
  {
    AppMethodBeat.i(95067);
    this.wAw = new SparseArray();
    AppMethodBeat.o(95067);
  }
  
  public d(SparseArray<m> paramSparseArray)
  {
    this.wAw = paramSparseArray;
    this.requestType = 9;
  }
  
  public d(m paramm, int paramInt)
  {
    this.wAv = paramm;
    this.requestType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.d
 * JD-Core Version:    0.7.0.1
 */