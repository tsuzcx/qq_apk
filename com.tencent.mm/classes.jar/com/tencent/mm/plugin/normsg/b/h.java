package com.tencent.mm.plugin.normsg.b;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class h
{
  private static final LruCache<String, LruCache<String, Field>> pim;
  private static final LruCache<String, LruCache<String, Method>> pio;
  private static final LruCache<String, LruCache<String, Constructor<?>>> pip;
  
  static
  {
    AppMethodBeat.i(10452);
    pim = new LruCache(50);
    pio = new LruCache(50);
    pip = new LruCache(50);
    AppMethodBeat.o(10452);
  }
  
  public static <T> T a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(10448);
    paramString1 = b(findClass(paramString1), paramString2, paramArrayOfClass, paramVarArgs);
    AppMethodBeat.o(10448);
    return paramString1;
  }
  
  public static <T> T b(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(10449);
    try
    {
      paramClass = b(paramClass, paramString, paramArrayOfClass).invoke(null, paramVarArgs);
      AppMethodBeat.o(10449);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new h.a(paramClass);
      AppMethodBeat.o(10449);
      throw paramClass;
    }
  }
  
  public static <T> T b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(10447);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = b(localClass, paramString, paramArrayOfClass).invoke(paramObject, paramVarArgs);
      AppMethodBeat.o(10447);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject = new h.a(paramObject);
      AppMethodBeat.o(10447);
      throw paramObject;
    }
  }
  
  private static Method b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(10451);
    LruCache localLruCache = (LruCache)pio.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      pio.put(paramClass.getName(), localLruCache);
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
        AppMethodBeat.o(10451);
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
          AppMethodBeat.o(10451);
          return localObject;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(10451);
      throw localThrowable;
    }
  }
  
  public static <T> void b(Object paramObject, String paramString, T paramT)
  {
    AppMethodBeat.i(10446);
    Class localClass = paramObject.getClass();
    try
    {
      e(localClass, paramString).set(paramObject, paramT);
      AppMethodBeat.o(10446);
      return;
    }
    catch (Throwable paramObject)
    {
      paramObject = new h.a(paramObject);
      AppMethodBeat.o(10446);
      throw paramObject;
    }
  }
  
  public static Class<?>[] b(Class<?>... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  private static <T> T d(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(10445);
    try
    {
      paramClass = e(paramClass, paramString).get(null);
      AppMethodBeat.o(10445);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new h.a(paramClass);
      AppMethodBeat.o(10445);
      throw paramClass;
    }
  }
  
  private static Field e(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(10450);
    LruCache localLruCache = (LruCache)pim.get(paramClass.getName());
    if (localLruCache == null)
    {
      localLruCache = new LruCache(30);
      pim.put(paramClass.getName(), localLruCache);
    }
    for (;;)
    {
      Field localField = (Field)localLruCache.get(paramString);
      if (localField != null)
      {
        AppMethodBeat.o(10450);
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
          AppMethodBeat.o(10450);
          return localField;
        }
        catch (Throwable localThrowable) {}
      } while ((paramClass.getSuperclass() != null) && (paramClass != Object.class));
      AppMethodBeat.o(10450);
      throw localThrowable;
    }
  }
  
  public static <T> T fG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10444);
    paramString1 = d(findClass(paramString1), paramString2);
    AppMethodBeat.o(10444);
    return paramString1;
  }
  
  public static Class<?> findClass(String paramString)
  {
    AppMethodBeat.i(10442);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(10442);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString = new h.a(paramString);
      AppMethodBeat.o(10442);
      throw paramString;
    }
  }
  
  public static <T> T g(Object paramObject, String paramString)
  {
    AppMethodBeat.i(10443);
    Class localClass = paramObject.getClass();
    try
    {
      paramObject = e(localClass, paramString).get(paramObject);
      AppMethodBeat.o(10443);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject = new h.a(paramObject);
      AppMethodBeat.o(10443);
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.h
 * JD-Core Version:    0.7.0.1
 */