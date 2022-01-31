package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.sdk.platformtools.y;

public final class l
{
  private static l qfK;
  public bae qfL;
  
  public static l bTj()
  {
    if (qfK == null) {
      qfK = new l();
    }
    return qfK;
  }
  
  public final void a(bae parambae)
  {
    y.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(parambae.balance), Integer.valueOf(parambae.twa), Integer.valueOf(parambae.tvZ) });
    this.qfL = parambae;
    if (ae.eTM)
    {
      this.qfL.balance = 100000000;
      this.qfL.twa = 50000000;
      this.qfL.tvZ = 50000000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.l
 * JD-Core Version:    0.7.0.1
 */