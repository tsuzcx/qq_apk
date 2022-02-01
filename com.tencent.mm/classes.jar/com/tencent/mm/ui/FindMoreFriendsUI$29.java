package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sr;
import com.tencent.mm.autogen.a.sr.a;
import com.tencent.mm.autogen.a.ss;
import com.tencent.mm.autogen.a.ss.a;

final class FindMoreFriendsUI$29
  implements Runnable
{
  FindMoreFriendsUI$29(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33064);
    FindMoreFriendsUI.jiz();
    ss localss = new ss();
    localss.publish();
    if (!localss.hVY.hWa)
    {
      sr localsr = new sr();
      localsr.publish();
      if (localsr.hVV.hBY)
      {
        FindMoreFriendsUI.a(this.adyF, localsr);
        AppMethodBeat.o(33064);
        return;
      }
    }
    FindMoreFriendsUI.a(this.adyF, localss);
    AppMethodBeat.o(33064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.29
 * JD-Core Version:    0.7.0.1
 */