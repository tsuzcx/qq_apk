package com.tencent.tinker.loader;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public class SystemClassLoaderAdder
{
  public static final String CHECK_DEX_CLASS = "com.tencent.tinker.loader.TinkerTestDexLoad";
  public static final String CHECK_DEX_FIELD = "isPatch";
  private static final String TAG = "Tinker.ClassLoaderAdder";
  private static int sPatchDexCount = 0;
  
  private static boolean checkDexInstall(ClassLoader paramClassLoader)
  {
    paramClassLoader = Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, paramClassLoader);
    boolean bool = ((Boolean)ShareReflectUtil.findField(paramClassLoader, "isPatch").get(null)).booleanValue();
    ShareTinkerLog.i("Tinker.ClassLoaderAdder", "checkDexInstall result: %s, checker_classloader: %s", new Object[] { Boolean.valueOf(bool), paramClassLoader.getClassLoader() });
    return bool;
  }
  
  private static List<File> createSortedAdditionalPathEntries(List<File> paramList)
  {
    paramList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((File)localIterator.next()).getName();
      localHashMap.put(str, Boolean.valueOf(ShareConstants.CLASS_N_PATTERN.matcher(str).matches()));
    }
    Collections.sort(paramList, new SystemClassLoaderAdder.1(localHashMap));
    return paramList;
  }
  
  static void injectDexesInternal(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      V23.install(paramClassLoader, paramList, paramFile);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      V19.install(paramClassLoader, paramList, paramFile);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      V14.install(paramClassLoader, paramList, paramFile);
      return;
    }
    V4.install(paramClassLoader, paramList, paramFile);
  }
  
  public static void installApk(PathClassLoader paramPathClassLoader, List<File> paramList)
  {
    if (!paramList.isEmpty())
    {
      paramList = createSortedAdditionalPathEntries(paramList);
      ArkHot.install(paramPathClassLoader, paramList);
      sPatchDexCount = paramList.size();
      ShareTinkerLog.i("Tinker.ClassLoaderAdder", "after loaded classloader: " + paramPathClassLoader + ", dex size:" + sPatchDexCount, new Object[0]);
      checkDexInstall(paramPathClassLoader);
    }
  }
  
  public static void installDexes(Application paramApplication, ClassLoader paramClassLoader, File paramFile, List<File> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    ShareTinkerLog.i("Tinker.ClassLoaderAdder", "installDexes dexOptDir: " + paramFile.getAbsolutePath() + ", dex size:" + paramList.size(), new Object[0]);
    if (!paramList.isEmpty())
    {
      paramList = createSortedAdditionalPathEntries(paramList);
      if ((Build.VERSION.SDK_INT >= 24) && (!paramBoolean1)) {
        paramClassLoader = NewClassLoaderInjector.inject(paramApplication, paramClassLoader, paramFile, paramBoolean2, paramList);
      }
      for (;;)
      {
        sPatchDexCount = paramList.size();
        ShareTinkerLog.i("Tinker.ClassLoaderAdder", "after loaded classloader: " + paramClassLoader + ", dex size:" + sPatchDexCount, new Object[0]);
        if (checkDexInstall(paramClassLoader)) {
          break;
        }
        uninstallPatchDex(paramClassLoader);
        throw new TinkerRuntimeException("checkDexInstall failed");
        injectDexesInternal(paramClassLoader, paramList, paramFile);
      }
    }
  }
  
  public static void uninstallPatchDex(ClassLoader paramClassLoader)
  {
    if (sPatchDexCount <= 0) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      ShareReflectUtil.reduceFieldArray(ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader), "dexElements", sPatchDexCount);
      return;
    }
    ShareReflectUtil.reduceFieldArray(paramClassLoader, "mPaths", sPatchDexCount);
    ShareReflectUtil.reduceFieldArray(paramClassLoader, "mFiles", sPatchDexCount);
    ShareReflectUtil.reduceFieldArray(paramClassLoader, "mZips", sPatchDexCount);
    try
    {
      ShareReflectUtil.reduceFieldArray(paramClassLoader, "mDexs", sPatchDexCount);
      return;
    }
    catch (Exception paramClassLoader) {}
  }
  
  static final class ArkHot
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList)
    {
      Class localClass = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.classloader.ExtendedClassLoaderHelper");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = ((File)paramList.next()).getCanonicalPath();
        Method localMethod = localClass.getDeclaredMethod("applyPatch", new Class[] { ClassLoader.class, String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { paramClassLoader, str });
        ShareTinkerLog.i("Tinker.ClassLoaderAdder", "ArkHot install path = ".concat(String.valueOf(str)), new Object[0]);
      }
    }
  }
  
  static final class V14
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    {
      paramClassLoader = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
      ShareReflectUtil.expandFieldArray(paramClassLoader, "dexElements", makeDexElements(paramClassLoader, new ArrayList(paramList), paramFile));
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile)
    {
      return (Object[])ShareReflectUtil.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile });
    }
  }
  
  static final class V19
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    {
      paramClassLoader = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      ShareReflectUtil.expandFieldArray(paramClassLoader, "dexElements", makeDexElements(paramClassLoader, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        if (paramClassLoader.hasNext())
        {
          paramClassLoader = (IOException)paramClassLoader.next();
          ShareTinkerLog.w("Tinker.ClassLoaderAdder", "Exception in makeDexElement", new Object[] { paramClassLoader });
          throw paramClassLoader;
        }
      }
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
    {
      try
      {
        Method localMethod1 = ShareReflectUtil.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
        return (Object[])localMethod1.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
          try
          {
            Method localMethod2 = ShareReflectUtil.findMethod(paramObject, "makeDexElements", new Class[] { List.class, File.class, List.class });
          }
          catch (NoSuchMethodException paramObject)
          {
            ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
            throw paramObject;
          }
        }
      }
    }
  }
  
  static final class V23
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    {
      paramClassLoader = ShareReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      ShareReflectUtil.expandFieldArray(paramClassLoader, "dexElements", makePathElements(paramClassLoader, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        if (paramClassLoader.hasNext())
        {
          paramClassLoader = (IOException)paramClassLoader.next();
          ShareTinkerLog.w("Tinker.ClassLoaderAdder", "Exception in makePathElement", new Object[] { paramClassLoader });
          throw paramClassLoader;
        }
      }
    }
    
    private static Object[] makePathElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
    {
      try
      {
        Method localMethod1 = ShareReflectUtil.findMethod(paramObject, "makePathElements", new Class[] { List.class, File.class, List.class });
        return (Object[])localMethod1.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        for (;;)
        {
          ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makePathElements(List,File,List) failure", new Object[0]);
          try
          {
            Method localMethod2 = ShareReflectUtil.findMethod(paramObject, "makePathElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure", new Object[0]);
            try
            {
              ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: try use v19 instead", new Object[0]);
              paramObject = SystemClassLoaderAdder.V19.makeDexElements(paramObject, paramArrayList, paramFile, paramArrayList1);
              return paramObject;
            }
            catch (NoSuchMethodException paramObject)
            {
              ShareTinkerLog.e("Tinker.ClassLoaderAdder", "NoSuchMethodException: makeDexElements(List,File,List) failure", new Object[0]);
              throw paramObject;
            }
          }
        }
      }
    }
  }
  
  static final class V4
  {
    private static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    {
      int i = paramList.size();
      Field localField = ShareReflectUtil.findField(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        File localFile = (File)paramList.next();
        String str = localFile.getAbsolutePath();
        localStringBuilder.append(':').append(str);
        i = paramList.previousIndex();
        arrayOfString[i] = str;
        arrayOfFile[i] = localFile;
        arrayOfZipFile[i] = new ZipFile(localFile);
        arrayOfDexFile[i] = DexFile.loadDex(str, SharePatchFileUtil.optimizedPathFor(localFile, paramFile), 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      ShareReflectUtil.expandFieldArray(paramClassLoader, "mPaths", arrayOfString);
      ShareReflectUtil.expandFieldArray(paramClassLoader, "mFiles", arrayOfFile);
      ShareReflectUtil.expandFieldArray(paramClassLoader, "mZips", arrayOfZipFile);
      try
      {
        ShareReflectUtil.expandFieldArray(paramClassLoader, "mDexs", arrayOfDexFile);
        return;
      }
      catch (Exception paramClassLoader) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.SystemClassLoaderAdder
 * JD-Core Version:    0.7.0.1
 */