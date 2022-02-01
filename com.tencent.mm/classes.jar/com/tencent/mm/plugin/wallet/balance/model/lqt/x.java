package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;
import kotlin.n.d;

public final class x
{
  private static x HtZ;
  private cux Hua;
  
  public static x fMZ()
  {
    AppMethodBeat.i(68491);
    if (HtZ == null) {
      HtZ = new x();
    }
    x localx = HtZ;
    AppMethodBeat.o(68491);
    return localx;
  }
  
  public final void a(cux paramcux)
  {
    AppMethodBeat.i(68492);
    Log.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(paramcux.MAf), Integer.valueOf(paramcux.MAh), Integer.valueOf(paramcux.MAg) });
    this.Hua = paramcux;
    if (paramcux != null) {}
    try
    {
      paramcux = new String(paramcux.toByteArray(), d.ISO_8859_1);
      ((a)g.ah(a.class)).getWalletCacheStg().set(ar.a.OfF, paramcux);
      if (ac.jPE)
      {
        this.Hua.MAf = 100000000;
        this.Hua.MAh = 50000000;
        this.Hua.MAg = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException paramcux)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", paramcux, "", new Object[0]);
      }
    }
  }
  
  public final cux fNa()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.Hua == null)
    {
      Log.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)g.ah(a.class)).getWalletCacheStg().get(ar.a.OfF, "");
      if (Util.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.Hua = ((cux)new cux().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.Hua;
      AppMethodBeat.o(182502);
      return localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.x
 * JD-Core Version:    0.7.0.1
 */