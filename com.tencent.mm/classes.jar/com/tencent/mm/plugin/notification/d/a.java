package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends y
  implements com.tencent.mm.kernel.a.b.b
{
  private static a GAl;
  
  private a()
  {
    super(com.tencent.mm.by.b.bsk("notification"));
    AppMethodBeat.i(26743);
    AppMethodBeat.o(26743);
  }
  
  public static a fky()
  {
    try
    {
      AppMethodBeat.i(267247);
      if (GAl == null) {
        GAl = new a();
      }
      a locala = GAl;
      AppMethodBeat.o(267247);
      return locala;
    }
    finally {}
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(26744);
    com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(h.ag(n.class));
    AppMethodBeat.o(26744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.a
 * JD-Core Version:    0.7.0.1
 */