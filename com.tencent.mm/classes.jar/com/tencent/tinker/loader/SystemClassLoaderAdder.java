package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.BaseDexClassLoader;
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
  private static int BtA = 0;
  
  @SuppressLint({"NewApi"})
  public static void a(Application paramApplication, BaseDexClassLoader paramBaseDexClassLoader, File paramFile, List<File> paramList, boolean paramBoolean)
  {
    new StringBuilder("installDexes dexOptDir: ").append(paramFile.getAbsolutePath()).append(", dex size:").append(paramList.size());
    if (!paramList.isEmpty())
    {
      List localList = fK(paramList);
      paramList = paramBaseDexClassLoader;
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramList = paramBaseDexClassLoader;
        if (!paramBoolean) {
          paramList = AndroidNClassLoader.a(paramBaseDexClassLoader, paramApplication);
        }
      }
      if (Build.VERSION.SDK_INT >= 23) {
        V23.d(paramList, localList, paramFile);
      }
      for (;;)
      {
        BtA = localList.size();
        new StringBuilder("after loaded classloader: ").append(paramList).append(", dex size:").append(BtA);
        if (((Boolean)ShareReflectUtil.g(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, paramList), "isPatch").get(null)).booleanValue()) {
          break;
        }
        a(paramList);
        throw new TinkerRuntimeException("checkDexInstall failed");
        if (Build.VERSION.SDK_INT >= 19) {
          V19.c(paramList, localList, paramFile);
        } else if (Build.VERSION.SDK_INT >= 14) {
          V14.b(paramList, localList, paramFile);
        } else {
          V4.e(paramList, localList, paramFile);
        }
      }
    }
  }
  
  public static void a(ClassLoader paramClassLoader)
  {
    if (BtA <= 0) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ShareReflectUtil.a(ShareReflectUtil.b(paramClassLoader, "pathList").get(paramClassLoader), "dexElements", BtA);
      return;
    }
    ShareReflectUtil.a(paramClassLoader, "mPaths", BtA);
    ShareReflectUtil.a(paramClassLoader, "mFiles", BtA);
    ShareReflectUtil.a(paramClassLoader, "mZips", BtA);
    try
    {
      ShareReflectUtil.a(paramClassLoader, "mDexs", BtA);
      return;
    }
    catch (Exception paramClassLoader) {}
  }
  
  private static List<File> fK(List<File> paramList)
  {
    paramList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((File)localIterator.next()).getName();
      localHashMap.put(str, Boolean.valueOf(ShareConstants.BuP.matcher(str).matches()));
    }
    Collections.sort(paramList, new Comparator() {});
    return paramList;
  }
  
  static final class V14 {}
  
  static final class V19
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
  
  static final class V23
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
  
  static final class V4 {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder
 * JD-Core Version:    0.7.0.1
 */