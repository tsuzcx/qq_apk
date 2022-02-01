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
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219616);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bhm();
    ((b.a)localObject).hQG = new bhn();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_qywx_qrcode";
    ((b.a)localObject).funcId = 1022;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bhm)this.rr.hQD.hQJ;
    ((bhm)localObject).dzL = paramString1;
    ((bhm)localObject).zQM = paramString2;
    ((bhm)localObject).GVI = paramString3;
    AppMethodBeat.o(219616);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(219618);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(219618);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(219617);
    int i = this.rr.getType();
    AppMethodBeat.o(219617);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219619);
    ae.i("NetSceneUpdateQrUrl", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(219619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h
 * JD-Core Version:    0.7.0.1
 */