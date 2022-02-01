package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private g callback;
  public String jsonString;
  private b rr;
  
  public f(String paramString)
  {
    AppMethodBeat.i(97154);
    b.a locala = new b.a();
    locala.gUU = new bua();
    locala.gUV = new bub();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.funcId = 2721;
    this.rr = locala.atI();
    ((bua)this.rr.gUS.gUX).DRv = paramString;
    ad.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(97154);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(97153);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new auk();
    ((b.a)localObject).gUV = new aul();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((b.a)localObject).funcId = 1337;
    this.rr = ((b.a)localObject).atI();
    localObject = (auk)this.rr.gUS.gUX;
    ((auk)localObject).hnC = paramString1;
    ((auk)localObject).Duk = paramString2;
    ((auk)localObject).Dul = paramString3;
    ad.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
    AppMethodBeat.o(97153);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97156);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(97156);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97155);
    int i = this.rr.getType();
    AppMethodBeat.o(97155);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97157);
    ad.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " sceneType: " + getType());
    if (getType() == 1337) {
      this.jsonString = ((aul)((b)paramq).gUT.gUX).Dqx;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(97157);
      return;
      if (getType() == 2721) {
        this.jsonString = ((bub)((b)paramq).gUT.gUX).DRw;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f
 * JD-Core Version:    0.7.0.1
 */