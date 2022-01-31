package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class at
  implements Runnable
{
  at(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    AppMethodBeat.i(147246);
    try
    {
      this.a[0] = as.b();
      label14:
      this.b.countDown();
      AppMethodBeat.o(147246);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.at
 * JD-Core Version:    0.7.0.1
 */