package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

public final class a$2
  implements n.c
{
  public a$2(a parama, List paramList, d paramd) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(91474);
    int i = 0;
    while (i < this.mwc.size())
    {
      y localy = (y)this.mwc.get(i);
      paraml.a(i, localy.title, localy.desc);
      if (localy.gDG) {
        this.gEx.udx = i;
      }
      i += 1;
    }
    AppMethodBeat.o(91474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.2
 * JD-Core Version:    0.7.0.1
 */