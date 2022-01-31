package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public enum l
{
  private String appId = null;
  private int errCode = 0;
  private int errType = 0;
  
  private l() {}
  
  public static void m(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i;
    switch (paramString1.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label67:
        y.e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
        i = -1;
      }
      break;
    }
    for (;;)
    {
      y.i("MicroMsg.SoterReportManager", "functionNameCode: %d", new Object[] { Integer.valueOf(i) });
      if (i != -1) {
        h.nFQ.f(13711, new Object[] { Integer.valueOf(i), paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
      return;
      if (!paramString1.equals("requireSoterBiometricAuthentication")) {
        break;
      }
      i = 0;
      break label67;
      if (!paramString1.equals("getSupportSoter")) {
        break;
      }
      i = 1;
      break label67;
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.l
 * JD-Core Version:    0.7.0.1
 */