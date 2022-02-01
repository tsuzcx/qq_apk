package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
import java.io.File;

public class r
{
  private static File a = null;
  
  public static long a()
  {
    AppMethodBeat.i(200251);
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    long l2 = localStatFs.getAvailableBlocks();
    AppMethodBeat.o(200251);
    return l2 * l1;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(200255);
    if (paramContext == null)
    {
      AppMethodBeat.o(200255);
      return false;
    }
    if (a == null) {
      try
      {
        boolean bool = paramContext.getApplicationInfo().processName.contains("com.tencent.mm");
        if (!bool)
        {
          AppMethodBeat.o(200255);
          return false;
        }
        paramContext = QbSdk.getTbsFolderDir(paramContext);
        if (paramContext != null)
        {
          bool = paramContext.isDirectory();
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(200255);
          return false;
        }
        paramContext = new File(paramContext, "share");
        if (!paramContext.isDirectory())
        {
          bool = paramContext.mkdir();
          if (!bool)
          {
            AppMethodBeat.o(200255);
            return false;
          }
        }
        a = paramContext;
        paramContext.setExecutable(true, false);
        AppMethodBeat.o(200255);
        return true;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(200255);
        return false;
      }
    }
    AppMethodBeat.o(200255);
    return true;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(200259);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("scfh", false);
      bool1 = bool2;
      TbsLog.i("TbsUtils", "isStableCoreForHostEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c.a().a(paramContext, Integer.valueOf(1003), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(200533);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("scfh", true);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1003](" + paramAnonymousString + ")");
          AppMethodBeat.o(200533);
        }
      });
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(200259);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.r
 * JD-Core Version:    0.7.0.1
 */