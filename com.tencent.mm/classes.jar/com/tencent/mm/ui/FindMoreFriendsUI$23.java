package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.rc;
import com.tencent.mm.f.a.rc.a;
import com.tencent.mm.f.a.rd;
import com.tencent.mm.f.a.rd.a;
import com.tencent.mm.sdk.event.EventCenter;

final class FindMoreFriendsUI$23
  implements Runnable
{
  FindMoreFriendsUI$23(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33064);
    FindMoreFriendsUI.hGr();
    rd localrd = new rd();
    EventCenter.instance.publish(localrd);
    if (!localrd.fQd.fQf)
    {
      rc localrc = new rc();
      EventCenter.instance.publish(localrc);
      if (localrc.fQa.fxt)
      {
        FindMoreFriendsUI.a(this.VUs, localrc);
        AppMethodBeat.o(33064);
        return;
      }
    }
    FindMoreFriendsUI.a(this.VUs, localrd);
    AppMethodBeat.o(33064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.23
 * JD-Core Version:    0.7.0.1
 */