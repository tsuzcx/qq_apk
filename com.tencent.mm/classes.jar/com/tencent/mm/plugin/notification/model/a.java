package com.tencent.mm.plugin.notification.model;

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
  private static a Mwv;
  
  private a()
  {
    super(com.tencent.mm.br.b.bsb("notification"));
    AppMethodBeat.i(26743);
    AppMethodBeat.o(26743);
  }
  
  public static a guP()
  {
    try
    {
      AppMethodBeat.i(271933);
      if (Mwv == null) {
        Mwv = new a();
      }
      a locala = Mwv;
      AppMethodBeat.o(271933);
      return locala;
    }
    finally {}
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(26744);
    com.tencent.mm.kernel.a.b.a.a(this, c.class).db(h.az(n.class));
    AppMethodBeat.o(26744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.model.a
 * JD-Core Version:    0.7.0.1
 */