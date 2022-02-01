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
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends n
  implements k
{
  private g callback;
  private b iaa;
  private acj zWd;
  public ack zWe;
  private boolean zWf;
  
  public l(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69911);
    this.zWf = paramBoolean;
    b.a locala = new b.a();
    locala.gUU = new acj();
    locala.gUV = new ack();
    if (paramBoolean) {
      locala.funcId = 1859;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktdrawlottery")
    {
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.iaa = locala.atI();
      this.zWd = ((acj)this.iaa.gUS.gUX);
      this.zWd.DcQ = paramString;
      this.zWd.DcR = paramInt;
      ad.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69911);
      return;
      locala.funcId = 2547;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69912);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(69912);
    return i;
  }
  
  public final int getType()
  {
    if (this.zWf) {
      return 1859;
    }
    return 2547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69913);
    ad.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zWe = ((ack)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */