package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

final class n$1
  implements n.d
{
  n$1(n paramn, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(97846);
    this.zPX.zPV.setFooterView(null);
    paraml.clear();
    int i = 0;
    while (i < this.jlt.size())
    {
      paraml.c(((Integer)this.zPW.get(i)).intValue(), (CharSequence)this.jlt.get(i));
      i += 1;
    }
    AppMethodBeat.o(97846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.n.1
 * JD-Core Version:    0.7.0.1
 */