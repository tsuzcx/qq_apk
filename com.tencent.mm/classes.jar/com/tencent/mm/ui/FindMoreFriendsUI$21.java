package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mf;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$21
  extends a
{
  FindMoreFriendsUI$21(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void g(IEvent paramIEvent)
  {
    AppMethodBeat.i(33062);
    Log.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", new Object[] { paramIEvent });
    if ((paramIEvent instanceof mf))
    {
      FindMoreFriendsUI.e(this.VUs);
      if (FindMoreFriendsUI.a(this.VUs) != null) {
        FindMoreFriendsUI.a(this.VUs).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(33062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.21
 * JD-Core Version:    0.7.0.1
 */