package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private b ELp;
  WebViewSmileyPanel.a ELq;
  int nnB;
  int nnC;
  Context nnh;
  boolean nnx = false;
  
  public final a eZA()
  {
    AppMethodBeat.i(82355);
    if (this.ELp == null)
    {
      this.ELp = new b();
      this.ELp.nnh = this.nnh;
      this.ELp.setPanelManager(this);
    }
    b localb = this.ELp;
    AppMethodBeat.o(82355);
    return localb;
  }
  
  public final void onDestroy()
  {
    this.ELp = null;
    this.nnh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */