package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.Iterator;
import java.util.List;

final class p$3
  implements u.g
{
  p$3(List paramList) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(34463);
    params.bx(1193046, R.l.gNP, R.g.fmW);
    Iterator localIterator = this.aehv.iterator();
    while (localIterator.hasNext()) {
      params.add((String)localIterator.next());
    }
    AppMethodBeat.o(34463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.3
 * JD-Core Version:    0.7.0.1
 */