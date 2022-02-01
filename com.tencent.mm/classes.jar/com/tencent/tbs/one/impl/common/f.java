package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class f
{
  public static File a(Context paramContext)
  {
    AppMethodBeat.i(174236);
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramContext = new File(paramContext.getApplicationInfo().nativeLibraryDir);
      AppMethodBeat.o(174236);
      return paramContext;
    }
    if (Build.VERSION.SDK_INT > 4)
    {
      paramContext = new File(paramContext.getApplicationInfo().dataDir, "lib");
      AppMethodBeat.o(174236);
      return paramContext;
    }
    paramContext = new File(paramContext.getFilesDir().getParentFile(), "lib");
    AppMethodBeat.o(174236);
    return paramContext;
  }
  
  public static File a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192453);
    if (paramContext1 == paramContext2)
    {
      paramContext1 = paramContext1.getExternalFilesDir("tbs");
      if (paramContext1 == null) {
        break label136;
      }
    }
    label136:
    for (paramContext1 = new File(new File(paramContext1, paramString1), paramString2);; paramContext1 = null)
    {
      if (paramContext1 == null) {
        break label141;
      }
      paramContext1 = new File(paramContext1, String.valueOf(paramInt));
      AppMethodBeat.o(192453);
      return paramContext1;
      if (paramContext1.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", paramContext1.getPackageName()) == 0)
      {
        paramContext1 = paramContext2.getPackageName();
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          paramContext1 = new File(Environment.getExternalStorageDirectory(), "Android/data/" + paramContext1 + "/files/tbs");
          break;
        }
      }
      paramContext1 = null;
      break;
    }
    label141:
    AppMethodBeat.o(192453);
    return null;
  }
  
  public static File a(File paramFile)
  {
    AppMethodBeat.i(174237);
    paramFile = new File(paramFile, "home");
    AppMethodBeat.o(174237);
    return paramFile;
  }
  
  public static File a(File paramFile, int paramInt)
  {
    AppMethodBeat.i(174247);
    paramFile = new File(new File(paramFile, "proc"), String.valueOf(paramInt));
    AppMethodBeat.o(174247);
    return paramFile;
  }
  
  public static File a(File paramFile, String paramString)
  {
    AppMethodBeat.i(174238);
    paramFile = new File(a(paramFile), paramString);
    AppMethodBeat.o(174238);
    return paramFile;
  }
  
  public static File a(File paramFile, String paramString, int paramInt)
  {
    AppMethodBeat.i(174243);
    paramFile = new File(b(paramFile, paramString), String.valueOf(paramInt));
    AppMethodBeat.o(174243);
    return paramFile;
  }
  
  public static File a(File paramFile, String paramString1, String paramString2)
  {
    AppMethodBeat.i(174245);
    paramString1 = Base64.encodeToString((paramString1 + File.separator + paramString2).getBytes(b.a), 2);
    String str1 = "libtbs=" + paramString1 + ".so";
    File localFile = new File(paramFile, str1);
    paramString1 = localFile;
    if (!localFile.exists())
    {
      String str2 = "libtbs" + paramString2 + ".so";
      localFile = new File(paramFile, str2);
      paramString1 = localFile;
      if (!localFile.exists())
      {
        paramFile = new File(paramFile, paramString2);
        paramString1 = paramFile;
        if (!paramFile.exists())
        {
          com.tencent.tbs.one.impl.a.f.b("Failed to find component file %s or %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str2, str1 });
          paramString1 = paramFile;
        }
      }
    }
    AppMethodBeat.o(174245);
    return paramString1;
  }
  
  public static File b(Context paramContext)
  {
    AppMethodBeat.i(174246);
    paramContext = new File(paramContext.getDir("tbs", 0), "proc");
    AppMethodBeat.o(174246);
    return paramContext;
  }
  
  public static File b(File paramFile)
  {
    AppMethodBeat.i(174239);
    paramFile = new File(paramFile, "DEPS");
    AppMethodBeat.o(174239);
    return paramFile;
  }
  
  public static File b(File paramFile, String paramString)
  {
    AppMethodBeat.i(174242);
    paramFile = new File(d(paramFile), paramString);
    AppMethodBeat.o(174242);
    return paramFile;
  }
  
  public static File c(File paramFile)
  {
    AppMethodBeat.i(174240);
    paramFile = new File(paramFile, "DEPS.latest");
    AppMethodBeat.o(174240);
    return paramFile;
  }
  
  public static File c(File paramFile, String paramString)
  {
    AppMethodBeat.i(174244);
    String str = "libtbs" + paramString + "DEPS.so";
    File localFile = new File(paramFile, str);
    paramString = localFile;
    if (!localFile.exists())
    {
      paramFile = new File(paramFile, "libtbsDEPS.so");
      paramString = paramFile;
      if (!paramFile.exists())
      {
        com.tencent.tbs.one.impl.a.f.b("Failed to find DEPS file %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str });
        paramString = paramFile;
      }
    }
    AppMethodBeat.o(174244);
    return paramString;
  }
  
  public static File d(File paramFile)
  {
    AppMethodBeat.i(174241);
    paramFile = new File(paramFile, "components");
    AppMethodBeat.o(174241);
    return paramFile;
  }
  
  public static File d(File paramFile, String paramString)
  {
    AppMethodBeat.i(174248);
    paramFile = new File(paramFile, paramString);
    AppMethodBeat.o(174248);
    return paramFile;
  }
  
  public static File e(File paramFile, String paramString)
  {
    AppMethodBeat.i(174249);
    paramFile = new File(paramFile.getParent(), paramFile.getName() + paramString);
    AppMethodBeat.o(174249);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.f
 * JD-Core Version:    0.7.0.1
 */