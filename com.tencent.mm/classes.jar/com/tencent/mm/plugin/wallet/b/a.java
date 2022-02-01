package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class a
{
  public static boolean Rv(int paramInt)
  {
    AppMethodBeat.i(69858);
    g.afC();
    if ((((Integer)g.afB().afk().get(ae.a.Fjq, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean ebg()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    ak localak;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      ad.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        ad.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.ctS());
      }
      s.dZT();
      localObject = s.dZU();
      localak = ((am)localObject).ecN();
      localStringBuilder = new StringBuilder("config==null?");
      if (localak != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletUtil", bool);
      if (localak != null) {
        ad.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localak.ecu());
      }
      ad.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((am)localObject).ecF());
      if ((locala == null) || (!locala.ctS()) || (localak == null) || (!localak.ecu()) || (!((am)localObject).ecF())) {
        break label217;
      }
      AppMethodBeat.o(69859);
      return true;
      bool = false;
      break;
    }
    label217:
    AppMethodBeat.o(69859);
    return false;
  }
  
  public static boolean ebh()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala == null)
    {
      ad.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    s.dZT();
    am localam = s.dZU();
    ak localak = localam.ecN();
    h.vKh.dB(916, 0);
    ad.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.cua()), Boolean.valueOf(localak.ecu()), Boolean.valueOf(localam.ecF()) });
    if ((locala.cua()) && (localak.ecu()) && (localam.ecF()))
    {
      AppMethodBeat.o(69860);
      return true;
    }
    AppMethodBeat.o(69860);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.b.a
 * JD-Core Version:    0.7.0.1
 */