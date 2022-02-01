package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;

public final class h
{
  public static boolean a(String paramString, p paramp)
  {
    AppMethodBeat.i(97445);
    if (x.asz(paramString))
    {
      bool = af.dHR().b(x.asL(paramString), paramp);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = af.dHU().b(x.asL(paramString), paramp.dME());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static p auS(String paramString)
  {
    AppMethodBeat.i(97444);
    if (x.asz(paramString))
    {
      paramString = af.dHR().xK(x.asL(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = af.dHU().xB(x.asL(paramString));
    if (paramString != null)
    {
      paramString = paramString.dMb();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
  
  public static p auT(String paramString)
  {
    AppMethodBeat.i(97446);
    if (x.asz(paramString))
    {
      paramString = af.dHR().Ph(x.avp(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = af.dHU().Pc(x.avp(paramString));
    if (paramString != null)
    {
      paramString = paramString.dMb();
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