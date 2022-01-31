package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class v
  extends m
  implements k, c.b
{
  private f eGj;
  public final com.tencent.mm.ai.b rr;
  private final int uVH;
  public axb uVI;
  
  public v(axb paramaxb, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, com.tencent.mm.bv.b paramb, int paramInt1, LinkedList<ayc> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(6622);
    ab.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, Integer.valueOf(paramInt1) });
    this.uVI = paramaxb;
    this.uVH = paramInt2;
    paramaxb = new b.a();
    paramaxb.fsX = new axo();
    paramaxb.fsY = new axp();
    paramaxb.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    paramaxb.funcId = 1096;
    paramaxb.reqCmdId = 0;
    paramaxb.respCmdId = 0;
    this.rr = paramaxb.ado();
    paramaxb = (axo)this.rr.fsV.fta;
    paramaxb.url = paramString1;
    paramaxb.cwc = paramString2;
    paramaxb.xmo = paramString3;
    paramaxb.cqf = paramString4;
    paramaxb.xmq = paramString5;
    paramaxb.signature = paramString6;
    paramaxb.xmr = paramString7;
    paramaxb.xmt = paramInt1;
    paramaxb.xms = paramb;
    paramaxb.xmx = paramLinkedList;
    AppMethodBeat.o(6622);
  }
  
  public final int dbN()
  {
    return this.uVH;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6624);
    ab.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6624);
    return i;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6623);
    ab.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */