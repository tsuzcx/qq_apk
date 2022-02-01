package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(97158);
    b.a locala = new b.a();
    locala.gUU = new dgl();
    locala.gUV = new dgm();
    locala.uri = "/cgi-bin/mmoc-bin/adplayinfo/update_shared_uxinfo";
    locala.funcId = 2883;
    this.rr = locala.atI();
    ((dgl)this.rr.gUS.gUX).Exa = paramString;
    AppMethodBeat.o(97158);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97161);
    this.callback = paramg;
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
    ad.i("NetSceneUpdateUxInfo", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h
 * JD-Core Version:    0.7.0.1
 */