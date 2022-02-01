package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  b EsV;
  WebViewSmileyPanel.a EsW;
  Context nhZ;
  boolean nip = false;
  int nit;
  int niu;
  
  public final a eVO()
  {
    AppMethodBeat.i(82355);
    if (this.EsV == null)
    {
      this.EsV = new b();
      this.EsV.nhZ = this.nhZ;
      this.EsV.setPanelManager(this);
    }
    b localb = this.EsV;
    AppMethodBeat.o(82355);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */