package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.ui.MMActivity;

final class c$8
  implements Runnable
{
  c$8(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(23464);
    if (this.pzT.cmc.isFinishing())
    {
      AppMethodBeat.o(23464);
      return;
    }
    b.Y(this.pzT.cmc, this.pzT.contact.field_username);
    b.x(this.pzT.cmc);
    AppMethodBeat.o(23464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.8
 * JD-Core Version:    0.7.0.1
 */