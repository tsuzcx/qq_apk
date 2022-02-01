package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  public String xbU;
  
  public k(dfr paramdfr)
  {
    AppMethodBeat.i(66903);
    b.a locala = new b.a();
    locala.hQF = new dlh();
    locala.hQG = new dli();
    locala.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
    locala.funcId = 557;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((dlh)this.rr.hQD.hQJ).HSN = paramdfr;
    AppMethodBeat.o(66903);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66905);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66905);
    return i;
  }
  
  public final int getType()
  {
    return 557;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66904);
    paramq = (dli)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + paramq.HSO);
      this.xbU = paramq.HSO;
    }
    ae.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(66904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.k
 * JD-Core Version:    0.7.0.1
 */