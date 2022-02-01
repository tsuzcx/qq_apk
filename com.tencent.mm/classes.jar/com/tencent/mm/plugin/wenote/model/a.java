package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fav.a.af;

public final class a
  extends y
  implements com.tencent.mm.kernel.a.b.b
{
  public a()
  {
    super(com.tencent.mm.br.b.bfR("wenote"));
    AppMethodBeat.i(30285);
    AppMethodBeat.o(30285);
  }
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(30286);
    com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(af.class));
    com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(com.tencent.mm.plugin.record.a.a.class));
    AppMethodBeat.o(30286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a
 * JD-Core Version:    0.7.0.1
 */