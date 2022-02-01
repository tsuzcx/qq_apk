package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String dtx;
  public final String xOk;
  public final String xOl;
  public final String xOm;
  public final boolean xOn;
  public final long xOo;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(200093);
    this.xOk = paramString1;
    this.xOl = paramString2;
    if (paramString3 != null)
    {
      this.dtx = paramString3;
      if (paramString4 == null) {
        break label63;
      }
    }
    for (;;)
    {
      this.xOm = paramString4;
      this.xOn = true;
      this.xOo = SystemClock.elapsedRealtime();
      AppMethodBeat.o(200093);
      return;
      paramString3 = "";
      break;
      label63:
      paramString4 = "";
    }
  }
  
  public static e x(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(200092);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(200092);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(200092);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */