package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.dim;

public final class c
  extends n
  implements k
{
  public final String appId;
  private g callback;
  private final int scene;
  
  public c(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73764);
    this.callback = paramg;
    paramg = new b.a();
    aas localaas = new aas();
    localaas.dlB = this.appId;
    localaas.dye = this.scene;
    paramg.gUU = localaas;
    paramg.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    paramg.gUV = new aat();
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.atI(), this);
    AppMethodBeat.o(73764);
    return i;
  }
  
  public final int getType()
  {
    return 1127;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73765);
    paramString = (aat)((b)paramq).gUT.gUX;
    this.callback.onSceneEnd(paramInt2, paramString.DbG.dhR, paramString.DbG.dhS, this);
    AppMethodBeat.o(73765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.c
 * JD-Core Version:    0.7.0.1
 */