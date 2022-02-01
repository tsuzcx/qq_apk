package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public p JQm;
  public SparseArray<p> JQn;
  public int requestType;
  
  public h()
  {
    AppMethodBeat.i(95067);
    this.JQn = new SparseArray();
    AppMethodBeat.o(95067);
  }
  
  public h(SparseArray<p> paramSparseArray)
  {
    this.JQn = paramSparseArray;
    this.requestType = 9;
  }
  
  public h(p paramp, int paramInt)
  {
    this.JQm = paramp;
    this.requestType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.h
 * JD-Core Version:    0.7.0.1
 */