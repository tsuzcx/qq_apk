package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.storage.bj;

public final class n
{
  public byn dIQ;
  public String dzb;
  public String key;
  public int requestType;
  public int size;
  public String zdt;
  public String zdu;
  public bj zdv;
  public SparseArray<byn> zdw;
  
  public n()
  {
    AppMethodBeat.i(95089);
    this.zdw = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  public n(byn parambyn, int paramInt, String paramString1, bj parambj, String paramString2, String paramString3)
  {
    this.dIQ = parambyn;
    this.requestType = paramInt;
    this.zdv = parambj;
    this.key = paramString1;
    this.zdt = paramString2;
    this.zdu = paramString3;
  }
  
  public n(String paramString1, SparseArray<byn> paramSparseArray, String paramString2, bj parambj, int paramInt)
  {
    this.dzb = paramString1;
    this.zdw = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.zdv = parambj;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.n
 * JD-Core Version:    0.7.0.1
 */