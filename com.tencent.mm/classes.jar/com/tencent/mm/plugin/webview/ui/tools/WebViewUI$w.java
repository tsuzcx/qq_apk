package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WebViewUI$w
{
  static
  {
    AppMethodBeat.i(7975);
    vgZ = new w("NO_NEED", 0);
    vha = new w("WILL_GET", 1);
    vhb = new w("FAILED", 2);
    vhc = new w[] { vgZ, vha, vhb };
    AppMethodBeat.o(7975);
  }
  
  private WebViewUI$w() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.w
 * JD-Core Version:    0.7.0.1
 */