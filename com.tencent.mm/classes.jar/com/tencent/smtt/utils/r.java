package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
import java.io.File;

public class r
{
  private static File a = null;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static long a()
  {
    AppMethodBeat.i(219365);
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    long l2 = localStatFs.getAvailableBlocks();
    AppMethodBeat.o(219365);
    return l2 * l1;
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(219383);
    try
    {
      paramContext = paramContext.getSharedPreferences("sai", 0).edit();
      if (paramBundle.containsKey("turing"))
      {
        boolean bool = paramBundle.getBoolean("turing");
        paramContext.putBoolean("itge", bool);
        TbsLog.e("TbsUtils", "setEnableForThirdParty key is " + "itge" + " value is " + bool);
      }
      paramContext.commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(219383);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {}
  
  public static void a(String paramString1, String paramString2)
  {
    c = paramString1;
    d = paramString2;
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(219370);
    if (paramContext == null)
    {
      AppMethodBeat.o(219370);
      return false;
    }
    if (a == null) {
      try
      {
        boolean bool = paramContext.getApplicationInfo().processName.contains("com.tencent.mm");
        if (!bool)
        {
          AppMethodBeat.o(219370);
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
          AppMethodBeat.o(219370);
          return false;
        }
        paramContext = new File(paramContext, "share");
        if (!paramContext.isDirectory())
        {
          bool = paramContext.mkdir();
          if (!bool)
          {
            AppMethodBeat.o(219370);
            return false;
          }
        }
        a = paramContext;
        paramContext.setExecutable(true, false);
        AppMethodBeat.o(219370);
        return true;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(219370);
        return false;
      }
    }
    AppMethodBeat.o(219370);
    return true;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(219375);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("cbau", false);
      bool1 = bool2;
      TbsLog.i("TbsUtils", "isClearBackupEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c localc = c.a();
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1013), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219385);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("cbau", true);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1013](" + paramAnonymousString + ")");
          AppMethodBeat.o(219385);
        }
      });
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1014), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219386);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("cbau", false);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1014](" + paramAnonymousString + ")");
          AppMethodBeat.o(219386);
        }
      });
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(219375);
    return bool1;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool1 = true;
    AppMethodBeat.i(219377);
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("sai", 0).getBoolean("scfh", true);
      bool1 = bool2;
      TbsLog.i("TbsUtils", "isStableCoreForHostEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c localc = c.a();
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1003), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219387);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("scfh", true);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1003](" + paramAnonymousString + ")");
          AppMethodBeat.o(219387);
        }
      });
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1009), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219388);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("scfh", false);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1009](" + paramAnonymousString + ")");
          AppMethodBeat.o(219388);
        }
      });
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(219377);
    return bool1;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(219380);
    if (!TextUtils.isEmpty(b))
    {
      TbsLog.i("TbsUtils", "getBuildModel from cache is " + b);
      paramContext = b;
      AppMethodBeat.o(219380);
      return paramContext;
    }
    try
    {
      Object localObject = paramContext.getSharedPreferences("sai", 0);
      String str = ((SharedPreferences)localObject).getString("bmo", "");
      b = str;
      if (!TextUtils.isEmpty(str))
      {
        TbsLog.i("TbsUtils", "getBuildModel from bmo is " + b);
        paramContext = b;
        AppMethodBeat.o(219380);
        return paramContext;
      }
      paramContext = paramContext.getSharedPreferences("uifa", 0);
      b = paramContext.getString("model", "");
      TbsLog.i("TbsUtils", "getBuildModel from uifa is " + b);
      if (TextUtils.isEmpty(b))
      {
        b = Build.MODEL;
        TbsLog.i("TbsUtils", "getBuildModel from system is " + b);
      }
      if (!TextUtils.isEmpty(b))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("bmo", b);
        ((SharedPreferences.Editor)localObject).commit();
        paramContext = paramContext.edit();
        paramContext.putString("model", b);
        paramContext.commit();
      }
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    paramContext = b;
    AppMethodBeat.o(219380);
    return paramContext;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(219382);
    boolean bool1 = bool2;
    try
    {
      Context localContext = paramContext.getApplicationContext();
      bool1 = bool2;
      bool2 = localContext.getSharedPreferences("sai", 0).getBoolean("itge", true);
      bool1 = bool2;
      TbsLog.i("TbsUtils", "isTuringEnable is ".concat(String.valueOf(bool2)));
      bool1 = bool2;
      c localc = c.a();
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1021), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219389);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("itge", true);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1021](" + paramAnonymousString + ")");
          AppMethodBeat.o(219389);
        }
      });
      bool1 = bool2;
      localc.a(paramContext, Integer.valueOf(1022), new c.a()
      {
        public final void a(String paramAnonymousString)
        {
          AppMethodBeat.i(219390);
          SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
          localEditor.putBoolean("itge", false);
          localEditor.commit();
          TbsLog.e("TbsUtils", "Execute command [1022](" + paramAnonymousString + ")");
          AppMethodBeat.o(219390);
        }
      });
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(paramContext));
      }
    }
    AppMethodBeat.o(219382);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.r
 * JD-Core Version:    0.7.0.1
 */