package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
{
  public static boolean Wd(int paramInt)
  {
    AppMethodBeat.i(69858);
    com.tencent.mm.kernel.g.ajS();
    if ((((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INU, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean eIj()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    al localal;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      ae.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        ae.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.cRY());
      }
      s.eGW();
      localObject = s.eGX();
      localal = ((an)localObject).eJP();
      localStringBuilder = new StringBuilder("config==null?");
      if (localal != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletUtil", bool);
      if (localal != null) {
        ae.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localal.eJx());
      }
      ae.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((an)localObject).eJH());
      if ((locala == null) || (!locala.cRY()) || (localal == null) || (!localal.eJx()) || (!((an)localObject).eJH())) {
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
  
  public static boolean eIk()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala == null)
    {
      ae.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    s.eGW();
    an localan = s.eGX();
    al localal = localan.eJP();
    com.tencent.mm.plugin.report.service.g.yxI.dD(916, 0);
    ae.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.cSg()), Boolean.valueOf(localal.eJx()), Boolean.valueOf(localan.eJH()) });
    if ((locala.cSg()) && (localal.eJx()) && (localan.eJH()))
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