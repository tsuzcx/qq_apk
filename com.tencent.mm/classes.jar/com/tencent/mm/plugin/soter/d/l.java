package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public enum l
{
  private String appId = null;
  private int errCode = 0;
  private int errType = 0;
  
  static
  {
    AppMethodBeat.i(130853);
    znJ = new l("INSTANCE");
    znK = new l[] { znJ };
    AppMethodBeat.o(130853);
  }
  
  private l() {}
  
  public static void s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130852);
    ac.d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i;
    switch (paramString1.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label71:
        ac.e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
        i = -1;
      }
      break;
    }
    for (;;)
    {
      ac.i("MicroMsg.SoterReportManager", "functionNameCode: %d", new Object[] { Integer.valueOf(i) });
      if (i != -1) {
        h.wUl.f(13711, new Object[] { Integer.valueOf(i), paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
      AppMethodBeat.o(130852);
      return;
      if (!paramString1.equals("requireSoterBiometricAuthentication")) {
        break;
      }
      i = 0;
      break label71;
      if (!paramString1.equals("getSupportSoter")) {
        break;
      }
      i = 1;
      break label71;
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.l
 * JD-Core Version:    0.7.0.1
 */