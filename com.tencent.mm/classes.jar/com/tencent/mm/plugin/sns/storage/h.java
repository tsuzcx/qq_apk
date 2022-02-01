package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;

public final class h
{
  public static boolean a(String paramString, p paramp)
  {
    AppMethodBeat.i(97445);
    if (x.anq(paramString))
    {
      bool = af.dtu().b(x.anz(paramString), paramp);
      AppMethodBeat.o(97445);
      return bool;
    }
    boolean bool = af.dtx().b(x.anz(paramString), paramp.dyh());
    AppMethodBeat.o(97445);
    return bool;
  }
  
  public static p apJ(String paramString)
  {
    AppMethodBeat.i(97444);
    if (x.anq(paramString))
    {
      paramString = af.dtu().th(x.anz(paramString));
      AppMethodBeat.o(97444);
      return paramString;
    }
    paramString = af.dtx().sY(x.anz(paramString));
    if (paramString != null)
    {
      paramString = paramString.dxE();
      AppMethodBeat.o(97444);
      return paramString;
    }
    AppMethodBeat.o(97444);
    return null;
  }
  
  public static p apK(String paramString)
  {
    AppMethodBeat.i(97446);
    if (x.anq(paramString))
    {
      paramString = af.dtu().Ne(x.aqg(paramString));
      AppMethodBeat.o(97446);
      return paramString;
    }
    paramString = af.dtx().MZ(x.aqg(paramString));
    if (paramString != null)
    {
      paramString = paramString.dxE();
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