package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f gzH;
  public String rBN;
  public final b rr;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78870);
    this.rBN = paramString3;
    paramString3 = new b.a();
    paramString3.hNM = new cc();
    paramString3.hNN = new cd();
    paramString3.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
    paramString3.funcId = 2667;
    paramString3.hNO = 2667;
    paramString3.respCmdId = 0;
    this.rr = paramString3.aDC();
    paramString3 = (cc)this.rr.hNK.hNQ;
    paramString3.FuD = paramString1;
    paramString3.duW = paramString2;
    AppMethodBeat.o(78870);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78871);
    this.gzH = paramf;
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
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.k
 * JD-Core Version:    0.7.0.1
 */