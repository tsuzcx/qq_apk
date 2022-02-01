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
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends q
  implements m, a.b
{
  public a.a PUk;
  public String PUl;
  private final int PUm;
  private i jQg;
  private final d rr;
  public String url;
  
  public t(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt1, String paramString9, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(265494);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), paramString9 });
    this.PUk = parama;
    this.PUl = paramString4;
    this.url = paramString1;
    this.PUm = paramInt2;
    parama = new d.a();
    parama.lBU = new cmr();
    parama.lBV = new cms();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
    parama.funcId = 1095;
    parama.lBW = 0;
    parama.respCmdId = 0;
    this.rr = parama.bgN();
    parama = (cmr)d.b.b(this.rr.lBR);
    parama.url = paramString1;
    parama.Tul = paramString2;
    parama.jUi = paramString3;
    parama.Tug = paramString4;
    parama.fdH = paramString5;
    parama.Tuh = paramString6;
    parama.signature = paramString7;
    parama.Tui = paramString8;
    parama.Tuj = b.cU(paramArrayOfByte);
    parama.Tuk = paramInt1;
    parama.scope = paramString9;
    parama.Tum = paramInt3;
    AppMethodBeat.o(265494);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78899);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78899);
    return i;
  }
  
  public final int gSo()
  {
    return this.PUm;
  }
  
  public final cmr gVr()
  {
    AppMethodBeat.i(265495);
    if (this.rr == null)
    {
      AppMethodBeat.o(265495);
      return null;
    }
    cmr localcmr = (cmr)d.b.b(this.rr.lBR);
    AppMethodBeat.o(265495);
    return localcmr;
  }
  
  public final cms gVs()
  {
    AppMethodBeat.i(265496);
    if (this.rr == null)
    {
      AppMethodBeat.o(265496);
      return null;
    }
    cms localcms = (cms)d.c.b(this.rr.lBS);
    AppMethodBeat.o(265496);
    return localcms;
  }
  
  public final int getType()
  {
    return 1095;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78898);
    Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.t
 * JD-Core Version:    0.7.0.1
 */