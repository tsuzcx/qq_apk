package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;

final class fu
  implements Runnable
{
  fu(ft paramft, fm paramfm, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = false;
    try
    {
      fp localfp = this.a.a();
      this.a.k = (SystemClock.elapsedRealtime() - this.b);
      this.a.a(false);
      boolean bool1 = bool2;
      if (localfp.a == 0)
      {
        int i = localfp.c;
        bool1 = bool2;
        if (i == 200) {
          bool1 = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      ft.a(this.c, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fu
 * JD-Core Version:    0.7.0.1
 */