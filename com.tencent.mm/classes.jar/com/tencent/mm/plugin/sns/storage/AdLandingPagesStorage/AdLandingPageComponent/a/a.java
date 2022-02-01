package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.platformtools.i;

public final class a
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(97129);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tw();
    ((b.a)localObject).hvu = new tx();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
    ((b.a)localObject).funcId = 1210;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tw)this.rr.hvr.hvw;
    ((tw)localObject).EnV = paramString2;
    ((tw)localObject).DOK = paramString1;
    ((tw)localObject).EnW = i.eUv();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((tw)localObject).EnX = i;
      AppMethodBeat.o(97129);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97132);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97132);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97131);
    int i = this.rr.getType();
    AppMethodBeat.o(97131);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97130);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a
 * JD-Core Version:    0.7.0.1
 */