package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.Iterator;
import java.util.List;

final class ap$3
  implements u.g
{
  ap$3(List paramList) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(34898);
    Iterator localIterator = this.aelG.iterator();
    while (localIterator.hasNext()) {
      params.add((String)localIterator.next());
    }
    AppMethodBeat.o(34898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ap.3
 * JD-Core Version:    0.7.0.1
 */