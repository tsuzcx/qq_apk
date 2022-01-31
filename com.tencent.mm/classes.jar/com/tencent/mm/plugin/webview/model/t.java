package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
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
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class t
  extends m
  implements k, c.b
{
  private f eGj;
  public String iIg;
  public final b rr;
  public c.a uVF;
  private final int uVH;
  
  public t(c.a parama, String paramString1, String paramString2, LinkedList<String> paramLinkedList, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2)
  {
    AppMethodBeat.i(6616);
    ab.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
    this.uVF = parama;
    this.iIg = paramString1;
    this.uVH = paramInt2;
    parama = new b.a();
    parama.fsX = new axk();
    parama.fsY = new axl();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.ado();
    parama = (axk)this.rr.fsV.fta;
    parama.url = paramString1;
    parama.cwc = paramString2;
    parama.xmI = paramLinkedList;
    parama.cqf = paramString3;
    parama.xmq = paramString4;
    parama.signature = paramString5;
    parama.xmr = paramString6;
    parama.scene = paramInt1;
    parama.xmJ = paramString7;
    AppMethodBeat.o(6616);
  }
  
  public final int dbN()
  {
    return this.uVH;
  }
  
  public final axl dbO()
  {
    if (this.rr == null) {
      return null;
    }
    return (axl)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6618);
    ab.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6618);
    return i;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6617);
    ab.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */