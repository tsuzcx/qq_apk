package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$2$1
  implements Runnable
{
  i$2$1(i.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(8175);
    if (this.vhU.vhT.getParent() != null) {
      ((ViewGroup)this.vhU.vhT.getParent()).removeView(this.vhU.vhT);
    }
    AppMethodBeat.o(8175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i.2.1
 * JD-Core Version:    0.7.0.1
 */