package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private g callback;
  private b iaa;
  private boolean zWf;
  private adz zWl;
  public aea zWm;
  
  public o(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69920);
    this.zWf = paramBoolean;
    b.a locala = new b.a();
    locala.gUU = new adz();
    locala.gUV = new aea();
    if (paramBoolean) {
      locala.funcId = 2529;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";; locala.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure")
    {
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.iaa = locala.atI();
      this.zWl = ((adz)this.iaa.gUS.gUX);
      this.zWl.Del = paramString;
      AppMethodBeat.o(69920);
      return;
      locala.funcId = 2888;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69921);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(69921);
    return i;
  }
  
  public final int getType()
  {
    if (this.zWf) {
      return 2529;
    }
    return 2888;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69922);
    ad.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zWm = ((aea)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.o
 * JD-Core Version:    0.7.0.1
 */