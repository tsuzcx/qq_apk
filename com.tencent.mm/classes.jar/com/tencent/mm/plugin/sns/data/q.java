package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.storage.bp;

public final class q
{
  public String JRo;
  public String JRp;
  public bp JRq;
  public SparseArray<cvt> JRr;
  public String fLp;
  public cvt fVT;
  public String key;
  public int requestType;
  public int size;
  
  public q()
  {
    AppMethodBeat.i(95089);
    this.JRr = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  public q(cvt paramcvt, int paramInt, String paramString1, bp parambp, String paramString2, String paramString3)
  {
    this.fVT = paramcvt;
    this.requestType = paramInt;
    this.JRq = parambp;
    this.key = paramString1;
    this.JRo = paramString2;
    this.JRp = paramString3;
  }
  
  public q(String paramString1, SparseArray<cvt> paramSparseArray, String paramString2, bp parambp, int paramInt)
  {
    this.fLp = paramString1;
    this.JRr = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.JRq = parambp;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.q
 * JD-Core Version:    0.7.0.1
 */