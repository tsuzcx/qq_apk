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
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends q
  implements m, a.b
{
  public a.a IXT;
  public String IXU;
  private final int IXV;
  private i heq;
  private final d rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2)
  {
    AppMethodBeat.i(210973);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.IXT = parama;
    this.IXU = paramString4;
    this.url = paramString1;
    this.IXV = paramInt2;
    parama = new d.a();
    parama.iLN = new cdx();
    parama.iLO = new cdy();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.iLP = 0;
    parama.respCmdId = 0;
    this.rr = parama.aXF();
    parama = (cdx)this.rr.iLK.iLR;
    parama.url = paramString1;
    parama.Mjy = paramString2;
    parama.hik = paramString3;
    parama.Mjs = paramString4;
    parama.dmc = paramString5;
    parama.Mju = paramString6;
    parama.signature = paramString7;
    parama.Mjv = paramString8;
    parama.Mjw = b.cD(paramArrayOfByte);
    parama.Mjx = paramInt1;
    parama.scope = paramString9;
    AppMethodBeat.o(210973);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78899);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final int fZu()
  {
    return this.IXV;
  }
  
  public final cdx gcw()
  {
    if (this.rr == null) {
      return null;
    }
    return (cdx)this.rr.iLK.iLR;
  }
  
  public final cdy gcx()
  {
    if (this.rr == null) {
      return null;
    }
    return (cdy)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */