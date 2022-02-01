package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class c
{
  WebViewSmileyPanel.a QzA;
  int QzB;
  int QzC;
  boolean Qzx = false;
  private b Qzz;
  Context uEJ;
  
  public static int[] hcp()
  {
    AppMethodBeat.i(237628);
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(237628);
    return new int[] { i, j };
  }
  
  protected static f hcq()
  {
    AppMethodBeat.i(237633);
    f localf = f.htQ();
    AppMethodBeat.o(237633);
    return localf;
  }
  
  public final a hco()
  {
    AppMethodBeat.i(82355);
    if (this.Qzz == null)
    {
      this.Qzz = new b();
      this.Qzz.uEJ = this.uEJ;
      this.Qzz.setPanelManager(this);
    }
    b localb = this.Qzz;
    AppMethodBeat.o(82355);
    return localb;
  }
  
  public final void onDestroy()
  {
    this.Qzz = null;
    this.uEJ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */