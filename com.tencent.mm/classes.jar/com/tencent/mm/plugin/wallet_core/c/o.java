package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private boolean COO;
  private ahh COU;
  public ahi COV;
  private f callback;
  private b gPp;
  
  public o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69920);
    this.COO = paramBoolean;
    b.a locala = new b.a();
    locala.hNM = new ahh();
    locala.hNN = new ahi();
    if (paramBoolean) {
      locala.funcId = 2529;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";; locala.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure")
    {
      locala.hNO = 0;
      locala.respCmdId = 0;
      this.gPp = locala.aDC();
      this.COU = ((ahh)this.gPp.hNK.hNQ);
      this.COU.GeU = paramString;
      AppMethodBeat.o(69920);
      return;
      locala.funcId = 2888;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69921);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(69921);
    return i;
  }
  
  public final int getType()
  {
    if (this.COO) {
      return 2529;
    }
    return 2888;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69922);
    ad.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.COV = ((ahi)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */