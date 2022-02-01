package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends p
  implements m, a.b
{
  public a.a WKW;
  private final int WKY;
  private h mAY;
  private final c rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(298403);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.WKW = parama;
    this.WKY = paramInt1;
    parama = new c.a();
    parama.otE = new ddt();
    parama.otF = new ddu();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.otG = 0;
    parama.respCmdId = 0;
    this.rr = parama.bEF();
    parama = (ddt)c.b.b(this.rr.otB);
    parama.url = paramString1;
    parama.aaIP = paramString2;
    parama.appid = paramString3;
    parama.aaIK = paramString4;
    parama.hhx = paramString5;
    parama.aaIL = paramString6;
    parama.signature = paramString7;
    parama.aaIM = paramString8;
    parama.aaIN = b.cX(paramArrayOfByte);
    parama.aaIQ = paramInt2;
    AppMethodBeat.o(298403);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78905);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final int irL()
  {
    return this.WKY;
  }
  
  public final ddu ivf()
  {
    AppMethodBeat.i(298408);
    if (this.rr == null)
    {
      AppMethodBeat.o(298408);
      return null;
    }
    ddu localddu = (ddu)c.c.b(this.rr.otC);
    AppMethodBeat.o(298408);
    return localddu;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */