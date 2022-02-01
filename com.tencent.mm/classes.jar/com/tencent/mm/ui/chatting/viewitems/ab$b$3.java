package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab$b$3
  implements Runnable
{
  ab$b$3(ab.b paramb, ab.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(255322);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.aeQV.clickArea.getLayoutParams();
    localLayoutParams.height = this.aeQV.aeQT.getHeight();
    localLayoutParams.width = this.aeQV.aeQT.getWidth();
    this.aeQV.clickArea.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(255322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b.3
 * JD-Core Version:    0.7.0.1
 */