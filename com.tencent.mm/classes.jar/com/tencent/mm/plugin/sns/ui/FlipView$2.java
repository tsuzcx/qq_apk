package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class FlipView$2
  implements n.c
{
  FlipView$2(FlipView paramFlipView, List paramList1, List paramList2, String paramString1, String paramString2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(38227);
    FlipView.a(this.rGJ).setFooterView(null);
    paraml.clear();
    int i = 0;
    if (i < this.mwc.size())
    {
      if (((Integer)this.rGK.get(i)).intValue() == 4) {
        FlipView.a(this.rGJ).setFooterView(FlipView.a(this.rGJ, this.nlv, this.Cq));
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.e(((Integer)this.rGK.get(i)).intValue(), (CharSequence)this.mwc.get(i));
      }
    }
    AppMethodBeat.o(38227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView.2
 * JD-Core Version:    0.7.0.1
 */