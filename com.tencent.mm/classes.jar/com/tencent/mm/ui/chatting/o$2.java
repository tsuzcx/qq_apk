package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.c.b.h;

final class o$2
  implements View.OnClickListener
{
  o$2(o paramo, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30621);
    this.zyG.oC(((Long)paramView.getTag()).longValue());
    AppMethodBeat.o(30621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.2
 * JD-Core Version:    0.7.0.1
 */