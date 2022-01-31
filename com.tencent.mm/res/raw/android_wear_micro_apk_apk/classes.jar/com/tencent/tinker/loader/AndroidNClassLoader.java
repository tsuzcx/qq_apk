package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.a.h;
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
  private static Object akr = null;
  private final PathClassLoader aks;
  private String akt;
  
  private AndroidNClassLoader(String paramString, PathClassLoader paramPathClassLoader, Application paramApplication)
  {
    super(paramString, paramPathClassLoader.getParent());
    this.aks = paramPathClassLoader;
    paramString = paramApplication.getClass().getName();
    if ((paramString != null) && (!paramString.equals("android.app.Application"))) {
      this.akt = paramString;
    }
  }
  
  public static AndroidNClassLoader a(PathClassLoader paramPathClassLoader, Application paramApplication)
  {
    AndroidNClassLoader localAndroidNClassLoader = new AndroidNClassLoader("", paramPathClassLoader, paramApplication);
    Field localField = h.a(paramPathClassLoader, "pathList");
    paramPathClassLoader = localField.get(paramPathClassLoader);
    Constructor localConstructor = h.a(paramPathClassLoader, new Class[] { ClassLoader.class, String.class, String.class, File.class });
    Object localObject2 = (Object[])h.a(paramPathClassLoader, "dexElements").get(paramPathClassLoader);
    Object localObject1 = (List)h.a(paramPathClassLoader, "nativeLibraryDirectories").get(paramPathClassLoader);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3 = h.a(localObject2.getClass().getComponentType(), "dexFile");
    int i = 1;
    int m = localObject2.length;
    int j = 0;
    if (j < m)
    {
      DexFile localDexFile = (DexFile)((Field)localObject3).get(localObject2[j]);
      int k = i;
      if (localDexFile != null)
      {
        if (i == 0) {
          break label179;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localDexFile.getName());
        k = i;
        j += 1;
        i = k;
        break;
        label179:
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
    h.a(paramPathClassLoader, "definingContext").set(paramPathClassLoader, localAndroidNClassLoader);
    akr = paramPathClassLoader;
    paramPathClassLoader = (Context)h.a(paramApplication, "mBase").get(paramApplication);
    paramPathClassLoader = h.a(paramPathClassLoader, "mPackageInfo").get(paramPathClassLoader);
    h.a(paramPathClassLoader, "mClassLoader").set(paramPathClassLoader, localAndroidNClassLoader);
    if (Build.VERSION.SDK_INT < 27)
    {
      paramPathClassLoader = paramApplication.getResources();
      h.a(paramPathClassLoader, "mClassLoader").set(paramPathClassLoader, localAndroidNClassLoader);
      paramPathClassLoader = h.a(paramPathClassLoader, "mDrawableInflater").get(paramPathClassLoader);
      if (paramPathClassLoader != null) {
        h.a(paramPathClassLoader, "mClassLoader").set(paramPathClassLoader, localAndroidNClassLoader);
      }
    }
    Thread.currentThread().setContextClassLoader(localAndroidNClassLoader);
    return localAndroidNClassLoader;
  }
  
  public Class<?> findClass(String paramString)
  {
    if (((paramString != null) && (paramString.startsWith("com.tencent.tinker.loader.")) && (!paramString.equals("com.tencent.tinker.loader.TinkerTestDexLoad"))) || ((this.akt != null) && (this.akt.equals(paramString)))) {
      return this.aks.loadClass(paramString);
    }
    return super.findClass(paramString);
  }
  
  public String findLibrary(String paramString)
  {
    return super.findLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.AndroidNClassLoader
 * JD-Core Version:    0.7.0.1
 */