package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet.model.p;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
{
  public static boolean asc(int paramInt)
  {
    AppMethodBeat.i(69858);
    com.tencent.mm.kernel.h.baF();
    if ((((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acLq, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean ihi()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    ak localak;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      Log.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        Log.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.ftv());
      }
      p.ifO();
      localObject = p.ifP();
      localak = ((am)localObject).ijp();
      localStringBuilder = new StringBuilder("config==null?");
      if (localak != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletUtil", bool);
      if (localak != null) {
        Log.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localak.iiU());
      }
      Log.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((am)localObject).ijf());
      if ((locala == null) || (!locala.ftv()) || (localak == null) || (!localak.iiU()) || (!((am)localObject).ijf())) {
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
  
  public static boolean ihj()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.c.a locala = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    p.ifO();
    am localam = p.ifP();
    ak localak = localam.ijp();
    com.tencent.mm.plugin.report.service.h.OAn.kJ(916, 0);
    Log.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.ftD()), Boolean.valueOf(localak.iiU()), Boolean.valueOf(localam.ijf()) });
    if ((locala.ftD()) && (localak.iiU()) && (localam.ijf()))
    {
      AppMethodBeat.o(69860);
      return true;
    }
    AppMethodBeat.o(69860);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.b.a
 * JD-Core Version:    0.7.0.1
 */