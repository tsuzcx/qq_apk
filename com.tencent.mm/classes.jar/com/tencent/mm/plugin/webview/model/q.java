package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class q
  extends m
  implements k, c.b
{
  private f dIJ;
  public final b dmK;
  public String gZO;
  public c.a rft;
  private final int rfv;
  
  public q(c.a parama, String paramString1, String paramString2, LinkedList<String> paramLinkedList, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
    this.rft = parama;
    this.gZO = paramString1;
    this.rfv = paramInt2;
    parama = new b.a();
    parama.ecH = new arf();
    parama.ecI = new arg();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.ecG = 1093;
    parama.ecJ = 0;
    parama.ecK = 0;
    this.dmK = parama.Kt();
    parama = (arf)this.dmK.ecE.ecN;
    parama.url = paramString1;
    parama.bOL = paramString2;
    parama.tmR = paramLinkedList;
    parama.bIK = paramString3;
    parama.tmB = paramString4;
    parama.signature = paramString5;
    parama.tmC = paramString6;
    parama.scene = paramInt1;
    parama.tmS = paramString7;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int cbK()
  {
    return this.rfv;
  }
  
  public final arg cbL()
  {
    if (this.dmK == null) {
      return null;
    }
    return (arg)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 1093;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.q
 * JD-Core Version:    0.7.0.1
 */