package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae
  extends p
  implements m
{
  String appId;
  String hHB;
  private h mAY;
  final c rr;
  
  public ae(String paramString1, String paramString2, dko paramdko)
  {
    AppMethodBeat.i(78937);
    this.appId = paramString1;
    this.hHB = paramString2;
    paramString2 = new c.a();
    paramString2.otE = new dkt();
    paramString2.otF = new dku();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.funcId = 1034;
    paramString2.otG = 0;
    paramString2.respCmdId = 0;
    this.rr = paramString2.bEF();
    paramString2 = (dkt)c.b.b(this.rr.otB);
    paramString2.appid = paramString1;
    paramString2.aaQO = paramdko;
    AppMethodBeat.o(78937);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78939);
    this.mAY = paramh;
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
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */