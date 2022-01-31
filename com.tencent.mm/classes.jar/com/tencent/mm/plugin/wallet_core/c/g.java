package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private ul qqB;
  public um qqC;
  private boolean qqD;
  
  public g(String paramString, int paramInt, boolean paramBoolean)
  {
    this.qqD = paramBoolean;
    b.a locala = new b.a();
    locala.ecH = new ul();
    locala.ecI = new um();
    if (paramBoolean) {
      locala.ecG = 1859;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktdrawlottery")
    {
      locala.ecJ = 0;
      locala.ecK = 0;
      this.eWr = locala.Kt();
      this.qqB = ((ul)this.eWr.ecE.ecN);
      this.qqB.sRh = paramString;
      this.qqB.sRi = paramInt;
      y.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      return;
      locala.ecG = 2547;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qqC = ((um)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    if (this.qqD) {
      return 1859;
    }
    return 2547;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.g
 * JD-Core Version:    0.7.0.1
 */