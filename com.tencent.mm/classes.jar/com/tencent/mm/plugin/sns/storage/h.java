package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;

public final class h
{
  public static boolean a(String paramString, n paramn)
  {
    AppMethodBeat.i(37836);
    if (v.Zq(paramString))
    {
      bool = ag.cpf().b(v.abO(paramString), paramn);
      AppMethodBeat.o(37836);
      return bool;
    }
    boolean bool = ag.cpi().b(v.abO(paramString), paramn.csQ());
    AppMethodBeat.o(37836);
    return bool;
  }
  
  public static n abu(String paramString)
  {
    AppMethodBeat.i(37835);
    if (v.Zq(paramString))
    {
      paramString = ag.cpf().lZ(v.abO(paramString));
      AppMethodBeat.o(37835);
      return paramString;
    }
    paramString = ag.cpi().lQ(v.abO(paramString));
    if (paramString != null)
    {
      paramString = paramString.csn();
      AppMethodBeat.o(37835);
      return paramString;
    }
    AppMethodBeat.o(37835);
    return null;
  }
  
  public static n abv(String paramString)
  {
    AppMethodBeat.i(37837);
    if (v.Zq(paramString))
    {
      paramString = ag.cpf().Ez(v.abP(paramString));
      AppMethodBeat.o(37837);
      return paramString;
    }
    paramString = ag.cpi().Ev(v.abP(paramString));
    if (paramString != null)
    {
      paramString = paramString.csn();
      AppMethodBeat.o(37837);
      return paramString;
    }
    AppMethodBeat.o(37837);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.h
 * JD-Core Version:    0.7.0.1
 */