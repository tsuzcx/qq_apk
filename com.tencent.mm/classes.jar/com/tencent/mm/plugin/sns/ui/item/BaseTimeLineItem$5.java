package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.pluginsdk.ui.d.o.a;

final class BaseTimeLineItem$5
  implements o.a
{
  BaseTimeLineItem$5(BaseTimeLineItem paramBaseTimeLineItem) {}
  
  public final void a(View paramView, Object paramObject)
  {
    AppMethodBeat.i(40119);
    if (this.sgI.rkX.rOK != null)
    {
      this.sgI.rkX.rOK.cpt = 13;
      this.sgI.rkX.rOK.a(paramView, paramObject);
    }
    AppMethodBeat.o(40119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.5
 * JD-Core Version:    0.7.0.1
 */