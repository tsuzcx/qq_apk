package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28179);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new qj();
    ((b.a)localObject).gUV = new qk();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
    ((b.a)localObject).funcId = 1252;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (qj)this.rr.gUS.gUX;
    ((qj)localObject).nrr = paramString1;
    ((qj)localObject).dyd = paramString2;
    AppMethodBeat.o(28179);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28180);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28180);
    return i;
  }
  
  public final int getType()
  {
    return 1252;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28181);
    ad.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.a
 * JD-Core Version:    0.7.0.1
 */