package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  private b iaa;
  private boolean zWf;
  private avx zWj;
  public avy zWk;
  
  public n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69917);
    this.zWf = paramBoolean;
    b.a locala = new b.a();
    locala.gUU = new avx();
    locala.gUV = new avy();
    if (paramBoolean) {
      locala.funcId = 2803;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktgetlottery")
    {
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      this.iaa = locala.atI();
      this.zWj = ((avx)this.iaa.gUS.gUX);
      this.zWj.Dvu = paramString;
      ad.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(69917);
      return;
      locala.funcId = 2508;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69918);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(69918);
    return i;
  }
  
  public final int getType()
  {
    if (this.zWf) {
      return 2803;
    }
    return 2508;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69919);
    ad.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.zWk = ((avy)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.n
 * JD-Core Version:    0.7.0.1
 */