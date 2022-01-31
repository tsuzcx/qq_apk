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
  
  public static String[] getLibrarySearchPaths(Context paramContext)
  {
    AppMethodBeat.i(63770);
    if (sLibrarySearchPaths != null)
    {
      paramContext = sLibrarySearchPaths;
      AppMethodBeat.o(63770);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(63770);
      return new String[] { "/system/lib" };
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getNativeLibraryDir(paramContext));
    localArrayList.add("/system/lib");
    paramContext = new String[localArrayList.size()];
    localArrayList.toArray(paramContext);
    sLibrarySearchPaths = paramContext;
    AppMethodBeat.o(63770);
    return paramContext;
  }
  
  public static String getNativeLibraryDir(Context paramContext)
  {
    AppMethodBeat.i(63771);
    int i = Build.VERSION.SDK_INT;
    if (i >= 9)
    {
      paramContext = paramContext.getApplicationInfo().nativeLibraryDir;
      AppMethodBeat.o(63771);
      return paramContext;
    }
    if (i >= 4)
    {
      paramContext = paramContext.getApplicationInfo().dataDir + "/lib";
      AppMethodBeat.o(63771);
      return paramContext;
    }
    paramContext = "/data/data/" + paramContext.getPackageName() + "/lib";
    AppMethodBeat.o(63771);
    return paramContext;
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
  {
    AppMethodBeat.i(63772);
    paramContext = getLibrarySearchPaths(paramContext);
    String str1 = System.mapLibraryName(paramString);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramContext[i];
      str2 = str2 + "/" + str1;
      if (new File(str2).exists()) {
        try
        {
          System.load(str2);
          AppMethodBeat.o(63772);
          return;
        }
        catch (Exception paramContext)
        {
          AppMethodBeat.o(63772);
          return;
        }
      }
      i += 1;
    }
    try
    {
      System.loadLibrary(paramString);
      AppMethodBeat.o(63772);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(63772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */