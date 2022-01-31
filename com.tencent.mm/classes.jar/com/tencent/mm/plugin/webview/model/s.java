package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.ark;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class s
  extends m
  implements k, c.b
{
  private f dIJ;
  public final com.tencent.mm.ah.b dmK;
  private final int rfv;
  public aqw rfw;
  
  public s(aqw paramaqw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, com.tencent.mm.bv.b paramb, int paramInt1, LinkedList<arx> paramLinkedList, int paramInt2)
  {
    y.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, Integer.valueOf(paramInt1) });
    this.rfw = paramaqw;
    this.rfv = paramInt2;
    paramaqw = new b.a();
    paramaqw.ecH = new arj();
    paramaqw.ecI = new ark();
    paramaqw.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    paramaqw.ecG = 1096;
    paramaqw.ecJ = 0;
    paramaqw.ecK = 0;
    this.dmK = paramaqw.Kt();
    paramaqw = (arj)this.dmK.ecE.ecN;
    paramaqw.url = paramString1;
    paramaqw.bOL = paramString2;
    paramaqw.tmz = paramString3;
    paramaqw.bIK = paramString4;
    paramaqw.tmB = paramString5;
    paramaqw.signature = paramString6;
    paramaqw.tmC = paramString7;
    paramaqw.tmE = paramInt1;
    paramaqw.tmD = paramb;
    paramaqw.tmI = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int cbK()
  {
    return this.rfv;
  }
  
  public final int getType()
  {
    return 1096;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.s
 * JD-Core Version:    0.7.0.1
 */