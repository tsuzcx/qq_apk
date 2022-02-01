package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.eoo;

public final class i
  extends q
  implements m
{
  public bwu CXM;
  public byte[] CXN;
  private com.tencent.mm.ak.i callback;
  
  public i(byte[] paramArrayOfByte)
  {
    this.CXN = paramArrayOfByte;
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(73771);
    this.callback = parami;
    parami = new d.a();
    bwt localbwt = new bwt();
    if (this.CXN != null) {
      localbwt.Mcz = z.aC(this.CXN).getBuffer();
    }
    parami.iLN = localbwt;
    this.CXM = new bwu();
    parami.iLO = this.CXM;
    parami.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
    parami.funcId = getType();
    parami.iLP = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.aXF(), this);
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
    this.CXM = ((bwu)((d)params).iLL.iLR);
    if (this.CXM.Lqs != null)
    {
      paramInt3 = this.CXM.Lqs.dIZ;
      paramString = this.CXM.Lqs.dJa;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */