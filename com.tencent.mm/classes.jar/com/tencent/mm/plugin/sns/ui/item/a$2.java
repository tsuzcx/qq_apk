package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.i;

final class a$2
  implements b.e
{
  a$2(a parama, av paramav, aw paramaw) {}
  
  public final void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(40129);
    if (paramInt != -1)
    {
      if ((this.sgJ == null) || (this.sgJ.rWP == null) || (this.sgJ.rWP.rFk == null))
      {
        AppMethodBeat.o(40129);
        return;
      }
      this.sgJ.rWP.rFk.v(this.shU.rZw, false);
    }
    AppMethodBeat.o(40129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.2
 * JD-Core Version:    0.7.0.1
 */