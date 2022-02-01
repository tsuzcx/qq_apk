package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.storage.bc;

public final class n
{
  public String dpC;
  public bpi dyS;
  public String key;
  public int requestType;
  public int size;
  public String wBe;
  public String wBf;
  public bc wBg;
  public SparseArray<bpi> wBh;
  
  public n()
  {
    AppMethodBeat.i(95089);
    this.wBh = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  public n(bpi parambpi, int paramInt, String paramString1, bc parambc, String paramString2, String paramString3)
  {
    this.dyS = parambpi;
    this.requestType = paramInt;
    this.wBg = parambc;
    this.key = paramString1;
    this.wBe = paramString2;
    this.wBf = paramString3;
  }
  
  public n(String paramString1, SparseArray<bpi> paramSparseArray, String paramString2, bc parambc, int paramInt)
  {
    this.dpC = paramString1;
    this.wBh = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.wBg = parambc;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.n
 * JD-Core Version:    0.7.0.1
 */