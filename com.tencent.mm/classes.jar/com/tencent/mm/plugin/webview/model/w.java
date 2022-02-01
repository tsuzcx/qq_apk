package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.protocal.protobuf.ddw;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class w
  extends p
  implements m, a.b
{
  private final int WKY;
  public dde WKZ;
  private h mAY;
  public final c rr;
  
  public w(dde paramdde, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, b paramb, int paramInt1, LinkedList<dek> paramLinkedList, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(298407);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.WKZ = paramdde;
    this.WKY = paramInt2;
    paramdde = new c.a();
    paramdde.otE = new ddv();
    paramdde.otF = new ddw();
    paramdde.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    paramdde.funcId = 1096;
    paramdde.otG = 0;
    paramdde.respCmdId = 0;
    this.rr = paramdde.bEF();
    paramdde = (ddv)c.b.b(this.rr.otB);
    paramdde.url = paramString1;
    paramdde.aaIP = paramString2;
    paramdde.appid = paramString3;
    paramdde.aaIK = paramString4;
    paramdde.hhx = paramString5;
    paramdde.aaIL = paramString6;
    paramdde.signature = paramString7;
    paramdde.aaIM = paramString8;
    paramdde.aaIO = paramInt1;
    paramdde.aaIN = paramb;
    paramdde.aaIU = paramLinkedList;
    paramdde.aaIQ = paramInt3;
    AppMethodBeat.o(298407);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78908);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final int irL()
  {
    return this.WKY;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */