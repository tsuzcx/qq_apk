package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.sdk.platformtools.ac;

public final class t
  extends n
  implements k, a.b
{
  public a.a Cpx;
  public String Cpy;
  private final int Cpz;
  private g gfX;
  private final com.tencent.mm.ak.b rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(188314);
    ac.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.Cpx = parama;
    this.Cpy = paramString4;
    this.url = paramString1;
    this.Cpz = paramInt2;
    parama = new b.a();
    parama.hvt = new blz();
    parama.hvu = new bma();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.aAz();
    parama = (blz)this.rr.hvr.hvw;
    parama.url = paramString1;
    parama.Fbp = paramString2;
    parama.fZx = paramString3;
    parama.Fbj = paramString4;
    parama.cJz = paramString5;
    parama.Fbl = paramString6;
    parama.signature = paramString7;
    parama.Fbm = paramString8;
    parama.Fbn = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    parama.Fbo = paramInt1;
    parama.scope = paramString9;
    AppMethodBeat.o(188314);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78899);
    ac.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final blz eBf()
  {
    if (this.rr == null) {
      return null;
    }
    return (blz)this.rr.hvr.hvw;
  }
  
  public final bma eBg()
  {
    if (this.rr == null) {
      return null;
    }
    return (bma)this.rr.hvs.hvw;
  }
  
  public final int eyt()
  {
    return this.Cpz;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    ac.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */