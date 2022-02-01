package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nl;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.h;

class FindMoreFriendsUI$3
  extends IListenerMStorage
{
  FindMoreFriendsUI$3(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void g(IEvent paramIEvent)
  {
    AppMethodBeat.i(33062);
    Log.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", new Object[] { paramIEvent });
    if ((paramIEvent instanceof nl))
    {
      FindMoreFriendsUI.e(this.adyF);
      if (FindMoreFriendsUI.a(this.adyF) != null) {
        FindMoreFriendsUI.a(this.adyF).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(33062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */