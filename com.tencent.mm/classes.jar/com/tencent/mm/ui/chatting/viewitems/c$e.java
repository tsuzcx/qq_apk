package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.c.a;
import com.tencent.mm.ui.widget.textview.a.f;

final class c$e
  extends a.f
{
  c.c zRl;
  
  c$e(c.c paramc)
  {
    this.zRl = paramc;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(32801);
    c.c localc = this.zRl;
    if ((localc.zCx != null) && (localc.zCx.dGj())) {
      localc.zCx = null;
    }
    AppMethodBeat.o(32801);
  }
  
  public final void eW(View paramView)
  {
    AppMethodBeat.i(32800);
    this.zRl.t(paramView, 0, 0);
    AppMethodBeat.o(32800);
  }
  
  public final void eX(View paramView)
  {
    AppMethodBeat.i(32802);
    this.zRl.onLongClick(paramView);
    AppMethodBeat.o(32802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.e
 * JD-Core Version:    0.7.0.1
 */