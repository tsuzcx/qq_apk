package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.tinker.loader.a.b;
import com.tencent.tinker.loader.a.h;
import dalvik.system.BaseDexClassLoader;
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
  private static int anU = 0;
  
  @SuppressLint({"NewApi"})
  public static void a(Application paramApplication, BaseDexClassLoader paramBaseDexClassLoader, File paramFile, List<File> paramList, boolean paramBoolean)
  {
    Log.i("Tinker.ClassLoaderAdder", "installDexes dexOptDir: " + paramFile.getAbsolutePath() + ", dex size:" + paramList.size());
    if (!paramList.isEmpty())
    {
      List localList = m(paramList);
      paramList = paramBaseDexClassLoader;
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramList = paramBaseDexClassLoader;
        if (!paramBoolean) {
          paramList = AndroidNClassLoader.a(paramBaseDexClassLoader, paramApplication);
        }
      }
      if (Build.VERSION.SDK_INT >= 23) {
        SystemClassLoaderAdder.V23.c(paramList, localList, paramFile);
      }
      for (;;)
      {
        anU = localList.size();
        Log.i("Tinker.ClassLoaderAdder", "after loaded classloader: " + paramList + ", dex size:" + anU);
        paramBoolean = ((Boolean)h.a(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, paramList), "isPatch").get(null)).booleanValue();
        Log.w("Tinker.ClassLoaderAdder", "checkDexInstall result:".concat(String.valueOf(paramBoolean)));
        if (paramBoolean) {
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
    if (anU <= 0) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      h.a(h.d(paramClassLoader, "pathList").get(paramClassLoader), "dexElements", anU);
      return;
    }
    h.a(paramClassLoader, "mPaths", anU);
    h.a(paramClassLoader, "mFiles", anU);
    h.a(paramClassLoader, "mZips", anU);
    try
    {
      h.a(paramClassLoader, "mDexs", anU);
      return;
    }
    catch (Exception paramClassLoader) {}
  }
  
  private static List<File> m(List<File> paramList)
  {
    paramList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((File)localIterator.next()).getName();
      localHashMap.put(str, Boolean.valueOf(b.apu.matcher(str).matches()));
    }
    Collections.sort(paramList, new Comparator() {});
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder
 * JD-Core Version:    0.7.0.1
 */