package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.storage.bk;

public final class o
{
  public String dAg;
  public bzh dKe;
  public String key;
  public int requestType;
  public int size;
  public String zuj;
  public String zuk;
  public bk zul;
  public SparseArray<bzh> zum;
  
  public o()
  {
    AppMethodBeat.i(95089);
    this.zum = new SparseArray();
    AppMethodBeat.o(95089);
  }
  
  public o(bzh parambzh, int paramInt, String paramString1, bk parambk, String paramString2, String paramString3)
  {
    this.dKe = parambzh;
    this.requestType = paramInt;
    this.zul = parambk;
    this.key = paramString1;
    this.zuj = paramString2;
    this.zuk = paramString3;
  }
  
  public o(String paramString1, SparseArray<bzh> paramSparseArray, String paramString2, bk parambk, int paramInt)
  {
    this.dAg = paramString1;
    this.zum = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.zul = parambk;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.o
 * JD-Core Version:    0.7.0.1
 */