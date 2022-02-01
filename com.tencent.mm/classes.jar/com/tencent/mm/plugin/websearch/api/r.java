package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.ac;

public final class r
  extends n
  implements k
{
  private String BYA;
  private g callback;
  private b hEg;
  private int scene;
  
  public r(cpk paramcpk)
  {
    AppMethodBeat.i(117627);
    b.a locala = new b.a();
    locala.funcId = 1523;
    locala.uri = "/cgi-bin/mmsearch-bin/recsearchreport";
    locala.hvt = paramcpk;
    locala.hvu = new cpl();
    this.hEg = locala.aAz();
    this.scene = paramcpk.Scene;
    this.BYA = paramcpk.FCf;
    AppMethodBeat.o(117627);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117629);
    ac.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    ai.Ut(5);
    ai.K(this.scene, 4, this.BYA);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(117629);
    return i;
  }
  
  public final int getType()
  {
    return 1523;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117628);
    ac.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ai.Ut(7);
      AppMethodBeat.o(117628);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ai.Ut(6);
    ai.a(this.scene, 5, paramInt2, paramInt3, this.BYA);
    AppMethodBeat.o(117628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.r
 * JD-Core Version:    0.7.0.1
 */