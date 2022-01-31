package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class s$4
  implements Runnable
{
  s$4(s params) {}
  
  public final void run()
  {
    AppMethodBeat.i(79792);
    if ((this.vUx.context instanceof MMActivity)) {
      ((MMActivity)this.vUx.context).showVKB();
    }
    AppMethodBeat.o(79792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.4
 * JD-Core Version:    0.7.0.1
 */