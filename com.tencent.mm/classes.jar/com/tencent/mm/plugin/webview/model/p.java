package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends m
  implements k, c.b
{
  private f dIJ;
  private final com.tencent.mm.ah.b dmK;
  public c.a rft;
  public String rfu;
  private final int rfv;
  public String url;
  
  public p(c.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte[] paramArrayOfByte, int paramInt1, String paramString8, int paramInt2)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, Integer.valueOf(paramInt1), paramString8 });
    this.rft = parama;
    this.rfu = paramString3;
    this.url = paramString1;
    this.rfv = paramInt2;
    parama = new b.a();
    parama.ecH = new aqx();
    parama.ecI = new aqy();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.ecG = 1095;
    parama.ecJ = 0;
    parama.ecK = 0;
    this.dmK = parama.Kt();
    parama = (aqx)this.dmK.ecE.ecN;
    parama.url = paramString1;
    parama.kRX = paramString2;
    parama.tmz = paramString3;
    parama.bIK = paramString4;
    parama.tmB = paramString5;
    parama.signature = paramString6;
    parama.tmC = paramString7;
    parama.tmD = com.tencent.mm.bv.b.bk(paramArrayOfByte);
    parama.tmE = paramInt1;
    parama.scope = paramString8;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final aqx cbI()
  {
    if (this.dmK == null) {
      return null;
    }
    return (aqx)this.dmK.ecE.ecN;
  }
  
  public final aqy cbJ()
  {
    if (this.dmK == null) {
      return null;
    }
    return (aqy)this.dmK.ecF.ecN;
  }
  
  public final int cbK()
  {
    return this.rfv;
  }
  
  public final int getType()
  {
    return 1095;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.p
 * JD-Core Version:    0.7.0.1
 */