package com.tencent.mm.plugin.normsg.b;

import android.util.LruCache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class h
{
  private static final LruCache<String, LruCache<String, Field>> mIg = new LruCache(50);
  private static final LruCache<String, LruCache<String, Method>> mIh = new LruCache(50);
  private static final LruCache<String, LruCache<String, Constructor<?>>> mIi = new LruCache(50);
  
  private static <T> T a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = b(paramClass, paramString).get(null);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      throw new h.a(paramClass);
    }
  }
  
  public static <T> T a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    return b(findClass(paramString1), paramString2, paramArrayOfClass, paramVarArgs);
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    LruCache localLruCache = (LruCache)mIh.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      mIh.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Object localObject = new StringBuilder().append(paramString).append("#");
      if (paramVarArgs != null) {}
      for (String str = Arrays.toString(paramVarArgs);; str = "[]")
      {
        str = str;
        localObject = (Method)localLruCache.get(str);
        if (localObject == null) {
          break;
        }
        return localObject;
      }
      do
      {
        paramClass = paramClass.getSuperclass();
        try
        {
          localObject = paramClass.getDeclaredMethod(paramString, paramVarArgs);
          if (!((Method)localObject).isAccessible()) {
            ((Method)localObject).setAccessible(true);
          }
          localLruCache.put(str, localObject);
          return localObject;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      throw localThrowable;
    }
  }
  
  public static <T> T b(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = a(paramClass, paramString, paramArrayOfClass).invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      throw new h.a(paramClass);
    }
  }
  
  public static <T> T b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = a(localClass, paramString, paramArrayOfClass).invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw new h.a(paramObject);
    }
  }
  
  private static Field b(Class<?> paramClass, String paramString)
  {
    LruCache localLruCache = (LruCache)mIg.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      mIg.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Field localField = (Field)localLruCache.get(paramString);
      if (localField != null) {
        return localField;
      }
      do
      {
        paramClass = paramClass.getSuperclass();
        try
        {
          localField = paramClass.getDeclaredField(paramString);
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          localLruCache.put(paramString, localField);
          return localField;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      throw localThrowable;
    }
  }
  
  public static <T> void b(Object paramObject, String paramString, T paramT)
  {
    Class localClass = paramObject.getClass();
    try
    {
      b(localClass, paramString).set(paramObject, paramT);
      return;
    }
    catch (Throwable paramObject)
    {
      throw new h.a(paramObject);
    }
  }
  
  public static Class<?>[] b(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  public static <T> T el(String paramString1, String paramString2)
  {
    return a(findClass(paramString1), paramString2);
  }
  
  public static <T> T f(Object paramObject, String paramString)
  {
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = b(localClass, paramString).get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw new h.a(paramObject);
    }
  }
  
  public static Class<?> findClass(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw new h.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.h
 * JD-Core Version:    0.7.0.1
 */