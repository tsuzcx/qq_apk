package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class u
  extends n
  implements k, a.b
{
  public a.a AXk;
  private final int AXm;
  private g gbr;
  public String lst;
  public final b rr;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(187888);
    ad.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.AXk = parama;
    this.lst = paramString1;
    this.AXm = paramInt2;
    parama = new b.a();
    parama.gUU = new bip();
    parama.gUV = new biq();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.atI();
    parama = (bip)this.rr.gUS.gUX;
    parama.url = paramString1;
    parama.DFV = paramString2;
    parama.dlB = paramString3;
    parama.DGk = paramLinkedList1;
    parama.DGm = paramLinkedList2;
    parama.cMo = paramString4;
    parama.DFR = paramString5;
    parama.signature = paramString6;
    parama.DFS = paramString7;
    parama.scene = paramInt1;
    parama.DGl = paramString8;
    AppMethodBeat.o(187888);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78902);
    ad.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final int eiZ()
  {
    return this.AXm;
  }
  
  public final biq elL()
  {
    if (this.rr == null) {
      return null;
    }
    return (biq)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    ad.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */