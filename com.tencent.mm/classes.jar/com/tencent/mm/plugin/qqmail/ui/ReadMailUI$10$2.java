package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class ReadMailUI$10$2
  implements Runnable
{
  ReadMailUI$10$2(ReadMailUI.10 param10) {}
  
  public final void run()
  {
    AppMethodBeat.i(68431);
    int i = (int)(ReadMailUI.g(this.pPc.pOX).getContentHeight() * ReadMailUI.g(this.pPc.pOX).getScale());
    ab.d("MicroMsg.ReadMailUI", ReadMailUI.g(this.pPc.pOX).getContentHeight() + "," + ReadMailUI.g(this.pPc.pOX).getHeight() + "," + ReadMailUI.g(this.pPc.pOX).getScale());
    if (Math.abs(i - ReadMailUI.g(this.pPc.pOX).getHeight()) < 10) {
      ((h)ReadMailUI.g(this.pPc.pOX)).oH(true);
    }
    AppMethodBeat.o(68431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10.2
 * JD-Core Version:    0.7.0.1
 */