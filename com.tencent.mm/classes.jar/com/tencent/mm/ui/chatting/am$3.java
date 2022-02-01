package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.List;

final class am$3
  implements n.d
{
  am$3(List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(34898);
    Iterator localIterator = this.JZe.iterator();
    while (localIterator.hasNext()) {
      paraml.add((String)localIterator.next());
    }
    AppMethodBeat.o(34898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am.3
 * JD-Core Version:    0.7.0.1
 */