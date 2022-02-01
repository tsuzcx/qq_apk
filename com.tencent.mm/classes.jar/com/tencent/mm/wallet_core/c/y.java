package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
{
  private static String HXc = "";
  private static String Rud = "";
  private static long pWj = 0L;
  
  public static String hhp()
  {
    boolean bool = false;
    AppMethodBeat.i(72804);
    if ((Util.isNullOrNil(HXc)) || (CrashReportFactory.hasDebuger()))
    {
      str = Rud;
      long l = Util.secondsToNow(pWj);
      Log.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(l)));
      if (l > 300L) {
        bool = true;
      }
      Log.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { str, Boolean.valueOf(bool), Long.valueOf(pWj) });
    }
    String str = HXc;
    AppMethodBeat.o(72804);
    return str;
  }
  
  public static void setTimeStamp(String paramString)
  {
    AppMethodBeat.i(72803);
    HXc = paramString;
    pWj = System.currentTimeMillis() / 1000L;
    Rud = Util.getStack().toString();
    AppMethodBeat.o(72803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */