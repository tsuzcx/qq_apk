package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d$49
  implements Runnable
{
  d$49(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(207271);
    try
    {
      Thread.sleep(5000L);
      label11:
      File localFile = new File(this.SGJ);
      String str = this.SGJ + ".zip";
      u.a(new File[] { localFile }, str, -1);
      AppMethodBeat.o(207271);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.49
 * JD-Core Version:    0.7.0.1
 */