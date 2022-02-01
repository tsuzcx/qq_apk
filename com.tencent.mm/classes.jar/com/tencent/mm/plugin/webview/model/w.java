package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class w
  extends n
  implements k, a.b
{
  private final int AXm;
  public big AXn;
  private g gbr;
  public final com.tencent.mm.al.b rr;
  
  public w(big parambig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, com.tencent.mm.bx.b paramb, int paramInt1, LinkedList<bji> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(187890);
    ad.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.AXn = parambig;
    this.AXm = paramInt2;
    parambig = new b.a();
    parambig.gUU = new bit();
    parambig.gUV = new biu();
    parambig.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    parambig.funcId = 1096;
    parambig.reqCmdId = 0;
    parambig.respCmdId = 0;
    this.rr = parambig.atI();
    parambig = (bit)this.rr.gUS.gUX;
    parambig.url = paramString1;
    parambig.DFV = paramString2;
    parambig.dlB = paramString3;
    parambig.DFP = paramString4;
    parambig.cMo = paramString5;
    parambig.DFR = paramString6;
    parambig.signature = paramString7;
    parambig.DFS = paramString8;
    parambig.DFU = paramInt1;
    parambig.DFT = paramb;
    parambig.DFZ = paramLinkedList;
    AppMethodBeat.o(187890);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78908);
    ad.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int eiZ()
  {
    return this.AXm;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    ad.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */