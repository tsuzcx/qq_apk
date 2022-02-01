package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(97158);
    b.a locala = new b.a();
    locala.hQF = new dso();
    locala.hQG = new dsp();
    locala.uri = "/cgi-bin/mmoc-bin/adplayinfo/update_shared_uxinfo";
    locala.funcId = 2883;
    this.rr = locala.aDS();
    ((dso)this.rr.hQD.hQJ).HYD = paramString;
    AppMethodBeat.o(97158);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(97161);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97161);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97160);
    int i = this.rr.getType();
    AppMethodBeat.o(97160);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97159);
    ae.i("NetSceneUpdateUxInfo", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.i
 * JD-Core Version:    0.7.0.1
 */