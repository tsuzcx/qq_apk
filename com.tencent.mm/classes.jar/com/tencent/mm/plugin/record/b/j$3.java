package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import java.util.Iterator;
import java.util.Vector;

final class j$3
  implements Runnable
{
  j$3(j paramj, int paramInt, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(135677);
    Iterator localIterator = j.a(this.pYI).iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(this.bHS, this.pYJ);
    }
    AppMethodBeat.o(135677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.j.3
 * JD-Core Version:    0.7.0.1
 */