package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
  extends n
  implements k, a.b
{
  public a.a DSV;
  public String DSW;
  private final int DSX;
  private f gzH;
  private final com.tencent.mm.al.b rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(207933);
    ad.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.DSV = parama;
    this.DSW = paramString4;
    this.url = paramString1;
    this.DSX = paramInt2;
    parama = new b.a();
    parama.hNM = new bqj();
    parama.hNN = new bqk();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.hNO = 0;
    parama.respCmdId = 0;
    this.rr = parama.aDC();
    parama = (bqj)this.rr.hNK.hNQ;
    parama.url = paramString1;
    parama.GKO = paramString2;
    parama.gsT = paramString3;
    parama.GKI = paramString4;
    parama.cUM = paramString5;
    parama.GKK = paramString6;
    parama.signature = paramString7;
    parama.GKL = paramString8;
    parama.GKM = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    parama.GKN = paramInt1;
    parama.scope = paramString9;
    AppMethodBeat.o(207933);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78899);
    ad.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final int eNj()
  {
    return this.DSX;
  }
  
  public final bqj ePX()
  {
    if (this.rr == null) {
      return null;
    }
    return (bqj)this.rr.hNK.hNQ;
  }
  
  public final bqk ePY()
  {
    if (this.rr == null) {
      return null;
    }
    return (bqk)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    ad.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */