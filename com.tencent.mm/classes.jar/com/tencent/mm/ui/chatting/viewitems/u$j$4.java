package com.tencent.mm.ui.chatting.viewitems;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.bi;

final class u$j$4
  implements e.a
{
  u$j$4(u.j paramj, u.c paramc, bi parambi) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(33082);
    this.zUR.zUM.jXG.setVisibility(0);
    if ((this.fkH.field_msgId + "_0").equals(this.zUR.zRD))
    {
      this.zUR.zUM.jXy.setImageResource(2130838314);
      AppMethodBeat.o(33082);
      return;
    }
    this.zUR.zUM.jXy.setImageResource(2130838315);
    AppMethodBeat.o(33082);
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.j.4
 * JD-Core Version:    0.7.0.1
 */