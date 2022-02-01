package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class y
{
  private static String Adv = "";
  private static String IdS = "";
  private static long nvz = 0L;
  
  public static String fjW()
  {
    boolean bool = false;
    AppMethodBeat.i(72804);
    if ((bt.isNullOrNil(Adv)) || (b.eEQ()))
    {
      str = IdS;
      long l = bt.lZ(nvz);
      ad.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(l)));
      if (l > 300L) {
        bool = true;
      }
      ad.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { str, Boolean.valueOf(bool), Long.valueOf(nvz) });
    }
    String str = Adv;
    AppMethodBeat.o(72804);
    return str;
  }
  
  public static void setTimeStamp(String paramString)
  {
    AppMethodBeat.i(72803);
    Adv = paramString;
    nvz = System.currentTimeMillis() / 1000L;
    IdS = bt.eGN().toString();
    AppMethodBeat.o(72803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */