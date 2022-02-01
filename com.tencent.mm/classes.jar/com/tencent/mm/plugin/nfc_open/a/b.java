package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  public com.tencent.mm.ak.b rr;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(26686);
    b.a locala = new b.a();
    locala.hvt = new zm();
    locala.hvu = new zn();
    locala.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
    locala.funcId = 1561;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((zm)this.rr.hvr.hvw).version = paramInt;
    AppMethodBeat.o(26686);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26687);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.b
 * JD-Core Version:    0.7.0.1
 */