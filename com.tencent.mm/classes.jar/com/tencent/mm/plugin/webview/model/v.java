package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.sdk.platformtools.ae;

public final class v
  extends n
  implements k, a.b
{
  public a.a EkV;
  private final int EkX;
  private f gCo;
  private final com.tencent.mm.ak.b rr;
  
  public v(a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(198115);
    ae.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8 });
    this.EkV = parama;
    this.EkX = paramInt;
    parama = new b.a();
    parama.hQF = new brn();
    parama.hQG = new bro();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
    parama.funcId = 1094;
    parama.hQH = 0;
    parama.respCmdId = 0;
    this.rr = parama.aDS();
    parama = (brn)this.rr.hQD.hQJ;
    parama.url = paramString1;
    parama.Hep = paramString2;
    parama.dwb = paramString3;
    parama.Hej = paramString4;
    parama.cVJ = paramString5;
    parama.Hel = paramString6;
    parama.signature = paramString7;
    parama.Hem = paramString8;
    parama.Hen = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    AppMethodBeat.o(198115);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78905);
    ae.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78905);
    return i;
  }
  
  public final int eQU()
  {
    return this.EkX;
  }
  
  public final bro eTM()
  {
    if (this.rr == null) {
      return null;
    }
    return (bro)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1094;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78904);
    ae.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */