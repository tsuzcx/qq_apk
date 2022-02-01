package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
{
  public static boolean aeG(int paramInt)
  {
    AppMethodBeat.i(69858);
    g.aAi();
    if ((((Integer)g.aAh().azQ().get(ar.a.NVW, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean fPB()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    al localal;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      Log.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        Log.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.dJT());
      }
      s.fOg();
      localObject = s.fOh();
      localal = ((an)localObject).fRs();
      localStringBuilder = new StringBuilder("config==null?");
      if (localal != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletUtil", bool);
      if (localal != null) {
        Log.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localal.fRa());
      }
      Log.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((an)localObject).fRk());
      if ((locala == null) || (!locala.dJT()) || (localal == null) || (!localal.fRa()) || (!((an)localObject).fRk())) {
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
  
  public static boolean fPC()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    s.fOg();
    an localan = s.fOh();
    al localal = localan.fRs();
    h.CyF.dN(916, 0);
    Log.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.dKb()), Boolean.valueOf(localal.fRa()), Boolean.valueOf(localan.fRk()) });
    if ((locala.dKb()) && (localal.fRa()) && (localan.fRk()))
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