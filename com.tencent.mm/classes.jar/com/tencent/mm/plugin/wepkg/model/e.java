package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static String box(String paramString)
  {
    AppMethodBeat.i(110675);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = heI() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String boy(String paramString)
  {
    AppMethodBeat.i(195540);
    if (paramString == null)
    {
      AppMethodBeat.o(195540);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(195540);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(195540);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 0)
      {
        paramString = paramString[0];
        AppMethodBeat.o(195540);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(195540);
    }
    return "";
  }
  
  public static String boz(String paramString)
  {
    AppMethodBeat.i(195543);
    if (paramString == null)
    {
      AppMethodBeat.o(195543);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(195543);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(195543);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 1)
      {
        paramString = paramString[1];
        AppMethodBeat.o(195543);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(195543);
    }
    return "";
  }
  
  public static String heI()
  {
    AppMethodBeat.i(195537);
    String str = c.ewp() + "wepkg/";
    AppMethodBeat.o(195537);
    return str;
  }
  
  public static String mU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = box(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e
 * JD-Core Version:    0.7.0.1
 */