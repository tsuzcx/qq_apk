package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.g.a.pm.a;
import com.tencent.mm.sdk.b.a;

final class FindMoreFriendsUI$21
  implements Runnable
{
  FindMoreFriendsUI$21(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(193614);
    FindMoreFriendsUI.fvT();
    pm localpm = new pm();
    a.IbL.l(localpm);
    if (!localpm.dDG.dDJ)
    {
      pl localpl = new pl();
      a.IbL.l(localpl);
      if (localpl.dDD.dmo)
      {
        FindMoreFriendsUI.a(this.IWp, localpl);
        AppMethodBeat.o(193614);
        return;
      }
    }
    FindMoreFriendsUI.a(this.IWp, localpm);
    AppMethodBeat.o(193614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.21
 * JD-Core Version:    0.7.0.1
 */