package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$1
  implements Runnable
{
  public e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(5646);
    this.uOg.execSQL("WebViewHistory", "delete from WebViewHistory where  timeStamp < ".concat(String.valueOf(System.currentTimeMillis() / 1000L - 604800L)));
    e.a(this.uOg);
    AppMethodBeat.o(5646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.e.1
 * JD-Core Version:    0.7.0.1
 */