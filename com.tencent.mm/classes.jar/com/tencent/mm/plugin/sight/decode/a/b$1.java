package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(70226);
    long l = System.currentTimeMillis();
    try
    {
      SightVideoJNI.freeAll();
      ab.i("MicroMsg.SightPlayController", "free all, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(70226);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SightPlayController", "free all sight error");
        ab.printErrStackTrace("MicroMsg.SightPlayController", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.1
 * JD-Core Version:    0.7.0.1
 */