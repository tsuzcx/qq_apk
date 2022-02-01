package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends p
  implements m
{
  private h callback;
  public String hTL;
  private c rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(97154);
    c.a locala = new c.a();
    locala.otE = new dvn();
    locala.otF = new dvo();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.funcId = 2721;
    this.rr = locala.bEF();
    ((dvn)c.b.b(this.rr.otB)).abbi = paramString;
    Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(97154);
  }
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(97153);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ckm();
    ((c.a)localObject).otF = new ckn();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((c.a)localObject).funcId = 1337;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ckm)c.b.b(this.rr.otB);
    ((ckm)localObject).oOI = paramString1;
    ((ckm)localObject).aasL = paramString2;
    ((ckm)localObject).aasM = paramString3;
    Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
    AppMethodBeat.o(97153);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(97156);
    this.callback = paramh;
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
      this.hTL = ((ckn)c.c.b(((c)params).otC)).aamk;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(97157);
      return;
      if (getType() == 2721) {
        this.hTL = ((dvo)c.c.b(((c)params).otC)).abbj;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.k
 * JD-Core Version:    0.7.0.1
 */