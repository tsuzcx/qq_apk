package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(73770);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new bji();
    paramf.hNN = new bjj();
    paramf.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
    paramf.funcId = 869;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    int i = dispatch(parame, paramf.aDC(), this);
    AppMethodBeat.o(73770);
    return i;
  }
  
  public final int getType()
  {
    return 869;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73769);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.f
 * JD-Core Version:    0.7.0.1
 */