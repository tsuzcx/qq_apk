package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.sdk.platformtools.ac;

public final class ae
  extends n
  implements k
{
  String appId;
  String dgl;
  private g gfX;
  final b rr;
  
  public ae(String paramString1, String paramString2, bru parambru)
  {
    AppMethodBeat.i(78937);
    this.appId = paramString1;
    this.dgl = paramString2;
    paramString2 = new b.a();
    paramString2.hvt = new brz();
    paramString2.hvu = new bsa();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.funcId = 1034;
    paramString2.reqCmdId = 0;
    paramString2.respCmdId = 0;
    this.rr = paramString2.aAz();
    paramString2 = (brz)this.rr.hvr.hvw;
    paramString2.djj = paramString1;
    paramString2.Fhg = parambru;
    AppMethodBeat.o(78937);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78939);
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78939);
    return i;
  }
  
  public final int getType()
  {
    return 1034;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78938);
    ac.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */