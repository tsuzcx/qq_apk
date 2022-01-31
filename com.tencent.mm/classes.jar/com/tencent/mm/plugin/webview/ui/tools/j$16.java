package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class j$16
  implements Runnable
{
  j$16(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(7655);
    if ((this.vcO.ddt().isFinishing()) || (this.vcO.ddt().vfK))
    {
      ab.i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
      AppMethodBeat.o(7655);
      return;
    }
    this.vcO.iOd.crd();
    AppMethodBeat.o(7655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.16
 * JD-Core Version:    0.7.0.1
 */