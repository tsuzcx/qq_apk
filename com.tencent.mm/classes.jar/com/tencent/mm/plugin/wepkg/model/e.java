package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static String bol(String paramString)
  {
    AppMethodBeat.i(110675);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = iFq() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String bom(String paramString)
  {
    AppMethodBeat.i(278679);
    if (paramString == null)
    {
      AppMethodBeat.o(278679);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(278679);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(278679);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 0)
      {
        paramString = paramString[0];
        AppMethodBeat.o(278679);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(278679);
    }
    return "";
  }
  
  public static String bon(String paramString)
  {
    AppMethodBeat.i(278682);
    if (paramString == null)
    {
      AppMethodBeat.o(278682);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(278682);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(278682);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 1)
      {
        paramString = paramString[1];
        AppMethodBeat.o(278682);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(278682);
    }
    return "";
  }
  
  public static String iFq()
  {
    AppMethodBeat.i(278677);
    String str = c.fEg() + "wepkg/";
    AppMethodBeat.o(278677);
    return str;
  }
  
  public static String oK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = bol(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e
 * JD-Core Version:    0.7.0.1
 */