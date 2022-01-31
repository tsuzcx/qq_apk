package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class t
{
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(65302);
    boolean bool = true;
    if (Looper.getMainLooper() != Looper.myLooper()) {
      bool = b(paramContext);
    }
    AppMethodBeat.o(65302);
    return bool;
  }
  
  private static boolean a(File paramFile)
  {
    AppMethodBeat.i(65303);
    try
    {
      boolean bool = j.b(paramFile);
      if (!bool)
      {
        AppMethodBeat.o(65303);
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      new StringBuilder("isOatFileBroken exception: ").append(paramFile);
      AppMethodBeat.o(65303);
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(139524);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        i = Build.VERSION.SDK_INT;
        if (i <= 25) {}
      }
      else
      {
        AppMethodBeat.o(139524);
        return true;
      }
      paramContext = c(paramContext);
      if (paramContext == null)
      {
        AppMethodBeat.o(139524);
        return true;
      }
      paramContext = paramContext.listFiles(new u());
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramContext[i];
        if ((localFile.isFile()) && (localFile.exists()))
        {
          if (a(localFile))
          {
            TbsLog.w("TbsCheckUtils", localFile + " is invalid --> check failed!");
            localFile.delete();
            AppMethodBeat.o(139524);
            return false;
          }
          TbsLog.i("TbsCheckUtils", localFile + " #4 check success!");
        }
        i += 1;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
      AppMethodBeat.o(139524);
    }
  }
  
  private static File c(Context paramContext)
  {
    AppMethodBeat.i(139523);
    paramContext = new File(paramContext.getDir("tbs", 0), "core_share");
    if ((!paramContext.isDirectory()) || (!paramContext.exists()))
    {
      AppMethodBeat.o(139523);
      return null;
    }
    AppMethodBeat.o(139523);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.t
 * JD-Core Version:    0.7.0.1
 */