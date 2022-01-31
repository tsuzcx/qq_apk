package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends q
  implements b
{
  public a()
  {
    super(com.tencent.mm.bq.c.anc("notification"));
    AppMethodBeat.i(23118);
    AppMethodBeat.o(23118);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(23119);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(n.class));
    AppMethodBeat.o(23119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.a
 * JD-Core Version:    0.7.0.1
 */