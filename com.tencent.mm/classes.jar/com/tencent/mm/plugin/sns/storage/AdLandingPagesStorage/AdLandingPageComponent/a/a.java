package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.g;

public final class a
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37655);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qz();
    ((b.a)localObject).fsY = new ra();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
    ((b.a)localObject).funcId = 1210;
    this.rr = ((b.a)localObject).ado();
    localObject = (qz)this.rr.fsV.fta;
    ((qz)localObject).wJj = paramString2;
    ((qz)localObject).wJi = paramString1;
    ((qz)localObject).wJk = g.dsn();
    AppMethodBeat.o(37655);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(37657);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(37657);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(145332);
    int i = this.rr.getType();
    AppMethodBeat.o(145332);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(37656);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(37656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a
 * JD-Core Version:    0.7.0.1
 */