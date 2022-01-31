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

final class j$2
  implements b.f
{
  j$2(j paramj, av paramav, long paramLong, boolean paramBoolean, int paramInt, aj paramaj) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(40157);
    if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
    {
      AppMethodBeat.o(40157);
      return;
    }
    if (paramLong >= 3L)
    {
      int i = (int)paramb.cmE();
      this.sgJ.rWP.rFk.c(this.sgG, bo.yB(), this.qZq);
      this.sgJ.rWP.rFk.f(this.sgG, i, this.qZq);
      this.sgJ.rWP.rFk.V(this.sgG, this.sgG + this.val$index);
      this.rPD.qVe.setOnDecodeDurationListener(null);
    }
    AppMethodBeat.o(40157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j.2
 * JD-Core Version:    0.7.0.1
 */