package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.j;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(97129);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new vr();
    ((b.a)localObject).hNN = new vs();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
    ((b.a)localObject).funcId = 1210;
    this.rr = ((b.a)localObject).aDC();
    localObject = (vr)this.rr.hNK.hNQ;
    ((vr)localObject).FVe = paramString2;
    ((vr)localObject).FtI = paramString1;
    ((vr)localObject).FVf = j.fjZ();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((vr)localObject).FVg = i;
      AppMethodBeat.o(97129);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(97132);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a
 * JD-Core Version:    0.7.0.1
 */