package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.Iterator;
import java.util.List;

final class n$3
  implements o.f
{
  n$3(List paramList) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(34463);
    paramm.aS(1193046, 2131763028, 2131231635);
    Iterator localIterator = this.PgG.iterator();
    while (localIterator.hasNext()) {
      paramm.add((String)localIterator.next());
    }
    AppMethodBeat.o(34463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.3
 * JD-Core Version:    0.7.0.1
 */