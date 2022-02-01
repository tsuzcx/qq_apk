package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;

public final class y
{
  private static String BvP = "";
  private static String JFu = "";
  private static long nYz = 0L;
  
  public static String fAm()
  {
    boolean bool = false;
    AppMethodBeat.i(72804);
    if ((bs.isNullOrNil(BvP)) || (b.eUk()))
    {
      str = JFu;
      long l = bs.pN(nYz);
      ac.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(l)));
      if (l > 300L) {
        bool = true;
      }
      ac.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { str, Boolean.valueOf(bool), Long.valueOf(nYz) });
    }
    String str = BvP;
    AppMethodBeat.o(72804);
    return str;
  }
  
  public static void setTimeStamp(String paramString)
  {
    AppMethodBeat.i(72803);
    BvP = paramString;
    nYz = System.currentTimeMillis() / 1000L;
    JFu = bs.eWi().toString();
    AppMethodBeat.o(72803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */