package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.Iterator;
import java.util.List;

final class an$3
  implements q.f
{
  an$3(List paramList) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(34898);
    Iterator localIterator = this.WEg.iterator();
    while (localIterator.hasNext()) {
      paramo.add((String)localIterator.next());
    }
    AppMethodBeat.o(34898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an.3
 * JD-Core Version:    0.7.0.1
 */