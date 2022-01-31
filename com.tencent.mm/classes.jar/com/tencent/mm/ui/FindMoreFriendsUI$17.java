package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;

final class FindMoreFriendsUI$17
  implements Runnable
{
  FindMoreFriendsUI$17(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29233);
    ab.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", new Object[] { Integer.valueOf(FindMoreFriendsUI.u(this.yWI)), Integer.valueOf(r.Zr()), Long.valueOf(FindMoreFriendsUI.v(this.yWI)), Long.valueOf(r.Zs()), Integer.valueOf(FindMoreFriendsUI.w(this.yWI)), Integer.valueOf(r.Zy()) });
    FindMoreFriendsUI.a(this.yWI, r.Zs());
    FindMoreFriendsUI.a(this.yWI, r.Zr());
    FindMoreFriendsUI.b(this.yWI, r.Zy());
    FindMoreFriendsUI.x(this.yWI);
    AppMethodBeat.o(29233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.17
 * JD-Core Version:    0.7.0.1
 */