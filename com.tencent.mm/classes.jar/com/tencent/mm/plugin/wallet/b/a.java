package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class a
{
  public static boolean Vw(int paramInt)
  {
    AppMethodBeat.i(69858);
    com.tencent.mm.kernel.g.ajD();
    if ((((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Itx, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean eEC()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    al localal;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      ad.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        ad.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.cPt());
      }
      s.eDp();
      localObject = s.eDq();
      localal = ((an)localObject).eGi();
      localStringBuilder = new StringBuilder("config==null?");
      if (localal != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletUtil", bool);
      if (localal != null) {
        ad.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localal.eFQ());
      }
      ad.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((an)localObject).eGa());
      if ((locala == null) || (!locala.cPt()) || (localal == null) || (!localal.eFQ()) || (!((an)localObject).eGa())) {
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
  
  public static boolean eED()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala == null)
    {
      ad.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    s.eDp();
    an localan = s.eDq();
    al localal = localan.eGi();
    com.tencent.mm.plugin.report.service.g.yhR.dD(916, 0);
    ad.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.cPB()), Boolean.valueOf(localal.eFQ()), Boolean.valueOf(localan.eGa()) });
    if ((locala.cPB()) && (localal.eFQ()) && (localan.eGa()))
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