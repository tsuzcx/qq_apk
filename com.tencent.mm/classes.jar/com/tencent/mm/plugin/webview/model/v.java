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
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends n
  implements k, a.b
{
  public a.a DSV;
  private final int DSX;
  private f gzH;
  private final com.tencent.mm.al.b rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(207935);
    ad.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.DSV = parama;
    this.DSX = paramInt;
    parama = new b.a();
    parama.hNM = new bqt();
    parama.hNN = new bqu();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.hNO = 0;
    parama.respCmdId = 0;
    this.rr = parama.aDC();
    parama = (bqt)this.rr.hNK.hNQ;
    parama.url = paramString1;
    parama.GKO = paramString2;
    parama.duW = paramString3;
    parama.GKI = paramString4;
    parama.cUM = paramString5;
    parama.GKK = paramString6;
    parama.signature = paramString7;
    parama.GKL = paramString8;
    parama.GKM = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    AppMethodBeat.o(207935);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78905);
    ad.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final int eNj()
  {
    return this.DSX;
  }
  
  public final bqu eQa()
  {
    if (this.rr == null) {
      return null;
    }
    return (bqu)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    ad.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */