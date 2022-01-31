package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends m
  implements k
{
  private f callback;
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(126848);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new aqt();
    paramf.fsY = new aqu();
    paramf.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
    paramf.funcId = 869;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.ado(), this);
    AppMethodBeat.o(126848);
    return i;
  }
  
  public final int getType()
  {
    return 869;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126847);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ab.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.e
 * JD-Core Version:    0.7.0.1
 */