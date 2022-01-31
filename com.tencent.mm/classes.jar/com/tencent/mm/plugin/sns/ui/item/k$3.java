package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.sdk.platformtools.bo;

final class k$3
  implements b.f
{
  k$3(k paramk, av paramav, long paramLong, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(40168);
    if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
    {
      AppMethodBeat.o(40168);
      return;
    }
    if (paramLong >= 3L)
    {
      int i = (int)paramb.cmE();
      this.sgJ.rWP.rFk.c(this.sgG, bo.yB(), false);
      this.sgJ.rWP.rFk.f(this.sgG, i, false);
      this.sgJ.rWP.rFk.V(this.sgG, this.sgG);
      this.rFH.sfG.qVe.setOnDecodeDurationListener(null);
    }
    AppMethodBeat.o(40168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k.3
 * JD-Core Version:    0.7.0.1
 */