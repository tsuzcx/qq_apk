package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class w
  extends n
  implements k, a.b
{
  private final int EkX;
  public brc EkY;
  private f gCo;
  public final com.tencent.mm.ak.b rr;
  
  public w(brc parambrc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, com.tencent.mm.bw.b paramb, int paramInt1, LinkedList<bse> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(198116);
    ae.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.EkY = parambrc;
    this.EkX = paramInt2;
    parambrc = new b.a();
    parambrc.hQF = new brp();
    parambrc.hQG = new brq();
    parambrc.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    parambrc.funcId = 1096;
    parambrc.hQH = 0;
    parambrc.respCmdId = 0;
    this.rr = parambrc.aDS();
    parambrc = (brp)this.rr.hQD.hQJ;
    parambrc.url = paramString1;
    parambrc.Hep = paramString2;
    parambrc.dwb = paramString3;
    parambrc.Hej = paramString4;
    parambrc.cVJ = paramString5;
    parambrc.Hel = paramString6;
    parambrc.signature = paramString7;
    parambrc.Hem = paramString8;
    parambrc.Heo = paramInt1;
    parambrc.Hen = paramb;
    parambrc.Het = paramLinkedList;
    AppMethodBeat.o(198116);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78908);
    ae.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int eQU()
  {
    return this.EkX;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    ae.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */