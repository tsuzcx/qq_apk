package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.pluginsdk.ui.d.o.a;

final class BaseTimeLineItem$4
  implements o.a
{
  BaseTimeLineItem$4(BaseTimeLineItem paramBaseTimeLineItem, av paramav) {}
  
  public final void a(View paramView, Object paramObject)
  {
    AppMethodBeat.i(40118);
    if (this.sgJ.rOK != null) {
      if (!(paramObject instanceof a)) {
        break label78;
      }
    }
    label78:
    for (boolean bool = ((a)paramObject).raZ;; bool = false)
    {
      if (bool) {}
      for (this.sgJ.rOK.cpt = 0;; this.sgJ.rOK.cpt = 6)
      {
        this.sgJ.rOK.a(paramView, paramObject);
        AppMethodBeat.o(40118);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.4
 * JD-Core Version:    0.7.0.1
 */