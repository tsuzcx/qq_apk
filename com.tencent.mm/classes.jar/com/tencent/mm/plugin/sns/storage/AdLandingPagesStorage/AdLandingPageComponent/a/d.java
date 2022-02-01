package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97146);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bl();
    ((b.a)localObject).gUV = new bm();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
    ((b.a)localObject).funcId = 2538;
    this.rr = ((b.a)localObject).atI();
    localObject = (bl)this.rr.gUS.gUX;
    bk localbk = new bk();
    localbk.CvZ = 2;
    Context localContext = aj.getContext();
    if (ay.isWifi(localContext)) {
      i = 1;
    }
    for (;;)
    {
      localbk.CvW = i;
      ((bl)localObject).Cwb = localbk;
      ((bl)localObject).cGg = paramString1;
      ((bl)localObject).content = paramString2;
      AppMethodBeat.o(97146);
      return;
      if (!ay.is2G(localContext)) {
        if (ay.is3G(localContext)) {
          i = 3;
        } else if (ay.is4G(localContext)) {
          i = 4;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97149);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97149);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97148);
    int i = this.rr.getType();
    AppMethodBeat.o(97148);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97147);
    ad.i("NetSceneAdLadingPageClick", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d
 * JD-Core Version:    0.7.0.1
 */