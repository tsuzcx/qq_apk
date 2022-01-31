package com.tencent.mm.ui.chatting.viewitems;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$c$1
  implements Runnable
{
  l$c$1(l.c paramc, l.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(32959);
    this.zUc.mZY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.zUc.mZY.getWidth(), this.zUc.mZY.getHeight());
    this.zUc.nef.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(32959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c.1
 * JD-Core Version:    0.7.0.1
 */