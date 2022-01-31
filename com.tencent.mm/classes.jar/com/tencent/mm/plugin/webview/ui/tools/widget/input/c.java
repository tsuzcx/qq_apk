package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  Context jpJ;
  boolean jqa = false;
  int jqe;
  int jqf;
  b vtI;
  WebViewSmileyPanel.a vtJ;
  
  public final a dhd()
  {
    AppMethodBeat.i(10119);
    if (this.vtI == null)
    {
      this.vtI = new b();
      this.vtI.jpJ = this.jpJ;
      this.vtI.setPanelManager(this);
    }
    b localb = this.vtI;
    AppMethodBeat.o(10119);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */