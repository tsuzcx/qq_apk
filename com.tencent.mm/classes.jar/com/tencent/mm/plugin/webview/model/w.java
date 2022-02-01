package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bqw;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class w
  extends n
  implements k, a.b
{
  private final int DSX;
  public bqi DSY;
  private f gzH;
  public final com.tencent.mm.al.b rr;
  
  public w(bqi parambqi, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, com.tencent.mm.bx.b paramb, int paramInt1, LinkedList<brk> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(207936);
    ad.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[] { paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1) });
    this.DSY = parambqi;
    this.DSX = paramInt2;
    parambqi = new b.a();
    parambqi.hNM = new bqv();
    parambqi.hNN = new bqw();
    parambqi.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
    parambqi.funcId = 1096;
    parambqi.hNO = 0;
    parambqi.respCmdId = 0;
    this.rr = parambqi.aDC();
    parambqi = (bqv)this.rr.hNK.hNQ;
    parambqi.url = paramString1;
    parambqi.GKO = paramString2;
    parambqi.duW = paramString3;
    parambqi.GKI = paramString4;
    parambqi.cUM = paramString5;
    parambqi.GKK = paramString6;
    parambqi.signature = paramString7;
    parambqi.GKL = paramString8;
    parambqi.GKN = paramInt1;
    parambqi.GKM = paramb;
    parambqi.GKS = paramLinkedList;
    AppMethodBeat.o(207936);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78908);
    ad.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78908);
    return i;
  }
  
  public final int eNj()
  {
    return this.DSX;
  }
  
  public final int getType()
  {
    return 1096;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78907);
    ad.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.w
 * JD-Core Version:    0.7.0.1
 */