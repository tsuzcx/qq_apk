package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class c$19
  implements o.f
{
  c$19(c paramc) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(27089);
    if ((c.c(this.Bfj) != null) && (c.c(this.Bfj).UF()))
    {
      paramm.kV(1, 2131758047);
      paramm.kV(3, 2131756736);
      paramm.kV(4, 2131757848);
      paramm.kV(5, 2131757805);
      AppMethodBeat.o(27089);
      return;
    }
    if ((c.c(this.Bfj) != null) && (c.c(this.Bfj).UG()))
    {
      paramm.kV(5, 2131757805);
      AppMethodBeat.o(27089);
      return;
    }
    paramm.kV(1, 2131758047);
    paramm.kV(2, 2131757824);
    if (!ab.JM(c.d(this.Bfj).field_username))
    {
      paramm.kV(3, 2131756736);
      paramm.kV(4, 2131757848);
    }
    paramm.kV(5, 2131757805);
    AppMethodBeat.o(27089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.19
 * JD-Core Version:    0.7.0.1
 */