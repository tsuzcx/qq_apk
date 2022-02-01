package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
{
  private static String VEW = "";
  private static String agTw = "";
  private static long update_time = 0L;
  
  public static String jON()
  {
    boolean bool = false;
    AppMethodBeat.i(72804);
    if ((Util.isNullOrNil(VEW)) || (CrashReportFactory.hasDebuger()))
    {
      str = agTw;
      long l = Util.secondsToNow(update_time);
      Log.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(l)));
      if (l > 300L) {
        bool = true;
      }
      Log.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { str, Boolean.valueOf(bool), Long.valueOf(update_time) });
    }
    String str = VEW;
    AppMethodBeat.o(72804);
    return str;
  }
  
  public static void setTimeStamp(String paramString)
  {
    AppMethodBeat.i(72803);
    VEW = paramString;
    update_time = System.currentTimeMillis() / 1000L;
    agTw = Util.getStack().toString();
    AppMethodBeat.o(72803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.y
 * JD-Core Version:    0.7.0.1
 */