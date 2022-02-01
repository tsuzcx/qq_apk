package com.tencent.mm.plugin.normsg.d;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class i
{
  private static final LruCache<String, LruCache<String, Field>> GzA;
  private static final LruCache<String, LruCache<String, Method>> GzB;
  private static final LruCache<String, LruCache<String, Constructor<?>>> GzC;
  
  static
  {
    AppMethodBeat.i(149105);
    GzA = new LruCache(50);
    GzB = new LruCache(50);
    GzC = new LruCache(50);
    AppMethodBeat.o(149105);
  }
  
  public static <T> T a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(149101);
    paramString1 = b(findClass(paramString1), paramString2, paramArrayOfClass, paramVarArgs);
    AppMethodBeat.o(149101);
    return paramString1;
  }
  
  public static <T> T b(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(149102);
    try
    {
      paramClass = d(paramClass, paramString, paramArrayOfClass).invoke(null, paramVarArgs);
      AppMethodBeat.o(149102);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new a(paramClass);
      AppMethodBeat.o(149102);
      throw paramClass;
    }
  }
  
  public static <T> T b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(149100);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = d(localClass, paramString, paramArrayOfClass).invoke(paramObject, paramVarArgs);
      AppMethodBeat.o(149100);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149100);
      throw paramObject;
    }
  }
  
  public static <T> void c(Object paramObject, String paramString, T paramT)
  {
    AppMethodBeat.i(149099);
    Class localClass = paramObject.getClass();
    try
    {
      i(localClass, paramString).set(paramObject, paramT);
      AppMethodBeat.o(149099);
      return;
    }
    catch (Throwable paramObject)
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149099);
      throw paramObject;
    }
  }
  
  public static Class<?>[] c(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  private static Method d(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(149104);
    LruCache localLruCache = (LruCache)GzB.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      GzB.put(paramClass.getName(), localLruCache);
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
        AppMethodBeat.o(149104);
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
          AppMethodBeat.o(149104);
          return localObject;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(149104);
      throw localThrowable;
    }
  }
  
  public static Class<?> findClass(String paramString)
  {
    AppMethodBeat.i(149095);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(149095);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new a(paramString);
      AppMethodBeat.o(149095);
      throw paramString;
    }
  }
  
  public static <T> T g(Object paramObject, String paramString)
  {
    AppMethodBeat.i(149096);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = i(localClass, paramString).get(paramObject);
      AppMethodBeat.o(149096);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject = new a(paramObject);
      AppMethodBeat.o(149096);
      throw paramObject;
    }
  }
  
  private static <T> T h(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(149098);
    try
    {
      paramClass = i(paramClass, paramString).get(null);
      AppMethodBeat.o(149098);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new a(paramClass);
      AppMethodBeat.o(149098);
      throw paramClass;
    }
  }
  
  private static Field i(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(149103);
    LruCache localLruCache = (LruCache)GzA.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      GzA.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Field localField = (Field)localLruCache.get(paramString);
      if (localField != null)
      {
        AppMethodBeat.o(149103);
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
          AppMethodBeat.o(149103);
          return localField;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(149103);
      throw localThrowable;
    }
  }
  
  public static <T> T js(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149097);
    paramString1 = h(findClass(paramString1), paramString2);
    AppMethodBeat.o(149097);
    return paramString1;
  }
  
  public static final class a
    extends RuntimeException
  {
    a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.i
 * JD-Core Version:    0.7.0.1
 */