package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class c$44
  implements Runnable
{
  c$44(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(139578);
    try
    {
      Thread.sleep(5000L);
      label11:
      File localFile = new File(this.BJh);
      String str = this.BJh + ".zip";
      o.a(new File[] { localFile }, str);
      AppMethodBeat.o(139578);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.44
 * JD-Core Version:    0.7.0.1
 */