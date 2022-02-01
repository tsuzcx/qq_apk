package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.sdk.platformtools.ae;

public final class t
  extends n
  implements k, a.b
{
  public a.a EkV;
  public String EkW;
  private final int EkX;
  private f gCo;
  private final com.tencent.mm.ak.b rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(198113);
    ae.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.EkV = parama;
    this.EkW = paramString4;
    this.url = paramString1;
    this.EkX = paramInt2;
    parama = new b.a();
    parama.hQF = new brd();
    parama.hQG = new bre();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.hQH = 0;
    parama.respCmdId = 0;
    this.rr = parama.aDS();
    parama = (brd)this.rr.hQD.hQJ;
    parama.url = paramString1;
    parama.Hep = paramString2;
    parama.gvv = paramString3;
    parama.Hej = paramString4;
    parama.cVJ = paramString5;
    parama.Hel = paramString6;
    parama.signature = paramString7;
    parama.Hem = paramString8;
    parama.Hen = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    parama.Heo = paramInt1;
    parama.scope = paramString9;
    AppMethodBeat.o(198113);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78899);
    ae.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final int eQU()
  {
    return this.EkX;
  }
  
  public final brd eTJ()
  {
    if (this.rr == null) {
      return null;
    }
    return (brd)this.rr.hQD.hQJ;
  }
  
  public final bre eTK()
  {
    if (this.rr == null) {
      return null;
    }
    return (bre)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    ae.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */