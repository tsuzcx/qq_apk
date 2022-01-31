package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.g;
import java.io.File;
import java.io.IOException;

public final class h
{
  public static boolean Vu(String paramString)
  {
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
        return true;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FilePathGenerator", paramString, "", new Object[0]);
        }
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  private static String YX(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (paramString.length() <= 4) {
      return null;
    }
    return paramString.substring(0, 2) + "/" + paramString.substring(2, 4) + "/";
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    if (bk.bl(paramString1)) {}
    label139:
    for (;;)
    {
      return null;
      if (paramString1.endsWith("/"))
      {
        String str = "";
        if (paramInt == 1) {
          str = YX(paramString3);
        }
        for (;;)
        {
          if (bk.bl(str)) {
            break label139;
          }
          paramString1 = paramString1 + str;
          if ((paramBoolean) && (!Vu(paramString1))) {
            break;
          }
          return paramString1 + bk.pm(paramString2) + paramString3 + bk.pm(paramString4);
          if (paramInt == 2) {
            if (bk.bl(paramString3)) {
              str = null;
            } else {
              str = YX(g.o(paramString3.getBytes()));
            }
          }
        }
      }
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    return a(paramString1, paramString2, paramString3, paramString4, paramInt, true);
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    String str = paramString1 + paramString3 + paramString4 + paramString5;
    paramString2 = a(paramString2, paramString3, paramString4, paramString5, 1, paramBoolean);
    if ((bk.bl(str)) || (bk.bl(paramString2))) {
      paramString1 = null;
    }
    do
    {
      do
      {
        return paramString1;
        paramString3 = new File(paramString2);
        paramString4 = new File(str);
        paramString1 = paramString2;
      } while (paramString3.exists());
      paramString1 = paramString2;
    } while (!paramString4.exists());
    j.u(str, paramString2, false);
    return paramString2;
  }
  
  public static String e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return b(paramString1, paramString2, paramString3, paramString4, paramString5, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.h
 * JD-Core Version:    0.7.0.1
 */