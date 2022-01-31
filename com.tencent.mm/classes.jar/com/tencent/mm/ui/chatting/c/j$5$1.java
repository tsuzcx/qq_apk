package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;

final class j$5$1
  implements n.c
{
  j$5$1(j.5 param5) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(31311);
    paraml.hx(0, 2131301652);
    paraml.hx(1, 2131301653);
    if (WWAPIFactory.jO(this.zEX.zET.caz.zJz.getContext()).dXY()) {
      paraml.e(2, this.zEX.zET.caz.zJz.getContext().getString(2131301654, new Object[] { WWAPIFactory.jO(this.zEX.zET.caz.zJz.getContext()).dXZ() }));
    }
    AppMethodBeat.o(31311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.5.1
 * JD-Core Version:    0.7.0.1
 */