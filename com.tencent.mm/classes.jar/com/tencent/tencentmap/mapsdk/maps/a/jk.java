package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class jk
{
  public static long a(File paramFile)
  {
    long l2 = 0L;
    AppMethodBeat.i(148706);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(148706);
      return 0L;
    }
    long l1;
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      l1 = l2;
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          l1 = l2;
          if (i >= j) {
            break;
          }
          l2 += a(localObject[i]);
          i += 1;
        }
      }
    }
    else
    {
      l1 = paramFile.length();
    }
    Object localObject = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
    paramFile.renameTo((File)localObject);
    ((File)localObject).delete();
    AppMethodBeat.o(148706);
    return l1;
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(148707);
    if (paramContext == null)
    {
      AppMethodBeat.o(148707);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        AppMethodBeat.o(148707);
        return "";
      }
      if (paramContext.length() > 255)
      {
        paramContext = paramContext.substring(0, 254);
        AppMethodBeat.o(148707);
        return paramContext;
      }
      AppMethodBeat.o(148707);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(148707);
    }
    return "";
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148705);
    paramString1 = new File(paramString1);
    File localFile = new File(paramString2);
    if (localFile.exists()) {
      a(localFile);
    }
    boolean bool = paramString1.renameTo(new File(paramString2));
    AppMethodBeat.o(148705);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jk
 * JD-Core Version:    0.7.0.1
 */