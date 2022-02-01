package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.protocal.protobuf.euy;
import java.util.List;

public final class k
  extends q
  implements m
{
  public List<euy> IKQ;
  public long IKR;
  public float angle;
  private i callback;
  public int fwM;
  public d rr;
  
  public k(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    d.a locala = new d.a();
    dcl localdcl = new dcl();
    localdcl.TJP = paramInt2;
    localdcl.TJQ = paramInt3;
    localdcl.TJU = paramString1;
    localdcl.TJV = paramString2;
    localdcl.CPw = paramInt1;
    locala.lBU = localdcl;
    locala.lBV = new dcm();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.fwM = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public k(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(120857);
    this.callback = parami;
    this.IKR = System.currentTimeMillis();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final List<euy> fCL()
  {
    return this.IKQ;
  }
  
  public final String fCM()
  {
    AppMethodBeat.i(211365);
    String str = ((dcm)d.c.b(this.rr.lBS)).TJY;
    AppMethodBeat.o(211365);
    return str;
  }
  
  public final long fCN()
  {
    return this.IKR;
  }
  
  public final float getAngle()
  {
    return this.angle;
  }
  
  public final int getSessionId()
  {
    return this.fwM;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((dcm)d.c.b(((d)params).lBS)).TJW;
    this.IKQ = ((dcm)d.c.b(((d)params).lBS)).TfA;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */