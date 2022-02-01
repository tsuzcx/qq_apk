package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.storage.bf;

public final class n
{
  public String dnn;
  public btz dwE;
  public String key;
  public int requestType;
  public int size;
  public String xNA;
  public bf xNB;
  public SparseArray<btz> xNC;
  public String xNz;
  
  public n()
  {
    AppMethodBeat.i(95089);
    this.xNC = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  public n(btz parambtz, int paramInt, String paramString1, bf parambf, String paramString2, String paramString3)
  {
    this.dwE = parambtz;
    this.requestType = paramInt;
    this.xNB = parambf;
    this.key = paramString1;
    this.xNz = paramString2;
    this.xNA = paramString3;
  }
  
  public n(String paramString1, SparseArray<btz> paramSparseArray, String paramString2, bf parambf, int paramInt)
  {
    this.dnn = paramString1;
    this.xNC = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.xNB = parambf;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.n
 * JD-Core Version:    0.7.0.1
 */