package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public e(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(219612);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dbe();
    ((b.a)localObject).hQG = new dbf();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/send_subscription_msg";
    ((b.a)localObject).funcId = 2810;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dbe)this.rr.hQD.hQJ;
    ((dbe)localObject).HKh = paramString1;
    ((dbe)localObject).zot = paramString2;
    ((dbe)localObject).zQo = paramLong;
    ((dbe)localObject).HKi = paramString3;
    AppMethodBeat.o(219612);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(219614);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(219614);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(219613);
    int i = this.rr.getType();
    AppMethodBeat.o(219613);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219615);
    ae.i("NetSceneAdSubscribe", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(219615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e
 * JD-Core Version:    0.7.0.1
 */