package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class w
{
  private static String AXf = "";
  private static long kqf;
  private static String uho = "";
  
  static
  {
    kqf = 0L;
  }
  
  public static boolean dSn()
  {
    AppMethodBeat.i(49084);
    long l = bo.gz(kqf);
    ab.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(l)));
    if (l > 300L)
    {
      AppMethodBeat.o(49084);
      return true;
    }
    AppMethodBeat.o(49084);
    return false;
  }
  
  public static String dSo()
  {
    AppMethodBeat.i(49085);
    if ((bo.isNullOrNil(uho)) || (b.dsf())) {
      ab.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[] { AXf, Boolean.valueOf(dSn()), Long.valueOf(kqf) });
    }
    String str = uho;
    AppMethodBeat.o(49085);
    return str;
  }
  
  public static void setTimeStamp(String paramString)
  {
    AppMethodBeat.i(49083);
    uho = paramString;
    kqf = System.currentTimeMillis() / 1000L;
    AXf = bo.dtY().toString();
    AppMethodBeat.o(49083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.w
 * JD-Core Version:    0.7.0.1
 */