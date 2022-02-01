package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.eyw;

public final class l
  extends q
  implements m
{
  public byte[] Jdt;
  public ecr Jdw;
  private i callback;
  private String fwe;
  
  public l(String paramString)
  {
    this.fwe = paramString;
  }
  
  public l(byte[] paramArrayOfByte)
  {
    this.Jdt = paramArrayOfByte;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73778);
    this.callback = parami;
    parami = new d.a();
    ecq localecq = new ecq();
    localecq.fwe = this.fwe;
    if (this.Jdt != null) {
      localecq.TlY = z.aN(this.Jdt).Tkb;
    }
    parami.lBU = localecq;
    parami.lBV = new ecr();
    parami.funcId = getType();
    parami.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    parami.lBW = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.bgN(), this);
    AppMethodBeat.o(73778);
    return i;
  }
  
  public final int getType()
  {
    return 1169;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73779);
    this.Jdw = ((ecr)d.c.b(((d)params).lBS));
    if (this.Jdw.SrP != null)
    {
      paramInt3 = this.Jdw.SrP.fBP;
      paramString = this.Jdw.SrP.errmsg;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */