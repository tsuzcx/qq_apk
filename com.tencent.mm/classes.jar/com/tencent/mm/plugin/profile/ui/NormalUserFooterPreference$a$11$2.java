package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class NormalUserFooterPreference$a$11$2
  implements n.c
{
  NormalUserFooterPreference$a$11$2(NormalUserFooterPreference.a.11 param11) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(23687);
    if (!this.pCk.pCi)
    {
      if (!ad.arf(NormalUserFooterPreference.a(this.pCk.pCf.pCe).field_username)) {
        break label95;
      }
      paraml.aw(1, 2131298849, 2131231033);
    }
    while (!this.pCk.pCj) {
      if (NormalUserFooterPreference.a(this.pCk.pCf.pCe).NW())
      {
        paraml.aw(8, 2131298680, 2131231002);
        AppMethodBeat.o(23687);
        return;
        label95:
        paraml.aw(1, 2131298670, 2131231033);
      }
      else if (!t.nS(NormalUserFooterPreference.a(this.pCk.pCf.pCe).field_username))
      {
        paraml.aw(5, 2131298675, 2131231002);
      }
    }
    AppMethodBeat.o(23687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11.2
 * JD-Core Version:    0.7.0.1
 */