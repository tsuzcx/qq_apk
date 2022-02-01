package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String dFy;
  public final String zee;
  public final String zef;
  public final String zeg;
  public final boolean zeh;
  public final long zei;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197818);
    this.zee = paramString1;
    this.zef = paramString2;
    if (paramString3 != null)
    {
      this.dFy = paramString3;
      if (paramString4 == null) {
        break label63;
      }
    }
    for (;;)
    {
      this.zeg = paramString4;
      this.zeh = true;
      this.zei = SystemClock.elapsedRealtime();
      AppMethodBeat.o(197818);
      return;
      paramString3 = "";
      break;
      label63:
      paramString4 = "";
    }
  }
  
  public static e y(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197817);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(197817);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(197817);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */