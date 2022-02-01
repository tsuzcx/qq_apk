package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

final class u$5
  implements n.c
{
  u$5(u paramu, List paramList1, List paramList2, p paramp) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(97899);
    this.yAb.yyJ.setFooterView(null);
    paraml.clear();
    int i = 0;
    if (i < this.yAc.size())
    {
      if (((Integer)this.yAd.get(i)).intValue() == 7) {
        this.yAb.yyJ.setFooterView(u.a(this.yAb, this.yyM));
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.c(((Integer)this.yAd.get(i)).intValue(), (CharSequence)this.yAc.get(i));
      }
    }
    paraml.c(-1, this.yAb.context.getString(2131763797));
    AppMethodBeat.o(97899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u.5
 * JD-Core Version:    0.7.0.1
 */