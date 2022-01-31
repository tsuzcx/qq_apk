package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.e.k;
import com.tencent.luggage.j.c;

final class o$1
  implements Runnable
{
  o$1(k paramk) {}
  
  public final void run()
  {
    try
    {
      this.rcP.destroy();
      return;
    }
    catch (Exception localException)
    {
      c.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o.1
 * JD-Core Version:    0.7.0.1
 */