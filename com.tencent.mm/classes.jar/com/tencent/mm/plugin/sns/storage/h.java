package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;

public final class h
{
  public static boolean a(String paramString, p paramp)
  {
    AppMethodBeat.i(97445);
    if (x.axz(paramString))
    {
      bool = ag.dUe().b(x.axN(paramString), paramp);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = ag.dUh().b(x.axN(paramString), paramp.dYU());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static p aAa(String paramString)
  {
    AppMethodBeat.i(97446);
    if (x.axz(paramString))
    {
      paramString = ag.dUe().QP(x.aAw(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = ag.dUh().QK(x.aAw(paramString));
    if (paramString != null)
    {
      paramString = paramString.dYr();
      AppMethodBeat.o(97446);
      return paramString;
    }
    AppMethodBeat.o(97446);
    return null;
  }
  
  public static p azZ(String paramString)
  {
    AppMethodBeat.i(97444);
    if (x.axz(paramString))
    {
      paramString = ag.dUe().Ai(x.axN(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = ag.dUh().zZ(x.axN(paramString));
    if (paramString != null)
    {
      paramString = paramString.dYr();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.h
 * JD-Core Version:    0.7.0.1
 */