package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.n;

public final class a
  extends t
  implements b
{
  public a()
  {
    super(com.tencent.mm.br.c.aIo("notification"));
    AppMethodBeat.i(26743);
    AppMethodBeat.o(26743);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(26744);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).by(g.ad(n.class));
    AppMethodBeat.o(26744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.a
 * JD-Core Version:    0.7.0.1
 */