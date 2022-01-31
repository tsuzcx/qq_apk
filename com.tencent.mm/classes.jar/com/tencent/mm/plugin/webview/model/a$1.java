package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class a$1
  implements Runnable
{
  a$1(String paramString, MMWebView paramMMWebView) {}
  
  public final void run()
  {
    AppMethodBeat.i(6562);
    l.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6561);
        if (this.iLL)
        {
          a.a(a.1.this.uVe, true);
          ab.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
          AppMethodBeat.o(6561);
          return;
        }
        a.a(a.1.this.uVe, false);
        ab.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
        AppMethodBeat.o(6561);
      }
    });
    AppMethodBeat.o(6562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.a.1
 * JD-Core Version:    0.7.0.1
 */