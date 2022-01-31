package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ae;

public final class a
  extends q
  implements b
{
  public a()
  {
    super(com.tencent.mm.bq.c.anc("wenote"));
    AppMethodBeat.i(26593);
    AppMethodBeat.o(26593);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(26594);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(ae.class));
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(com.tencent.mm.plugin.record.a.a.class));
    AppMethodBeat.o(26594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a
 * JD-Core Version:    0.7.0.1
 */