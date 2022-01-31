package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
{
  private static s tML;
  public bhh tMM;
  
  public static s cQR()
  {
    AppMethodBeat.i(45277);
    if (tML == null) {
      tML = new s();
    }
    s locals = tML;
    AppMethodBeat.o(45277);
    return locals;
  }
  
  public final void a(bhh parambhh)
  {
    AppMethodBeat.i(45278);
    ab.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(parambhh.xwl), Integer.valueOf(parambhh.xwn), Integer.valueOf(parambhh.xwm) });
    this.tMM = parambhh;
    if (ae.glH)
    {
      this.tMM.xwl = 100000000;
      this.tMM.xwn = 50000000;
      this.tMM.xwm = 50000000;
    }
    AppMethodBeat.o(45278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.s
 * JD-Core Version:    0.7.0.1
 */