package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  b COV;
  WebViewSmileyPanel.a COW;
  Context mHB;
  boolean mHR = false;
  int mHV;
  int mHW;
  
  public final a eGO()
  {
    AppMethodBeat.i(82355);
    if (this.COV == null)
    {
      this.COV = new b();
      this.COV.mHB = this.mHB;
      this.COV.setPanelManager(this);
    }
    b localb = this.COV;
    AppMethodBeat.o(82355);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */