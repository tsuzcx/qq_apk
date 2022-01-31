package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
  private static int wWW = 0;
  
  @SuppressLint({"NewApi"})
  public static void a(Application paramApplication, PathClassLoader paramPathClassLoader, File paramFile, List<File> paramList)
  {
    new StringBuilder("installDexes dexOptDir: ").append(paramFile.getAbsolutePath()).append(", dex size:").append(paramList.size());
    if (!paramList.isEmpty())
    {
      List localList = eB(paramList);
      paramList = paramPathClassLoader;
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramList = paramPathClassLoader;
        if (!eA(localList)) {
          paramList = AndroidNClassLoader.a(paramPathClassLoader, paramApplication);
        }
      }
      if (Build.VERSION.SDK_INT >= 23) {
        V23.c(paramList, localList, paramFile);
      }
      for (;;)
      {
        wWW = localList.size();
        new StringBuilder("after loaded classloader: ").append(paramList).append(", dex size:").append(wWW);
        if (((Boolean)ShareReflectUtil.d(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, paramList), "isPatch").get(null)).booleanValue()) {
          break;
        }
        a(paramList);
        throw new TinkerRuntimeException("checkDexInstall failed");
        if (Build.VERSION.SDK_INT >= 19) {
          V19.b(paramList, localList, paramFile);
        } else if (Build.VERSION.SDK_INT >= 14) {
          V14.a(paramList, localList, paramFile);
        } else {
          V4.d(paramList, localList, paramFile);
        }
      }
    }
  }
  
  public static void a(ClassLoader paramClassLoader)
  {
    if (wWW <= 0) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ShareReflectUtil.a(ShareReflectUtil.b(paramClassLoader, "pathList").get(paramClassLoader), "dexElements", wWW);
      return;
    }
    ShareReflectUtil.a(paramClassLoader, "mPaths", wWW);
    ShareReflectUtil.a(paramClassLoader, "mFiles", wWW);
    ShareReflectUtil.a(paramClassLoader, "mZips", wWW);
    try
    {
      ShareReflectUtil.a(paramClassLoader, "mDexs", wWW);
      return;
    }
    catch (Exception paramClassLoader) {}
  }
  
  private static boolean eA(List<File> paramList)
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
  
  private static List<File> eB(List<File> paramList)
  {
    paramList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((File)localIterator.next()).getName();
      localHashMap.put(str, Boolean.valueOf(ShareConstants.wYl.matcher(str).matches()));
    }
    Collections.sort(paramList, new Comparator() {});
    return paramList;
  }
  
  private static final class V14 {}
  
  private static final class V19
  {
    private static Object[] a(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
    {
      try
      {
        Method localMethod1 = ShareReflectUtil.b(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
        return (Object[])localMethod1.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          Method localMethod2 = ShareReflectUtil.b(paramObject, "makeDexElements", new Class[] { List.class, File.class, List.class });
        }
        catch (NoSuchMethodException paramObject)
        {
          throw paramObject;
        }
      }
    }
  }
  
  private static final class V23
  {
    private static Object[] c(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
    {
      try
      {
        Method localMethod1 = ShareReflectUtil.b(paramObject, "makePathElements", new Class[] { List.class, File.class, List.class });
        return (Object[])localMethod1.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          Method localMethod2 = ShareReflectUtil.b(paramObject, "makePathElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          try
          {
            paramObject = SystemClassLoaderAdder.V19.b(paramObject, paramArrayList, paramFile, paramArrayList1);
            return paramObject;
          }
          catch (NoSuchMethodException paramObject)
          {
            throw paramObject;
          }
        }
      }
    }
  }
  
  private static final class V4 {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder
 * JD-Core Version:    0.7.0.1
 */