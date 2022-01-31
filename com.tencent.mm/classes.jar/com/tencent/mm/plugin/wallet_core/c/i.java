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
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private boolean qqD;
  private ahh qqH;
  public ahi qqI;
  
  public i(String paramString, boolean paramBoolean)
  {
    this.qqD = paramBoolean;
    b.a locala = new b.a();
    locala.ecH = new ahh();
    locala.ecI = new ahi();
    if (paramBoolean) {
      locala.ecG = 2803;
    }
    for (locala.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";; locala.uri = "/cgi-bin/mmpay-bin/mktgetlottery")
    {
      locala.ecJ = 0;
      locala.ecK = 0;
      this.eWr = locala.Kt();
      this.qqH = ((ahh)this.eWr.ecE.ecN);
      this.qqH.teX = paramString;
      y.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return;
      locala.ecG = 2508;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qqI = ((ahi)((b)paramq).ecF.ecN);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    if (this.qqD) {
      return 2803;
    }
    return 2508;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */