package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.h;

final class FindMoreFriendsUI$21$1
  implements Runnable
{
  FindMoreFriendsUI$21$1(FindMoreFriendsUI.21 param21) {}
  
  public final void run()
  {
    AppMethodBeat.i(29237);
    aw.aaz();
    c.Ru().set(68377, "");
    if (FindMoreFriendsUI.a(this.yWV.yWI) != null) {
      FindMoreFriendsUI.a(this.yWV.yWI).notifyDataSetChanged();
    }
    AppMethodBeat.o(29237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.21.1
 * JD-Core Version:    0.7.0.1
 */