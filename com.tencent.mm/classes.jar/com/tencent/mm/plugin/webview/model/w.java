package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class w
  extends q
  implements m, a.b
{
  private final int PUm;
  public cmq PUn;
  private i jQg;
  public final d rr;
  
  public w(cmq paramcmq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, b paramb, int paramInt1, LinkedList<cns> paramLinkedList, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221738);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.PUn = paramcmq;
    this.PUm = paramInt2;
    paramcmq = new d.a();
    paramcmq.lBU = new cnd();
    paramcmq.lBV = new cne();
    paramcmq.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    paramcmq.funcId = 1096;
    paramcmq.lBW = 0;
    paramcmq.respCmdId = 0;
    this.rr = paramcmq.bgN();
    paramcmq = (cnd)d.b.b(this.rr.lBR);
    paramcmq.url = paramString1;
    paramcmq.Tul = paramString2;
    paramcmq.appid = paramString3;
    paramcmq.Tug = paramString4;
    paramcmq.fdH = paramString5;
    paramcmq.Tuh = paramString6;
    paramcmq.signature = paramString7;
    paramcmq.Tui = paramString8;
    paramcmq.Tuk = paramInt1;
    paramcmq.Tuj = paramb;
    paramcmq.Tuq = paramLinkedList;
    paramcmq.Tum = paramInt3;
    AppMethodBeat.o(221738);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78908);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int gSo()
  {
    return this.PUm;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */