package com.tencent.mm.plugin.sns.ad.widget.alphavideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class d
{
  private static volatile d Qfh;
  
  public static d hcO()
  {
    AppMethodBeat.i(310498);
    if (Qfh == null) {}
    try
    {
      if (Qfh == null) {
        Qfh = new d();
      }
      d locald = Qfh;
      AppMethodBeat.o(310498);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(310498);
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(310502);
    h.ahAA.bk(paramRunnable);
    AppMethodBeat.o(310502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.alphavideo.d
 * JD-Core Version:    0.7.0.1
 */