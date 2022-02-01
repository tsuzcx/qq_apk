package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.ak.b rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(26686);
    b.a locala = new b.a();
    locala.hQF = new abv();
    locala.hQG = new abw();
    locala.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
    locala.funcId = 1561;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((abv)this.rr.hQD.hQJ).version = paramInt;
    AppMethodBeat.o(26686);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26687);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26687);
    return i;
  }
  
  public final int getType()
  {
    return 1561;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26688);
    ae.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.b
 * JD-Core Version:    0.7.0.1
 */