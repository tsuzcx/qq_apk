package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d.a;

final class e$12
  implements Runnable
{
  e$12(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(153098);
    this.uRQ.uRk.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new e.12.1(this));
    AppMethodBeat.o(153098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.12
 * JD-Core Version:    0.7.0.1
 */