package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.aa;
import d.n.d;
import java.io.IOException;

public final class v
{
  private static v CxD;
  private cdw CxE;
  
  public static v eCj()
  {
    AppMethodBeat.i(68491);
    if (CxD == null) {
      CxD = new v();
    }
    v localv = CxD;
    AppMethodBeat.o(68491);
    return localv;
  }
  
  public final void a(cdw paramcdw)
  {
    AppMethodBeat.i(68492);
    ad.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(paramcdw.GXO), Integer.valueOf(paramcdw.GXQ), Integer.valueOf(paramcdw.GXP) });
    this.CxE = paramcdw;
    if (paramcdw != null) {}
    try
    {
      paramcdw = new String(paramcdw.toByteArray(), d.ISO_8859_1);
      ((a)g.ad(a.class)).getWalletCacheStg().set(al.a.ICM, paramcdw);
      if (ac.iPQ)
      {
        this.CxE.GXO = 100000000;
        this.CxE.GXQ = 50000000;
        this.CxE.GXP = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException paramcdw)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", paramcdw, "", new Object[0]);
      }
    }
  }
  
  public final cdw eCk()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.CxE == null)
    {
      ad.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)g.ad(a.class)).getWalletCacheStg().get(al.a.ICM, "");
      if (bt.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.CxE = ((cdw)new cdw().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.CxE;
      AppMethodBeat.o(182502);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */