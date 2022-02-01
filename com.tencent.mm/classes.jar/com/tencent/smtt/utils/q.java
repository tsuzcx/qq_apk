package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class q
{
  private static File a = null;
  
  public static long a()
  {
    AppMethodBeat.i(54010);
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    long l2 = localStatFs.getAvailableBlocks();
    AppMethodBeat.o(54010);
    return l2 * l1;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(54011);
    if (paramContext == null)
    {
      AppMethodBeat.o(54011);
      return false;
    }
    if (a == null) {
      try
      {
        boolean bool = paramContext.getApplicationInfo().processName.contains("com.tencent.mm");
        if (!bool)
        {
          AppMethodBeat.o(54011);
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
          AppMethodBeat.o(54011);
          return false;
        }
        paramContext = new File(paramContext, "share");
        if (!paramContext.isDirectory())
        {
          bool = paramContext.mkdir();
          if (!bool)
          {
            AppMethodBeat.o(54011);
            return false;
          }
        }
        a = paramContext;
        paramContext.setExecutable(true, false);
        AppMethodBeat.o(54011);
        return true;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(54011);
        return false;
      }
    }
    AppMethodBeat.o(54011);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.q
 * JD-Core Version:    0.7.0.1
 */