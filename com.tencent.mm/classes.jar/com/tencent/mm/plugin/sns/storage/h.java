package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;

public final class h
{
  public static boolean a(String paramString, p paramp)
  {
    AppMethodBeat.i(97445);
    if (x.ayP(paramString))
    {
      bool = ah.dXE().b(x.aze(paramString), paramp);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = ah.dXH().b(x.aze(paramString), paramp.ecy());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static p aBq(String paramString)
  {
    AppMethodBeat.i(97444);
    if (x.ayP(paramString))
    {
      paramString = ah.dXE().AG(x.aze(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = ah.dXH().Ax(x.aze(paramString));
    if (paramString != null)
    {
      paramString = paramString.ebV();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
  
  public static p aBr(String paramString)
  {
    AppMethodBeat.i(97446);
    if (x.ayP(paramString))
    {
      paramString = ah.dXE().Rw(x.aBN(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = ah.dXH().Rr(x.aBN(paramString));
    if (paramString != null)
    {
      paramString = paramString.ebV();
      AppMethodBeat.o(97446);
      return paramString;
    }
    AppMethodBeat.o(97446);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.h
 * JD-Core Version:    0.7.0.1
 */