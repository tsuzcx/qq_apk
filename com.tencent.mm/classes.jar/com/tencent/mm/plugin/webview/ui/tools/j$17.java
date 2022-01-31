package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class j$17
  implements Runnable
{
  j$17(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(7656);
    if ((this.vcO.ddt().isFinishing()) || (this.vcO.ddt().vfK))
    {
      ab.i("MicroMsg.WebViewMenuHelper", "tryShow bottom sheet failed, the activity has been destroyed.");
      AppMethodBeat.o(7656);
      return;
    }
    this.vcO.iOd.crd();
    AppMethodBeat.o(7656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.17
 * JD-Core Version:    0.7.0.1
 */