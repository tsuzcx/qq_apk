package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f callback;
  public String jsonString;
  private b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(37662);
    b.a locala = new b.a();
    locala.fsX = new bgw();
    locala.fsY = new bgx();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.funcId = 2721;
    this.rr = locala.ado();
    ((bgw)this.rr.fsV.fta).xwb = paramString;
    ab.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(37662);
  }
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(37661);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aku();
    ((b.a)localObject).fsY = new akv();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((b.a)localObject).funcId = 1337;
    this.rr = ((b.a)localObject).ado();
    localObject = (aku)this.rr.fsV.fta;
    ((aku)localObject).fKw = paramString1;
    ((aku)localObject).xbR = paramString2;
    ((aku)localObject).xbS = paramString3;
    ab.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
    AppMethodBeat.o(37661);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(37663);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(37663);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(145333);
    int i = this.rr.getType();
    AppMethodBeat.o(145333);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(37664);
    ab.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " sceneType: " + getType());
    if (getType() == 1337) {
      this.jsonString = ((akv)((b)paramq).fsW.fta).wYM;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(37664);
      return;
      if (getType() == 2721) {
        this.jsonString = ((bgx)((b)paramq).fsW.fta).xwc;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c
 * JD-Core Version:    0.7.0.1
 */