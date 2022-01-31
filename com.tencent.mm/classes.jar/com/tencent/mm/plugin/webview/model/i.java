package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f eGj;
  public String mBI;
  public final b rr;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6586);
    this.mBI = paramString3;
    paramString3 = new b.a();
    paramString3.fsX = new bu();
    paramString3.fsY = new bv();
    paramString3.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
    paramString3.funcId = 2667;
    paramString3.reqCmdId = 2667;
    paramString3.respCmdId = 0;
    this.rr = paramString3.ado();
    paramString3 = (bu)this.rr.fsV.fta;
    paramString3.wop = paramString1;
    paramString3.cwc = paramString2;
    AppMethodBeat.o(6586);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6587);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6587);
    return i;
  }
  
  public final int getType()
  {
    return 2667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6588);
    ab.i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(6588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */