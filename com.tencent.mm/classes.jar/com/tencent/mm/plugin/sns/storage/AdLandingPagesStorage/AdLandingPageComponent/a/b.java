package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(97133);
    b.a locala = new b.a();
    locala.hvt = new cki();
    locala.hvu = new ckj();
    locala.uri = "/cgi-bin/mmoc-bin/adplayinfo/query_ad_redpkt_state";
    locala.funcId = 2944;
    this.rr = locala.aAz();
    ((cki)this.rr.hvr.hvw).Fyq = paramString;
    AppMethodBeat.o(97133);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97136);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97136);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97135);
    int i = this.rr.getType();
    AppMethodBeat.o(97135);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97134);
    ac.i("NetSceneAdGetHbCoverState", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b
 * JD-Core Version:    0.7.0.1
 */