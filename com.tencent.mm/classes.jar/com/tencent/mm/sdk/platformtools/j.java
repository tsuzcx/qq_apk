package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import java.io.File;
import java.io.IOException;

public final class j
{
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51980);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(51980);
      return null;
    }
    if (!paramString1.endsWith("/"))
    {
      AppMethodBeat.o(51980);
      return null;
    }
    String str = "";
    if (paramInt == 1) {
      str = aoW(paramString3);
    }
    while (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(51980);
      return null;
      if (paramInt == 2) {
        if (bo.isNullOrNil(paramString3)) {
          str = null;
        } else {
          str = aoW(g.w(paramString3.getBytes()));
        }
      }
    }
    paramString1 = paramString1 + str;
    if ((paramBoolean) && (!akQ(paramString1)))
    {
      AppMethodBeat.o(51980);
      return null;
    }
    paramString1 = paramString1 + bo.nullAsNil(paramString2) + paramString3 + bo.nullAsNil(paramString4);
    AppMethodBeat.o(51980);
    return paramString1;
  }
  
  public static boolean akQ(String paramString)
  {
    AppMethodBeat.i(51979);
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        paramString = new File(paramString + ".nomedia");
        boolean bool = paramString.exists();
        if (bool) {}
      }
      try
      {
        paramString.createNewFile();
        AppMethodBeat.o(51979);
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FilePathGenerator", paramString, "", new Object[0]);
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(51979);
    }
  }
  
  private static String aoW(String paramString)
  {
    AppMethodBeat.i(51978);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51978);
      return null;
    }
    if (paramString.length() <= 4)
    {
      AppMethodBeat.o(51978);
      return null;
    }
    paramString = paramString.substring(0, 2) + "/" + paramString.substring(2, 4) + "/";
    AppMethodBeat.o(51978);
    return paramString;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(51981);
    paramString1 = a(paramString1, paramString2, paramString3, paramString4, paramInt, true);
    AppMethodBeat.o(51981);
    return paramString1;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(51982);
    paramString1 = paramString1 + paramString3 + paramString4 + paramString5;
    paramString2 = a(paramString2, paramString3, paramString4, paramString5, 1, paramBoolean);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(51982);
      return null;
    }
    paramString3 = new File(paramString2);
    paramString4 = new File(paramString1);
    if (paramString3.exists())
    {
      AppMethodBeat.o(51982);
      return paramString2;
    }
    if (paramString4.exists()) {
      m.C(paramString1, paramString2, false);
    }
    AppMethodBeat.o(51982);
    return paramString2;
  }
  
  public static String h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(51983);
    paramString1 = b(paramString1, paramString2, paramString3, paramString4, paramString5, true);
    AppMethodBeat.o(51983);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.7.0.1
 */