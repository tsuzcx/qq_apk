package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
  extends n
  implements k, a.b
{
  public a.a AXk;
  public String AXl;
  private final int AXm;
  private g gbr;
  private final com.tencent.mm.al.b rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(187887);
    ad.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.AXk = parama;
    this.AXl = paramString4;
    this.url = paramString1;
    this.AXm = paramInt2;
    parama = new b.a();
    parama.gUU = new bih();
    parama.gUV = new bii();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.atI();
    parama = (bih)this.rr.gUS.gUX;
    parama.url = paramString1;
    parama.DFV = paramString2;
    parama.fVC = paramString3;
    parama.DFP = paramString4;
    parama.cMo = paramString5;
    parama.DFR = paramString6;
    parama.signature = paramString7;
    parama.DFS = paramString8;
    parama.DFT = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    parama.DFU = paramInt1;
    parama.scope = paramString9;
    AppMethodBeat.o(187887);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78899);
    ad.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final int eiZ()
  {
    return this.AXm;
  }
  
  public final bih elJ()
  {
    if (this.rr == null) {
      return null;
    }
    return (bih)this.rr.gUS.gUX;
  }
  
  public final bii elK()
  {
    if (this.rr == null) {
      return null;
    }
    return (bii)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    ad.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */