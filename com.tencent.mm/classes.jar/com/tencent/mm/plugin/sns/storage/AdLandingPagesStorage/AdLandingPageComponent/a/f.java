package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.ac;

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
    locala.hvt = new byr();
    locala.hvu = new bys();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.funcId = 2721;
    this.rr = locala.aAz();
    ((byr)this.rr.hvr.hvw).FnN = paramString;
    ac.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(97154);
  }
  
  public f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(97153);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new axq();
    ((b.a)localObject).hvu = new axr();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((b.a)localObject).funcId = 1337;
    this.rr = ((b.a)localObject).aAz();
    localObject = (axq)this.rr.hvr.hvw;
    ((axq)localObject).hOf = paramString1;
    ((axq)localObject).EPt = paramString2;
    ((axq)localObject).EPu = paramString3;
    ac.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
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
    ac.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " sceneType: " + getType());
    if (getType() == 1337) {
      this.jsonString = ((axr)((b)paramq).hvs.hvw).ELz;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(97157);
      return;
      if (getType() == 2721) {
        this.jsonString = ((bys)((b)paramq).hvs.hvw).FnO;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f
 * JD-Core Version:    0.7.0.1
 */