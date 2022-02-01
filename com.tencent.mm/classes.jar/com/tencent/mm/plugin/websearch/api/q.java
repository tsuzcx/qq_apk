package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;

public final class q
  extends n
  implements k
{
  public chz DAW;
  private f callback;
  private b hWL;
  
  public q(chy paramchy)
  {
    AppMethodBeat.i(117617);
    paramchy.GRt = ad.bNG();
    this.DAW = new chz();
    b.a locala = new b.a();
    locala.funcId = 1417;
    locala.uri = "/cgi-bin/mmsearch-bin/parduspresearch";
    locala.hNM = paramchy;
    locala.hNN = this.DAW;
    this.hWL = locala.aDC();
    AppMethodBeat.o(117617);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117618);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.NetScenePardusPreSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.q
 * JD-Core Version:    0.7.0.1
 */