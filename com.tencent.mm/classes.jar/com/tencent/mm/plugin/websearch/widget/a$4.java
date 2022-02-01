package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.q;

final class a$4
  implements g
{
  a$4(a parama, String paramString) {}
  
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(177342);
    if (q.B(parame.fOK()).equals(this.DDZ))
    {
      AppMethodBeat.o(177342);
      return false;
    }
    AppMethodBeat.o(177342);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.4
 * JD-Core Version:    0.7.0.1
 */