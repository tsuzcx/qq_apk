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
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.eoo;

public final class k
  extends q
  implements m
{
  public final String CXO;
  public final int CXP;
  private i callback;
  private final String dNI;
  private final int scene;
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.dNI = paramString1;
    this.CXO = paramString2;
    this.CXP = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73777);
    this.callback = parami;
    parami = new d.a();
    cqj localcqj = new cqj();
    localcqj.dNI = this.dNI;
    localcqj.MvX = this.CXO;
    localcqj.MvY = this.CXP;
    parami.iLN = localcqj;
    parami.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    parami.iLO = new cqk();
    parami.funcId = getType();
    parami.iLP = 0;
    parami.respCmdId = 0;
    int i = dispatch(paramg, parami.aXF(), this);
    AppMethodBeat.o(73777);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73776);
    paramString = (cqk)((d)params).iLL.iLR;
    this.callback.onSceneEnd(paramInt2, paramString.Lqs.dIZ, paramString.Lqs.dJa, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */