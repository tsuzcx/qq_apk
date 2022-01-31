package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$25
  extends a
{
  FindMoreFriendsUI$25(FindMoreFriendsUI paramFindMoreFriendsUI) {}
  
  public final void i(b paramb)
  {
    AppMethodBeat.i(29245);
    if ((paramb instanceof qw))
    {
      FindMoreFriendsUI.h(this.yWI);
      FindMoreFriendsUI.a(this.yWI).notifyDataSetChanged();
    }
    AppMethodBeat.o(29245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.25
 * JD-Core Version:    0.7.0.1
 */