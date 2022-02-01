package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;

public final class f
{
  public static boolean a(String paramString, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97445);
    if (y.aYj(paramString))
    {
      bool = aj.fOI().b(y.aYS(paramString), paramSnsInfo);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = aj.fOL().b(y.aYS(paramString), paramSnsInfo.getAdSnsInfo());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static SnsInfo bbk(String paramString)
  {
    AppMethodBeat.i(97444);
    if (y.aYj(paramString))
    {
      paramString = aj.fOI().Rd(y.aYS(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = aj.fOL().QX(y.aYS(paramString));
    if (paramString != null)
    {
      paramString = paramString.convertToSnsInfo();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
  
  public static SnsInfo bbl(String paramString)
  {
    AppMethodBeat.i(97446);
    if (y.aYj(paramString))
    {
      paramString = aj.fOI().agI(y.bbI(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = aj.fOL().agG(y.bbI(paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.f
 * JD-Core Version:    0.7.0.1
 */