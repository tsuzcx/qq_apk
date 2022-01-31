package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.d.d;

public final class l
  extends m
  implements k, g, d
{
  private f dmL;
  private b eWr;
  public boolean jMV = false;
  public kk nym;
  public boolean nyn = false;
  private kj nyo;
  
  public l(bya parambya, co paramco, String paramString1, int paramInt, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new kj();
    locala.ecI = new kk();
    locala.ecG = 2682;
    locala.uri = "/cgi-bin/mmpay-bin/busif2fzerocallback";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.nyo = ((kj)this.eWr.ecE.ecN);
    this.nyo.sEQ = paramco;
    this.nyo.sFh = parambya;
    this.nyo.sFi = paramString1;
    this.nyo.sFu = paramInt;
    this.nyo.token = paramString2;
    y.i("MicroMsg.NetSceneBusiF2fZeroCallback", "NetSceneBusiF2fZeroCallback, token %s AfterPlaceOrderCommReq %s zero_pay_extend: %s", new Object[] { paramString2, a.a(paramco), paramString1 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fZeroCallback", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nym = ((kk)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBusiF2fZeroCallback", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nym.ino), this.nym.inp });
    if (this.dmL != null) {
      if (this.nym.sFv != 1) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      this.jMV = bool;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  public final boolean bwg()
  {
    return this.nyn;
  }
  
  public final int getType()
  {
    return 2682;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.l
 * JD-Core Version:    0.7.0.1
 */