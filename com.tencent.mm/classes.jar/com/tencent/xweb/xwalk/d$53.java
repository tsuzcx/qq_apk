package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.n;
import java.io.File;

final class d$53
  implements Runnable
{
  d$53(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(212800);
    try
    {
      Thread.sleep(5000L);
      label11:
      File localFile = new File(this.aioB);
      String str = this.aioB + ".zip";
      n.a(new File[] { localFile }, str);
      AppMethodBeat.o(212800);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.53
 * JD-Core Version:    0.7.0.1
 */