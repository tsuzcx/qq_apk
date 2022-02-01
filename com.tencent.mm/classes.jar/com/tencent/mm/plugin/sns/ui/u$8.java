package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

final class u$8
  implements n.c
{
  u$8(u paramu, List paramList1, List paramList2, p paramp) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(97904);
    this.yAb.yyJ.setFooterView(null);
    paraml.clear();
    int i = 0;
    if (i < this.iSl.size())
    {
      if (((Integer)this.yyK.get(i)).intValue() == 7) {
        this.yAb.yyJ.setFooterView(u.a(this.yAb, this.yyM));
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.c(((Integer)this.yyK.get(i)).intValue(), (CharSequence)this.iSl.get(i));
      }
    }
    AppMethodBeat.o(97904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u.8
 * JD-Core Version:    0.7.0.1
 */