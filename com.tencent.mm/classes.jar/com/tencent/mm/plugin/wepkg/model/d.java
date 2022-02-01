package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
{
  public static String aKI(String paramString)
  {
    AppMethodBeat.i(110675);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = eXZ() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String aKJ(String paramString)
  {
    AppMethodBeat.i(214468);
    if (paramString == null)
    {
      AppMethodBeat.o(214468);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(214468);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(214468);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 0)
      {
        paramString = paramString[0];
        AppMethodBeat.o(214468);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(214468);
    }
    return "";
  }
  
  public static String aKK(String paramString)
  {
    AppMethodBeat.i(214469);
    if (paramString == null)
    {
      AppMethodBeat.o(214469);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(214469);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(214469);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 1)
      {
        paramString = paramString[1];
        AppMethodBeat.o(214469);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(214469);
    }
    return "";
  }
  
  public static String eXZ()
  {
    AppMethodBeat.i(214467);
    String str = b.cWZ() + "wepkg/";
    AppMethodBeat.o(214467);
    return str;
  }
  
  public static String lm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = aKI(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.d
 * JD-Core Version:    0.7.0.1
 */