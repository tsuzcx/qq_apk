package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
import java.io.IOException;
import kotlin.n.d;

public final class z
{
  private static z Var;
  private dwg Vas;
  
  public static z ieB()
  {
    AppMethodBeat.i(68491);
    if (Var == null) {
      Var = new z();
    }
    z localz = Var;
    AppMethodBeat.o(68491);
    return localz;
  }
  
  public final void a(dwg paramdwg)
  {
    AppMethodBeat.i(68492);
    Log.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", new Object[] { Integer.valueOf(paramdwg.ftr), Integer.valueOf(paramdwg.abca), Integer.valueOf(paramdwg.abbZ) });
    this.Vas = paramdwg;
    if (paramdwg != null) {}
    try
    {
      paramdwg = new String(paramdwg.toByteArray(), d.ISO_8859_1);
      ((a)h.az(a.class)).getWalletCacheStg().set(at.a.acVy, paramdwg);
      if (com.tencent.mm.platformtools.z.pDo)
      {
        this.Vas.ftr = 100000000;
        this.Vas.abca = 50000000;
        this.Vas.abbZ = 50000000;
      }
      AppMethodBeat.o(68492);
      return;
    }
    catch (IOException paramdwg)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LqtOnClickRedeemCache", paramdwg, "", new Object[0]);
      }
    }
  }
  
  public final dwg ieC()
  {
    AppMethodBeat.i(182502);
    Object localObject;
    if (this.Vas == null)
    {
      Log.d("MicroMsg.LqtOnClickRedeemCache", "cache is null");
      localObject = (String)((a)h.az(a.class)).getWalletCacheStg().get(at.a.acVy, "");
      if (Util.isNullOrNil((String)localObject)) {}
    }
    try
    {
      this.Vas = ((dwg)new dwg().parseFrom(((String)localObject).getBytes(d.ISO_8859_1)));
      localObject = this.Vas;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.z
 * JD-Core Version:    0.7.0.1
 */