package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.Iterator;
import java.util.List;

final class n$3
  implements q.f
{
  n$3(List paramList) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(34463);
    paramo.aW(1193046, R.l.eLR, R.g.dmK);
    Iterator localIterator = this.WzZ.iterator();
    while (localIterator.hasNext()) {
      paramo.add((String)localIterator.next());
    }
    AppMethodBeat.o(34463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.3
 * JD-Core Version:    0.7.0.1
 */