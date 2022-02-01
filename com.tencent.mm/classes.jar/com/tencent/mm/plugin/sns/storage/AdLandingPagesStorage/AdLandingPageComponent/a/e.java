package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public e(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(198098);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dak();
    ((b.a)localObject).hNN = new dal();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/send_subscription_msg";
    ((b.a)localObject).funcId = 2810;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dak)this.rr.hNK.hNQ;
    ((dak)localObject).HqF = paramString1;
    ((dak)localObject).yXS = paramString2;
    ((dak)localObject).zyP = paramLong;
    ((dak)localObject).HqG = paramString3;
    AppMethodBeat.o(198098);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(198100);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(198100);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(198099);
    int i = this.rr.getType();
    AppMethodBeat.o(198099);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198101);
    ad.i("NetSceneAdSubscribe", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(198101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e
 * JD-Core Version:    0.7.0.1
 */