package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;

final class x$1
  implements Runnable
{
  x$1(x paramx) {}
  
  public final void run()
  {
    AppMethodBeat.i(29653);
    if (!g.RJ().QU())
    {
      ab.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
      AppMethodBeat.o(29653);
      return;
    }
    if (this.zcS.zcL == null)
    {
      ab.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
      AppMethodBeat.o(29653);
      return;
    }
    f.dQr().d(new x.1.2(this)).f(new x.1.1(this)).a(this.zcS.yXg);
    AppMethodBeat.o(29653);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29654);
    String str = super.toString() + "|setTagRunnable";
    AppMethodBeat.o(29654);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.x.1
 * JD-Core Version:    0.7.0.1
 */