package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$2
  implements b.f
{
  c$2(c paramc, av paramav, aw paramaw, c.a parama, b.c paramc1, n paramn) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(40136);
    if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
    {
      AppMethodBeat.o(40136);
      return;
    }
    if ((!this.sgJ.rWP.rFk.lj(this.shU.rZw)) && (paramLong >= 3L))
    {
      i = (int)paramb.cmE();
      this.sgJ.rWP.rFk.c(this.shU.rZw, bo.yB(), false);
      this.sgJ.rWP.rFk.f(this.shU.rZw, i, false);
      this.sgJ.rWP.rFk.V(this.shU.rZw, this.shU.rZw);
    }
    ab.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", new Object[] { Long.valueOf(paramLong) });
    int i = (int)paramLong;
    c.a(this.sih, this.sii, this.sij, this.rFG, i * 1000);
    AppMethodBeat.o(40136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c.2
 * JD-Core Version:    0.7.0.1
 */