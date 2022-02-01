package com.tencent.mm.ui.chatting.viewitems;

import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$b$1
  implements Runnable
{
  y$b$1(y.b paramb, y.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(36966);
    this.aeQJ.HLM.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.aeQJ.HLM.getWidth(), this.aeQJ.HLM.getHeight());
    this.aeQJ.HLN.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(36966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b.1
 * JD-Core Version:    0.7.0.1
 */