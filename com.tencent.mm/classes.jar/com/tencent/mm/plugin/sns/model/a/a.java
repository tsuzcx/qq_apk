package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;

public final class a
{
  public String cBO = "";
  public String cqq = "";
  public String czw;
  public e rbc = null;
  public SparseArray<e> rbd;
  public String rbk = "";
  public String rbl = "";
  public SparseArray<bcs> rbn;
  public String reC = "";
  public String reG = "";
  public bcs reH;
  public boolean rjA = false;
  public boolean rjB = false;
  public int rjC = 0;
  public az rjD;
  public float rjE = 0.0F;
  public int size;
  public String url = "";
  
  public a(String paramString)
  {
    this.cBO = paramString;
  }
  
  public a(String paramString, SparseArray<bcs> paramSparseArray, SparseArray<e> paramSparseArray1, int paramInt)
  {
    this.czw = paramString;
    this.rbn = paramSparseArray;
    this.rbd = paramSparseArray1;
    this.size = paramInt;
  }
  
  public final String cpP()
  {
    AppMethodBeat.i(36743);
    if (this.rjC == 4)
    {
      str = i.p(this.reH);
      AppMethodBeat.o(36743);
      return str;
    }
    if (this.rjC == 6)
    {
      str = i.q(this.reH);
      AppMethodBeat.o(36743);
      return str;
    }
    if (this.rjA)
    {
      str = i.n(this.reH);
      AppMethodBeat.o(36743);
      return str;
    }
    String str = i.m(this.reH);
    AppMethodBeat.o(36743);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(36744);
    if (!bo.isNullOrNil(this.rbk))
    {
      str = this.rbk;
      AppMethodBeat.o(36744);
      return str;
    }
    if (bo.isNullOrNil(this.reC)) {
      init();
    }
    String str = this.reC;
    AppMethodBeat.o(36744);
    return str;
  }
  
  public final a gr(String paramString1, String paramString2)
  {
    this.rbk = paramString1;
    this.rbl = paramString2;
    return this;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(36742);
    this.reC = ao.gl(ag.getAccSnsPath(), this.cBO);
    AppMethodBeat.o(36742);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */