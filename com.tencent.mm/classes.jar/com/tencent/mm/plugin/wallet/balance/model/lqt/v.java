package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.c.aa;
import d.n.d;
import java.io.IOException;

public final class v
{
  private static v AXu;
  private bzf AXv;
  
  public static v eok()
  {
    AppMethodBeat.i(68491);
    if (AXu == null) {
      AXu = new v();
    }
    v localv = AXu;
    AppMethodBeat.o(68491);
    return localv;
  }
  
  public final void a(bzf parambzf)
  {
    AppMethodBeat.i(68492);
    ac.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(parambzf.Foc), Integer.valueOf(parambzf.Foe), Integer.valueOf(parambzf.Fod) });
    this.AXv = parambzf;
    if (parambzf != null) {}
    try
    {
      parambzf = new String(parambzf.toByteArray(), d.ISO_8859_1);
      ((a)g.ad(a.class)).getWalletCacheStg().set(ah.a.GQs, parambzf);
      if (ab.iwI)
      {
        this.AXv.Foc = 100000000;
        this.AXv.Foe = 50000000;
        this.AXv.Fod = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException parambzf)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", parambzf, "", new Object[0]);
      }
    }
  }
  
  public final bzf eol()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.AXv == null)
    {
      ac.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)g.ad(a.class)).getWalletCacheStg().get(ah.a.GQs, "");
      if (bs.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.AXv = ((bzf)new bzf().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.AXv;
      AppMethodBeat.o(182502);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */