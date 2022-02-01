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
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends n
  implements k, a.b
{
  public a.a AXk;
  private final int AXm;
  private g gbr;
  private final com.tencent.mm.al.b rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(187889);
    ad.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.AXk = parama;
    this.AXm = paramInt;
    parama = new b.a();
    parama.gUU = new bir();
    parama.gUV = new bis();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.atI();
    parama = (bir)this.rr.gUS.gUX;
    parama.url = paramString1;
    parama.DFV = paramString2;
    parama.dlB = paramString3;
    parama.DFP = paramString4;
    parama.cMo = paramString5;
    parama.DFR = paramString6;
    parama.signature = paramString7;
    parama.DFS = paramString8;
    parama.DFT = com.tencent.mm.bx.b.cd(paramArrayOfByte);
    AppMethodBeat.o(187889);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78905);
    ad.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final int eiZ()
  {
    return this.AXm;
  }
  
  public final bis elM()
  {
    if (this.rr == null) {
      return null;
    }
    return (bis)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    ad.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */