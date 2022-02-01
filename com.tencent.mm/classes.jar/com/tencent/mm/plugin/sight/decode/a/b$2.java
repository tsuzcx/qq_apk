package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;

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
      Log.i("MicroMsg.SightPlayController", "free all, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(116073);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SightPlayController", "free all sight error");
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.2
 * JD-Core Version:    0.7.0.1
 */