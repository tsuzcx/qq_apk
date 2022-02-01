package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xh;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.base.preference.h;

class FindMoreFriendsUI$9
  extends IListenerMStorage
{
  FindMoreFriendsUI$9(FindMoreFriendsUI paramFindMoreFriendsUI)
  {
    AppMethodBeat.i(161494);
    AppMethodBeat.o(161494);
  }
  
  public final void g(IEvent paramIEvent)
  {
    AppMethodBeat.i(250255);
    if ((paramIEvent instanceof xh))
    {
      FindMoreFriendsUI.g(this.adyF);
      FindMoreFriendsUI.a(this.adyF).notifyDataSetChanged();
    }
    AppMethodBeat.o(250255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.9
 * JD-Core Version:    0.7.0.1
 */