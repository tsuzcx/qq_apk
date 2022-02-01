package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
{
  public static String aMe(String paramString)
  {
    AppMethodBeat.i(110675);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = fbL() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String aMf(String paramString)
  {
    AppMethodBeat.i(209396);
    if (paramString == null)
    {
      AppMethodBeat.o(209396);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(209396);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(209396);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 0)
      {
        paramString = paramString[0];
        AppMethodBeat.o(209396);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(209396);
    }
    return "";
  }
  
  public static String aMg(String paramString)
  {
    AppMethodBeat.i(209397);
    if (paramString == null)
    {
      AppMethodBeat.o(209397);
      return "";
    }
    try
    {
      paramString = paramString.split("/wepkg/");
      if (paramString.length <= 1)
      {
        AppMethodBeat.o(209397);
        return "";
      }
      paramString = paramString[1];
      if (paramString == null)
      {
        AppMethodBeat.o(209397);
        return "";
      }
      paramString = paramString.split("/");
      if (paramString.length > 1)
      {
        paramString = paramString[1];
        AppMethodBeat.o(209397);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(209397);
    }
    return "";
  }
  
  public static String fbL()
  {
    AppMethodBeat.i(209395);
    String str = b.cZG() + "wepkg/";
    AppMethodBeat.o(209395);
    return str;
  }
  
  public static String lt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = aMe(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.d
 * JD-Core Version:    0.7.0.1
 */