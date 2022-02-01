package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m, a.b
{
  public a.a PUk;
  private final int PUm;
  private i jQg;
  private final d rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243056);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.PUk = parama;
    this.PUm = paramInt1;
    parama = new d.a();
    parama.lBU = new cnb();
    parama.lBV = new cnc();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.lBW = 0;
    parama.respCmdId = 0;
    this.rr = parama.bgN();
    parama = (cnb)d.b.b(this.rr.lBR);
    parama.url = paramString1;
    parama.Tul = paramString2;
    parama.appid = paramString3;
    parama.Tug = paramString4;
    parama.fdH = paramString5;
    parama.Tuh = paramString6;
    parama.signature = paramString7;
    parama.Tui = paramString8;
    parama.Tuj = b.cU(paramArrayOfByte);
    parama.Tum = paramInt2;
    AppMethodBeat.o(243056);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78905);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final int gSo()
  {
    return this.PUm;
  }
  
  public final cnc gVu()
  {
    AppMethodBeat.i(243062);
    if (this.rr == null)
    {
      AppMethodBeat.o(243062);
      return null;
    }
    cnc localcnc = (cnc)d.c.b(this.rr.lBS);
    AppMethodBeat.o(243062);
    return localcnc;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */