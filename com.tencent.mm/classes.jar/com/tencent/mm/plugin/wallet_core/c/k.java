package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f dmL;
  private b eWr;
  public String pva;
  private bho qqL;
  public bhp qqM;
  
  public k(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new bho();
    locala.ecI = new bhp();
    locala.ecG = 2710;
    locala.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.qqL = ((bho)this.eWr.ecE.ecN);
    this.qqL.qEA = paramString1;
    this.pva = paramString2;
    y.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[] { paramString1, paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qqM = ((bhp)((b)paramq).ecF.ecN);
    if ((paramInt2 == 0) || (paramInt3 == 0)) {
      y.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.qqM.ino), this.qqM.inp });
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2710;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */