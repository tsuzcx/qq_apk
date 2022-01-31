package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class s$7
  implements n.c
{
  s$7(s params, List paramList1, List paramList2, n paramn) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(38255);
    this.rHr.rHk.setFooterView(null);
    paraml.clear();
    int i = 0;
    if (i < this.gEz.size())
    {
      if (((Integer)this.rHt.get(i)).intValue() == 7) {
        this.rHr.rHk.setFooterView(s.a(this.rHr, this.rHq));
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.e(((Integer)this.rHt.get(i)).intValue(), (CharSequence)this.gEz.get(i));
      }
    }
    AppMethodBeat.o(38255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.7
 * JD-Core Version:    0.7.0.1
 */