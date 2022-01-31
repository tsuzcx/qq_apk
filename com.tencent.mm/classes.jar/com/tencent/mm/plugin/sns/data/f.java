package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.storage.az;

public final class f
{
  public bcs cIc;
  public String czw;
  public String key;
  public String rbk;
  public String rbl;
  public az rbm;
  public SparseArray<bcs> rbn;
  public int requestType;
  public int size;
  
  public f()
  {
    AppMethodBeat.i(35799);
    this.rbn = new SparseArray();
    AppMethodBeat.o(35799);
  }
  
  public f(bcs parambcs, int paramInt, String paramString1, az paramaz, String paramString2, String paramString3)
  {
    this.cIc = parambcs;
    this.requestType = paramInt;
    this.rbm = paramaz;
    this.key = paramString1;
    this.rbk = paramString2;
    this.rbl = paramString3;
  }
  
  public f(String paramString1, SparseArray<bcs> paramSparseArray, String paramString2, az paramaz, int paramInt)
  {
    this.czw = paramString1;
    this.rbn = paramSparseArray;
    this.requestType = 9;
    this.key = paramString2;
    this.rbm = paramaz;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.f
 * JD-Core Version:    0.7.0.1
 */