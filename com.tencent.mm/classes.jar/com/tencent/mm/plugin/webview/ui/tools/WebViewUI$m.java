package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class WebViewUI$m
{
  private int vgU = 0;
  
  protected WebViewUI$m(WebViewUI paramWebViewUI) {}
  
  public final void deQ()
  {
    AppMethodBeat.i(7955);
    ab.d("MicroMsg.WebViewUI", "addGetA8KeySceneEndListener, before inc count=%d", new Object[] { Integer.valueOf(this.vgU) });
    if (this.vgU == 0) {
      WebViewUI.d(this.vgz, 233);
    }
    this.vgU += 1;
    AppMethodBeat.o(7955);
  }
  
  public final void deR()
  {
    AppMethodBeat.i(7956);
    ab.d("MicroMsg.WebViewUI", "removeGetA8KeySceneEndListener, before dec count=%d", new Object[] { Integer.valueOf(this.vgU) });
    this.vgU -= 1;
    if (this.vgU <= 0) {
      WebViewUI.e(this.vgz, 233);
    }
    AppMethodBeat.o(7956);
  }
  
  public final boolean deS()
  {
    AppMethodBeat.i(7957);
    ab.d("MicroMsg.WebViewUI", "GetA8KeySceneEndController.hasAddListener count=%d", new Object[] { Integer.valueOf(this.vgU) });
    if (this.vgU > 0)
    {
      AppMethodBeat.o(7957);
      return true;
    }
    AppMethodBeat.o(7957);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.m
 * JD-Core Version:    0.7.0.1
 */