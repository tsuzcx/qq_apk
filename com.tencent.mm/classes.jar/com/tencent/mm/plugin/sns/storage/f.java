package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;

public final class f
{
  public static boolean a(String paramString, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97445);
    if (y.aNz(paramString))
    {
      bool = aj.faO().b(y.aOa(paramString), paramSnsInfo);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = aj.faR().b(y.aOa(paramString), paramSnsInfo.getAdSnsInfo());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static SnsInfo aQl(String paramString)
  {
    AppMethodBeat.i(97444);
    if (y.aNz(paramString))
    {
      paramString = aj.faO().JJ(y.aOa(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = aj.faR().JE(y.aOa(paramString));
    if (paramString != null)
    {
      paramString = paramString.convertToSnsInfo();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
  
  public static SnsInfo aQm(String paramString)
  {
    AppMethodBeat.i(97446);
    if (y.aNz(paramString))
    {
      paramString = aj.faO().Zr(y.aQI(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = aj.faR().Zp(y.aQI(paramString));
    if (paramString != null)
    {
      paramString = paramString.convertToSnsInfo();
      AppMethodBeat.o(97446);
      return paramString;
    }
    AppMethodBeat.o(97446);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.f
 * JD-Core Version:    0.7.0.1
 */