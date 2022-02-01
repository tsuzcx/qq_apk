package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import java.util.Iterator;
import java.util.List;

final class SnsTimeLineUI$63
  implements u.g
{
  SnsTimeLineUI$63(SnsTimeLineUI paramSnsTimeLineUI, List paramList) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(307943);
    params.clear();
    Iterator localIterator = this.pZG.iterator();
    while (localIterator.hasNext()) {
      params.j((t)localIterator.next());
    }
    AppMethodBeat.o(307943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.63
 * JD-Core Version:    0.7.0.1
 */