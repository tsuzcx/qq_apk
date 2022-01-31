package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.pluginsdk.ui.d.o.a;

final class BaseTimeLineItem$3
  implements o.a
{
  BaseTimeLineItem$3(BaseTimeLineItem paramBaseTimeLineItem, av paramav) {}
  
  public final void a(View paramView, Object paramObject)
  {
    AppMethodBeat.i(40117);
    if (this.sgJ.rOK != null)
    {
      this.sgJ.rOK.cpt = 0;
      this.sgJ.rOK.a(paramView, paramObject);
    }
    AppMethodBeat.o(40117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.3
 * JD-Core Version:    0.7.0.1
 */