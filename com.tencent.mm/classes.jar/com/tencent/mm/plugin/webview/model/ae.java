package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.protocal.protobuf.bxh;

public final class ae
  extends n
  implements k
{
  String appId;
  String dsN;
  private f gCo;
  final b rr;
  
  public ae(String paramString1, String paramString2, bxb parambxb)
  {
    AppMethodBeat.i(78937);
    this.appId = paramString1;
    this.dsN = paramString2;
    paramString2 = new b.a();
    paramString2.hQF = new bxg();
    paramString2.hQG = new bxh();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.funcId = 1034;
    paramString2.hQH = 0;
    paramString2.respCmdId = 0;
    this.rr = paramString2.aDS();
    paramString2 = (bxg)this.rr.hQD.hQJ;
    paramString2.dwb = paramString1;
    paramString2.Hkj = parambxb;
    AppMethodBeat.o(78937);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78939);
    this.gCo = paramf;
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ae
 * JD-Core Version:    0.7.0.1
 */