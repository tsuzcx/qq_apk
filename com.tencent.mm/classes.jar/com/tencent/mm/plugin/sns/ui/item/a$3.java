package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.sdk.platformtools.bo;

final class a$3
  implements b.f
{
  a$3(a parama, av paramav, aw paramaw, a.a parama1) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(40130);
    if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
    {
      AppMethodBeat.o(40130);
      return;
    }
    if (paramLong >= 3L)
    {
      int i = (int)paramb.cmE();
      this.sgJ.rWP.rFk.c(this.shU.rZw, bo.yB(), false);
      this.sgJ.rWP.rFk.f(this.shU.rZw, i, false);
      this.sgJ.rWP.rFk.V(this.shU.rZw, this.shU.rZw);
      this.shS.sfG.qVe.setOnDecodeDurationListener(null);
    }
    AppMethodBeat.o(40130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.3
 * JD-Core Version:    0.7.0.1
 */