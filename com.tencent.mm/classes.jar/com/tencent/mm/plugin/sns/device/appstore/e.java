package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final String DFh;
  public final String DFi;
  public final boolean DFj;
  public final long DFk;
  public final String adExtInfo;
  public final String uxInfo;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202662);
    this.DFh = paramString1;
    this.DFi = paramString2;
    if (paramString3 != null)
    {
      this.uxInfo = paramString3;
      if (paramString4 == null) {
        break label63;
      }
    }
    for (;;)
    {
      this.adExtInfo = paramString4;
      this.DFj = true;
      this.DFk = SystemClock.elapsedRealtime();
      AppMethodBeat.o(202662);
      return;
      paramString3 = "";
      break;
      label63:
      paramString4 = "";
    }
  }
  
  public static e C(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202661);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(202661);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(202661);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */