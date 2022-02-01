package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ShareReflectUtil
{
  public static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    paramString = findField(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, 0, paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, paramArrayOfObject.length, arrayOfObject1.length);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  public static Constructor<?> findConstructor(Object paramObject, Class<?>... paramVarArgs)
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Constructor localConstructor = localClass.getDeclaredConstructor(paramVarArgs);
        if (!localConstructor.isAccessible()) {
          localConstructor.setAccessible(true);
        }
        return localConstructor;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchMethodException("Constructor with parameters " + Arrays.asList(paramVarArgs) + " not found in " + paramObject.getClass());
  }
  
  public static Field findField(Class<?> paramClass, String paramString)
  {
    Object localObject = paramClass;
    while (localObject != null) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    throw new NoSuchFieldException("Field " + paramString + " not found in " + paramClass);
  }
  
  public static Field findField(Object paramObject, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Field localField = localClass.getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchFieldException("Field " + paramString + " not found in " + paramObject.getClass());
  }
  
  public static Method findMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    while (paramClass != null) {
      try
      {
        Method localMethod = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramClass = paramClass.getSuperclass();
      }
    }
    throw new NoSuchMethodException("Method " + paramString + " with parameters " + Arrays.asList(paramVarArgs) + " not found in " + paramClass);
  }
  
  public static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Method localMethod = localClass.getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchMethodException("Method " + paramString + " with parameters " + Arrays.asList(paramVarArgs) + " not found in " + paramObject.getClass());
  }
  
  public static Object getActivityThread(Context paramContext, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass == null) {}
    try
    {
      localObject = Class.forName("android.app.ActivityThread");
      paramClass = ((Class)localObject).getMethod("currentActivityThread", new Class[0]);
      paramClass.setAccessible(true);
      localObject = paramClass.invoke(null, new Object[0]);
      paramClass = (Class<?>)localObject;
      if (localObject == null)
      {
        paramClass = (Class<?>)localObject;
        if (paramContext != null)
        {
          paramClass = paramContext.getClass().getField("mLoadedApk");
          paramClass.setAccessible(true);
          paramContext = paramClass.get(paramContext);
          paramClass = paramContext.getClass().getDeclaredField("mActivityThread");
          paramClass.setAccessible(true);
          paramClass = paramClass.get(paramContext);
        }
      }
      return paramClass;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getValueOfStaticIntField(Class<?> paramClass, String paramString, int paramInt)
  {
    try
    {
      int i = findField(paramClass, paramString).getInt(null);
      return i;
    }
    catch (Throwable paramClass) {}
    return paramInt;
  }
  
  public static void reduceFieldArray(Object paramObject, String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    Object[] arrayOfObject1;
    int i;
    do
    {
      return;
      paramString = findField(paramObject, paramString);
      arrayOfObject1 = (Object[])paramString.get(paramObject);
      i = arrayOfObject1.length - paramInt;
    } while (i <= 0);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), i);
    System.arraycopy(arrayOfObject1, paramInt, arrayOfObject2, 0, i);
    paramString.set(paramObject, arrayOfObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareReflectUtil
 * JD-Core Version:    0.7.0.1
 */