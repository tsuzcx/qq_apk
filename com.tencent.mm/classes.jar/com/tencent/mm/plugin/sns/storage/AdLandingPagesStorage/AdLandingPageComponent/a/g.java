package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  public String jsonString;
  private b rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(97154);
    b.a locala = new b.a();
    locala.hNM = new cdi();
    locala.hNN = new cdj();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.funcId = 2721;
    this.rr = locala.aDC();
    ((cdi)this.rr.hNK.hNQ).GXw = paramString;
    ad.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(97154);
  }
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(97153);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bbs();
    ((b.a)localObject).hNN = new bbt();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((b.a)localObject).funcId = 1337;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bbs)this.rr.hNK.hNQ;
    ((bbs)localObject).iht = paramString1;
    ((bbs)localObject).GyE = paramString2;
    ((bbs)localObject).GyF = paramString3;
    ad.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
    AppMethodBeat.o(97153);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(97156);
    this.callback = paramf;
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
      this.jsonString = ((bbt)((b)paramq).hNL.hNQ).GuC;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(97157);
      return;
      if (getType() == 2721) {
        this.jsonString = ((cdj)((b)paramq).hNL.hNQ).GXx;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g
 * JD-Core Version:    0.7.0.1
 */