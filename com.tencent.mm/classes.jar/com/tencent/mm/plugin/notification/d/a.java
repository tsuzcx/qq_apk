package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends u
  implements b
{
  private static a wLA;
  
  private a()
  {
    super(com.tencent.mm.br.c.aPo("notification"));
    AppMethodBeat.i(26743);
    AppMethodBeat.o(26743);
  }
  
  public static a dzm()
  {
    try
    {
      AppMethodBeat.i(186486);
      if (wLA == null) {
        wLA = new a();
      }
      a locala = wLA;
      AppMethodBeat.o(186486);
      return locala;
    }
    finally {}
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(26744);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bA(g.ad(n.class));
    AppMethodBeat.o(26744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.a
 * JD-Core Version:    0.7.0.1
 */