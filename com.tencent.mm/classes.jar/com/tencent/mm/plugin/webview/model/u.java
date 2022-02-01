package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u
  extends p
  implements m, a.b
{
  public a.a WKW;
  private final int WKY;
  private h mAY;
  public final c rr;
  public String sML;
  
  public u(a.a parama, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(298399);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7 });
    this.WKW = parama;
    this.sML = paramString1;
    this.WKY = paramInt2;
    parama = new c.a();
    parama.otE = new ddr();
    parama.otF = new dds();
    parama.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    parama.funcId = 1093;
    parama.otG = 0;
    parama.respCmdId = 0;
    this.rr = parama.bEF();
    parama = (ddr)c.b.b(this.rr.otB);
    parama.url = paramString1;
    parama.aaIP = paramString2;
    parama.appid = paramString3;
    parama.aaJh = paramLinkedList1;
    parama.aaJj = paramLinkedList2;
    parama.hhx = paramString4;
    parama.aaIL = paramString5;
    parama.signature = paramString6;
    parama.aaIM = paramString7;
    parama.scene = paramInt1;
    parama.aaJi = paramString8;
    parama.aaJk = paramInt3;
    parama.aaIQ = paramInt4;
    AppMethodBeat.o(298399);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78902);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78902);
    return i;
  }
  
  public final int getType()
  {
    return 1093;
  }
  
  public final int irL()
  {
    return this.WKY;
  }
  
  public final dds ive()
  {
    AppMethodBeat.i(298410);
    if (this.rr == null)
    {
      AppMethodBeat.o(298410);
      return null;
    }
    dds localdds = (dds)c.c.b(this.rr.otC);
    AppMethodBeat.o(298410);
    return localdds;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78901);
    Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */