package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m, a.b
{
  public a.a IXT;
  private final int IXV;
  private i heq;
  private final d rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(210975);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.IXT = parama;
    this.IXV = paramInt;
    parama = new d.a();
    parama.iLN = new ceh();
    parama.iLO = new cei();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.iLP = 0;
    parama.respCmdId = 0;
    this.rr = parama.aXF();
    parama = (ceh)this.rr.iLK.iLR;
    parama.url = paramString1;
    parama.Mjy = paramString2;
    parama.dNI = paramString3;
    parama.Mjs = paramString4;
    parama.dmc = paramString5;
    parama.Mju = paramString6;
    parama.signature = paramString7;
    parama.Mjv = paramString8;
    parama.Mjw = b.cD(paramArrayOfByte);
    AppMethodBeat.o(210975);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78905);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final int fZu()
  {
    return this.IXV;
  }
  
  public final cei gcz()
  {
    if (this.rr == null) {
      return null;
    }
    return (cei)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */