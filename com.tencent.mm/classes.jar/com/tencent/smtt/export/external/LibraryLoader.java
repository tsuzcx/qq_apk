package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader
{
  private static String[] sLibrarySearchPaths = null;
  private byte _hellAccFlag_;
  
  public static String[] getLibrarySearchPaths(Context paramContext)
  {
    AppMethodBeat.i(53150);
    if (sLibrarySearchPaths != null)
    {
      paramContext = sLibrarySearchPaths;
      AppMethodBeat.o(53150);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(53150);
      return new String[] { "/system/lib" };
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getNativeLibraryDir(paramContext));
    localArrayList.add("/system/lib");
    paramContext = new String[localArrayList.size()];
    localArrayList.toArray(paramContext);
    sLibrarySearchPaths = paramContext;
    AppMethodBeat.o(53150);
    return paramContext;
  }
  
  public static String getNativeLibraryDir(Context paramContext)
  {
    AppMethodBeat.i(53151);
    int i = Build.VERSION.SDK_INT;
    if (i >= 9)
    {
      paramContext = paramContext.getApplicationInfo().nativeLibraryDir;
      AppMethodBeat.o(53151);
      return paramContext;
    }
    if (i >= 4)
    {
      paramContext = paramContext.getApplicationInfo().dataDir + "/lib";
      AppMethodBeat.o(53151);
      return paramContext;
    }
    paramContext = "/data/data/" + paramContext.getPackageName() + "/lib";
    AppMethodBeat.o(53151);
    return paramContext;
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(53152);
    paramContext = getLibrarySearchPaths(paramContext);
    String str1 = System.mapLibraryName(paramString);
    int j = paramContext.length;
    while (i < j)
    {
      String str2 = paramContext[i];
      str2 = str2 + "/" + str1;
      if (new File(str2).exists()) {
        try
        {
          System.load(str2);
          AppMethodBeat.o(53152);
          return;
        }
        catch (Exception paramContext)
        {
          AppMethodBeat.o(53152);
          return;
        }
      }
      i += 1;
    }
    try
    {
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      paramString = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramString, paramContext.aYi(), "com/tencent/smtt/export/external/LibraryLoader", "loadLibrary", "(Landroid/content/Context;Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)paramContext.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/smtt/export/external/LibraryLoader", "loadLibrary", "(Landroid/content/Context;Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      AppMethodBeat.o(53152);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(53152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */