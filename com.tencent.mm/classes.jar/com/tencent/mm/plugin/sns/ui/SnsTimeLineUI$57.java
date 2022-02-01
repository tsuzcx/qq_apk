package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class SnsTimeLineUI$57
  implements n.c
{
  SnsTimeLineUI$57(SnsTimeLineUI paramSnsTimeLineUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(179274);
    Iterator localIterator = this.isg.iterator();
    while (localIterator.hasNext()) {
      paraml.g((m)localIterator.next());
    }
    AppMethodBeat.o(179274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.57
 * JD-Core Version:    0.7.0.1
 */