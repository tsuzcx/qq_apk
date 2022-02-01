package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
  extends n
  implements k
{
  private String DBu;
  private f callback;
  private b hWL;
  private int scene;
  
  public u(cup paramcup)
  {
    AppMethodBeat.i(117627);
    b.a locala = new b.a();
    locala.funcId = 1523;
    locala.uri = "/cgi-bin/mmsearch-bin/recsearchreport";
    locala.hNM = paramcup;
    locala.hNN = new cuq();
    this.hWL = locala.aDC();
    this.scene = paramcup.Scene;
    this.DBu = paramcup.Hmu;
    AppMethodBeat.o(117627);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117629);
    ad.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    am.Wm(5);
    am.M(this.scene, 4, this.DBu);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    ad.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      am.Wm(7);
      AppMethodBeat.o(117628);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    am.Wm(6);
    am.a(this.scene, 5, paramInt2, paramInt3, this.DBu);
    AppMethodBeat.o(117628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */