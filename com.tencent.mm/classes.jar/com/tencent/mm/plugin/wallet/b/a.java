package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;

public final class a
{
  public static boolean amt(int paramInt)
  {
    AppMethodBeat.i(69858);
    com.tencent.mm.kernel.h.aHH();
    if ((((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VjW, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(69858);
      return true;
    }
    AppMethodBeat.o(69858);
    return false;
  }
  
  public static boolean gIe()
  {
    AppMethodBeat.i(69859);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    Object localObject = new StringBuilder("mgr==null?");
    am localam;
    StringBuilder localStringBuilder;
    if (locala == null)
    {
      bool = true;
      Log.i("MicroMsg.WalletUtil", bool);
      if (locala != null) {
        Log.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locala.eos());
      }
      s.gGL();
      localObject = s.gGM();
      localam = ((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gJY();
      localStringBuilder = new StringBuilder("config==null?");
      if (localam != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletUtil", bool);
      if (localam != null) {
        Log.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localam.gJG());
      }
      Log.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gJQ());
      if ((locala == null) || (!locala.eos()) || (localam == null) || (!localam.gJG()) || (!((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gJQ())) {
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
  
  public static boolean gIf()
  {
    AppMethodBeat.i(69860);
    com.tencent.mm.plugin.fingerprint.d.a locala = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(69860);
      return false;
    }
    s.gGL();
    com.tencent.mm.plugin.wallet_core.model.ao localao = s.gGM();
    am localam = localao.gJY();
    com.tencent.mm.plugin.report.service.h.IzE.el(916, 0);
    Log.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locala.eoA()), Boolean.valueOf(localam.gJG()), Boolean.valueOf(localao.gJQ()) });
    if ((locala.eoA()) && (localam.gJG()) && (localao.gJQ()))
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