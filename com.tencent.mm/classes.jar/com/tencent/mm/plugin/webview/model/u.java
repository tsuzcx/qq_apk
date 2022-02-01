package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u
  extends q
  implements m, a.b
{
  public a.a PUk;
  private final int PUm;
  private i jQg;
  public String pHO;
  public final d rr;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(244204);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.PUk = parama;
    this.pHO = paramString1;
    this.PUm = paramInt2;
    parama = new d.a();
    parama.lBU = new cmz();
    parama.lBV = new cna();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.lBW = 0;
    parama.respCmdId = 0;
    this.rr = parama.bgN();
    parama = (cmz)d.b.b(this.rr.lBR);
    parama.url = paramString1;
    parama.Tul = paramString2;
    parama.appid = paramString3;
    parama.TuB = paramLinkedList1;
    parama.TuD = paramLinkedList2;
    parama.fdH = paramString4;
    parama.Tuh = paramString5;
    parama.signature = paramString6;
    parama.Tui = paramString7;
    parama.scene = paramInt1;
    parama.TuC = paramString8;
    parama.TuE = paramInt3;
    parama.Tum = paramInt4;
    AppMethodBeat.o(244204);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78902);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final int gSo()
  {
    return this.PUm;
  }
  
  public final cna gVt()
  {
    AppMethodBeat.i(244207);
    if (this.rr == null)
    {
      AppMethodBeat.o(244207);
      return null;
    }
    cna localcna = (cna)d.c.b(this.rr.lBS);
    AppMethodBeat.o(244207);
    return localcna;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */