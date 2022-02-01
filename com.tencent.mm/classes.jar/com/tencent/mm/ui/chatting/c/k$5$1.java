package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.d.a;

final class k$5$1
  implements n.c
{
  k$5$1(k.5 param5) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(35200);
    paraml.jw(0, 2131761385);
    paraml.jw(1, 2131761386);
    if (am.lL(this.HTr.HTn.cLy.HZF.getContext())) {
      paraml.c(2, this.HTr.HTn.cLy.HZF.getContext().getString(2131761387, new Object[] { am.lM(this.HTr.HTn.cLy.HZF.getContext()) }));
    }
    AppMethodBeat.o(35200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k.5.1
 * JD-Core Version:    0.7.0.1
 */