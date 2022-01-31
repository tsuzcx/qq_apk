package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public String oJN = "";
  
  public b(String paramString)
  {
    this.oJN = paramString;
    b.a locala = new b.a();
    locala.ecH = new yf();
    locala.ecI = new yg();
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
    locala.ecG = 2874;
    this.dmK = locala.Kt();
    ((yf)this.dmK.ecE.ecN).sWV = paramString;
    y.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", new Object[] { paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2874;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b
 * JD-Core Version:    0.7.0.1
 */