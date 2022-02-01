package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.sdk.platformtools.ac;

public final class l
  extends n
  implements k
{
  private adi Box;
  public adj Boy;
  private boolean Boz;
  private g callback;
  private b gvE;
  
  public l(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69911);
    this.Boz = paramBoolean;
    b.a locala = new b.a();
    locala.hvt = new adi();
    locala.hvu = new adj();
    if (paramBoolean) {
      locala.funcId = 1859;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktdrawlottery")
    {
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.gvE = locala.aAz();
      this.Box = ((adi)this.gvE.hvr.hvw);
      this.Box.EvX = paramString;
      this.Box.EvY = paramInt;
      ac.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69911);
      return;
      locala.funcId = 2547;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69912);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(69912);
    return i;
  }
  
  public final int getType()
  {
    if (this.Boz) {
      return 1859;
    }
    return 2547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69913);
    ac.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Boy = ((adj)((b)paramq).hvs.hvw);
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