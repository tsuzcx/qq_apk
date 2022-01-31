package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bi
  implements Runnable
{
  bi(bh parambh, bb parambb, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = false;
    AppMethodBeat.i(147292);
    try
    {
      be localbe = this.a.a();
      this.a.k = (SystemClock.elapsedRealtime() - this.b);
      this.a.a(false);
      boolean bool1 = bool2;
      if (localbe.a == 0)
      {
        int i = localbe.c;
        bool1 = bool2;
        if (i == 200) {
          bool1 = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      bh.a(this.c, false);
      AppMethodBeat.o(147292);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bi
 * JD-Core Version:    0.7.0.1
 */