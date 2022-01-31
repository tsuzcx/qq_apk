package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class v$1
  implements Runnable
{
  v$1(v paramv, v.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(67992);
    v.b localb = new v.b(this.pJJ, (byte)0);
    v.a(this.pJJ).put(Long.valueOf(this.pJI.id), this.pJI);
    v.b(this.pJJ).put(Long.valueOf(this.pJI.id), localb);
    localb.b(this.pJI);
    AppMethodBeat.o(67992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.1
 * JD-Core Version:    0.7.0.1
 */