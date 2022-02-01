package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae
  extends q
  implements m
{
  String appId;
  String fCM;
  private i jQg;
  final d rr;
  
  public ae(String paramString1, String paramString2, ctm paramctm)
  {
    AppMethodBeat.i(78937);
    this.appId = paramString1;
    this.fCM = paramString2;
    paramString2 = new d.a();
    paramString2.lBU = new ctr();
    paramString2.lBV = new cts();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.funcId = 1034;
    paramString2.lBW = 0;
    paramString2.respCmdId = 0;
    this.rr = paramString2.bgN();
    paramString2 = (ctr)d.b.b(this.rr.lBR);
    paramString2.appid = paramString1;
    paramString2.TBA = paramctm;
    AppMethodBeat.o(78937);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78939);
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78939);
    return i;
  }
  
  public final int getType()
  {
    return 1034;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78938);
    Log.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */