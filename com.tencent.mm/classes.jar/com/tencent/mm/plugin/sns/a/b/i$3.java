package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cec;
import java.util.LinkedList;

final class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(35752);
    if ((System.currentTimeMillis() - i.b(this.raa) >= 60000L) || (i.a(this.raa).wok.size() > 1000))
    {
      if ((i.a(this.raa) != null) && (i.a(this.raa).wok.size() > 0)) {
        i.d(this.raa);
      }
      i.a(this.raa, 0L);
    }
    AppMethodBeat.o(35752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i.3
 * JD-Core Version:    0.7.0.1
 */