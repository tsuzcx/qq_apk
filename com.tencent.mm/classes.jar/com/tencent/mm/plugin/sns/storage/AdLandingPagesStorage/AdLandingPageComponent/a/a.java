package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vu;

public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  
  public a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(97129);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new vt();
    ((b.a)localObject).hQG = new vu();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
    ((b.a)localObject).funcId = 1210;
    this.rr = ((b.a)localObject).aDS();
    localObject = (vt)this.rr.hQD.hQJ;
    ((vt)localObject).GnD = paramString2;
    ((vt)localObject).FMg = paramString1;
    ((vt)localObject).GnE = com.tencent.mm.sdk.platformtools.k.fnT();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((vt)localObject).GnF = i;
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