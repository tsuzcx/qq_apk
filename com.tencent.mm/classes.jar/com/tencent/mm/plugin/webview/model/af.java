package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.sdk.platformtools.ab;

public final class af
  extends m
  implements k
{
  String appId;
  String ctV;
  private f eGj;
  final b rr;
  
  public af(String paramString1, String paramString2, bbf parambbf)
  {
    AppMethodBeat.i(6653);
    this.appId = paramString1;
    this.ctV = paramString2;
    paramString2 = new b.a();
    paramString2.fsX = new bbk();
    paramString2.fsY = new bbl();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.funcId = 1034;
    paramString2.reqCmdId = 0;
    paramString2.respCmdId = 0;
    this.rr = paramString2.ado();
    paramString2 = (bbk)this.rr.fsV.fta;
    paramString2.cwc = paramString1;
    paramString2.xqH = parambbf;
    AppMethodBeat.o(6653);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6655);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6655);
    return i;
  }
  
  public final int getType()
  {
    return 1034;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6654);
    ab.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.af
 * JD-Core Version:    0.7.0.1
 */