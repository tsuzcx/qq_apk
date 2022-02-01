package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.eoo;

public final class l
  extends q
  implements m
{
  public byte[] CXN;
  public dst CXQ;
  private i callback;
  private String dDv;
  
  public l(String paramString)
  {
    this.dDv = paramString;
  }
  
  public l(byte[] paramArrayOfByte)
  {
    this.CXN = paramArrayOfByte;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73778);
    this.callback = parami;
    parami = new d.a();
    dss localdss = new dss();
    localdss.dDv = this.dDv;
    if (this.CXN != null) {
      localdss.Mcz = z.aC(this.CXN).getBuffer();
    }
    parami.iLN = localdss;
    parami.iLO = new dst();
    parami.funcId = getType();
    parami.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
    parami.iLP = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.aXF(), this);
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
    this.CXQ = ((dst)((d)params).iLL.iLR);
    if (this.CXQ.Lqs != null)
    {
      paramInt3 = this.CXQ.Lqs.dIZ;
      paramString = this.CXQ.Lqs.dJa;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */