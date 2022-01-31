package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.i;

final class j$1
  implements b.e
{
  j$1(j paramj, av paramav, long paramLong, boolean paramBoolean) {}
  
  public final void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(40156);
    if (paramInt != -1)
    {
      if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
      {
        AppMethodBeat.o(40156);
        return;
      }
      this.sgJ.rWP.rFk.v(this.sgG, this.qZq);
    }
    AppMethodBeat.o(40156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j.1
 * JD-Core Version:    0.7.0.1
 */