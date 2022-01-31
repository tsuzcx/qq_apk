package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$24
  extends a
{
  FindMoreFriendsUI$24(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(29244);
    if ((paramb instanceof gz))
    {
      FindMoreFriendsUI.g(this.yWI);
      FindMoreFriendsUI.a(this.yWI).notifyDataSetChanged();
    }
    AppMethodBeat.o(29244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.24
 * JD-Core Version:    0.7.0.1
 */