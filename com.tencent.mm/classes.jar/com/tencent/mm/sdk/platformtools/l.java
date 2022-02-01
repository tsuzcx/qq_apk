package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class l
{
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157533);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(157533);
      return null;
    }
    if (!paramString1.endsWith("/"))
    {
      AppMethodBeat.o(157533);
      return null;
    }
    String str = "";
    if (paramInt == 1) {
      str = aFk(paramString3);
    }
    while (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(157533);
      return null;
      if (paramInt == 2) {
        if (bt.isNullOrNil(paramString3)) {
          str = null;
        } else {
          str = aFk(g.getMessageDigest(paramString3.getBytes()));
        }
      }
    }
    paramString1 = paramString1 + str;
    if ((paramBoolean) && (!aAk(paramString1)))
    {
      AppMethodBeat.o(157533);
      return null;
    }
    paramString1 = paramString1 + bt.nullAsNil(paramString2) + paramString3 + bt.nullAsNil(paramString4);
    AppMethodBeat.o(157533);
    return paramString1;
  }
  
  public static boolean aAk(String paramString)
  {
    AppMethodBeat.i(157532);
    try
    {
      if (new e(paramString).mkdirs())
      {
        paramString = new e(paramString + ".nomedia");
        boolean bool = paramString.exists();
        if (bool) {}
      }
      try
      {
        paramString.createNewFile();
        AppMethodBeat.o(157532);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FilePathGenerator", paramString, "", new Object[0]);
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(157532);
    }
  }
  
  private static String aFk(String paramString)
  {
    AppMethodBeat.i(157531);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157531);
      return null;
    }
    if (paramString.length() <= 4)
    {
      AppMethodBeat.o(157531);
      return null;
    }
    paramString = paramString.substring(0, 2) + "/" + paramString.substring(2, 4) + "/";
    AppMethodBeat.o(157531);
    return paramString;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(157535);
    paramString1 = paramString1 + paramString3 + paramString4 + paramString5;
    paramString2 = a(paramString2, paramString3, paramString4, paramString5, 1, paramBoolean);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157535);
      return null;
    }
    paramString3 = new e(paramString2);
    paramString4 = new e(paramString1);
    if (paramString3.exists())
    {
      AppMethodBeat.o(157535);
      return paramString2;
    }
    if (paramString4.exists()) {
      o.C(paramString1, paramString2, false);
    }
    AppMethodBeat.o(157535);
    return paramString2;
  }
  
  public static String d(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(157534);
    paramString1 = a(paramString1, paramString2, paramString3, paramString4, paramInt, true);
    AppMethodBeat.o(157534);
    return paramString1;
  }
  
  public static String j(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(157536);
    paramString1 = b(paramString1, paramString2, paramString3, paramString4, paramString5, true);
    AppMethodBeat.o(157536);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.l
 * JD-Core Version:    0.7.0.1
 */