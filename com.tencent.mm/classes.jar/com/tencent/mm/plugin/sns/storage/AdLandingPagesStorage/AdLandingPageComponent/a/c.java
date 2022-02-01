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
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public c(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(97137);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new avi();
    ((b.a)localObject).gUV = new avj();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_landpage_smartphone";
    ((b.a)localObject).funcId = 2605;
    this.rr = ((b.a)localObject).atI();
    localObject = (avi)this.rr.gUS.gUX;
    ((avi)localObject).wVT = paramLong;
    ((avi)localObject).DuK = paramInt1;
    ((avi)localObject).DtA = paramString1;
    ((avi)localObject).wxc = paramString2;
    ((avi)localObject).wVR = paramInt2;
    AppMethodBeat.o(97137);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97140);
    this.callback = paramg;
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
    ad.i("NetSceneAdGetSmartPhoneNumber", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c
 * JD-Core Version:    0.7.0.1
 */