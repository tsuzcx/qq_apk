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
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.sdk.platformtools.y;

public final class r
  extends m
  implements k, c.b
{
  private f dIJ;
  private final com.tencent.mm.ah.b dmK;
  public c.a rft;
  private final int rfv;
  
  public r(c.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte[] paramArrayOfByte, int paramInt)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.rft = parama;
    this.rfv = paramInt;
    parama = new b.a();
    parama.ecH = new arh();
    parama.ecI = new ari();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.ecG = 1094;
    parama.ecJ = 0;
    parama.ecK = 0;
    this.dmK = parama.Kt();
    parama = (arh)this.dmK.ecE.ecN;
    parama.url = paramString1;
    parama.bOL = paramString2;
    parama.tmz = paramString3;
    parama.bIK = paramString4;
    parama.tmB = paramString5;
    parama.signature = paramString6;
    parama.tmC = paramString7;
    parama.tmD = com.tencent.mm.bv.b.bk(paramArrayOfByte);
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int cbK()
  {
    return this.rfv;
  }
  
  public final ari cbM()
  {
    if (this.dmK == null) {
      return null;
    }
    return (ari)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 1094;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.r
 * JD-Core Version:    0.7.0.1
 */