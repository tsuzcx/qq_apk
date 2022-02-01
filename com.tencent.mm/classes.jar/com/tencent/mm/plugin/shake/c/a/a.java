package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28179);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new sm();
    ((b.a)localObject).hQG = new sn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
    ((b.a)localObject).funcId = 1252;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (sm)this.rr.hQD.hQJ;
    ((sm)localObject).oEo = paramString1;
    ((sm)localObject).dJc = paramString2;
    AppMethodBeat.o(28179);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28180);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(28181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.a
 * JD-Core Version:    0.7.0.1
 */