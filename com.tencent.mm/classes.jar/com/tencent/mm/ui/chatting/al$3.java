package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class al$3
  implements n.c
{
  al$3(List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(31012);
    Iterator localIterator = this.zCo.iterator();
    while (localIterator.hasNext()) {
      paraml.add((String)localIterator.next());
    }
    AppMethodBeat.o(31012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.3
 * JD-Core Version:    0.7.0.1
 */