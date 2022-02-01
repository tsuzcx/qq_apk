package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.List;

final class SnsTimeLineUI$58
  implements n.d
{
  SnsTimeLineUI$58(SnsTimeLineUI paramSnsTimeLineUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(219991);
    paraml.clear();
    Iterator localIterator = this.jon.iterator();
    while (localIterator.hasNext()) {
      paraml.g((m)localIterator.next());
    }
    AppMethodBeat.o(219991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.58
 * JD-Core Version:    0.7.0.1
 */