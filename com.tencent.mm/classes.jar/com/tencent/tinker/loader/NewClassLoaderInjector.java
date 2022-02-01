package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class NewClassLoaderInjector
{
  private NewClassLoaderInjector()
  {
    throw new UnsupportedOperationException();
  }
  
  private static ClassLoader createNewClassLoader(Context paramContext, ClassLoader paramClassLoader, File paramFile, String... paramVarArgs)
  {
    int j = 1;
    Object localObject = findField(Class.forName("dalvik.system.BaseDexClassLoader", false, paramClassLoader), "pathList").get(paramClassLoader);
    paramContext = new StringBuilder();
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = 0;
      while (i < paramVarArgs.length)
      {
        if (i > 0) {
          paramContext.append(File.pathSeparator);
        }
        paramContext.append(paramVarArgs[i]);
        i += 1;
      }
    }
    paramVarArgs = paramContext.toString();
    paramContext = findField(localObject.getClass(), "nativeLibraryDirectories");
    StringBuilder localStringBuilder;
    label155:
    File localFile;
    if (paramContext.getType().isArray())
    {
      paramContext = Arrays.asList((File[])paramContext.get(localObject));
      localStringBuilder = new StringBuilder();
      paramContext = paramContext.iterator();
      i = j;
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        localFile = (File)paramContext.next();
      } while (localFile == null);
      if (i == 0) {
        break label215;
      }
      i = 0;
    }
    for (;;)
    {
      localStringBuilder.append(localFile.getAbsolutePath());
      break label155;
      paramContext = (List)paramContext.get(localObject);
      break;
      label215:
      localStringBuilder.append(File.pathSeparator);
    }
    paramContext = new TinkerClassLoader(paramVarArgs, paramFile, localStringBuilder.toString(), paramClassLoader);
    findField(localObject.getClass(), "definingContext").set(localObject, paramContext);
    return paramContext;
  }
  
  private static void doInject(Application paramApplication, ClassLoader paramClassLoader)
  {
    Thread.currentThread().setContextClassLoader(paramClassLoader);
    Object localObject = (Context)findField(paramApplication.getClass(), "mBase").get(paramApplication);
    localObject = findField(localObject.getClass(), "mPackageInfo").get(localObject);
    findField(localObject.getClass(), "mClassLoader").set(localObject, paramClassLoader);
    if (Build.VERSION.SDK_INT < 27) {
      paramApplication = paramApplication.getResources();
    }
    try
    {
      findField(paramApplication.getClass(), "mClassLoader").set(paramApplication, paramClassLoader);
      paramApplication = findField(paramApplication.getClass(), "mDrawableInflater").get(paramApplication);
      if (paramApplication != null) {
        findField(paramApplication.getClass(), "mClassLoader").set(paramApplication, paramClassLoader);
      }
      return;
    }
    catch (Throwable paramApplication) {}
  }
  
  private static Field findField(Class<?> paramClass, String paramString)
  {
    Object localObject = paramClass;
    for (;;)
    {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        localField.setAccessible(true);
        return localField;
      }
      catch (Throwable localThrowable)
      {
        if (localObject == Object.class) {
          throw new NoSuchFieldException("Cannot find field " + paramString + " in class " + paramClass.getName() + " and its super classes.");
        }
        localObject = ((Class)localObject).getSuperclass();
      }
    }
  }
  
  public static ClassLoader inject(Application paramApplication, ClassLoader paramClassLoader, File paramFile, List<File> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((File)paramList.get(i)).getAbsolutePath();
      i += 1;
    }
    paramClassLoader = createNewClassLoader(paramApplication, paramClassLoader, paramFile, arrayOfString);
    doInject(paramApplication, paramClassLoader);
    return paramClassLoader;
  }
  
  public static void triggerDex2Oat(Context paramContext, File paramFile, String... paramVarArgs)
  {
    paramContext = new StringBuilder();
    int j = 1;
    int k = paramVarArgs.length;
    int i = 0;
    if (i < k)
    {
      paramFile = paramVarArgs[i];
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        paramContext.append(paramFile);
        i += 1;
        break;
        paramContext.append(File.pathSeparator);
      }
    }
    new PathClassLoader(paramContext.toString(), ClassLoader.getSystemClassLoader());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.NewClassLoaderInjector
 * JD-Core Version:    0.7.0.1
 */