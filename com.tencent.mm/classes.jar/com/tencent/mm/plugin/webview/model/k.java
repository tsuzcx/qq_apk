package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g gbr;
  public String qjl;
  public final b rr;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78870);
    this.qjl = paramString3;
    paramString3 = new b.a();
    paramString3.gUU = new ca();
    paramString3.gUV = new cb();
    paramString3.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
    paramString3.funcId = 2667;
    paramString3.reqCmdId = 2667;
    paramString3.respCmdId = 0;
    this.rr = paramString3.atI();
    paramString3 = (ca)this.rr.gUS.gUX;
    paramString3.CwX = paramString1;
    paramString3.dlB = paramString2;
    AppMethodBeat.o(78870);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78871);
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78871);
    return i;
  }
  
  public final int getType()
  {
    return 2667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78872);
    ad.i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.k
 * JD-Core Version:    0.7.0.1
 */