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
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public c(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(97137);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bdi();
    ((b.a)localObject).hQG = new bdj();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_landpage_smartphone";
    ((b.a)localObject).funcId = 2605;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bdi)this.rr.hQD.hQJ;
    ((bdi)localObject).zQo = paramLong;
    ((bdi)localObject).GSK = paramInt1;
    ((bdi)localObject).GRl = paramString1;
    ((bdi)localObject).zot = paramString2;
    ((bdi)localObject).zQm = paramInt2;
    AppMethodBeat.o(97137);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(97140);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97140);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97139);
    int i = this.rr.getType();
    AppMethodBeat.o(97139);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97138);
    ae.i("NetSceneAdGetSmartPhoneNumber", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c
 * JD-Core Version:    0.7.0.1
 */