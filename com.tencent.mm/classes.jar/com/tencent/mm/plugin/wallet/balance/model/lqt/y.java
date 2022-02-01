package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.io.IOException;
import kotlin.n.d;

public final class y
{
  private static y OlL;
  private deh OlM;
  
  public static y gFD()
  {
    AppMethodBeat.i(68491);
    if (OlL == null) {
      OlL = new y();
    }
    y localy = OlL;
    AppMethodBeat.o(68491);
    return localy;
  }
  
  public final void a(deh paramdeh)
  {
    AppMethodBeat.i(68492);
    Log.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(paramdeh.dta), Integer.valueOf(paramdeh.TLQ), Integer.valueOf(paramdeh.TLP) });
    this.OlM = paramdeh;
    if (paramdeh != null) {}
    try
    {
      paramdeh = new String(paramdeh.toByteArray(), d.ISO_8859_1);
      ((a)h.ag(a.class)).getWalletCacheStg().set(ar.a.VtT, paramdeh);
      if (ac.mGO)
      {
        this.OlM.dta = 100000000;
        this.OlM.TLQ = 50000000;
        this.OlM.TLP = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException paramdeh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", paramdeh, "", new Object[0]);
      }
    }
  }
  
  public final deh gFE()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.OlM == null)
    {
      Log.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)h.ag(a.class)).getWalletCacheStg().get(ar.a.VtT, "");
      if (Util.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.OlM = ((deh)new deh().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.OlM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.y
 * JD-Core Version:    0.7.0.1
 */