package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eyw;

public final class i
  extends q
  implements m
{
  public cek Jds;
  public byte[] Jdt;
  private com.tencent.mm.an.i callback;
  
  public i(byte[] paramArrayOfByte)
  {
    this.Jdt = paramArrayOfByte;
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(73771);
    this.callback = parami;
    parami = new d.a();
    cej localcej = new cej();
    if (this.Jdt != null) {
      localcej.TlY = z.aN(this.Jdt).Tkb;
    }
    parami.lBU = localcej;
    this.Jds = new cek();
    parami.lBV = this.Jds;
    parami.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    parami.funcId = getType();
    parami.lBW = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.bgN(), this);
    AppMethodBeat.o(73771);
    return i;
  }
  
  public final int getType()
  {
    return 1146;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73772);
    this.Jds = ((cek)d.c.b(((d)params).lBS));
    if (this.Jds.SrP != null)
    {
      paramInt3 = this.Jds.SrP.fBP;
      paramString = this.Jds.SrP.errmsg;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */