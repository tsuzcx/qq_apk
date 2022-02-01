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
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.platformtools.ac;

public final class v
  extends n
  implements k, a.b
{
  public a.a Cpx;
  private final int Cpz;
  private g gfX;
  private final com.tencent.mm.ak.b rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(188316);
    ac.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.Cpx = parama;
    this.Cpz = paramInt;
    parama = new b.a();
    parama.hvt = new bmj();
    parama.hvu = new bmk();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.aAz();
    parama = (bmj)this.rr.hvr.hvw;
    parama.url = paramString1;
    parama.Fbp = paramString2;
    parama.djj = paramString3;
    parama.Fbj = paramString4;
    parama.cJz = paramString5;
    parama.Fbl = paramString6;
    parama.signature = paramString7;
    parama.Fbm = paramString8;
    parama.Fbn = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    AppMethodBeat.o(188316);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78905);
    ac.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final bmk eBi()
  {
    if (this.rr == null) {
      return null;
    }
    return (bmk)this.rr.hvs.hvw;
  }
  
  public final int eyt()
  {
    return this.Cpz;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    ac.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */