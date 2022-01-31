package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  public static final String vFO;
  
  static
  {
    AppMethodBeat.i(63519);
    String str2 = e.eQv;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    vFO = str1 + "wepkg/";
    AppMethodBeat.o(63519);
  }
  
  public static String akz(String paramString)
  {
    AppMethodBeat.i(63517);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63517);
      return "";
    }
    paramString = vFO + paramString + "/";
    AppMethodBeat.o(63517);
    return paramString;
  }
  
  public static String hN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63518);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(63518);
      return "";
    }
    paramString1 = akz(paramString1) + paramString2;
    AppMethodBeat.o(63518);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.c
 * JD-Core Version:    0.7.0.1
 */