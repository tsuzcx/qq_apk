package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class a
{
  public static boolean TE(int paramInt)
  {
    AppMethodBeat.i(69858);
    g.agS();
    if ((((Integer)g.agR().agA().get(ah.a.GHf, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean eqC()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    ak localak;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      ac.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        ac.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.cHe());
      }
      s.epp();
      localObject = s.epq();
      localak = ((am)localObject).esi();
      localStringBuilder = new StringBuilder("config==null?");
      if (localak != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletUtil", bool);
      if (localak != null) {
        ac.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localak.erQ());
      }
      ac.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((am)localObject).esa());
      if ((locala == null) || (!locala.cHe()) || (localak == null) || (!localak.erQ()) || (!((am)localObject).esa())) {
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
  
  public static boolean eqD()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala == null)
    {
      ac.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    s.epp();
    am localam = s.epq();
    ak localak = localam.esi();
    h.wUl.dB(916, 0);
    ac.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.cHm()), Boolean.valueOf(localak.erQ()), Boolean.valueOf(localam.esa()) });
    if ((locala.cHm()) && (localak.erQ()) && (localam.esa()))
    {
      AppMethodBeat.o(69860);
      return true;
    }
    AppMethodBeat.o(69860);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.b.a
 * JD-Core Version:    0.7.0.1
 */