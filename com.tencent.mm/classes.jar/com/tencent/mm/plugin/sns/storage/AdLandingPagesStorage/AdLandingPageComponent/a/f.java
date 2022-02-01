package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private b rr;
  public String zJu;
  
  public f(String paramString)
  {
    AppMethodBeat.i(97150);
    this.zJu = "";
    this.zJu = paramString;
    b.a locala = new b.a();
    locala.hNM = new ajz();
    locala.hNN = new aka();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
    locala.funcId = 2874;
    this.rr = locala.aDC();
    ((ajz)this.rr.hNK.hNQ).Gjq = paramString;
    ad.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", new Object[] { paramString });
    AppMethodBeat.o(97150);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(97151);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97151);
    return i;
  }
  
  public final int getType()
  {
    return 2874;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97152);
    ad.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(97152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f
 * JD-Core Version:    0.7.0.1
 */