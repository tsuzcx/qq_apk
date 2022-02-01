package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u
  extends q
  implements m, a.b
{
  public a.a IXT;
  private final int IXV;
  private i heq;
  public String nKc;
  public final d rr;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(210974);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.IXT = parama;
    this.nKc = paramString1;
    this.IXV = paramInt2;
    parama = new d.a();
    parama.iLN = new cef();
    parama.iLO = new ceg();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.iLP = 0;
    parama.respCmdId = 0;
    this.rr = parama.aXF();
    parama = (cef)this.rr.iLK.iLR;
    parama.url = paramString1;
    parama.Mjy = paramString2;
    parama.dNI = paramString3;
    parama.MjM = paramLinkedList1;
    parama.MjO = paramLinkedList2;
    parama.dmc = paramString4;
    parama.Mju = paramString5;
    parama.signature = paramString6;
    parama.Mjv = paramString7;
    parama.scene = paramInt1;
    parama.MjN = paramString8;
    parama.HTO = paramInt3;
    AppMethodBeat.o(210974);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78902);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final int fZu()
  {
    return this.IXV;
  }
  
  public final ceg gcy()
  {
    if (this.rr == null) {
      return null;
    }
    return (ceg)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */