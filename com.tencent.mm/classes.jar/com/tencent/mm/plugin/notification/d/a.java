package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends y
  implements com.tencent.mm.kernel.a.b.b
{
  private static a AHc;
  
  private a()
  {
    super(com.tencent.mm.br.b.bfR("notification"));
    AppMethodBeat.i(26743);
    AppMethodBeat.o(26743);
  }
  
  public static a eyT()
  {
    try
    {
      AppMethodBeat.i(231769);
      if (AHc == null) {
        AHc = new a();
      }
      a locala = AHc;
      AppMethodBeat.o(231769);
      return locala;
    }
    finally {}
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(26744);
    com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(n.class));
    AppMethodBeat.o(26744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.a
 * JD-Core Version:    0.7.0.1
 */