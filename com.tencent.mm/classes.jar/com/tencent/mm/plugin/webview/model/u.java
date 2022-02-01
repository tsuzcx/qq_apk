package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class u
  extends n
  implements k, a.b
{
  public a.a DSV;
  private final int DSX;
  private f gzH;
  public String mue;
  public final b rr;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(207934);
    ad.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.DSV = parama;
    this.mue = paramString1;
    this.DSX = paramInt2;
    parama = new b.a();
    parama.hNM = new bqr();
    parama.hNN = new bqs();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.hNO = 0;
    parama.respCmdId = 0;
    this.rr = parama.aDC();
    parama = (bqr)this.rr.hNK.hNQ;
    parama.url = paramString1;
    parama.GKO = paramString2;
    parama.duW = paramString3;
    parama.GLd = paramLinkedList1;
    parama.GLf = paramLinkedList2;
    parama.cUM = paramString4;
    parama.GKK = paramString5;
    parama.signature = paramString6;
    parama.GKL = paramString7;
    parama.scene = paramInt1;
    parama.GLe = paramString8;
    AppMethodBeat.o(207934);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78902);
    ad.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final int eNj()
  {
    return this.DSX;
  }
  
  public final bqs ePZ()
  {
    if (this.rr == null) {
      return null;
    }
    return (bqs)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    ad.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */