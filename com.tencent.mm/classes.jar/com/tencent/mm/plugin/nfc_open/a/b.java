package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.al.b rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(26686);
    b.a locala = new b.a();
    locala.hNM = new abm();
    locala.hNN = new abn();
    locala.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
    locala.funcId = 1561;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((abm)this.rr.hNK.hNQ).version = paramInt;
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
    ad.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.b
 * JD-Core Version:    0.7.0.1
 */