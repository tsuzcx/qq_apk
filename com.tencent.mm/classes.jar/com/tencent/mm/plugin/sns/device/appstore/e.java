package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String dvK;
  public final String wBP;
  public final String wBQ;
  public final String wBR;
  public final boolean wBS;
  public final long wBT;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(187312);
    this.wBP = paramString1;
    this.wBQ = paramString2;
    if (paramString3 != null)
    {
      this.dvK = paramString3;
      if (paramString4 == null) {
        break label63;
      }
    }
    for (;;)
    {
      this.wBR = paramString4;
      this.wBS = true;
      this.wBT = SystemClock.elapsedRealtime();
      AppMethodBeat.o(187312);
      return;
      paramString3 = "";
      break;
      label63:
      paramString4 = "";
    }
  }
  
  public static e v(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(187311);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(187311);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(187311);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */