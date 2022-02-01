package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.smiley.o;

public class c
{
  boolean Xsr = false;
  private b Xst;
  WebViewSmileyPanel.a Xsu;
  int Xsv;
  int Xsw;
  Context xNl;
  
  public static int[] cSk()
  {
    AppMethodBeat.i(298071);
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    AppMethodBeat.o(298071);
    return new int[] { i, j };
  }
  
  protected static o iCQ()
  {
    AppMethodBeat.i(298073);
    o localo = o.iVl();
    AppMethodBeat.o(298073);
    return localo;
  }
  
  public final a iCP()
  {
    AppMethodBeat.i(82355);
    if (this.Xst == null)
    {
      this.Xst = new b();
      this.Xst.xNl = this.xNl;
      this.Xst.setPanelManager(this);
    }
    b localb = this.Xst;
    AppMethodBeat.o(82355);
    return localb;
  }
  
  public final void onDestroy()
  {
    this.Xst = null;
    this.xNl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.c
 * JD-Core Version:    0.7.0.1
 */