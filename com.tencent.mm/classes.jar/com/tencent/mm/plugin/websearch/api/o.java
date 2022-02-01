package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  public byf AFK;
  private g callback;
  private b hdD;
  
  public o(bye parambye)
  {
    AppMethodBeat.i(117617);
    parambye.DLE = aa.bCk();
    this.AFK = new byf();
    b.a locala = new b.a();
    locala.funcId = 1417;
    locala.uri = "/cgi-bin/mmsearch-bin/parduspresearch";
    locala.gUU = parambye;
    locala.gUV = this.AFK;
    this.hdD = locala.atI();
    AppMethodBeat.o(117617);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117618);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(117618);
    return i;
  }
  
  public final int getType()
  {
    return 1417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117619);
    ad.i("MicroMsg.FTS.NetScenePardusPreSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.o
 * JD-Core Version:    0.7.0.1
 */