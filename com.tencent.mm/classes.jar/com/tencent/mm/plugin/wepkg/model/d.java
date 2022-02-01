package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.b;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
{
  public static String azT(String paramString)
  {
    AppMethodBeat.i(110675);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110675);
      return "";
    }
    paramString = etN() + paramString + "/";
    AppMethodBeat.o(110675);
    return paramString;
  }
  
  public static String etN()
  {
    AppMethodBeat.i(192625);
    String str = b.cBu() + "wepkg/";
    AppMethodBeat.o(192625);
    return str;
  }
  
  public static String kt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110676);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110676);
      return "";
    }
    paramString1 = azT(paramString1) + paramString2;
    AppMethodBeat.o(110676);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.d
 * JD-Core Version:    0.7.0.1
 */