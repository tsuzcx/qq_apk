package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class e
{
  public final SnsInfo PNI;
  public final String QoO;
  public final String QoP;
  public final boolean QoQ;
  public final long QoR;
  public long QoS;
  public final String adExtInfo;
  public final String uxInfo;
  
  private e(String paramString1, String paramString2, String paramString3, String paramString4, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(306339);
    this.QoO = paramString1;
    this.QoP = paramString2;
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
      this.QoQ = true;
      this.QoR = SystemClock.elapsedRealtime();
      this.PNI = paramSnsInfo;
      this.QoS = System.currentTimeMillis();
      AppMethodBeat.o(306339);
      return;
      paramString3 = "";
      break;
      label76:
      paramString4 = "";
    }
  }
  
  public static e a(String paramString1, String paramString2, String paramString3, String paramString4, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(306338);
    try
    {
      paramString1 = new e(paramString1, paramString2, paramString3, paramString4, paramSnsInfo);
      return paramString1;
    }
    finally
    {
      AppMethodBeat.o(306338);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.e
 * JD-Core Version:    0.7.0.1
 */