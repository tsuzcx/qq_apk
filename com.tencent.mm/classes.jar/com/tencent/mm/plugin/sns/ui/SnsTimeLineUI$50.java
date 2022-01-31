package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class SnsTimeLineUI$50
  implements n.c
{
  SnsTimeLineUI$50(SnsTimeLineUI paramSnsTimeLineUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(155759);
    Iterator localIterator = this.gEz.iterator();
    while (localIterator.hasNext()) {
      paraml.f((m)localIterator.next());
    }
    AppMethodBeat.o(155759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.50
 * JD-Core Version:    0.7.0.1
 */