package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f dmL;
  private b eWr;
  public ki nyl;
  
  public k(co paramco, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new kh();
    ((b.a)localObject).ecI = new ki();
    ((b.a)localObject).ecG = 2702;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.eWr = ((b.a)localObject).Kt();
    localObject = (kh)this.eWr.ecE.ecN;
    ((kh)localObject).sEQ = paramco;
    ((kh)localObject).sFd = paramString;
    h.nFQ.h(886L, 0L, 1L);
    y.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", new Object[] { paramco.swc, paramco.swd, Integer.valueOf(paramco.swh) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nyl = ((ki)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nyl.ino), this.nyl.inp });
    h.nFQ.h(886L, 1L, 1L);
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2702;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.k
 * JD-Core Version:    0.7.0.1
 */