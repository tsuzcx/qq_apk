package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private b JBg;
  WebViewSmileyPanel.a JBh;
  Context owO;
  boolean oxd = false;
  int oxh;
  int oxi;
  
  public final a giG()
  {
    AppMethodBeat.i(82355);
    if (this.JBg == null)
    {
      this.JBg = new b();
      this.JBg.owO = this.owO;
      this.JBg.setPanelManager(this);
    }
    b localb = this.JBg;
    AppMethodBeat.o(82355);
    return localb;
  }
  
  public final void onDestroy()
  {
    this.JBg = null;
    this.owO = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */