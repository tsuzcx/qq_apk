package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.sdk.platformtools.ad;

public final class s
  extends n
  implements k
{
  private String AGi;
  private g callback;
  private b hdD;
  private int scene;
  
  public s(ckd paramckd)
  {
    AppMethodBeat.i(117627);
    b.a locala = new b.a();
    locala.funcId = 1523;
    locala.uri = "/cgi-bin/mmsearch-bin/recsearchreport";
    locala.gUU = paramckd;
    locala.gUV = new cke();
    this.hdD = locala.atI();
    this.scene = paramckd.Scene;
    this.AGi = paramckd.Eff;
    AppMethodBeat.o(117627);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117629);
    ad.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[] { Integer.valueOf(this.scene) });
    ak.Sk(5);
    ak.L(this.scene, 4, this.AGi);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
      ak.Sk(7);
      AppMethodBeat.o(117628);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    ak.Sk(6);
    ak.a(this.scene, 5, paramInt2, paramInt3, this.AGi);
    AppMethodBeat.o(117628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.s
 * JD-Core Version:    0.7.0.1
 */