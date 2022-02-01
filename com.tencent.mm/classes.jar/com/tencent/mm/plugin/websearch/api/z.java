package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.sdk.platformtools.ae;

public final class z
  extends n
  implements k
{
  private String DTr;
  private f callback;
  public b hZD;
  private int scene;
  
  public z(cvj paramcvj)
  {
    AppMethodBeat.i(117641);
    b.a locala = new b.a();
    locala.funcId = 1134;
    locala.uri = "/cgi-bin/mmsearch-bin/searchreport";
    locala.hQF = paramcvj;
    locala.hQG = new cvk();
    this.hZD = locala.aDS();
    this.scene = paramcvj.Scene;
    this.DTr = paramcvj.HFU;
    AppMethodBeat.o(117641);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117643);
    ae.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    am.WT(5);
    am.M(this.scene, 4, this.DTr);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(117643);
    return i;
  }
  
  public final int getType()
  {
    return 1134;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117642);
    ae.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      am.WT(7);
      AppMethodBeat.o(117642);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    am.WT(6);
    am.a(this.scene, 5, paramInt2, paramInt3, this.DTr);
    AppMethodBeat.o(117642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.z
 * JD-Core Version:    0.7.0.1
 */