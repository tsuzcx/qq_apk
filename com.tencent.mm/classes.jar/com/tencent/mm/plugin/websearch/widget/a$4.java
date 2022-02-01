package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;

final class a$4
  implements w
{
  a$4(a parama, String paramString) {}
  
  public final boolean accept(u paramu)
  {
    AppMethodBeat.i(177342);
    if (ah.v(paramu.jKT()).equals(this.WsP))
    {
      AppMethodBeat.o(177342);
      return false;
    }
    AppMethodBeat.o(177342);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.4
 * JD-Core Version:    0.7.0.1
 */