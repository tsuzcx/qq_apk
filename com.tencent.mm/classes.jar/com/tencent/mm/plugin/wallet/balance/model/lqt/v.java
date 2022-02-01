package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.c.aa;
import d.n.d;
import java.io.IOException;

public final class v
{
  private static v zFh;
  private buo zFi;
  
  public static v dYO()
  {
    AppMethodBeat.i(68491);
    if (zFh == null) {
      zFh = new v();
    }
    v localv = zFh;
    AppMethodBeat.o(68491);
    return localv;
  }
  
  public final void a(buo parambuo)
  {
    AppMethodBeat.i(68492);
    ad.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(parambuo.DRI), Integer.valueOf(parambuo.DRK), Integer.valueOf(parambuo.DRJ) });
    this.zFi = parambuo;
    if (parambuo != null) {}
    try
    {
      parambuo = new String(parambuo.toByteArray(), d.ISO_8859_1);
      ((a)g.ad(a.class)).getWalletCacheStg().set(ae.a.FsB, parambuo);
      if (ab.hWE)
      {
        this.zFi.DRI = 100000000;
        this.zFi.DRK = 50000000;
        this.zFi.DRJ = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException parambuo)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", parambuo, "", new Object[0]);
      }
    }
  }
  
  public final buo dYP()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.zFi == null)
    {
      ad.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)g.ad(a.class)).getWalletCacheStg().get(ae.a.FsB, "");
      if (bt.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.zFi = ((buo)new buo().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.zFi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */