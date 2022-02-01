package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends n
  implements k
{
  public cit DST;
  private f callback;
  private b hZD;
  
  public q(cis paramcis)
  {
    AppMethodBeat.i(117617);
    paramcis.HkU = ad.bOD();
    this.DST = new cit();
    b.a locala = new b.a();
    locala.funcId = 1417;
    locala.uri = "/cgi-bin/mmsearch-bin/parduspresearch";
    locala.hQF = paramcis;
    locala.hQG = this.DST;
    this.hZD = locala.aDS();
    AppMethodBeat.o(117617);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117618);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(117618);
    return i;
  }
  
  public final int getType()
  {
    return 1417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117619);
    ae.i("MicroMsg.FTS.NetScenePardusPreSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.q
 * JD-Core Version:    0.7.0.1
 */