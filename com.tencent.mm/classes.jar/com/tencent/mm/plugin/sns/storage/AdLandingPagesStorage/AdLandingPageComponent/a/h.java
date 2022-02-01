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
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(198102);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bgw();
    ((b.a)localObject).hNN = new bgx();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_qywx_qrcode";
    ((b.a)localObject).funcId = 1022;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bgw)this.rr.hNK.hNQ;
    ((bgw)localObject).dyG = paramString1;
    ((bgw)localObject).zzN = paramString2;
    ((bgw)localObject).GCi = paramString3;
    AppMethodBeat.o(198102);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(198104);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(198104);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(198103);
    int i = this.rr.getType();
    AppMethodBeat.o(198103);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198105);
    ad.i("NetSceneUpdateQrUrl", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(198105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h
 * JD-Core Version:    0.7.0.1
 */