package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class c$19
  implements n.c
{
  c$19(c paramc) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(23474);
    if ((this.pzT.pyd != null) && (this.pzT.pyd.aeg()))
    {
      paraml.hx(1, 2131298744);
      paraml.hx(3, 2131297684);
      paraml.hx(4, 2131298561);
      paraml.hx(5, 2131298519);
      AppMethodBeat.o(23474);
      return;
    }
    if ((this.pzT.pyd != null) && (this.pzT.pyd.aeh()))
    {
      paraml.hx(5, 2131298519);
      AppMethodBeat.o(23474);
      return;
    }
    paraml.hx(1, 2131298744);
    paraml.hx(2, 2131298538);
    if (!t.oL(this.pzT.contact.field_username))
    {
      paraml.hx(3, 2131297684);
      paraml.hx(4, 2131298561);
    }
    paraml.hx(5, 2131298519);
    AppMethodBeat.o(23474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.19
 * JD-Core Version:    0.7.0.1
 */