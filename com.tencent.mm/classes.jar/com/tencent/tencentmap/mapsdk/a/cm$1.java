package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.Date;

final class cm$1
  implements Runnable
{
  cm$1(cm paramcm, String paramString1, String paramString2, Context paramContext) {}
  
  public final void run()
  {
    String str = this.a;
    try
    {
      l1 = e.d(this.b).getTime() / 1000L;
      long l2 = l1;
      if (l1 == 0L) {
        l2 = new Date().getTime() / 1000L + 86400L;
      }
      Context localContext = this.c;
      this.d.getClass();
      e.a(localContext, "sid", new Object[] { str, Long.valueOf(l2) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cm.1
 * JD-Core Version:    0.7.0.1
 */