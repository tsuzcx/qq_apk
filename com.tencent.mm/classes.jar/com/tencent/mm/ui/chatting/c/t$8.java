package com.tencent.mm.ui.chatting.c;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class t$8
  implements MenuItem.OnMenuItemClickListener
{
  t$8(t paramt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(31486);
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = this.zGC.caz.txj.field_username;
    localux.cLs.context = this.zGC.caz.zJz.getContext();
    if (paramMenuItem.getItemId() == 1) {
      localux.cLs.cLm = 4;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.l(localux);
      AppMethodBeat.o(31486);
      return true;
      if (paramMenuItem.getItemId() == 2) {
        localux.cLs.cLm = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.8
 * JD-Core Version:    0.7.0.1
 */