package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String dGD;
  public final String zsJ;
  public final String zuU;
  public final String zuV;
  public final boolean zuW;
  public final long zuX;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(219301);
    this.zuU = paramString1;
    this.zuV = paramString2;
    if (paramString3 != null)
    {
      this.dGD = paramString3;
      if (paramString4 == null) {
        break label63;
      }
    }
    for (;;)
    {
      this.zsJ = paramString4;
      this.zuW = true;
      this.zuX = SystemClock.elapsedRealtime();
      AppMethodBeat.o(219301);
      return;
      paramString3 = "";
      break;
      label63:
      paramString4 = "";
    }
  }
  
  public static e y(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(219300);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(219300);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(219300);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */