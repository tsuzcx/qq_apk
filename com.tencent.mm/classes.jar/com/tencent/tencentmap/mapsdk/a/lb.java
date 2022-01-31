package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.io.File;

public class lb
{
  public static long a(File paramFile)
  {
    long l2 = 0L;
    if ((paramFile == null) || (!paramFile.exists())) {
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
    return l1;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        String str = paramContext.getPackageName();
        if ((str != null) && (str.length() != 0))
        {
          paramContext = str;
          if (str.length() <= 255) {
            continue;
          }
          paramContext = str.substring(0, 254);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return "";
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lb
 * JD-Core Version:    0.7.0.1
 */