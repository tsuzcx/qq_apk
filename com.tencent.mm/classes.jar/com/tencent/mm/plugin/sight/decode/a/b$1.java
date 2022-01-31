package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  public final void run()
  {
    long l = System.currentTimeMillis();
    try
    {
      SightVideoJNI.freeAll();
      y.i("MicroMsg.SightPlayController", "free all, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SightPlayController", "free all sight error");
        y.printErrStackTrace("MicroMsg.SightPlayController", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.1
 * JD-Core Version:    0.7.0.1
 */