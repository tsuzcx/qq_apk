package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.b;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
{
  public static String aFj(String paramString)
  {
    AppMethodBeat.i(110675);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = eJg() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String aFk(String paramString)
  {
    AppMethodBeat.i(199881);
    if (paramString == null)
    {
      AppMethodBeat.o(199881);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(199881);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(199881);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 0)
      {
        paramString = paramString[0];
        AppMethodBeat.o(199881);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(199881);
    }
    return "";
  }
  
  public static String aFl(String paramString)
  {
    AppMethodBeat.i(199882);
    if (paramString == null)
    {
      AppMethodBeat.o(199882);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(199882);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(199882);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 1)
      {
        paramString = paramString[1];
        AppMethodBeat.o(199882);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(199882);
    }
    return "";
  }
  
  public static String eJg()
  {
    AppMethodBeat.i(199880);
    String str = b.cOD() + "wepkg/";
    AppMethodBeat.o(199880);
    return str;
  }
  
  public static String kP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = aFj(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.d
 * JD-Core Version:    0.7.0.1
 */