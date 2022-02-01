package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileFilter;

public class m
{
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(54013);
    boolean bool = true;
    if (Looper.getMainLooper() != Looper.myLooper()) {
      bool = b(paramContext);
    }
    AppMethodBeat.o(54013);
    return bool;
  }
  
  private static boolean a(File paramFile)
  {
    AppMethodBeat.i(54015);
    try
    {
      boolean bool = e.b(paramFile);
      if (!bool)
      {
        AppMethodBeat.o(54015);
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      new StringBuilder("isOatFileBroken exception: ").append(paramFile);
      AppMethodBeat.o(54015);
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(54014);
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
          AppMethodBeat.o(54014);
          return true;
        }
        paramContext = c(paramContext);
        if (paramContext == null)
        {
          AppMethodBeat.o(54014);
          return true;
        }
        paramContext = paramContext.listFiles(new FileFilter()
        {
          public final boolean accept(File paramAnonymousFile)
          {
            AppMethodBeat.i(53958);
            paramAnonymousFile = paramAnonymousFile.getName();
            if ((!TextUtils.isEmpty(paramAnonymousFile)) && (paramAnonymousFile.endsWith(".dex")))
            {
              AppMethodBeat.o(53958);
              return true;
            }
            AppMethodBeat.o(53958);
            return false;
          }
        });
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
            AppMethodBeat.o(54014);
            return false;
          }
          TbsLog.i("TbsCheckUtils", localFile + " #4 check success!");
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
        AppMethodBeat.o(54014);
        return true;
      }
      label174:
      i += 1;
    }
  }
  
  private static File c(Context paramContext)
  {
    AppMethodBeat.i(54012);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share");
    if ((!paramContext.isDirectory()) || (!paramContext.exists()))
    {
      AppMethodBeat.o(54012);
      return null;
    }
    AppMethodBeat.o(54012);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */