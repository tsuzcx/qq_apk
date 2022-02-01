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
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends p
  implements m, a.b
{
  public a.a WKW;
  public String WKX;
  private final int WKY;
  private h mAY;
  private final c rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(298395);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.WKW = parama;
    this.WKX = paramString4;
    this.url = paramString1;
    this.WKY = paramInt2;
    parama = new c.a();
    parama.otE = new ddf();
    parama.otF = new ddg();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.otG = 0;
    parama.respCmdId = 0;
    this.rr = parama.bEF();
    parama = (ddf)c.b.b(this.rr.otB);
    parama.url = paramString1;
    parama.aaIP = paramString2;
    parama.muA = paramString3;
    parama.aaIK = paramString4;
    parama.hhx = paramString5;
    parama.aaIL = paramString6;
    parama.signature = paramString7;
    parama.aaIM = paramString8;
    parama.aaIN = b.cX(paramArrayOfByte);
    parama.aaIO = paramInt1;
    parama.scope = paramString9;
    parama.aaIQ = paramInt3;
    AppMethodBeat.o(298395);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78899);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final int irL()
  {
    return this.WKY;
  }
  
  public final ddf ivc()
  {
    AppMethodBeat.i(298401);
    if (this.rr == null)
    {
      AppMethodBeat.o(298401);
      return null;
    }
    ddf localddf = (ddf)c.b.b(this.rr.otB);
    AppMethodBeat.o(298401);
    return localddf;
  }
  
  public final ddg ivd()
  {
    AppMethodBeat.i(298405);
    if (this.rr == null)
    {
      AppMethodBeat.o(298405);
      return null;
    }
    ddg localddg = (ddg)c.c.b(this.rr.otC);
    AppMethodBeat.o(298405);
    return localddg;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */