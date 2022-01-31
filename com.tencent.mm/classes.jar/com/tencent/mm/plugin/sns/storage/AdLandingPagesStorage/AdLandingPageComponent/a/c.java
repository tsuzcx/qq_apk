package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public String bTX;
  private b dmK;
  private f dmL;
  
  public c(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new azt();
    locala.ecI = new azu();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
    locala.ecG = 2721;
    this.dmK = locala.Kt();
    ((azt)this.dmK.ecE.ecN).tvQ = paramString;
    y.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:" + paramString);
  }
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new agb();
    ((b.a)localObject).ecI = new agc();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
    ((b.a)localObject).ecG = 1337;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (agb)this.dmK.ecE.ecN;
    ((agb)localObject).euK = paramString1;
    ((agb)localObject).tdS = paramString2;
    ((agb)localObject).tdT = paramString3;
    y.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + paramString2 + " sharedAppId :" + paramString1);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString + " sceneType: " + this.dmK.ecG);
    if (this.dmK.ecG == 1337) {
      this.bTX = ((agc)((b)paramq).ecF.ecN).tav;
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if (this.dmK.ecG == 2721) {
        this.bTX = ((azu)((b)paramq).ecF.ecN).tvR;
      }
    }
  }
  
  public final int getType()
  {
    return this.dmK.ecG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c
 * JD-Core Version:    0.7.0.1
 */