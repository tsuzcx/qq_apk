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
import com.tencent.mm.protocal.c.abo;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private abo qqE;
  public abp qqF;
  public long qqG;
  
  public h(String paramString, long paramLong)
  {
    b.a locala = new b.a();
    locala.ecH = new abo();
    locala.ecI = new abp();
    locala.uri = "/cgi-bin/mmpay-bin/mktgetaward";
    locala.ecG = 2948;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.qqE = ((abo)this.eWr.ecE.ecN);
    this.qqE.taQ = paramString;
    this.qqG = paramLong;
    y.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qqF = ((abp)((b)paramq).ecF.ecN);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      y.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[] { Integer.valueOf(this.qqF.ino), this.qqF.inp, Integer.valueOf(this.qqF.taR), this.qqF.taS, this.qqF.taT });
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2948;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.h
 * JD-Core Version:    0.7.0.1
 */