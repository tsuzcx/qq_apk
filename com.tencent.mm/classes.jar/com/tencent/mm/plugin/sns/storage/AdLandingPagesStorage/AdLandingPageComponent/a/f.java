package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements k
{
  public String AaB;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(97150);
    this.AaB = "";
    this.AaB = paramString;
    b.a locala = new b.a();
    locala.hQF = new akj();
    locala.hQG = new akk();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
    locala.funcId = 2874;
    this.rr = locala.aDS();
    ((akj)this.rr.hQD.hQJ).GBZ = paramString;
    ae.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", new Object[] { paramString });
    AppMethodBeat.o(97150);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(97152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f
 * JD-Core Version:    0.7.0.1
 */