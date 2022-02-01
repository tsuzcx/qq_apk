package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  b BwN;
  WebViewSmileyPanel.a BwO;
  Context mfC;
  boolean mfS = false;
  int mfW;
  int mfX;
  
  public final a eru()
  {
    AppMethodBeat.i(82355);
    if (this.BwN == null)
    {
      this.BwN = new b();
      this.BwN.mfC = this.mfC;
      this.BwN.setPanelManager(this);
    }
    b localb = this.BwN;
    AppMethodBeat.o(82355);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */