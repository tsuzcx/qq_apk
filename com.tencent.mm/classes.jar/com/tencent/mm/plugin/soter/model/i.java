package com.tencent.mm.plugin.soter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public enum i
{
  private String appId = null;
  private int errCode = 0;
  private int errType = 0;
  
  static
  {
    AppMethodBeat.i(130853);
    Sac = new i("INSTANCE");
    Sad = new i[] { Sac };
    AppMethodBeat.o(130853);
  }
  
  private i() {}
  
  public static void v(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130852);
    Log.d("MicroMsg.SoterReportManager", "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i;
    switch (paramString1.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label71:
        Log.e("MicroMsg.SoterReportManager", "unknown soter jsapi function name");
        i = -1;
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.SoterReportManager", "functionNameCode: %d", new Object[] { Integer.valueOf(i) });
      if (i != -1) {
        h.OAn.b(13711, new Object[] { Integer.valueOf(i), paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
 * Qualified Name:     com.tencent.mm.plugin.soter.model.i
 * JD-Core Version:    0.7.0.1
 */