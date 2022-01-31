package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class ag
{
  static ArrayList<n> mjj = null;
  private static ag ulq = null;
  bz.a kMG;
  
  private ag()
  {
    AppMethodBeat.i(46920);
    this.kMG = new ag.1(this);
    AppMethodBeat.o(46920);
  }
  
  public static boolean a(n paramn)
  {
    AppMethodBeat.i(46922);
    if (mjj == null) {
      mjj = new ArrayList();
    }
    mjj.add(paramn);
    AppMethodBeat.o(46922);
    return true;
  }
  
  public static boolean b(n paramn)
  {
    AppMethodBeat.i(46923);
    if (mjj == null)
    {
      ab.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      AppMethodBeat.o(46923);
      return false;
    }
    mjj.remove(paramn);
    AppMethodBeat.o(46923);
    return true;
  }
  
  public static ag cTY()
  {
    AppMethodBeat.i(46921);
    if (ulq == null) {
      ulq = new ag();
    }
    ag localag = ulq;
    AppMethodBeat.o(46921);
    return localag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */