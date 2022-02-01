package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.DelegateLastClassLoader;
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
  
  private static ClassLoader createNewClassLoader(ClassLoader paramClassLoader, File paramFile, boolean paramBoolean1, boolean paramBoolean2, String... paramVarArgs)
  {
    Object localObject1 = findField(Class.forName("dalvik.system.BaseDexClassLoader", false, paramClassLoader), "pathList").get(paramClassLoader);
    Object localObject2 = new StringBuilder();
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = 0;
      while (i < paramVarArgs.length)
      {
        if (i > 0) {
          ((StringBuilder)localObject2).append(File.pathSeparator);
        }
        ((StringBuilder)localObject2).append(paramVarArgs[i]);
        i += 1;
      }
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    paramVarArgs = findField(localObject1.getClass(), "nativeLibraryDirectories");
    StringBuilder localStringBuilder;
    label166:
    File localFile;
    if (paramVarArgs.getType().isArray())
    {
      paramVarArgs = Arrays.asList((File[])paramVarArgs.get(localObject1));
      localStringBuilder = new StringBuilder();
      paramVarArgs = paramVarArgs.iterator();
      i = 1;
      do
      {
        if (!paramVarArgs.hasNext()) {
          break;
        }
        localFile = (File)paramVarArgs.next();
      } while (localFile == null);
      if (i == 0) {
        break label230;
      }
      i = 0;
    }
    for (;;)
    {
      localStringBuilder.append(localFile.getAbsolutePath());
      break label166;
      paramVarArgs = (List)paramVarArgs.get(localObject1);
      break;
      label230:
      localStringBuilder.append(File.pathSeparator);
    }
    paramVarArgs = localStringBuilder.toString();
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 27))
    {
      paramFile = new DelegateLastClassLoader((String)localObject2, paramVarArgs, ClassLoader.getSystemClassLoader());
      paramVarArgs = ClassLoader.class.getDeclaredField("parent");
      paramVarArgs.setAccessible(true);
      paramVarArgs.set(paramFile, paramClassLoader);
    }
    for (paramClassLoader = paramFile;; paramClassLoader = new TinkerClassLoader((String)localObject2, paramFile, paramVarArgs, paramClassLoader))
    {
      if ((paramBoolean2) && (Build.VERSION.SDK_INT < 26)) {
        findField(localObject1.getClass(), "definingContext").set(localObject1, paramClassLoader);
      }
      return paramClassLoader;
    }
  }
  
  private static void doInject(Application paramApplication, ClassLoader paramClassLoader)
  {
    Thread.currentThread().setContextClassLoader(paramClassLoader);
    Object localObject1 = (Context)findField(paramApplication.getClass(), "mBase").get(paramApplication);
    try
    {
      findField(localObject1.getClass(), "mClassLoader").set(localObject1, paramClassLoader);
      label38:
      localObject1 = findField(localObject1.getClass(), "mPackageInfo").get(localObject1);
      findField(localObject1.getClass(), "mClassLoader").set(localObject1, paramClassLoader);
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
      }
      finally {}
    }
    finally
    {
      break label38;
    }
  }
  
  private static Field findField(Class<?> paramClass, String paramString)
  {
    Object localObject1 = paramClass;
    for (;;)
    {
      try
      {
        Field localField = ((Class)localObject1).getDeclaredField(paramString);
        localField.setAccessible(true);
        return localField;
      }
      finally
      {
        if (localObject1 == Object.class) {
          throw new NoSuchFieldException("Cannot find field " + paramString + " in class " + paramClass.getName() + " and its super classes.");
        }
        localObject1 = ((Class)localObject1).getSuperclass();
      }
    }
  }
  
  public static ClassLoader inject(Application paramApplication, ClassLoader paramClassLoader, File paramFile, boolean paramBoolean, List<File> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((File)paramList.get(i)).getAbsolutePath();
      i += 1;
    }
    paramClassLoader = createNewClassLoader(paramClassLoader, paramFile, paramBoolean, true, arrayOfString);
    doInject(paramApplication, paramClassLoader);
    return paramClassLoader;
  }
  
  public static ClassLoader triggerDex2Oat(Context paramContext, File paramFile, boolean paramBoolean, String... paramVarArgs)
  {
    return createNewClassLoader(paramContext.getClassLoader(), paramFile, paramBoolean, false, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.NewClassLoaderInjector
 * JD-Core Version:    0.7.0.1
 */