package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;

final class ReadMailUI$10$1
  implements Runnable
{
  ReadMailUI$10$1(ReadMailUI.10 param10) {}
  
  public final void run()
  {
    AppMethodBeat.i(68430);
    ReadMailUI.g(this.pPc.pOX).getSettings().setLoadsImagesAutomatically(true);
    ReadMailUI.g(this.pPc.pOX).getSettings().setSupportZoom(true);
    ReadMailUI.g(this.pPc.pOX).getSettings().setBuiltInZoomControls(true);
    ((h)ReadMailUI.g(this.pPc.pOX)).dgU();
    ((h)ReadMailUI.g(this.pPc.pOX)).dgV();
    AppMethodBeat.o(68430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10.1
 * JD-Core Version:    0.7.0.1
 */