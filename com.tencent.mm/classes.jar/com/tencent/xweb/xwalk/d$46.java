package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d$46
  implements Runnable
{
  d$46(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(154209);
    try
    {
      Thread.sleep(5000L);
      label11:
      File localFile = new File(this.KFY);
      String str = this.KFY + ".zip";
      u.a(new File[] { localFile }, str, -1);
      AppMethodBeat.o(154209);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.46
 * JD-Core Version:    0.7.0.1
 */