package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static String bcx(String paramString)
  {
    AppMethodBeat.i(110675);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = gkQ() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String bcy(String paramString)
  {
    AppMethodBeat.i(200169);
    if (paramString == null)
    {
      AppMethodBeat.o(200169);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(200169);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(200169);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 0)
      {
        paramString = paramString[0];
        AppMethodBeat.o(200169);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(200169);
    }
    return "";
  }
  
  public static String bcz(String paramString)
  {
    AppMethodBeat.i(200170);
    if (paramString == null)
    {
      AppMethodBeat.o(200170);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(200170);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(200170);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 1)
      {
        paramString = paramString[1];
        AppMethodBeat.o(200170);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(200170);
    }
    return "";
  }
  
  public static String gkQ()
  {
    AppMethodBeat.i(200168);
    String str = b.dTg() + "wepkg/";
    AppMethodBeat.o(200168);
    return str;
  }
  
  public static String ms(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = bcx(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e
 * JD-Core Version:    0.7.0.1
 */