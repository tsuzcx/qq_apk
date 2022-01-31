package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.g;

final class e$13
  implements Runnable
{
  e$13(e parame, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(6027);
    int i = g.by(this.uRV, this.uRQ.mContext.getResources().getColor(2131690695));
    this.uRQ.uRl.setBackgroundColor(i);
    this.uRQ.uRl.setX5LogoViewVisibility(8);
    AppMethodBeat.o(6027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.13
 * JD-Core Version:    0.7.0.1
 */