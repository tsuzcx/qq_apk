package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public final class a$2
  implements n.c
{
  public a$2(a parama, List paramList, d paramd) {}
  
  public final void a(l paraml)
  {
    int i = 0;
    while (i < this.kbG.size())
    {
      y localy = (y)this.kbG.get(i);
      paraml.a(i, localy.title, localy.desc);
      if (localy.fmm) {
        this.fnd.wno = i;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.2
 * JD-Core Version:    0.7.0.1
 */