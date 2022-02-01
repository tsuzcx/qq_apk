package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

final class w$9
  implements o.f
{
  w$9(w paramw, List paramList1, List paramList2, SnsInfo paramSnsInfo) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(97904);
    this.Erd.Epy.setFooterView(null);
    paramm.clear();
    int i = 0;
    if (i < this.kmw.size())
    {
      if (((Integer)this.Epz.get(i)).intValue() == 7) {
        this.Erd.Epy.setFooterView(w.a(this.Erd, this.EpB));
      }
      for (;;)
      {
        i += 1;
        break;
        paramm.d(((Integer)this.Epz.get(i)).intValue(), (CharSequence)this.kmw.get(i));
      }
    }
    AppMethodBeat.o(97904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w.9
 * JD-Core Version:    0.7.0.1
 */