package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
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
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class u
  extends n
  implements k, a.b
{
  public a.a EkV;
  private final int EkX;
  private f gCo;
  public String mzb;
  public final b rr;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(198114);
    ae.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.EkV = parama;
    this.mzb = paramString1;
    this.EkX = paramInt2;
    parama = new b.a();
    parama.hQF = new brl();
    parama.hQG = new brm();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.hQH = 0;
    parama.respCmdId = 0;
    this.rr = parama.aDS();
    parama = (brl)this.rr.hQD.hQJ;
    parama.url = paramString1;
    parama.Hep = paramString2;
    parama.dwb = paramString3;
    parama.HeE = paramLinkedList1;
    parama.HeG = paramLinkedList2;
    parama.cVJ = paramString4;
    parama.Hel = paramString5;
    parama.signature = paramString6;
    parama.Hem = paramString7;
    parama.scene = paramInt1;
    parama.HeF = paramString8;
    AppMethodBeat.o(198114);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78902);
    ae.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final int eQU()
  {
    return this.EkX;
  }
  
  public final brm eTL()
  {
    if (this.rr == null) {
      return null;
    }
    return (brm)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    ae.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */