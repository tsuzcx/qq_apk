package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.tinker.loader.a.b;
import com.tencent.tinker.loader.a.h;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemClassLoaderAdder
{
  private static int aku = 0;
  
  @SuppressLint({"NewApi"})
  public static void a(Application paramApplication, PathClassLoader paramPathClassLoader, File paramFile, List<File> paramList)
  {
    Log.i("Tinker.ClassLoaderAdder", "installDexes dexOptDir: " + paramFile.getAbsolutePath() + ", dex size:" + paramList.size());
    if (!paramList.isEmpty())
    {
      List localList = n(paramList);
      paramList = paramPathClassLoader;
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramList = paramPathClassLoader;
        if (!m(localList)) {
          paramList = AndroidNClassLoader.a(paramPathClassLoader, paramApplication);
        }
      }
      if (Build.VERSION.SDK_INT >= 23) {
        SystemClassLoaderAdder.V23.c(paramList, localList, paramFile);
      }
      for (;;)
      {
        aku = localList.size();
        Log.i("Tinker.ClassLoaderAdder", "after loaded classloader: " + paramList + ", dex size:" + aku);
        boolean bool = ((Boolean)h.a(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, paramList), "isPatch").get(null)).booleanValue();
        Log.w("Tinker.ClassLoaderAdder", "checkDexInstall result:" + bool);
        if (bool) {
          break;
        }
        a(paramList);
        throw new TinkerRuntimeException("checkDexInstall failed");
        if (Build.VERSION.SDK_INT >= 19) {
          SystemClassLoaderAdder.V19.b(paramList, localList, paramFile);
        } else if (Build.VERSION.SDK_INT >= 14) {
          SystemClassLoaderAdder.V14.a(paramList, localList, paramFile);
        } else {
          SystemClassLoaderAdder.V4.d(paramList, localList, paramFile);
        }
      }
    }
  }
  
  public static void a(ClassLoader paramClassLoader)
  {
    if (aku <= 0) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      h.a(h.a(paramClassLoader, "pathList").get(paramClassLoader), "dexElements", aku);
      return;
    }
    h.a(paramClassLoader, "mPaths", aku);
    h.a(paramClassLoader, "mFiles", aku);
    h.a(paramClassLoader, "mZips", aku);
    try
    {
      h.a(paramClassLoader, "mDexs", aku);
      return;
    }
    catch (Exception paramClassLoader) {}
  }
  
  private static boolean m(List<File> paramList)
  {
    if (!paramList.isEmpty())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        File localFile = (File)paramList.next();
        if ((localFile != null) && (localFile.getName().startsWith("changed_classes.dex"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static List<File> n(List<File> paramList)
  {
    paramList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((File)localIterator.next()).getName();
      localHashMap.put(str, Boolean.valueOf(b.alU.matcher(str).matches()));
    }
    Collections.sort(paramList, new Comparator() {});
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder
 * JD-Core Version:    0.7.0.1
 */