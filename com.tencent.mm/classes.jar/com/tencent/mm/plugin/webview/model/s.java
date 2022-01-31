package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k, c.b
{
  private f eGj;
  private final com.tencent.mm.ai.b rr;
  public c.a uVF;
  public String uVG;
  private final int uVH;
  public String url;
  
  public s(c.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte[] paramArrayOfByte, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(6613);
    ab.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, Integer.valueOf(paramInt1), paramString8 });
    this.uVF = parama;
    this.uVG = paramString3;
    this.url = paramString1;
    this.uVH = paramInt2;
    parama = new b.a();
    parama.fsX = new axc();
    parama.fsY = new axd();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.ado();
    parama = (axc)this.rr.fsV.fta;
    parama.url = paramString1;
    parama.npZ = paramString2;
    parama.xmo = paramString3;
    parama.cqf = paramString4;
    parama.xmq = paramString5;
    parama.signature = paramString6;
    parama.xmr = paramString7;
    parama.xms = com.tencent.mm.bv.b.bL(paramArrayOfByte);
    parama.xmt = paramInt1;
    parama.scope = paramString8;
    AppMethodBeat.o(6613);
  }
  
  public final axc dbL()
  {
    if (this.rr == null) {
      return null;
    }
    return (axc)this.rr.fsV.fta;
  }
  
  public final axd dbM()
  {
    if (this.rr == null) {
      return null;
    }
    return (axd)this.rr.fsW.fta;
  }
  
  public final int dbN()
  {
    return this.uVH;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6615);
    ab.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6615);
    return i;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6614);
    ab.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.s
 * JD-Core Version:    0.7.0.1
 */