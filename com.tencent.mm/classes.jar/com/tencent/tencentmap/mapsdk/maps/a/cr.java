package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class cr
  implements Runnable
{
  cr(cl paramcl) {}
  
  public final void run()
  {
    AppMethodBeat.i(147374);
    try
    {
      an.e();
      Object localObject1 = an.b();
      localObject1 = cl.a(this.a, (String)localObject1);
      long l = SystemClock.elapsedRealtime();
      int i = cl.a(this.a, ((cl.a)localObject1).b);
      if ((l - ((cl.a)localObject1).a > i) || (l < ((cl.a)localObject1).a))
      {
        cl.b(2);
        cl.c(this.a).removeCallbacks(cl.b(this.a));
        cl.c(this.a).post(cl.b(this.a));
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      AppMethodBeat.o(147374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cr
 * JD-Core Version:    0.7.0.1
 */