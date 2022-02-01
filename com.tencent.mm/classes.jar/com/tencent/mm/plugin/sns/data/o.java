package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;

public final class o
{
  public String DEt;
  public String DEu;
  public bp DEv;
  public SparseArray<cnb> DEw;
  public String dRS;
  public cnb ebR;
  public String key;
  public int requestType;
  public int size;
  
  public o()
  {
    AppMethodBeat.i(95089);
    this.DEw = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  public o(cnb paramcnb, int paramInt, String paramString1, bp parambp, String paramString2, String paramString3)
  {
    this.ebR = paramcnb;
    this.requestType = paramInt;
    this.DEv = parambp;
    this.key = paramString1;
    this.DEt = paramString2;
    this.DEu = paramString3;
  }
  
  public o(String paramString1, SparseArray<cnb> paramSparseArray, String paramString2, bp parambp, int paramInt)
  {
    this.dRS = paramString1;
    this.DEw = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.DEv = parambp;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.o
 * JD-Core Version:    0.7.0.1
 */