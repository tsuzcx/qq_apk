package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
{
  public static boolean Iv(int paramInt)
  {
    AppMethodBeat.i(46462);
    g.RM();
    if ((((Integer)g.RL().Ru().get(ac.a.yAU, Integer.valueOf(-1))).intValue() < paramInt) && (paramInt > 0))
    {
      AppMethodBeat.o(46462);
      return true;
    }
    AppMethodBeat.o(46462);
    return false;
  }
  
  public static boolean cST()
  {
    AppMethodBeat.i(46463);
    l locall = (l)g.E(l.class);
    Object localObject = new StringBuilder("mgr==null?");
    ak localak;
    StringBuilder localStringBuilder;
    if (locall == null)
    {
      bool = true;
      ab.i("MicroMsg.WalletUtil", bool);
      if (locall != null) {
        ab.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + locall.bzf());
      }
      s.cRG();
      localObject = s.cRH();
      localak = ((am)localObject).cUt();
      localStringBuilder = new StringBuilder("config==null?");
      if (localak != null) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletUtil", bool);
      if (localak != null) {
        ab.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localak.cUd());
      }
      ab.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((am)localObject).cUl());
      if ((locall == null) || (!locall.bzf()) || (localak == null) || (!localak.cUd()) || (!((am)localObject).cUl())) {
        break label217;
      }
      AppMethodBeat.o(46463);
      return true;
      bool = false;
      break;
    }
    label217:
    AppMethodBeat.o(46463);
    return false;
  }
  
  public static boolean cSU()
  {
    AppMethodBeat.i(46464);
    l locall = (l)g.E(l.class);
    if (locall == null)
    {
      ab.w("MicroMsg.WalletUtil", "no finger mgr!");
      AppMethodBeat.o(46464);
      return false;
    }
    s.cRG();
    am localam = s.cRH();
    ak localak = localam.cUt();
    h.qsU.cT(916, 0);
    ab.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(locall.bzn()), Boolean.valueOf(localak.cUd()), Boolean.valueOf(localam.cUl()) });
    if ((locall.bzn()) && (localak.cUd()) && (localam.cUl()))
    {
      AppMethodBeat.o(46464);
      return true;
    }
    AppMethodBeat.o(46464);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.b.a
 * JD-Core Version:    0.7.0.1
 */