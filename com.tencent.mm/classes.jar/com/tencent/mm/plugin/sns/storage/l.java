package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.al;

public final class l
{
  public static boolean a(String paramString, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97445);
    if (ai.aWb(paramString))
    {
      bool = al.hgB().b(ai.aXe(paramString), paramSnsInfo);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = al.hgE().b(ai.aXe(paramString), paramSnsInfo.getAdSnsInfo());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static SnsInfo aZK(String paramString)
  {
    AppMethodBeat.i(97444);
    if (ai.aWb(paramString))
    {
      paramString = al.hgB().vj(ai.aXe(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = al.hgE().vd(ai.aXe(paramString));
    if (paramString != null)
    {
      paramString = paramString.convertToSnsInfo();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
  
  public static SnsInfo aZL(String paramString)
  {
    AppMethodBeat.i(97446);
    if (ai.aWb(paramString))
    {
      paramString = al.hgB().alB(ai.bap(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = al.hgE().alz(ai.bap(paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.l
 * JD-Core Version:    0.7.0.1
 */