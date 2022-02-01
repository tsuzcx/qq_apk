package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;

final class b$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(116073);
    long l = System.currentTimeMillis();
    try
    {
      SightVideoJNI.freeAll();
      ae.i("MicroMsg.SightPlayController", "free all, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116073);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SightPlayController", "free all sight error");
        ae.printErrStackTrace("MicroMsg.SightPlayController", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.2
 * JD-Core Version:    0.7.0.1
 */