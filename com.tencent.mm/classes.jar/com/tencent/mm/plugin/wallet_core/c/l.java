package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends q
  implements m
{
  private ahz HPK;
  public aia HPL;
  private boolean HPM;
  private i callback;
  private d hJu;
  
  public l(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(69911);
    this.HPM = paramBoolean;
    d.a locala = new d.a();
    locala.iLN = new ahz();
    locala.iLO = new aia();
    if (paramBoolean) {
      locala.funcId = 1859;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktdrawlottery")
    {
      locala.iLP = 0;
      locala.respCmdId = 0;
      this.hJu = locala.aXF();
      this.HPK = ((ahz)this.hJu.iLK.iLR);
      this.HPK.LrG = paramString;
      this.HPK.LrH = paramInt;
      Log.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69911);
      return;
      locala.funcId = 2547;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69912);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(69912);
    return i;
  }
  
  public final int getType()
  {
    if (this.HPM) {
      return 1859;
    }
    return 2547;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69913);
    Log.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.HPL = ((aia)((d)params).iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.l
 * JD-Core Version:    0.7.0.1
 */