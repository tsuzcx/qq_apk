package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g gfX;
  public String qRN;
  public final b rr;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78870);
    this.qRN = paramString3;
    paramString3 = new b.a();
    paramString3.hvt = new cc();
    paramString3.hvu = new cd();
    paramString3.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
    paramString3.funcId = 2667;
    paramString3.reqCmdId = 2667;
    paramString3.respCmdId = 0;
    this.rr = paramString3.aAz();
    paramString3 = (cc)this.rr.hvr.hvw;
    paramString3.DPt = paramString1;
    paramString3.djj = paramString2;
    AppMethodBeat.o(78870);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78871);
    this.gfX = paramg;
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
    ac.i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.k
 * JD-Core Version:    0.7.0.1
 */