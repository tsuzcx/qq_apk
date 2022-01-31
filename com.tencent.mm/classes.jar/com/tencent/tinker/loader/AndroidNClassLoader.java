package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
class AndroidNClassLoader
  extends PathClassLoader
{
  private static Object Btw = null;
  private static String Btx = null;
  private final BaseDexClassLoader Bty;
  private String Btz;
  
  private AndroidNClassLoader(String paramString, BaseDexClassLoader paramBaseDexClassLoader, Application paramApplication)
  {
    super(paramString, paramBaseDexClassLoader.getParent());
    this.Bty = paramBaseDexClassLoader;
    paramString = paramApplication.getClass().getName();
    if ((paramString != null) && (!paramString.equals("android.app.Application"))) {
      this.Btz = paramString;
    }
    Btx = paramApplication.getPackageCodePath();
  }
  
  public static AndroidNClassLoader a(BaseDexClassLoader paramBaseDexClassLoader, Application paramApplication)
  {
    AndroidNClassLoader localAndroidNClassLoader = new AndroidNClassLoader("", paramBaseDexClassLoader, paramApplication);
    Field localField = ShareReflectUtil.b(paramBaseDexClassLoader, "pathList");
    paramBaseDexClassLoader = localField.get(paramBaseDexClassLoader);
    Constructor localConstructor = ShareReflectUtil.a(paramBaseDexClassLoader, new Class[] { ClassLoader.class, String.class, String.class, File.class });
    Object localObject2 = (Object[])ShareReflectUtil.b(paramBaseDexClassLoader, "dexElements").get(paramBaseDexClassLoader);
    Object localObject1 = (List)ShareReflectUtil.b(paramBaseDexClassLoader, "nativeLibraryDirectories").get(paramBaseDexClassLoader);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3 = ShareReflectUtil.g(localObject2.getClass().getComponentType(), "dexFile");
    int i = 1;
    int m = localObject2.length;
    int j = 0;
    if (j < m)
    {
      DexFile localDexFile = (DexFile)((Field)localObject3).get(localObject2[j]);
      int k = i;
      if (localDexFile != null)
      {
        k = i;
        if (localDexFile.getName() != null)
        {
          k = i;
          if (localDexFile.getName().equals(Btx))
          {
            if (i == 0) {
              break label210;
            }
            i = 0;
          }
        }
      }
      for (;;)
      {
        localStringBuilder.append(localDexFile.getName());
        k = i;
        j += 1;
        i = k;
        break;
        label210:
        localStringBuilder.append(File.pathSeparator);
      }
    }
    localObject2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localObject1 = ((List)localObject1).iterator();
    i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (File)((Iterator)localObject1).next();
      if (localObject3 != null)
      {
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append(((File)localObject3).getAbsolutePath());
          break;
          localStringBuilder.append(File.pathSeparator);
        }
      }
    }
    localField.set(localAndroidNClassLoader, localConstructor.newInstance(new Object[] { localAndroidNClassLoader, localObject2, localStringBuilder.toString(), null }));
    ShareReflectUtil.b(paramBaseDexClassLoader, "definingContext").set(paramBaseDexClassLoader, localAndroidNClassLoader);
    Btw = paramBaseDexClassLoader;
    paramBaseDexClassLoader = (Context)ShareReflectUtil.b(paramApplication, "mBase").get(paramApplication);
    paramBaseDexClassLoader = ShareReflectUtil.b(paramBaseDexClassLoader, "mPackageInfo").get(paramBaseDexClassLoader);
    ShareReflectUtil.b(paramBaseDexClassLoader, "mClassLoader").set(paramBaseDexClassLoader, localAndroidNClassLoader);
    if (Build.VERSION.SDK_INT < 27)
    {
      paramBaseDexClassLoader = paramApplication.getResources();
      ShareReflectUtil.b(paramBaseDexClassLoader, "mClassLoader").set(paramBaseDexClassLoader, localAndroidNClassLoader);
      paramBaseDexClassLoader = ShareReflectUtil.b(paramBaseDexClassLoader, "mDrawableInflater").get(paramBaseDexClassLoader);
      if (paramBaseDexClassLoader != null) {
        ShareReflectUtil.b(paramBaseDexClassLoader, "mClassLoader").set(paramBaseDexClassLoader, localAndroidNClassLoader);
      }
    }
    Thread.currentThread().setContextClassLoader(localAndroidNClassLoader);
    return localAndroidNClassLoader;
  }
  
  public Class<?> findClass(String paramString)
  {
    if ((this.Btz != null) && (this.Btz.equals(paramString))) {
      return this.Bty.loadClass(paramString);
    }
    if ((paramString != null) && (paramString.startsWith("com.tencent.tinker.loader.")) && (!paramString.equals("com.tencent.tinker.loader.TinkerTestDexLoad"))) {
      return this.Bty.loadClass(paramString);
    }
    if ((paramString != null) && ((paramString.startsWith("org.apache.commons.codec.")) || (paramString.startsWith("org.apache.commons.logging.")) || (paramString.startsWith("org.apache.http.")))) {
      return this.Bty.loadClass(paramString);
    }
    try
    {
      Class localClass = super.findClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return this.Bty.loadClass(paramString);
  }
  
  public String findLibrary(String paramString)
  {
    return super.findLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.AndroidNClassLoader
 * JD-Core Version:    0.7.0.1
 */