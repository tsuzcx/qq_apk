package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class m$3
  implements n.c
{
  m$3(List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(34463);
    paraml.aJ(1193046, 2131761219, 2131231571);
    Iterator localIterator = this.HMN.iterator();
    while (localIterator.hasNext()) {
      paraml.add((String)localIterator.next());
    }
    AppMethodBeat.o(34463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.3
 * JD-Core Version:    0.7.0.1
 */