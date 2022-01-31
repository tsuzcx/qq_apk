package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.k;
import com.tencent.mm.sdk.b.c;

final class g$23
  implements Runnable
{
  g$23(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(153157);
    if (AppForegroundDelegate.bXk.bLR)
    {
      k localk = new k();
      localk.cmu.isActive = true;
      this.uYd.kMK.callback(localk);
    }
    AppMethodBeat.o(153157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.23
 * JD-Core Version:    0.7.0.1
 */