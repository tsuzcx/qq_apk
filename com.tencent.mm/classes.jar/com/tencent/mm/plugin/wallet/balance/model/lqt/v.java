package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import d.n.d;
import java.io.IOException;

public final class v
{
  private static v CPi;
  private ceq CPj;
  
  public static v eFR()
  {
    AppMethodBeat.i(68491);
    if (CPi == null) {
      CPi = new v();
    }
    v localv = CPi;
    AppMethodBeat.o(68491);
    return localv;
  }
  
  public final void a(ceq paramceq)
  {
    AppMethodBeat.i(68492);
    ae.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(paramceq.Hro), Integer.valueOf(paramceq.Hrq), Integer.valueOf(paramceq.Hrp) });
    this.CPj = paramceq;
    if (paramceq != null) {}
    try
    {
      paramceq = new String(paramceq.toByteArray(), d.ISO_8859_1);
      ((a)g.ad(a.class)).getWalletCacheStg().set(am.a.IXm, paramceq);
      if (ac.iSJ)
      {
        this.CPj.Hro = 100000000;
        this.CPj.Hrq = 50000000;
        this.CPj.Hrp = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException paramceq)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", paramceq, "", new Object[0]);
      }
    }
  }
  
  public final ceq eFS()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.CPj == null)
    {
      ae.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)g.ad(a.class)).getWalletCacheStg().get(am.a.IXm, "");
      if (bu.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.CPj = ((ceq)new ceq().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.CPj;
      AppMethodBeat.o(182502);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */