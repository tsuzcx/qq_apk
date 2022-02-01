package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.deu;
import java.util.List;

public final class h
  extends n
  implements k
{
  public float angle;
  private g callback;
  public int dcS;
  public b rr;
  public List<deu> vOA;
  public long vOB;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    b.a locala = new b.a();
    bte localbte = new bte();
    localbte.DQh = paramInt2;
    localbte.DQi = paramInt3;
    localbte.DQm = paramString1;
    localbte.DQn = paramString2;
    localbte.Scene = paramInt1;
    locala.gUU = localbte;
    locala.gUV = new btf();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.dcS = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public h(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final float dlr()
  {
    return this.angle;
  }
  
  public final List<deu> dls()
  {
    return this.vOA;
  }
  
  public final String dlt()
  {
    return ((btf)this.rr.gUT.gUX).DQq;
  }
  
  public final long dlu()
  {
    return this.vOB;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(120857);
    this.callback = paramg;
    this.vOB = System.currentTimeMillis();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final int getSessionId()
  {
    return this.dcS;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((btf)((b)paramq).gUT.gUX).DQo;
    this.vOA = ((btf)((b)paramq).gUT.gUX).Duu;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */