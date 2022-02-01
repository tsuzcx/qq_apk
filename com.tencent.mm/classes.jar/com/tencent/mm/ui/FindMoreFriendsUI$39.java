package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vr;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$39
  extends a
{
  FindMoreFriendsUI$39(FindMoreFriendsUI paramFindMoreFriendsUI)
  {
    AppMethodBeat.i(161494);
    AppMethodBeat.o(161494);
  }
  
  public final void g(IEvent paramIEvent)
  {
    AppMethodBeat.i(287943);
    if ((paramIEvent instanceof vr))
    {
      FindMoreFriendsUI.g(this.VUs);
      FindMoreFriendsUI.a(this.VUs).notifyDataSetChanged();
    }
    AppMethodBeat.o(287943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.39
 * JD-Core Version:    0.7.0.1
 */