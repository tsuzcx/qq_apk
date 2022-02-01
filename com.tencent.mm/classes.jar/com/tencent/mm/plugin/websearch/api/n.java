package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  public cdb BYd;
  private g callback;
  private b hEg;
  
  public n(cda paramcda)
  {
    AppMethodBeat.i(117617);
    paramcda.FhT = z.bJn();
    this.BYd = new cdb();
    b.a locala = new b.a();
    locala.funcId = 1417;
    locala.uri = "/cgi-bin/mmsearch-bin/parduspresearch";
    locala.hvt = paramcda;
    locala.hvu = this.BYd;
    this.hEg = locala.aAz();
    AppMethodBeat.o(117617);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117618);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.FTS.NetScenePardusPreSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.n
 * JD-Core Version:    0.7.0.1
 */