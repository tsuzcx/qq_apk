package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

final class w$6
  implements o.f
{
  w$6(w paramw, List paramList1, List paramList2, SnsInfo paramSnsInfo) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(97899);
    this.Erd.Epy.setFooterView(null);
    paramm.clear();
    int i = 0;
    if (i < this.Ere.size())
    {
      if (((Integer)this.Erf.get(i)).intValue() == 7) {
        this.Erd.Epy.setFooterView(w.a(this.Erd, this.EpB));
      }
      for (;;)
      {
        i += 1;
        break;
        paramm.d(((Integer)this.Erf.get(i)).intValue(), (CharSequence)this.Ere.get(i));
      }
    }
    paramm.d(-1, this.Erd.context.getString(2131766021));
    AppMethodBeat.o(97899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w.6
 * JD-Core Version:    0.7.0.1
 */