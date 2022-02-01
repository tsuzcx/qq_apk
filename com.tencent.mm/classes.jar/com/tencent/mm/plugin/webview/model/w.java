package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class w
  extends n
  implements k, a.b
{
  public bly CpA;
  private final int Cpz;
  private g gfX;
  public final com.tencent.mm.ak.b rr;
  
  public w(bly parambly, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, com.tencent.mm.bw.b paramb, int paramInt1, LinkedList<bna> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(188317);
    ac.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.CpA = parambly;
    this.Cpz = paramInt2;
    parambly = new b.a();
    parambly.hvt = new bml();
    parambly.hvu = new bmm();
    parambly.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    parambly.funcId = 1096;
    parambly.reqCmdId = 0;
    parambly.respCmdId = 0;
    this.rr = parambly.aAz();
    parambly = (bml)this.rr.hvr.hvw;
    parambly.url = paramString1;
    parambly.Fbp = paramString2;
    parambly.djj = paramString3;
    parambly.Fbj = paramString4;
    parambly.cJz = paramString5;
    parambly.Fbl = paramString6;
    parambly.signature = paramString7;
    parambly.Fbm = paramString8;
    parambly.Fbo = paramInt1;
    parambly.Fbn = paramb;
    parambly.Fbt = paramLinkedList;
    AppMethodBeat.o(188317);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78908);
    ac.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int eyt()
  {
    return this.Cpz;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    ac.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */