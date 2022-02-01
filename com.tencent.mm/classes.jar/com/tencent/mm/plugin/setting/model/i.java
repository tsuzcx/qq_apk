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
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.dim;

public final class i
  extends n
  implements k
{
  private g callback;
  private final String dlB;
  private final int scene;
  public final String wcY;
  public final int wcZ;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.dlB = paramString1;
    this.wcY = paramString2;
    this.wcZ = paramInt1;
    this.scene = paramInt2;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(73777);
    this.callback = paramg;
    paramg = new b.a();
    brg localbrg = new brg();
    localbrg.dlB = this.dlB;
    localbrg.DPb = this.wcY;
    localbrg.DPc = this.wcZ;
    paramg.gUU = localbrg;
    paramg.uri = "/cgi-bin/mmbiz-bin/moduserauth";
    paramg.gUV = new brh();
    paramg.funcId = getType();
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    int i = dispatch(parame, paramg.atI(), this);
    AppMethodBeat.o(73777);
    return i;
  }
  
  public final int getType()
  {
    return 1144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73776);
    paramString = (brh)((b)paramq).gUT.gUX;
    this.callback.onSceneEnd(paramInt2, paramString.DbG.dhR, paramString.DbG.dhS, this);
    AppMethodBeat.o(73776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.i
 * JD-Core Version:    0.7.0.1
 */