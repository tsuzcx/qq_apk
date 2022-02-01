package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class w
  extends q
  implements m, a.b
{
  private final int IXV;
  public cdw IXW;
  private i heq;
  public final d rr;
  
  public w(cdw paramcdw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, b paramb, int paramInt1, LinkedList<cey> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(210976);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.IXW = paramcdw;
    this.IXV = paramInt2;
    paramcdw = new d.a();
    paramcdw.iLN = new cej();
    paramcdw.iLO = new cek();
    paramcdw.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    paramcdw.funcId = 1096;
    paramcdw.iLP = 0;
    paramcdw.respCmdId = 0;
    this.rr = paramcdw.aXF();
    paramcdw = (cej)this.rr.iLK.iLR;
    paramcdw.url = paramString1;
    paramcdw.Mjy = paramString2;
    paramcdw.dNI = paramString3;
    paramcdw.Mjs = paramString4;
    paramcdw.dmc = paramString5;
    paramcdw.Mju = paramString6;
    paramcdw.signature = paramString7;
    paramcdw.Mjv = paramString8;
    paramcdw.Mjx = paramInt1;
    paramcdw.Mjw = paramb;
    paramcdw.MjC = paramLinkedList;
    AppMethodBeat.o(210976);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78908);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int fZu()
  {
    return this.IXV;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */