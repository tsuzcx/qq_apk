package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.i;

final class k$2
  implements b.e
{
  k$2(k paramk, av paramav, long paramLong) {}
  
  public final void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(40167);
    if (paramInt != -1)
    {
      if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
      {
        AppMethodBeat.o(40167);
        return;
      }
      this.sgJ.rWP.rFk.v(this.sgG, false);
    }
    AppMethodBeat.o(40167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k.2
 * JD-Core Version:    0.7.0.1
 */