package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;

final class FindMoreFriendsUI$18
  implements Runnable
{
  FindMoreFriendsUI$18(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29234);
    FindMoreFriendsUI.a(this.yWI, r.Zr());
    FindMoreFriendsUI.b(this.yWI, r.Zy());
    FindMoreFriendsUI.a(this.yWI, r.Zs());
    long l = System.currentTimeMillis();
    FindMoreFriendsUI.x(this.yWI);
    ab.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(29234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.18
 * JD-Core Version:    0.7.0.1
 */