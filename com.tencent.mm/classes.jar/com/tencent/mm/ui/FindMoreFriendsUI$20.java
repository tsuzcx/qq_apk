package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$20
  extends a
{
  FindMoreFriendsUI$20(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(29236);
    ab.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", new Object[] { paramb });
    if ((paramb instanceof je))
    {
      FindMoreFriendsUI.e(this.yWI);
      if (FindMoreFriendsUI.a(this.yWI) != null) {
        FindMoreFriendsUI.a(this.yWI).notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(29236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.20
 * JD-Core Version:    0.7.0.1
 */