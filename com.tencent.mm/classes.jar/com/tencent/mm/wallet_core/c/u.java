package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class u
{
  private static long ioY = 0L;
  private static String quW = "";
  private static String wAJ = "";
  
  public static boolean cMy()
  {
    long l = bk.cn(ioY);
    y.d("MicroMsg.TimeStampHelper", "pass time " + l);
    return l > 300L;
  }
  
  public static String cMz()
  {
    if ((bk.bl(quW)) || (b.cqk())) {
      y.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { wAJ, Boolean.valueOf(cMy()), Long.valueOf(ioY) });
    }
    return quW;
  }
  
  public static void setTimeStamp(String paramString)
  {
    quW = paramString;
    ioY = System.currentTimeMillis() / 1000L;
    wAJ = bk.csb().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.u
 * JD-Core Version:    0.7.0.1
 */