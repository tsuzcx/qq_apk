package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends m
  implements k
{
  private f callback;
  private b goo;
  private yy ubx;
  public yz uby;
  private boolean ubz;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(46506);
    this.ubz = paramBoolean;
    b.a locala = new b.a();
    locala.fsX = new yy();
    locala.fsY = new yz();
    if (paramBoolean) {
      locala.funcId = 1859;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktdrawlottery")
    {
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.goo = locala.ado();
      this.ubx = ((yy)this.goo.fsV.fta);
      this.ubx.wPV = paramString;
      this.ubx.wPW = paramInt;
      ab.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(46506);
      return;
      locala.funcId = 2547;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46507);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(46507);
    return i;
  }
  
  public final int getType()
  {
    if (this.ubz) {
      return 1859;
    }
    return 2547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46508);
    ab.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uby = ((yz)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(46508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.j
 * JD-Core Version:    0.7.0.1
 */