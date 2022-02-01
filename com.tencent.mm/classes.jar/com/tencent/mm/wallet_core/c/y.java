package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public final class y
{
  private static String DnK = "";
  private static String LVn = "";
  private static long oIv = 0L;
  
  public static String fVS()
  {
    boolean bool = false;
    AppMethodBeat.i(72804);
    if ((bu.isNullOrNil(DnK)) || (b.fnF()))
    {
      str = LVn;
      long l = bu.rZ(oIv);
      ae.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(l)));
      if (l > 300L) {
        bool = true;
      }
      ae.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { str, Boolean.valueOf(bool), Long.valueOf(oIv) });
    }
    String str = DnK;
    AppMethodBeat.o(72804);
    return str;
  }
  
  public static void setTimeStamp(String paramString)
  {
    AppMethodBeat.i(72803);
    DnK = paramString;
    oIv = System.currentTimeMillis() / 1000L;
    LVn = bu.fpN().toString();
    AppMethodBeat.o(72803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */