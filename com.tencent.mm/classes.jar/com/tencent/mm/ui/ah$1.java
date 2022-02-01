package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.updater.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;

final class ah$1
  implements Runnable
{
  ah$1(ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(33490);
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
      AppMethodBeat.o(33490);
      return;
    }
    if (ah.a(this.adHs) == null)
    {
      Log.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
      AppMethodBeat.o(33490);
      return;
    }
    g.jJU().d(new ah.1.2(this)).f(new ah.1.1(this)).b(ah.b(this.adHs));
    if (((a)h.az(a.class)).hasBottomTabRedDot()) {
      ah.a(this.adHs).KU(true);
    }
    AppMethodBeat.o(33490);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(33491);
    String str = super.toString() + "|setTagRunnable";
    AppMethodBeat.o(33491);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ah.1
 * JD-Core Version:    0.7.0.1
 */