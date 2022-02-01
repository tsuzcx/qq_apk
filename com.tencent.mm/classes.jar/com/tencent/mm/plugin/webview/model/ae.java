package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae
  extends q
  implements m
{
  String appId;
  String dJX;
  private i heq;
  final d rr;
  
  public ae(String paramString1, String paramString2, ckt paramckt)
  {
    AppMethodBeat.i(78937);
    this.appId = paramString1;
    this.dJX = paramString2;
    paramString2 = new d.a();
    paramString2.iLN = new cky();
    paramString2.iLO = new ckz();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.funcId = 1034;
    paramString2.iLP = 0;
    paramString2.respCmdId = 0;
    this.rr = paramString2.aXF();
    paramString2 = (cky)this.rr.iLK.iLR;
    paramString2.dNI = paramString1;
    paramString2.Mqx = paramckt;
    AppMethodBeat.o(78937);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78939);
    this.heq = parami;
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
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */