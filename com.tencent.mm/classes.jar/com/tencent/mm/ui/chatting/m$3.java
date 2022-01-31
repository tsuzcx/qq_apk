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
    AppMethodBeat.i(30599);
    paraml.aw(1193046, 2131301549, 2130838235);
    Iterator localIterator = this.zyw.iterator();
    while (localIterator.hasNext()) {
      paraml.add((String)localIterator.next());
    }
    AppMethodBeat.o(30599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.3
 * JD-Core Version:    0.7.0.1
 */