package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends q
  implements m
{
  public cza IDB;
  private i callback;
  private d iUB;
  
  public t(cyz paramcyz)
  {
    AppMethodBeat.i(117617);
    paramcyz.MlQ = ai.clJ();
    paramcyz.MlR = ai.fYd();
    this.IDB = new cza();
    d.a locala = new d.a();
    locala.funcId = 1417;
    locala.uri = "/cgi-bin/mmsearch-bin/parduspresearch";
    locala.iLN = paramcyz;
    locala.iLO = this.IDB;
    this.iUB = locala.aXF();
    AppMethodBeat.o(117617);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117618);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(117618);
    return i;
  }
  
  public final int getType()
  {
    return 1417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117619);
    Log.i("MicroMsg.FTS.NetScenePardusPreSearch", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */