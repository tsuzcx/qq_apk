package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  private i callback;
  public String jsonString;
  private d rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(97154);
    d.a locala = new d.a();
    locala.iLN = new cuj();
    locala.iLO = new cuk();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.funcId = 2721;
    this.rr = locala.aXF();
    ((cuj)this.rr.iLK.iLR).MzD = paramString;
    Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(97154);
  }
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(97153);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bnu();
    ((d.a)localObject).iLO = new bnv();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((d.a)localObject).funcId = 1337;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bnu)this.rr.iLK.iLR;
    ((bnu)localObject).jfi = paramString1;
    ((bnu)localObject).LWj = paramString2;
    ((bnu)localObject).LWk = paramString3;
    Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
    AppMethodBeat.o(97153);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(97156);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97157);
    Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " sceneType: " + getType());
    if (getType() == 1337) {
      this.jsonString = ((bnv)((d)params).iLL.iLR).LSg;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(97157);
      return;
      if (getType() == 2721) {
        this.jsonString = ((cuk)((d)params).iLL.iLR).MzE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.j
 * JD-Core Version:    0.7.0.1
 */