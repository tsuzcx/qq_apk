package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class u
  extends n
  implements k, a.b
{
  public a.a Cpx;
  private final int Cpz;
  private g gfX;
  public String lUn;
  public final b rr;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    AppMethodBeat.i(188315);
    ac.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.Cpx = parama;
    this.lUn = paramString1;
    this.Cpz = paramInt2;
    parama = new b.a();
    parama.hvt = new bmh();
    parama.hvu = new bmi();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.reqCmdId = 0;
    parama.respCmdId = 0;
    this.rr = parama.aAz();
    parama = (bmh)this.rr.hvr.hvw;
    parama.url = paramString1;
    parama.Fbp = paramString2;
    parama.djj = paramString3;
    parama.FbE = paramLinkedList1;
    parama.FbG = paramLinkedList2;
    parama.cJz = paramString4;
    parama.Fbl = paramString5;
    parama.signature = paramString6;
    parama.Fbm = paramString7;
    parama.scene = paramInt1;
    parama.FbF = paramString8;
    AppMethodBeat.o(188315);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78902);
    ac.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final bmi eBh()
  {
    if (this.rr == null) {
      return null;
    }
    return (bmi)this.rr.hvs.hvw;
  }
  
  public final int eyt()
  {
    return this.Cpz;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    ac.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */