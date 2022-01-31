package com.tencent.mm.plugin.sight.decode.ui;

import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1$2
  implements Runnable
{
  c$1$2(c.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(70278);
    c.d(this.qUm.qUl).setVisibility(0);
    c.d(this.qUm.qUl).startAnimation(AnimationUtils.loadAnimation(this.qUm.qUl.getContext(), 2131034181));
    AppMethodBeat.o(70278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c.1.2
 * JD-Core Version:    0.7.0.1
 */