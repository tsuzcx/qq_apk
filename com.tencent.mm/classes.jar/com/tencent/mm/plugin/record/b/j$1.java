package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.d;
import java.util.Vector;

final class j$1
  implements Runnable
{
  j$1(j paramj, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(135675);
    if (!j.a(this.pYI).contains(this.pYH)) {
      j.a(this.pYI).add(this.pYH);
    }
    AppMethodBeat.o(135675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.j.1
 * JD-Core Version:    0.7.0.1
 */