package com.tencent.mm.plugin.normsg.b;

import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static boolean mHX = false;
  
  static
  {
    long l = System.nanoTime();
    try
    {
      mHX = Normsg.b.boI();
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.NormalMsgSource.DADH", localThrowable, "unexpected exception.", new Object[0]);
      mHX = false;
      return;
    }
    finally
    {
      y.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[] { Boolean.valueOf(mHX), Long.valueOf(System.nanoTime() - l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.e
 * JD-Core Version:    0.7.0.1
 */