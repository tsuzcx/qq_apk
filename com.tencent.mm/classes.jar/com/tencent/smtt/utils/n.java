package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class n
{
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(219348);
    boolean bool = true;
    if (Looper.getMainLooper() != Looper.myLooper()) {
      bool = b(paramContext);
    }
    AppMethodBeat.o(219348);
    return bool;
  }
  
  private static boolean a(File paramFile)
  {
    AppMethodBeat.i(219356);
    try
    {
      boolean bool = e.b(paramFile);
      if (!bool)
      {
        AppMethodBeat.o(219356);
        return true;
      }
    }
    finally
    {
      new StringBuilder("isOatFileBroken exception: ").append(paramFile);
      AppMethodBeat.o(219356);
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(219351);
    for (;;)
    {
      int i;
      try
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          i = Build.VERSION.SDK_INT;
          if (i <= 25) {}
        }
        else
        {
          AppMethodBeat.o(219351);
          return true;
        }
        paramContext = c(paramContext);
        if (paramContext == null)
        {
          AppMethodBeat.o(219351);
          return true;
        }
        paramContext = paramContext.listFiles(new n.1());
        int j = paramContext.length;
        i = 0;
        if (i < j)
        {
          File localFile = paramContext[i];
          if ((!localFile.isFile()) || (!localFile.exists())) {
            break label174;
          }
          if (a(localFile))
          {
            TbsLog.w("TbsCheckUtils", localFile + " is invalid --> check failed!");
            localFile.delete();
            AppMethodBeat.o(219351);
            return false;
          }
          TbsLog.i("TbsCheckUtils", localFile + " #4 check success!");
        }
      }
      finally
      {
        TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
        AppMethodBeat.o(219351);
        return true;
      }
      label174:
      i += 1;
    }
  }
  
  private static File c(Context paramContext)
  {
    AppMethodBeat.i(219344);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share");
    if ((!paramContext.isDirectory()) || (!paramContext.exists()))
    {
      AppMethodBeat.o(219344);
      return null;
    }
    AppMethodBeat.o(219344);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */