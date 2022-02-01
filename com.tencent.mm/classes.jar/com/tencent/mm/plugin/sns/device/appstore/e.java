package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class e
{
  public final String JSc;
  public final String JSd;
  public final boolean JSe;
  public final long JSf;
  public long JSg;
  public final SnsInfo Jzk;
  public final String adExtInfo;
  public final String uxInfo;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(264321);
    this.JSc = paramString1;
    this.JSd = paramString2;
    if (paramString3 != null)
    {
      this.uxInfo = paramString3;
      if (paramString4 == null) {
        break label76;
      }
    }
    for (;;)
    {
      this.adExtInfo = paramString4;
      this.JSe = true;
      this.JSf = SystemClock.elapsedRealtime();
      this.Jzk = paramSnsInfo;
      this.JSg = System.currentTimeMillis();
      AppMethodBeat.o(264321);
      return;
      paramString3 = "";
      break;
      label76:
      paramString4 = "";
    }
  }
  
  public static e a(String paramString1, String paramString2, String paramString3, String paramString4, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(264319);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4, paramSnsInfo);
      AppMethodBeat.o(264319);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(264319);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */