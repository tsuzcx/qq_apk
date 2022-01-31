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
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
  extends m
  implements k, c.b
{
  private f eGj;
  private final com.tencent.mm.ai.b rr;
  public c.a uVF;
  private final int uVH;
  
  public u(c.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(6619);
    ab.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.uVF = parama;
    this.uVH = paramInt;
    parama = new b.a();
    parama.fsX = new axm();
    parama.fsY = new axn();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.ado();
    parama = (axm)this.rr.fsV.fta;
    parama.url = paramString1;
    parama.cwc = paramString2;
    parama.xmo = paramString3;
    parama.cqf = paramString4;
    parama.xmq = paramString5;
    parama.signature = paramString6;
    parama.xmr = paramString7;
    parama.xms = com.tencent.mm.bv.b.bL(paramArrayOfByte);
    AppMethodBeat.o(6619);
  }
  
  public final int dbN()
  {
    return this.uVH;
  }
  
  public final axn dbP()
  {
    if (this.rr == null) {
      return null;
    }
    return (axn)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6621);
    ab.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6621);
    return i;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6620);
    ab.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */